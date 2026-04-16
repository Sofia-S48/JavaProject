package Model;

public class Organizer {
    protected Integer organizerId;
    protected String name;
    protected String email;

    public Organizer(int organizerId, String name, String email) {
        this.organizerId = organizerId;
        this.name = name;
        this.email = email;
    }

    public Organizer(String name, String email) {
        // AP: When creating a new organizer, you do not have any ID
        // The ID is only created upon insertion to the DB. So you need a way to create a NEW Organizer object without any ID
        this.organizerId = null; //only works cause we made organizerId an Integer.
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