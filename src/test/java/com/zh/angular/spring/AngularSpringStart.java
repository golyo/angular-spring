package com.zh.angular.spring;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class AngularSpringStart {
    public static void main(String[] args) throws Exception {

        Server server = new Server(8080);
        WebAppContext whandler = new WebAppContext("src/main/webapp", "/");       
        server.setHandler(whandler);
        server.setStopAtShutdown(true);

        try {
            System.out.println(">>> STARTING EMBEDDED JETTY SERVER, PRESS ANY KEY TO STOP");
            server.start();
            System.in.read();
            System.out.println(">>> STOPPING EMBEDDED JETTY SERVER");
            server.stop();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
