package library.services;

import library.entities.Librarian;
import library.entities.Member;

import java.util.Scanner;

public class Login {
    Scanner sc = new Scanner(System.in);

    public Librarian librarianLogin(Librarian librarian , int i) {

        if (librarian == null) {
            System.out.println("No librarian registered.");
            return null;
        }

        if(i<5){
            System.out.print("enter your name : ");
            String name = sc.nextLine();
            int id = 0;
            while(true){
                System.out.print("enter your id : ");
                id = sc.nextInt();
                if(id>0 && id<=Integer.MAX_VALUE ){
                    break;
                }
                else{
                    System.out.println("please enter valid ID");
                }
            }
            System.out.print("enter your password : ");
            String password = sc.nextLine();
            if(librarian.authenticate(name, id, password)){
                System.out.println("Login successful. Welcome, " + name + "!");
                return librarian;
            }
            else {
                System.out.println("Login unsuccessful. Please try again.");
                return librarianLogin(librarian, i+1);
            }
        }
        System.out.println("Today's login attempts are over. Please come back tomorrow.");
        return null;
    }

    public Librarian librarianRegister(Librarian librarian) {

        if(librarian != null){
            System.out.println("Librarian already registered");
            return null;
        }

        System.out.print("enter your name : ");
        String name = sc.nextLine();
        int id =0;
        while(true){
            System.out.print("enter your id : ");
            id = sc.nextInt();
            if(id>0 && id<=Integer.MAX_VALUE ){

                break;
            }
            else{
                System.out.println("please enter valid ID");
            }
        }
        sc.nextLine();
        System.out.print("enter your password : ");
        String password = sc.nextLine();
        librarian = new Librarian(id, name, "Librarian", password);
        System.out.println("Registration successful. Welcome, " + name + "!");
        return librarian;
    }

    public Member memberLogin(Member[] memberArray, int i) {
        if(i<5){
            System.out.print("enter your name : ");
            String name = sc.nextLine();
            System.out.print("enter your id : ");
            int id = 0;
            while(true){
                System.out.print("enter your id : ");
                id = sc.nextInt();
                if(id>0 && id<=Integer.MAX_VALUE ){
                    sc.nextLine();
                    break;
                }
                else{
                    System.out.println("please enter valid ID");
                }
            }
            System.out.print("enter your password : ");
            String password = sc.nextLine();
            Member member = authenticateMember(memberArray, name, id, password);
            if (member != null) {
                System.out.println("Login successful. Welcome, " + name + "!");
                return member;
            }
            else {
                System.out.println("Login failed. Invalid credentials.");
                return memberLogin(memberArray, i+1);
            }
        }
        System.out.println("Today's login attempts are over. Please come back tomorrow.");
        return null;
    }

    public Member memberRegister(Member[] memberArray) {

        System.out.print("enter your name : ");
        String name = sc.nextLine();
        int id =0;
        while (true){
            System.out.print("enter id : ");
            id = sc.nextInt();
            sc.nextLine();
            if(isMemberIdExists(memberArray, id)){
                System.out.println("please enter another ID, It is already used.");
            }
            else{
                break;
            }
        }
        System.out.print("enter your password : ");
        String password = sc.nextLine();
        for (int i = 0; i < memberArray.length; i++) {
            if (memberArray[i] == null) {
                memberArray[i] = new Member(id, name, "Member", password);
                System.out.println("Registration successful. Welcome, " + name + "!");
                return memberArray[i];
            }
        }
        System.out.println("Registration failed. No available slots.");
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
