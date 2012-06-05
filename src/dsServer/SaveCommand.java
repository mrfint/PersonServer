
package dsServer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.converter.FactoryConvertI;
import model.dataStore.DSFactory;
import model.except.ExtenException;
import model.person.Person;


public class SaveCommand implements iCommand{
    Scanner sc;

    public SaveCommand(Scanner sc) {
        this.sc = sc;
    }
    
    @Override
    public void execute() {
        
        List<Person> lst = parseDate();
        
        try {
             DSFactory.getInstance("storage.xml").save(lst);
        } 
        catch (ExtenException ex) {
            Logger.getLogger(SaveCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) {
                Logger.getLogger(SaveCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
        
       
    }
    private List<Person> parseDate(){
        
        List<Person> lst = new ArrayList<Person>(); 

        while (sc.hasNextLine())
        {  
            String line = sc.nextLine();            

            String type = line.substring(2,line.indexOf(':')-1);
            lst.add(FactoryConvertI.getInstance("json", type).fromString(line));
            
        }
        return lst;
    }
}
