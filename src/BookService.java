import java.util.Scanner;

public class BookService {
    Scanner sc = new Scanner(System.in);

    public void addBook(Book[] books) {
        System.out.println("----------------");
        System.out.println("  ADD NEW BOOK  ");
        System.out.println("----------------");
        boolean spaceAvailable = false;
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                spaceAvailable = true;
                break;
            }
        }
        if (!spaceAvailable) {
            System.out.println("Book Storage Full");
            System.out.println("--------------------------------");
            System.out.println();
            return;
        }

        String bookTitle = "";
        while (true) {
            System.out.print("enter the book Title : ");
            bookTitle = sc.nextLine().trim();
            if (bookTitle.equals("")) {
                System.out.println("Book title cannot be empty");
                System.out.println();
                continue;
            }
            break;
        }

        String bookAuthor = "";
        while (true) {
            System.out.print("enter the book Author : ");
             bookAuthor = sc.nextLine().trim();
            if (bookAuthor.equals("")) {
                System.out.println("Book author cannot be empty");
                System.out.println();
                continue;
            }
            break;
        }


        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = new Book(bookTitle, bookAuthor);
                System.out.println("Book Added Successfully");
                System.out.println("--------------------------------");
                System.out.println();
                return;
            }
        }
    }

    public void viewBooks(Book[] books) {
        System.out.println("-------------");
        System.out.println("  VIEW BOOK  ");
        System.out.println("-------------");
        boolean found = false;

        for (int i = 0; i < books.length; i++) {
            if (books[i] != null && books[i].isIssued()) {
                books[i].displayBook();
                found = true;
            }
        }
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null && !books[i].isIssued()) {
                books[i].displayBook();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books available in the library");
            System.out.println("--------------------------------");
            System.out.println();
        }
    }

    public void removeBook(Book[] books) {
        System.out.println("---------------");
        System.out.println("  REMOVE BOOK  ");
        System.out.println("---------------");

        boolean removableExists = false;
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null && !books[i].isIssued()) {
                books[i].displayBook();
                removableExists = true;
            }
        }

        if (!removableExists) {
            System.out.println("No books available to remove");
            System.out.println("--------------------------------");
            System.out.println();
            return;
        }
        int bookId = 0;
        while (true) {
            System.out.print("enter the book ID you want to remove : ");
            bookId = sc.nextInt();
            sc.nextLine();

            if (bookId <= 0) {
                System.out.println("Invalid Book ID. Please enter a positive number.");
                System.out.println();
                continue;
            }
            break;
        }


        for (int i = 0; i < books.length; i++) {
            if (books[i] != null && books[i].getBookId() == bookId) {

                if (books[i].isIssued()) {
                    System.out.println("Book is currently issued and cannot be removed");
                    System.out.println("----------------------------------------------");
                    System.out.println();
                    return;
                }

                books[i] = null;
                System.out.println("Book Removed Successfully");
                System.out.println("--------------------------------");
                System.out.println();
                return;
            }
        }
        System.out.println("Book Not Found");
        System.out.println("--------------------------------");
        System.out.println();
    }

    public void issueBook(Book[] books, Member member) {
        System.out.println("--------------");
        System.out.println("  ISSUE BOOK  ");
        System.out.println("--------------");

        int count = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                count++;
            }
        }
        if (count == books.length) {
            System.out.println("Library Is Empty");
            System.out.println("--------------------------------------");
            System.out.println();
            return;
        }

        boolean found = false;
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null && !books[i].isIssued()) {
                books[i].displayBook();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No available books at the moment");
            System.out.println("--------------------------------------");
            System.out.println();
            return;
        }
        int bookId =0;
        while (true) {
            System.out.print("enter the book ID you want to issue : ");
            bookId = sc.nextInt();

            if (bookId <= 0) {
                System.out.println("Invalid Book ID. Please try again.");
                System.out.println();
                continue;
            }
            break;
        }

        for (int i = 0; i < books.length; i++) {
            if (books[i] != null && books[i].getBookId() == bookId) {

                if (books[i].isIssued()) {
                    System.out.println("Book is already issued");
                    System.out.println("--------------------------------");
                    System.out.println();
                    return;
                }

                books[i].issueBook(member);
                System.out.println("Book Issued Successfully");
                System.out.println("--------------------------------");
                System.out.println();
                return;
            }
        }
        System.out.println("Book Not Found");
        System.out.println("--------------------------------");
        System.out.println();
    }

    public void returnBook(Book[] books, Member member) {
        System.out.println("---------------");
        System.out.println("  RETURN BOOK  ");
        System.out.println("---------------");
        boolean found = false;

        for (int i = 0; i < books.length; i++) {
            if (books[i] != null && books[i].isIssued() && books[i].getIssuedBy() == member) {
                books[i].displayBook();
                found = true;
            }
        }

        if (!found) {
            System.out.println("You have not issued any books");
            System.out.println("--------------------------------");
            System.out.println();
            return;
        }
        int bookId = 0;
        while(true) {
            System.out.print("enter the book Id you want to return : ");
            bookId = sc.nextInt();

            if (bookId <= 0) {
                System.out.println("Invalid Book ID. Please try again.");
                System.out.println();
                continue;
            }
            break;
        }


        for (int i = 0; i < books.length; i++) {
            if (books[i] != null && books[i].getBookId() == bookId) {

                if (!books[i].isIssued()) {
                    System.out.println("This book is not issued");
                    System.out.println("--------------------------------");
                    System.out.println();
                    return;
                }

                if (books[i].getIssuedBy() != member) {
                    System.out.println("You did not issue this book");
                    System.out.println("--------------------------------");
                    System.out.println();
                    return;
                }

                books[i].returnBook();
                System.out.println("Book Returned Successfully");
                System.out.println("--------------------------------");
                System.out.println();
                return;
            }
        }
        System.out.println("Book Not Found");
        System.out.println("--------------------------------");
        System.out.println();
    }

    public void viewAvailableBooks(Book[] books) {
        System.out.println("------------------------");
        System.out.println("  VIEW AVAILABLE BOOKS  ");
        System.out.println("------------------------");

        int count = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                count++;
            }
        }
        if (count == books.length) {
            System.out.println("Library Is Empty");
            System.out.println("-------------------------------------------");
            System.out.println();
            return;
        }



        boolean found = false;
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null && !books[i].isIssued()) {
                books[i].displayBook();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No available books at the moment");
            System.out.println("------------------------------------");
            System.out.println();
        }
    }

    public void viewIssuedBooks(Book[] books, Member member) {
        System.out.println("---------------------");
        System.out.println("  VIEW ISSUED BOOKS  ");
        System.out.println("---------------------");
        boolean found = false;

        for (int i = 0; i < books.length; i++) {
            if (books[i] != null && books[i].isIssued() && books[i].getIssuedBy() == member) {
                books[i].displayBook();
                found = true;
            }
        }

        if (!found) {
            System.out.println("You have not issued any books");
            System.out.println("--------------------------------");
            System.out.println();
        }
    }
}
