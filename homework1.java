package HomeworkChapter8;

import java.util.Scanner;

public class homework1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println(
				"please enter the length and width of your rectangle (but not more than 20 and less than 0) :");
		Rectangle one = new Rectangle(input.nextInt(), input.nextInt());

		if (one.getLength() == 0)
			System.out.println("You enter wrong length.");

		else if (one.getWidth() == 0)
			System.out.println("You enter wrong width");

		else
			System.out.printf("the area of your rectangle is %.2f%n; and perimeter is %.2f%n", one.area(),
					one.perimeter());
	}

}

class Rectangle {

	private int length;
	private int width;

	Rectangle(int length, int width) {

		this.length = length;
		this.width = width;
	}

	int getLength() {
		return length;
	}

	void setLength(int length) {
		if (length > 0 && length < 20)
			this.length = length;
		else
			this.length = 0;
	}

	int getWidth() {
		return width;
	}

	void setWidth(int width) {
		if (width > 20 && width < 0)
			this.width = width;
		else
			this.width = 0;
	}

	double perimeter() {
		double perimeter = 2 * (width + length);
		return perimeter;
	}

	double area() {
		double area = width * length;
		return area;
	}
}


//8.4 (Rectangle Class) Create a class Rectangle with attributes length and width, each of which
//defaults to 1. Provide methods that calculate the rectangle’s perimeter and area. It has set and get
//methods for both length and width. The set methods should verify that length and width are each
//floating-point numbers larger than 0.0 and less than 20.0. Write a program to test class Rectangle