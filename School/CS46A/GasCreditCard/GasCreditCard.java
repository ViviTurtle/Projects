// This class mirrors shell's credit card savings in which if 45 gallons are spent, one would save 5 cents per gallon.
public class GasCreditCard
{
    private double aGallons;
    private double savings;
    public static final double GALLONS_MIN = 45;
    public static final double GALLONS_MAX = 100;
    public static final double DOLLARS_SAVED_RATE = 0.05;
    /*
     *This contructs a new gas credit card where savings and gallons bought is zero
     */
    public GasCreditCard()
    {
        savings = 0;
        aGallons = 0;
    }
    /*
     * This method buys gas and tracks how many gallons have been bought
     * @param gallons the amount of gallons bought
     */
    public void buyGas(double gallons)
    {
        aGallons = aGallons + gallons;  
    }
    /*
     * This method calculates how much savings one has saved until now
     * @return the amount of monety saved so far
     */
    public double getSavings()
    {
        if (aGallons >= GALLONS_MIN)
        {
            if (aGallons >= GALLONS_MAX)
            {
                savings = DOLLARS_SAVED_RATE * GALLONS_MAX;
            }
            else
            {
                savings = DOLLARS_SAVED_RATE * aGallons;
            }
        }
        else savings = 0;
        return savings;
    }
    /*
     * This method resets the amount of gallons and savings one has bought this for the new month
     */
    public void resetMonth()
    {
        aGallons = 0;
        savings = 0;
    }
}