import java.util.Scanner;

public class Login {
    Scanner sc = new Scanner(System.in);

    public Librarian librarianLogin(Librarian librarian , int i) {
        System.out.println("---------------");
        System.out.println("LIBRARIAN LOGIN");
        System.out.println("---------------");
        if (librarian == null) {
            System.out.println("No librarian registered.");
            System.out.println("--------------------------------------");
            return null;
        }

        if(i<5){
            String name = "";
            int id = 0;

            while (true) {
                System.out.print("Enter your name: ");
                name = sc.nextLine().trim();

                if (name.equals("")) {
                    System.out.println("Please enter a valid name.");
                    continue;
                }

                boolean isValid = true;
                for (int j = 0; j < name.length(); j++) {
                    char c = name.charAt(j);
                    if (!((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))) {
                        isValid = false;
                        break;
                    }
                }

                if (!isValid) {
                    System.out.println("Use alphabets only.");
                    continue;
                } else {
                    break;
                }
            }


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
            String password = "";
            while(true){
                System.out.print("enter your password : ");
                password = sc.nextLine();
                if(password.trim().equals("")){
                    System.out.println("please enter valid password.");
                    continue;
                }
                else {
                    break;
                }
            }
            if(librarian.authenticate(name, id, password)){
                System.out.println("Login successful. Welcome, " + name + "!");
                return librarian;
            }
            else {
                System.out.println("Login unsuccessful. Please try again.");
                System.out.println("--------------------------------------");
                return librarianLogin(librarian, i+1);
            }
        }
        System.out.println("Today's login attempts are over. Please come back tomorrow.");
        System.out.println("----------------------------------------------------------");
        return null;
    }

    public Librarian librarianRegister(Librarian librarian) {
        System.out.println("------------------");
        System.out.println("LIBRARIAN REGISTER");
        System.out.println("------------------");
        if(librarian != null){
            System.out.println("Librarian already registered");
            System.out.println("----------------------------");
            return null;
        }

        String name = "";
        int id = 0;

        while (true) {
            System.out.print("Enter your name: ");
            name = sc.nextLine().trim();

            if (name.equals("")) {
                System.out.println("Please enter a valid name.");
                continue;
            }

            boolean isValid = true;
            for (int j = 0; j < name.length(); j++) {
                char c = name.charAt(j);
                if (!((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))) {
                    isValid = false;
                    break;
                }
            }

            if (!isValid) {
                System.out.println("Use alphabets only.");
                continue;
            } else {
                break;
            }
        }


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
        String password = "";
        while(true){
            System.out.print("enter your password : ");
             password = sc.nextLine();
            if(password.trim().equals("")){
                System.out.println("please enter valid password.");
                continue;
            }
            else {
                break;
            }
        }

        librarian = new Librarian(id, name, "Librarian", password);
        System.out.println("Registration successful. Welcome, " + name + "!");
        System.out.println("--------------------------------------------");
        return librarian;
    }

    public Member memberLogin(Member[] memberArray, int i) {
        System.out.println("------------");
        System.out.println("MEMBER LOGIN");
        System.out.println("------------");
        int count = 0;
        for(int j=0;j<memberArray.length;j++){
            if(memberArray[j] == null){
                count++;
            }
        }
        if(count==memberArray.length){
            System.out.println("No member registered.");
            System.out.println("----------------------");
            return null;
        }

        if(i<5){
            String name = "";
            int id = 0;

            while (true) {
                System.out.print("Enter your name: ");
                name = sc.nextLine().trim();

                if (name.equals("")) {
                    System.out.println("Please enter a valid name.");
                    continue;
                }

                boolean isValid = true;
                for (int j = 0; j < name.length(); j++) {
                    char c = name.charAt(j);
                    if (!((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))) {
                        isValid = false;
                        break;
                    }
                }

                if (!isValid) {
                    System.out.println("Use alphabets only.");
                    continue;
                } else {
                    break;
                }
            }


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
            String password = "";
            while(true){
                System.out.print("enter your password : ");
                password = sc.nextLine();
                if(password.trim().equals("")){
                    System.out.println("please enter valid password.");
                    continue;
                }
                else {
                    break;
                }
            }
            Member member = authenticateMember(memberArray, name, id, password);
            if (member != null) {
                System.out.println("Login successful. Welcome, " + name + "!");
                System.out.println("--------------------------------------");
                return member;
            }
            else {
                System.out.println("Login failed.");
                System.out.println("--------------------------------------");
                return memberLogin(memberArray, i+1);
            }
        }
        System.out.println("Today's login attempts are over. Please come back tomorrow.");
        System.out.println("-----------------------------------------------------------");
        return null;
    }

    public Member memberRegister(Member[] memberArray) {
        System.out.println("---------------");
        System.out.println("MEMBER REGISTER");
        System.out.println("---------------");
        String name = "";
        int id = 0;

        while (true) {
            System.out.print("Enter your name: ");
            name = sc.nextLine().trim();

            if (name.equals("")) {
                System.out.println("Please enter a valid name.");
                continue;
            }

            boolean isValid = true;
            for (int j = 0; j < name.length(); j++) {
                char c = name.charAt(j);
                if (!((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))) {
                    isValid = false;
                    break;
                }
            }

            if (!isValid) {
                System.out.println("Use alphabets only.");
            } else {
                break;
            }
        }


        while(true){
            System.out.print("enter your ID number : ");
            id = sc.nextInt();
            if(isMemberIdExists(memberArray, id)){
                System.out.println("ID is already in use.");
                continue;
            }
            if(id<=0){
                System.out.println("please enter valid id.");
                continue;
            }
            else{
                break;
            }
        }
        sc.nextLine();
        String password = "";
        while(true){
            System.out.print("enter your password : ");
            password = sc.nextLine();
            if(password.trim().equals("")){
                System.out.println("please enter valid password.");
                continue;
            }
            else {
                break;
            }
        }
        for (int i = 0; i < memberArray.length; i++) {
            if (memberArray[i] == null) {
                memberArray[i] = new Member(id, name, "Member", password);
                System.out.println("Registration successful. Welcome, " + name + "!");
                return memberArray[i];
            }
        }
        System.out.println("Registration failed. No available slots.");
        System.out.println("----------------------------------------");
        return null;
    }

    Member authenticateMember(Member[] memberArray, String name, int id, String password) {
        for (Member member : memberArray) {
            if (member != null && member.authenticate(name, id, password)) {
                return member;
            }
        }
        return null;
    }

     boolean isMemberIdExists(Member [] memberArray, int id) {
        for (int i = 0; i < memberArray.length; i++) {
            if(memberArray[i] != null && memberArray[i].getId() == id){
                return true;
            }
        }
        return false;
    }

}
