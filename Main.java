import java.util.Scanner;

public class Main{
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args){

        boolean running = true;
        String filename;
        int control1;
        int control2;
        long startTime;
        long finishTime;

        while (running){
            try{
                control1 = 0;
                control2 = 0;
                startTime = 0;
                finishTime = 0;
                filename = "";
                Card combination = new Card();
                Op operation = new Op();

                while (control1 < 1 || control1 > 3){
                    System.out.println("24 Solver");
                    System.out.println("Pilih cara:");
                    System.out.println("1. Input manual");
                    System.out.println("2. Randomly generated");
                    System.out.println("3. Exit");
                    
                    control1 = in.nextInt();
                    control2 = 0;

                    switch(control1){
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

                    try{
                        while(control2 < 1 || control2 > 2){
                            System.out.println("Selesai");
                            System.out.println("Waktu eksekusi (milisekon): " + finishTime/1000000);
                            System.out.println("Pilih output:");
                            System.out.println("1. Terminal");
                            System.out.println("2. File");
                            control2 = in.nextInt();
                            switch(control2){
                                case 1:
                                operation.printResult();
                                break;
                                
                                case 2:    
                                System.out.println("Masukkan nama file: ");
                                filename = in.nextLine();
                                filename = in.nextLine();
                                operation.fileResult(filename);
                                break;

                                default:
                                System.out.println("Input Tidak Valid");
                                break;
                            }
                        }
                    } catch(Exception e){
                        System.out.println(e);
                    }

                    System.out.println("\n\n");
                }
            } catch(Exception e){
                System.out.println(e);
            }
        } System.out.println("Program Selesai");        
    }
}