import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class UserIDView extends JFrame{
	

	JFrame frame  ;
	JPanel mainPanel  ;
	JLabel promptLabel ;
	JButton login, cancel  ;
	JTextField idField ;
	Container contentPane;
public UserIDView(){
	frame = new JFrame("Guest");
	mainPanel = new JPanel();
	
	promptLabel = new JLabel("Enter your user ID:",JLabel.CENTER);
	idField = new JTextField(12);

	contentPane = frame.getContentPane();
	contentPane.setLayout(new BorderLayout());
	contentPane.add(promptLabel,BorderLayout.NORTH);
	login = new JButton("Login");
	cancel = new JButton("Cancel");
	JPanel bottom = new JPanel();
	bottom.add(idField);
	bottom.add(login);
	bottom.add(cancel);
	contentPane.add(bottom,BorderLayout.SOUTH);
	frame.setSize(400, 400);
	frame.pack();
	frame.setVisible(true);
}

public void invalidID(){
	promptLabel.setText("Invalid user ID");
	super.repaint();
}

public void close(){
	frame.setVisible(false);
	frame.dispose();
}
public String getUserText(){
	return idField.getText();
}

public void addLoginListener(ActionListener a) {
	login.addActionListener(a);
}

public void addCancelListener(ActionListener a) {
	cancel.addActionListener(a);
}


}
