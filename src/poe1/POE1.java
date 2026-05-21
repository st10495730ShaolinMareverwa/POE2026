package poe1;

/*
 * Import Scanner class
 *
 * Scanner allows the program to read user input from the keyboard.
 */

import java.util.Scanner;

public class POE1 
{

    /*
     * Main method
     *
     * Program execution starts here.
     */
    
    public static void main(String[] args) 
    {

        /*
         * Create Scanner object
         *
         * Used throughout the program to capture keyboard input.
         */
        
        Scanner input = new Scanner(System.in);

        /*
         * Create Login object
         *
         * This object stores user details and gives access to all validation 
         * methods from the Login class.
         */
        
        Login login = new Login();

        /*
         * REGISTRATION SECTION
         */

        System.out.println("=== Registration ===");

        /*
         * Ask user for first name and store it in Login object.
         */
        
        System.out.print("Enter first name: ");
        login.setFirstName(input.nextLine());

        /*
         * Ask user for last name and store it in Login object.
         */
        
        System.out.print("Enter last name: ");
        login.setLastName(input.nextLine());

        /*
         * Ask user for username and store it in Login object.
         */
        
        System.out.print("Enter username: ");
        login.setUserName(input.nextLine());

        /*
         * Validate username using checkUserName() method.
         *
         * Rules:
         * - must contain underscore
         * - must be 5 characters or less
         */
        
        if (login.checkUserName()) 
        {

            System.out.println("Username successfully captured.");

        } 
        else 
        {

            System.out.println("Username is not correctly formatted; "
                            + "please ensure that your username "
                            + "contains an underscore and is no "
                            + "more than five characters in length.");
        }

        /*
         * Ask user for password and store it in Login object.
         */
        
        System.out.print("Enter password: ");
        login.setPassword(input.nextLine());

        /*
         * Validate password complexity.
         *
         * Rules:
         * - minimum 8 characters
         * - must contain capital letter
         * - must contain number
         * - must contain special character
         */
        
        if (login.checkPasswordComplexity()) 
        {

            System.out.println(
                    "Password successfully captured."
            );

        } 
        else 
        {

            System.out.println("Password is not correctly formatted; "
                            + "please ensure that the password "
                            + "contains at least eight characters, "
                            + "a capital letter, a number, and a "
                            + "special character.");
        }

        /*
         * Ask user for cellphone number.
         *
         * Must contain South African international code (+27).
         */
        
        System.out.print("Enter South African cell phone number "
                        + "with international code: ");

        login.setCellPhoneNumber(input.nextLine());

        /*
         * Validate cellphone number format.
         */
        
        if (login.checkCellPhoneNumber()) 
        {

            System.out.println(
                    "Cell phone number successfully added."
            );

        } 
        else 
        {

            System.out.println("Cell phone number incorrectly formatted "
                            + "or does not contain international code.");
        }

        /*
         * Display final registration result.
         *
         * registerUser() checks all three fields:
         * - username validity
         * - password validity
         * - cellphone validity
         *
         * Returns an error message for the first failed check, or a welcome 
         * message if all fields are valid.
         */
        
        System.out.println(login.registerUser());

        /*
         * LOGIN SECTION
         */

        System.out.println("\n=== Login ===");

        /*
         * Ask user to enter username again for login authentication.
         */
        
        System.out.print("Enter username: ");

        String enteredUserName =
                input.nextLine();

        /*
         * Ask user to enter password again for login authentication.
         */
        
        System.out.print("Enter password: ");

        String enteredPassword =
                input.nextLine();

        /*
         * Check whether entered details match the stored registration details.
         *
         * loginSuccess stores:
         * - true if login succeeds
         * - false if login fails
         */
        
        boolean loginSuccess = login.loginUser( enteredUserName, 
                                                enteredPassword);

        /*
         * Display login result message.
         */
        
        System.out.println( login.returnLoginStatus(loginSuccess));

        /*
         * QUICKCHAT SECTION
         *
         * Only continue to QuickChat if login was successful.
         */
        
        if (loginSuccess) 
        {

            System.out.println("\nWelcome to QuickChat.");

            /*
             * Ask user how many messages they would like to send.
             */
            
            System.out.print("How many messages would you like to send? ");

            /*
             * Stores the number of messages the user chooses to send.
             */
            
            int numMessages = 0;

            /*
             * Loop until valid number is entered.
             *
             * Prevents crashes caused by:
             * - letters
             * - symbols
             * - invalid numbers
             */
            while (true) 
            {

                try 
                {

                    /*
                     * Convert user input from String into integer.
                     */
                    
                    numMessages =
                            Integer.parseInt(
                                    input.nextLine()
                            );

                    /*
                     * Ensure number is greater than 0.
                     */
                    
                    if (numMessages > 0) 
                    {

                        break;

                    } 
                    else 
                    {

                        System.out.print( "Please enter a number "
                                        + "greater than 0: "
                        );
                    }

                } 
                catch (NumberFormatException e) 
                {

                    /*
                     * Handles invalid numeric input.
                     */
                    
                    System.out.print("Invalid input. "
                                    + "Please enter a number: "
                    );
                }
            }

            /*
             * Tracks how many messages have been sent or stored.
             */
            
            int currentMessage = 0;

            /*
             * Stores user menu selection.
             */
            
            int choice = 0;

            /*
             * Menu loop continues until
             * user selects Quit (option 3).
             */
            
            while (choice != 3) 
            {

                /*
                 * Display QuickChat menu.
                 */
                
                System.out.println("\n===== MENU =====");

                System.out.println("1) Send Messages");

                System.out.println("2) Show recently sent messages");

                System.out.println("3) Quit");

                System.out.print("Choose an option: ");

                /*
                 * Prevent invalid menu input.
                 */
                
                try 
                {
                    choice = Integer.parseInt(input.nextLine());

                } 
                catch (NumberFormatException e) 
                {
                    System.out.println("Invalid option.");

                    /*
                     * Restart loop immediately.
                     */
                    
                    continue;
                }

                /*
                 * Switch statement executes different code depending on 
                 * selected menu option.
                 */
                
                switch (choice) 
                {
                    /*
                     * SEND MESSAGE
                     */
                    
                    case 1:

                        /*
                         * Prevent user from exceeding selected message limit.
                         */
                        
                        if (currentMessage >= numMessages) 
                        {

                            System.out.println( "Message limit reached.");

                            break;
                        }

                        /*
                         * Ask user for recipient number.
                         */
                        
                        System.out.print("Enter recipient number: ");

                        String recipient = input.nextLine();

                        /*
                         * Ask user for message text.
                         */
                        
                        System.out.print( "Enter message: ");

                        String messageText = input.nextLine();

                        /*
                         * Create Message object.
                         *
                         * currentMessage + 1 ensures numbering starts at 1.
                         */
                        
                        Message message = new Message(currentMessage + 1,
                                                      recipient,
                                                      messageText);

                        /*
                         * Validate recipient number.
                         */
                        
                        System.out.println(message.checkRecipientCell());

                        /*
                         * Validate message length.
                         *
                         * Maximum allowed: 250 characters.
                         */
                        
                        String lengthResult = message.checkMessageLength();

                        System.out.println( lengthResult);

                        /*
                         * Stop processing if message
                         * exceeds 250 characters.
                         */
                        
                        if (!lengthResult.equals("Message ready to send.")) 
                        {
                            break;
                        }

                        /*
                         * Display message options menu.
                         */
                        
                        System.out.println("\nChoose message option:");

                        System.out.println("1) Send Message");

                        System.out.println("2) Disregard Message");

                        System.out.println("3) Store Message to send later" );

                        /*
                         * Stores selected message option.
                         */
                        
                        int messageOption = 0;

                        /*
                         * Prevent invalid numeric input.
                         */
                        
                        try 
                        {
                            messageOption = Integer.parseInt(
                                            input.nextLine());
                        } 
                        catch (NumberFormatException e) 
                        {
                            System.out.println( "Invalid option.");

                            break;
                        }

                        /*
                         * Passes selected option to SentMessage().
                         *
                         * 1 - sends message, adds to sent list
                         * 2 - disregards message
                         * 3 - stores message to JSON file
                         *
                         * Returns a confirmation string which is printed to 
                         * the console.
                         */
                        
                        System.out.println( message.SentMessage(messageOption));

                        /*
                         * If message is sent:
                         * - display ID
                         * - display hash
                         * - increase counter
                         */
                        
                        if (messageOption == 1) 
                        {

                            System.out.println("\nMessage ID: "
                                            + message.getMessageID());

                            System.out.println("Message Hash: "
                                            + message.getMessageHash() );

                            currentMessage++;
                        }

                        /*
                         * Also increase counter
                         * when message is stored.
                         */
                        
                        if (messageOption == 3) 
                        {

                            currentMessage++;
                        }

                        break;

                    /*
                     * SHOW RECENTLY SENT MESSAGES
                     */
                    case 2:

                        /*
                         * A temporary Message object is created here because 
                         * printMessages() is an instance method and requires 
                         * an object to call it on. Even though it is called on 
                         * this temporary object, printMessages() reads from
                         * the static sentMessages ArrayList which holds all
                         * previously sent messages.
                         */
                        
                        Message temp = new Message(0,"","temp");

                        System.out.println(temp.printMessages());
                        
                        break;

                    /*
                     * QUIT APPLICATION
                     */
                        
                    case 3:

                        /*
                         * Exit message.
                         */
                        
                        System.out.println("Goodbye.");

                        break;

                    /*
                     * Handles invalid menu options.
                     */
                        
                    default:

                        System.out.println("Invalid option.");
                }
            }

            /*
             * Display total number of messages sent before program closes.
             */
            
            System.out.println("\nTotal messages sent: "
                            + Message.returnTotalMessages()
            );
        }

        /*
         * Close Scanner to prevent resource leaks.
         */
        
        input.close();
    }
}
        
        