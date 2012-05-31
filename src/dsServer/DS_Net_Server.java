
package dsServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


class DS_Net_Server extends Thread {
    private final Socket incoming;
    
    DS_Net_Server(Socket accept) {
        incoming = accept;
    }

    @Override
    public void run() {

         try
         {
            InputStream inStream = incoming.getInputStream();
            OutputStream outStream = incoming.getOutputStream();

            Scanner in = new Scanner(inStream);
            PrintWriter out = new PrintWriter(outStream, true /* autoFlush */);
         
            if(in.hasNextLine())
            {
                iCommand c = null;
                String type = in.nextLine();
                
                if(type.equals("save")){
                    c = new SaveCommand(in);
                }
                else if(type.equals("load")){
                    c = new LoadCommand(outStream);
                }

                c.execute();
            
            }

            
         }
         catch(IOException ex) {
                Logger.getLogger(DS_Net_Server.class.getName()).log(Level.SEVERE, null, ex);
         }
         finally
         {
            try {
                incoming.close();
            } catch (IOException ex) {
                Logger.getLogger(DS_Net_Server.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
    }
    
}
