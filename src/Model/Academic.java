package Model;

import java.util.Date;
public class Academic extends Event{
    public String subject;
    public String speaker;


    public Academic(int eventId, String name, Date date, int maxParticipants, Organizer organizer, String subject, String speaker) {
        super(eventId, name, date, maxParticipants, organizer);
        this.subject = subject;
        this.speaker = speaker;
    }

    public Academic(String name, Date date, int maxParticipants, Organizer organizer, String subject, String speaker) {

        super(name, date, maxParticipants, organizer);
        this.subject = subject;
        this.speaker = speaker;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }
}
