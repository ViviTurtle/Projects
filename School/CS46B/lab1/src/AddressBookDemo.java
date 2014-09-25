
import javax.swing.JFileChooser;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class AddressBookDemo {
   

public static void main(String[] args) 
{
JFileChooser chooser = new JFileChooser();
int result = chooser.showOpenDialog(null);
if (result == JFileChooser.APPROVE_OPTION) 
{
   String filename = chooser.getSelectedFile().getPath();
   AddressBook book = new ArrayListAddressBook();
   book.load(filename);
   System.out.println(book.get("Horstmann","Phone"));
   System.out.println(book.getFirst());

}   
}
}  