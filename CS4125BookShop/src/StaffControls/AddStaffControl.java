package StaffControls;

import DBInterface.DBHandler;
import Staff.Staff;

public class AddStaffControl {
    
    public void addStaff(String name, String address, String email, int phoneNumber) {
        Staff staff = new Staff(name, address, email, phoneNumber);
        DBHandler db = new DBHandler();
        db.insertStaff(staff);
    }
}
