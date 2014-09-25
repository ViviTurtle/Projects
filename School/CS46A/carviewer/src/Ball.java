
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.Color;
public class Ball implements Drawable,Moveable
{
    public int x;
    public int y;
    public int DIAMETER;
    public Ball (int x, int y, int WIDTH, int HEIGHT)
    {
        this.x = x;
        this.y = y;
        this.DIAMETER = WIDTH;
    }
    
   public void draw(Graphics2D g2)
   {
        g2.setColor(Color.RED);
        g2.fill(new Ellipse2D.Double(x, y, DIAMETER, DIAMETER));
        g2.setColor(Color.BLACK);   
   }
   
   public void move()
   {
       y = y++;
   }
   
}
