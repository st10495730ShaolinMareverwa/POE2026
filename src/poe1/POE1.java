    
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
        
        