package dk.app.view.component;

import dk.app.model.Customer;

import java.util.Scanner;

public abstract class AbstractCustomerUI {

    protected final Scanner scanner;

    public AbstractCustomerUI(Scanner scanner) {
        this.scanner = scanner;
    }

    public abstract Customer generateCustomer();

    public abstract void editCustomer(Customer customer);
}
