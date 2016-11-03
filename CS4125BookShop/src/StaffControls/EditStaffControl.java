package StaffControls;

import DBInterface.DBHandler;
import Staff.Staff;

public class EditStaffControl {
    
    public void editStaff(int id, String name, String address, String email, int phoneNumber) {
        Staff staff = new Staff(name, address, email, phoneNumber);
        DBHandler db = new DBHandler();
        db.updateStaff(id, staff);
    }
}
