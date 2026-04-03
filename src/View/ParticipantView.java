import java.util.Scanner;

public static class ParticipantView {
    public static void run(){
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running){
            System.out.println("Menu: ");
            System.out.println("1. List all Participant");
            System.out.println("2. Add Participant");
            System.out.println("3. Search participant by ID");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice){
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
}
private static void listParticipants(){
    System.out.println("Listing all participants: ");
}
private static void addParticipant(){
    System.out.println("Adding new participant: ");
}
private static void searchParticipant(){
    System.out.println("Searching for participant: ");
}

void main() {
}