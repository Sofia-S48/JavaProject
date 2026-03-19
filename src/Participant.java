public class Participant {
    private int participantId;
    private String name;
    private String contactInformation;

    public Participant(int participantId, String name, String contactInformation) {
        this.participantId = participantId;
        this.name = name;
        this.contactInformation = contactInformation;
    }

    public int getParticipantId() {
        return participantId;
    }

    public void setParticipantId(int participantId) {
        this.participantId = participantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "participantId=" + participantId +
                " name=" + name + " " +
                ", contactInformation=" + contactInformation + "}";
    }
}
