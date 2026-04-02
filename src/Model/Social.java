package Model;

import java.util.Date;
public class Social extends Event {
    private String theme;

    public Social(int eventId, String name, Date date, int maxParticipants, Organizer organizer, String theme) {
        super(eventId, name, date, maxParticipants, organizer);
        this.theme= theme;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    @Override
    public String toString() {
        return super.toString();

    }
}
