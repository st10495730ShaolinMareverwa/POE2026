package poe1;

/*
 * Import the Before annotation.
 *
 * @Before runs setUp() before every test.
 * This is essential here because the Message class uses static variables that 
 * carry over
 * between tests if not manually cleared.
 */
import org.junit.Before;

/*
 * Import the Test annotation.
 *
 * @Test marks methods as unit tests.
 */

import org.junit.Test;

/*
 * Import all assertion methods.
 *
 * Assertions are used to check whether actual results match expected results.
 */

import static org.junit.Assert.*;

public class MessageTest 
{

    /*
     * SETUP METHOD
     */

    /*
     * This method runs before every test.
     *
     * The Message class contains static variables:
     * - totalMessages
     * - sentMessages
     *
     * Static variables keep their values between tests, which can cause tests 
     * to affect each other.
     *
     * resetSession() clears all stored messages and resets counters so every 
     * test starts clean.
     */
    
    @Before
    public void setUp() 
    {
        Message.resetSession();
    }

    /*
     * MESSAGE LENGTH TESTS
     */

    /*
     * Test whether a valid message length passes.
     *
     * Assignment rule: Message must not exceed 250 characters.
     *
     * This message is shorter than 250 characters,
     * so the method should return: "Message ready to send."
     */
    
    @Test
    public void testMessageLengthSuccess() 
    {

        /*
         * Create Message object using valid test data.
         */
        
        Message msg = new Message( 1, "+27718693002",
                "Hi Mike, can you join us for dinner tonight?");

        /*
         * assertEquals compares:
         * - expected result
         * - actual result
         *
         * Test passes only if both match.
         */
        
        assertEquals( "Message ready to send.",
                msg.checkMessageLength());
    }

    /*
     * Test whether an invalid message length fails.
     *
     * 5 rows of 50 characters = 250
     * plus 6 extra = 256 total.
     * Exceeds limit by 6.
     *
     * So the correct error message should appear.
     */
    
    @Test
    public void testMessageLengthFailure() 
    {

        /*
         * Long message used for testing
         * character limit validation.
         */
        
        String longMessage = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
                + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
                + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
                + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
                + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
                + "aaaaaa";

        /*
         * Create Message object with invalid message length.
         */
        
        Message msg = new Message( 1, "+27718693002", longMessage);

        /*
         * Verify correct error message is returned.
         */
        
        assertEquals( "Message exceeds 250 characters by 6; please reduce the size.",
                     msg.checkMessageLength()
        );
    }

    /*
     * RECIPIENT NUMBER TESTS
     */

    /*
     * Test whether a valid cellphone number passes.
     *
     * Number must:
     * - contain +27 international code
     * - contain correct number of digits
     */
    
    @Test
    public void testRecipientSuccess() 
    {

        /*
         * Create Message object using
         * valid cellphone number.
         */
        
        Message msg = new Message(1, "+27718693002", "Hello");

        /*
         * Verify correct success message
         * is returned.
         */
        
        assertEquals("Cell phone number successfully captured.", 
                     msg.checkRecipientCell());
    }

    /*
     * Test whether invalid cellphone number fails.
     *
     * This number starts with 0 instead of +27 and does not contain an 
     * international code, so validation should fail.
     */
    
    @Test
    public void testRecipientFailure() 
    {

        /*
         * Create Message object using
         * invalid cellphone number.
         */
        
        Message msg = new Message( 1, "08575975889", "Hello");

        /*
         * Verify correct failure message is returned.
         */
        
        assertEquals( "Cell phone number is incorrectly formatted or "
                        + "does not contain an international code. "
                        + "Please correct the number and try again.",
                msg.checkRecipientCell()
        );
    }

    /*
     * MESSAGE HASH TEST
     */

    /*
     * Test whether message hash is created correctly.
     *
     * Example:
     * 00:1:HITONIGHT
     */
    
    @Test
    public void testMessageHash() 
    {

        /*
         * Create Message object.
         */
        
        Message msg = new Message (1, "+27718693002",
                "Hi Mike, can you join us for dinner tonight?");

        /*
         * Store generated hash.
         */
        
        String hash = msg.getMessageHash();

        /*
         * Verify hash is uppercase.
         *
         * toUpperCase() converts text to uppercase.
         * If original hash already equals uppercase version, test passes.
         */
        
        assertEquals( hash, hash.toUpperCase() );

        /*
         * Verify hash ends with:
         * HITONIGHT
         *
         * First word = Hi
         * Last word = tonight
         *
         * Punctuation is removed.
         */
        
        assertTrue( hash.endsWith("HITONIGHT"));

        /*
         * Verify hash contains exactly 2 colons.
         *
         * Loop checks every character in hash.
         */
        
        int colonCount = 0;

        for (char c : hash.toCharArray()) 
        {

            /*
             * Increase counter every time a colon is found.
             */
            
            if (c == ':') 
            {
                colonCount++;
            }
        }

        /*
         * Verify total colon count equals 2.
         */
        
        assertEquals(2, colonCount);
    }

    /*
     * MESSAGE ID TEST
     */

    /*
     * Test whether generated message ID is valid.
     *
     * checkMessageID() returns true only if ID contains exactly 10 digits
     */
    
    @Test
    public void testMessageID() 
    {

        /*
         * Create Message object.
         */
        
        Message msg = new Message( 1, "+27718693002", "Hello" );

        /*
         * assertTrue passes only if method returns true.
         */
        
        assertTrue(msg.checkMessageID());
    }

    /*
     * SENTMESSAGE() METHOD TESTS
     */

    /*
     * Test Send Message option.
     *
     * SentMessage(1) means send message.
     */
    
    @Test
    public void testSendMessage() 
    {

        /*
         * Create Message object.
         */
        
        Message msg = new Message(1, "+27718693002", "Hello");

        /*
         * Verify correct send message result is returned.
         */
        
        assertEquals( "Message successfully sent.",
                msg.SentMessage(1));
    }

    /*
     * Test Disregard Message option.
     *
     * SentMessage(2) means disregard/delete message.
     */
    
    @Test
    public void testDisregardMessage() 
    {

        /*
         * Create Message object.
         */
        
        Message msg = new Message(1, "+27718693002", "Hello");

        /*
         * Verify correct disregard message result is returned.
         */
        
        assertEquals( "Press 0 to delete the message.", msg.SentMessage(2));
    }

    /*
     * Test Store Message option.
     *
     * SentMessage(3) means store message in JSON file.
     */
    
    @Test
    public void testStoreMessage() 
    {

        /*
         * Create Message object.
         */
        
        Message msg = new Message(1, "+27718693002", "Hello");

        /*
         * Verify correct store message result is returned.
         */
        
        assertEquals ( "Message successfully stored.", msg.SentMessage(3));
    }

    /*
     * TOTAL MESSAGE COUNT TEST
     */

    /*
     * Test whether totalMessages increases correctly when messages are sent.
     */
    
    @Test
    public void testReturnTotalMessages() 
    {

        /*
         * Create first Message object.
         */
        
        Message msg1 = new Message(1, "+27718693002", "Hello");

        /*
         * Create second Message object.
         */
        
        Message msg2 = new Message( 2, "+27718693003", "Hi");

        /*
         * Send both messages.
         *
         * This should increase totalMessages to 2.
         */
        
        msg1.SentMessage(1);
        msg2.SentMessage(1);

        /*
         * Verify total messages sent equals 2.
         */
        
        assertEquals( 2, Message.returnTotalMessages());
    }

    /*
     * PRINT MESSAGES TEST
     */

    /*
     * Test whether printMessages() correctly displays sent messages.
     */
    
    @Test
    public void testPrintMessages() 
    {

        /*
         * Create Message object.
         */
        
        Message msg = new Message( 1, "+27718693002", "Hello" );

        /*
         * Send message so it gets added
         * to sentMessages ArrayList.
         */
        
        msg.SentMessage(1);

        /*
         * Store printed output from printMessages() method.
         */
        
        String output = msg.printMessages();

        /*
         * Verify output contains message text.
         */
        
        assertTrue( output.contains("Hello"));

        /*
         * Verify output contains recipient number.
         */
        
        assertTrue( output.contains("+27718693002"));
    }
}
