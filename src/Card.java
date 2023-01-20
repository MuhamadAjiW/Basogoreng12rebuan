import java.util.Random;
import java.util.Vector;

public class Card {
    InputHandler inputHandler = new InputHandler();
    float[] Val = new float[4];
    float[][] Cbm;

    public void readCards(){
        String[] vals = new String[4];
        Boolean valid = false;

        System.out.println("Masukkan 4 kombinasi kartu: ");
        while (!valid){
            vals = inputHandler.SpacedWords(4);
            try{
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

    boolean isMember(int[] arr, int check){
        boolean member = false;
        int i = 0;
        while (i < arr.length && !member){
            if(check == arr[i]){
                member = true;
            }
            else{
                i++;
            }
        }
        return member;
    }

    Vector<float[]> cmbVector = new Vector<float[]>(1);
    boolean noDuplicate(float[] array, int start, int current){
        boolean retval = true;
        for(int i = start; i < current; i++){
            if(array[i] == array[current]){
                retval = false;
            }
        }
        return retval;
    }
    void ValPermutation(int index){
        float temp;
        if (index == Val.length-1){
            float[] getter = Val.clone();
            cmbVector.add(getter);
        }
        else{
            for(int i = index; i < Val.length; i++){
                if (noDuplicate(Val, index, i)){
                    temp = Val[i];
                    Val[i] = Val[index];
                    Val[index] = temp;
                    
                    ValPermutation(index + 1);
                    
                    temp = Val[index];
                    Val[index] = Val[i];
                    Val[i] = temp;
                }
            }
        }
    }

    public void generateCbm(){
        ValPermutation(0);
        Cbm = new float[cmbVector.size()][4];
        for(int i = 0; i < cmbVector.size(); i++){
            Cbm[i] = cmbVector.get(i);
        }
    }
}
