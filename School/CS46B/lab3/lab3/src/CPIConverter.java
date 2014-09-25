
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
public class CPIConverter {

   private double[] cpi = new double[LAST_YEAR - FIRST_YEAR + 1];
   private static final int FIRST_YEAR = 1913;
   private static final int LAST_YEAR = 2012;

   public void read(String location) throws MalformedURLException, IOException {
      
         URL cpiURL = new URL(location);
         InputStream cpiIn = cpiURL.openStream();
         Scanner in = new Scanner(cpiIn);
         while (in.hasNextLine()) {
            int year = in.nextInt();
            double cpi1 = in.nextDouble();
            cpi[year - FIRST_YEAR] = cpi1;
            in.nextLine();
         }
      }
public double equivalentAmount(double amount, int fromYear, int toYear) {

      return amount / (cpi[fromYear - FIRST_YEAR]) * (cpi[toYear - FIRST_YEAR]);
   }
}
