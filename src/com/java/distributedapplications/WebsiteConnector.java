package com.java.distributedapplications;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Logger;

public class WebsiteConnector {
    public static void main(String[] args) {
        Socket socket1 = null;
        Socket socket2 = null;
        Socket socket3 = null;
        Socket socket4 = null;

        try {
            socket1 = new Socket("www.wp.pl", 80);
            socket2 = new Socket("www.ug.gda.pl", 80);
            socket3 = new Socket("www.onet.pl", 80);
            socket4 = new Socket("www.interia.pl", 80);
        } catch (IOException exc) {
            Logger.getLogger(UrlReader.class.getName()).info(exc.getMessage());
            Logger.getLogger(UrlReader.class.getName()).info(exc.getCause().toString());
            exc.getStackTrace();
        }
        printSocketInfo(socket1);
        printSocketInfo(socket2);
        printSocketInfo(socket3);
        printSocketInfo(socket4);
    }

    public static void printSocketInfo(Socket socket) {
        if (socket != null) {
            System.out.println(socket);
        }
    }
}

