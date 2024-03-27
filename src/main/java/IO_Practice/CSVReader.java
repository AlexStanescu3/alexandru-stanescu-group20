package IO_Practice;

import java.io.*;
import java.nio.file.Paths;

public class CSVReader {
    public static void main(String[] args) {

        File myFile = new File("C:/Users/user/Downloads/SacramentocrimeJanuary2006.csv");
        String line = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(myFile));

            while((line = br.readLine()) !=null) {
                String[] values = line.split(",");
                System.out.println("Date: " + values[0] + ", Crime description: " + values[5]);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
