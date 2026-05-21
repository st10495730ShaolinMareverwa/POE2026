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
