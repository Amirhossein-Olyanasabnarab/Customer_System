package dk.app.view;

import dk.app.model.Customer;

import java.util.Scanner;

public class LegalCustomerUI extends AbstractCustomerUI{
    public LegalCustomerUI(Scanner scanner) {
        super(scanner);
    }

    @Override
    public Customer generateCustomer() {
        return null;
    }

    @Override
    public void editCustomer(Customer customer) {

    }
}
