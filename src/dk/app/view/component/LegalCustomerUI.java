package dk.app.view.component;

import dk.app.model.Customer;
import dk.app.model.LegalCustomer;

import java.util.Scanner;

public class LegalCustomerUI extends AbstractCustomerUI{
    public LegalCustomerUI(Scanner scanner) {
        super(scanner);
    }

    @Override
    public Customer generateCustomer() {
        System.out.println("Please enter your customer name:");
        String customerName = scanner.nextLine();
        System.out.println("Please enter your customer email:");
        String customerEmail = scanner.nextLine();
        System.out.println("Please enter your customer phone number:");
        String customerPhoneNumber = scanner.nextLine();
        System.out.println("Please enter your customer fax:");
        String customerFax = scanner.nextLine();
        LegalCustomer legalCustomer = new LegalCustomer(customerName, customerEmail, customerPhoneNumber);
        legalCustomer.setFax(customerFax);
        return legalCustomer;
    }

    @Override
    public void editCustomer(Customer customer) {
        LegalCustomer legalCustomer = (LegalCustomer) customer;
        System.out.println("Please enter your customer name:");
        String customerName = scanner.nextLine();
        System.out.println("Please enter your customer email:");
        String customerEmail = scanner.nextLine();
        System.out.println("Please enter your customer phone number:");
        String customerPhoneNumber = scanner.nextLine();
        System.out.println("Please enter your customer fax:");
        String customerFax = scanner.nextLine();
        legalCustomer.setName(customerName);
        legalCustomer.setEmail(customerEmail);
        legalCustomer.setPhone(customerPhoneNumber);
        legalCustomer.setFax(customerFax);

    }
}
