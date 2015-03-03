import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewResView {
	JFrame frame;
	JTextField checkin, checkout;
	JLabel error;
	JButton one, two;
	Container contentPane;
	public NewResView() {

		frame = new JFrame("Make a reservation");
		contentPane = frame.getContentPane();
		JLabel in = new JLabel("Check-in:", JLabel.LEFT);
		JLabel out = new JLabel("Check-out:", JLabel.LEFT);
		checkin = new JTextField("MM/DD/YY", 20);
		checkout = new JTextField("MM/DD/YY", 20);
		JPanel left = new JPanel();
		JPanel right = new JPanel();
		JPanel bottom = new JPanel();
		two = new JButton("$200");
		one = new JButton("$100");
		left.add(in);
		left.add(checkin);
		right.add(out);
		right.add(checkout);
		bottom.add(two);
		bottom.add(one);
		contentPane.setLayout(new BorderLayout());
		contentPane.add(left, BorderLayout.WEST);
		contentPane.add(right, BorderLayout.EAST);
		contentPane.add(bottom, BorderLayout.SOUTH);
		

		frame.setSize(400, 400);
		frame.pack();
		frame.setVisible(true);
	}

	public void close() {
		frame.setVisible(false);
		frame.dispose();
	}

	public Day getCheckIn() throws NumberFormatException {
		String[] dates = checkin.getText().split("/");
		int[] date = new int[3];
		int i = 0;
		for (String s : dates) {
			date[i] = Integer.parseInt(s);
			i++;
		}
		if (date[0] > 12 || date[1] > 31 || date[2] > 9999) {
			throw new NumberFormatException("Invalid date.");
		}
		return new Day(date[0], date[1], date[2]);
	}

	public Day getCheckOut() throws NumberFormatException {
		String[] dates = checkout.getText().split("/");
		int[] date = new int[3];
		int i = 0;
		for (String s : dates) {
			date[i] = Integer.parseInt(s);
			i++;
		}
		if (date[0] > 12 || date[1] > 31 || date[2] > 9999) {
			throw new NumberFormatException("Invalid date.");
		}
		return new Day(date[0], date[1], date[2]);
	}
	public void noRooms(){
		error = new JLabel("There are no rooms available on specified date(s)");
		contentPane.add(error, BorderLayout.SOUTH);
	}

	public void invalidDate(){
		error = new JLabel("Specified date(s) are invalid, use MM/DD/YY");
		contentPane.add(error, BorderLayout.SOUTH);
	}
	public void addTwoListener(ActionListener e) {
		two.addActionListener(e);
	}

	public void addOneListener(ActionListener e) {
		one.addActionListener(e);
	}
}
