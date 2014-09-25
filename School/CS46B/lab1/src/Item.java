public class Item implements Comparable
{
   private String key;
   private String value;
   private String name;

   public Item(String key, String value, String name) {
      this.key = key;
      this.value = value;
      this.name = name;
   }
   
   

   public String getName() {
      return name;
   }

   public String getValue() {
      return value;
   }

   public void setValue(String value) {
      this.value = value;
   }

   public String getKey() {
      return key;
   }

   @Override
   public int compareTo(Object o)
   {
      Item other = (Item) o;
      
      if (name.equals(other.getName()))
              {
                 if (key.equals(other.getKey()))
                 {
                    return value.compareTo(other.value);
                 }
                  return key.compareTo(other.getKey());
               }
      return name.compareTo(other.getName());
     }
   
          public String toString ()
       {
          String tString = name + key + value;
          return tString;
       }
         
          public boolean equals(Item anItem)
          {
             if (name.equals(anItem.name) && key.equals(anItem.key) && value.equals(anItem.value))
             {
                return true;
             }
             else return false;
          }
   }



