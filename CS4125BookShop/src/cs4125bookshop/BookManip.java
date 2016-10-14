/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs4125bookshop;

import javax.swing.JOptionPane;

/**
 *
 * @author Owner
 */

public class BookManip {
    private DBHandler db;
    private String name;
    private String author;
    private String genre;
    private String publisher;
    private int id;
    private double price;       
    private Book book;
    public void addBook(){
        name = JOptionPane.showInputDialog(null, "Input book name");
        author = JOptionPane.showInputDialog(null, "Input author name");
        genre = JOptionPane.showInputDialog(null, "Input genre");
        publisher = JOptionPane.showInputDialog(null, "Input publisher name");
        price = Double.parseDouble(JOptionPane.showInputDialog(null, "Input price of book"));       
        book = new Book(name, author, genre, publisher, price);
        db.insertBook(book);
        return;
}
    public void deleteBook (){
        id = Integer.parseInt(JOptionPane.showInputDialog(null, "Insert ID of book you wish to delete"));
        db.deleteBook(id);
}
    public void updateBook(){
        id = Integer.parseInt(JOptionPane.showInputDialog(null, "Insert ID of book you wish to delete"));
        int i = db.checkidExists(id);
        if(i == 0){
        name = JOptionPane.showInputDialog(null, "Input book name");
        author = JOptionPane.showInputDialog(null, "Input author name");
        genre = JOptionPane.showInputDialog(null, "Input genre");
        publisher = JOptionPane.showInputDialog(null, "Input publisher name");
        price = Double.parseDouble(JOptionPane.showInputDialog(null, "Input price of book"));  
        db.updateBook(id, book);
        }
    }
}
