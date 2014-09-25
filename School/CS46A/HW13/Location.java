public class Location
{
   private int row;
   private int column;
   
   public Location(int row, int column)
   {
      this.row = row;
      this.column = column;
   }

   public int getRow() { return row; }

   public int getColumn() { return column; }

   public boolean equals(Object otherObject)     
   {
      Location other = (Location) otherObject;
      return row == other.row && column == other.column;
   }

   public String toString() 
   {
      return "(" + row + "," + column + ")";
   }
}