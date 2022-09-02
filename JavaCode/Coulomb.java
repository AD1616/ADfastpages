package JavaCode;
import java.util.Scanner;
import java.lang.Math;

public class Coulomb {
    
    // Constructor with the enterValues method. 
    public Coulomb () {
        this.enterValues();
    }
    
    // Generally, charge values can be integers, since charge is quantized.
    // The distance can be a float, since it is often a decimal. 
    // The force is a double due to the size of k.
    private double force;
    private int q1;
    private int q2;
    private float r;
    private static double k = 9 * Math.pow(10, 9);
    
    public static void main(String[] args) {
        // Creating an object of the Coulomb class. The constructor calls the enterValues method.
        Coulomb calc = new Coulomb();
    }
    
    private void enterValues() {
        Scanner input;
        
        // 3 while loops with try-catch statements to make sure the correct datatype is inputted.
        while (true) {
            input = new Scanner(System.in);
            System.out.print("Enter the first charge: ");
            try {
                q1 = input.nextInt();
                break;
            } catch (Exception e) {  // if not a number
                System.out.println("Not an int" + e);
            }
            input.close();
        }

        while (true) {
            input = new Scanner(System.in);
            System.out.print("Enter the second charge: ");
            try {
                q2 = input.nextInt();
                break;
            } catch (Exception e) {  // if not a number
                System.out.println("Not an int" + e);
            }
            input.close();  
        }

        while (true) {
            input = new Scanner(System.in);
            System.out.print("Enter the distance between the charges: ");
            try {
                r = input.nextFloat();
                break;
            } catch (Exception e) {  // if not a number
                System.out.println("Not a float" + e);
            }
            input.close(); 
        }

        
        CalculateCoulomb();
        System.out.println("The force between the two charges, by Coulomb's Law, is " + force + " Coulombs");
        
        // If the user wishes to continue, they can enter new values. If not, the program exits.
        if (moreCalc()) {
            enterValues();
        }
        else {
            System.out.println("Exited.");
            return;
        }
    }
    
    // The actual calculator. A simple formula called Coulomb's Law is employed.
    // The method itself is of type double, and outputs the force which is of double datatype. 
    public double CalculateCoulomb() {
        force = (k * q1 * q2 / (Math.pow(r, 2)));
        return force;
    }
    
    // This method checks if the user wishes to do a new calculation.
    // The method is of type boolean, and outputs true if the user wants to enter new values, and false otherwise.
    public boolean moreCalc() {
        Scanner input;
        input = new Scanner(System.in);
        System.out.print("Do you wish to continue? Type Yes to continue, or anything else to exit. ");
        String chosen = input.nextLine();
        // String is a class. Therefore, the object of the String class, chosen, has methods.
        // The .equals method is used to check if two strings are equivalent.
        if (chosen.equals("Yes")) {
            return true;
        }
        else {
            return false;
        }

    }
}
