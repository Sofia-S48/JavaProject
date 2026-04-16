package DAO;

import DB.DbConnection;
import Model.Registration;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RegistrationDAO {
//    add, remove, getall, getByEventID, isParticipantRegistered
//    registrationId;
//     eventId;
//     participantId;
//     registrationDate;

    public void addRegistration(Registration r) throws SQLException {
        try {
            String query =" insert into registrations ( event_id, participant_id, registrationDate)  Values (?,?,?)";

            Connection myConnection = DbConnection.getConnection();
            if(myConnection!=null)
            {

                PreparedStatement myQuery = myConnection.prepareStatement(query);
                myQuery.setInt(1,r.getEventId());
                myQuery.setInt(2,r.getParticipantId());
                myQuery.setDate(3, Date.valueOf((LocalDate) r.getRegistrationDate()));

                myQuery.executeUpdate();

                System.out.println("Registration added successfully");
            }

        }
        catch (Exception e )
        {
            e.printStackTrace();
        }
    }

    public List<Registration> getAllRegistrations()
    {
        String query = "SELECT * FROM registrations";

        Connection myConnection = DbConnection.getConnection();

        if(myConnection != null)
        {
            try{
                PreparedStatement statement = myConnection.prepareStatement(query);
                ResultSet registrationResults= statement.executeQuery(query);

                List<Registration> allRegistrations = new ArrayList<>();

                while(registrationResults.next())
                {
                    int registrationId = registrationResults.getInt("registration_id");
                    int eventId= registrationResults.getInt("event_id");
                    int participantId= registrationResults.getInt("participant_id");
                    java.util.Date registrationDate = registrationResults.getDate("redistrationDate");

                    Registration reg =new Registration(registrationId, eventId, participantId, registrationDate);
                    allRegistrations.add(reg);
                }
                return allRegistrations;
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        return null;
    }


    public Registration getByEventId(int eventId) throws SQLException {
        try {
            String query = "SELECT * FROM registrations WHERE event_id = ?";

            Connection myConnection = DbConnection.getConnection();

            if (myConnection != null) {
                PreparedStatement statement = myConnection.prepareStatement(query);
                statement.setInt(1, eventId);

                ResultSet registrationResults = statement.executeQuery(query);


                if (registrationResults.next()) {
                    int registrationId = registrationResults.getInt("registration_id");
                    int evId = registrationResults.getInt("event_id");
                    int participantId = registrationResults.getInt("participant_id");
                    java.util.Date registrationDate = registrationResults.getDate("ragistrationDate");

                    Registration reg = new Registration(registrationId, evId, participantId);
                    return reg;

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    public void removeRegistration(int registrationId) throws SQLException{
        try{
            String query = "DELETE FROM registrations WHERE registration_id = ?";

            Connection myConnection = DbConnection.getConnection();

            if(myConnection != null){
                PreparedStatement myQuery = myConnection.prepareStatement(query);
                myQuery.setInt(1, registrationId);

                int rowsDelete = myQuery.executeUpdate();

                if(rowsDelete >0)
                {
                    System.out.println("Registration deleted");
                }else {
                    System.out.println("Registration not found.");
                }
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public boolean isParticipantRegistered(int eventId, int participantId) throws SQLException {
        try {
            String query = "SELECT * FROM registrations WHERE event_id= ? AND participant_id = ?";
            Connection myConnection = DbConnection.getConnection();

            if (myConnection != null) {
                PreparedStatement statement = myConnection.prepareStatement(query);
                statement.setInt(1, eventId);
                statement.setInt(2, participantId);

                ResultSet registrationResults = statement.executeQuery();

                if (registrationResults.next()) {
                    return true; // already registered
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false; //not registered

    }
}

