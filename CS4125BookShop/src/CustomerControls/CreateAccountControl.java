package CustomerControls;

import DBInterface.DBHandler;
import Customers.Customer;

public class CreateAccountControl {
    
    public void createAccount(String name, String email, int memship) {
        Customer customer = new Customer(name, email, memship);
        DBHandler db = new DBHandler();
        db.insertCustomer(customer);
    }
}
