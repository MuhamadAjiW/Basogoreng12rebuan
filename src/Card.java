import java.util.Random;
import java.util.Vector;

public class Card {
    InputHandler inputHandler = new InputHandler();
    float[] Val = new float[4];
    Vector<float[]> cbmVector = new Vector<float[]>(1);
    float[][] Cbm;

    public void readCards(){
        String[] vals = new String[4];
        Boolean valid = false;

        System.out.println("Masukkan 4 kombinasi kartu: ");
        while (!valid){
            vals = inputHandler.SpacedWords(4);
            try{
                for(byte i = 0; i < 4; i++){
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
            } catch (Exception e){
                System.out.println("Input tidak valid!");
                System.out.println(e+"\n");
            }
        }
    }

    public void randomCards(){
        Random randomNum = new Random();
        System.out.println("Kartu yang didapat: ");
        int temp;
        for(byte i = 0; i < 4; i++){
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

    boolean noDuplicate(byte[] arr){
        boolean retval = true;
        byte i, j;
        i = 0;
        while(retval && i < arr.length){
            j = 0;
            while(retval && j < i){
                if(arr[j] == arr[i]){
                    retval = false;
                }
                else{
                    j++;
                }
            }
            i++;
        }
        return retval;
    }

    boolean sameContent(float[] arr1, float[] arr2){
        boolean retval = true;
        byte i = 0;
        if(arr1.length != arr2.length){
            retval = false;
        }
        while(retval && i < arr1.length){
            if(arr1[i] != arr2[i]){
                retval = false;
            }
            else{
                i++;
            }
        }
        return retval;
    }

    boolean VectorContains(float[] arr){
        boolean retval = false;
        byte i;
        i = 0;
        while(!retval && i < cbmVector.size()){
            if(sameContent(arr, cbmVector.get(i))){
                retval = true;
            }
            i++;
        }
        return retval;
    }

    void ValPermutation(int index){
        for(byte i = 0; i < 4; i++){
            for(byte j = 0; j < 4; j++){
                for(byte k = 0; k < 4; k++){
                    for (byte l = 0; l < 4; l++){
                        byte[]permutation = {i, j, k, l};
                        if(noDuplicate(permutation)){
                            float[] getter = {Val[permutation[0]], Val[permutation[1]], Val[permutation[2]], Val[permutation[3]]};
                            if(!VectorContains(getter)){
                                cbmVector.add(getter);
                            }
                        }
                    }
                }
            }
        }
    }

    public void generateCbm(){
        ValPermutation(0);
        Cbm = new float[cbmVector.size()][4];
        for(byte i = 0; i < cbmVector.size(); i++){
            Cbm[i] = cbmVector.get(i);
        }
    }
}
