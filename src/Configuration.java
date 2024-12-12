import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The {@code Configuration} class is responsible for managing the configuration settings
 * of the ticketing system. It provides methods to set and retrieve configuration values
 * and to save these settings to a file for persistence.
 */
public class Configuration implements Serializable {
    private int totalTickets;
    private int ticketReleaseRate;
    private int customerRetrievalRate;
    private int maxTicketCapacity;

    /**
     * Retrieves the total number of tickets.
     *
     * @return the total number of tickets
     */
    public int getTotalTickets() {
        return totalTickets;
    }

    /**
     * Sets the total number of tickets.
     *
     * @param totalTickets the total number of tickets
     */
    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    /**
     * Retrieves the ticket release rate.
     *
     * @return the ticket release rate in tickets per second
     */
    public int getTicketReleaseRate() {
        return ticketReleaseRate;
    }

    /**
     * Sets the ticket release rate.
     *
     * @param ticketReleaseRate the ticket release rate in tickets per second
     */
    public void setTicketReleaseRate(int ticketReleaseRate) {
        this.ticketReleaseRate = ticketReleaseRate;
    }

    /**
     * Retrieves the customer ticket retrieval rate.
     *
     * @return the customer retrieval rate in tickets per second
     */
    public int getCustomerRetrievalRate() {
        return customerRetrievalRate;
    }

    /**
     * Sets the customer ticket retrieval rate.
     *
     * @param customerRetrievalRate the customer retrieval rate in tickets per second
     */
    public void setCustomerRetrievalRate(int customerRetrievalRate) {
        this.customerRetrievalRate = customerRetrievalRate;
    }

    /**
     * Retrieves the maximum ticket capacity in the pool.
     *
     * @return the maximum ticket capacity
     */
    public int getMaxTicketCapacity() {
        return maxTicketCapacity;
    }

    /**
     * Sets the maximum ticket capacity in the pool.
     *
     * @param maxTicketCapacity the maximum ticket capacity
     */
    public void setMaxTicketCapacity(int maxTicketCapacity) {
        this.maxTicketCapacity = maxTicketCapacity;
    }

    /**
     * Saves the current configuration settings to a file. The file name includes the vendor's name
     * and a timestamp to ensure uniqueness.
     *
     * @param vendorName the name of the vendor for which the configuration is being saved
     */
    public void saveToFile(String vendorName) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = vendorName + "_" + timestamp + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Total Tickets: " + totalTickets + "\n");
            writer.write("Ticket Release Rate: " + ticketReleaseRate + " tickets/second\n");
            writer.write("Customer Retrieval Rate: " + customerRetrievalRate + " tickets/second\n");
            writer.write("Max Ticket Capacity: " + maxTicketCapacity + "\n");
            System.out.println("Configuration saved to file: " + fileName);
        } catch (IOException e) {
            System.err.println("Error saving configuration to file: " + e.getMessage());
        }
    }
}
