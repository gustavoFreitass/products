package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter Client data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date(dd/MM/yyyy): ");
		Date dateBirth = sdf.parse(sc.next());
		Client client = new Client(name, email, dateBirth);
		
		System.out.println("Enter Status data: ");
		System.out.print("Status: ");
		OrderProduct status = OrderProduct.valueOf(sc.next());
		Order order = new Order(new Date(), status, client);
		
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		for(int i=1; i<=n; i++ ) {
			System.out.println("Enter #" + i + " item date:");
			sc.nextLine();
			System.out.print("Product name: ");
			String nameProduct= sc.nextLine();
			System.out.print("Product price: ");
			double price = sc.nextDouble();
			Product product = new Product(nameProduct, price);
			
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			OrderItem orderItem = new OrderItem(quantity, price, product);
			order.addItem(orderItem);
		}
		
		System.out.println("\n" + order);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		sc.close();

	}

}
