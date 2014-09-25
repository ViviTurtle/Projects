
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FewestBabyNamesNeeded {

   public static void main(String[] args) {
      if (args.length != 3) {
         System.out.println("Usage: java FewestBabyNamesNeeded filename male value");
         System.out.println("or: java FewestBabyNamesNeeded filename female value");
      } else {
         String filename = args[0];
         try {

            File baby = new File(filename);
            Scanner in = new Scanner(baby);
            double percentage = 0;
            int count = 0;
            double max = (double) filename.charAt(filename.length() - 1);
            if (filename.contains("female")) {
               while (in.hasNext() && percentage < max) {
                  for (int i = 0; i < 4; i++) {
                     in.next();
                     in.nextInt();
                     percentage += in.nextDouble();
                     count++;
                     in.nextLine();
                  }
               }
            } else if (filename.contains("male")) {
               while (in.hasNext()) {
                  in.next();
                  in.next();
                  in.nextInt();
                  percentage += in.nextDouble();
                  count++;
                  in.nextLine();
               }
            }
            System.out.println(count);


         } catch (FileNotFoundException exception) {
            System.out.println("File not found: " + filename);
         }
      }
   }
}