package controller;
import DAO.EventDAO;
import Model.Event;

import Model.Event;

import java.sql.SQLException;
import java.util.ArrayList;
public class EventController {
    //removed redundancy of using event list, and now fully uses the DAOS
    private EventDAO eventDAO;

    public EventController() {

        eventDAO = new EventDAO();
    }

    public Event addEvent(Event event) throws SQLException {
       return eventDAO.addEvent(event);
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

    public ArrayList<Event> getAllEvents() {
        try {
            return new ArrayList<>(eventDAO.getAllEvents());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public void displayEvents() {
        ArrayList<Event> allEvents = getAllEvents();
        for (int i = 0; i < allEvents.size(); i++) {
            System.out.println(allEvents.get(i));
        }
    }
}

