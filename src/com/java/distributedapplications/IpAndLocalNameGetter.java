package com.java.distributedapplications;

import java.net.InetAddress;
import java.util.logging.Logger;

public class IpAndLocalNameGetter {
    public static void main(String[] args) {
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            String ipAddress = inetAddress.getHostAddress();
            String computerName = inetAddress.getHostName();
            System.out.println("IP address: " + ipAddress + "\n" + "Computer name: " + computerName);
        }
        catch (Exception exc) {
            Logger.getLogger(IpAndLocalNameGetter.class.getName()).info(exc.getMessage());
            System.exit(0);
        }
    }
}

