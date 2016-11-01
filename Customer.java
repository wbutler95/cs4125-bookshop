package cs4125bookshop;

public class Customer {
    private int id;
    private String name;
    private String email;
    private int memship;
    
     Customer() {
        
    }
    
    Customer(String name, String email, int memship) {
        this.id = 0;
        this.name = name;
        this.email = email;
        this.memship = memship;
    }
    
    public int getID() {
        return this.id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public int getMemship() {
        return this.memship;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setMemship(int memship) {
        this.memship = memship;
    }
}