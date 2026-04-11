package controller;
import  DAO.ParticipantDAO;
import Model.Participant;

import java.util.ArrayList;

public class ParticipantController {
    private ArrayList<Participant> participants;
    private ParticipantDAO participantDAO;

    public ParticipantController() {
        participants = new ArrayList<>();
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

    public ArrayList<Participant> getAllParticipants() { //NOT DONE need help.
        return participants;
    }

    public void displayParticipants() {
        ArrayList<Participant> allParticipants = getAllParticipants();
        for (int i = 0; i < allParticipants.size(); i++) {
            System.out.println(allParticipants.get(i));
        }
    }

    public void addParticipant(Participant participant) {
    }
}