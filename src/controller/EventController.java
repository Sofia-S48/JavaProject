package controller;
import DAO.EventDAO;
import Model.Event;

import java.util.ArrayList;
public class EventController {
    private ArrayList<Event> events;
    private EventDAO eventDAO;

    public EventController() {
        events = new ArrayList<>();
        eventDAO = new EventDAO();
    }

    public void addEvent(Event event) {
        events.add(event);
        try {
            eventDAO.addEvent(event);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Event searchEventById(int id) {
        try {
            return eventDAO.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void removeEvent(int id) {
        try {
            eventDAO.removeEvent(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Event> getAllEvents() { //*Need to fix, needed help.
        return events;
    }

    public void displayEvents() {
        ArrayList<Event> allEvents = getAllEvents();
        for (int i = 0; i < allEvents.size(); i++) {
            System.out.println(allEvents.get(i));
        }
    }
}

