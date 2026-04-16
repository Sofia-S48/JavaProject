package controller;

import Model.Event;
import Model.Registration;
import DAO.RegistrationDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegistrationController {
    private static ArrayList<Registration> registrations;
    private static RegistrationDAO registrationDAO;

//constructor
    public RegistrationController() {
        registrations = new ArrayList<>();
        registrationDAO = new RegistrationDAO();
    }
// add

//    add eventFullException
    public static void addRegistration(Registration r) throws SQLException {
        if (registrationDAO.isParticipantRegistered(r.getParticipantId(), r.getEventId())) {
            System.out.println("Participant already registered for this event!");
            return;
        }
        registrationDAO.addRegistration(r);
        registrations.add(r);
    }

//    getAll

    public ArrayList<Registration> getAllRegistration() throws SQLException{
        registrations= (ArrayList<Registration>) registrationDAO.getAllRegistrations();
        return registrations;

    }

//    getById

    public Registration getRegistrationByEventId(int id) throws SQLException{
        return registrationDAO.getByEventId(id);
    }


//     Remove
    public void deleteRegistration(int id) throws SQLException{
        registrationDAO.removeRegistration(id);
    }

    public void displayRegistrations() throws SQLException {
        ArrayList<Registration> allRegistrations = getAllRegistration();
        for (int i = 0; i < allRegistrations.size(); i++) {
            System.out.println(allRegistrations.get(i));
        }
    }



}
