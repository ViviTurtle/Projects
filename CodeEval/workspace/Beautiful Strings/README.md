Challenge Description: (***Currently Working on it***)
-------------------------

Link: https://www.codeeval.com/open_challenges/83/


**Challange Description:**

>Credits: This problem appeared in the Facebook Hacker Cup 2013 Hackathon.

>When John was a little kid he didn't have much to do. There was no internet, no Facebook, and no programs to hack on. So he did the only thing he could... he evaluated the beauty of strings in a quest to discover the most beautiful string in the world.

>Given a string s, little Johnny defined the beauty of the string as the sum of the beauty of the letters in it. The beauty of each letter is an integer between 1 and 26, inclusive, and no two letters have the same beauty. Johnny doesn't care about whether letters are uppercase or lowercase, so that doesn't affect the beauty of a letter. (Uppercase 'F' is exactly as beautiful as lowercase 'f', for example.)

>You're a student writing a report on the youth of this famous hacker. You found the string that Johnny considered most beautiful. What is the maximum possible beauty of this string?

**Input sample:**

Your program should accept as its first argument a path to a filename. Each line in this file has a sentence. E.g. 

>ABbCcc

>Good luck in the Facebook Hacker Cup this year!

>Ignore punctuation, please :)

>Sometimes test cases are hard to make up.

>So I just go consult Professor Dalves


**Output sample:**

Print out the maximum beauty for the string. E.g. 

>152

>754

>491

>729

>646

Main.java
```java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		String string;
		Scanner scan2;
		char[] numbers;
		int last;
		ArrayList<Integer> answer = new ArrayList<Integer>() {
			{
				add(1);
			}
		};
		Scanner scan = new Scanner(new File(args[0]));
		while (scan.hasNextLine()) {
			string = scan.nextLine().toLowerCase();
			numbers = string.toCharArray();
			Arrays.sort(numbers);
			for (int i = 1; i < numbers.length; i++) {
				if (numbers[i] != numbers[i - 1]) {
					answer.add(1);
				}

				else {
					last = answer.get(answer.size() - 1);
					answer.set(answer.get(answer.size() - 1), last++);
				}
			}

		}
		scan.close();
	}
}
```


