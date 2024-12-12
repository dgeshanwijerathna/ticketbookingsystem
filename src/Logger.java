import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The Logger class provides methods to log messages to both the console and a log file.
 * Each log message is timestamped with the current date and time.
 */
public class Logger {
    // The log file where messages will be written.
    private static final String LOG_FILE = "system_log.txt";

    /**
     * Logs a message to the console and appends it to a log file.
     *
     * @param message The message to be logged.
     */
    public static void log(String message) {
        String timestampedMessage = getTimestamp() + " " + message;
        System.out.println(timestampedMessage);
        writeToFile(timestampedMessage);
    }

    /**
     * Generates the current timestamp in the format "yyyy-MM-dd HH:mm:ss".
     *
     * @return The current timestamp as a string.
     */
    private static String getTimestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    /**
     * Writes a log message to a log file, appending it to the existing contents.
     *
     * @param message The message to be written to the log file.
     */
    private static void writeToFile(String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            writer.write(message);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }
}
