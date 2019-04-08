package HomeworkChapter8;

enum TrafficLight {

	RED("40"), YELLOW("10"), GREEN("50");

	private final String duration;

	TrafficLight(String duration) {
		this.duration = duration;
	}

	public String getDuration() {
		return duration;
	}
}

public class Homework6 {

	public static void main(String[] args) {
		System.out.println("test all traffic Lights :");
		for (TrafficLight light : TrafficLight.values()) {
			System.out.printf("%-6s light have %-2s seconds duration.%n", light, light.getDuration());
		}
	}

}


//8.10 Write an enum type TrafficLight, 
//whose constants (RED, GREEN, YELLOW) 
//take one parameter—the duration of the light.
//Write a program to test the TrafficLight enum so that 
//it displays the enum constants and their durations.