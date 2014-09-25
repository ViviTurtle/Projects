// This class represents the patterns of the Mens restroom, has the number of stalls, location of a person, and adding and removing people
public class MensRoom
{
    public static final int TO_GET_MIDDLE = 2;
    public String[] mensRoom;
    public int totalStalls = 0;
    public int amountPeople; //keeps track of how many people are in the bathroom
    /*
     * This constructs the Mens restroom 
     * @param totalNumberOfStalls the total stalls in the bathroom
     */
    public MensRoom(int totalNumberOfStalls)
    {
        totalStalls= totalNumberOfStalls;
        mensRoom = new String[totalNumberOfStalls];
        amountPeople = 0;
        for (int i = 0; i<= mensRoom.length-1; i++)
        {
            mensRoom[i] = "0";
        }
    }

    /*
     * This returns the Mens restroom visually where "_" is an empty stall and "X" is a used stall
     * @return the visual representation of the restroom
     */
    public String toString()
    {
        String aMensRoom = "";
        for (int i = 0; i <= totalStalls-1; i++)
        {

            if (mensRoom[i].equals("0"))
            {
                aMensRoom += "_";
            }
            else aMensRoom += "X";
        }
        return aMensRoom;

    }

    /*
     * This adds a person the restroom. He will go to the middle of the longest series of empty stalls closest to the door.
     * @return the location of the stall he went into
     */
    public int add()
    {   
        int location = -1;
        int i =0;
        int longestSeries = 0;
        int beginningSeries= -1; //the beginning of the test series
        int testingSeries = 0; //the end of the test series
        int aBeginSeries = 0; // the beginning of the longest series
        if (amountPeople == 0)
        {
            if (totalStalls % 2 == 0) //if its even
            {
                location = (totalStalls -1 -1)/TO_GET_MIDDLE; //subtract one stall because it starts at zero, and subtract one more to reach the floor otherwise known as the stall closester to the door. Divides by two to reach the "middle" of the stalls
            }
            else
            {
                location = (totalStalls-1)/TO_GET_MIDDLE; //subtracts one stall because it starts at zero Divides by two to reach the "middle" of the stalls
            }

        }
        else
        {
            while (i <= mensRoom.length-1)
            {
                if (mensRoom[i].equals("0"))
                {
                    beginningSeries = i;
                    for (int j = i; j <= mensRoom.length-1; j++)
                    {
                        if (mensRoom[j].equals("X"))
                        {
                            i = j;
                            j = mensRoom.length-1;
                        }
                        else i++;
                    }
                    testingSeries = i-beginningSeries;
                    if (testingSeries > longestSeries)
                    {
                        longestSeries=testingSeries;
                        aBeginSeries = beginningSeries;
                    }
                }
                else i+=1;
            }
            if (longestSeries % 2 == 0) //if its even
            {
                location = aBeginSeries + ((longestSeries -1-1)/TO_GET_MIDDLE); //subtract one stall because it starts at zero, and subtract one more to reach the floor otherwise known as the stall closester to the door. Divides by two to reach the "middle" of the stalls
            }
            else
            {
                location = aBeginSeries +((longestSeries-1)/TO_GET_MIDDLE); //subtracts one stall because it starts at zero Divides by two to reach the "middle" of the stalls
            }
        }

        if (location >= 0)
        {
            mensRoom[location] = "X";
            amountPeople++;
        }
        return location;
    }

    /*
     * removes the person at a certain stall
     * @param i the stall which a person is to be removed
     * return true if there is a person on that stall
     */
    public boolean remove(int i)
    {
        if (i > mensRoom.length-1)
        {
            return false;
        }
        else if (mensRoom[i].equals("X"))
        {
            mensRoom[i] = "0";
            amountPeople--;
            return true;
        }

        else return false;
    }
}