public class Student 
{
   private String name;
   private boolean ripe;
   
   public Student(String myName, boolean didShower)
   {
      name = myName;
      ripe = !didShower;
   }
   
   public boolean didShower()
   {
      return !ripe;
   }
   
   public String toString()
   {
      return name;
   }
}