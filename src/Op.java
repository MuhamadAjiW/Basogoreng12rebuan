import java.io.BufferedWriter;
import java.io.FileWriter;

public class Op {
    char[] Oper = {'+', '-', '*', '/'};
    String retval = "";

    static float eval2 (float a, char op, float b){
        if(op == '+'){
            return a + b;
        }
        else if(op == '-'){
            return a - b;
        }
        else if(op == '*'){
            return a * b;
        }
        else return a / b;
    }

    static float eval3 (float a, char op1, float b, char op2, float c){
        if((op2 == '*' || op2 == '/')){
            return eval2(a, op1, eval2(b, op2, c));
        }
        else return eval2(eval2(a, op1, b), op2, c);
    }
    
    public static float eval4 (float a, char op1, float b, char op2, float c, char op3, float d){
        if((op1 == '+' || op1 == '-') && (op2 == '+' || op2 == '-') && (op3 == '*' || op3 == '/')){
            return eval2(eval2(a, op1, b), op2, eval2(c, op3, d));
        }
        else if((op1 == '+' || op1 == '-') && (op2 == '*' || op2 == '/') && (op3 == '+' || op3 == '-')){
            return eval2(eval2(a, op1, eval2(b, op2, c)), op3, d);
        }
        else if((op1 == '+' || op1 == '-') && (op2 == '*' || op2 == '/') && (op3 == '*' || op3 == '/')){
            return eval2(a, op1, eval2(eval2(b, op2, c), op3, d));
        }
        else if((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-') && (op3 == '*' || op3 == '/')){
            return eval2(eval2(a, op1, b), op2, eval2(c, op3, d));
        }
        else return eval2(eval2(eval2(a, op1, b), op2, c), op3, d);
    }
    
    public void getmodels(float[][] Cbm){

        byte i, j, k, l;
            for(j = 0; j < 4; j++){
                for(k = 0; k < 4; k++){
                    for(l = 0; l < 4; l++){
                        for(i = 0; i < Cbm.length; i++){
                            if (eval4(Cbm[i][0], Oper[j], Cbm[i][1], Oper[k], Cbm[i][2], Oper[l], Cbm[i][3]) == 24){
                                retval += String.format("s%f %c %f %c %f %c %f", Cbm[i][0], Oper[j], Cbm[i][1], Oper[k], Cbm[i][2], Oper[l], Cbm[i][3]);
                            }
                            else if (eval3(eval2(Cbm[i][0], Oper[j], Cbm[i][1]), Oper[k], Cbm[i][2], Oper[l], Cbm[i][3]) == 24){
                                retval += String.format("s(%f %c %f) %c %f %c %f", Cbm[i][0], Oper[j], Cbm[i][1], Oper[k], Cbm[i][2], Oper[l], Cbm[i][3]);
                            }
                            else if (eval3(Cbm[i][0], Oper[j], eval2(Cbm[i][1], Oper[k], Cbm[i][2]), Oper[l], Cbm[i][3]) == 24){
                                retval += String.format("s%f %c (%f %c %f) %c %f", Cbm[i][0], Oper[j], Cbm[i][1], Oper[k], Cbm[i][2], Oper[l], Cbm[i][3]);
                            }
                            else if (eval3(Cbm[i][0], Oper[j], Cbm[i][1], Oper[k], eval2(Cbm[i][2], Oper[l], Cbm[i][3])) == 24){
                                retval += String.format("s%f %c %f %c (%f %c %f)", Cbm[i][0], Oper[j], Cbm[i][1], Oper[k], Cbm[i][2], Oper[l], Cbm[i][3]);
                            }
                            else if (eval2(eval2(Cbm[i][0], Oper[j], Cbm[i][1]), Oper[k], eval2(Cbm[i][2], Oper[l], Cbm[i][3])) == 24){
                                retval += String.format("s(%f %c %f) %c (%f %c %f)", Cbm[i][0], Oper[j], Cbm[i][1], Oper[k], Cbm[i][2], Oper[l], Cbm[i][3]);
                            }
                            else if (eval2(eval3(Cbm[i][0], Oper[j], Cbm[i][1], Oper[k], Cbm[i][2]), Oper[l], Cbm[i][3]) == 24){
                                retval += String.format("s(%f %c %f %c %f) %c %f", Cbm[i][0], Oper[j], Cbm[i][1], Oper[k], Cbm[i][2], Oper[l], Cbm[i][3]);
                            }
                            else if (eval2(eval2(eval2(Cbm[i][0], Oper[j], Cbm[i][1]), Oper[k], Cbm[i][2]), Oper[l], Cbm[i][3]) == 24){
                                retval += String.format("s((%f %c %f) %c %f) %c %f", Cbm[i][0], Oper[j], Cbm[i][1], Oper[k], Cbm[i][2], Oper[l], Cbm[i][3]);
                            }
                            else if (eval2(eval2(Cbm[i][0], Oper[j], eval2(Cbm[i][1], Oper[k], Cbm[i][2])), Oper[l], Cbm[i][3]) == 24){
                                retval += String.format("s(%f %c (%f %c %f)) %c %f", Cbm[i][0], Oper[j], Cbm[i][1], Oper[k], Cbm[i][2], Oper[l], Cbm[i][3]);
                            }
                            else if (eval2(Cbm[i][0], Oper[j], eval3(Cbm[i][1], Oper[k], Cbm[i][2], Oper[l], Cbm[i][3])) == 24){
                                retval += String.format("s%f %c (%f %c %f %c %f)", Cbm[i][0], Oper[j], Cbm[i][1], Oper[k], Cbm[i][2], Oper[l], Cbm[i][3]);
                            }
                            else if (eval2(Cbm[i][0], Oper[j], eval2(eval2(Cbm[i][1], Oper[k], Cbm[i][2]), Oper[l], Cbm[i][3])) == 24){
                                retval += String.format("s%f %c ((%f %c %f) %c %f)", Cbm[i][0], Oper[j], Cbm[i][1], Oper[k], Cbm[i][2], Oper[l], Cbm[i][3]);
                            }
                            else if (eval2(Cbm[i][0], Oper[j], eval2(Cbm[i][1], Oper[k], eval2(Cbm[i][2], Oper[l], Cbm[i][3]))) == 24){
                                retval += String.format("s%f %c (%f %c (%f %c %f))", Cbm[i][0], Oper[j], Cbm[i][1], Oper[k], Cbm[i][2], Oper[l], Cbm[i][3]);
                            }
                        }
                    }
                }
            }
    }

    public void printResult(){
        if(retval.length() == 0){
            System.out.println("Tidak ada solusi");
        }
        else{
            retval = retval.replace("10", "Temp");
            retval = retval.replace("0", "");
            retval = retval.replace(".", "");
            retval = retval.replace("Temp", "10");

            retval = retval.replace("11", "J");
            retval = retval.replace("12", "Q");
            retval = retval.replace("13", "K");
            retval = retval.replace("1 ", "A ");
            retval = retval.replace("1)", "A)");
            String[] output = retval.split("s");
            System.out.println(String.format("Terdapat %d solusi:", output.length-1));

            for(int i = 1; i < output.length; i++){
                System.out.println(output[i]);
            }
        }
    }

    public void fileResult(String filename){
        String fileOutput = filename + ".txt";

        if(retval.length() == 0){
            try{
                BufferedWriter bw = new BufferedWriter(new FileWriter("./test/" + fileOutput));

                bw.write("Tidak ada solusi");
                bw.newLine();

                bw.flush();
                bw.close();

                System.out.println("\n\n\nFile berhasil disimpan pada /test/" + fileOutput);

            } catch(Exception e){
                System.out.println(e);
            }
        }
        else{
            retval = retval.replace("10", "Temp");
            retval = retval.replace("0", "");
            retval = retval.replace(".", "");
            retval = retval.replace("Temp", "10");

            retval = retval.replace("11", "J");
            retval = retval.replace("12", "Q");
            retval = retval.replace("13", "K");
            retval = retval.replace("1 ", "A ");
            retval = retval.replace("1)", "A)");
            String[] output = retval.split("s");

            try{
                BufferedWriter bw = new BufferedWriter(new FileWriter("./test/" + fileOutput));

                for(int i = 1; i < output.length; i++){
                    bw.write(output[i]);
                    bw.newLine();
                }
                bw.flush();
                bw.close();

                System.out.println("\n\n\nFile berhasil disimpan pada /test/" + fileOutput);

            } catch(Exception e){
                System.out.println(e);
            }
        }
        
    }
}
