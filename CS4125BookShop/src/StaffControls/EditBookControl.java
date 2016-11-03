package StaffControls;

import DBInterface.DBHandler;
import Orders.Book;

public class EditBookControl {
    
    public void editBook(int id, String name, String author, String genre, String publisher, double price) {
        Book book = new Book(name, author, genre, publisher, price);
        DBHandler db = new DBHandler();
        db.updateBook(id, book);
    }
}
