package DAO;

import Model.Academic;
import Model.Event;
import DB.DbConnection;
import Model.Organizer;
import Model.Professional;
import Model.Social;

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
    public Event addEvent(Event e) throws SQLException {

            String query = " INSERT INTO events (name, date, max_participants, organizer_id, event_type, subject, industry, theme, speaker)  VALUES (?, ?, ?, ?,?,?,?,?,?)";

            Connection myConnection = DbConnection.getConnection();
            if (myConnection != null) {
                try{
                PreparedStatement myQuery = myConnection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

                myQuery.setString(1, e.getName());
                myQuery.setDate(2, new java.sql.Date(e.getDate().getTime()));
                myQuery.setInt(3, e.getMaxParticipants());
                myQuery.setInt(4, e.getOrganizer().getOrganizerId());

                if (e instanceof Professional) {
                    myQuery.setString(5, "Proffessional");

                    myQuery.setString(6, ((Professional) e).getSubject());
                    myQuery.setString(7, ((Professional) e).getIndustry());
                    myQuery.setString(8, null);
                    myQuery.setString(9, null);
                } else if (e instanceof Social) {
                    myQuery.setString(5, "Social");

                    myQuery.setString(6, null);
                    myQuery.setString(7, null);
                    myQuery.setString(8, ((Social) e).getTheme());
                    myQuery.setString(9, null);

                } else if (e instanceof Academic) {
                    myQuery.setString(5, "Academic");

                    myQuery.setString(6, ((Academic) e).getSubject());
                    myQuery.setString(7, null);
                    myQuery.setString(8, null);
                    myQuery.setString(9, ((Academic) e).getSpeaker());
                }

                myQuery.executeUpdate();

                ResultSet rs = myQuery.getGeneratedKeys();
                if (rs.next()) {
                    e.setEventId(rs.getInt(1));
                }
                return e;

            } catch(Exception e1){
                e1.printStackTrace();
            }
        }
            return null;
    }

    public boolean removeEvent(int eventId) throws SQLException {

            String query = "DELETE FROM events WHERE event_id = ?";

            Connection myConnection = DbConnection.getConnection();

            if (myConnection != null) {
                try {
                PreparedStatement myQuery = myConnection.prepareStatement(query);
                myQuery.setInt(1, eventId);

               return myQuery.executeUpdate() >0;

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
       return false;
    }

    public boolean updateEvent(Event e) throws SQLException {

            String query = "UPDATE events SET name = ?, date = ?, max_participants = ?, organizer_id = ? WHERE event_id = ?";

            Connection myConnection = DbConnection.getConnection();

            if (myConnection != null) {
                try{
                PreparedStatement statement = myConnection.prepareStatement(query);

                statement.setString(1, e.getName());
                statement.setDate(2, new java.sql.Date(e.getDate().getTime()));
                statement.setInt(3, e.getMaxParticipants());
                statement.setInt(4, e.getOrganizer().getOrganizerId());
                statement.setInt(5, e.getEventId());

                return statement.executeUpdate() > 0;
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        return false;
    }

    public List<Event> getAllEvents() throws SQLException {
        String query = "SELECT * FROM events";
        List<Event> allEvents = new ArrayList<>();

        Connection myConnection = DbConnection.getConnection();

        if (myConnection != null) {
            try {
                PreparedStatement statement = myConnection.prepareStatement(query);
                ResultSet eventResults = statement.executeQuery();



                while (eventResults.next()) {
                    int eventId = eventResults.getInt("event_id");
                    String name = eventResults.getString("name");
                    java.util.Date date = eventResults.getDate("date");
                    int maxParticipants = eventResults.getInt("max_participants");

                    Organizer organizer = new Organizer(eventResults.getInt("organizer_id"), "", "");

                    String type = eventResults.getString("event_type");

                    Event event = null;
                    switch (type){
                        case "Professional":
                            event = new Professional(
                                    eventId, name, date, maxParticipants, organizer,
                                    eventResults.getString("subject"),
                                    eventResults.getString("industry")
                            );
                            break;

                        case "Social":
                            event = new Social(
                                    eventId, name, date, maxParticipants, organizer,
                                    eventResults.getString("theme")
                            );
                            break;

                        case "Academic":
                            event = new Academic(
                                    eventId, name, date, maxParticipants, organizer,
                                    eventResults.getString("subject"),
                                    eventResults.getString("speaker")
                            );
                            break;
                    }
                    if (event != null){
                        allEvents.add(event);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return allEvents;
    }

    public Event getById(int eventId) throws SQLException {

            String query = "SELECT * FROM events WHERE event_id = ?";

            Connection myConnection = DbConnection.getConnection();

            if (myConnection != null) {
                try {
                    PreparedStatement statement = myConnection.prepareStatement(query);
                    statement.setInt(1, eventId);

                    ResultSet eventResults = statement.executeQuery(); //we have a prepared statement and set the parameter.


                    if (eventResults.next()) {

                        String type = eventResults.getString("event_type");
                        Organizer org = new Organizer(eventResults.getInt("organizer_id"), "", "");

                        if (type.equals("Professional")) {
                            return new Professional(
                                    eventId,
                                    eventResults.getString("name"),
                                    eventResults.getDate("date"),
                                    eventResults.getInt("max_participants"),
                                    org,
                                    eventResults.getString("subject"),
                                    eventResults.getString("industry")
                            );
                        }
                        if (type.equals("Social")) {
                            return new Social(
                                    eventId,
                                    eventResults.getString("name"),
                                    eventResults.getDate("date"),
                                    eventResults.getInt("max_participants"),
                                    org,
                                    eventResults.getString("theme")
                            );
                        }
                        if (type.equals("Academic")) {
                            return new Academic(
                                    eventId,
                                    eventResults.getString("name"),
                                    eventResults.getDate("date"),
                                    eventResults.getInt("max_participants"),
                                    org,
                                    eventResults.getString("subject"),
                                    eventResults.getString("speaker")
                            );
                        }

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        return null;
    }

}




