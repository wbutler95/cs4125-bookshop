package cs4125bookshop;

import javax.swing.JOptionPane;

public class CS4125BookShop {
    
    private DBHandler db;
    public static void main(String[] args) {
       AddBook ab = new AddBook();
       CS4125BookShop bookshop = new CS4125BookShop();
       String temp =JOptionPane.showInputDialog(null, "Add, Delete or update.");
       if(temp.equals("Add"))
       ab.addBook();
       if(temp.equals("Delete"))
       ab.deleteBook();
       if(temp.equals("update"))
       ab.updateBook();
}   
}
