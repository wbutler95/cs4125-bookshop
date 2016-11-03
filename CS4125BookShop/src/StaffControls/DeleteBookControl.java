package StaffControls;

import DBInterface.DBHandler;

public class DeleteBookControl {
    
    public void deleteBook(String name) {
        DBHandler db = new DBHandler();
        db.deleteBook(name);
    }
}
