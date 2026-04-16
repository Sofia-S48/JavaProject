package controller;
import  DAO.ParticipantDAO;
import Model.Participant;

import Model.Participant;

import java.util.ArrayList;
import java.util.List;

public class ParticipantController {
    //removed redundancy of using participant list, and now fully uses the DAOS
    private ParticipantDAO participantDAO;

    public ParticipantController() {
        participantDAO = new ParticipantDAO();
    }

    public Participant addParticipants(Participant participant) throws SQLException {

           return participantDAO.addParticipant(participant);


    }
    // removeParticipants**
    public boolean removeParticipants (int id) throws SQLException {

          return   participantDAO.removeParticipant(id);

    }

    public Participant searchParticipantById(int id) throws SQLException {
            return participantDAO.getById(id);


    }

    public List<Participant> getAllParticipants() throws SQLException {

            return participantDAO.getAllParticipants();

    }

    public void displayParticipants() throws SQLException {
        List<Participant> allParticipants = getAllParticipants();
        for (int i = 0; i < allParticipants.size(); i++) {
            System.out.println(allParticipants.get(i));
        }
    }

}