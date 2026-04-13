
package poe1;

import org.junit.Test;
import static org.junit.Assert.*;

/*
 * use:
 * - assertEquals
 * - assertTrue
 * - assertFalse
 *
 * - use the exact test data shown in the table.
 */
public class LoginTest 
{

    /*
     * Test that a correctly formatted username returns true.
     * Assignment test data: "kyl_1"
     */
    @Test
    public void testCheckUserNameTrue() 
    {
        Login login = new Login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertTrue(login.checkUserName());
    }

    /*
     * Test that an incorrectly formatted username returns false.
     * Assignment test data: "kyle!!!!!!!"
     */
    @Test
    public void testCheckUserNameFalse() 
    {
        Login login = new Login("Kyle", "Smith", "kyle!!!!!!!", "Ch&&sec@ke99!", "+27838968976");
        assertFalse(login.checkUserName());
    }

    /*
     * Test that a valid password returns true.
     * Assignment test data: "Ch&&sec@ke99!"
     */
    @Test
    public void testCheckPasswordComplexityTrue() 
    {
        Login login = new Login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertTrue(login.checkPasswordComplexity());
    }

    /*
     * Test that an invalid password returns false.
     * Assignment test data: "password"
     */
    @Test
    public void testCheckPasswordComplexityFalse() 
    {
        Login login = new Login("Kyle", "Smith", "kyl_1", "password", "+27838968976");
        assertFalse(login.checkPasswordComplexity());
    }

    /*
     * Test that a valid cell phone number returns true.
     * Assignment test data: +27838968976
     */
    @Test
    public void testCheckCellPhoneNumberTrue() 
    {
        Login login = new Login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertTrue(login.checkCellPhoneNumber());
    }

    /*
     * Test that an invalid cell phone number returns false.
     * Assignment test data: 08966553
     */
    @Test
    public void testCheckCellPhoneNumberFalse() 
    {
        Login login = new Login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "08966553");
        assertFalse(login.checkCellPhoneNumber());
    }

    /*
     * Test the username error message using assertEquals.
     */
    @Test
    public void testRegisterUserUsernameErrorMessage() 
    {
        Login login = new Login("Kyle", "Smith", "kyle!!!!!!!", "Ch&&sec@ke99!", "+27838968976");

        assertEquals(
                "Username is not correctly formatted; please ensure that your "
                        + "username contains an underscore and is no more than "
                        + "five characters in length.",
                login.registerUser()
        );
    }

    /*
     * Test the password success message using the assignment test data.
     */
    @Test
    public void testPasswordSuccessMessage() 
    {
        Login login = new Login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");

        String actualMessage;
        if (login.checkPasswordComplexity()) 
        {
            actualMessage = "Password successfully captured.";
        } else 
        {
            actualMessage = "Password is not correctly formatted; please "
                    + "ensure that the password contains at least eight "
                    + "characters, a capital letter, a number, and a special character.";
        }

        assertEquals("Password successfully captured.", actualMessage);
    }

    /*
     * Test the password failure message using assertEquals.
     */
    @Test
    public void testPasswordFailureMessage() 
    {
        Login login = new Login("Kyle", "Smith", "kyl_1", "password", "+27838968976");

        String actualMessage;
        if (login.checkPasswordComplexity()) 
        {
            actualMessage = "Password successfully captured.";
        } else 
        {
            actualMessage = "Password is not correctly formatted; please "
                    + "ensure that the password contains at least eight "
                    + "characters, a capital letter, a number, and a special character.";
        }

        assertEquals(
                "Password is not correctly formatted; please ensure that the "
                        + "password contains at least eight characters, a "
                        + "capital letter, a number, and a special character.",
                actualMessage
        );
    }

    /*
     * Test the cell phone success message using assertEquals.
     */
    @Test
    public void testCellPhoneSuccessMessage() 
    {
        Login login = new Login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");

        String actualMessage;
        if (login.checkCellPhoneNumber()) 
        {
            actualMessage = "Cell number successfully captured.";
        } else 
        {
            actualMessage = "Cell number is incorrectly formatted or does not "
                    + "contain an international code; please correct the "
                    + "number and try again.";
        }

        assertEquals("Cell number successfully captured.", actualMessage);
    }

    /*
     * Test the cell phone failure message using assertEquals.
     */
    @Test
    public void testCellPhoneFailureMessage() 
    {
        Login login = new Login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "08966553");

        String actualMessage;
        if (login.checkCellPhoneNumber()) 
        {
            actualMessage = "Cell number successfully captured.";
        } else 
        {
            actualMessage = "Cell number is incorrectly formatted or does not "
                    + "contain an international code; please correct the number and try again.";
        }

        assertEquals(
                "Cell number is incorrectly formatted or does not contain an "
                        + "international code; please correct the number and try again.",
                actualMessage
        );
    }

    /*
     * Test successful login using correct stored details.
     */
    @Test
    public void testLoginUserTrue() 
    {
        Login login = new Login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }

    /*
     * Test failed login using incorrect details.
     */
    @Test
    public void testLoginUserFalse() 
    {
        Login login = new Login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertFalse(login.loginUser("wrongUser", "wrongPassword"));
    }

    /*
     * Test the successful login status message.
     */
    @Test
    public void testReturnLoginStatusSuccess() 
    {
        Login login = new Login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");

        assertEquals(
                "Welcome Kyle, Smith it is great to see you again.",
                login.returnLoginStatus(true)
        );
    }

    /*
     * Test the failed login status message.
     */
    @Test
    public void testReturnLoginStatusFailure() 
    {
        Login login = new Login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");

        assertEquals(
                "Username or password incorrect, please try again.",
                login.returnLoginStatus(false)
        );
    }
}