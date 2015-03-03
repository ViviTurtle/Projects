import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ManagerView {

	JFrame frame;
	CalendarViewPanel calendar;
	JLabel promptLabel;
	JComboBox<String> month;
	JComboBox<Integer> year;
	Container contentPane;
	JTextArea roomInfo;

	public ManagerView() {
		frame = new JFrame("Manager");
		calendar = new CalendarViewPanel();
		contentPane = frame.getContentPane();
		roomInfo = new JTextArea(7, 17);
		roomInfo.setEditable(false);
		month = new JComboBox<String>(new String[] { "January", "February",
				"March", "April", "May", "June", "July", "August", "October",
				"September", "November", "December" });
		year = new JComboBox<Integer>();
		int i = 2014;
		while (i >= 1582) {
			year.addItem(i);
			i--;
		}
		JPanel left = new JPanel();
		JPanel lefttop = new JPanel();
		lefttop.add(month);
		lefttop.add(year);

		left.setLayout(new BorderLayout());
		left.add(lefttop, BorderLayout.NORTH);
		left.add(calendar, BorderLayout.SOUTH);
		contentPane.setLayout(new FlowLayout());
		contentPane.add(left);
		contentPane.add(roomInfo);

		calendar.setVisible(true);
		frame.setSize(400, 400);
		frame.pack();
		frame.setVisible(true);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateCalendar() {
		calendar = new CalendarViewPanel(getMonth(), getYear());
		calendar.setVisible(true);
		frame.repaint();
	}

	public int getMonth() {
		return month.getSelectedIndex();
	}

	public int getYear() {
		return (int) year.getSelectedItem();
	}

	public int getDay() {
		return calendar.getSelectedCell();
	}

	public void setInfoText(String s) {
		roomInfo.setText(s);
	}

	public void addMouseListener(MouseListener a) {
		calendar.addMouseListener(a);
	}

	public void addMonthListener(ActionListener a) {
		month.addActionListener(a);
	}

	public void addYearListener(ActionListener a) {
		year.addActionListener(a);
	}

	public void close() {
		frame.setVisible(false);
		frame.dispose();
	}

}
