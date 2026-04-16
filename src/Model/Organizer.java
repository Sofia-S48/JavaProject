package Model;

public class Organizer {
    public int organizerId;
    public String name;
    public String email;

    public Organizer( String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Organizer(int organizerId, String name, String email) {
        this.organizerId = organizerId;
        this.name = name;
        this.email = email;
    }

    public int getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId(int organizerId) {
        this.organizerId = organizerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Model.Organizer{" +
                "organizerId=" + organizerId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}