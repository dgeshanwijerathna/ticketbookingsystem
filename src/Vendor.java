/**
 * The {@code Vendor} class represents a ticket vendor that periodically adds tickets 
 * to a shared {@link TicketPool}. It runs on its own thread and stops adding tickets 
 * when the total ticket limit is reached.
 */
public class Vendor implements Runnable {
    private final TicketPool ticketPool;
    private final int ticketReleaseRate;

    /**
     * Constructs a {@code Vendor} instance.
     *
     * @param ticketPool       the shared {@link TicketPool} where tickets will be added
     * @param ticketReleaseRate the rate at which tickets are added, measured in tickets per second
     */
    public Vendor(TicketPool ticketPool, int ticketReleaseRate) {
        this.ticketPool = ticketPool;
        this.ticketReleaseRate = ticketReleaseRate;
    }

    /**
     * The main logic for the {@code Vendor}. Periodically adds tickets to the 
     * {@link TicketPool} until the total ticket limit is reached. This method runs 
     * as a separate thread when invoked by a {@link Thread}.
     */
    @Override
    public void run() {
        try {
            while (true) {
                synchronized (ticketPool) {
                    if (ticketPool.getTotalTicketsAdded() >= ticketPool.getTotalTicketLimit()) {
                        Logger.log("Vendor stopped adding tickets: All tickets listed.");
                        break;
                    }
                    ticketPool.addTickets(ticketReleaseRate);
                }
                Thread.sleep(1000); // Simulate ticket release rate
            }
        } catch (Exception e) {
            Logger.log("Error in Vendor thread: " + e.getMessage());
        }
    }
}
