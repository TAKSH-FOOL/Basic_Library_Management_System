public class Librarian  extends User {

    public Librarian (int id, String name, String role, String password) {
        super(id, name, role, password);
    }

    public void displayInfo() {
        System.out.printf("%-12s : %-10d%n%-12s : %-20s%n", "Librarian ID", id, "Name", name);
    }


}
