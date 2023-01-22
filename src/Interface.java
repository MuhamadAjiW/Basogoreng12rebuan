public class Interface{
    public void run(){

        boolean running = true;
        String filename;
        int input;
        long startTime;
        long finishTime;

        while (running){
                input = 0;
                startTime = 0;
                finishTime = 0;
                filename = "";
                Card combination = new Card();
                Op operation = new Op();
                InputHandler inputHandler = new InputHandler();

                System.out.println("24 Solver");
                System.out.println("Pilih cara:");
                System.out.println("1. Input manual");
                System.out.println("2. Randomly generated");
                System.out.println("3. Exit");
                input = inputHandler.Choice(1, 3);

                switch(input){
                    case 1:
                    combination.readCards();
                    break;

                    case 2:
                    combination.randomCards();
                    break;

                    case 3:
                    running = false;
                    break;
                }
                
                if (running == true){
                    startTime = System.nanoTime();
                    combination.generateCbm();
                    operation.getmodels(combination.cbmVector);
                    finishTime = System.nanoTime() - startTime;
                        
                    System.out.println("Selesai");
                    System.out.println("Waktu eksekusi (milisekon): " + (double)finishTime /1000000);
                    System.out.println("Pilih output:");
                    System.out.println("1. Terminal");
                    System.out.println("2. File");
                    input = inputHandler.Choice(1, 2);

                    switch(input){
                        case 1:
                        operation.printResult();
                        break;
                                
                        case 2:    
                        System.out.println("Masukkan nama file: ");
                        filename = inputHandler.StringLine();
                        operation.fileResult(filename);
                        break;
                    }

                    System.out.println("\n\n");
                }
        }
        
        System.out.println("Program Selesai");        
    }
}
