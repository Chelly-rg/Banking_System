package bankingSystem;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
	
	static float balance = 0;
	static int deposit, withdraw, transfer;
	static int choice;
	static String firstName, lastName;
	static String accNumber;
	static String input1;
	static int loop = 1, loop1 = 1;
	static Scanner input_1 = new Scanner(System.in);
	static Scanner s = new Scanner(System.in);
	
	public static void deposit() throws InterruptedException{
		System.out.println("~~~~~~~~~~~ DEPOSIT ~~~~~~~~~~~");
		
		while (true) {
			try {
				System.out.print("Enter amount to deposit: ");
				deposit = s.nextInt();
				s.nextLine();
				
				balance = balance + deposit;
				
				System.out.println("Transaction Successful!");
				Thread.sleep(1000);
				anotherTrans();
				break;
			}
			
			catch (InputMismatchException e) {
				s.next();
				System.out.println();
				System.out.println("Invalid input.");
				System.out.println("Please enter a number.");
				Thread.sleep(1000);
				System.out.println();
			}
		}
		
	}
	
	public static void withdraw() throws InterruptedException {
		System.out.println("~~~~~~~~~~ WITHDRAW ~~~~~~~~~~~");
		
		while (true) {
			try {
				System.out.print("Enter amount to withdraw: ");
				withdraw = s.nextInt();
				s.nextLine();
				
				if (withdraw > balance) {
					Thread.sleep(1000);
					System.out.println("You don't have enough balance to do this transaction.");
					Thread.sleep(1000);
					System.out.println();
					anotherTrans();
					break;
				} else {
					if (withdraw%100 != 0) {
						System.out.println("You can only withdraw an amount that is divisible by 100.");
						Thread.sleep(1000);
						System.out.println();
					} else {
						balance = balance - withdraw;
						System.out.println("Transaction Successful!");
						Thread.sleep(1000);
						anotherTrans();
						break;
					}
				
				}
			}
			
			catch (InputMismatchException e) {
				s.next();
				System.out.println();
				System.out.println("Invalid input.");
				System.out.println("Please enter a number.");
				Thread.sleep(1000);
				System.out.println();
			}
		}
	}
	
	public static void balanceInquiry() throws InterruptedException {
		System.out.println("~~~~~~~ BALANCE INQUIRY ~~~~~~~");
		System.out.println("Your balance is: " + balance);
		Thread.sleep(1000);
		anotherTrans();
	}
	
	public static void transfer() throws InterruptedException {
		while (loop1 == 1) {
			System.out.println("~~~~~~~~ TRANSFER CASH ~~~~~~~~");
			
			Scanner s1 = new Scanner (System.in);
			System.out.println("[Recipient]");
			System.out.print("First Name     : ");
			firstName = s1.nextLine();
			
			System.out.print("Last Name      : ");
			lastName = s1.nextLine();
			
			System.out.print("Account Number : ");
			accNumber = s1.nextLine();
			
			System.out.print("Amount         : ");
			transfer = s1.nextInt();
			Thread.sleep(1000);
			
			if (balance == 0) {
				System.out.println("Your balance is 0.");
				System.out.println("Please deposit an amount to do this transaction.");
				Thread.sleep(1000);
				anotherTrans();
				break;
			} else {
					if (balance < transfer) {
						System.out.println("You don't have enough balance to do this transaction.");
						Thread.sleep(1000);
						anotherTrans();
						break;
					} else {
					System.out.println();
					System.out.println("~~~~~~~ Confirmation Details ~~~~~~~");
					System.out.println("Please check if all information is correct.");
					System.out.println("[Recipient]");
					System.out.println("Name           : " + firstName.toUpperCase() + " " + lastName.toUpperCase());
					System.out.println("Account Number : " + accNumber);
					System.out.println("Amount         : " + transfer);
					
						while (true) {
							Thread.sleep(1000);
							System.out.println();
							System.out.println("Yes (Y) or No (N)");
							System.out.print("Your answer : ");
							input1 = input_1.nextLine();
							System.out.println();
							
							if (input1.equalsIgnoreCase("N")) {
								System.out.println("Please enter the correct information.");
								break;	
							} else if (input1.equalsIgnoreCase("Y")) {
								balance = balance - transfer;
								System.out.println("Transaction Successful!");
								Thread.sleep(1000);
								anotherTrans();
								loop1++;
								break;
							} else {
								System.out.println("Please choose Yes (Y) or No (N)...");
								System.out.println();
								Thread.sleep(1000);
							}
						}
					}
			}
			
		}
		
	}
	
	public static void exit() throws InterruptedException{
		
		System.out.println("~~~~~~~~~~~~ EXIT ~~~~~~~~~~~~~");
		while (true) {
			System.out.println("Are you sure you want to exit?");
			System.out.println("Yes (Y) or No (N)");
			System.out.print("Your answer : ");
			input1 = input_1.nextLine();
			System.out.println();
			
			if (input1.equalsIgnoreCase("N")) {
				System.out.println("What would you like to do next?");
				Thread.sleep(1000);
				break; 
			} else if (input1.equalsIgnoreCase("Y")) {
				printReceipt();
				System.out.println("Thank you for banking with us.");
				loop++;
				break;
			} else {
				System.out.println("Please choose Yes (Y) or No (N)...");
				System.out.println();
				Thread.sleep(1000);
			}
		}
	}

	public static void anotherTrans() throws InterruptedException{
		while (true) {
			System.out.println();
			System.out.println("Would you like to do another transaction?");
			System.out.println("Yes (Y) or No (N)");
			System.out.print("Your answer : ");
			input1 = input_1.nextLine();
			System.out.println();
			
			if (input1.equalsIgnoreCase("N")) {
				exit();
				break;	
			} else if (input1.equalsIgnoreCase("Y")) {
				break;
			} else {
				System.out.println("Please choose Yes (Y) or No (N)...");
				System.out.println();
				Thread.sleep(1000);
			}
		
		}
	}
	
	public static void printReceipt() throws InterruptedException{
		System.out.println("~~~~~~~~~~~ RECEIPT ~~~~~~~~~~~");
		System.out.println("Remaining Balance : " + balance);

	}
	
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("Welcome to our Banking System.");
		System.out.println();
		System.out.println("What would you like to do today?");
		
		while (loop == 1) {
			System.out.println();
			System.out.println("[1] Deposit");
			System.out.println("[2] Withdraw");
			System.out.println("[3] Balance Inquiry");
			System.out.println("[4] Transfer Cash");
			System.out.println("[5] Exit");
			System.out.print("Enter your answer : ");
			choice = s.nextInt();
			System.out.println();
			
			switch (choice) {
			case 1:
				deposit();
				break;
			
			case 2:
				withdraw();
				break;
			
			case 3:
				balanceInquiry();
				break;
				
			case 4:
				transfer();
				break;
				
			case 5:
				exit();
				break;
				
			default:
				System.out.println("Invalid input.");
				System.out.println("Please choose a number from 1-5.");
				Thread.sleep(1000);
				System.out.println();
				break;
				
			}
			
		}

	}

}
