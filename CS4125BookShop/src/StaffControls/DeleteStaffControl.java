package StaffControls;

import DBInterface.DBHandler;

public class DeleteStaffControl {
    
    public void deleteStaff(String name) {
        DBHandler db = new DBHandler();
        db.deleteStaff(name);
    }
}
