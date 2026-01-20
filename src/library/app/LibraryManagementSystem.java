package library.app;

import library.entities.*;
import library.services.Login;
import library.services.Menu;
import library.services.BookService;
import library.services.MemberService;


import java.util.Scanner;
public class LibraryManagementSystem {

    static Book[] books = new Book[10000];
    static Member[] members = new Member[1000];
    static Librarian librarian = null;
    static int bookCount = 0;
    static int memberCount = 0;

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Login login = new Login();
        BookService bookService = new BookService();
        MemberService memberService = new MemberService();
        while (true){
            System.out.println("Welcome to the Library Management System");
            Menu.roleMenu();
            int roleChoice = sc.nextInt();

            Librarian isLibrarian = null;
            Member isMember = null;
            if(roleChoice == 1){
                Menu.authOption();
                int librarianChoice = sc.nextInt();
                if(librarianChoice == 1){
                     isLibrarian = login.librarianLogin(librarian,0);
                }
                else if (librarianChoice == 2){
                    librarian = login.librarianRegister(librarian);
                    isLibrarian = librarian;
                }
                else {
                    System.out.println("invalid choice");
                }
                if (isLibrarian != null){
                    boolean login = true;
                    while (login){
                        Menu.librarianMenu();
                        int functionChoice = sc.nextInt();
                            switch (functionChoice){
                                case 1:{
                                    bookService.addBook(books);
                                    break;
                                }
                                case 2:{
                                    bookService.viewBooks(books);
                                    break;
                                }
                                case 3:{
                                    memberService.viewMembers(members);
                                    break;
                                }
                                case 4: {
                                    bookService.removeBook(books);
                                    break;
                                }
                                case 5:{
                                    memberService.removeMember(members);
                                    break;
                                }
                                case 6:{
                                    System.out.println("Logged out successfully.");
                                    login = false;
                                    break;
                                }
                                default:{
                                    System.out.println("invalid choice");
                                }
                            }
                    }

                }
            }
            else if(roleChoice == 2){
                Menu.authOption();
                int memberChoice = sc.nextInt();
                if(memberChoice == 1){
                    isMember = login.memberLogin(members,0);
                }
                else if(memberChoice == 2){
                   isMember =  login.memberRegister(members);
                     if (isMember != null){
                          members[memberCount] = isMember;
                          memberCount++;
                     }
                }
                else  {
                    System.out.println("invalid choice");
                }
                if (isMember != null){
                    boolean login = true;
                    while (login){
                        Menu.memberMenu();
                        int functionChoice = sc.nextInt();
                        switch (functionChoice){
                            case 1:{
                                bookService.issueBook(books, isMember);
                                break;
                            }
                            case 2:{
                                bookService.returnBook(books, isMember);
                                break;
                            }
                            case 3:{
                                bookService.viewAvailableBooks(books);
                                break;
                            }
                            case 4:{
                                bookService.viewIssuedBooks(books, isMember);
                                break;
                            }
                            case 5:{
                                System.out.println("Logged out successfully.");
                                login = false;
                                break;
                            }
                            default:{
                                System.out.println("invalid choice");
                            }
                        }
                    }
                }
            }
            break;
        }
    }
}
