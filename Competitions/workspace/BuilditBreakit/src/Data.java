public class Data {

	private String name;
	private long roomID;
	private boolean isGuest;
	private long arrivalTime;
	private long leaveTime;

	public Data(String name, long roomID, boolean isGuest, long arrivalTime) {
		this.name = name;
		this.roomID = roomID;
		this.isGuest = isGuest;
		this.arrivalTime = arrivalTime;
		this.leaveTime = -1;

	}

	public Data(String name, boolean isGuest, long arrivalTime) {
		this.name = name;
		this.roomID = -1;
		this.isGuest = isGuest;
		this.arrivalTime = arrivalTime;
		this.leaveTime = -1;
	}

	public Data(String name, long roomID, boolean isGuest, long arrivalTime,
			long leaveTime) {
		this.name = name;
		this.roomID = roomID;
		this.isGuest = isGuest;
		this.arrivalTime = arrivalTime;
		this.leaveTime = leaveTime;
	}

	public String getName() {
		return name;
	}

	public long getRoom() {
		return roomID;
	}

	public boolean isGuest() {
		return isGuest;
	}

	public long getArrivalTime() {
		return arrivalTime;
	}

	public long getLeaveTime() {
		return leaveTime;
	}

	public void setLeaveTime(long time) {
		leaveTime = time;
	}

	public String toString() {
		String answer = name;
		answer += "_" + roomID;
		answer += "_" + isGuest;
		answer += "_" + arrivalTime;
		answer += "_" + leaveTime;
		return answer;
	}
}
