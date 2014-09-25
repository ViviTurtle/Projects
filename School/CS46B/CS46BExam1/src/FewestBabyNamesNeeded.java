
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
            boolean less = true;
            double max = Double.parseDouble(args[2]);


            if (args[1].equals("female")) {
               while (in.hasNext() && less) {
                  for (int i = 0; i < 5; i++) {
                     in.next();
                  }
                  in.nextInt();
                  percentage += in.nextDouble();
                  count++;
                  in.nextLine();
                  if (percentage > max) {
                     less = false;
                  }
               }

            } else if (args[1].equals("male")) {
               while (in.hasNext() && less) {
                  in.next();
                  in.next();
                  in.nextInt();
                  count++;
                  percentage += in.nextDouble();
                  in.nextLine();
                  if (percentage > max) {
                     less = false;
                  }
               }
            }
            System.out.println(count);


         } catch (FileNotFoundException exception) {
            System.out.println("File not found: " + filename);
         }
      }
   }
}