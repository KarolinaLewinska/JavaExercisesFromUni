package com.java.distributedapplications;

import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class PortScanner {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit( () -> {
            try {
                if (args.length < 1) {
                    System.out.println("Enter program argument!");
                    System.exit(0);
                } else if (args.length > 1) {
                    System.out.println("Enter only one argument!");
                    System.exit(0);
                }
                String serverAddress = args[0];
                for (int port=1; port<=65535; port++) {
                    try {
                        Socket socket = new Socket();
                        SocketAddress socketAddress = new InetSocketAddress(serverAddress, port);
                        socket.connect(socketAddress, 1);
                        System.out.println("Connection established at port: " + socket.getPort());
                        socket.close();
                    } catch (SocketTimeoutException ste) {
                        System.out.println("Cannot connect with port: " + port);
                    }
                }

            } catch (Exception exc) {
                Logger.getLogger(PortScanner.class.getName()).info(exc.getMessage());
                exc.printStackTrace();
            }
        });
        executorService.shutdown();
    }
}
