import java.util.ArrayList;
import java.util.Date;


public class User{
protected int userID;
protected String username;
ArrayList<Reservation> reservations = new ArrayList<Reservation>();

public void makeReservaton()
{

}

public int getUserID(){
	return userID;

}
public String getUsername(){
	return username;
}
}
