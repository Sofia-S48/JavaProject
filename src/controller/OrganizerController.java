package controller;

import DAO.OrganizerDAO;
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

    public void addOrganizer(Organizer o) throws SQLException
    {
        organizerDAO.addOrganizer(o);
//        organizers.add(o); // AP: This organizer does not have any id or has an INCORRECT ID  -- same issue as Registration
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
    public void updateOrganizer (Organizer o) throws SQLException
    {
        organizerDAO.updateOrganizer(o);

        for (int i = 0; i <organizers.size(); i++)
        {
            if (organizers.get(i).getOrganizerId() == o.getOrganizerId())
            {
                organizers.set(i,o);
            }
        }
    }

//    remove

    public void deleteOrganizer(int id) throws SQLException
    {
        organizerDAO.deleteOrganizer(id);
        organizers.removeIf(o -> o.getOrganizerId() == id);
    }
}
