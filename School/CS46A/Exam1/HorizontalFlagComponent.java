import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

public class HorizontalFlagComponent extends JComponent
{
   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;
      HorizontalFlag italianFlag = new HorizontalFlag(100, 100, 90,
         Color.GREEN, Color.WHITE, Color.RED);
      italianFlag.draw(g2);
      HorizontalFlag belgianFlag = new HorizontalFlag(200, 200, 90,
         Color.BLACK, Color.YELLOW, Color.RED);
      belgianFlag.draw(g2);
   }
}
