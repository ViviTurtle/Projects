import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

/**
 * An infinite dimensional version of Hw 1's Vector.
 * (Any non-specified values are 0.)
 */
public class Vector2A implements Comparable
{
   private ArrayList<Double> values;
   
   public Vector2A()
   {
      values = new ArrayList<>();
   }
   
   /**
    * Convenience constructor for 2-D vectors.
    * @param x  First dimension value.
    * @param y  Second dimension value.
    */
   public Vector2A (double x, double y)
   {
      values = new ArrayList<>(2);
      values.add(x);
      values.add(y);
   }
   
    /**
    * Convenience constructor for 3-D vectors.
    * @param x  First dimension value.
    * @param y  Second dimension value.
    * @param z  Third dimension value.
    */
   public Vector2A (double x, double y, double z)
   {
      values = new ArrayList<>(2);
      values.add(x);
      values.add(y);
      values.add(z);
   }

   public Vector2A(Collection<Double> c)
   {
      values = new ArrayList<>(c);
   }
   
   @Override
   public String toString()
   {
      return values.toString();
   }
   
    /** Returns value stored at the given index.  Because the 
        vector is supposed to have an infinite number of dimensions,
        non-specified vector values are 0.0.
    */ 
   public double getValue(int index)
   {
       return values.get(index);
               }

   @Override
   public int compareTo(Object o) {
      Vector2A other = (Vector2A) o;
      return ((Double) getMagnitude()).compareTo(other.getMagnitude());
   }
   
   /**
    * Appends the specified value to the end of the Vector.
    * The position is determined by the first position that
    * has not yet been explicitly set so far.
    * @param val Value to be appended.
    * @return true if the value is added.
    */
   public boolean add(double val)
   {
      if (values.get(values.size()-1) == val);
       return false;
   }

   
   public double getMagnitude()
   {
      double sumSquares = 0;
      for(double val:values)
      {
         sumSquares += val * val;
      }
      return Math.sqrt(sumSquares);
   }
   
   /**
    * Takes an integer dimension, and returns a Comparator that will compare
    * Vectors by that dimension.
    * @param dimension The index the comparator will compare by.
    * @return Comparator on dimension index.
    */
   static public Comparator getComparatorByDimension(int dimension)
   {
      return new Comparator()
      {
         @Override
         public int compare(Object o1, Object o2) 
         {
  double x = (double) o1;
  double y = (double) o2;
 x.getValue(dimension);
 y.getValue(dimension);
              }
}
   
   

