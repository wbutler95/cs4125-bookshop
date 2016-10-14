package cs4125bookshop;

public class CS4125BookShop {
    
    private DBHandler db;
    
    public CS4125BookShop() {
        db = new DBHandler();
    }
    
    public static void main(String[] args) {
        CS4125BookShop bookshop = new CS4125BookShop();
    }
    
}