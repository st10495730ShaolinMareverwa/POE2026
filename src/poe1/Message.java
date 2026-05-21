package poepart1;

/*
 * JSON Simple imports
 * These allow the program to create JSON objects and arrays
 * so messages can be stored in a JSON file.
 */
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/*
 * FileWriter allows writing to files.
 * IOException handles file-writing errors.
 */
import java.io.FileWriter;
import java.io.IOException;

/*
 * ArrayList stores multiple sent messages.
 * Random generates random message IDs.
 */
import java.util.ArrayList;
import java.util.Random;

public class Message {

    /*
     * Static variables
     *
     * totalMessages:
     * Stores the total number of messages sent during runtime.
     *
     * sentMessages:
     * Stores all sent Message objects while the program runs.
     */
    private static int totalMessages = 0;
    private static ArrayList<Message> sentMessages = new ArrayList<>();
    
/*
     * Instance variables
     *
     * These store information for each individual message object.
     */
    private String messageID;
    private int messageNumber;
    private String recipient;
    private String message;
    private String messageHash;

    /*
     * Constructor
     *
     * This constructor creates a new Message object and:
     * - stores the message number
     * - stores the recipient number
     * - stores the message text
     * - generates a random message ID
     * - creates a message hash
     */
    public Message(int messageNumber, String recipient, String message) {

        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.message = message;

        // Generate the random 10-digit message ID
        generateMessageID();

        /*
         * Ensure the message is not null or empty
         * before creating the message hash.
         */
        if (message != null && !message.trim().isEmpty()) {
            this.messageHash = createMessageHash();
        }
    }

/*
     * Generate random 10-digit message ID
     *
     * Example:
     * 5483921746
     */
    private void generateMessageID() {

        // Create Random object
        Random random = new Random();

        /*
         * Generate random number between:
         * 1000000000 and 9999999999
         *
         * This guarantees exactly 10 digits.
         */
        long number = 1000000000L
                + (long) (random.nextDouble() * 9000000000L);

        // Convert number into String
        this.messageID = String.valueOf(number);
    }

    /*
     * Check whether the message ID is exactly 10 digits.
     *
     * Returns:
     * - true if valid
     * - false if invalid
     */
    public boolean checkMessageID() {

        return messageID.length() == 10;
    }
    
/*
     * Validate recipient cellphone number
     *
     * Regex explanation:
     * ^         -> start of string
     * \\+27     -> must begin with +27
     * \\d{9}    -> followed by exactly 9 digits
     * $         -> end of string
     *
     * Example valid number:
     * +27718693002
     *
     * Regex reference:
     * Oracle Java Pattern documentation:
     * https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/regex/Pattern.html
     */
    public String checkRecipientCell() {

        // Check if recipient number matches SA format
        if (recipient.matches("^\\+27\\d{9}$")) {

            return "Cell phone number successfully captured.";

        } else {

            return "Cell phone number is incorrectly formatted or "
                    + "does not contain an international code. "
                    + "Please correct the number and try again.";
        }
    }