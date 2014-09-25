import java.util.ArrayList;

/**
 * An infinite dimensional version of Hw 1's Vector.
 * (Any non-specified values are 0.)  Now as a subclass!
 */
public class Vector2B extends ArrayList<Double>
{
      public double getMagnitude()
{
   int total = 0;
for (int i = 0; i <= this.size()-1; i++) {
   total += Math.pow(this.get(i), 2);
}
return Math.sqrt(total);
}


public Double get(int x)
{
if (x >= this.size()) {
   return 0.0;
}
else {
   return super.get(x);
}
}

    //You need to write 2 methods here.  You don't actually need any
    //constructors for this part, just the 2 methods that will get the
    //the tester to run correctly. 
   

   
}
