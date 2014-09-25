import javax.swing.JFileChooser;

public class AddressBookDemo
{
   public static void main(String[] args)
   {
      String filename = null;
      InOut in;
      if (args.length > 0) 
      {
         filename = args[0];
         in = new ConsoleInOut();
      }
      else
      {
         JFileChooser chooser = new JFileChooser();
         if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            filename = chooser.getSelectedFile().getPath();
         in = new WindowInOut();
      }
      if (filename == null) return;
      AddressBook book = new ArrayListAddressBook();
      book.load(filename);
      processCommands(in, book);
   }

   private static void processCommands(InOut in, AddressBook book)
   {
      String commands = "1: Add/Change Entry\n" 
         + "2: Look Up Entry\n"
         + "3: Remove Entry\n"
         + "4: Save Directory\n"
         + "5: Exit\n"
	 + "Enter Command: ";
      boolean done = false;
      while (!done)
      {
         String choice = in.nextLine(commands);
         if (choice.equals("1")) addChangeEntry(in, book);
         else if (choice.equals("2")) lookupEntry(in, book);
         else if (choice.equals("3")) removeEntry(in, book);
         else if (choice.equals("4")) book.save();
         else if (choice.equals("5")) done = true;
         else System.out.println("Not a valid option:" + choice);
      }
   }

   private static void addChangeEntry(InOut in, AddressBook book)
   {
      String name = in.nextLine("Enter name: ");
      String key = in.nextLine("Enter key: ");
      String value = in.nextLine("Enter value: ");
      String oldValue = book.put(name, key, value);
      if (oldValue == null)
         in.message("Entry added");
      else
         in.message("Entry updated");
   }

   private static void lookupEntry(InOut in, AddressBook book)
   {
      String name = in.nextLine("Enter name: ");
      String key = in.nextLine("Enter key: ");
      String value = book.get(name, key);
      if (value == null)
         in.message("No entry");
      else
         in.message("Value: " + value);
   }

   private static void removeEntry(InOut in, AddressBook book)
   {
   }
}
