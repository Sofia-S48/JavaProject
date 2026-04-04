package DAO;

import Model.Academic;
import Model.Event;
import DB.DbConnection;
import Model.Organizer;
import Model.Registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


//DAO is to separate your db code from your main logic. it is a class that handles all communication with the DB.

public class EventDAO {
    //    // CRUD of Event
//
//        // 1- add Event
    public void addOrganizer(Organizer o) throws SQLException {
        try {
            String query = " INSERT INTO Organizer (organizer_id, name, email)  VALUES (?,?,?)";

            Connection myConnection = DbConnection.getConnection();
            if (myConnection != null) {
                PreparedStatement myQuery = myConnection.prepareStatement(query);
                myQuery.setInt(1, o.getOrganizerId());
                myQuery.setString(2, o.getName());
                myQuery.setString(3, o.getEmail());
                myQuery.executeUpdate();
                System.out.println("Organizer added successfully");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void removeEvent(int eventId) throws SQLException {
        try {
            String query = "DELETE FROM Events WHERE event_id = ?";

            Connection myConnection = DbConnection.getConnection();

            if (myConnection != null) {
                PreparedStatement myQuery = myConnection.prepareStatement(query);
                myQuery.setInt(1, eventId);

                int rowsDelete = myQuery.executeUpdate();

                if (rowsDelete > 0) {
                    System.out.println("Event deleted");
                } else {
                    System.out.println("Event not found.");
                }
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }

    }

    public void updateEvent(Event e) throws SQLException {
        try {
            String query = "UPDATE Events SET name = ?, date = ?, max_participants = ?, organizer_id = ? WHERE event_id = ?";

            Connection myConnection = DbConnection.getConnection();

            if (myConnection != null) {
                PreparedStatement statement = myConnection.prepareStatement(query);

                statement.setString(1, e.getName());
                statement.setDate(2, new java.sql.Date(e.getDate().getTime()));
                statement.setInt(3, e.getMaxParticipants());
                statement.setInt(4, e.getOrganizer().getOrganizerId());
                statement.setInt(5, e.getEventId());

                int rowsUpdated = statement.executeUpdate();

                if (rowsUpdated > 0) {
                    System.out.println("Event updated successfully.");
                } else {
                    System.out.println("Event not found.");
                }
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public List<Event> getAllEvents() throws SQLException {
        String query = "SELECT * FROM Events";

        Connection myConnection = DbConnection.getConnection();

        if (myConnection != null) {
            try {
                PreparedStatement statement = myConnection.prepareStatement(query);
                ResultSet eventResults = statement.executeQuery();

                List<Event> allEvents = new ArrayList<>();

                while (eventResults.next()) {
                    int eventId = eventResults.getInt("event_id");
                    String name = eventResults.getString("name");
                    java.util.Date date = eventResults.getDate("date");
                    int maxParticipants = eventResults.getInt("max_participants");
                    int organizerId = eventResults.getInt("organizer_id");

                    Organizer organizer = new Organizer(organizerId, "", "");
                    //need help.
                    Event ev = new Academic(eventId, name, date, maxParticipants, organizer, "", ""); //*Academic is acting as a placeholder for now because event is abstract.
                    allEvents.add(ev);
                }
                return allEvents;
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        return null;
    }

    public Event getById(int eventId) throws SQLException {
        try {
            String query = "SELECT * FROM Events WHERE event_id = ?";

            Connection myConnection = DbConnection.getConnection();

            if (myConnection != null) {
                PreparedStatement statement = myConnection.prepareStatement(query);
                statement.setInt(1, eventId);

                ResultSet eventResults = statement.executeQuery(); //we have a prepared statement and set the parameter.


                if (eventResults.next()) {
                    int evId = eventResults.getInt("event_id");
                    String name = eventResults.getString("name");
                    java.util.Date date = eventResults.getDate("date");
                    int maxParticipants = eventResults.getInt("max_participants");
                    int organizerId = eventResults.getInt("organizer_id");

                    Organizer organizer = new Organizer(organizerId, "", "");

                    Event ev = new Academic(evId, name, date, maxParticipants, organizer, "", ""); // acts as a placeholder for now.
                    return ev;

                }
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        return null;
    }
}




