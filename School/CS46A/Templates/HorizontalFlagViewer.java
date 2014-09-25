import javax.swing.JFrame;

public class HorizontalFlagViewer
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();
      frame.setSize(300, 400);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      HorizontalFlagComponent component = new HorizontalFlagComponent();
      frame.add(component);
      frame.setVisible(true);
   }
}
