package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Product> list = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		sc.nextLine();
		for (int i = 1; i <= n; i++) {
			System.out.println("Product #" + i + " data: ");
			System.out.print("Common, used or imported (c/u/i)? ");
			char type = sc.next().charAt(0);
			sc.nextLine();
			if (type == 'c') {
				System.out.print("Name: ");
				String name = sc.nextLine();
				System.out.print("Price: ");
				double price = sc.nextDouble();
				Product prod = new Product(name, price);
				list.add(prod);
			} else if (type == 'u') {
				System.out.print("Name: ");
				String name = sc.nextLine();
				System.out.print("Price: ");
				double price = sc.nextDouble();
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date date = sdf.parse(sc.next());
				Product prod = new UsedProduct(name, price, date);
				list.add(prod);
			} else {
				System.out.print("Name: ");
				String name = sc.nextLine();
				System.out.print("Price: ");
				double price = sc.nextDouble();
				System.out.print("Customs Fee: ");
				double cust = sc.nextDouble();
				Product prod = new ImportedProduct(name, price, cust);
				list.add(prod);
			}
		}
		System.out.println("PRICE TAGS: ");
		for(Product c : list) {
			System.out.println(c.priceTag());
		}

		sc.close();

	}

}
