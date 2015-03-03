import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The main frame where user picks if they are guest or manager
 */
public class MainView extends JFrame{

	JFrame frame ;
	JLabel promptLabel ;
	JButton guestButton ;
	JButton managerButton ;

	/**
 	* Constructs a frame with Guest and Manager buttons
 	*/
	public MainView() {
		frame = new JFrame("Hotel Manager");
		JLabel promptLabel = new JLabel("User type?", JLabel.CENTER);
		guestButton = new JButton("Guest");
		managerButton = new JButton("Manager");
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new BorderLayout());

		JPanel options = new JPanel();
		options.add(guestButton);
		options.add(managerButton);

		contentPane.add(promptLabel, BorderLayout.CENTER);
		contentPane.add(options, BorderLayout.SOUTH);
		frame.setSize(400, 400);
		frame.pack();
		frame.setVisible(true);
	}

	/**
 	* Sets the visibility of the frame
 	* @param b to false to make frame not visible, true to make it visible
 	*/
	public void setVisible(boolean b){
		frame.setVisible(b);
	}
	
	/**
	 * Adds an ActionListener to the Guest Button
	 * @param a the ActionListener to add
 	*/
	public void addGuestListener(ActionListener a) {
		guestButton.addActionListener(a);
	}

	/**
 	* Adds an ActionListener to the Manager Button
 	* @param a the ActionListener to add
 	*/
	public void addManagerListener(ActionListener a) {
		managerButton.addActionListener(a);
	}
	
	


}
