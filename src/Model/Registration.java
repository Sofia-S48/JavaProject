package Model;

import java.util.Date;

public class Registration  {
    private int registrationId;
    private int eventId;
    private int participantId;
    private Date registrationDate;

    public Registration(int registrationId, int eventId, int participantId, Date registrationDate) {
        this.registrationId = registrationId;
        this.eventId = eventId;
        this.participantId = participantId;
        this.registrationDate = registrationDate;
    }
    public int getRegistrationId(){return registrationId;}
    public int getEventId(){return eventId;}
    public int getParticipantId(){return participantId;}
    public Date getRegistrationDate(){return registrationDate;}

    public void displayRegistration()
    {
        System.out.println("Participant "+ participantId+ " registered for event" + eventId);
    }
}
