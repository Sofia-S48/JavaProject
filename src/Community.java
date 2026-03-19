import java.util.Date;
public class Community extends Event{
    public String purpose;


    public Community(int eventId, String name, Date date, int maxParticipants, Organizer organizer, String purpose) {
        super(eventId, name, date, maxParticipants, organizer);
        this.purpose= purpose;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

}
