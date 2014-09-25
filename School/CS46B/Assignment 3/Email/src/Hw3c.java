
import java.util.Scanner;

public class Hw3c {

    public static String e2PL(String input) {
        String sentence = "";
        Scanner in = new Scanner(input);
        in.useDelimiter("[\n ]+");
        while (in.hasNext()) {
            int beginning = 0;
            int position = 0;
            String consanants = "";
            String punctuation = "";
            String word = in.next();
            for (int j = 1; j < word.length(); j++) {
                if ((word.charAt(j) == ',') || word.charAt(j) == '!' || word.charAt(j) == '.' || word.charAt(j) == '?') {
                    punctuation = punctuation + word.charAt(j);
                }
            }
            boolean apos = false;
            boolean caps = false;
            if (Character.isUpperCase(word.charAt(0))) {
                caps = true;
            }
            if (Character.toLowerCase(word.charAt(0)) != 'a' && Character.toLowerCase(word.charAt(0)) != 'e' && Character.toLowerCase(word.charAt(0)) != 'i' && Character.toLowerCase(word.charAt(0)) != 'o' && Character.toLowerCase(word.charAt(0)) != 'u') {
                //if (!isVowel(word.charAt(0))) {
                if (word.charAt(0) == '\'') {
                    apos = true;
                } else {
                    consanants = consanants + Character.toLowerCase(word.charAt(0));
                }
                for (int i = 1; i < word.length() && !isVowel(word.charAt(i)); i++) {
                    if (word.charAt(i) != '!' && word.charAt(i) != '.' && word.charAt(i) != '?' && word.charAt(i) != ',') {
                        consanants = consanants + word.charAt(i);
                        beginning = i;
                    }
                }
            } else {
                beginning = -1;
                consanants = "";
            }
            String replaced;
            if (!caps) {
                replaced = word.substring(beginning + 1);
            } else {
                replaced = (Character.toUpperCase(word.charAt(beginning + 1)) + word.substring(beginning + 2));
            }
            replaced = replaced.replace("!", "");
            replaced = replaced.replace("?", "");
            replaced = replaced.replace(".", "");
            replaced = replaced.replace(",", "");
            if (apos) {
                String newWord = " " + "'" + replaced + consanants + "ay" + punctuation;
                sentence = sentence + newWord;
            } else {
                String newWord = " " + replaced + consanants + "ay" + punctuation;
                sentence = sentence + newWord;
            }
        }
        return sentence;
    }

    public static boolean isVowel(char i) {
        if (Character.toLowerCase(i) == 'a' || Character.toLowerCase(i) == 'e' || Character.toLowerCase(i) == 'i' || Character.toLowerCase(i) == 'o' || Character.toLowerCase(i) == 'u' || Character.toLowerCase(i) == '\'') {
            return true;
        }
        return false;
    }
}
