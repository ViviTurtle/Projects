public class Tester
{
   public static void main(String[] args)
   {
       Bug1 coolBug = new Bug1();
       coolBug.turn();
       coolBug.move(1);
       System.out.println(coolBug.getX()); 
       System.out.println("Expected: 0.0");
       System.out.println(coolBug.getY());
       System.out.println("Expected: -1.0");
       coolBug.turn(-36.86989764584402);
       coolBug.move(5);
       System.out.println(coolBug.getX());
       System.out.println("Expected: 3.0");
       System.out.println(coolBug.getY());
       System.out.println("Expected: -5.0");
       
       
   }
}