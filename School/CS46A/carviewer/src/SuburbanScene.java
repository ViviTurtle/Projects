
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JComponent;

/**
   This component draws two car shapes.
*/
public class SuburbanScene extends JComponent
{  
    public ArrayList<Drawable> drawables;
    private static final int TEST_AMOUNT = 5;
    private static final int CAR_HEIGHT = 30;
    public SuburbanScene()
    { 
        drawables = new ArrayList<Drawable>();
        for (int i = 0; i <= TEST_AMOUNT-1; i++)
        {
            drawables.add(new Car(0, CAR_HEIGHT*i));
            drawables.add(new House(100, 80*i+80, 50, 50));
            drawables.add(new Ball(150, 50* i, 30,30 ));
        }
    }

    
   public void paintComponent(Graphics g)
   {  
      Graphics2D g2 = (Graphics2D) g;
      for (int i = 0; i<= drawables.size()-1; i++)
      {
          if (drawables.get(i) instanceof Moveable) 
          { 
                Moveable moving = (Moveable) drawables.get(i);
                moving.move();
                                Drawable d =(Drawable) moving;
                d.draw(g2);
          }
          else drawables.get(i).draw(g2);
      }
      

   }
}