import java.util.Comparator;
 
public class VectorComparatorBuilder 
{
   Measurer measurer;
   
   public VectorComparatorBuilder(Measurer aMeasurer)
   {
      measurer = aMeasurer;
   }
   
   public Comparator getComparator()
   {
      return new Comparator()
      {
         public int compare(Object o1, Object o2) 
         {
        if (measurer.measure(o1) > measurer.measure(o2))
{
return 1;
}
else if (measurer.measure(o1) < measurer.measure(o2))
{
return -1;
}
else return 0;
	     //Really, that is all it should do:  just return 0.
         }
      };
     
   }
}