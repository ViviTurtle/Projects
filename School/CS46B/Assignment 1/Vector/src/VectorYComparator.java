//No Package Statement Please!!!

import java.util.Comparator;

public class VectorYComparator implements Comparator 
{
    public int compare(Object other, Object other2)
{
Vector v1 = (Vector) other;
Vector v2 = (Vector) other2;
if (v1.getY() > v2.getY())
{
return 1;
}
else if (v1.getY() < v2.getY())
{
return -1;
}
else return 0;
}


}




