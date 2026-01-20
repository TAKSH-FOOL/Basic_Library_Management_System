package library.entities;

public  class User {
     int id;
     String name;
     String Role;
     String password;

     User(int id, String name, String Role, String password) {
        this.id = id;
        this.name = name;
        this.Role = Role;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public boolean authenticate(String name, int id, String password) {
        return this.name.equals(name) && this.id == id && this.password.equals(password); // later → hashed
    }

}
