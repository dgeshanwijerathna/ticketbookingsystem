**README for Ticket Management System CLI**

**Introduction**

The Ticket Management System is a simulation of a vendor and customer
interaction where a vendor adds tickets to a shared pool, and customers
retrieve tickets from that pool. The system operates in a multithreaded
environment, where vendor and customer actions are simulated
concurrently. The vendor adds tickets at a certain rate, while customers
attempt to purchase tickets until the total ticket limit is reached.

**Features:**

-   **Ticket Pool Management**: A shared pool that holds tickets, which
    can be added and removed by the vendor and customers.

-   **Vendor Simulation**: The vendor adds tickets to the pool at a
    configurable rate.

-   **Customer Simulation**: Customers purchase tickets from the pool at
    a configurable rate.

-   **Logging**: System actions are logged with timestamps for
    monitoring.

-   **Configuration**: The system is highly configurable, allowing
    customization of ticket pool settings, ticket release rates,
    customer retrieval rates, and more.

**Setup Instructions**

**Prerequisites**

Before running the Ticket Management System, ensure that you have the
following installed:

-   **Java**: Java Development Kit (JDK) 8 or later.

-   **IDE**: Any Java IDE (e.g., IntelliJ IDEA, Eclipse) or you can use
    a text editor like Visual Studio Code.

-   **Terminal/Command Prompt**: For running the compiled program and
    managing file paths.

**How to Build and Run the Application**

1.  **Clone or Download the Repository**:

    -   If you are using Git, clone the repository:

    -   git clone \<repository_url\>

    -   Alternatively, download the ZIP file and extract it to your
        desired location.

2.  **Compile the Java Code**:

    -   Open a terminal or command prompt in the project directory.

    -   Compile the Java files:

    -   javac Main.java

3.  **Run the Application**:

    -   To run the application, execute the following command:

    -   java Main

This will start the Ticket Management System and prompt you to input
configuration values (e.g., ticket pool size, ticket release rate,
etc.).

**Usage Instructions**

**How to Configure and Start the System**

1.  When the application starts, you will be prompted to enter several
    configuration values:

    -   **Vendor Name**: The name of the vendor that will be used for
        file naming.

    -   **Total Number of Tickets**: The total number of tickets
        available in the system.

    -   **Ticket Release Rate**: The rate at which tickets are released
        by the vendor (tickets per second).

    -   **Customer Retrieval Rate**: The rate at which customers
        purchase tickets (tickets per second).

    -   **Max Ticket Capacity**: The maximum number of tickets the pool
        can hold.

2.  After entering the configuration, the system will save the
    configuration to a file named vendorName_timestamp.txt in the
    current directory. The configuration file contains the settings for
    future reference.

3.  The system will create instances of the Vendor and Customer classes,
    and threads for each will start running to simulate the ticket
    purchase process.

4.  The vendor will continuously add tickets to the pool until the total
    ticket limit is reached. Customers will attempt to purchase tickets
    until all tickets have been sold or the ticket pool is empty.

**Explanation of System Components**

-   **Vendor**: A thread that adds tickets to the pool at a rate defined
    by the ticket release rate.

-   **Customer**: A thread that purchases tickets from the pool, limited
    by the customer retrieval rate.

-   **Ticket Pool**: A shared resource where tickets are added and
    removed by the vendor and customers. The pool has a maximum capacity
    and a total ticket limit.

-   **Logger**: Captures and writes logs with timestamps for system
    activities, including ticket purchases and additions.

**Example Output**

During the execution, the system will print messages to the console such
as:

-   Ticket additions by the vendor.

-   Ticket purchases by customers.

-   Configuration settings saved to a file.

The system will also generate a log file (system_log.txt) that records
every ticket addition and removal.

**File Structure**

-   **Main.java**: The main class that runs the ticket management
    system.

-   **TicketPool.java**: Class responsible for managing the ticket pool.

-   **Vendor.java**: Represents the vendor adding tickets to the pool.

-   **Customer.java**: Represents the customers purchasing tickets from
    the pool.

-   **Logger.java**: Handles logging of system actions.

-   **Configuration.java**: Manages and saves the system configuration.

**Troubleshooting**

-   **Compilation Errors**: Ensure you are using the correct version of
    the JDK (Java 8 or later).

-   **File Not Found**: Make sure you are running the program from the
    directory where your .java files are located.

-   **Threading Issues**: Since the system is multithreaded, ensure that
    synchronization is being correctly managed in the TicketPool,
    Vendor, and Customer classes.

**License**

This project is licensed under the MIT License.

This README provides a basic overview of the Ticket Management System,
guiding you through setting it up, configuring it, and understanding its
operation.
