    
package poe1;

import java.util.Scanner;
public class POE1 
{

    
    public static void main(String[] args) 
    {
      
        // Scanner is used to read input from the keyboard
        Scanner input = new Scanner(System.in);

        // Create a Login object to store details and use the validation methods
        Login login = new Login();

        // Registration 'heading'
        System.out.println("=== Registration ===");

        // Ask user for their first name
        System.out.print("Enter first name: ");
        login.setFirstName(input.nextLine()); 

        // Ask user for their last name
        System.out.print("Enter last name: ");
        login.setLastName(input.nextLine());

        // Ask user for their preferred username
        System.out.print("Enter username: ");
        login.setUserName(input.nextLine());

        // Check inputted username and show the appropriate message
        if (login.checkUserName()) 
        {
            System.out.println("Username successfully captured.");
        } else 
        {
            System.out.println("Username is not correctly formatted; please "
                    + "ensure that your username contains an underscore and is "
                    + "no more than five characters in length.");
        }

        // Ask user for password
        System.out.print("Enter password: ");
        login.setPassword(input.nextLine());
        
        // Check password and show the appropriate message
        if (login.checkPasswordComplexity()) 
        {
            System.out.println("Password successfully captured.");
        } else 
        {
            System.out.println("Password is not correctly formatted; please "
                    + "ensure that the password contains at least eight "
                    + "characters, a capital letter, a number, and a special "
                    + "character.");
        }

        // Ask user for a South African cell phone number
        System.out.print("Enter South African cell phone number with "
                + "international code: ");
        login.setCellPhoneNumber(input.nextLine());

        // Check cell phone number and show the correct assignment message
        if (login.checkCellPhoneNumber()) 
        {
            System.out.println("Cell phone number successfully added.");
        } else 
        {
            System.out.println("Cell phone number incorrectly formatted or does "
                    + "not contain international code.");
        }
        
        // Call registerUser to show the overall registration result
        System.out.println(login.registerUser());

        // Login header
        System.out.println("\n=== Login ===");

        // Ask for username again for login
        System.out.print("Enter username: ");
        String enteredUserName = input.nextLine();

        // Ask for password again for login
        System.out.print("Enter password: ");
        String enteredPassword = input.nextLine();

        // Check whether login details match the stored details
        boolean loginSuccess = login.loginUser(enteredUserName, enteredPassword);

        // Display the final login message
        System.out.println(login.returnLoginStatus(loginSuccess));

        // Close scanner
        input.close();
    }
    
}

        
        