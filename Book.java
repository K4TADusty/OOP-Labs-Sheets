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
