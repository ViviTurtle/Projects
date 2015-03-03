import java.awt.Container;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

/**
 * A frame for cancelling reservations
 */
public class CancelResView {
	JFrame frame;
	JButton view, back;
	JScrollPane res;
	ArrayList<Reservation> list;

	/**
	 * Constructs frame with title "Cancel a reservation"
	 */
	public CancelResView() {

		frame = new JFrame("Cancel a reservation");
		Container contentPane = frame.getContentPane();
		list = new ArrayList<Reservation>();
		// scroll pane here, similar to available room view
		res = new JScrollPane();
		view = new JButton("View");
		back = new JButton("Back");
		contentPane.add(view);
		contentPane.add(back);
		frame.setSize(400, 400);
		frame.pack();
		frame.setVisible(true);
	}

	public void addRes(Reservation r) {
		list.add(r);
		res.add(new JLabel(r.toString()));
	}

	public void addViewListener(){
		
	}
	/**
	 * Closes the frame
	 */
	public void close() {
		frame.setVisible(false);
		frame.dispose();
	}
}
