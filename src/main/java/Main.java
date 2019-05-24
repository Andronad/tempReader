import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import com.ibm.jzos.FileFactory;


public class FileFactoryCopy {

    public static void main(String[] args) throws IOException {
        BufferedReader rdr = null;
        BufferedWriter wtr = null;
        long count = 0;
        try {
            rdr = FileFactory.newBufferedReader("//INVOICE.TXT");
            wtr = FileFactory.newBufferedWriter("//INVOICE2.TXT");

            String line;
            while ((line = rdr.readLine()) != null) {
                wtr.write(line);
                wtr.write("\n");
                count++;
            }
            System.out.println("Copied " + count + " lines from: " + args[0] + " to: " + args[1] );
        } finally {
            if (wtr != null) wtr.close();
            if (rdr != null) rdr.close();
        }
    }
}