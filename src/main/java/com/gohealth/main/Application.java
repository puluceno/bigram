package com.gohealth.main;

import com.gohealth.main.business.BiGram;
import com.gohealth.main.business.NGram;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Application {

    /**
     * Main method. Initiates the application.
     *
     * @param args input parameters
     */
    public static void main(String[] args) {
        if (args.length > 0 && !args[0].isBlank()) {
            Application.run(parseText(args[0]));
        } else {
            System.out.println("***** Please input the file name *****");
        }
    }

    /**
     * Instantiates the application base object and starts it.
     */
    private static void run(String text) {
        NGram biGram = new BiGram();
        biGram.generate(text);
    }

    private static String parseText(String filepath) {
        File file = new File(filepath);
        String parsedText = "";
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                parsedText += scanner.nextLine();
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return parsedText;
    }

}
