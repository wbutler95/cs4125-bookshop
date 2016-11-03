package Staff;

public class Staff {
    private String name = "";
    private String address;
    private String email;
    private int phoneNumber;
    
    public Staff() {
        
    }
    
    public Staff(String name, String address, String email, int phoneNumber) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getAddress() {
        return this.address;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public int getPhoneNumber() {
        return this.phoneNumber;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
