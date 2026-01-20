package library.services;
import library.entities.Book;
import library.entities.Member;

import java.util.Scanner;

public class BookService {
    Scanner sc = new Scanner(System.in);

    public void addBook(Book[] books) {
        for(int i = 0; i < books.length; i++) {
            if(books[i] == null) {
                break;
            }
            if(i == books.length - 1) {
                System.out.println("Book Storage Full");
                return;
            }
        }
        System.out.print("enter the book Title : ");
        String bookTitle = sc.nextLine();
        System.out.print("enter the book Author : ");
        String bookAuthor = sc.nextLine();
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = new Book(bookTitle, bookAuthor);
                System.out.println("Book Added Successfully");
                return;
            }
        }
    }

    public void viewBooks(Book [] books){
        for(int i = 0; i < books.length; i++){
            if(books[i] != null && books[i].isIssued() == true){
                books[i].displayBook();
            }
        }
        for(int i = 0; i < books.length; i++){
            if(books[i] != null && books[i].isIssued() == false){
                books[i].displayBook();
            }
        }
    }

    public void removeBook(Book[] books){
        int bookId = 0;
        for(int i = 0; i < books.length; i++){
            System.out.print("enter the book ID you want to remove : ");
             bookId = sc.nextInt();
             if(bookId>0 && bookId<books.length){
                 break;
             }
             else{
                 System.out.println("Invalid Book ID, Please try again.");
             }
        }

        for (int i = 0; i < books.length; i++) {
            if (books[i] != null && books[i].getBookId() == bookId) {
                books[i] = null;
                System.out.println("Book Removed Successfully");
                return;
            }
        }
        System.out.println("Book Not Found");
    }

    public void issueBook(Book[] books, Member member){

        int bookId = 0;
        for(int i = 0; i < books.length; i++){
            System.out.print("enter the book ID you want to issue : ");
            bookId = sc.nextInt();
            if(bookId>0 && bookId<books.length){
                break;
            }
            else{
                System.out.println("Invalid Book ID, Please try again.");
            }
        }
        for(int i=0; i<books.length; i++){
            if(books[i] != null && books[i].getBookId() == bookId){
                books[i].issueBook(member);
                System.out.println("Book Issued Successfully");
                return;
            }
        }
        System.out.println("Book Not Found or Not Available");
    }

    public void returnBook(Book[] books, Member member){
        int bookId = 0;
        for(int i = 0; i < books.length; i++){
            System.out.print("enter the book Id you want to return : ");            bookId = sc.nextInt();
            if(bookId>0 && bookId<books.length){
                break;
            }
            else{
                System.out.println("Invalid Book ID, Please try again.");
            }
        }
        for(int i=0; i<books.length; i++){
            if(books[i] != null && books[i].getBookId() == bookId){
                books[i].returnBook();
                System.out.println("Book Returned Successfully");
                return;
            }
        }
        System.out.println("You have not issued this book");
    }

    public void viewAvailableBooks(Book[] books){
        for(int i=0; i<books.length; i++){
            if(books[i] != null && books[i].isIssued() == false){
                books[i].displayBook();
            }
        }
    }

    public void viewIssuedBooks(Book[] books, Member member){
        for(int i=0; i<books.length; i++){
            if(books[i] != null && books[i].isIssued() && books[i].getIssuedBy() == member){
                books[i].displayBook();
            }
        }
    }
}
