
import java.util.LinkedList;

public class Hw6cTester {
   public static void main(String[] args)
   {
      LinkedList<Student> ll = new LinkedList<>();
      Student s = new Student("Stinky Joe", false);
      ll.addLast(s);
      
      s = new Student("Clean Jane", true);
      ll.addLast(s);
      s = new Student("Sparkling Sally", true);
      ll.addLast(s);
      s = new Student("Smelly Sue", false);
      ll.addLast(s);
      s = new Student("Fresh Fran", true);
      ll.addLast(s);
      s = new Student("Soapy Steve", true);
      ll.addLast(s);
      s = new Student("Grimey Grant", false);
      ll.addLast(s);
      s = new Student("Sewage Steve", false);
      ll.addLast(s);
      s = new Student("Shampood Shayna", true);
      ll.addLast(s);
      
      Hw6c.breeze(ll);
      System.out.println("Received: " + ll);
      System.out.println("Expected: [Stinky Joe, Sparkling Sally, " +
              "Smelly Sue, Soapy Steve, Grimey Grant]");      
      
   }
}