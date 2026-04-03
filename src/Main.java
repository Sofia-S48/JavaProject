import Model.Participant;
import jdk.jfr.Event;

import java.util.Scanner;

public class Main {
    private static int id;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Event event = null;
        int choice;

        do {
            System.out.println("\n===== EVENT MENU =====");
            System.out.println("1. Create Event");
            System.out.println("2. Add Participant");
            System.out.println("3. Show Participants");
            System.out.println("4. Exit");
            System.out.print("Choose: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("What type of event would you like to create?");
                    System.out.println("1. Professional");
                    System.out.println("2. Social");
                    System.out.println("3. Academic");
                    int eventType  = scanner.nextInt();
                    switch (eventType) {


                    }
                    System.out.print("Enter event name: ");
                    String eventName = scanner.nextLine();

                    System.out.println("Event created successfully!");
                    break;

                case 2:
                    //ask event id, if event id is not found
                    if (event == null) {
                        System.out.println("Please create an event first.");
                        break;
                    }

                    System.out.print("Enter participant name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter participant ID: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();


                    Participant participant = new Participant(name, id);
                    event.registerParticipant(participant);
                    break;

                case 3:
                    if (event == null) {
                        System.out.println("No event created yet.");
                    } else {
                        event.showParticipants();
                    }
                    break;

                case 4:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option.");
            }

        } while (choice != 4);

        scanner.close();
    }
}
