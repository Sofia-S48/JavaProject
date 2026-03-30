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
    // RemoveRegistration**

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
