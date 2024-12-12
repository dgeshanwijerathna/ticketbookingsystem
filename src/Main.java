//import java.util.Scanner;
//
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        Configuration config = new Configuration();
//
//        // Prompt the user for inputs
//        System.out.println("Enter the vendor name:");
//        String vendorName = scanner.nextLine();
//
//        System.out.println("Enter the total number of tickets:");
//        config.setTotalTickets(scanner.nextInt());
//
//        System.out.println("Enter the ticket release rate (tickets per second):");
//        config.setTicketReleaseRate(scanner.nextInt());
//
//        System.out.println("Enter the customer retrieval rate (tickets per second):");
//        config.setCustomerRetrievalRate(scanner.nextInt());
//
//        System.out.println("Enter the maximum ticket capacity in the pool:");
//        config.setMaxTicketCapacity(scanner.nextInt());
//
//        // Save the configuration to a file
//        config.saveToFile(vendorName);
//
//        // Create TicketPool and initialize threads
//        TicketPool ticketPool = new TicketPool(config.getMaxTicketCapacity(), config.getTotalTickets());
//
//        Vendor vendor = new Vendor(ticketPool, config.getTicketReleaseRate());
//        Customer customer1 = new Customer(ticketPool, 1);
//        Customer customer2 = new Customer(ticketPool, 2);
//
//        // Start vendor and customer threads
//        Thread vendorThread = new Thread(vendor);
//        Thread customerThread1 = new Thread(customer1);
//        Thread customerThread2 = new Thread(customer2);
//
//        vendorThread.start();
//        customerThread1.start();
//        customerThread2.start();
//    }
//}

import java.util.Scanner;

/**
 * The {@code Main} class serves as the entry point for the ticket selling application.
 * It collects user inputs, initializes configurations, and starts vendor and customer threads.
 */
public class Main {

    /**
     * The main method initializes the ticketing system by collecting user input,
     * configuring the {@code TicketPool}, and starting threads for vendor and customers.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Configuration config = new Configuration();

        try {
            // Prompt the user for inputs
            System.out.println("Enter the vendor name:");
            String vendorName = scanner.nextLine();

            System.out.println("Enter the total number of tickets:");
            config.setTotalTickets(scanner.nextInt());

            System.out.println("Enter the ticket release rate (tickets per second):");
            config.setTicketReleaseRate(scanner.nextInt());

            System.out.println("Enter the customer retrieval rate (tickets per second):");
            config.setCustomerRetrievalRate(scanner.nextInt());

            System.out.println("Enter the maximum ticket capacity in the pool:");
            config.setMaxTicketCapacity(scanner.nextInt());

            // Save the configuration to a file
            config.saveToFile(vendorName);

            // Create TicketPool and initialize threads
            TicketPool ticketPool = new TicketPool(config.getMaxTicketCapacity(), config.getTotalTickets());

            Vendor vendor = new Vendor(ticketPool, config.getTicketReleaseRate());
            Customer customer1 = new Customer(ticketPool, 1);
            Customer customer2 = new Customer(ticketPool, 2);

            // Start vendor and customer threads
            Thread vendorThread = new Thread(vendor);
            Thread customerThread1 = new Thread(customer1);
            Thread customerThread2 = new Thread(customer2);

            vendorThread.start();
            customerThread1.start();
            customerThread2.start();

            // Join threads to ensure completion
            vendorThread.join();
            customerThread1.join();
            customerThread2.join();

        } catch (Exception e) {
            System.err.println("Error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
