import java.util.Scanner;

public class InputHandler{
    static Scanner in = new Scanner(System.in);
    String inputLine;
    String[] parsedInput;

    int Choice(int bottomLimit, int upperLimit){
        int retval = bottomLimit - 1;
        do{
            inputLine = in.nextLine();
            parsedInput = inputLine.split(" ");
            if(parsedInput.length == 1){
                try {
                    retval = Integer.parseInt(parsedInput[0]);
                } catch (NumberFormatException e) {
                    retval = bottomLimit-1;
                }
                if (retval < bottomLimit || retval > upperLimit) {
                    System.out.println("Input tidak valid");
                } 
            }
            else{
                retval = bottomLimit - 1;
                System.out.println("Jumlah input tidak valid");
            }
        } while (retval < bottomLimit || retval > upperLimit);
        return retval;
    }

    String[] SpacedWords(int wordnum){
        boolean valid = false;
        do{
            inputLine = in.nextLine();
            parsedInput = inputLine.split(" ");
            if(parsedInput.length == wordnum){
                valid = true;
            }
            else{
                System.out.println("Jumlah input tidak valid");
            }
        } while (!valid);
        return parsedInput;
    }

    String StringLine(){
        return in.nextLine();
    }


    float[] CardCombination(){
        boolean valid = false;
        String[] vals;
        float[] Val = new float[4];
        while (!valid){
            vals = SpacedWords(4);
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
                                throw new Exception("");
                            }
                            break;
                    }
                }
                valid = true;
            } catch (Exception e){
                System.out.println("Input tidak valid");
            }
        }
        return Val;
    }
}
