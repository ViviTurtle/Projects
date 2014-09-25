/**
   A class whose objects emit personalized greetings.
*/
public class Greeter
{
   /**
      Constructs a greeter that greets the world.
   */
   public Greeter()
   {
      name = "World";
   }

   /**
      Constructs a greeter.
      @param aName the name of the person to be greeted
   */
   public Greeter(String aName)
   {
      name = aName;
   }

   /**
      Makes a "Hello" greeting.
      @return the greeting
   */
   public String sayHello()
   {
      String message = "Hello, " + name + "!";
      return message;
   }

   /**
      Makes a "Goodbye" greeting.
      @return the greeting
   */
   public String sayGoodbye()
   {
      String message = "Goodbye, " + name + "!";
      return message;
   }

   private String name;
}
