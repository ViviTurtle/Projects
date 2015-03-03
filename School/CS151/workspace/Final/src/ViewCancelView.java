import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class ViewCancelView {
	ArrayList<Reservation> lor;
	JFrame frame;
	JButton cancel, back;
	JTextArea info;
	JScrollPane res;
	JList list;
	public ViewCancelView(){
		lor = new ArrayList<Reservation>();
		frame = new JFrame("Select to view or cancel");
		list = new JList<JLabel>();
		res = new JScrollPane(list);
		info = new JTextArea(" ");
		cancel = new JButton("Cancel this Reservation");
		back = new JButton("Back to menu");
		Container contentPane = frame.getContentPane();
		JPanel top = new JPanel();
		JPanel bottom = new JPanel();
		top.setLayout(new BorderLayout());
		bottom.setLayout(new BorderLayout());
		top.add(res, BorderLayout.WEST);
		top.add(info, BorderLayout.EAST);
		bottom.add(cancel, BorderLayout.WEST);
		bottom.add(back, BorderLayout.EAST);
		contentPane.setLayout(new BorderLayout());
		contentPane.add(top, BorderLayout.NORTH);
		contentPane.add(bottom,BorderLayout.SOUTH);
		frame.setSize(400,400);
		frame.pack();
		frame.setVisible(true);
		
	}
	public void addCancelListener(ActionListener e){
		cancel.addActionListener(e);
	}
	public void addBackListener(ActionListener e){
		back.addActionListener(e);
	}
	public void setText(String s){
		info.setText(s);
	}
	public void addRes(Reservation r){
		list.add(new JLabel(r.toString()));
		
	}
	public int getSelected(){
		return list.getSelectedIndex();
	}
	public ArrayList<Reservation> getRes(){
		return lor;
	}
	public void cancel(int index){
		list.remove(index);
		lor.remove(index);
	}
	/**
	 * Closes the frame
	 */
	public void close() {
		frame.setVisible(false);
		frame.dispose();
	}
}
