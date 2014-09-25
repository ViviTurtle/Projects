
import java.io.*;
import java.util.Scanner;

public class BabyNamesStartingWithA {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java BabyNamesStartingWithA filename");
        } else {
             String filename = args[0];
            try {

                File baby = new File(filename);
                Scanner in = new Scanner(baby);
                while (in.hasNext()) {
                    for (int i = 0; i < 4; i++)
                    {
                        in.next();
                    }
                    String name = in.next();
                    if (name.charAt(0) == 'A') {
                        System.out.print(name);
                        double frequency = in.nextInt();
                        System.out.println(frequency);
                    }
                }
            } catch (FileNotFoundException exception) {
                System.out.println("File not found: " + filename);
            }
        }
    }
}