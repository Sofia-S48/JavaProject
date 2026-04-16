package controller;

import Model.Registration;
import DAO.RegistrationDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegistrationController {
//    private ArrayList<Registration> registrations;
    private RegistrationDAO registrationDAO;

//constructor
    public RegistrationController() {
//        registrations = new ArrayList<>();
        registrationDAO = new RegistrationDAO();
    }
// add
    public void addRegistration(Registration r) throws SQLException {
        if (registrationDAO.isParticipantRegistered(r.getParticipantId(), r.getEventId())) {
            // TODO should also check if event is full
            System.out.println("Participant already registered for this event!");
            return;
        }
        registrationDAO.addRegistration(r);
//        registrations.add(r); // AP: this registration would not have any ID -- also why hold all registrations in memory?
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
//        registrations.removeIf(r ->r.getRegistrationId() == id); //no need for this because this way it will fetch from the database first.
    }


    public void displayRegistrations() {
        try {
            List<Registration> registrations = getAllRegistration();
            for (int i = 0; i < registrations.size(); i++) {
                Registration registration = registrations.get(i);
                System.out.println(registration);
            }
            // AP: This in memory list would not have any IDs
            // Should pull this from the DB, hold in memory and then update "on refresh" when new registration is added
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
