package Model;

import java.util.Date;


public class Event {
    protected Integer eventId; // AP: Consider using Integer so this can be nullable
    protected String name;
    protected Date date;
    protected int maxParticipants;
    protected Organizer organizer;


    public Event(int eventId, String name, Date date, int maxParticipants, Organizer organizer) {
        this.eventId = eventId;
        this.name = name;
        this.date = date;
        this.maxParticipants = maxParticipants;
        this.organizer = organizer;
    }

    public Event(String name, Date date, int maxParticipants, Organizer organizer) {
        // AP: When creating a new organizer, you do not have any ID
        // The ID is only created upon insertion to the DB. So you need a way to create a NEW Organizer object without any ID
        this.eventId = null;
        this.name = name;
        this.date = date;
        this.maxParticipants = maxParticipants;
        this.organizer = organizer;
    }


    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(int maxParticipants) {
        this.maxParticipants = maxParticipants;
    }

    public Organizer getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }

    @Override
    public String toString() {
        return "Model.Event{" +
                "eventId=" + eventId +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", maxParticipants=" + maxParticipants +
                ", organizer=" + organizer +
                '}';
    }

}
