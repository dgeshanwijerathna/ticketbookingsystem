import java.util.Vector;

/**
 * The TicketPool class simulates a pool of tickets where tickets can be added and removed by customers.
 * The pool has a maximum capacity and a total ticket limit.
 */
public class TicketPool {
    private final Vector<String> tickets;
    private final int maxCapacity;
    private final int totalTicketLimit;
    private int totalTicketsAdded = 0;

    /**
     * Constructor to initialize the TicketPool with a maximum capacity and a total ticket limit.
     *
     * @param maxCapacity The maximum number of tickets the pool can hold at any given time.
     * @param totalTicketLimit The total number of tickets that can ever be added to the pool.
     */
    public TicketPool(int maxCapacity, int totalTicketLimit) {
        this.tickets = new Vector<>();
        this.maxCapacity = maxCapacity;
        this.totalTicketLimit = totalTicketLimit;
    }

    /**
     * Adds a specified number of tickets to the pool, provided that the pool's current size
     * does not exceed the maximum capacity or the total ticket limit.
     *
     * @param count The number of tickets to add to the pool.
     */
    public synchronized void addTickets(int count) {
        for (int i = 0; i < count; i++) {
            if (tickets.size() < maxCapacity && totalTicketsAdded < totalTicketLimit) {
                String ticket = "Ticket-" + (totalTicketsAdded + 1);
                tickets.add(ticket);
                totalTicketsAdded++;
                Logger.log("Added " + ticket);
            } else {
                break; // Stop adding tickets if capacity or ticket limit is reached
            }
        }
    }

    /**
     * Removes a ticket from the pool. If the pool is empty, it returns null.
     *
     * @return The ticket that was removed from the pool, or null if no tickets are available.
     */
    public synchronized String removeTicket() {
        if (tickets.isEmpty()) {
            return null; // No tickets available to remove
        }
        String ticket = tickets.remove(0);
        Logger.log("Removed " + ticket);
        return ticket;
    }

    /**
     * Gets the total ticket limit of the pool.
     *
     * @return The total ticket limit.
     */
    public int getTotalTicketLimit() {
        return totalTicketLimit;
    }

    /**
     * Gets the total number of tickets that have been added to the pool.
     *
     * @return The number of tickets added to the pool.
     */
    public int getTotalTicketsAdded() {
        return totalTicketsAdded;
    }
}
