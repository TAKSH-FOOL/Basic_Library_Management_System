public class Menu {

    public static void roleMenu(){
        System.out.println("-----------------");
        System.out.println("select your role");
        System.out.println("------------------");
        System.out.println("1. Librarian");
        System.out.println("2. Member");
        System.out.print("Enter your choice: ");
    }

    public static void authOption(){
        System.out.println("---------------------");
        System.out.println("AUTHENTICATION OPTION");
        System.out.println("---------------------");
        System.out.println("1. Login");
        System.out.println("2. REGISTER");
        System.out.print("Enter your choice: ");
    }

    public static void librarianMenu(){
        System.out.println("--------------");
        System.out.println("LIBRARIAN MENU");
        System.out.println("--------------");
        System.out.println("1. Add books");
        System.out.println("2. View Books");
        System.out.println("3. View Members");
        System.out.println("4. Remove Books");
        System.out.println("5. Remove Members");
        System.out.println("6. Logout");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void memberMenu(){
        System.out.println("-----------");
        System.out.println("MEMBER MENU");
        System.out.println("-----------");
        System.out.println("1. Issue Book");
        System.out.println("2. Return Book");
        System.out.println("3. View Available Books");
        System.out.println("4. View Issued Books");
        System.out.println("5. Logout");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }
}
