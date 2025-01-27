package dk.app.view;

import dk.app.model.Customer;

import java.util.Scanner;

public class RealCustomerUI extends AbstractCustomerUI
{
    public RealCustomerUI(Scanner scanner) {
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
