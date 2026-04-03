package View;

import Model.Participant;

import java.util.Scanner;

public class ConsoleApp {
    public static void run() {

        System.out.println("Welcome to the Events Management Program ");

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            //Displaying the menu
            System.out.println("1. Manage Events ");
            System.out.println("2. Manage Participants");
            System.out.println("3. Exit ");
            System.out.println("Choose an option");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    EventsView.run();
                    break;
                case 2:
                    ParticipantView.run();
                    break;
                case 3:
                    System.out.println("Leaving the program.");
                    break;
                default:
                    System.out.println("The choice is invalid.");
            }
        } while (choice != 3); // if user doesn't choose choice 3
    }
}

