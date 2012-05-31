package webServer;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import dsServer.DSServer;


public class WebServer implements Runnable
{  private ServerSocket s = null;

    @Override
    public void run() {
     
      try 
      {
            // establish HTTP - server socket
            ServerSocket s = new ServerSocket(8080);
            while (true) {
                Thread t= new ServerListener(s.accept());
                t.start();
            }
      } 
      catch (IOException ex) 
      {
            Logger.getLogger(DSServer.class.getName()).log(Level.SEVERE, null, ex);
      }
   
   }

    
}


