package DAO;

import DB.DbConnection;
import Model.Organizer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrganizerDAO {
    //    add, getall, getbyid, update

    public Organizer addOrganizer(Organizer o) throws SQLException {
            String query =" INSERT INTO organizers ( name, email)  VALUES (?,?)";

            Connection myConnection = DbConnection.getConnection();
            if(myConnection!=null) {
                try {

                    PreparedStatement myQuery = myConnection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
                    myQuery.setString(1, o.getName());
                    myQuery.setString(2, o.getEmail());
                    myQuery.executeUpdate();

                    ResultSet rs = myQuery.getGeneratedKeys();

                    if (rs.next()) {
                        int generatedId = rs.getInt(1);
                        o.setOrganizerId(generatedId);
                    }

                    return o;


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
    return null;
    }

    public ArrayList<Organizer> getAllOrganizers() {
        String query = "SELECT * FROM organizers";
        ArrayList<Organizer> allOrganizers = new ArrayList<>();

        Connection myConnection = DbConnection.getConnection();

        if(myConnection != null)
        {
            try{
                PreparedStatement statement = myConnection.prepareStatement(query);
                ResultSet organizerResults= statement.executeQuery();

                while(organizerResults.next())
                {
                    int id = organizerResults.getInt("organizer_id");
                    String name= organizerResults.getString("name");
                    String email= organizerResults.getString("email");

                    Organizer org =new Organizer(id, name, email);
                    allOrganizers.add(org);
                }
                return allOrganizers;
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        return allOrganizers;
    }



    public Organizer getOrganizerById(int organizerId) throws SQLException {
        try {
            String query = "SELECT * FROM organizers WHERE organizer_id = ?";
            Connection myConnection = DbConnection.getConnection();

            if (myConnection != null) {
                PreparedStatement statement = myConnection.prepareStatement(query);
                statement.setInt(1, organizerId);

                ResultSet organizerResults = statement.executeQuery(query);


                if (organizerResults.next()) {
                    int id = organizerResults.getInt("organizer_id");
                    String name = organizerResults.getString("name");
                    String email = organizerResults.getString("email");

                    Organizer org = new Organizer(id, name, email);
                    return org;

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }



    public boolean updateOrganizer(Organizer o) throws SQLException {
            String query = "UPDATE organizers SET name = ?, email= ? WHERE organizer_id = ?";

            Connection myConnection = DbConnection.getConnection();

            if(myConnection != null)
            {
                PreparedStatement myQuery = myConnection.prepareStatement(query);

                myQuery.setString(1, o.getName());
                myQuery.setString(2, o.getEmail());
                myQuery.setInt(3, o.getOrganizerId());

                int rowsUpdated = myQuery.executeUpdate();

                return rowsUpdated > 0;

            }
            return false;


    }


    public boolean deleteOrganizer(int organizerId) throws SQLException{
            String query = "DELETE FROM organizer WHERE organizer_id = ?";

            Connection myConnection = DbConnection.getConnection();

            if(myConnection != null){
                try{
                PreparedStatement myQuery = myConnection.prepareStatement(query);
                myQuery.setInt(1, organizerId);

                int rowsDelete = myQuery.executeUpdate();

                return rowsDelete >0;
            }catch (Exception e){
                    e.printStackTrace();
                }

        }
        return false;
    }

}
