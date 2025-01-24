package dk.app.view;

import dk.app.model.Customer;
import dk.app.model.LegalCustomer;
import dk.app.model.RealCustomer;
import dk.app.service.CustomerService;

import java.util.ArrayList;
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
        System.out.println("Enter customer ID:");
        Integer customerId = scanner.nextInt();
        scanner.nextLine();
        Customer customer = customerService.getCustomerById(customerId);
        System.out.println(customer);
        System.out.println("Enter customer first name:");
        String customerName = scanner.nextLine();
        customer.setName(customerName);
        System.out.println("Enter customer email:");
        String customerEmail = scanner.nextLine();
        customer.setEmail(customerEmail);
        System.out.println("Enter customer phone:");
        String customerPhone = scanner.nextLine();
        customer.setPhone(customerPhone);
        if (customer instanceof RealCustomer realCustomer) {
            System.out.println("Enter customer family:");
            String customerFamilyName = scanner.nextLine();
            realCustomer.setFamily(customerFamilyName);
        }else if (customer instanceof LegalCustomer legalCustomer) {
            System.out.println("Enter customer fax:");
            String customerFax = scanner.nextLine();
            legalCustomer.setFax(customerFax);
        }
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
        if (choice == 1) {
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
            customerService.addCustomer(realCustomer);
        }else if (choice == 2) {
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
            customerService.addCustomer(legalCustomer);
        }else{
            System.out.println("Invalid option...... please try again");
        }
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
