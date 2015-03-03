import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * The hotel controller, controls the UI
 * @author Kairan Hsu
 *
 */
public class HotelController {

	MainView main;
	UserIDView useridview;
	ManagerView manager;
	ResMenuView reservation;
	NewAccountView newaccount;
	NewResView newres;
	ViewCancelView cancelres;
	// HotelModel model;
	CalendarModel calendar;
	ConfirmResView confirm;
	String toSave;
	int userIndex, userID;

	/**
	 * Creates a HotelController
	 * 
	 * @param v
	 *            view of the initial window
	 */
	public HotelController(MainView v) {
		main = v;
		GregorianCalendar now = new GregorianCalendar();
		calendar = new CalendarModel(now.get(Calendar.MONTH),
				now.get(Calendar.DAY_OF_MONTH), now.get(Calendar.YEAR));

		// load data into model here

		main.addGuestListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				main.setVisible(false);
				useridview = new UserIDView();
				promptUserID();
			}
		});

		main.addManagerListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				main.setVisible(false);
				showManager();
			}
		});
	}

	/**
	 * Creates a HotelController
	 * 
	 * @param v
	 *            view of initial window
	 * @param m
	 *            a CalendarModel to use in Manager
	 */
	public HotelController(MainView v, CalendarModel m) {
		main = v;
		calendar = m;

		// load data into model here

		main.addGuestListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				main.setVisible(false);
				useridview = new UserIDView();
				promptUserID();
			}
		});

		main.addManagerListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				main.setVisible(false);
				showManager();
			}
		});
	}

	/**
	 * gets the controller's calendar
	 * 
	 * @return the calendar model
	 */
	public CalendarModel getCalendarModel() {
		return calendar;
	}

	/**
	 * shows the Manager's UI
	 */
	public void showManager() {

		manager = new ManagerView();
		manager.addMonthListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.updateCalendar();
			}
		});
		manager.addYearListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.updateCalendar();
			}
		});
		manager.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				manager.setInfoText(calendar.listReservationsOn(new Day(manager
						.getMonth() + 1, manager.getDay(), manager.getYear())));

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});
	}

	/**
	 * closes windows and goes back to main view
	 */
	public void backToMain() {
		try {
			useridview.close();
			reservation.close();
			newaccount.close();
			manager.close();
		} catch (NullPointerException e) {
		}
		main.setVisible(true);
	}

	/**
	 * prompts the user for his userID
	 */
	public void promptUserID() {
		useridview.addLoginListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = useridview.getUserText();
				try {
					userIndex = System.getUserIndex(Integer.parseInt(s));
				} catch (NumberFormatException ex) {
					useridview.invalidID();
					userIndex = -2;
				}
				if (userIndex > 0) {
					userID = Integer.parseInt(s);
					reservation = new ResMenuView();

				} else if (userIndex == -2) {
					useridview.invalidID();
					promptUserID();
				} else if (userIndex == -1) {

					newaccount = new NewAccountView(true);
					createNewAccount();
				}
			}
		});
		useridview.addCancelListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// close userid and go back to mainview

				backToMain();
			}
		});
	}

	/**
	 * Opens the reservation menu for the user
	 */
	public void openResMenu() {
		reservation.addMakeListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		reservation.addCancelListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		reservation.addBackListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				backToMain();
			}
		});
	}

	/**
	 * opens the dialog to create a new account
	 */
	public void createNewAccount() {

		newaccount.addEnterListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newName = newaccount.getUsername();
				// check if newid and newname are valid
				int id = -1;
				try {

					id = Integer.parseInt(newaccount.getUserID());
				} catch (NumberFormatException ex) {

				}
				if (id != -1) {
					System.addGuest(id, newName);
					newaccount.close();
					viewReservationOptions();
				} else {
					newaccount = new NewAccountView(false);
					createNewAccount();
				}
			}
		});
		newaccount.addCancelListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newaccount.close();
				useridview = new UserIDView();
				promptUserID();
			}
		});
	}

	/**
	 * Opens the reservation options for the user
	 */
	public void viewReservationOptions() {
		reservation = new ResMenuView();
		reservation.addMakeListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewNewRes();
			}
		});
		reservation.addCancelListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reservation.close();
				viewCancelMenu();
			}
		});
		reservation.addBackListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reservation.close();
			}
		});

	}

	/**
	 * Opens the dialog to make a new reservation
	 */
	public void viewNewRes() {

		newres = new NewResView();
		newres.addOneListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Day start = new Day(1, 1, 1582);
				Day end = new Day(1, 1, 1582);
				try {
					start = newres.getCheckIn();
					end = newres.getCheckOut();
					if (calendar.availableRooms(80, start, end).size() > 0) {
						confirm = new ConfirmResView();
						showConfirmation(80, start, end);
					} else {
						newres.noRooms();
					}
				} catch (NumberFormatException ex) {
					newres.invalidDate();
				}
			}
		});
		newres.addTwoListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Day start = new Day(1, 1, 1582);
				Day end = new Day(1, 1, 1582);
				try {
					start = newres.getCheckIn();
					end = newres.getCheckOut();
					if (calendar.availableRooms(200, start, end).size() > 0) {
						confirm = new ConfirmResView();
						showConfirmation(200, start, end);
					} else {
						newres.noRooms();
					}
				} catch (NumberFormatException ex) {
					newres.invalidDate();
				}
			}
		});
	}

	/**
	 * Opens a confirmation window for a specified reservation
	 * 
	 * @param price
	 *            price of the reservation
	 * @param start
	 *            start date of the reservation
	 * @param end
	 *            ending date of the reservation
	 */
	public void showConfirmation(final int price, final Day start, final Day end) {

		ArrayList<Room> rooms = calendar.availableRooms(price, start, end);
		for (Room r : rooms) {
			confirm.addAvailable(r);
		}
		confirm.addConfirmListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				calendar.makeReservation(confirm.getSelectedRoom(), start, end,
						userID);
				toSave = calendar.Reservation2Data(calendar.getReservations()
						.size() - 1);
				confirm.changeConfirm();
				confirm.addConfirmListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						viewNewRes();
						confirm.close();

					}

				});
			}

		});
		confirm.addDoneListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				viewReservationOptions();
				confirm.close();

			}

		});
	}

	/**
	 * shows the menu to cancel or view reservations
	 */
	public void viewCancelMenu() {
		cancelres = new ViewCancelView();

		ArrayList<Reservation> all = calendar.getReservations();
		for (Reservation r : all) {
			if (r.getUserID() == userID) {
				cancelres.addRes(r);
			}
		}
		cancelres.addCancelListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (cancelres.getSelected() > -1) {
					calendar.cancelReservation(cancelres.getRes().get(
							cancelres.getSelected()));
					cancelres.cancel(cancelres.getSelected());
				}
			}

		});
		cancelres.addBackListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				viewReservationOptions();
				cancelres.close();

			}

		});
	}

}
