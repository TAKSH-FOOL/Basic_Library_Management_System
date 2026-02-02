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
        int width = Math.max(
                Math.max(title.length(), author.length()) + 18,
                30
        );

        if(width>30){
            for (int i = 0; i < width+2; i++) {
                System.out.printf("-");
            }
        }
        else{
            for (int i = 0; i < width; i++) {
                System.out.printf("-");
            }
        }

        System.out.printf("%n");

        System.out.printf("%-15s : %-"+ (width - 18) +"s%n", "Book Title", title);
        System.out.printf("%-15s : %-"+ (width - 18) +"s%n", "Book Author", author);
        System.out.printf("%-15s : %-"+ (width - 18) +"d%n", "Book ID", bookId);
        System.out.printf("%-15s : %-"+ (width - 18) +"s%n", "Book Status", isIssued ? "Issued" : "Available");

        for (int i = 0; i < width; i++) {
            System.out.printf("-");
        }
        System.out.printf("%n%n");
    }



    public Member getIssuedBy() {
        return issuedBy;
    }
}
