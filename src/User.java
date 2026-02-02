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
         boolean valid = true;
         if(!(this.name.equals(name))){
             System.out.println("Invalid username");
             valid = false;
         }

         if(!(this.id == id)){
             System.out.println("Invalid id");
             valid = false;
         }

         if(!(this.password.equals(password))){
             System.out.println("Invalid password");
             valid = false;
         }


         return valid;
    }

}
