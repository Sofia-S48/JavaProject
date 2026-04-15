package controller;
import  DAO.ParticipantDAO;
import Model.Participant;

import java.util.ArrayList;

public class ParticipantController {
    //removed redundancy of using participant list, and now fully uses the DAOS
    private ParticipantDAO participantDAO;

    public ParticipantController() {
        participantDAO = new ParticipantDAO();
    }

    public void addParticipants(Participant participant) {
        try {
            participantDAO.addParticipant(participant);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    // removeParticipants**
    public void removeParticipants (int id) {
        try {
            participantDAO.removeParticipant(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Participant searchParticipantById(int id) {
        try {
            return participantDAO.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Participant> getAllParticipants() {
        try {
            return new ArrayList<>(participantDAO.getAllParticipants());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public void displayParticipants() {
        ArrayList<Participant> allParticipants = getAllParticipants();
        for (int i = 0; i < allParticipants.size(); i++) {
            System.out.println(allParticipants.get(i));
        }
    }

}