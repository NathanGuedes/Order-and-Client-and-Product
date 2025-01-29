package application;

import model.entities.Client;
import model.entities.OrderItem;
import model.entities.Product;
import model.entities.Order;
import model.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        try (Scanner sc = new Scanner(System.in)){

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            System.out.println("Enter cliente data:");
            System.out.print("Name: ");
            String clientName = sc.nextLine();
            System.out.print("Email: ");
            String clientEmail = sc.nextLine();
            System.out.print("Birth date (DD/MM/YYYY): ");
            Date clientBirthDate = sdf.parse(sc.next());

            Client client =new Client(clientName, clientEmail, clientBirthDate);

            System.out.println();
            System.out.println("Enter order data:");
            System.out.print("Status: ");
            OrderStatus orderStatus = OrderStatus.valueOf(sc.next());

            Order order = new Order(new Date(), orderStatus, client);

            System.out.println();
            System.out.print("How many items to this order? ");
            int n = sc.nextInt();
            sc.nextLine();

            System.out.println();
            for (int i = 0; i < n; i++) {
                System.out.printf("Enter #%d item data:%n", i + 1);

                System.out.print("Product name: ");
                String productName = sc.nextLine();
                System.out.print("Product price: ");
                double productPrice = sc.nextDouble();

                Product product = new Product(productName, productPrice);

                System.out.print("Quantity: ");
                int productQuantity;
                productQuantity = sc.nextInt();
                sc.nextLine();
                System.out.println();

                OrderItem orderItem = new OrderItem(productQuantity, productPrice,product);

                order.addItem(orderItem);
            }

            System.out.println("ORDER SUMMARY:");
            System.out.println(order);

        }
    }
}
