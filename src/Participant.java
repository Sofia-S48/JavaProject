public class Participant {

    private String name;
    private int id;


    public Participant(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public String getName(){
        return this.name;
    }
    public String toString(){
        return ("Name: " + name +  "Id: " + id );
    }
}
