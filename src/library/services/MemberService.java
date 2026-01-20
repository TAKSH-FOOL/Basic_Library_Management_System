package library.services;

import library.entities.Member;

import java.util.Scanner;

public class MemberService {
    Scanner sc = new Scanner(System.in);

    public void viewMembers(Member[] members){
        if(members == null){
            System.out.println("No members");
            return;
        }
        for(int i = 0; i<members.length; i++){
            if(members[i]!=null){
                members[i].displayInfo();
            }
        }
        System.out.println("Members displayed successfully");
    }

    public void removeMember(Member [] member){
        System.out.print("enter the ID of the member : ");
        int id = sc.nextInt();
        for(int i=0; i<member.length; i++){
            if(member[i].getId() == id){
                member[i] = null;
                System.out.println("Member Removed Successfully");
                return;
            }
        }
        System.out.println("invalid ID");
    }
}
