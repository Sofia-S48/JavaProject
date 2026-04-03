package DAO;

import DB.DbConnection;
import Model.Organizer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static jdk.internal.org.jline.utils.Colors.s;

public class OrganizerDAO {
    //    add, getall, getbyid, update
<<<<<<< HEAD
  public void addOrganizer(Organizer o) throws SQLException {
        try {
            String query =" insert into Organizer (organizer_id, name, email)  Values (?,?,?)";

            Connection myConnection = DbConnection.getConnection();
            if(myConnection!=null)
            {

                PreparedStatement myQuery = myConnection.prepareStatement(query);
                myQuery.setInt(1,o.getOrganizerId());
=======

    public List<Organizer> addOrganizer(Organizer o) throws SQLException {
        try {
            String query =" insert into Organizer (organizer_id, name, email)  Values (?,?,?)";

            Connection myConnetion = DbConnection.getConnection();
            if(myConnetion!=null)
            {
                try{
                    PreparedStatement statement = myConnetion.prepareStatement(query);
                    ResultSet organizerResults= statement.executeQuery(query);
                    List<Organizer> allOrganizers = new ArrayList<>();

                    while(organizerResults.next())
                    {
                        String id = organizerResults.getString("organizer_id");
                        String name= organizerResults.getString("name");
                        String email= organizerResults.getString("email");

                        Organizer stud =new Organizer(o.getOrganizerId(), o.getName(), o.getEmail());
                        allOrganizers.add(stud);
                    }
                    return allOrganizers;
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                PreparedStatement myQuery = myConnetion.prepareStatement(query);
                myQuery.setString(1,o.getOrganizerId());
>>>>>>> 9c02176 (saving current AOOP local changes i made)
                myQuery.setString(2,o.getName());
                myQuery.setString(3,o.getEmail());
                myQuery.executeUpdate();

<<<<<<< HEAD
                System.out.println("Organizer added successfully");
=======



>>>>>>> 9c02176 (saving current AOOP local changes i made)
            }

        }
        catch (Exception e )
        {
            e.printStackTrace();
        }
<<<<<<< HEAD
    }

    public List<Organizer> getAllOrganizers(Organizer o)
    {
        String query = "SELECT * FROM organizers";

        Connection myConnection = DbConnection.getConnection();

        if(myConnection != null)
        {
            try{
                PreparedStatement statement = myConnection.prepareStatement(query);
                ResultSet organizerResults= statement.executeQuery(query);

                List<Organizer> allOrganizers = new ArrayList<>();

                while(organizerResults.next())
                {
                    int id = organizerResults.getInt("organizer_id");
                    String name= organizerResults.getString("name");
                    String email= organizerResults.getString("email");

                    Organizer org =new Organizer(o.getOrganizerId(), o.getName(), o.getEmail());
                    allOrganizers.add(org);
                }
                return allOrganizers;
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        return null;
    }



    public Organizer getOrganizerById(int organizerId) throws SQLException {
        try {
            String query = "SELECT * FROM Organizer WHERE organizer_id = ?";

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



    public void updateOrganizer(Organizer o) throws SQLException {
        try{
            String query = "UPDATE orgnaizers SET name = ?, email= ? WHERE organizer_id = ?";

            Connection myConnection = DbConnection.getConnection();

            if(myConnection != null)
            {
                PreparedStatement myQuery = myConnection.prepareStatement(query);

                myQuery.setString(1, o.getName());
                myQuery.setString(2, o.getEmail());
                myQuery.setInt(3, o.getOrganizerId());

                int rowsUpdated = myQuery.executeUpdate();

                if(rowsUpdated > 0)
                {
                    System.out.println("Organizer updated");
                }else{
                    System.out.println("Organizer couldn't be found");
                }
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }


    public void deleteOrganizer(int organizerId) throws SQLException{
        try{
            String query = "DELETE FROM organizers WHERE organizer_id = ?";

            Connection myConnection = DbConnection.getConnection();

            if(myConnection != null){
                PreparedStatement myQuery = myConnection.prepareStatement(query);
                myQuery.setInt(1, organizerId);

                int rowsDelete = myQuery.executeUpdate();

                if(rowsDelete >0)
                {
                    System.out.println("Organizer deleted");
                }else {
                    System.out.println("Organizer not found.");
                }
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
=======
        return null;

    }

>>>>>>> 9c02176 (saving current AOOP local changes i made)
}
