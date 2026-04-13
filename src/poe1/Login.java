
package poe1;

public class Login 
{
    // These variables store the user's information
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String cellPhoneNumber;

    
    //This allows us to create an object first and then set the values later. 
    public Login() 
    {
    }
    // This is a Constructor with parameters
    // This allows us to create a Login object and immediately give it all the user data.
     
    public Login(String firstName, String lastName, String userName, String 
            password, String cellPhoneNumber) 
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;
    }

    /*
     * This method checks if the username is correctly formatted.
     * - must contain an underscore
     * - must be no more than 5 characters long
     *
     * Returns:
     * - true if valid
     * - false if invalid
     */
    public boolean checkUserName() 
    {
        return userName != null && userName.contains("_") && userName.length() <= 5;
    }

    /*
     * This method checks whether the password meets the requirements.
     * - at least 8 characters long
     * - contains a capital letter
     * - contains a number
     * - contains a special character
     *
     * Returns:
     * - true if password is valid
     * - false if password is invalid
     */
    public boolean checkPasswordComplexity() 
    {
        if (password == null) 
        {
            return false;
        }

        boolean hasCapitalLetter = false;
        boolean hasNumber = false;
        boolean hasSpecialCharacter = false;

        for (int i = 0; i < password.length(); i++) 
        {
            char ch = password.charAt(i);

            if (Character.isUpperCase(ch)) 
            {
                hasCapitalLetter = true;
            } else if (Character.isDigit(ch)) 
            {
                hasNumber = true;
            } else if (!Character.isLetterOrDigit(ch)) 
            {
                hasSpecialCharacter = true;
            }
        }

        return password.length() >= 8 && hasCapitalLetter && hasNumber && hasSpecialCharacter;
    }

    /*
     * This method checks whether the South African cell phone number is valid.
     * - must include the international code (+27)
     * - followed by exactly 9 digits
     *
     * Returns:
     * - true if valid
     * - false if invalid
     */
    public boolean checkCellPhoneNumber() 
    {
        if (cellPhoneNumber == null) 
        {
            return false;
        }

        return cellPhoneNumber.matches("^\\+27\\d{9}$");
    }

    /*
     * This method returns the registration message
     *
     * It checks:
     * - username validity
     * - password validity
     * - phone number validity
     *
     * Returns a specific message depending on user input
     */
    public String registerUser() 
    {
        if (!checkUserName()) 
        {
            return "Username is not correctly formatted; please ensure that "
                    + "your username contains an underscore and is no more than"
                    + " five characters in length.";
        }

        if (!checkPasswordComplexity()) 
        {
            return "Password is not correctly formatted; please ensure that "
                    + "the password contains at least eight characters, a "
                    + "capital letter, a number, and a special character.";
        }

        if (!checkCellPhoneNumber()) 
        {
            return "Cell number is incorrectly formatted or does not contain "
                    + "international code.";
        }

        return "User has been registered successfully.";
    }

    /*
     * This method checks whether the login details entered by the user
     * match the username and password stored during registration.
     *
     * Returns:
     * - true if both match
     * - false if either is incorrect
     */
    public boolean loginUser(String enteredUserName, String enteredPassword) 
    {
        return userName != null
                && password != null
                && userName.equals(enteredUserName)
                && password.equals(enteredPassword);
    }

    /*
     * This method returns the final login message depending on whether login 
     * was successful or not.
     */
    public String returnLoginStatus(boolean loginSuccess) 
    {
        if (loginSuccess) 
        {
            return "Welcome " + firstName + ", " + lastName + " it is great to "
                    + "see you again.";
        } else 
        {
            return "Username or password incorrect, please try again.";
        }
    }

    // Getter and setter methods below allow other classes to access and update the private variables.

    public String getFirstName() 
    {
        return firstName;
    }

    public void setFirstName(String firstName) 
    {
        this.firstName = firstName;
    }

    public String getLastName() 
    {
        return lastName;
    }

    public void setLastName(String lastName) 
    {
        this.lastName = lastName;
    }

    public String getUserName() 
    {
        return userName;
    }

    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getPassword() 
    {
        return password;
    }

    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getCellPhoneNumber() 
    {
        return cellPhoneNumber;
    }

    public void setCellPhoneNumber(String cellPhoneNumber) 
    {
        this.cellPhoneNumber = cellPhoneNumber;
    }
}