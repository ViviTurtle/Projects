public class University extends AbstractFiniteSet
{
   private int students;

   public University(int size)
   {
      students = size;
   }

   public int number()
   {
      return students;
   }
}