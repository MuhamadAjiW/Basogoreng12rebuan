import java.io.BufferedWriter;
import java.io.FileWriter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Op {
    static ScriptEngineManager mgr = new ScriptEngineManager();
    static ScriptEngine engine = mgr.getEngineByName("JavaScript");

    char[] Oper = {'+', '-', '*', '/'};
    int OpLength = 4;
    String retval = "";

    public void getmodels(int[][] Cbm){

        int currentVal;
        int i, j, k, l;
        String current;

        try{
            for(i = 0; i < 24; i++){
                for(j = 0; j < OpLength; j++){
                    for(k = 0; k < OpLength; k++){
                        for(l = 0; l < OpLength; l++){
                            try{
                                current = String.format("%d %c %d %c %d %c %d", Cbm[i][0], Oper[j], Cbm[i][1], Oper[k], Cbm[i][2], Oper[l], Cbm[i][3]);
                                currentVal = (Integer) engine.eval(current);
                                if (currentVal == 24){
                                    retval += "s" + current;
                                    break;
                                }
                            } catch(Exception e){}
                            
                            try{
                                current = String.format("(%d %c %d) %c %d %c %d", Cbm[i][0], Oper[j], Cbm[i][1], Oper[k], Cbm[i][2], Oper[l], Cbm[i][3]);
                                currentVal = (Integer) engine.eval(current);
                                if (currentVal == 24){
                                    retval += "s" + current;
                                    break;
                                }
                            } catch(Exception e){}

                            try{
                                current = String.format("%d %c (%d %c %d) %c %d", Cbm[i][0], Oper[j], Cbm[i][1], Oper[k], Cbm[i][2], Oper[l], Cbm[i][3]);
                                currentVal = (Integer) engine.eval(current);
                                if (currentVal == 24){
                                    retval += "s" + current;
                                    break;
                                }
                            } catch(Exception e){}
                                
                            try{
                                current = String.format("%d %c %d %c (%d %c %d)", Cbm[i][0], Oper[j], Cbm[i][1], Oper[k], Cbm[i][2], Oper[l], Cbm[i][3]);
                                currentVal = (Integer) engine.eval(current);
                                if (currentVal == 24){
                                    retval += "s" + current;
                                    break;
                                }
                            } catch(Exception e){}

                            try{
                                current = String.format("(%d %c %d) %c (%d %c %d)", Cbm[i][0], Oper[j], Cbm[i][1], Oper[k], Cbm[i][2], Oper[l], Cbm[i][3]);
                                currentVal = (Integer) engine.eval(current);
                                if (currentVal == 24){
                                    retval += "s" + current;
                                    break;
                                }
                            } catch(Exception e){}

                            try{
                                current = String.format("(%d %c %d %c %d) %c %d", Cbm[i][0], Oper[j], Cbm[i][1], Oper[k], Cbm[i][2], Oper[l], Cbm[i][3]);
                                currentVal = (Integer) engine.eval(current);
                                if (currentVal == 24){
                                    retval += "s" + current;
                                    break;
                                }
                            } catch(Exception e){}

                            try{
                                current = String.format("((%d %c %d) %c %d) %c %d", Cbm[i][0], Oper[j], Cbm[i][1], Oper[k], Cbm[i][2], Oper[l], Cbm[i][3]);
                                currentVal = (Integer) engine.eval(current);
                                if (currentVal == 24){
                                    retval += "s" + current;
                                    break;
                                }
                            } catch(Exception e){}

                            try{
                                current = String.format("(%d %c (%d %c %d)) %c %d", Cbm[i][0], Oper[j], Cbm[i][1], Oper[k], Cbm[i][2], Oper[l], Cbm[i][3]);
                                currentVal = (Integer) engine.eval(current);
                                if (currentVal == 24){
                                    retval += "s" + current;
                                    break;
                                }
                            } catch(Exception e){}

                            try{
                                current = String.format("%d %c (%d %c %d %c %d)", Cbm[i][0], Oper[j], Cbm[i][1], Oper[k], Cbm[i][2], Oper[l], Cbm[i][3]);
                                currentVal = (Integer) engine.eval(current);
                                if (currentVal == 24){
                                    retval += "s" + current;
                                    break;
                                }
                            } catch(Exception e){}

                            try{
                                current = String.format("%d %c ((%d %c %d) %c %d)", Cbm[i][0], Oper[j], Cbm[i][1], Oper[k], Cbm[i][2], Oper[l], Cbm[i][3]);
                                currentVal = (Integer) engine.eval(current);
                                if (currentVal == 24){
                                    retval += "s" + current;
                                    break;
                                }
                            } catch(Exception e){}

                            try{
                                current = String.format("%d %c (%d %c (%d %c %d))", Cbm[i][0], Oper[j], Cbm[i][1], Oper[k], Cbm[i][2], Oper[l], Cbm[i][3]);
                                currentVal = (Integer) engine.eval(current);
                                if (currentVal == 24){
                                    retval += "s" + current;
                                    break;
                                }
                            } catch(Exception e){}
                        }
                    }
                }
            }
        } catch(Exception e){
            System.out.println(e);
        }
    }


    public void printResult(){
        if(retval.length() == 0){
            System.out.println("Tidak ada solusi");
        }
        else{
            retval = retval.replace("11", "J");
            retval = retval.replace("12", "Q");
            retval = retval.replace("13", "K");
            retval = retval.replace("1 ", "A ");
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
                BufferedWriter bw = new BufferedWriter(new FileWriter("./results/" + fileOutput));

                bw.write("Tidak ada solusi");
                bw.newLine();

                bw.flush();
                bw.close();

                System.out.println("\nFile berhasil disimpan pada /results/" + fileOutput);

            } catch(Exception e){
                System.out.println(e);
            }
        }
        else{
            retval = retval.replace("11", "J");
            retval = retval.replace("12", "Q");
            retval = retval.replace("13", "K");
            retval = retval.replace("1 ", "A ");
            String[] output = retval.split("s");

            try{
                BufferedWriter bw = new BufferedWriter(new FileWriter("./results/" + fileOutput));

                for(int i = 1; i < output.length; i++){
                    bw.write(output[i]);
                    bw.newLine();
                }
                bw.flush();
                bw.close();

                System.out.println("\nFile berhasil disimpan pada /results/" + fileOutput);

            } catch(Exception e){
                System.out.println(e);
            }
        }
        
    }
}
