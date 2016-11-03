package CustomerControls;

import DBInterface.DBHandler;

public class BuyBookControl {
    
    public void buyBook(String bookName) {
        DBHandler db = new DBHandler();
        int bookID = db.getBookID(bookName);
        db.updateStoreStock(bookID, -1);
    }
}
