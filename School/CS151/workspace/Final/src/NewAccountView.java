import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class NewAccountView {
	JLabel label;
	JButton enter,cancel;
	JTextField username;
	JTextField userid;
	JFrame frame;
public NewAccountView(boolean first){
	frame = new JFrame("Create a new account");
	Container contentPane = frame.getContentPane();
	
	label = new JLabel((first)?"The ID is unrecognized, to create a new account, enter a username and a user id:":"User ID invalid, please try again.");
	username = new JTextField("username",20);
	userid = new JTextField("user id",20);
	enter = new JButton("Enter");
	cancel = new JButton("Cancel");
	contentPane.add(label,BorderLayout.NORTH);
	JPanel top = new JPanel();
	JPanel bottom = new JPanel();
	top.add(username,BorderLayout.NORTH);
	top.add(userid,BorderLayout.SOUTH);
	bottom.add(enter);
	bottom.add(cancel);
	contentPane.add(label,BorderLayout.NORTH);
	contentPane.add(top,BorderLayout.CENTER);
	contentPane.add(bottom,BorderLayout.SOUTH);
	
	frame.setSize(400, 400);
	frame.pack();
	frame.setVisible(true);
}

public String getUsername(){
	return username.getText();
}
public String getUserID(){
	return userid.getText();
}

public void addEnterListener(ActionListener e){
	enter.addActionListener(e);
}
public void addCancelListener(ActionListener e){
	cancel.addActionListener(e);
}

public void close(){
	frame.setVisible(false);
	frame.dispose();
}

}
