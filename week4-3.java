import java.util.Scanner;

 
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

  class ExceptionHandlingExample {

    
    public static void handleExceptions(int choice, int num1, int num2, String name, int age) throws InvalidAgeException {
        switch (choice) {
            case 1:
                 
                try {
                    System.out.println("Result of division: " + (num1 / num2));
                } catch (ArithmeticException e) {
                    System.out.println("Error: Cannot divide by zero.");
                }
                break;

            case 2:
                 
                try {
                    System.out.println("Length of the name: " + name.length());
                } catch (NullPointerException e) {
                    System.out.println("Error: Name cannot be null.");
                }
                break;

            case 3:
                 
                if (age < 18) {
                    throw new InvalidAgeException("Age must be 18 or above.");
                } else {
                    System.out.println("Valid age: " + age);
                }
                break;

            default:
                System.out.println("Invalid choice.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice, num1 = 0, num2 = 0, age = 0;
        String name = null;
		boolean run=true;
        while(run){
        System.out.println("1. Division (ArithmeticException) \n2. Name Length (NullPointerException)\n3. Age Validation (Custom Exception) \n4. Exit \nEnter your choice: ");
         
        choice = sc.nextInt();
         
        try {
            switch (choice) {
                case 1:
                   
                    System.out.print("Enter first number: ");
                    num1 = sc.nextInt();
                    System.out.print("Enter second number: ");
                    num2 = sc.nextInt();
                    break;
                case 2:
                     
                    System.out.print("Enter name (or leave empty for null): ");
                    sc.nextLine();  
                    name = sc.nextLine();
                    if (name.isEmpty()) name = null;
                    break;
                case 3:
                     
                    System.out.print("Enter age: ");
                    age = sc.nextInt();
                    break;
				case 4:
				      
					  System.out.print("Exit");
					  run=false;
					  break;
					  
                default:
                    System.out.println("Invalid choice.");
                    return;
            }
 
            handleExceptions(choice, num1, num2, name, age);

        } catch (InvalidAgeException e) {
             
            System.out.println("Custom Exception: " + e.getMessage());
        } catch (Exception e) {
             
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            System.out.println("Program execution completed.");
        }
		}

         
    }
}
