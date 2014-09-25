//No Package Statement Please!!!

//You should all be familiar with this after Assignment 0...
//But...
//it sure would be great if this class were Comparable...
//Add the required method and anything else needed to make it so.
//One vector is larger than another if it has a larger magnitude.
//For the draft, the added method should just return 0, always.
public class Vector implements Comparable
{
   private double x, y;
   
   public Vector (double thisX, double thisY)
   {
      x = thisX;
      y = thisY;
   }
   
   public double getX()
   {
      return x;
   }
   
   public double getY()
   {
      return y;
   }
   
   public String toString()
   {
      return "(x=" + x + ", y=" + y + ")";
   }
   
   public Vector add(Vector otherVector)
   {
      return new Vector(x+otherVector.x, y+otherVector.y);
   }
   
   public double getMagnitude()
   {
      return Math.sqrt(x*x + y*y);
   }
public int compareTo(Object other)
{
Vector v1 = (Vector)other;
if (this.getMagnitude() > v1.getMagnitude())
{
 return 1;
}
else if (v1.getMagnitude() > this.getMagnitude())
{
return -1;
}
else return 0;
}

}