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
                myQuery.setString(2,o.getName());
                myQuery.setString(3,o.getEmail());
                myQuery.executeUpdate();




            }

        }
        catch (Exception e )
        {
            e.printStackTrace();
        }
        return null;

    }

}
