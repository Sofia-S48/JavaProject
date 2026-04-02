package controller;

import Model.Event;

import java.util.ArrayList;
public class EventController {
    private ArrayList<Event> events;

    public EventController() {
        events = new ArrayList<>();
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public Event searchEventById(int id) {
        for (int i = 0; i < events.size(); i++) {
            Event event = events.get(i);

            if (event.getEventId() == id) {
                return event;
            }
        }
        return null;
    }

    public boolean removeEvent(int id)
    {
        for (int i = 0; i < events.size(); i++) {
            Event event = events.get(i);

            if (event.getEventId() == id) // this is used to check if the event ID matches the one to be deleted.
            {
                events.remove(i);
                return true; //stop once event is removed.
            }
        }
        return false; // this is if the loop never finds a matching index.
    }

    public ArrayList<Event> getAllEvents() {
        return events;
    }

    public void displayEvents() {
        for (int i = 0; i < events.size(); i++) {
            Event event = events.get(i);
            System.out.println(event);
        }
    }
}

