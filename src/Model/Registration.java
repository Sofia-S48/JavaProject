package Model;

import java.time.LocalDate;
import java.util.Date;

public class Registration  {
    private int registrationId;
    private int eventId;
    private int participantId;
    private LocalDate registrationDate;

    public Registration( int eventId, int participantId) {
        this.eventId = eventId;
        this.participantId = participantId;
        this.registrationDate = LocalDate.now();

    }

    public Registration(int registrationId, int eventId, int participantId) {
        this.registrationId = registrationId;
        this.eventId = eventId;
        this.participantId = participantId;
    }

    public Registration(int eventId, int participantId, LocalDate registrationDate) {
        this.eventId = eventId;
        this.participantId = participantId;
        this.registrationDate = registrationDate;
    }

    public Registration(int registrationId, int eventId, int participantId, Date registrationDate) {
    }


    public int getRegistrationId(){return registrationId;}
    public int getEventId(){return eventId;}
    public int getParticipantId(){return participantId;}
    public LocalDate getRegistrationDate(){return registrationDate;}

    public void setRegistrationId(int registrationId) {this.registrationId = registrationId;}

    public void displayRegistration()
    {
        System.out.println("Participant "+ participantId+ " registered for event" + eventId);
    }
}
