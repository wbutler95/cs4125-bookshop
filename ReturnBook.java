package cs4125bookshop;

import javax.swing.JOptionPane;

public class ReturnBook {
    private DBHandler db;
    public void returnBook() {
    int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Input ID of book you wish to return."));
    db.updateStoreStock(id, 1);
}
}
