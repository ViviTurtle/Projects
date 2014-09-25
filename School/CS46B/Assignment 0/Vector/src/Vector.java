/*
 * 
 */
public class Vector
{
   private double x;
   private double y;
 public Vector(double x, double y)  
 {
    this.x = x;
    this.y = y;
 }
 public double getX()
 {
    return x;
 }
 public double getY()
 {
    return y;
 }
 public Vector add(Vector v)
 {
    double newX = v.getX() + x;
    double newY = v.getY() + y;
    Vector vector2 = new Vector(newX, newY);
    return vector2;
 }
 public double getMagnitude()
 {
    double a = Math.pow(x, 2);
    double b = Math.pow(y, 2);
    double c = a + b;
    double answer = Math.sqrt(c);
    return answer;
 }
}
