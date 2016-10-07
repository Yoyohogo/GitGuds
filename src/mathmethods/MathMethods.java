/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathmethods;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * 04/10/2016 author rodec8600 To demonstrate the ability to use and create
 * methods pertaining to mathematics
 */
public class MathMethods {

    /**
     * param args the command line arguments
     */
    //global variables used in all methods, mainly to make things look pretty
    static DecimalFormat x = new DecimalFormat("##.##");
    static int selection;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        //variables to repeat if there is an error as well as variables to store input and output
        boolean repeat = true;
        double first, second;
        String output;

        //run this code at least once, and repeat if there is an error
        do {
            try {
                displayMenu();

                //determines which method to call, based on user input
                selection = Integer.parseInt(scanner.nextLine());

                if (selection == 1) {
                    System.out.println("Input a value and a value to raise the first by:");
                    first = Integer.parseInt(scanner.nextLine());
                    second = Integer.parseInt(scanner.nextLine());
                    output = powMethod(first, second);
                    System.out.println(x.format(first) + " to the power of " + x.format(second) + " equals " + output + ".");
                    //repeatPrompt();
                } else if (selection == 2) {
                    System.out.println("Please enter an angle:");
                    first = Integer.parseInt(scanner.nextLine());
                    output = angleMethod(first);
                    System.out.println("The answer is " + output + ".");
                    //repeatPrompt();
                } else if (selection == 3) {
                    System.out.println("Please enter a value:");
                    first = Integer.parseInt(scanner.nextLine());
                    output = absMethod(first);
                    System.out.println("The absolute value of " + x.format(first) + " is " + output + ".");
                    // repeatPrompt();
                } else if (selection == 4) {
                    System.out.println("Goodbye!");
                    repeat = false;
                } else {
                    System.out.println("\nPlease provide valid input.\n");

                }

                //repeat code if there is an error
            } catch (NumberFormatException e) {
                System.out.println("Please provide valid input.");
                repeat = true;
            }
        } while (repeat == true);
    }

    /**
     * Displays the main menu 
     * PRE: none 
     * POST: none
     */
    public static void displayMenu() {
        System.out.println("Welcome!\n" + "Please select a math function to use, or 4. to close:");
        System.out.println("1.\tPower\n" + "2.\tSin, cos, or tan\n" + "3.\tAbs\n" + "4.\tClose");
    }

    /**
     * Finds the power of two values   
     * PRE: the base value and the value to raise the base by post 
     * POST: the resulting value
     */
    public static String powMethod(double first, double second) {
        String pow = x.format(Math.pow(first, second));
        return pow;
    }

    /**
     * Finds the sine, cosine or tangent of an angle  
     * PRE: a value to represent an angle
     * POST: return the sine, cosine, or tangent of the angle
     */
    public static String angleMethod(double first) {
        double radians = Math.toRadians(first);
        String output = ("");
        System.out.println("1.\tSin\n" + "2.\tCos\n" + "3.\tTan");
        selection = Integer.parseInt(scanner.nextLine());

        if (selection == 1) {
            output = x.format(Math.sin(radians));
            return output;
        } else if (selection == 2) {
            output = x.format(Math.cos(radians));
            return output;
        } else if (selection == 3) {
            output = x.format(Math.tan(radians));
            return output;
        } else {
            System.out.println("Invalid input! Enter an integer between 1 and 3.");
            return output;
        }
    }

    /**
     * Finds the absolute value of a value 
     * PRE: a value to find the absolute value of 
     * POST: return the absolute value of the value
     */
    public static String absMethod(double first) {
        String output = x.format(Math.abs(first));
        return output;
    }
}
