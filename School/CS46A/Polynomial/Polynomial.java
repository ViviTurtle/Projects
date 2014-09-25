/*
 * This makes an array of the coefficiants of a certain polynomial, which can be added normally, or alternatingly
 */
public class Polynomial
{
    private double[] coeff;

    /*
    Constructs a polynomial with given coefficients.
    @param coeff the coefficients, starting with the highest term
     */
    public Polynomial(double... coeff)
    {
        this.coeff = coeff;
    }

    /*
    Evaluates this polynomial at a given value.
    @param x the value at which to evaluate the polynomial
    @return the value of the polynomial for the given x
     */
    public double at(double x)
    {
        // http://en.wikipedia.org/wiki/Horner%27s_method
        double r = 0;
        for (int i = 0; i < coeff.length; i++)
            r = coeff[i] + r * x;
        return r;
    }

    /*
     * Adds the sum of the coefficiants together
     * @return the sum
     */
    public double sumOfCoefficients()
    {
        double sum = 0;
        for (double numbers : coeff)
        {
            sum += numbers;
        }
        return sum;

    }

    /*
     * This adds the alternating sum of the Coefficients together (i.e. 1 -2 + 3 -4 +5 -6)
     * @returns the alternating sum
     */
    public double alternatingSumOfCoefficients()
    {
        int sum = 0;
        double index = 0;
        for (double numbers : coeff)
        {
            sum += numbers*Math.pow(-1, ++index+1);
        }
        return sum;
    }

    /*
     * This creates a string describing the polynomial
     * @return The string
     */
    public String prettyToString()
    {
        String[] subscripts = new String[11];
        subscripts[10] = "\u00B9"+"\u2070";
        subscripts[9] = "\u2079";
        subscripts[8] = "\u2078";
        subscripts[7] = "\u2077";
        subscripts[6] = "\u2076";
        subscripts[5] = "\u2075";
        subscripts[4] = "\u2074";
        subscripts[3] = "\u00B3";
        subscripts[2] = "\u00B2";
        subscripts[1] = "";
        subscripts[0] = "\u2070";
        String written = "";

        for (int i = 0; i <= coeff.length-1; i++)
        {
            int power = coeff.length-i-1;
            if (power == 0 && coeff[i] != 0)
            {
                written += "+" + coeff[i];
            }
             else if (coeff[i] != 0) //if the coefficient is 0 it skips to the next coeffefrficient 
            {

                if (coeff[i]  < 0) //this handles negatives numbers
                {

                    {
                        if(coeff[i] == -1)
                        {
                            written += "-x" + subscripts[power]; 
                        }
                        else 
                        {
                            written += coeff[i] + "x" + subscripts[power]; 
                        }
                    }
                }

                else if (coeff[i] > 0) //this handles positive numbers
                {
                    if (i == 0)
                    {
                        if(coeff[i] == 1)
                        {
                            written += "x" + subscripts[power]; 
                        }
                        else 
                        {
                            written += coeff[i] + "x" + subscripts[power]; 
                        }
                    }
                    else 
                    {
                        if(coeff[i] == 1)
                        {
                            written += "+x" + subscripts[power]; 
                        }
                        else 
                        {
                            written += "+"+ coeff[i] + subscripts[power]; 
                        }

                    }

                }
            }
        }
        written = written.replace(".0", "");
        return written;
    }
}

