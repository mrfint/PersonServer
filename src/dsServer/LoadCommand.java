
package dsServer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.converter.FactoryConvertI;
import model.converter.IConvert;
import model.dataStore.ADS;
import model.dataStore.DSFactory;
import model.except.ExtenException;
import model.person.Person;


public class LoadCommand implements iCommand{
    OutputStream outStream;

    public LoadCommand(OutputStream outStream) {
        this.outStream = outStream;
    }
    
    @Override
    public void execute() {
        List<Person> lst = null;
        
        
        PrintWriter out = new PrintWriter(outStream, true /* autoFlush */);
        try {
            //*** read from file
            lst = DSFactory.getInstance("storage.xml").load();
            System.out.println(lst);
            System.out.println("*****************");
            //*** send list
            for(int i=0; i<lst.size(); i++){
                String type = lst.get(i).getClass().getSimpleName();
                out.println(FactoryConvertI.getInstance("json", type).toString(lst.get(i)));
            }
           out.close();  
        } 
        catch (IOException ex){
            Logger.getLogger(LoadCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (ExtenException ex){
            Logger.getLogger(LoadCommand.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
