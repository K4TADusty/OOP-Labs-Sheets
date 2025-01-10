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
