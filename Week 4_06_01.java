public class Main {
    public static void main(String[] args) {
        Book book1 = new Book();
        book1.title = "Java Programming";
        book1.price = 450;
        book1.publisher = "Head First";
        book1.yearPublished = 2006;
        book1.isAvailable = false;
        book1.author = "John Smith";

        book1.printDetails();
        System.out.println("-------------");
        book1.updatePrice(250);
        book1.markAsAvailable();
        book1.printDetails();
        System.out.println(book1.isPublishedAfter(2000));
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

    void markAsAvailable() {
        isAvailable = true;
    }

    boolean isPublishedAfter(int year) {
        return yearPublished > year;
    }
}
