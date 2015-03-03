import java.awt.Container;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;


public class ConfirmResView {

	JFrame frame;
	JButton confirm, done;
	ArrayList<Room> res;
	JScrollPane available ;
	JList<JLabel> list ;

	/**
	 * Constructs frame with title "Cancel a reservation"
	 */
	public ConfirmResView() {

		frame = new JFrame("Confirm");
		Container contentPane = frame.getContentPane();
		res = new ArrayList<Room>();
		// scroll pane here, similar to available room view
		confirm = new JButton("Confirmed");
		done = new JButton("Transaction Done");
		list = new JList<JLabel>();
		available = new JScrollPane(list);
		contentPane.add(available);
		contentPane.add(confirm);
		contentPane.add(done);
		frame.setSize(400, 400);
		frame.pack();
		frame.setVisible(true);
	}
	
	public void changeConfirm(){
		confirm = new JButton("Make Another Reservation");
	}
	public Room getSelectedRoom(){
		return res.get(list.getSelectedIndex());
	}
	public void addAvailable(Room r){
		list.add(new JLabel(r.toString()));
		res.add(r);
		frame.repaint();
	}
	public void addConfirmListener(ActionListener e){
		confirm.addActionListener(e);
	}
	public void addDoneListener(ActionListener e){
		done.addActionListener(e);
	}

	public void close() {
		frame.setVisible(false);
		frame.dispose();
	}

}
