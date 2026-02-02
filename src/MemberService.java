import java.util.Scanner;

public class MemberService {
    Scanner sc = new Scanner(System.in);

    public void viewMembers(Member[] members){
        System.out.println("----------------");
        System.out.println("  VIEW MEMBERS  ");
        System.out.println("----------------");
        boolean memberFound = false;
        int count = 0;
        for(int i = 0; i < members.length; i++){
            if(members[i] == null){
                memberFound = true;
                count++;
            }
        }
        if(count == members.length){
            System.out.println("No members registered");
            System.out.println("--------------------------------");
            System.out.println();
            return;
        }
        else {
            for(int i = 0; i<members.length; i++){
                if(members[i]!=null){
                    members[i].displayInfo();
                }
            }
            System.out.println("--------------------------------");
            System.out.println();
        }
    }

    public void removeMember(Member[] members, Book[] books){
        System.out.println("------------------");
        System.out.println("  REMOVE MEMBERS  ");
        System.out.println("------------------");

        boolean memberFound = false;
        int count = 0;
        for(int i = 0; i < members.length; i++){
            if(members[i] == null){
                memberFound = true;
                count++;
            }
        }
        if(count == members.length){
            System.out.println("No members registered");
            System.out.println("--------------------------------");
            System.out.println();
            return;
        }
        else {
            for(int i = 0; i<members.length; i++){
                if(members[i]!=null){
                    members[i].displayInfo();
                }
            }
        }

        int id =0;
        while(true){
            System.out.print("enter your ID number : ");
            id = sc.nextInt();
            if(id<=0){
                System.out.println("please enter valid id.");
                continue;
            }
            else{
                break;
            }
        }

        sc.nextLine();
        for(int i = 0; i< members.length; i++){
            if(members[i] != null && members[i].getId() == id){
                for(int j=0; j<books.length; j++){
                    if(books[j] != null && books[j].getIssuedBy() == members[i]){
                        books[j].returnBook();
                    }
                }
                members[i] = null;
                System.out.println("Member Removed Successfully");
                System.out.println("--------------------------------");
                System.out.println();
                return;
            }
        }
        System.out.println("invalid ID");
        System.out.println("----------");
        System.out.println();
    }
}
