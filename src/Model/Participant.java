package Model;

import java.util.Date;

public class Participant extends Event {
    private int participantId;
    private String participantName;
    private String contactInformation;

    public Participant(int eventId, String name, Date date, int maxParticipants, Organizer organizer, int participantId, String participantName, String contactInformation)
    {
        super(eventId, name, date, maxParticipants, organizer);
        this.participantId = participantId;
        this.name = name;
        this.contactInformation = contactInformation;
    }


    public Participant(String participantNameName, int participantId) {
        super(name, participantId);
    }


    public int getParticipantId() {
        return participantId;
    }

    public void setParticipantId(int participantId) {
        this.participantId = participantId;
    }

    public String getParticipantName() {
        return participantName;
    }

    public void setParticipantName(String participantName) {
        this.participantName = participantName;
    }

    public String getContactInformation() {
        return contactInformation;
    }


    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    @Override
    public String toString() {
        return "Model.Participant{" +
                "participantId=" + participantId +
                " name=" + participantName + " " +
                ", contactInformation=" + contactInformation + "}";
    }
}
