package HomeworkChapter8;

class SavingAccount {

	private String name;
	private static double yearInterestRate;
	private double savingBalance;
	private double monthlyInterest;

	public SavingAccount(String name, double savingBalance) {

		this.name = name;
		this.savingBalance = savingBalance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSavingBalance() {
		return savingBalance;
	}

	public void setSavingBalance(double savingBalance) {
		if (savingBalance > 0)
			this.savingBalance = savingBalance;
		else
			this.savingBalance = 0;
	}

	public double getMonthlyInterest() {
		return monthlyInterest;
	}

	public void setMonthlyInterest(double monthlyInterest) {
		this.monthlyInterest = monthlyInterest;
	}

	public double calculateMonthlyInterest() {

		monthlyInterest = (savingBalance * yearInterestRate / 100) / 12;
		this.savingBalance += monthlyInterest;
		return savingBalance;
	}

	public static void modifyInterestRate(int newInterestRate) {
		if (newInterestRate >= 0)
			yearInterestRate = newInterestRate;
	}

	public String toString() {

		return String.format("%s will have %.2f%n", getName(), calculateMonthlyInterest());
	}
}

public class Homework3 {
	public static void main(String[] args) {
		SavingAccount saver1 = new SavingAccount("valera", 2000.0);
		SavingAccount saver2 = new SavingAccount("Akakii", 3000.0);

		SavingAccount.modifyInterestRate(4);

		for (int i = 0; i < 12; i++) {
			System.out.printf("at %d month %s", (i + 1), saver1.toString());
			System.out.printf("at %d month %s", (i + 1), saver2.toString());
		}

		SavingAccount.modifyInterestRate(5);

		System.out.println("with new interest rate :");

		for (int i = 0; i < 12; i++) {
			System.out.printf("at %d month %s", (i + 1), saver1.toString());
			System.out.printf("at %d month %s", (i + 1), saver2.toString());
		}
	}

}


//8.6		(Savings Account Class) Create class SavingsAccount. Use a static variable annualInterestRate to store
//the annual interest rate for all account holders. Each object of the class contains a private instance
//variable savingsBalance indicating the amount the saver currently has on deposit.
//Provide method calculateMonthlyInterest to calculate the monthly interest by multiplying the savingsBalance
//by annualInterestRate divided by 12—this interest should be added to savingsBalance. 
//Provide a static method modifyInterestRate that sets the annualInterestRate to a new
//value. Write a program to test class SavingsAccount. Instantiate two savingsAccount objects,
//saver1 and saver2, with balances of $2000.00 and $3000.00, respectively. Set annualInterestRate
//to 4%, then calculate the monthly interest for each of 12 months and print the new balances for
//both savers. Next, set the annualInterestRate to 5%, calculate the next month’s interest and print
//the new balances for both savers