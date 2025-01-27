package dk.app.view;

import dk.app.model.Customer;
import dk.app.model.LegalCustomer;
import dk.app.model.RealCustomer;
import dk.app.service.CustomerService;
import dk.app.view.component.AbstractCustomerUI;
import dk.app.view.component.LegalCustomerUI;
import dk.app.view.component.RealCustomerUI;

import java.util.List;
import java.util.Scanner;

public class ConsoleUI implements AutoCloseable{
    private final Scanner scanner;
    private final CustomerService customerService;

    public ConsoleUI(){
        scanner = new Scanner(System.in);
        customerService = CustomerService.getInstance();
    }

    public void startMenu(){
        int choice;
        do {
            printMenu();
            System.out.println("Select an option:");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    System.out.println("Exit.....");
                    break;
                case 1:
                    addCustomer();
                    break;
                case 2:
                    showAllCustomer();
                    break;
                case 3:
                    searchAndPrintCustomersByName();
                    break;
                case 4:
                    searchAndPrintCustomersByFamily();
                    break;
                case 5:
                    editCustomerById();
                    break;
                case 6:
                    deleteCustomerById();
                    break;
                case 7:
                    printAllDeletedCustomers();
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }while (choice != 0);
    }

    private void printAllDeletedCustomers() {
        List<Customer> customers = customerService.getAllDeletedCustomers();
        if (customers.isEmpty()) {
            System.out.println("No customers found");
        }else {
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        }
    }

    private void deleteCustomerById() {
        System.out.println("Enter customer id:");
        Integer customerId = scanner.nextInt();
        scanner.nextLine();
        customerService.deleteCustomerById(customerId);
    }

    private void editCustomerById() {
        AbstractCustomerUI customerUI;
        System.out.println("Please enter a customer id:");
        Customer customer = customerService.getCustomerById(scanner.nextInt());
        scanner.nextLine();

        if (customer instanceof RealCustomer realCustomer) {
            customerUI = new RealCustomerUI(scanner);
        }else {
            customerUI = new LegalCustomerUI(scanner);
        }
        customerUI.editCustomer(customer);
    }

    private void searchAndPrintCustomersByFamily() {
        System.out.println("Please enter name for searching customers by name:");
        String family = scanner.nextLine();
        List<Customer> customers = customerService.getCustomersByFamily(family);
        customers.forEach(System.out::println);
    }

    private void searchAndPrintCustomersByName() {
        System.out.println("Please enter name for searching customers by name:");
        String name = scanner.nextLine();
        List<Customer> customers = customerService.getCustomersByName(name);
        customers.forEach(System.out::println);
    }

    private void showAllCustomer() {
        List<Customer> allCustomers = customerService.getActivesCustomers();
        if (allCustomers.isEmpty()){
            System.out.println("No customers found");
        }else {
            for (Customer customer : allCustomers){
                System.out.println(customer);
            }
        }
    }

    private void addCustomer() {
        System.out.println("Customer type:");
        System.out.println("1- Real customer");
        System.out.println("2- Legal customer");
        System.out.println("Please enter your choice:");
        int choice = scanner.nextInt();
        scanner.nextLine();
        AbstractCustomerUI customerUI = null;
        if (choice == 1) {
            customerUI = new RealCustomerUI(scanner);
        }else if (choice == 2) {
            customerUI = new LegalCustomerUI(scanner);
        }else{
            System.out.println("Invalid option...... please try again");
        }
        Customer customer = customerUI.generateCustomer();
        customerService.addCustomer(customer);
    }

    public void printMenu(){
        System.out.println("Please choose one of the following options:");
        System.out.println("0. Exit");
        System.out.println("1. Add new customer");
        System.out.println("2. Show all customers");
        System.out.println("3. Print customer by name");
        System.out.println("4. Print customer by family");
        System.out.println("5. Edit customer by Id");
        System.out.println("6. Delete customer by Id");
        System.out.println("7. Print all deleted customers");
    }
    @Override
    public void close()  {
        scanner.close();
    }
}
