package Model;

import java.util.Date;

public class Registration extends Event {
    private String attendeeName;
    private Event event;

    public Registration(int eventId, String name, Date date, int maxParticipants, Organizer organizer, String attendeeName, Event event) {
        super(eventId, name, date, maxParticipants, organizer);
        this.attendeeName = attendeeName;
        this.event = event;
    }


    public void displayRegistration() {
        System.out.println(attendeeName + " registered for " + event.name + event.eventId);
    }
}
