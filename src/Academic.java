import java.util.Date;
public class Academic extends Event{
    public String subject;
    public String speaker;


    public Academic(int eventId, String name, Date date, int maxParticipants, Organizer organizer, String subject, String speaker) {
        super(eventId, name, date, maxParticipants, organizer);
        this.subject = subject;
        this.speaker = speaker;
    }


}
