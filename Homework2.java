package HomeworkChapter8;

class time {
	private int second; // 0 - 59

	// Time no-argument constructor:
	// initializes each instance variable to zero
	public time() {
		this(0); // invoke constructor with three arguments
	}

	// Time2 constructor: hour supplied, minute and second defaulted to 0
	public time(int hour) {
		if (hour < 0 || hour >= 24)
			throw new IllegalArgumentException("hour must be 0-23");

		this.second = hour * 3600; // invoke constructor with three arguments
	}

	// Time2 constructor: hour and minute supplied, second defaulted to 0
	public time(int hour, int minute) {
		if (hour < 0 || hour >= 24)
			throw new IllegalArgumentException("hour must be 0-23");

		if (minute < 0 || minute >= 60)
			throw new IllegalArgumentException("minute must be 0-59");

		this.second = hour * 3600 + minute * 60; // invoke constructor with three arguments
	}

	// Time2 constructor: hour, minute and second supplied
	public time(int hour, int minute, int second) {
		if (hour < 0 || hour >= 24)
			throw new IllegalArgumentException("hour must be 0-23");

		if (minute < 0 || minute >= 60)
			throw new IllegalArgumentException("minute must be 0-59");

		if (second < 0 || second >= 60)
			throw new IllegalArgumentException("second must be 0-59");

		this.second = hour * 3600 + minute * 60 + second;
	}

	// Time2 constructor: another Time2 object supplied
	public time(time time) {
		// invoke constructor with three arguments
		this(time.getHour(), time.getMinute(), time.getSecond());
	}

	// Set Methods
	// set a new time value using universal time;
	// validate the data
	public void setTime(int hour, int minute, int second) {
		if (hour < 0 || hour >= 24)
			throw new IllegalArgumentException("hour must be 0-23");

		if (minute < 0 || minute >= 60)
			throw new IllegalArgumentException("minute must be 0-59");

		if (second < 0 || second >= 60)
			throw new IllegalArgumentException("second must be 0-59");

		this.second = hour * 3600 + minute * 60 + second;
	}

	// validate and set hour
	public void setHour(int hour) {
		if (hour < 0 || hour >= 24)
			throw new IllegalArgumentException("hour must be 0-23");

		this.second = hour * 3600;
	}

	// validate and set minute
	public void setMinute(int minute) {
		if (minute < 0 || minute >= 60)
			throw new IllegalArgumentException("minute must be 0-59");

		this.second = minute * 60;
	}

	// validate and set second
	public void setSecond(int second) {
		if (second < 0 || second >= 60)
			throw new IllegalArgumentException("second must be 0-59");

		this.second = second;
	}

	// Get Methods
	// get hour value
	public int getHour() {
		int hour = second / 3600;
		return hour;
	}

	// get minute value
	public int getMinute() {
		int minute = second % 3600 / 60;
		return minute;
	}

	// get second value
	public int getSecond() {
		int seconds = (second % 3600) % 60;
		return seconds;
	}

	// convert to String in universal-time format (HH:MM:SS)
	public String toUniversalString() {
		return String.format("%02d:%02d:%02d", getHour(), getMinute(), getSecond());
	}

	// convert to String in standard-time format (H:MM:SS AM or PM)
	public String toString() {
		return String.format("%d:%02d:%02d %s", ((getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12),
				getMinute(), getSecond(), (getHour() < 12 ? "AM" : "PM"));
	}

}

public class Homework2 {

	public static void main(String[] args) {
		time t1 = new time(); // 00:00:00
		time t2 = new time(2); // 02:00:00
		time t3 = new time(21, 34); // 21:34:00
		time t4 = new time(12, 25, 42); // 12:25:42
		time t5 = new time(t4); // 12:25:42

		System.out.println("Constructed with:");
		displayTime("t1: all default arguments", t1);
		displayTime("t2: hour specified; default minute and second", t2);
		displayTime("t3: hour and minute specified; default second", t3);
		displayTime("t4: hour, minute and second specified", t4);
		displayTime("t5: Time2 object t4 specified", t5);

		// attempt to initialize t6 with invalid values
		try {
			time t6 = new time(27, 74, 99); // invalid values
		} catch (IllegalArgumentException e) {
			System.out.printf("%nException while initializing t6: %s%n", e.getMessage());
		}
	}

	// displays a Time2 object in 24-hour and 12-hour formats
	private static void displayTime(String header, time t) {
		System.out.printf("%s%n   %s%n   %s%n", header, t.toUniversalString(), t.toString());
	}
}


//8.5		(Modifying the Internal Data Representation of a Class) It would be perfectly reasonable
//for the Time2 class of Fig. 8.5 to represent the time internally as the number of seconds since 
//midnight rather than the three integer values hour, minute and second. Clients could use the same 
//public methods and get the same results. Modify the Time2 class of Fig. 8.5 to implement the time as
//the number of seconds since midnight and show that no change is visible to the clients of the class.