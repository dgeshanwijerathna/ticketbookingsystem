/**
 * The Customer class implements Runnable and simulates a customer purchasing tickets from a TicketPool.
 * Each customer attempts to buy tickets from the available pool until the total ticket limit is reached.
 */
public class Customer implements Runnable {
    private final TicketPool ticketPool;
    private final int customerId;
    private static int totalPurchasedTickets = 0;

    /**
     * Constructor to initialize the Customer with a TicketPool and customer ID.
     *
     * @param ticketPool The TicketPool object where tickets are stored.
     * @param customerId The unique ID assigned to the customer.
     */
    public Customer(TicketPool ticketPool, int customerId) {
        this.ticketPool = ticketPool;
        this.customerId = customerId;
    }

    /**
     * The run method defines the behavior of the customer when the thread is started.
     * The customer tries to purchase tickets from the TicketPool in a synchronized manner.
     * The process continues until the total ticket limit is reached.
     */
    @Override
    public void run() {
        try {
            // Keep purchasing tickets until the total limit is reached.
            while (true) {
                synchronized (Customer.class) {
                    if (totalPurchasedTickets >= ticketPool.getTotalTicketLimit()) {
                        break;
                    }

                    // Attempt to purchase a ticket from the pool.
                    String ticket = ticketPool.removeTicket();
                    if (ticket != null) {
                        totalPurchasedTickets++;
                        Logger.log("Customer " + customerId + " purchased " + ticket);
                    }
                }
                // Simulate the rate at which the customer purchases tickets.
                Thread.sleep(1000); // 1 second delay between purchases
            }
        } catch (InterruptedException e) {
            // Handle any interruptions that might occur during thread execution.
            Logger.log("Error in Customer thread: " + e.getMessage());
        } finally {
            // Log when the customer has finished purchasing tickets.
            Logger.log("Customer " + customerId + " has finished purchasing.");
        }
    }
}
