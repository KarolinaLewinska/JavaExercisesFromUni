package com.java.distributedapplications;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Logger;

public class IpAddressesGetter {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Enter program argument!");
            System.exit(0);
        } else if (args.length > 1) {
            System.out.println("Enter only one argument!");
            System.exit(0);
        }
        String hostname = args[0];
        try {
            InetAddress[] allInetAddresses = InetAddress.getAllByName(hostname);
            for (InetAddress inetAddress : allInetAddresses) {
                System.out.println("All IP addresses of " + hostname + ":\n" + inetAddress + "\n");
            }
        }
        catch (UnknownHostException exc) {
            Logger.getLogger(IpAddressesGetter.class.getName()).info(exc.getMessage());
            System.exit(0);
        }
    }
}
