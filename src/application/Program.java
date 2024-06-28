package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Ordem;
import entities.OrdemItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Enter client data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Emai: ");
		String email = sc.next();
		System.out.print("Birth Date: ");
		Date birthDate = sdf.parse(sc.next());
		Client client = new Client(name, email, birthDate);
		System.out.println("Enter Order data: ");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		System.out.print("How many items to this order? ");
		int items = sc.nextInt();
		sc.nextLine();
		Ordem order = new Ordem(client, status);
		for (int i = 1; i <= items; i++) {
			System.out.println("Enter #" + i + " item data: ");
			System.out.print("Product name: ");
			String nameProduct = sc.nextLine();
			System.out.print("Product price: ");
			double price = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			sc.nextLine();
			Product product = new Product(nameProduct, price);
			OrdemItem itemsOrder = new OrdemItem(quantity, price, product);
			order.addItem(itemsOrder);
		}
		System.out.println(order);
		sc.close();

	}

}
