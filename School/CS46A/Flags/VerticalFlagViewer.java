import javax.swing.JFrame;

public class VerticalFlagViewer
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();
      frame.setSize(300, 400);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      VerticalFlagComponent component = new VerticalFlagComponent();
      frame.add(component);
      frame.setVisible(true);
   }
}
