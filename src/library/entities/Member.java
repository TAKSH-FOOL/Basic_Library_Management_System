package library.entities;

public class Member extends User {
    static int memberCount = 1;


    public static int getMemberCount() {
        return memberCount;
    }

    public static void incrementMemberCount() {
        ++memberCount;
    }

    public Member(int id, String name, String role, String password) {
        super(id, name, role, password);
    }

    public void displayInfo(){
        System.out.println("Member ID: " + id + ", Name: " + name);
    }

}
