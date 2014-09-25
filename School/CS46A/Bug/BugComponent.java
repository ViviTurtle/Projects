import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

public class BugComponent extends JComponent
{
   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;
      Bug2 bugsy = new Bug2();
      bugsy.turn(72);
      bugsy.move(5, g2);
      bugsy.turn(72);
      bugsy.move(5, g2);
      bugsy.turn(72);
      bugsy.move(5, g2);
      bugsy.turn(72);
      bugsy.move(5, g2);
      bugsy.turn(72);
      bugsy.move(5, g2);
   }
}