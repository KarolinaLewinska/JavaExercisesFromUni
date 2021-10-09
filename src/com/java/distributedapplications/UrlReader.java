package com.java.distributedapplications;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UrlReader {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit( () -> {
            try {
                getLinksFromUrlAndSaveToFile("https://www.otodom.pl/pl/oferty/wynajem/mieszkanie/sopot");
            } catch(Exception ex) {
                Logger.getLogger(UrlReader.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        executorService.shutdown();
    }

    public static void getLinksFromUrlAndSaveToFile(String websiteUrl) throws Exception {
        long startTime = System.currentTimeMillis();
        String[] textFromFile = {};

        for (int i = 0; i < 1; i++) {
            URL url = new URL(websiteUrl);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                textFromFile = inputLine.split("\"");
            }
            in.close();
        }

        try {
            FileWriter myWriter = new FileWriter("linksFromWebsite.txt");
            for (String text : textFromFile) {
                if (text.startsWith("http") && text.contains("http")) {
                    System.out.println(text);
                    myWriter.write(text + "\n");
                }
            }
            myWriter.close();
        } catch (IOException exc) {
            Logger.getLogger(UrlReader.class.getName()).info(exc.getMessage());
            exc.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time of program executing: " + (endTime-startTime));
    }
}

