
public class sales
 {
  
  
  private String Date;
  private String CName;
  private int OrderId;
  private String BookName;  
  private double price;
  
  public sales( String sDate, String sName, int sOrderId, String sBookName)
  {
    Date = sDate;
	CName = sName;
	OrderId = sOrderId;
	BookName = sBookName;
	price = calulateDiscount(BookName,CName);
  }
  
  public String getDate()
  {
   return Date;
  }
  
  public String getCName()
  {
   return CName;
  }
  
  public int getOrderid()
  {
   return OrderId;
  }
  
   public String getbookName()
  {
   return BookName;
  }
  
    public double getprice()
  {
   return price;
  }
  
  public double calulateDiscount(String bName, String cName)
  {
   int clevel; //put customer level here
   double bprice;
   double Dprice;
   // database code to get the customer level and book price
   
   switch ( clevel ) {
            case 1: Dprice = bprice / 0.02;
                     break;
		    case 2: Dprice = bprice / 0.05;
                     break;
			case 3: Dprice = bprice / 0.1;
                     break;		 
            default: Dprice = bprice;
                     break;
         }
   return Dprice;
  }  
 }