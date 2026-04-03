package DAO;

import DB.DbConnection;
import Model.Participant;
import Model.Registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParticipantDAO {
// CRUD of Participant
//
//        // 1- add participant
        public List<Participant> addParticipant(Participant p) throws SQLException {
            try {
                String query ="insert into Participant (participantId, participantName, contactInformation)  Values (?,?,?)";

                Connection myconnection = DbConnection.getConnection();
                if(myconnection !=null)
                {
                    try {
                        PreparedStatement statement = myconnection.prepareStatement(query);
                        //something to get participantId
                        //something to get participantName
                        //something to get contractInformation

                        //***** I think this is wrong.
                        ResultSet eventResults = statement.executeQuery(query);
                        List<Participant> allParticipants = new ArrayList<>();

                        while(eventResults.next())
                        {
                            int id = eventResults.getInt("participantId");
                            String name = eventResults.getString("participantName");
                            String contact = eventResults.getString("contactInformation");


                            Participant participant1 = new Participant(0, null, null, 0, null, id, name, contact); // this needed to be changed because of the way our Participant class works.
                            // these act as placeholders because the DAO is not fetching the event data yet.
                            allParticipants.add(participant1);
                        }
                        return allParticipants;
                    }
                    catch(Exception e)
                    {

                    }

                }

            }
            catch (Exception e )
            {
                e.printStackTrace();
            }
            return null;
        }
    public List<Participant> getAllParticipants() throws SQLException
    {
        String query = "SELECT * FROM Partipant";

        Connection myConnection = DbConnection.getConnection();

        if(myConnection != null)
        {
            try{
                PreparedStatement statement = myConnection.prepareStatement(query);
                ResultSet participantResults= statement.executeQuery(query);

                List<Participant> allParticipants = new ArrayList<>();

                while(participantResults.next())
                {
                    int id = participantResults.getInt("participantId");
                    String name = participantResults.getString("participantName");
                    String contact = participantResults.getString("contactInformation");

                    Participant participant1 = new Participant(0, null, null, 0, null, id, name, contact);
                    allParticipants.add(participant1);
                };
                return allParticipants;
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        return null;
    }
    public Participant getById(int participantId) throws SQLException {
        try {
            String query = "SELECT * FROM Participant WHERE participantId = ?";

            Connection myConnection = DbConnection.getConnection();

            if (myConnection != null) {
                PreparedStatement statement = myConnection.prepareStatement(query);
                statement.setInt(1, participantId);

                ResultSet participantResults = statement.executeQuery(query);


                if (participantResults.next()) {
                    int id = participantResults.getInt("participantId");
                    String name = participantResults.getString("participantName");
                    String contact = participantResults.getString("contactInformation");

                    ///  *** NOT DONE NEED HELP HERE.

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    public void removeParticipant (int participantId) throws SQLException{
        try{
            String query = "DELETE FROM Participant WHERE participantId = ?";

            Connection myConnection = DbConnection.getConnection();

            if(myConnection != null){
                PreparedStatement myQuery = myConnection.prepareStatement(query);
                myQuery.setInt(1, participantId);

                int rowsDelete = myQuery.executeUpdate();

                if(rowsDelete >0)
                {
                    System.out.println("Participant deleted");
                }
                else
                {
                    System.out.println("Participant not found.");
                }
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
