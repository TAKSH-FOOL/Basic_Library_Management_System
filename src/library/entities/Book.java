package library.entities;

public class Book {
    static int id = 0;
     int bookId;
     String title;
     String author;
     Member issuedBy;
     boolean isIssued = false;

   public Book(String title, String author) {
        ++id;
        this.bookId = id;
        this.title = title;
        this.author = author;
        this.issuedBy = null;
    }

   public int getBookId() {
        return bookId;
   }

   public void issueBook(Member member) {
       issuedBy = member;
       isIssued = true;
   }

   public boolean isIssued() {
       if(issuedBy == null){
           return false;
       }
        else{
           return true;
       }
    }

   public void returnBook() {
        issuedBy = null;
        isIssued = false;
    }

    public void displayBook() {
        System.out.println("---------------------------");
        System.out.println("Book ID : " + bookId );
        System.out.println("Book Title : " + title);
        System.out.println("Book Author : " + author);
        System.out.println("Book Status : " + (isIssued ? "Issued" : "Available"));
        System.out.println("---------------------------");
        System.out.println();
    }

    public Member getIssuedBy() {
        return issuedBy;
    }
}
