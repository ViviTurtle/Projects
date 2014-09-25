public class Homework2C
{
   public static void main(String[] args)
   {
      Day d1 = new Day(2012,1,1);
      Day d2 = new Day(2012,2,28);
      Day d3 = new Day(2012,12,31);
      Day newD1 = d1.addDays(1);
      Day newD2 = d2.addDays(1);
      Day newD3 = d3.addDays(1);
      
      System.out.println(newD1.toString());
      System.out.println("Expected: 2012-01-02");
      System.out.println(newD2.toString());
      System.out.println("Expected: 2012-02-29");
      System.out.println(newD3.toString());
      System.out.println("Expected: 2013-01-01");
   }
}