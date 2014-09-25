//This class creates a Balloon that can add air and also get the radius, Surface Area, and Volume of the Balloon
public class Balloon
{
private double air;
private double radius;
    //Constructs an empty Balloon
    public Balloon()
    {
        air = 0;
    }
    /*
     * Adds air to the Balloon
     * @param amount the amount of air that is goign to be added
     */
    public void addAir(double amount)
    {
        air = air + amount;
        radius = Math.cbrt(3*air/4/Math.PI);
    }
    /*
     * Gets the current volume of air in the Balloon
     * @return the amount of air in the balloon
     */
    public double getVolume()
    {
        return air;
    }
    
    /*
     * Gets the current Surface Area of the Balloon
     * @return the surface area of the baloon
     */
    public double getSurfaceArea()
    {
        double surfaceArea = 4*Math.PI*radius*radius;
        return surfaceArea;
    }
    /*
     * Gets the current Radius of the Balloon
     * @return the radius of the ballon
     */
    public double getRadius()
    {
        return radius;
    }
}