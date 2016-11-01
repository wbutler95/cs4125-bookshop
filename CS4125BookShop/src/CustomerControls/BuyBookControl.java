package CustomerControls;

import DBInterface.DBHandler;
import Orders.Book;

public class BuyBookControl {
    
    public void buyBook(String bookName) {
        DBHandler db = new DBHandler();
        Book book = db.getBook(bookName);
        int bookID = book.getID();
        db.updateStoreStock(bookID, -1);
    }
}
