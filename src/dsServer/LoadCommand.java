
package dsServer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LoadCommand implements iCommand{
    OutputStream outStream;

    public LoadCommand(OutputStream outStream) {
        this.outStream = outStream;
    }
    
    @Override
    public void execute() {
        BufferedReader in;
        PrintWriter out = new PrintWriter(outStream, true /* autoFlush */);
        try {
            in = new BufferedReader(new FileReader("11.json"));
            String s;

            while((s=in.readLine())!=null){   
                out.println(s);
            }
           out.close(); 
           in.close();  
       
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LoadCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) {
            Logger.getLogger(LoadCommand.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
