import java.util.ArrayList;

/** 
    Yet another grid implementation for testing. Probably not
    a lot of useful stuff here for 13a and 13b, but you are 
    welcome to peek.
*/
public class MysteryGrid implements Grid
{
   private int[] values;
   private int columns;

   public MysteryGrid(int rows, int columns)
   {
      values = new int[rows * columns];
      this.columns = columns;
   }

   public ArrayList<Location> occupiedLocations()
   {
      ArrayList<Location> result = new ArrayList<>();
      for (int i = 0; i < values.length; i++)
            if (values[i] != 0) result.add(new Location(i / columns, i % columns));
      return result;
   }

   public ArrayList<Location> validNeighbors(Location loc)
   {
      int i = loc.getRow() * columns + loc.getColumn();
      ArrayList<Location> result = new ArrayList<>();
      for (int dr = -1; dr <= 1; dr++)
         for (int dc = -1; dc <= 1; dc++)
         {
            int j = mod(i + dr * columns + dc, values.length);
            if (i != j) result.add(new Location(j / columns, j % columns));
         }
      return result;
   }

   public int get(Location loc)
   {
      int i = mod(loc.getRow() * columns + loc.getColumn(), values.length);
      return values[i];
   }

   public void set(Location loc, int value)
   {
      int i = mod(loc.getRow() * columns + loc.getColumn(), values.length);
      values[i] = value;
   }

   private static int mod(int m, int n)
   {
      int r = m % n;
      if (r >= 0) return r; else return r + n;
   }
}