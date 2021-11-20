package com.charlene.app.api;

import java.util.Scanner;

public class CoffeeConsole {

    private Scanner scanner;

    public CoffeeConsole() {
        scanner = new Scanner(System.in);
    }

    public String getOrderFromClient() {
        System.out.println("Please enter the order, then press ENTER:");

        return scanner.nextLine();
    }

    public String getCustomerID() {
        System.out.println("Please enter customerID, then press ENTER:");

        return scanner.next();
    }

    public void displayMenu() {
        System.out.println(
                "CHARLENE'S COFFEE CORNER\n\n" +
                        "Name                           Price\n" +
                        "Coffee - Small                 2.50 CHF\n" +
                        "Coffee - Medium                3 CHF\n" +
                        "Coffee - Large                 3.5 CHF\n" +
                        "Bacon Roll                     4.50 CHF\n" +
                        "Freshly Squeezed Orange juice  3.95 CHF" +
                        "\n\n" +

                        "Extras                         Price\n" +
                        "Extra milk                     2.50 CHF\n" +
                        "Foamed milk                    3 CHF\n" +
                        "Special roast coffee           3.5 CHF\n");

    }

    public void printReceiptOnScreen(String receipt) {
        System.out.println(receipt);
    }
}
