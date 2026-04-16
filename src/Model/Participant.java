package Model;

import java.util.Date;

public class Participant  { // changed class to not extend Event.
    private int participantId;
    private String participantName;
    private String contactInformation;

    public Participant(int participantId, String participantName, String contactInformation)
    {
        this.participantId = participantId;
        this.participantName = participantName;
        this.contactInformation = contactInformation;
    }

    public Participant(String participantName, int participantId) {
        super();
    }


    public Participant(String participantName, int participantId) {
        super();
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
