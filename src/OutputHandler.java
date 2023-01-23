import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Vector;

public class OutputHandler {
    BufferedWriter bw;
    public void printResult(Vector<String> retval){
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

    public void fileResult(String filename, Vector<String> retval){
        String fileOutput = filename + ".txt";

        if(retval.size() == 0){
            try{
                bw = new BufferedWriter(new FileWriter("./test/" + fileOutput));
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
