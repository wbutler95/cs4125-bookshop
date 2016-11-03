package StaffControls;

import DBInterface.DBHandler;

public class RemoveStockControl {
    
    public void removeStock(String name, int amount) {
        DBHandler db = new DBHandler();
        int id = db.getBookID(name);
        int stock = db.getStoreStockAmount(id);
        db.updateStoreStock(id, stock-amount);
    }
}
