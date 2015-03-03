import java.awt.Container;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AvailableRoomView {

	JFrame frame;
	JButton confirm, done;

	public AvailableRoomView() {

		frame = new JFrame("Confirm transaction");
		Container contentPane = frame.getContentPane();
		confirm = new JButton("Confirmed");
		done = new JButton("Transaction Done");
		// need Available Rooms box, scrollpane?
		contentPane.add(confirm);
		contentPane.add(done);
		frame.setSize(400, 400);
		frame.pack();
		frame.setVisible(true);
	}

	public void addDoneListener(ActionListener e) {
		done.addActionListener(e);
	}

	public void addConfirmListener(ActionListener e) {
		confirm.addActionListener(e);
	}

	public void close() {
		frame.setVisible(false);
		frame.dispose();
	}
}
