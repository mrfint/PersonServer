
package bin;

import dsServer.DSServer;
import webServer.WebServer;


public class ServerStart {

    public static void main(String[] args) {
        
        Thread t1 = new Thread(new DSServer());
        Thread t2 = new Thread(new WebServer());
        
        // Run threads
        t1.start();
        t2.start();
        
    }
}
