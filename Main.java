import java.util.Scanner;

public class Main{
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args){

        boolean running = true;
        String filename;
        String inputLine;
        String[] parsedInput;
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

                while (input < 1 || input > 3){
                    System.out.println("24 Solver");
                    System.out.println("Pilih cara:");
                    System.out.println("1. Input manual");
                    System.out.println("2. Randomly generated");
                    System.out.println("3. Exit");
                        do{
                            inputLine = in.nextLine();
                            parsedInput = inputLine.split(" ");
                            try {
                                input = Integer.parseInt(parsedInput[0]);
                            } catch (NumberFormatException e) {
                                input = 0;
                            }
                            if (input <= 0 || input > 3) {
                                System.out.println("Input tidak valid");
                            } 
                        } while (input <= 0 || input > 3);

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

                            default:
                            System.out.println("Input Tidak Valid");
                            break;
                        }
                }
                
                if (running == true){
                    startTime = System.nanoTime();
                    combination.generateCbm();
                    operation.getmodels(combination.Cbm);
                    finishTime = System.nanoTime() - startTime;

                        
                        System.out.println("Selesai");
                        System.out.println("Waktu eksekusi (milisekon): " + (double)finishTime /1000000);
                        System.out.println("Pilih output:");
                        System.out.println("1. Terminal");
                        System.out.println("2. File");

                            do{
                                inputLine = in.nextLine();
                                parsedInput = inputLine.split(" ");
                                try {
                                    input = Integer.parseInt(parsedInput[0]);
                                } catch (NumberFormatException e) {
                                    input = 0;
                                }
                                if (input <= 0 || input > 2) {
                                    System.out.println("Input tidak valid");
                                } 
                            } while (input <= 0 || input > 2);


                            switch(input){
                                case 1:
                                operation.printResult();
                                break;
                                
                                case 2:    
                                System.out.println("Masukkan nama file: ");
                                filename = in.nextLine();
                                operation.fileResult(filename);
                                break;
                                
                                default:
                            System.out.println("Input Tidak Valid");
                            break;
                            }

                    System.out.println("\n\n");
                }
        }
        
        
        System.out.println("Program Selesai");        
    }
}