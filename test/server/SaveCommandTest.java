
package server;

import dsServer.SaveCommand;
import java.util.Scanner;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;


public class SaveCommandTest {
    private final SaveCommand cmd;
    
    public SaveCommandTest() {
        Scanner sc = new Scanner("{\"Person\": {\"id\":\"0\",\"fn\":\"GaryTest\",\"ln\":\"Portman\",\"age\":\"30\"}");
        cmd = new SaveCommand(sc);
        
    }

    
    @Test
    public void testSomeMethod() {
        cmd.execute();
    }
}
