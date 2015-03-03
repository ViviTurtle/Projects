import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class CalendarViewPanel extends JPanel {
	//JPanel panel;
	JTable table;
//	JComboBox month, year;
	GregorianCalendar now;

	public CalendarViewPanel(int month, int year) {
		super(new GridLayout(1,0));
		table = new JTable(7, 7);
		now = new GregorianCalendar(year,month,1);

		// first day of month
		GregorianCalendar fdom = new GregorianCalendar(now.get(Calendar.YEAR),
				now.get(Calendar.MONTH), 1);

		// last day of this month
		GregorianCalendar ldom = new GregorianCalendar(now.get(Calendar.YEAR),
				now.get(Calendar.MONTH), 1);
		ldom.roll(Calendar.DAY_OF_MONTH, false);

		// day of week of first day of month
		int dowofdom = fdom.get(Calendar.DAY_OF_WEEK);

		fdom.roll(Calendar.MONTH, false);
		fdom.roll(Calendar.DAY_OF_MONTH, false);

		// last day of last month
		int ldolm = fdom.get(Calendar.DAY_OF_MONTH);

		int x = 0, y = 0, i = 1, n = 1;

		// top left corner of table = last day of last month - day of week of
		// current day of month - 2
		int tlcot = ldolm - dowofdom + 2;

		table.setValueAt("S", 0, 0);
		table.setValueAt("M", 0, 1);
		table.setValueAt("T", 0, 2);
		table.setValueAt("W", 0, 3);
		table.setValueAt("T", 0, 4);
		table.setValueAt("F", 0, 5);
		table.setValueAt("S", 0, 6);

		while (y < 6) {
			while (x < 7) {
				table.setValueAt(
						(tlcot <= ldolm) ? "" : (i <= ldom
								.get(Calendar.DAY_OF_MONTH)) ? i : "", y + 1, x);
				if (tlcot <= ldolm) {
					tlcot++;
				} else if (i <= ldom.get(Calendar.DAY_OF_MONTH)) {
					i++;
				} else {
					n++;
				}
				x++;
			}
			x = 0;
			y++;
		}
		add(table);
		table.setCellSelectionEnabled(true);
	    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}

	public CalendarViewPanel() {
		super(new GridLayout(1,0));
		table = new JTable(7, 7);
		now = new GregorianCalendar();

		// first day of month
		GregorianCalendar fdom = new GregorianCalendar(now.get(Calendar.YEAR),
				now.get(Calendar.MONTH), 1);

		// last day of this month
		GregorianCalendar ldom = new GregorianCalendar(now.get(Calendar.YEAR),
				now.get(Calendar.MONTH), 1);
		ldom.roll(Calendar.DAY_OF_MONTH, false);

		// day of week of first day of month
		int dowofdom = fdom.get(Calendar.DAY_OF_WEEK);

		fdom.roll(Calendar.MONTH, false);
		fdom.roll(Calendar.DAY_OF_MONTH, false);

		// last day of last month
		int ldolm = fdom.get(Calendar.DAY_OF_MONTH);

		int x = 0, y = 0, i = 1, n = 1;

		// top left corner of table = last day of last month - day of week of
		// current day of month - 2
		int tlcot = ldolm - dowofdom + 2;

		table.setValueAt("S", 0, 0);
		table.setValueAt("M", 0, 1);
		table.setValueAt("T", 0, 2);
		table.setValueAt("W", 0, 3);
		table.setValueAt("T", 0, 4);
		table.setValueAt("F", 0, 5);
		table.setValueAt("S", 0, 6);

		while (y < 6) {
			while (x < 7) {
				table.setValueAt(
						(tlcot <= ldolm) ? "" : (i <= ldom
								.get(Calendar.DAY_OF_MONTH)) ? i : "", y + 1, x);
				if (tlcot <= ldolm) {
					tlcot++;
				} else if (i <= ldom.get(Calendar.DAY_OF_MONTH)) {
					i++;
				} else {
					n++;
				}
				x++;
			}
			x = 0;
			y++;
		}
		add(table);

		table.setCellSelectionEnabled(true);
	    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

	}
	public int getSelectedCell(){
		return (int) table.getValueAt(table.getSelectedRow(), table.getSelectedColumn());
	}
	public void addMouseListener(MouseListener e){
		table.addMouseListener(e);
	}
	public void setVisible(boolean v) {
		table.setGridColor(Color.WHITE);
		table.setVisible(v);
		super.setVisible(v);
		super.setOpaque(v);
	}

}
