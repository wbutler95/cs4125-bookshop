package Customers;

import java.util.Date;

public class CreditCard {
    private String cardHolder = "";
    private int cardNumber;
    private int securityCode;
    private String expiryDate;
    
    public CreditCard() {
        
    }
    
    public CreditCard(String cardHolder, int cardNumber, int securityCode, String expiryDate) {
        this.cardHolder = cardHolder;
        this.cardNumber = cardNumber;
        this.securityCode = securityCode;
        this.expiryDate = expiryDate;
    }
    
    public String getCardHolder() {
        return this.cardHolder;
    }
    
    public int getCardNumber() {
        return this.cardNumber;
    }
    
    public int getSecurityCode() {
        return this.securityCode;
    }
    
    public String getExpiryDate() {
        return this.expiryDate;
    }
    
    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }
    
    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }
    
    public void setSecurityCode(int securityCode) {
        this.securityCode = securityCode;
    }
    
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
}
