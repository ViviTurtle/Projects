import java.awt.Graphics2D;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import javax.swing.ImageIcon;

public class Dog
{
   public Dog(int x, int y)
   {
      this.x = x;
      this.y = y;
      try 
      {
         // image = ImageIO.read(new File("dog.png"));
         // NetBeans won't read the file
         image = new ImageIcon(getClass().getResource("dog.png")).getImage();
      }
      catch (Exception ex)
      {
         System.out.println("Can't read image.");
      }
   }


   public void draw(Graphics2D g2)
   {
      g2.drawImage(image, x, y, null);
   }

   private int x;
   private int y;
   private Image image;
}
