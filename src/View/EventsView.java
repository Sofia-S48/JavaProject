package View;

import java.util.Scanner;

public class EventsView {
    public static void run(){

        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("Menu: ");
            System.out.println("1. List all Events ");
            System.out.println("2. Add events ");
            System.out.println("3. Search the event by ID ");
            System.out.println("4. Exit ");

            System.out.println("Choose an option");

            Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    listEvents();
                    break;
                case 2:
                    addEvents();
                    break;
                case 3:
                    searchEvent();
                    break;

                case 4:
                    System.out.println("Exiting to main menu");
                    break;
                    // AP: When exiting does this go back to ConsoleApp menu or exit the program?
                default:
                    System.out.println("The choice is invalid.");
            }
        } while (choice != 4); // if user doesn't choose choice 4
    }

    //Methods
    // AP: Does not launch the forms or execute any functions
    private static void listEvents() {
        System.out.println("Listing all Events: ");
    }
    private static void addEvents() {
        System.out.println("Adding events: ");
    }
    private static void searchEvent() {
        System.out.println("Searching Event by ID: ");
    }
}