package Model;

public class Organizer {
    public String organizerId;
    public String name;
    public String email;

    public Organizer(String organizerId, String name, String email) {
        this.organizerId = organizerId;
        this.name = name;
        this.email = email;
    }

    public String getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId(String organizerId) {
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
