import java.io.*;
import java.util.Scanner;

public class Hw3a {

    public static void main(String[] args) {
        int letters = 0;
        int words = 0;
        int sentences = 0;
        Scanner in = new Scanner(System.in, "UTF-8");
        in.useDelimiter("[\n ]+");
        if (in.hasNext())
        {
            sentences++;
        }
        while (in.hasNext()) {
            String word = in.next();
            words++;
            if (word.contains("...")) 
            {
                words++;
            }
            
            for (int i = 0; i < word.length(); i++) {
                char test = word.charAt(i);
                if (test == '.' || test == '?' || test == '!')
                {
                    if (in.hasNext())
                    {
                    sentences++;
                    }
                }
                if (Character.isLetter(test)) {
                    letters++;
                }
            }
        }
        System.out.println("Total letters: " + letters);
        System.out.println("Total words: " + words);
        System.out.println("Total sentences: " + sentences);
        System.out.println("Letters per word: " + (double)letters / (double)words);
        System.out.println("Words per sentence: " + (double)words / (double)sentences);
    }
}
