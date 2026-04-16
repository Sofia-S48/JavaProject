package controller;

import Model.Event;
import Model.Organizer;
import Model.Participant;
import Model.Registration;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExportController {

    public void exportParticipantsToTXT(ArrayList<Participant> participants, String fileName) throws IOException {
        FileWriter writer = new FileWriter(fileName);
        writer.write("===== Participants List =====\n");
        for (Participant p : participants)
        {
            writer.write("ID: " +p.getParticipantId()+ "\n");
            writer.write("Name: "+p.getParticipantName()+"\n");
            writer.write("Contact Information: " +p.getContactInformation()+"\n");
            writer.write("----------------------------\n");
        }
        writer.close();
        System.out.println("Participants exported into TXT.");

    }


    public void exportEventsToTXT(List<Event> events, String fileName) throws IOException {
        FileWriter writer = new FileWriter(fileName);
        writer.write("===== Events List =====\n");

        for(Event e : events)
        {
            writer.write("ID: " +e.getEventId()+"\n");
            writer.write("Date: " + e.getDate()+"\n");
            writer.write("Maximum Participants: "+ e.getMaxParticipants()+"\n");
            writer.write("Organizer: "+ e.getOrganizer() + "\n");
        }
        writer.close();
        System.out.println("Events exported into TXT. ");

    }


    public void exportRegistrationsToTXT(List<Registration> registrations, String fileName) throws IOException {
        FileWriter writer = new FileWriter(fileName);
        writer.write("===== Registrations List =====\n");

        for(Registration r : registrations)
        {
            writer.write("Registration ID: " +r.getRegistrationId()+"\n");
            writer.write("Event ID: " + r.getEventId()+"\n");
            writer.write("Participant ID: "+ r.getParticipantId()+"\n");
            writer.write("Registration Date: "+ r.getRegistrationDate() + "\n");
        }
        writer.close();
        System.out.println("Registrations exported into TXT. ");

    }
}
