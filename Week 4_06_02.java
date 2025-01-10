public class Main {
    public static void main(String[] args) {
        Book book1 = new Book();
        book1.title = "Java Programming";
        book1.price = 450;
        book1.publisher = "Head First";
        book1.yearPublished = 2006;
        book1.isAvailable = false;
        book1.author = "John Smith";

        Book book2 = new Book();
        book2.title = "Python Programming";
        book2.price = 225;
        book2.publisher = "KM";
        book2.yearPublished = 2020;
        book2.isAvailable = true;
        book2.author = "Elon Potter";

        Library lib = new Library();
        lib.libraryName = "IT Library";
        lib.addBook(book2, 1);
        lib.addBook(book1, 3);

        lib.updateBookPrice(2, 1000);
        lib.updateBookPrice(3, 320);

        lib.printLibraryDetails();
    }
}

class Book {
    String title;
    double price;
    String publisher;
    int yearPublished;
    boolean isAvailable;
    String author;

    void printDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Publisher: " + publisher);
        System.out.println("Year Published: " + yearPublished);
        System.out.println("Price: $" + price);
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
    }

    void updatePrice(double newPrice) {
        price = newPrice;
    }
}

class Library {
    String libraryName;
    Book[] books = new Book[5];

    void addBook(Book book, int slot) {
        if (slot >= 0 && slot < books.length) {
            books[slot] = book;
        }
    }

    void updateBookPrice(int slot, double newPrice) {
        if (slot >= 0 && slot < books.length && books[slot] != null) {
            books[slot].updatePrice(newPrice);
            System.out.println("Updated price of " + books[slot].title + " to $" + newPrice + ".");
        } else {
            System.out.println("No book in this slot.");
        }
    }

    void printLibraryDetails() {
        System.out.println("Library: " + libraryName);
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                books[i].printDetails();
            } else {
                System.out.println("No book in this slot.");
            }
        }
    }
}
