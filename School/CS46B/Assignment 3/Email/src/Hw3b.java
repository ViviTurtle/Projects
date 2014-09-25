
import java.io.*;
import java.util.Scanner;

public class Hw3b {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Usage: Hw3b inputFileName");
        } else {
            try {
                File inFile = new File(args[0]);
                Scanner in = new Scanner(inFile, "UTF-8");
                in.useDelimiter("[,\n ]+");
                while (in.hasNext()) {

                    String word = in.next();
                    int count = 0;
                    for (int i = 0; i < word.length(); i++) {
                        if (word.charAt(i) == '@') {
                            count++;
                        }
                    }
                    if (word.charAt(0) != '@' && word.charAt(word.length() - 1) != '@' && count == 1) {
                        System.out.println(word);
                    }
                }
            } catch (FileNotFoundException exception) {
                System.out.println("File not Found: " + args[0]);
            }
        }
    }
}
