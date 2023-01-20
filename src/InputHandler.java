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
                System.out.println("Input terlalu banyak");
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
                System.out.println("Input terlalu banyak");
            }
        } while (!valid);
        return parsedInput;
    }

    String StringLine(){
        return in.nextLine();
    }
}
