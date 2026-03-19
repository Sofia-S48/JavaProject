public class Registration {
    private String attendeeName;
    private Event event;

    public Registration(String attendeeName, Event event) {
        this.attendeeName = attendeeName;
        this.event = event;
    }

    public void displayRegistration() {
        System.out.println(attendeeName + " registered for " + event.name);
    }
}
