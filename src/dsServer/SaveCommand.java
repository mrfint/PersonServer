
package dsServer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SaveCommand implements iCommand{
    Scanner sc;

    public SaveCommand(Scanner sc) {
        this.sc = sc;
    }
    
    @Override
    public void execute() {
        try {
            FileWriter out = new FileWriter("11.json");
            
            while (sc.hasNextLine())
            {  
               String line = sc.nextLine();            
               out.write(line+"\r\n");            
            }
            
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(SaveCommand.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }
    
}
