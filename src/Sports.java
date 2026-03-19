import java.util.Date;
public class Sports extends Event {
    private String sportType;

    public Sports(int eventId, String name, Date date, int maxParticipants, Organizer organizer, String sportsType) {
        super(eventId, name, date, maxParticipants, organizer);
        this.sportType = sportsType;

    }

    public String getSportType() {
        return sportType;
    }

    public void setSportType(String sportType) {
        this.sportType = sportType;
    }
}
