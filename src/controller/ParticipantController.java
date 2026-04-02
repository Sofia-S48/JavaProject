package controller;

import java.util.ArrayList;

public class ParticipantController {
    private ArrayList<Participant> participants;

    public ParticipantController() {
        participants = new ArrayList<>();
    }

    public void addParticipants(Participant participant) {
        participants.add(participant);
    }
    // removeParticipants**


    public Participant searchParticipantById(int id) {
        for (int i = 0; i < participants.size(); i++) {
            Participant participant = participants.get(i);

            if (participant.getParticipantId() == id) {
                return participant;
            }
        }
        return null;
    }

    public ArrayList<Participant> getAllParticipants() {
        return participants;
    }

    public void displayParticipants() {
        for (int i = 0; i < participants.size(); i++) {
            Participant participant = participants.get(i);
            System.out.println(participant);
        }
    }
}