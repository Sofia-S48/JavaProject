import DAO.EventDAO;
import DAO.ParticipantDAO;
import Model.*; // i looked up that this will import everything in our model folder. makes things look neater.
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Event event = null;
        //added Event and Participant DAO as a test
        EventDAO eventDAO = new EventDAO();
        ParticipantDAO participantDAO = new ParticipantDAO();

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
                    try {
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
                                break;
                        }

                        if (event != null) {
                            eventDAO.addEvent(event);
                            System.out.println("Event created successfully!");
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 2:
                    try {
                        if (event == null) {
                            System.out.println("Please create an event first.");
                            break;
                        }

                        System.out.print("Enter participant name: ");
                        String name = scanner.nextLine();

                        System.out.print("Enter participant ID: ");
                        int participantId = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Enter contact information: ");
                        String contactInformation = scanner.nextLine();

                        Participant participant = new Participant(participantId, name, contactInformation);
                        participantDAO.addParticipant(participant);
                        System.out.println("Participant created successfully");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 3:
                    try {
                        System.out.println("All participants:");

                        for (Participant p : participantDAO.getAllParticipants()) {
                            System.out.println(p);
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
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