package se.lexicon.vecka41; // Package declaration: Groups this class under the lexicon namespace for the week 41 assignments,
// ensuring a clean, organized project structure and avoiding naming conflicts.

import java.util.Scanner;

public class CafeApp {

    void main() {
        Scanner scanner = new Scanner(System.in);
        // Using Scanner instead of BufferedReader because it is easier and more convenient
        // for parsing primitive data types like int and double directly from user input.

        // 1. Ask for name
        System.out.print("Welcome! What is your name? ");
        String name = scanner.nextLine();

        System.out.println("\nHi " + name + "! Here is our menu:");
        System.out.println("==============================");
        System.out.println("         Lexicon Cafe");
        System.out.println("==============================");
        System.out.println("1. Espresso         25.00 SEK");
        System.out.println("2. Cappuccino       35.00 SEK");
        System.out.println("3. Latte            40.00 SEK");
        System.out.println("4. Croissant        30.00 SEK");
        System.out.println("5. Sandwich         55.00 SEK");

        // 2. Select item
        System.out.print("Enter item number (1-6): ");
        int choice = scanner.nextInt();

        // How many of the item
        System.out.print("How many? ");
        int quantity = scanner.nextInt();

        // 4. Loyal member?
        System.out.print("Loyalty member? (yes/no): ");
        scanner.nextLine(); // Rensa bufferten
        String loyalty = scanner.nextLine().trim().toLowerCase();

        // Modern switch with arrow syntax (->) to return values directly
        String itemName = switch (choice) {
            case 1 -> "Espresso";
            case 2 -> "Cappuccino";
            case 3 -> "Latte";
            case 4 -> "Croissant";
            case 5 -> "Sandwich";
            default -> "Unknown item";
        };

        double pricePerItem = switch (choice) {
            case 1 -> 25.00;
            case 2 -> 35.00;
            case 3 -> 40.00;
            case 4 -> 30.00;
            case 5 -> 55.00;
            default -> 0.00;
        };

        // Calculations
        double subtotal = pricePerItem * quantity;

        double discount = 0.0;
        if (loyalty.equals("yes")) {
            discount = subtotal * 0.15; // 15% discount
        }

        double discountedTotal = subtotal - discount;

        // VAT calculation
        double netSum = discountedTotal / 1.12;
        double vat = discountedTotal - netSum;
        double total = discountedTotal;

        // 5. Skriv ut kvitto
        System.out.println("==============================");
        System.out.println("          LEXICON CAFE");
        System.out.println("==============================");
        System.out.println("Customer  : " + name);
        System.out.println("Item      : " + itemName + " x " + quantity);
        System.out.printf("Subtotal  : %.2f SEK\n", subtotal);
        if (discount > 0) {
            System.out.printf("Discount  : -%.2f SEK\n", discount);
        }
        System.out.printf("VAT       : %.2f SEK\n", vat);
        System.out.printf("TOTAL     : %.2f SEK\n", total);
        System.out.println("   Thank you, " + name + "!");
        System.out.println("   See you next time.");
        System.out.println("==============================");

        scanner.close();
    }
}