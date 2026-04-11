package View;

import java.util.Scanner;

public class ParticipantView {
    public static void run(){
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while(running){
            System.out.println("Menu");
            System.out.println("1. List all Participants");
            System.out.println("2. Add Participants");
            System.out.println("3. Search participant by ID");
            System.out.println("4.Exit");
            System.out.println("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    listParticipants();
                    break;
                case 2:
                    addParticipant();
                    break;
                case 3:
                    searchParticipant();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again");
            }


        }
    }
    private static void listParticipants(){
        System.out.println("List all participants:");
    }
    private static void addParticipant(){
        System.out.println("Adding new participant");
    }
    private static void searchParticipant(){
        System.out.println("Searching for participant");
    }
}
