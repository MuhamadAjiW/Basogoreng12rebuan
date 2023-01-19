import java.util.Random;
import java.util.Scanner;

public class Card {
    static Scanner in = new Scanner(System.in);
    float[] Val = new float[4];
    float[][] Cbm;

    public void readCards(){
        String line;
        String[] vals = new String[5];
        Boolean valid = false;
        while (!valid){
            System.out.println("Masukkan 4 kombinasi kartu: ");
            line = in.nextLine();
            vals = line.split(" ");
            try{
                if (vals.length > 4){
                    throw new Exception("Input terlalu banyak");
                }
                for(int i = 0; i < 4; i++){
                    switch(vals[i]){
                        case "A":
                            Val[i] = 1;
                            break;
                        case "J":
                            Val[i] = 11;
                            break;
                        case "Q":
                            Val[i] = 12;
                            break;
                        case "K":
                            Val[i] = 13;
                            break;
                        default:
                            Val[i] = Integer.parseInt(vals[i]);
                            if (Val[i] < 2 || Val[i] > 10){
                                throw new Exception("Ada kartu < 2 atau > 10 (Gunakan A, J, Q, K)");
                            }
                            break;
                    }
                }
                valid = true;
            } catch(Exception e){
                System.out.println("Input tidak valid!");
                System.out.println(e+"\n");
            }
        }   
    }

    public void randomCards(){
        Random randomNum = new Random();
        System.out.println("Kartu yang didapat: ");
        int temp;
        for(int i = 0; i < 4; i++){
            temp = randomNum.nextInt(13) + 1;
            Val[i] =((float)temp);
            switch(temp){
                case 1:
                System.out.print("A ");
                break;
                case 11:
                System.out.print("J ");
                break;
                case 12:
                System.out.print("Q ");
                break;
                case 13:
                System.out.print("K ");
                break;
                default:
                System.out.print(String.format("%d ", temp));
                break;
            }
        }
        System.out.print("\n");
    }

    public void generateCbm(){
        if (Val[0] == Val[1] && Val[0] == Val[2] && Val[0] == Val[3]){
            Cbm = new float[1][4];
            Cbm[0][0] = Val[0]; Cbm[0][1] = Val[0]; Cbm[0][2] = Val[0]; Cbm[0][3] = Val[0];
        }
        else if (Val[0] == Val[1] && Val[0] == Val[2]){
            Cbm = new float[4][4];
            Cbm[0][0] = Val[0]; Cbm[0][1] = Val[0]; Cbm[0][2] = Val[0]; Cbm[0][3] = Val[3];
            Cbm[1][0] = Val[0]; Cbm[1][1] = Val[0]; Cbm[1][2] = Val[3]; Cbm[1][3] = Val[0];
            Cbm[2][0] = Val[0]; Cbm[2][1] = Val[3]; Cbm[2][2] = Val[0]; Cbm[2][3] = Val[0];
            Cbm[3][0] = Val[3]; Cbm[3][1] = Val[0]; Cbm[3][2] = Val[0]; Cbm[3][3] = Val[0];
        }
        else if (Val[0] == Val[1] && Val[0] == Val[3]){
            Cbm = new float[4][4];
            Cbm[0][0] = Val[0]; Cbm[0][1] = Val[0]; Cbm[0][2] = Val[2]; Cbm[0][3] = Val[0];
            Cbm[1][0] = Val[0]; Cbm[1][1] = Val[2]; Cbm[1][2] = Val[0]; Cbm[1][3] = Val[0];
            Cbm[2][0] = Val[2]; Cbm[2][1] = Val[0]; Cbm[2][2] = Val[0]; Cbm[2][3] = Val[0];
            Cbm[3][0] = Val[0]; Cbm[3][1] = Val[0]; Cbm[3][2] = Val[0]; Cbm[3][3] = Val[2];
        }
        else if (Val[0] == Val[2] && Val[0] == Val[3]){
            Cbm = new float[4][4];
            Cbm[0][0] = Val[0]; Cbm[0][1] = Val[1]; Cbm[0][2] = Val[0]; Cbm[0][3] = Val[0];
            Cbm[1][0] = Val[1]; Cbm[1][1] = Val[0]; Cbm[1][2] = Val[0]; Cbm[1][3] = Val[0];
            Cbm[2][0] = Val[0]; Cbm[2][1] = Val[0]; Cbm[2][2] = Val[0]; Cbm[2][3] = Val[1];
            Cbm[3][0] = Val[0]; Cbm[3][1] = Val[0]; Cbm[3][2] = Val[1]; Cbm[3][3] = Val[0];
        }
        else if (Val[1] == Val[2] && Val[1] == Val[3]){
            Cbm = new float[4][4];
            Cbm[0][0] = Val[0]; Cbm[0][1] = Val[1]; Cbm[0][2] = Val[2]; Cbm[0][3] = Val[3];
            Cbm[1][0] = Val[1]; Cbm[1][1] = Val[2]; Cbm[1][2] = Val[3]; Cbm[1][3] = Val[0];
            Cbm[2][0] = Val[2]; Cbm[2][1] = Val[3]; Cbm[2][2] = Val[0]; Cbm[2][3] = Val[1];
            Cbm[3][0] = Val[3]; Cbm[3][1] = Val[0]; Cbm[3][2] = Val[1]; Cbm[3][3] = Val[2];
        }
        else if (Val[0] == Val[1]){
            Cbm = new float[12][4];
            Cbm[0][0] = Val[0]; Cbm[0][1] = Val[0]; Cbm[0][2] = Val[2]; Cbm[0][3] = Val[3];
            Cbm[1][0] = Val[0]; Cbm[1][1] = Val[0]; Cbm[1][2] = Val[3]; Cbm[1][3] = Val[2];

            Cbm[2][0] = Val[0]; Cbm[2][1] = Val[2]; Cbm[2][2] = Val[3]; Cbm[2][3] = Val[0];
            Cbm[3][0] = Val[0]; Cbm[3][1] = Val[3]; Cbm[3][2] = Val[2]; Cbm[3][3] = Val[0];

            Cbm[4][0] = Val[2]; Cbm[4][1] = Val[3]; Cbm[4][2] = Val[0]; Cbm[4][3] = Val[0];
            Cbm[5][0] = Val[3]; Cbm[5][1] = Val[2]; Cbm[5][2] = Val[0]; Cbm[5][3] = Val[0];

            Cbm[6][0] = Val[0]; Cbm[6][1] = Val[2]; Cbm[6][2] = Val[0]; Cbm[6][3] = Val[3];
            Cbm[7][0] = Val[0]; Cbm[7][1] = Val[3]; Cbm[7][2] = Val[0]; Cbm[7][3] = Val[2];

            Cbm[8][0] = Val[2]; Cbm[8][1] = Val[0]; Cbm[8][2] = Val[0]; Cbm[8][3] = Val[3];
            Cbm[9][0] = Val[3]; Cbm[9][1] = Val[0]; Cbm[9][2] = Val[0]; Cbm[9][3] = Val[2];
            
            Cbm[10][0] = Val[2]; Cbm[10][1] = Val[0]; Cbm[10][2] = Val[3]; Cbm[10][3] = Val[0];
            Cbm[11][0] = Val[3]; Cbm[11][1] = Val[0]; Cbm[11][2] = Val[2]; Cbm[11][3] = Val[0];
        }
        else if (Val[0] == Val[2]){
            Cbm = new float[12][4];
            Cbm[0][0] = Val[0]; Cbm[0][1] = Val[0]; Cbm[0][2] = Val[1]; Cbm[0][3] = Val[3];
            Cbm[1][0] = Val[0]; Cbm[1][1] = Val[0]; Cbm[1][2] = Val[3]; Cbm[1][3] = Val[1];

            Cbm[2][0] = Val[0]; Cbm[2][1] = Val[1]; Cbm[2][2] = Val[3]; Cbm[2][3] = Val[0];
            Cbm[3][0] = Val[0]; Cbm[3][1] = Val[3]; Cbm[3][2] = Val[1]; Cbm[3][3] = Val[0];

            Cbm[4][0] = Val[1]; Cbm[4][1] = Val[3]; Cbm[4][2] = Val[0]; Cbm[4][3] = Val[0];
            Cbm[5][0] = Val[3]; Cbm[5][1] = Val[1]; Cbm[5][2] = Val[0]; Cbm[5][3] = Val[0];

            Cbm[6][0] = Val[0]; Cbm[6][1] = Val[1]; Cbm[6][2] = Val[0]; Cbm[6][3] = Val[3];
            Cbm[7][0] = Val[0]; Cbm[7][1] = Val[3]; Cbm[7][2] = Val[0]; Cbm[7][3] = Val[1];

            Cbm[8][0] = Val[1]; Cbm[8][1] = Val[0]; Cbm[8][2] = Val[0]; Cbm[8][3] = Val[3];
            Cbm[9][0] = Val[3]; Cbm[9][1] = Val[0]; Cbm[9][2] = Val[0]; Cbm[9][3] = Val[1];

            Cbm[10][0] = Val[1]; Cbm[10][1] = Val[0]; Cbm[10][2] = Val[3]; Cbm[10][3] = Val[0];
            Cbm[11][0] = Val[3]; Cbm[11][1] = Val[0]; Cbm[11][2] = Val[1]; Cbm[11][3] = Val[0];

        }
        else if (Val[0] == Val[3]){
            Cbm = new float[12][4];
            Cbm[0][0] = Val[0]; Cbm[0][1] = Val[0]; Cbm[0][2] = Val[1]; Cbm[0][3] = Val[2];
            Cbm[1][0] = Val[0]; Cbm[1][1] = Val[0]; Cbm[1][2] = Val[2]; Cbm[1][3] = Val[1];

            Cbm[2][0] = Val[0]; Cbm[2][1] = Val[1]; Cbm[2][2] = Val[2]; Cbm[2][3] = Val[0];
            Cbm[3][0] = Val[0]; Cbm[3][1] = Val[2]; Cbm[3][2] = Val[1]; Cbm[3][3] = Val[0];

            Cbm[4][0] = Val[1]; Cbm[4][1] = Val[2]; Cbm[4][2] = Val[0]; Cbm[4][3] = Val[0];
            Cbm[5][0] = Val[2]; Cbm[5][1] = Val[1]; Cbm[5][2] = Val[0]; Cbm[5][3] = Val[0];

            Cbm[6][0] = Val[0]; Cbm[6][1] = Val[1]; Cbm[6][2] = Val[0]; Cbm[6][3] = Val[2];
            Cbm[7][0] = Val[0]; Cbm[7][1] = Val[2]; Cbm[7][2] = Val[0]; Cbm[7][3] = Val[1];
            
            Cbm[8][0] = Val[1]; Cbm[8][1] = Val[0]; Cbm[8][2] = Val[0]; Cbm[8][3] = Val[2];
            Cbm[9][0] = Val[2]; Cbm[9][1] = Val[0]; Cbm[9][2] = Val[0]; Cbm[9][3] = Val[1];

            Cbm[10][0] = Val[1]; Cbm[10][1] = Val[0]; Cbm[10][2] = Val[2]; Cbm[10][3] = Val[0];
            Cbm[11][0] = Val[2]; Cbm[11][1] = Val[0]; Cbm[11][2] = Val[1]; Cbm[11][3] = Val[0];

        }
        else if (Val[1] == Val[2]){
            Cbm = new float[12][4];
            Cbm[0][0] = Val[1]; Cbm[0][1] = Val[1]; Cbm[0][2] = Val[0]; Cbm[0][3] = Val[3];
            Cbm[1][0] = Val[1]; Cbm[1][1] = Val[1]; Cbm[1][2] = Val[3]; Cbm[1][3] = Val[0];

            Cbm[2][0] = Val[1]; Cbm[2][1] = Val[0]; Cbm[2][2] = Val[3]; Cbm[2][3] = Val[1];
            Cbm[3][0] = Val[1]; Cbm[3][1] = Val[3]; Cbm[3][2] = Val[0]; Cbm[3][3] = Val[1];

            Cbm[4][0] = Val[0]; Cbm[4][1] = Val[3]; Cbm[4][2] = Val[1]; Cbm[4][3] = Val[1];
            Cbm[5][0] = Val[3]; Cbm[5][1] = Val[0]; Cbm[5][2] = Val[1]; Cbm[5][3] = Val[1];

            Cbm[6][0] = Val[1]; Cbm[6][1] = Val[0]; Cbm[6][2] = Val[1]; Cbm[6][3] = Val[3];
            Cbm[7][0] = Val[1]; Cbm[7][1] = Val[3]; Cbm[7][2] = Val[1]; Cbm[7][3] = Val[0];

            Cbm[8][0] = Val[0]; Cbm[8][1] = Val[1]; Cbm[8][2] = Val[1]; Cbm[8][3] = Val[3];
            Cbm[9][0] = Val[3]; Cbm[9][1] = Val[1]; Cbm[9][2] = Val[1]; Cbm[9][3] = Val[0];

            Cbm[10][0] = Val[0]; Cbm[10][1] = Val[1]; Cbm[10][2] = Val[3]; Cbm[10][3] = Val[1];
            Cbm[11][0] = Val[3]; Cbm[11][1] = Val[1]; Cbm[11][2] = Val[0]; Cbm[11][3] = Val[1];

        }
        else if (Val[1] == Val[3]){
            Cbm = new float[12][4];
            Cbm[0][0] = Val[1]; Cbm[0][1] = Val[1]; Cbm[0][2] = Val[0]; Cbm[0][3] = Val[2];
            Cbm[1][0] = Val[1]; Cbm[1][1] = Val[1]; Cbm[1][2] = Val[2]; Cbm[1][3] = Val[0];

            Cbm[2][0] = Val[1]; Cbm[2][1] = Val[0]; Cbm[2][2] = Val[2]; Cbm[2][3] = Val[1];
            Cbm[3][0] = Val[1]; Cbm[3][1] = Val[2]; Cbm[3][2] = Val[0]; Cbm[3][3] = Val[1];

            Cbm[4][0] = Val[0]; Cbm[4][1] = Val[2]; Cbm[4][2] = Val[1]; Cbm[4][3] = Val[1];
            Cbm[5][0] = Val[2]; Cbm[5][1] = Val[0]; Cbm[5][2] = Val[1]; Cbm[5][3] = Val[1];

            Cbm[6][0] = Val[1]; Cbm[6][1] = Val[0]; Cbm[6][2] = Val[1]; Cbm[6][3] = Val[2];
            Cbm[7][0] = Val[1]; Cbm[7][1] = Val[2]; Cbm[7][2] = Val[1]; Cbm[7][3] = Val[0];

            Cbm[8][0] = Val[0]; Cbm[8][1] = Val[1]; Cbm[8][2] = Val[1]; Cbm[8][3] = Val[2];
            Cbm[9][0] = Val[2]; Cbm[9][1] = Val[1]; Cbm[9][2] = Val[1]; Cbm[9][3] = Val[0];

            Cbm[10][0] = Val[0]; Cbm[10][1] = Val[1]; Cbm[10][2] = Val[2]; Cbm[10][3] = Val[1];
            Cbm[11][0] = Val[2]; Cbm[11][1] = Val[1]; Cbm[11][2] = Val[0]; Cbm[11][3] = Val[1];

        }
        else if (Val[2] == Val[3]){
            Cbm = new float[12][4];
            Cbm[0][0] = Val[2]; Cbm[0][1] = Val[2]; Cbm[0][2] = Val[0]; Cbm[0][3] = Val[1];
            Cbm[1][0] = Val[2]; Cbm[1][1] = Val[2]; Cbm[1][2] = Val[1]; Cbm[1][3] = Val[0];

            Cbm[2][0] = Val[2]; Cbm[2][1] = Val[0]; Cbm[2][2] = Val[1]; Cbm[2][3] = Val[2];
            Cbm[3][0] = Val[2]; Cbm[3][1] = Val[1]; Cbm[3][2] = Val[0]; Cbm[3][3] = Val[2];

            Cbm[4][0] = Val[0]; Cbm[4][1] = Val[1]; Cbm[4][2] = Val[2]; Cbm[4][3] = Val[2];
            Cbm[5][0] = Val[1]; Cbm[5][1] = Val[0]; Cbm[5][2] = Val[2]; Cbm[5][3] = Val[2];

            Cbm[6][0] = Val[2]; Cbm[6][1] = Val[0]; Cbm[6][2] = Val[2]; Cbm[6][3] = Val[1];
            Cbm[7][0] = Val[2]; Cbm[7][1] = Val[1]; Cbm[7][2] = Val[2]; Cbm[7][3] = Val[0];

            Cbm[8][0] = Val[0]; Cbm[8][1] = Val[2]; Cbm[8][2] = Val[2]; Cbm[8][3] = Val[1];
            Cbm[9][0] = Val[1]; Cbm[9][1] = Val[2]; Cbm[9][2] = Val[2]; Cbm[9][3] = Val[0];

            Cbm[10][0] = Val[0]; Cbm[10][1] = Val[2]; Cbm[10][2] = Val[1]; Cbm[10][3] = Val[2];
            Cbm[11][0] = Val[1]; Cbm[11][1] = Val[2]; Cbm[11][2] = Val[0]; Cbm[11][3] = Val[2];

        }
        else{
            Cbm = new float[24][4];
            Cbm[0][0] = Val[0]; Cbm[0][1] = Val[1]; Cbm[0][2] = Val[2]; Cbm[0][3] = Val[3];
            Cbm[1][0] = Val[0]; Cbm[1][1] = Val[1]; Cbm[1][2] = Val[3]; Cbm[1][3] = Val[2];
            Cbm[2][0] = Val[0]; Cbm[2][1] = Val[2]; Cbm[2][2] = Val[1]; Cbm[2][3] = Val[3];
            Cbm[3][0] = Val[0]; Cbm[3][1] = Val[2]; Cbm[3][2] = Val[3]; Cbm[3][3] = Val[1];
            Cbm[4][0] = Val[0]; Cbm[4][1] = Val[3]; Cbm[4][2] = Val[1]; Cbm[4][3] = Val[2];
            Cbm[5][0] = Val[0]; Cbm[5][1] = Val[3]; Cbm[5][2] = Val[2]; Cbm[5][3] = Val[1];

            Cbm[6][0] = Val[1]; Cbm[6][1] = Val[0]; Cbm[6][2] = Val[2]; Cbm[6][3] = Val[3];
            Cbm[7][0] = Val[1]; Cbm[7][1] = Val[0]; Cbm[7][2] = Val[3]; Cbm[7][3] = Val[2];
            Cbm[8][0] = Val[1]; Cbm[8][1] = Val[2]; Cbm[8][2] = Val[0]; Cbm[8][3] = Val[3];
            Cbm[9][0] = Val[1]; Cbm[9][1] = Val[2]; Cbm[9][2] = Val[3]; Cbm[9][3] = Val[0];
            Cbm[10][0] = Val[1]; Cbm[10][1] = Val[3]; Cbm[10][2] = Val[1]; Cbm[10][3] = Val[2];
            Cbm[11][0] = Val[1]; Cbm[11][1] = Val[3]; Cbm[11][2] = Val[2]; Cbm[11][3] = Val[1];

            Cbm[12][0] = Val[2]; Cbm[12][1] = Val[0]; Cbm[12][2] = Val[1]; Cbm[12][3] = Val[3];
            Cbm[13][0] = Val[2]; Cbm[13][1] = Val[0]; Cbm[13][2] = Val[3]; Cbm[13][3] = Val[1];
            Cbm[14][0] = Val[2]; Cbm[14][1] = Val[1]; Cbm[14][2] = Val[0]; Cbm[14][3] = Val[3];
            Cbm[15][0] = Val[2]; Cbm[15][1] = Val[1]; Cbm[15][2] = Val[3]; Cbm[15][3] = Val[0];
            Cbm[16][0] = Val[2]; Cbm[16][1] = Val[3]; Cbm[16][2] = Val[0]; Cbm[16][3] = Val[1];
            Cbm[17][0] = Val[2]; Cbm[17][1] = Val[3]; Cbm[17][2] = Val[1]; Cbm[17][3] = Val[0];

            Cbm[18][0] = Val[3]; Cbm[18][1] = Val[0]; Cbm[18][2] = Val[1]; Cbm[18][3] = Val[2];
            Cbm[19][0] = Val[3]; Cbm[19][1] = Val[0]; Cbm[19][2] = Val[2]; Cbm[19][3] = Val[1];
            Cbm[20][0] = Val[3]; Cbm[20][1] = Val[1]; Cbm[20][2] = Val[0]; Cbm[20][3] = Val[2];
            Cbm[21][0] = Val[3]; Cbm[21][1] = Val[1]; Cbm[21][2] = Val[2]; Cbm[21][3] = Val[0];
            Cbm[22][0] = Val[3]; Cbm[22][1] = Val[2]; Cbm[22][2] = Val[0]; Cbm[22][3] = Val[1];
            Cbm[23][0] = Val[3]; Cbm[23][1] = Val[2]; Cbm[23][2] = Val[1]; Cbm[23][3] = Val[0];
        }
    }

    public void printCbm(){
        for(int i = 0; i < 24; i++){
            System.out.println(Cbm[i][0] + " " + Cbm[i][1] + " " + Cbm[i][2] + " " + Cbm[i][3]);
        }
    }
}
