import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Vector;

public class Op {
    char[] Oper = {'+', '-', '*', '/'};
    Vector<String> retval = new Vector<String>(1);

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

    public void getmodels(Vector<float[]> Cbm){
        byte i, j, k, l;
            for(i = 0; i < Cbm.size(); i++){
                for(j = 0; j < 4; j++){
                    for(k = 0; k < 4; k++){
                        for(l = 0; l < 4; l++){
                            if (eval4(Cbm.get(i)[0], Oper[j], Cbm.get(i)[1], Oper[k], Cbm.get(i)[2], Oper[l], Cbm.get(i)[3]) == 24){
                                retval.add(String.format("%.0f %c %.0f %c %.0f %c %.0f", Cbm.get(i)[0], Oper[j], Cbm.get(i)[1], Oper[k], Cbm.get(i)[2], Oper[l], Cbm.get(i)[3]));
                            }
                            else if (eval3(eval2(Cbm.get(i)[0], Oper[j], Cbm.get(i)[1]), Oper[k], Cbm.get(i)[2], Oper[l], Cbm.get(i)[3]) == 24){
                                retval.add(String.format("(%.0f %c %.0f) %c %.0f %c %.0f", Cbm.get(i)[0], Oper[j], Cbm.get(i)[1], Oper[k], Cbm.get(i)[2], Oper[l], Cbm.get(i)[3]));
                            }
                            else if (eval3(Cbm.get(i)[0], Oper[j], eval2(Cbm.get(i)[1], Oper[k], Cbm.get(i)[2]), Oper[l], Cbm.get(i)[3]) == 24){
                                retval.add(String.format("%.0f %c (%.0f %c %.0f) %c %.0f", Cbm.get(i)[0], Oper[j], Cbm.get(i)[1], Oper[k], Cbm.get(i)[2], Oper[l], Cbm.get(i)[3]));
                            }
                            else if (eval3(Cbm.get(i)[0], Oper[j], Cbm.get(i)[1], Oper[k], eval2(Cbm.get(i)[2], Oper[l], Cbm.get(i)[3])) == 24){
                                retval.add(String.format("%.0f %c %.0f %c (%.0f %c %.0f)", Cbm.get(i)[0], Oper[j], Cbm.get(i)[1], Oper[k], Cbm.get(i)[2], Oper[l], Cbm.get(i)[3]));
                            }
                            else if (eval2(eval2(Cbm.get(i)[0], Oper[j], Cbm.get(i)[1]), Oper[k], eval2(Cbm.get(i)[2], Oper[l], Cbm.get(i)[3])) == 24){
                                retval.add(String.format("(%.0f %c %.0f) %c (%.0f %c %.0f)", Cbm.get(i)[0], Oper[j], Cbm.get(i)[1], Oper[k], Cbm.get(i)[2], Oper[l], Cbm.get(i)[3]));
                            }
                            else if (eval2(eval3(Cbm.get(i)[0], Oper[j], Cbm.get(i)[1], Oper[k], Cbm.get(i)[2]), Oper[l], Cbm.get(i)[3]) == 24){
                                retval.add(String.format("(%.0f %c %.0f %c %.0f) %c %.0f", Cbm.get(i)[0], Oper[j], Cbm.get(i)[1], Oper[k], Cbm.get(i)[2], Oper[l], Cbm.get(i)[3]));
                            }
                            else if (eval2(eval2(eval2(Cbm.get(i)[0], Oper[j], Cbm.get(i)[1]), Oper[k], Cbm.get(i)[2]), Oper[l], Cbm.get(i)[3]) == 24){
                                retval.add(String.format("((%.0f %c %.0f) %c %.0f) %c %.0f", Cbm.get(i)[0], Oper[j], Cbm.get(i)[1], Oper[k], Cbm.get(i)[2], Oper[l], Cbm.get(i)[3]));
                            }
                            else if (eval2(eval2(Cbm.get(i)[0], Oper[j], eval2(Cbm.get(i)[1], Oper[k], Cbm.get(i)[2])), Oper[l], Cbm.get(i)[3]) == 24){
                                retval.add(String.format("(%.0f %c (%.0f %c %.0f)) %c %.0f", Cbm.get(i)[0], Oper[j], Cbm.get(i)[1], Oper[k], Cbm.get(i)[2], Oper[l], Cbm.get(i)[3]));
                            }
                            else if (eval2(Cbm.get(i)[0], Oper[j], eval3(Cbm.get(i)[1], Oper[k], Cbm.get(i)[2], Oper[l], Cbm.get(i)[3])) == 24){
                                retval.add(String.format("%.0f %c (%.0f %c %.0f %c %.0f)", Cbm.get(i)[0], Oper[j], Cbm.get(i)[1], Oper[k], Cbm.get(i)[2], Oper[l], Cbm.get(i)[3]));
                            }
                            else if (eval2(Cbm.get(i)[0], Oper[j], eval2(eval2(Cbm.get(i)[1], Oper[k], Cbm.get(i)[2]), Oper[l], Cbm.get(i)[3])) == 24){
                                retval.add(String.format("%.0f %c ((%.0f %c %.0f) %c %.0f)", Cbm.get(i)[0], Oper[j], Cbm.get(i)[1], Oper[k], Cbm.get(i)[2], Oper[l], Cbm.get(i)[3]));
                            }
                            else if (eval2(Cbm.get(i)[0], Oper[j], eval2(Cbm.get(i)[1], Oper[k], eval2(Cbm.get(i)[2], Oper[l], Cbm.get(i)[3]))) == 24){
                                retval.add(String.format("%.0f %c (%.0f %c (%.0f %c %.0f))", Cbm.get(i)[0], Oper[j], Cbm.get(i)[1], Oper[k], Cbm.get(i)[2], Oper[l], Cbm.get(i)[3]));
                            }
                            /* 
                            if (eval2(eval2(Cbm.get(i)[0], Oper[j], Cbm.get(i)[1]), Oper[k], eval2(Cbm.get(i)[2], Oper[l], Cbm.get(i)[3])) == 24){
                                retval.add(String.format("(%.0f %c %.0f) %c (%.0f %c %.0f)", Cbm.get(i)[0], Oper[j], Cbm.get(i)[1], Oper[k], Cbm.get(i)[2], Oper[l], Cbm.get(i)[3]));
                            }
                            if (eval2(eval2(eval2(Cbm.get(i)[0], Oper[j], Cbm.get(i)[1]), Oper[k], Cbm.get(i)[2]), Oper[l], Cbm.get(i)[3]) == 24){
                                retval.add(String.format("((%.0f %c %.0f) %c %.0f) %c %.0f", Cbm.get(i)[0], Oper[j], Cbm.get(i)[1], Oper[k], Cbm.get(i)[2], Oper[l], Cbm.get(i)[3]));
                            }
                            if (eval2(eval2(Cbm.get(i)[0], Oper[j], eval2(Cbm.get(i)[1], Oper[k], Cbm.get(i)[2])), Oper[l], Cbm.get(i)[3]) == 24){
                                retval.add(String.format("(%.0f %c (%.0f %c %.0f)) %c %.0f", Cbm.get(i)[0], Oper[j], Cbm.get(i)[1], Oper[k], Cbm.get(i)[2], Oper[l], Cbm.get(i)[3]));
                            }
                            if (eval2(Cbm.get(i)[0], Oper[j], eval2(eval2(Cbm.get(i)[1], Oper[k], Cbm.get(i)[2]), Oper[l], Cbm.get(i)[3])) == 24){
                                retval.add(String.format("%.0f %c ((%.0f %c %.0f) %c %.0f)", Cbm.get(i)[0], Oper[j], Cbm.get(i)[1], Oper[k], Cbm.get(i)[2], Oper[l], Cbm.get(i)[3]));
                            }
                            */
                        }
                    }
                }
            }
    }

    public void printResult(){
        if(retval.size() == 0){
            System.out.println("Tidak ada solusi");
        }
        else{
            String output;
            System.out.println(String.format("Terdapat %d solusi:", retval.size()));
            for(int i = 0; i < retval.size(); i++){
                output = retval.get(i).replace("11", "J").replace("12", "Q").replace("13", "K").replace("10", "T").replace("1", "A").replace("T", "10");
                System.out.println(output);
            }
        }
    }

    public void fileResult(String filename){
        String fileOutput = filename + ".txt";

        if(retval.size() == 0){
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
            String output;
            try{
                BufferedWriter bw = new BufferedWriter(new FileWriter("./test/" + fileOutput));
                bw.write(String.format("Terdapat %d solusi:", retval.size()));
                bw.newLine();
                for(int i = 0; i < retval.size(); i++){
                    output = retval.get(i).replace("11", "J").replace("12", "Q").replace("13", "K").replace("10", "T").replace("1", "A").replace("T", "10");
                    bw.write(output);
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
