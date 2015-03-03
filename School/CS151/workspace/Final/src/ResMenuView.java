import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ResMenuView {
	JLabel promptLabel;
	JButton make, cancel, back;
	JFrame frame;

	public ResMenuView() {
		frame = new JFrame();
		Container contentPane = frame.getContentPane();
		promptLabel = new JLabel("Choose an option:", JLabel.CENTER);
		make = new JButton("Make a Reservation");
		cancel = new JButton("View/Cancel a Reservation");
		back = new JButton("Save and quit");
		contentPane.setLayout(new BorderLayout());
		contentPane.add(promptLabel, BorderLayout.CENTER);
		JPanel options = new JPanel();
		options.add(make);
		options.add(cancel);
		options.add(back);
		contentPane.add(options, BorderLayout.SOUTH);
		frame.setSize(400, 400);
		frame.pack();
		frame.setVisible(true);
	}

	public void addMakeListener(ActionListener e) {
		make.addActionListener(e);
	}

	public void addCancelListener(ActionListener e) {
		cancel.addActionListener(e);
	}

	public void addBackListener(ActionListener e) {
		cancel.addActionListener(e);
	}

	public void close() {
		frame.setVisible(false);
		frame.dispose();
	}

}
