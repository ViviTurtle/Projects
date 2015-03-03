import java.awt.*;
import javax.swing.*;
public class Test {

		public static void main(String args[])
		{
			
			JFrame frame = new JFrame();
			
			frame.setSize(400, 200);
			JButton button = new JButton("This is a test");
			JTextField testField= new JTextField(200);
			testField.setText("Hai");
			frame.setLayout(new FlowLayout());
			frame.add(button);
			frame.add(testField);
			frame.pack();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			
		}

		
}
