// This class makes an array of a sequence which can be then tested and sorted
public class Sequence
{
    private int[] values;
    /*
     * This creates the actual array of sequences
     * @param int... the sequence of values
     */
    public Sequence(int... values)
    {
        this.values = values;
    }

    /*
     * tests if the sequence is sorted in increasing order
     * @return true if sorted in increasing order
     */
    public boolean isSorted()
    {
        for (int i = 1; i<= values.length-1; i++)
        {
            if (values[i-1] > values[i])
            {
                return false;
            }

        }
        return true;
    }

    /*
     * Gives the first index when the sequence decreases
     * @return the index when it decreses or -1 if already sorted
     */
    public int firstDecreasingPosition()
    {
        int decrease = -1;
        for (int i = 1; i<= values.length-1; i++)
        {
            if (values[i-1] > values[i])
            {
                decrease = i-1;
                i = values.length-1;
            }

        }
        return decrease;
    }

    /*
     * Sorts the sequence in increasing fashion
     */
    public void sort()
    {
        int decrease = -1;
        for (int i = 1; i<= values.length-1; i++)
        {
            if (!this.isSorted())
            {
                decrease = this.firstDecreasingPosition();
                this.swap(decrease);
                i--;
            }         
        }
    }

    /*
     * This swaps the two variables at a certain index with the one above it
     * @param index, the index where the swap takjes place
     */
    public void swap(int index)
    {
        int change = values[index];
        values[index] = values [index + 1];
        values[index + 1] =  change;
    }

    /*
     * returns the String with all values
     * @return A string of all the values
     */
    public String toString()
    {   String written = "";
        for (int i = 0; i <= values.length-1; i++)
            if (i == values.length-1)
            {
                written += values[i];
            }
            else
            {
                written += values[i]+",";
        }

        return written;
    }
}