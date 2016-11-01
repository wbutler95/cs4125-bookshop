package cs4125bookshop;

import javax.swing.JOptionPane;

public class BuyBook {
    private DBHandler db;
    public void buyBook() {
    int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Input ID of book you wish to buy."));
    db.updateStoreStock(id, -1);
}
}
