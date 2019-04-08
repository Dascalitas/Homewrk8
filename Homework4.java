package HomeworkChapter8;

class Time2 {
	private int hour; // 0 - 23
	private int minute; // 0 - 59
	private int second; // 0 - 59

	// Time2 no-argument constructor:
	// initializes each instance variable to zero
	public Time2() {
		this(0, 0, 0); // invoke constructor with three arguments
	}

	// Time2 constructor: hour supplied, minute and second defaulted to 0
	public Time2(int hour) {
		this(hour, 0, 0); // invoke constructor with three arguments
	}

	// Time2 constructor: hour and minute supplied, second defaulted to 0
	public Time2(int hour, int minute) {
		this(hour, minute, 0); // invoke constructor with three arguments
	}

	// Time2 constructor: hour, minute and second supplied
	public Time2(int hour, int minute, int second) {
		if (hour < 0 || hour >= 24)
			throw new IllegalArgumentException("hour must be 0-23");

		if (minute < 0 || minute >= 60)
			throw new IllegalArgumentException("minute must be 0-59");

		if (second < 0 || second >= 60)
			throw new IllegalArgumentException("second must be 0-59");

		this.hour = hour;
		this.minute = minute;
		this.second = second;

		this.tick();
	}

	// Time2 constructor: another Time2 object supplied
	public Time2(Time2 time) {
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

		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}

	// validate and set hour
	public void setHour(int hour) {
		if (hour < 0 || hour >= 24)
			throw new IllegalArgumentException("hour must be 0-23");

		this.hour = hour;
	}

	// validate and set minute
	public void setMinute(int minute) {
		if (minute < 0 || minute >= 60)
			throw new IllegalArgumentException("minute must be 0-59");

		this.minute = minute;
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
		return hour;
	}

	// get minute value
	public int getMinute() {
		return minute;
	}

	// get second value
	public int getSecond() {
		return second;
	}

	public void tick() {

		if (second < 59)
			second++;
		else {
			second = 0;
		}
		incrementMinute();
	}

	public void incrementMinute() {

		if (minute < 59)
			minute++;
		else {
			minute = 0;
		}
		incrementHour();
	}

	public void incrementHour() {

		if (hour < 23)
			hour++;
		else
			hour = 0;
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

public class Homework4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Time2 time1 = new Time2(); // 00:00:00
		Time2 time2 = new Time2(2); // 02:00:00
		Time2 time3 = new Time2(21, 34); // 21:34:00
		Time2 time4 = new Time2(12, 25, 42); // 12:25:42
		Time2 time5 = new Time2(18, 20, 59); // 18:20:59
		Time2 time6 = new Time2(23, 59, 59); // 23:59:59

//		time1.tick();
//		time2.tick();
//		time3.tick();
//		time4.tick();
//		time5.tick();
//		time6.tick();

		displayTime("t1: all default arguments", time1);
		displayTime("t2: hour specified; default minute and second", time2);
		displayTime("t3: hour and minute specified; default second", time3);
		displayTime("t4: hour, minute and second specified", time4);
		displayTime("t5: with seconds on 59", time5);
		displayTime("t6: on next day", time6);
	}

	// displays a Time2 object in 24-hour and 12-hour formats
	private static void displayTime(String header, Time2 t) {
		System.out.printf("%s%n   %s%n   %s%n", header, t.toUniversalString(), t.toString());
	}
}


//8.7 (Enhancing Class Time2) Modify class Time2 of Fig. 8.5 to include a tick method that increments 
//the time stored in a Time2 object by one second. Provide method incrementMinute to increment the minute 
//by one and method incrementHour to increment the hour by one. Write a program that tests the tick method, 
//the incrementMinute method and the incrementHour method to ensure that they work correctly. Be sure to test the following cases:
//a) incrementing into the next minute,
//b) incrementing into the next hour and
//c) incrementing into the next day (i.e., 11:59:59 PM to 12:00:00 AM).