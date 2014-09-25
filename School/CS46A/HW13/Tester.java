public class Tester
{
   public static void main(String[] args)
   {
      Grid gr = new UnboundedGrid();
      gr.set(new Location(2, 2), 2);
      gr.set(new Location(3, 3), 3);
      gr.set(new Location(4, 4), 4);
      System.out.println(gr.get(new Location(3, 3)));
      System.out.println("Expected: 3");
      System.out.println(gr.get(new Location(3, 4)));
      System.out.println("Expected: 0");
      gr.set(new Location(3, 3), 4);
      System.out.println(gr.get(new Location(3, 3)));
      System.out.println("Expected: 4");
      gr.set(new Location(3, 3), 0);
      System.out.println(gr.get(new Location(3, 3)));
      System.out.println("Expected: 0");
   }
}