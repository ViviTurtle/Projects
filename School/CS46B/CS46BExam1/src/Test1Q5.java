
public class Test1Q5 {

   public static void main(String[] args) {
      String a = "abcdef";
      String b = "abracadabra";
      System.out.println("Length:  " + maxLengthSharedString(a, b));
      System.out.println("Expected:  4");
   }

   public static int maxLengthSharedString(String a, String b) {
      return helper(a, b, 0);
   }

   private static int helper(String a, String b, int count) {
      int amount = count;
      if (a.isEmpty() || b.isEmpty()) {
         return amount;
      }
      if (a.charAt(0) == b.charAt(0)) {
         amount++;
         return helper(a.substring(1), b.substring(1), amount);
      } 
      if (a.length() > b.length()) {
         if (a.contains(b.substring(0, 1))) {
            amount++;
            int start = a.indexOf(b.substring(0, 1));
            return helper(a.substring(start), b.substring(1), amount);
         }
      } else if (b.length() > a.length()) {
         if (b.contains(a.substring(0, 1))) {
            amount++;
            int start = b.indexOf(a.substring(0, 1));
            return helper(b.substring(start), a.substring(1), amount);
         }
      }
      return helper(b.substring(1), a.substring(1), amount);
   }
}
