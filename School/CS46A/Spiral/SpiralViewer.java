import javax.swing.JFrame;

/**
   Viewer for the spiral component.
*/
public class SpiralViewer
{
   public static void main(String[] args)
   {
      final int FRAME_WIDTH = 600;
      final int FRAME_HEIGHT = 600;
      JFrame frame = new JFrame();
      frame.setTitle("SpiralViewer");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      SpiralComponent component = new SpiralComponent();
      frame.add(component);
      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      frame.setVisible(true);
   }
}
