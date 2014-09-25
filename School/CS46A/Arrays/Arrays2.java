import java.util.*;
//This grabs a a lists of numbers, and modifies the lists by putting negatives first or other methods concerning negatives
public class Arrays2
{
    /*
     * This copies the negatives of a series, and in order, puts them in the beginning
     * @param values the lists of numbers the modifies
     * @return the array of numbers in which the the negatives comes first in order of placement
     */
    public int[] copyWithNegativesFirst(int[] values)
    {
        int[] newValues = values;
        int change = 0;
        int placement=0;
        for (int i = newValues.length-1; i >= placement; i--)
        {
            if (newValues[i] < 0)
            {
                change = newValues[i];
                for (int j = i ; j > 0; j--)
                {
                    newValues[j] = newValues[j-1];

                }
                newValues[0] = change;
                placement++;
            }
        }
        return newValues;
    }

    /*
     * This copies the negatives of a series, and in order, puts them in the beginning
     * @param values the lists of numbers the modifies
     */
    public void negativesFirst(int[] values)
    {
        int change = 0;
        int placement=0;
        for (int i = values.length-1; i >= placement; i--)
        {
            if (values[i] < 0)
            {
                change = values[i];
                for (int j = i ; j > 0; j--)
                {
                    values[j] = values[j-1];

                }
                values[0] = change;
                placement++;
            }
        }
    }

        /*
     * This copies the negatives of a series, and in order, puts them in the beginning
     * @param values the lists of numbers the modifies
     */
    public void negativesFirst(ArrayList<Integer> values)
    {
        int counter = 0;
        for (int i = values.size()-1; i >= 0 + counter ;i--)
        {
            if (values.get(i) < 0)
            {
                values.add(0, values.remove(i));
                counter++;
            }
        }
    }

}