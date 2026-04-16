package controller;

import Model.Event;
import Model.Registration;
import DAO.RegistrationDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegistrationController {
    private ArrayList<Registration> registrations;
    private RegistrationDAO registrationDAO;

//constructor
    public RegistrationController() {
        registrations = new ArrayList<>();
        registrationDAO = new RegistrationDAO();
    }
// add
    public void addRegistration(Registration r) throws SQLException {
        if (registrationDAO.isParticipantRegistered(r.getParticipantId(), r.getEventId())) {
            System.out.println("Participant already registered for this event!");
            return;
        }
        registrationDAO.addRegistration(r);
        registrations.add(r);
    }

//    getAll

    public List<Registration> getAllRegistration() throws SQLException{
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
        registrations.removeIf(r ->r.getRegistrationId() == id);
    }


    public void displayRegistrations() {
        for (int i = 0; i < registrations.size(); i++) {
            Registration registration = registrations.get(i);
            System.out.println(registration);
        }
    }



}
