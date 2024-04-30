class Problem1 extends ConsoleProgram {

  /**
  * Description
  * @author: J. Lau
  */
  
  public void run() {
    // get user values
    System.out.println("***** Student Account Registration *****");
    String strFirstName = readLine("Enter your first name: ");
    String strLastName = readLine("Enter your last name: ");
    String strStudentNumber = readLine("Enter your student number: ");
    String strUsername = readLine("Enter a new username: ");
    System.out.println("");

    boolean isValidPassword = validateUsername(strUsername);
    println("Valid password: " + isValidPassword);

    // show 
    String strPassword = createPassword(strFirstName, strLastName, strStudentNumber);
    println("Your password is: " + strPassword);
  }

  private boolean validateUsername(String password) {
    if (password.length() < 7) {
      return false;
    }
    
    boolean Uppercase = false;
    boolean LetterOrDigit = false;
    
    for (char check : password.toCharArray()) {
      if (Character.isUpperCase(check)) {
        Uppercase = true;
      }
      if (Character.isLetterOrDigit(check)) {
        LetterOrDigit = true;
      }
      if (Uppercase && LetterOrDigit) {
        return true;
      }
    }

    return false;
  }

  private String createPassword(String firstName, String lastName, String studentNumber) {
    // first initial
    char chrInitial = firstName.charAt(0);
    chrInitial = Character.toUpperCase(chrInitial);

    // last initials
    String strLastInitials = lastName.substring(0, Math.min(lastName.length(), 4)).toLowerCase();

    // Middle three digits
    String strMiddleThreeDigits = studentNumber.substring(Math.max(studentNumber.length() - 6, 0));

    String userName = chrInitial + strLastInitials + strMiddleThreeDigits;

    return userName; 
  }
}