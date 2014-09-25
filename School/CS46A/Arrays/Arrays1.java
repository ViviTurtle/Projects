// This class checks the order of an array if it increases then decreases or viceversa or returns how many times it increases and decreases
public class Arrays1
{
    public static final int MINIMUM_NUMBERS_TO_MAKE_A_HILL = 3;
    public static final int MIN_NUM_TO_INCREASE_DECREASE =2;
    /*
     * This checks the array if it increases then decreases
     * @param values the series of numbers the method checks
     * @return true if  it strictly increases then decreases 
     */
    public boolean isUpThenDown(int[] values)
    {
        boolean upDown = false;
        int peak = 0;
        if (values.length < MINIMUM_NUMBERS_TO_MAKE_A_HILL || values[0] > values[1]  )//if it just decreases in the beginning it returns false, or there isnt enought numbers in the set to comapare it returns false
        {
            return upDown;
        }
        else 
        {
            for(int i = 1; i<= values.length-1 && values[i-1] <= values[i]; i++) //gets the increasing length, and stops the moment it starts decreasing
            {
                if (values[i-1] < values[i]) //grabs the increasing order and returns remembers the peak 
                {
                    peak = i;
                }
            }
            upDown = true; //since its increasing ,so far the sequence is true

            for(int j = peak+1; j<= values.length-1 && upDown == true ;j++) // this checks if it decreases, after the peak, if it doesnt returns false
            {
                if (values[j-1] <= values[j]) // if it increases anywhere after the peak it returns false and the loop stops
                {
                    upDown = false; 
                }

            }
            return upDown;
        }

    }

    /*
     * Counts the number of times a series of numbers increases and decreases
     * @param values the series of numbers
     * @return the amount of times it increases and decreases
     */
    public int upsAndDowns(int[] values)
    {
        int placement = 1;
        int counter = 0;
        if (values.length < MIN_NUM_TO_INCREASE_DECREASE)
        {
            return counter;
        }
        else
        {
            while (placement <= values.length-1)
            {
                if (values[placement-1] < values[placement])
                {
                    for (int i = placement; i <= values.length-1 && values[i-1] <= values[i]; i++)
                    {
                        placement = i+1;
                    }
                    counter++;
                }
                else if (values[placement-1] > values[placement])
                {
                    for (int j = placement; j <= values.length-1 && values[j-1] >= values[j]; j++)
                    {
                        placement = j+1;
                    }
                    counter++;
                }
            }
        }
        return counter;
    }
}