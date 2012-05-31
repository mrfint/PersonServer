package dsServer;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DSServer implements Runnable
{  
    private ServerSocket s = null;

    @Override
    public void run() {
     
        try 
        {
            // establish server socket
            s = new ServerSocket(8189);
        
            while (true) {
                Thread t= new DS_Net_Server(s.accept());
                t.start();
            }
            
       } catch (IOException ex) 
       {
            Logger.getLogger(DSServer.class.getName()).log(Level.SEVERE, null, ex);
       }
        
    }
}


