package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import model.exceptions.Exception;
import model.entities.Account;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.US);
		try {
			System.out.println("Enter account data: ");
			System.out.print("Number: ");
			int number = sc.nextInt();
			sc.nextLine();
			System.out.print("Holder: ");
			String holder = sc.nextLine();
			System.out.print("Initial balance: ");
			double balance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			double withDrawLimit = sc.nextDouble();
			Account account = new Account(number, holder, balance, withDrawLimit);
			System.out.print("Enter amount for withdraw: ");
			double withDraw = sc.nextDouble();
			account.withDraw(withDraw);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} catch (InputMismatchException e) {
			System.out.println("Unexpected error");
		}
		sc.close();
	}

}
