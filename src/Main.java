
import Model.*; // i looked up that this will import everything in our model folder. makes things look neater.
import controller.EventController;
import controller.ParticipantController;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {

        Scanner scanner = new Scanner(System.in);
        Event event = null;
        //added Event and Participant Controller as a test
        EventController eventController = new EventController();
        ParticipantController participantController = new ParticipantController();

        int choice;

        do {
            System.out.println("\n ===== MAIN MENU =====");
            System.out.println("1. Event Menu");
            System.out.println("2. Export Menu");
            System.out.println("3.Organizer Menu");
            System.out.println("4.Participant Menu");
            System.out.println("5.Registration Menu");
            System.out.println("0. Exit");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    int eventChoice;

                    do {
                        System.out.println("\n ===== EVENT MENU =====");
                        System.out.println("1. Add Event");
                        System.out.println("2. Remove Event");
                        System.out.println("3. Display all Events");
                        System.out.println("4. Search Event by Id");
                        System.out.println("0. Back");

                        eventChoice = scanner.nextInt();
                        scanner.nextLine();

                        switch (eventChoice) {

                            case 1:
                                System.out.println("What type of event would you like to create?");
                                System.out.println("1. Professional");
                                System.out.println("2. Social");
                                System.out.println("3. Academic");

                                int eventType = scanner.nextInt();
                                scanner.nextLine();

                                System.out.print("Enter event ID: ");
                                int eventId = scanner.nextInt();
                                scanner.nextLine();

                                System.out.print("Enter event name: ");
                                String eventName = scanner.nextLine();

                                System.out.print("Enter max participants: ");
                                int maxParticipants = scanner.nextInt();
                                scanner.nextLine();

                                Organizer organizer = new Organizer(1, "Default", "default@email.com");
                                Date date = new Date();

                                Event event = null;

                                switch (eventType) {
                                    case 1:
                                        System.out.print("Enter subject: ");
                                        String proSubject = scanner.nextLine();
                                        System.out.print("Enter industry: ");
                                        String industry = scanner.nextLine();

                                        event = new Professional(eventId, eventName, date, maxParticipants, organizer, proSubject, industry);
                                        break;

                                    case 2:
                                        System.out.print("Enter theme: ");
                                        String theme = scanner.nextLine();

                                        event = new Social(eventId, eventName, date, maxParticipants, organizer, theme);
                                        break;

                                    case 3:
                                        System.out.print("Enter subject: ");
                                        String academicSubject = scanner.nextLine();
                                        System.out.print("Enter speaker: ");
                                        String speaker = scanner.nextLine();

                                        event = new Academic(eventId, eventName, date, maxParticipants, organizer, academicSubject, speaker);
                                        break;

                                    default:
                                        System.out.println("Invalid type.");
                                }

                                if (event != null) {
                                    eventController.addEvent(event);
                                    System.out.println("Event created successfully!");
                                }

                                break;

                            case 2:
                                System.out.println("Enter event ID to remove:");
                                int removeId = scanner.nextInt();
                                scanner.nextLine();

                                eventController.removeEvent(removeId);
                                break;

                            case 3:
                                eventController.displayEvents();
                                break;

                            case 4:
                                System.out.println("Enter event ID to search:");
                                int searchId = scanner.nextInt();
                                scanner.nextLine();

                                eventController.searchEventById(searchId);
                                break;

                        if (event != null) {
                            eventController.addEvent(event);
                            System.out.println("Event created successfully!");
                        }

                    } while (eventChoice != 0);

                    break;

                case 2:
                    int exportChoice;

                    do{
                        System.out.println("n/==== Export Menu ====");
                        System.out.println("1. Export Participants");
                        System.out.println("2. Export Events");
                        System.out.println("3. Export Registrations");
                        System.out.println("0. Exit");
                        exportChoice = scanner.nextInt();
                        scanner.nextLine();

                        switch (exportChoice){
                            case 1:
                                System.out.println("What would you like your file name to be?");
                                String fileName = scanner.nextLine();
                                exportController.exportParticipantsToTXT((ArrayList<Participant>) participantController.getAllParticipants(), fileName);
                                break;

                        Participant participant = new Participant(participantId, name, contactInformation);
                        participantController.addParticipant(participant);
                        System.out.println("Participant created successfully");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 3:
                    int organizerChoice;

                        for (Participant p : participantController.getAllParticipants()) {
                            System.out.println(p);
                        }

                                organizerController.updateOrganizer(updatedOrganizer);
                                break;

                            case 4:
                                organizerController.getAllOrganizers();
                                break;
                            case 5:
                                System.out.println("Enter ID to search:");
                                int searchId = scanner.nextInt();
                                scanner.nextLine();

                                organizerController.getOrganizerById(searchId);
                                break;
                        }
                    } while (organizerChoice != 0);
                    break;

                case 4:
                    int participantChoice;

                    do {
                        System.out.println("n/==== Participant Menu ====");
                        System.out.println("1. Add Participant");
                        System.out.println("2. Remove Participant");
                        System.out.println("3. Display all Participants");
                        System.out.println("4. Search Participant by Id");
                        System.out.println("0. Back");
                        participantChoice = scanner.nextInt();
                        scanner.nextLine();

                        switch (participantChoice){
                            case 1:
                                System.out.println("Please enter the Participant Id");
                                int participantId = scanner.nextInt();
                                scanner.nextLine();

                                System.out.println("Please enter Participant name");
                                String participantName = scanner.nextLine();

                                System.out.println("Please enter contact information");
                                String contactInformation = scanner.nextLine();

                                Participant participant = new Participant(participantId, participantName, contactInformation);

                                participantController.addParticipants(participant);
                                break;

                            case 2:
                                System.out.println("Enter Participant ID to remove:");
                                int removeId = scanner.nextInt();
                                scanner.nextLine();

                                participantController.removeParticipants(removeId);
                                break;

                            case 3:
                                participantController.displayParticipants();
                                break;

                            case 4:
                                System.out.println("Enter ID to search:");
                                int searchId = scanner.nextInt();
                                scanner.nextLine();

                                participantController.searchParticipantById(searchId);
                                break;

                        }
                    }while (participantChoice != 0);
                    break;

                case 5:
                    int registrationChoice;

                    do {
                        System.out.println("n/==== Participant Menu ====");
                        System.out.println("1. Add Participant");
                        System.out.println("2. Remove Participant");
                        System.out.println("3. Display all Participants");
                        System.out.println("4. Search Participant by Id");
                        System.out.println("0. Back");
                        registrationChoice = scanner.nextInt();
                        scanner.nextLine();

                        switch (registrationChoice){
                            case 1:
                                System.out.println("Please enter the Registration Id");
                                int registrationId = scanner.nextInt();
                                scanner.nextLine();

                                System.out.println("Please enter Event Id");
                                int eventId = scanner.nextInt();
                                scanner.nextLine();

                                System.out.println("Please enter Participant Id");
                                int participantId = scanner.nextInt();
                                scanner.nextLine();

                                Registration registration = new Registration(registrationId, eventId, participantId);

                                RegistrationController.addRegistration(registration);
                                break;

                            case 2:
                                System.out.println("Enter Registration ID to remove:");
                                int removeId = scanner.nextInt();
                                scanner.nextLine();

                                registrationController.deleteRegistration(removeId);
                                break;

                            case 3:
                                registrationController.displayRegistrations();
                                break;

                            case 4:
                                System.out.println("Enter Event ID to search:");
                                int searchId = scanner.nextInt();
                                scanner.nextLine();

                                registrationController.getRegistrationByEventId(searchId);
                                break;

                        }
                    }while (registrationChoice != 0);
                    break;


            }

        } while (choice != 0);

        scanner.close();
    }
}
//        do {
//            System.out.println("\n===== EVENT MENU =====");
//            System.out.println("1. Create Event");
//            System.out.println("2. Add Participant");
//            System.out.println("3. Show Participants");
//            System.out.println("4. Exit");
//            System.out.print("Choose: ");
//            choice = scanner.nextInt();
//            scanner.nextLine();
//
//            switch (choice) {
//
//                case 1:
//                    try {
//                        System.out.println("What type of event would you like to create?");
//                        System.out.println("1. Professional");
//                        System.out.println("2. Social");
//                        System.out.println("3. Academic");
//                        int eventType = scanner.nextInt();
//                        scanner.nextLine();
//
//                        System.out.print("Enter event ID: ");
//                        int eventId = scanner.nextInt();
//                        scanner.nextLine();
//
//                        System.out.print("Enter event name: ");
//                        String eventName = scanner.nextLine();
//
//                        System.out.print("Enter max participants: ");
//                        int maxParticipants = scanner.nextInt();
//                        scanner.nextLine();
//
//                        Organizer organizer = new Organizer(1, "Default", "default@email.com");
//                        Date date = new Date();
//
//                        switch (eventType) {
//                            case 1:
//                                System.out.print("Enter subject: ");
//                                String proSubject = scanner.nextLine();
//                                System.out.print("Enter industry: ");
//                                String industry = scanner.nextLine();
//
//                                event = new Professional(eventId, eventName, date, maxParticipants, organizer, proSubject, industry);
//                                break;
//
//                            case 2:
//                                System.out.print("Enter theme: ");
//                                String theme = scanner.nextLine();
//
//                                event = new Social(eventId, eventName, date, maxParticipants, organizer, theme);
//                                break;
//
//                            case 3:
//                                System.out.print("Enter subject: ");
//                                String academicSubject = scanner.nextLine();
//                                System.out.print("Enter speaker: ");
//                                String speaker = scanner.nextLine();
//
//                                event = new Academic(eventId, eventName, date, maxParticipants, organizer, academicSubject, speaker);
//                                break;
//
//                            default:
//                                System.out.println("Invalid type.");
//                                break;
//                        }
//
//                        if (event != null) {
//                            eventController.addEvent(event);
//                            System.out.println("Event created successfully!");
//                        }
//
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                    break;
//
//                case 2:
//                    try {
//                        if (event == null) {
//                            System.out.println("Please create an event first.");
//                            break;
//                        }
//
//                        System.out.print("Enter participant name: ");
//                        String name = scanner.nextLine();
//
//                        System.out.print("Enter participant ID: ");
//                        int participantId = scanner.nextInt();
//                        scanner.nextLine();
//
//                        System.out.print("Enter contact information: ");
//                        String contactInformation = scanner.nextLine();
//
//                        Participant participant = new Participant(participantId, name, contactInformation);
//                        participantController.addParticipant(participant);
//                        System.out.println("Participant created successfully");
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                    break;
//
//                case 3:
//                    try {
//                        System.out.println("All participants:");
//
//                        for (Participant p : participantController.getAllParticipants()) {
//                            System.out.println(p);
//                        }
//
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                    break;
//
//                case 4:
//                    System.out.println("Goodbye!");
//                    break;
//
//                default:
//                    System.out.println("Invalid option.");
//            }
//
//        } while (choice != 4);

