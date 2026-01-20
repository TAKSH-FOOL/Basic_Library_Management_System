package library.entities;

public class Librarian  extends User {

    public Librarian (int id, String name, String role, String password) {
        super(id, name, role, password);
    }

    public void displayInfo() {
        System.out.println("Librarian  ID: " + id + ", Name: " + name);
    }


}
