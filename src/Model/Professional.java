package Model;

import java.util.Date;
public class Professional extends Event {
    public String subject;
    public String industry;


    public Professional(int eventId, String name, Date date, int maxParticipants, Organizer organizer, String subject, String industry) {
        super(eventId, name, date, maxParticipants, organizer);
        this.subject = subject;
        this.industry = industry;
    }

    public Professional(String name, Date date, int maxParticipants, Organizer organizer, String subject, String industry) {
        super(name, date, maxParticipants, organizer);
        this.subject = subject;
        this.industry = industry;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }
}
