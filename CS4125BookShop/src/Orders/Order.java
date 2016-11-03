package Orders;

public class Order
{
    private String date;
    private String customerName;
    private int orderID;
    private String bookName;  
    private double price;

    public Order( String date, String customerName, int orderID, String bookName, double price)
    {
        this.date = date;
        this.customerName = customerName;
        this.orderID = orderID;
        this.bookName = bookName;
        this.price = price;//calulateDiscount(BookName,CName);
    }

    public String getDate()
    {
        return this.date;
    }

    public String getCName()
    {
        return this.customerName;
    }

    public int getOrderid()
    {
        return this.orderID;
    }

    public String getbookName()
    {
        return this.bookName;
    }

    public double getprice()
    {
        return this.price;
    }

    /*public double calulateDiscount(String bookName, String customerName)
    {
        int membership; //put customer level here
        double bookPrice;
        double discountedPrice;
        // database code to get the customer level and book price

        switch(membership) {
            case 1: discountedPrice = bookPrice / 0.02;
            break;
            case 2: discountedPrice = bookPrice / 0.05;
            break;
            case 3: discountedPrice = bookPrice / 0.1;
            break;		 
            default: discountedPrice = bookPrice;
            break;
        }
        return discountedPrice;
    }*/ 
}