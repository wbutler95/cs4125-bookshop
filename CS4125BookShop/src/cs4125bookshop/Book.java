package cs4125bookshop;

public class Book {
    private int id;
    private String name;
    private String author;
    private String genre;
    private String publisher;
    private double price;
    
    Book() {
        
    }
    
    Book(String name, String author, String genre, String publisher, double price) {
        this.id = 0;
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.publisher = publisher;
        this.price = price;
    }
    
    public int getID() {
        return this.id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getAuthor() {
        return this.author;
    }
    
    public String getGenre() {
        return this.genre;
    }
    
    public String getPublisher() {
        return this.publisher;
    }
    
    public double getPrice() {
        return this.price;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
}
