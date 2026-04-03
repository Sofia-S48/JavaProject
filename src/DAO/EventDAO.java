package DAO;

import Model.Academic;
import Model.Event;
import DB.DbConnection;
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
        public List<Event> addEvent(Event e) throws SQLException {
            try {
                String query ="insert into Event (...)  Values (?,?,?)"; //because it's abstract we use ...

                Connection myconnection = DbConnection.getConnection();
                if(myconnection!=null)
                {
                    try {
                        PreparedStatement statement = myconnection.prepareStatement(query);

//                         missing stuff for values, not sure. need help

                        //***** I think this is wrong.
                        ResultSet eventResults = statement.executeQuery(query);


                        List<Event> allEvents = new ArrayList<>();

                        while(eventResults.next())
                        {
                            //abstract.
                        }
                        return allEvents;
                    }
                    catch(Exception e1)
                    {

                    }

                }

            }
            catch (Exception e1 )
            {
                e1.printStackTrace();
            }
            return null;
        }
    }
        public void removeEvent(int eventId) throws SQLException{
            try
            {
                String query = "DELETE FROM Event WHERE eventId = ?";

                Connection myConnection = DbConnection.getConnection();

                if(myConnection != null)
                {
                    PreparedStatement myQuery = myConnection.prepareStatement(query);
                    myQuery.setInt(1, eventId);

                    int rowsDelete = myQuery.executeUpdate();

                    if(rowsDelete >0)
                    {
                        System.out.println("Event deleted");
                    }
                    else
                    {
                        System.out.println("Event not found.");
                    }
                }
            }
            catch (Exception e1)
            {
                e1.printStackTrace();
            }

        }
            //need help because event is an abstract and i don't understand what is going wrong.
//        public void updateEvent(Event e) throws SQLException {
//            try {
//                String query = "UPDATE Event SET name = ?, date = ?, location = ? WHERE event_id = ?";
//
//                Connection myConnection = DbConnection.getConnection();
//
//                if (myConnection != null) {
//                    PreparedStatement statement = myConnection.prepareStatement(query);
//
//                }
//            }
//        }
        public List<Event> getAllEvents() throws SQLException
        {
            String query = "SELECT * FROM Event";

            Connection myConnection = DbConnection.getConnection();

            if(myConnection != null)
            {
                try{
                    PreparedStatement statement = myConnection.prepareStatement(query);
                    ResultSet eventResults= statement.executeQuery(query);

                    List<Event> allEvents = new ArrayList<>();

                    while(eventResults.next())
                    {
                        int eventId = eventResults.getInt("event_id");
                        String name = eventResults.getString("name");
                        java.util.Date Date = eventResults.getDate("date");
                        String location = eventResults.getString("location");

                        //need help.
                        Event ev =new event(ev.getEventId(), ev.getName()); //*not done. i don't understand what to do since event is abstract.
                        allEvents.add(ev);
                    }
                    return allEvents;
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
            return null;
        }
        public Event getById(int eventId) throws SQLException {
            try {
                String query = "SELECT * FROM Event WHERE event_id = ?";

                Connection myConnection = DbConnection.getConnection();

                if (myConnection != null) {
                    PreparedStatement statement = myConnection.prepareStatement(query);
                    statement.setInt(1, eventId);

                    ResultSet eventResults = statement.executeQuery(query);


                    if (eventResults.next()) {
                        int evId = eventResults.getInt("event_id");
                        String name = eventResults.getString("name");
                        java.util.Date date = eventResults.getDate("date");
                        String location = eventResults.getString("location");

                        Event ev = new //** (); //don't know what to do because event is abstract.
                        return ev;

                    }
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }

            return null;
        }




