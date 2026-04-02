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
    // removeEvent

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

