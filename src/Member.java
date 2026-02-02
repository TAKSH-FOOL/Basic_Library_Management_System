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

    public void displayInfo() {
        int width = Math.max(3,name.length()) + 18;
        for(int i=0; i<width; i++) {
           System.out.printf("-");
        }
        System.out.printf("%n");
        System.out.printf("%-12s : %-"+ (width-18) + "d%n", "Member ID", id);
        System.out.printf("%-12s : %-"+ (width-18) + "s%n",  "Name", name);
        for(int i=0; i<width; i++) {
            System.out.printf("-");
        }
        System.out.printf("%n%n");
    }

}
