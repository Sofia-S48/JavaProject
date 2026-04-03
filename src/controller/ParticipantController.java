package controller;

import Model.Participant;

import java.util.ArrayList;

public class ParticipantController {
    private ArrayList<Participant> participants;

    public ParticipantController() {
        participants = new ArrayList<>();
    }

    public void addParticipant(Participant participant) {
        participants.add(participant);
    }

    public boolean removePartipant(int id) {
        for (int i = 0; i <participants.size(); i++) //loop that goes through every participant that will look at the participant at position i.
        {
            Participant participant = participants.get(i); //uses get function we made to get the index.
            if (participant.getParticipantId()==id) // this is used to check if the id matches the one to be deleted.
            {
                participants.remove(i);
                return true; //stop once participant is removed.
            }
        }
        return false; // this is if no participant with that ID exists.
    }

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