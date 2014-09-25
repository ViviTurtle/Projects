import javax.swing.JFrame;

public class Problem2Viewer
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      frame.setSize(800, 100);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      Problem2Component component = new Problem2Component(10, 60);
      frame.add(component);

      frame.setVisible(true);
   }
}
