/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathmethods;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * 04/10/2016
 * author rodec8600 
 * To demonstrate the ability to use and create methods pertaining to mathematics
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
                selection = scanner.nextInt();
                if (selection == 1) {
                    System.out.println("Input a value and a value to raise the first by:");
                    first = scanner.nextInt();
                    second = scanner.nextInt();
                    output = powMethod(first, second);
                    System.out.println(x.format(first) + " to the power of " + x.format(second) + " equals " + output + ".");
                    //repeatPrompt();
                } else if (selection == 2) {
                    System.out.println("Please enter an angle:");
                    first = scanner.nextInt();
                    output = angleMethod(first);
                    System.out.println("The answer is " + output + ".");
                    //repeatPrompt();
                } else if (selection == 3) {
                    System.out.println("Please enter a value:");
                    first = scanner.nextInt();
                    output = absMethod(first);
                    System.out.println("The absolute value of " + x.format(first) + " is " + output + ".");
                   // repeatPrompt();
                } else if (selection == 4) {
                    System.out.println("Goodbye!");
                    repeat = false;
                } else {
                    System.out.println(selection + " is not valid input. Please provide valid input.\n");
                    
                }

                //repeat code if there is an error
            } catch (Exception e) {
                System.out.println("Please provide valid input.");
                repeat = true;
            }
        } while (repeat == true);
    }

    /**
     * Displays the main menu
     *  pre none
     *  post none
     */
    public static void displayMenu() {
        System.out.println("Welcome!\n" + "Please select a math function to use, or 4. to close:");
        System.out.println("1.\tPower\n" + "2.\tSin, cos, or tan\n" + "3.\tAbs\n" + "4.\tClose");
    }

    /**
     * Finds the power of two values
     * pre first, the base value
     * pre second, the value to raise the base by
     * post the resulting double
     */
    public static String powMethod(double first, double second) {
        String pow = x.format(Math.pow(first, second));
        return pow;
    }

    //WIP
    /*private static void repeatPrompt() {
        System.out.println("Would you like to use another method? <1=Yes, 0=No>");
        selection = scanner.nextInt();
        if (selection == 1) {
            repeat = true;

        } else if (selection == 2) {
            repeat = false;
            System.exit(0);
        } else {
            System.out.println("Invalid input!");
        }

    }*/

    /**
     * Finds the sine, cosine or tangent of an angle
     * pre first, a value to represent an angle
     * return the sine, cosine, or tangent of the angle
     */
    public static String angleMethod(double first) {
        double radians = Math.toRadians(first);
        String output = ("");
        System.out.println("1.\tSin\n" + "2.\tCos\n" + "3.\tTan");
        selection = scanner.nextInt();

        if (selection == 1) {
            output = x.format(Math.sin(radians));
            return output;
        } else if (selection == 2) {
            output = x.format(Math.cos(first));
            return output;
        } else if (selection == 3) {
            output = x.format(Math.tan(first));
            return output;
        } else {
            System.out.println("Invalid input! Enter an integer between 1 and 3.");
            return output;
        }
    }

    /**
     * Finds the absolute value of a value
     * pre first, a value to find the absolute value of
     * return the absolute value of the value
     */
    public static String absMethod(double first) {
        String output = x.format(Math.abs(first));
        return output;
    }
}
