package DAO;

import DB.DbConnection;
import Model.Participant;
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
    public Participant addParticipant(Participant p) throws SQLException {
        String query = "INSERT INTO participants (participant_name, contact_information)  Values (?,?)"; // in our database script, participantid is auto incremented so we don't need 3 ?.


        Connection myConnection = DbConnection.getConnection();
        if (myConnection != null) {
            try {

                PreparedStatement statement = myConnection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

                statement.setString(1, p.getParticipantName());
                statement.setString(2, p.getContactInformation());
                // removed p.getParticipantId because not needed anymore according to our database script.

                statement.executeUpdate();

                ResultSet rs = statement.getGeneratedKeys();
                if (rs.next()) {
                    p.setParticipantId(rs.getInt(1));
                }
                return p;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;

    }

    public List<Participant> getAllParticipants() throws SQLException {
        String query = "SELECT * FROM participants";
        List<Participant> allParticipants = new ArrayList<>();

        Connection myConnection = DbConnection.getConnection();

        if (myConnection != null) {
            try {
                PreparedStatement statement = myConnection.prepareStatement(query);
                ResultSet participantResults = statement.executeQuery(); // removed query


                while (participantResults.next()) {
                    allParticipants.add(new Participant(
                            participantResults.getInt("participant_id"),
                            participantResults.getString("name"),
                            participantResults.getString("contact_information")
                    ));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return allParticipants;
    }


    public Participant getById(int participantId) throws SQLException {

            String query = "SELECT * FROM participants WHERE participant_id = ?";

            Connection myConnection = DbConnection.getConnection();

            if (myConnection != null) {
                try{
                PreparedStatement statement = myConnection.prepareStatement(query);
                statement.setInt(1, participantId);

                ResultSet participantResults = statement.executeQuery(); // removed query


                if (participantResults.next()) {
                    return new Participant(
                            participantResults.getInt("participant_id"),
                            participantResults.getString("name"),
                            participantResults.getString("contact_information")
                    );
                }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        return null;
    }

    public boolean removeParticipant(int participantId) throws SQLException {

        String query = "DELETE FROM participants WHERE participant_id = ?";

        Connection myConnection = DbConnection.getConnection();

        if (myConnection != null) {
            try {
                PreparedStatement myQuery = myConnection.prepareStatement(query);
                myQuery.setInt(1, participantId);

                return myQuery.executeUpdate() > 0;


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
