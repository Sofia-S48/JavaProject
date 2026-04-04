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
    public void addParticipant(Participant p) throws SQLException {
        try {
            String query = "INSERT INTO Participant (participant_id, participant_name, contact_information)  Values (?,?,?)";

            Connection myConnection = DbConnection.getConnection();
            if (myConnection != null) {

                PreparedStatement statement = myConnection.prepareStatement(query);
                statement.setInt(1, p.getParticipantId());
                statement.setString(2, p.getParticipantName());
                statement.setString(3, p.getContactInformation());

                int rowsInserted = statement.executeUpdate();

                if (rowsInserted > 0) {
                    System.out.println("Participant added successfully");
                } else {
                    System.out.println("Participant was not added");
                }
            }
        } catch(Exception e)
            {
                e.printStackTrace();
            }
        }

    public List<Participant> getAllParticipants() throws SQLException
    {
        String query = "SELECT * FROM Participant";

        Connection myConnection = DbConnection.getConnection();

        if(myConnection != null)
        {
            try{
                PreparedStatement statement = myConnection.prepareStatement(query);
                ResultSet participantResults= statement.executeQuery(); // removed query

                List<Participant> allParticipants = new ArrayList<>();

                while(participantResults.next())
                {
                    int id = participantResults.getInt("participant_id");
                    String name = participantResults.getString("participant_name");
                    String contact = participantResults.getString("contact_information");

                    Participant participant1 = new Participant(0, null, null, 0, null, id, name, contact);
                    allParticipants.add(participant1);
                }
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
            String query = "SELECT * FROM Participant WHERE participant_id = ?";

            Connection myConnection = DbConnection.getConnection();

            if (myConnection != null) {
                PreparedStatement statement = myConnection.prepareStatement(query);
                statement.setInt(1, participantId);

                ResultSet participantResults = statement.executeQuery(); // removed query


                if (participantResults.next()) {
                    int id = participantResults.getInt("participant_id");
                    String name = participantResults.getString("participant_name");
                    String contact = participantResults.getString("contact_information");

                    Participant participant1 = new Participant(0, null, null, 0, null, id, name, contact);
                    return participant1;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    public void removeParticipant (int participantId) throws SQLException{
        try{
            String query = "DELETE FROM Participant WHERE participant_id = ?";

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
