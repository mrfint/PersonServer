/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import dsServer.LoadCommand;
import java.io.PrintWriter;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

public class LoadCommandTest {
    private final LoadCommand cmd;
    
    public LoadCommandTest() {
        cmd = new LoadCommand(System.out);
    }

    @Test
    public void testSomeMethod() {
        cmd.execute();
    }
}
