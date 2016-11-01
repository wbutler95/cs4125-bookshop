
package cs4125bookshop;

import javax.swing.JOptionPane;

public class CreateCustomer {
    private DBHandler db;
    private String name;
    private String email;
    private int memship;
    private Customer customer;
    public void createCustomer() {
        name = JOptionPane.showInputDialog(null, "What is your name?");
        email = JOptionPane.showInputDialog(null, "What is your email?");
        memship = Integer.parseInt(JOptionPane.showInputDialog(null, "What level of membership do you want? \n1. Bronze \n2. Silver \n3. Gold"));
        customer = new Customer(name, email, memship);
        db.addCustomer(customer);
    }
}
