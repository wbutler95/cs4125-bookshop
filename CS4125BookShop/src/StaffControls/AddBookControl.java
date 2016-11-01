package StaffControls;

import DBInterface.DBHandler;
import Orders.Book;

public class AddBookControl {
    
    public void addBook(String name, String author, String genre, String publisher, double price) {
        Book book = new Book(name, author, genre, publisher, price);
        DBHandler db = new DBHandler();
        db.insertBook(book);
    }
}
