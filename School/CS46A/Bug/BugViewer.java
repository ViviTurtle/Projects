import javax.swing.JFrame;

public class BugViewer
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();
      frame.setSize(300, 400);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      BugComponent component = new BugComponent();
      frame.add(component);
      frame.setVisible(true);
   }
}