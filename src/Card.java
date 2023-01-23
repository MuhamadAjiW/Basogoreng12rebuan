import java.util.Random;

public class Card {
    float[] Val = new float[4];

    public void readCards(float[] input){
        Val = input;
    }

    public void randomCards(){
        Random randomNum = new Random();
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
}
