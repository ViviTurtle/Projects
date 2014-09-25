import java.lang.Math;
public class Running
{
    // instance variables - replace the example below with your own

    //values of each in microseconds
    private final long microsecond = 1;
    private final long second = microsecond * 1000000;
    private final long minute = second * 60;
    private final long hour = minute * 60;
    private final long day = hour *24;
    private final long month = day * 30;
    private final long year = day * 365;
    private final long century = year * 100;

    long[] time = {second, minute, hour, day, month, year, century};
    /**
     * Constructor for objects of class Running
     */
    public Running()
    {
        System.out.println("log n:");
        print(log_n());
        System.out.println("n:");
        print(n());
        System.out.println("n log n:");
        print(n_log_n());
        System.out.println("n squared:");
        print(n_squared());
        System.out.println("2^n:");
        print(power_n());
    }

    public void print(double[] answers)
    {
        for (double answer : answers)
        {
            System.out.println(answer);
        }
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public double[] log_n()
    {
                   int counter = 0;
        double[] answers = new double[7]; //the amount of in the table  
        for (double times : time) {
            long x = 1;
            while (Math.log(x) < times)
            {
                if (Math.log(x) < times/2){
                    x = x *2;
                }
                x += 1;
            }
            answers[counter] = x;
            counter += 1;
        }
        return answers;
    }

    public double[] power_n()
    {
                   int counter = 0;
        double[] answers = new double[7]; //the amount of in the table  
        for (double times : time) {
            int x = 1;
     
            while (Math.pow(2,x) < times)
            {
                if (Math.pow
                (2,x) < times/2){
                    x = x *2;
                }
                x += 1;
            }
            answers[counter] = x;
            counter += 1;
        }
        return answers;
    }

    public double[] n()
    {
                   int counter = 0;
        double[] answers = new double[7]; //the amount of in the table  
        for (double times : time) {
            int x = 1;

            while (x < times)
            {
                if (x < times/2){
                    x = x *2;
                }
                x += 1;
            }
            answers[counter] = x;
            counter += 1;
        }
        return answers;
    }

    public double[] n_log_n()
    {
                   int counter = 0;
        double[] answers = new double[7]; //the amount of in the table  
        for (double times : time) {
            int x = 1;

            while (x * Math.log(x) < times)
            {
                if (x*Math.log(x) < times/2){
                    x = x *2;
                }
                x += 1;
            }
            answers[counter] = x;
            counter += 1;
        }
        return answers;
    }

    public double[] n_squared()
    {
                   int counter = 0;
        double[] answers = new double[7]; //the amount of in the table  
        for (double times : time) {
            int x = 1;

            while (Math.pow(x, 2) < times )
            {
                if (Math.pow(x,2) < times/2){
                    x = x *2;
                }
                x += 1;
            }
            answers[counter] = x;
            counter += 1;
        }
        return answers;
    }}

