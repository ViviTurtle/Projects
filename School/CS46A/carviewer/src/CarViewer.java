import javax.swing.JFrame;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarViewer
{
   public static void main(String[] args)
   {
      final JFrame frame = new JFrame(); // Add final to the variable declaration  

      frame.setSize(300, 400);
      frame.setTitle("Two cars");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      SuburbanScene component = new SuburbanScene();
      frame.add(component);

       frame.setVisible(true);
      class TimerListener implements ActionListener
      { 
         public void actionPerformed(ActionEvent event)
         {
            frame.repaint();
         }
      }
      ActionListener listener = new TimerListener();
      Timer t = new Timer(100, listener); // 100 milliseconds between actions
      t.start();
   }
} 
