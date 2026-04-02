package controller;

import Model.Participant;
import Model.Registration;

import java.util.ArrayList;

public class RegistrationController {
    private ArrayList<Registration> registrations;

    public RegistrationController() {
        registrations = new ArrayList<>();
    }

    public void addRegistration(Registration registration) {
        registrations.add(registration);
    }

    public Registration searchRegistration(int index) {
        for (int i = 0; i < registrations.size(); i++) {
            if (i == index) {
                return registrations.get(i);
            }
        }
        return null;
    }

    public boolean removeRegistration(int index) {
        for (int i = 0; i <registrations.size(); i++) //loop that goes through every index in the registration list.
        {
            if (i== index) // this is used to check if the index matches the one to be deleted.
            {
                registrations.remove(i);
                return true; //stop once registration is removed.
            }
        }
        return false; // this is if the loop never finds a matching index.
    }

    public ArrayList<Registration> getAllRegistrations() {
        return registrations;
    }

    public void displayRegistrations() {
        for (int i = 0; i < registrations.size(); i++) {
            Registration registration = registrations.get(i);
            System.out.println(registration);
        }
    }
}
