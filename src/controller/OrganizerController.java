package controller;

import DAO.OrganizerDAO;
import Model.Event;
import Model.Organizer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrganizerController {
    private OrganizerDAO organizerDAO;
    private List<Organizer> organizers;


//    constructor
    public OrganizerController(){
        organizerDAO = new OrganizerDAO();
        organizers = new ArrayList<>();
    }


//    add Organizer

    public Organizer addOrganizer(Organizer o) throws SQLException
    {
        return organizerDAO.addOrganizer(o);

    }

    //getAll

    public List<Organizer> getAllOrganizers() throws SQLException
    {
        organizers = organizerDAO.getAllOrganizers();
        return organizers;
    }

//    getById
    public Organizer getOrganizerById(int id) throws SQLException
    {
      return organizerDAO.getOrganizerById(id);
    }

//    update
    public boolean updateOrganizer (Organizer o) throws SQLException
    {
        boolean success = organizerDAO.updateOrganizer(o);

        if(success) {
            for (int i = 0; i < organizers.size(); i++) {
                if (organizers.get(i).getOrganizerId() == o.getOrganizerId()) {
                    organizers.set(i, o);
                }
            }
        }
        return success;
    }

//    remove

    public boolean deleteOrganizer(int id) throws SQLException
    {
        boolean success = organizerDAO.deleteOrganizer(id);

        if(success){
            organizers.removeIf(o -> o.getOrganizerId() == id);
        }
        return success;

    }

    public void displayOrganizers() throws SQLException {
        List<Organizer> allOrganizers =getAllOrganizers();
        for (int i = 0; i < allOrganizers.size(); i++) {
            System.out.println(allOrganizers.get(i));
        }
    }
}
