package DAO;

import Model.Event;
import DB.DbConnection;
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

