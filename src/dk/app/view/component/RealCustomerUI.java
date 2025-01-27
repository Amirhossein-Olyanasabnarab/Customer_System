package dk.app.view.component;

import dk.app.model.Customer;
import dk.app.model.RealCustomer;

import java.util.Scanner;

public class RealCustomerUI extends AbstractCustomerUI
{
    public RealCustomerUI(Scanner scanner) {
        super(scanner);
    }

    @Override
    public Customer generateCustomer() {
        System.out.println("Please enter your customer name:");
        String customerName = scanner.nextLine();
        System.out.println("Please enter your customer family:");
        String customerFamily = scanner.nextLine();
        System.out.println("Please enter your customer email:");
        String customerEmail = scanner.nextLine();
        System.out.println("Please enter your customer phone number:");
        String customerPhoneNumber = scanner.nextLine();
        RealCustomer realCustomer = new RealCustomer(customerName, customerEmail, customerPhoneNumber);
        realCustomer.setFamily(customerFamily);
        return realCustomer;
    }

    @Override
    public void editCustomer(Customer customer) {
        RealCustomer realCustomer = (RealCustomer) customer;

        System.out.println("Enter customer name:");
        String customerName = scanner.nextLine();
        System.out.println("Enter customer family:");
        String customerFamily = scanner.nextLine();
        System.out.println("Enter customer email:");
        String customerEmail = scanner.nextLine();
        System.out.println("Enter customer phone number:");
        String customerPhoneNumber = scanner.nextLine();
        realCustomer.setName(customerName);
        realCustomer.setFamily(customerFamily);
        realCustomer.setEmail(customerEmail);
        realCustomer.setPhone(customerPhoneNumber);

    }
}
