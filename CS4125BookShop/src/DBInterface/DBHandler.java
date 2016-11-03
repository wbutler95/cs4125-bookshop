package DBInterface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import Orders.Book;
import Customers.Customer;
import Staff.Staff;

public class DBHandler {
    
    private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    
    // Default constructor creates a connection to MySQL using IP localhost, database cs4125bookshop, 
    // username sqluser, password sqluserpw
    // Taken from (and edited) JDBC use example by UL Staff Member: James Murphy
    public DBHandler() {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            
            // Set up the connection with the DBMS
            connect = DriverManager.getConnection("jdbc:mysql://localhost/?user=root&password=");
            
            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            
            // Create the database if it doesn't already exist
            statement.execute("CREATE DATABASE IF NOT EXISTS cs4125bookshop");
            
            // Connect to the Bookshop DB
            connect = DriverManager.getConnection("jdbc:mysql://localhost/cs4125bookshop?user=root&password=");
            statement = connect.createStatement();
            
            // Create the BOOKS table if it doesn't already exist
            statement.execute("CREATE TABLE IF NOT EXISTS BOOKS (" +
                            "ID INT NOT NULL AUTO_INCREMENT, " +
                            "NAME VARCHAR(30) NOT NULL, " +
                            "AUTHOR VARCHAR(30) NOT NULL, " +
                            "GENRE VARCHAR(30) NOT NULL, " +
                            "PUBLISHER VARCHAR(30) NOT NULL," +
                            "PRICE DECIMAL(4,2) DEFAULT 0.00, " +
                            "EXIST INT NOT NULL DEFAULT 1," +
                            "PRIMARY KEY (ID))");
            
            // Create the ORDERS table if it doesn't already exist
            statement.execute("CREATE TABLE IF NOT EXISTS ORDERS (" +
                            "ID INT NOT NULL AUTO_INCREMENT, " +
                            "NAME VARCHAR(30) NOT NULL, " +
                            "PRICE DECIMAL(4,2) DEFAULT 0.00, " +
                            "PRIMARY KEY (ID))");
            
            // Create the STAFF table if it doesn't already exist
            statement.execute("CREATE TABLE IF NOT EXISTS STAFF (" +
                            "ID INT NOT NULL AUTO_INCREMENT, " +
                            "NAME VARCHAR(30) NOT NULL, " +
                            "ADDRESS VARCHAR(60) NOT NULL, " +
                            "EMAIL VARCHAR(30) NOT NULL, " +
                            "PHONE INT NOT NULL, " +
                            "EXIST INT NOT NULL DEFAULT 1," +
                            "PRIMARY KEY (ID))");
            
            // Create the CUSTOMERS table if it doesn't already exist
            statement.execute("CREATE TABLE IF NOT EXISTS CUSTOMERS (" +
                            "ID INT NOT NULL AUTO_INCREMENT, " +
                            "NAME VARCHAR(30) NOT NULL, " +
                            "EMAIL VARCHAR(30) NOT NULL, " +
                            "MEMSHIP INT, " +
                            "EXIST INT NOT NULL DEFAULT 1," +
                            "PRIMARY KEY (ID))");
            
            // Create the CREDITCARDS table if it doesn't already exist
            statement.execute("CREATE TABLE IF NOT EXISTS CREDITCARDS (" +
                            "ID INT NOT NULL AUTO_INCREMENT, " +
                            "CARDHOLDER VARCHAR(30) NOT NULL, " +
                            "CARDNUMBER INT NOT NULL, " +
                            "SECURITYCODE INT NOT NULL, " +
                            "EXPIRYDATE VARCHAR(10) NOT NULL, " +
                            "PRIMARY KEY (ID)" +
                            "FOREIGN KEY (CARDHOLDER) REFERENCES CUSTOMERS(NAME))");
            
            // Create the STORESTOCK table if it doesn't already exist
            statement.execute("CREATE TABLE IF NOT EXISTS STORESTOCK (" +
                            "ID INT NOT NULL, " +
                            "AMOUNT INT NOT NULL, " +
                            "FOREIGN KEY (ID) REFERENCES BOOKS(ID))");
            
            // Create the WAREHOUSESTOCK table if it doesn't already exist
            statement.execute("CREATE TABLE IF NOT EXISTS WAREHOUSESTOCK (" +
                            "ID INT NOT NULL, " +
                            "AMOUNT INT NOT NULL, " +
                            "FOREIGN KEY (ID) REFERENCES BOOKS(ID))");
        } catch (Exception e) {
        }
    }
    
    // Constructor creates a connection to MySQL using parameters for IP, database, username, password
    // Taken from (and edited) JDBC use example by UL Staff Member: James Murphy
    public DBHandler(String ip, String db, String user, String pw) {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            
            // Setup the connection with the DMBS
            connect = DriverManager.getConnection("jdbc:mysql://"+ip+"/?"+"user="+user+"&password="+pw);
            
            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            
            // Create the database if it doesn't already exist
            statement.execute("CREATE DATABASE IF NOT EXISTS cs4125bookshop");
            
            // Connect to the cs4125bookshop DB
            connect = DriverManager.getConnection("jdbc:mysql://"+ip+"/"+db+"?user="+user+"&password="+pw);
            statement = connect.createStatement();
            
            // Create the BOOKS table if it doesn't already exist
            statement.execute("CREATE TABLE IF NOT EXISTS BOOKS (" +
                            "ID INT NOT NULL AUTO_INCREMENT, " +
                            "NAME VARCHAR(30) NOT NULL, " +
                            "AUTHOR VARCHAR(30) NOT NULL, " +
                            "GENRE VARCHAR(30) NOT NULL, " +
                            "PUBLISHER VARCHAR(30) NOT NULL," +
                            "PRICE DECIMAL(4,2) DEFAULT 0.00, " +
                            "EXIST INT NOT NULL DEFAULT 1," +
                            "PRIMARY KEY (ID))");
            
            // Create the ORDERS table if it doesn't already exist
            statement.execute("CREATE TABLE IF NOT EXISTS ORDERS (" +
                            "ID INT NOT NULL AUTO_INCREMENT, " +
                            "NAME VARCHAR(30) NOT NULL, " +
                            "PRICE DECIMAL(4,2) DEFAULT 0.00, " +
                            "PRIMARY KEY (ID))");
            
            // Create the CUSTOMERS table if it doesn't already exist
            statement.execute("CREATE TABLE IF NOT EXISTS CUSTOMERS (" +
                            "ID INT NOT NULL AUTO_INCREMENT, " +
                            "NAME VARCHAR(30) NOT NULL, " +
                            "EMAIL VARCHAR(30) NOT NULL, " +
                            "MEMSHIP INT, " +
                            "EXIST INT NOT NULL DEFAULT 1," +
                            "PRIMARY KEY (ID))");
            
            // Create the CREDITCARDS table if it doesn't already exist
            statement.execute("CREATE TABLE IF NOT EXISTS CREDITCARDS (" +
                            "ID INT NOT NULL AUTO_INCREMENT, " +
                            "CARDHOLDER VARCHAR(30) NOT NULL, " +
                            "CARDNUMBER INT NOT NULL, " +
                            "SECURITYCODE INT NOT NULL, " +
                            "EXPIRYDATE VARCHAR(10) NOT NULL, " +
                            "PRIMARY KEY (ID)" +
                            "FOREIGN KEY (CARDHOLDER) REFERENCES CUSTOMERS(NAME))");
            
            // Create the STAFF table if it doesn't already exist
            statement.execute("CREATE TABLE IF NOT EXISTS STAFF (" +
                            "ID INT NOT NULL AUTO_INCREMENT, " +
                            "NAME VARCHAR(30) NOT NULL, " +
                            "ADDRESS VARCHAR(50) NOT NULL, " +
                            "EMAIL VARCHAR(30) NOT NULL, " +
                            "PHONE INT NOT NULL, " +
                            "EXIST INT NOT NULL DEFAULT 1," +
                            "PRIMARY KEY (ID))");
            
            // Create the STORESTOCK table if it doesn't already exist
            statement.execute("CREATE TABLE IF NOT EXISTS STORESTOCK (" +
                            "ID INT NOT NULL, " +
                            "AMOUNT INT NOT NULL, " +
                            "FOREIGN KEY (ID) REFERENCES BOOKS(ID))");
            
            // Create the WAREHOUSESTOCK table if it doesn't already exist
            statement.execute("CREATE TABLE IF NOT EXISTS WAREHOUSESTOCK (" +
                            "ID INT NOT NULL, " +
                            "AMOUNT INT NOT NULL, " +
                            "FOREIGN KEY (ID) REFERENCES BOOKS(ID))");
        } catch (Exception e) {
        }
    }
    
    // Returns a ResultSet if the type is SELECT, otherwise it executes the command
    // Taken from JDBC use example by UL Staff Member: James Murphy
    public ResultSet doStatement(String sql, String type) {
        ResultSet result = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            switch(type) {
                case "SELECT": result = statement.executeQuery(sql);    break;
                default:       statement.executeUpdate(sql);            break;
            }
        } catch (Exception e) {
        }
        return result;
    }
    
    // Returns 1 if the book exists, 0 if it doesn't
    public int checkBookExists(String bookName) {
        resultSet = doStatement("SELECT EXISTS(SELECT * FROM BOOKS WHERE NAME='"+bookName+"' AND EXIST=1)", "SELECT");
        int i = 0;
        try {
            resultSet.first();
            i = resultSet.getInt(1);
        } catch (Exception e) {
        }
        return i;
    }
    
    public int checkBookExists(int id) {
        resultSet = doStatement("SELECT EXISTS(SELECT * FROM BOOKS WHERE ID="+id+" AND EXIST=1)", "SELECT");
        int i = 0;
        try {
            resultSet.first();
            i = resultSet.getInt(1);
        } catch (Exception e) {
        }
        return i;
    }

    // Returns 1 if the book exists, 0 if it doesn't
    public int checkCustomerExists(String customerName) {
        resultSet = doStatement("SELECT EXISTS(SELECT * FROM CUSTOMERS WHERE NAME='"+customerName+"' AND EXIST=1)", "SELECT");
        int i = 0;
        try {
            resultSet.first();
            i = resultSet.getInt(1);
        } catch (Exception e) {
        }
        return i;
    }
    
    public int checkCustomerExists(int id) {
        resultSet = doStatement("SELECT EXISTS(SELECT * FROM CUSTOMERS WHERE ID="+id+" AND EXIST=1)", "SELECT");
        int i = 0;
        try {
            resultSet.first();
            i = resultSet.getInt(1);
        } catch (Exception e) {
        }
        return i;
    }

    // Returns 1 if the staff exists, 0 if it doesn't
    public int checkStaffExists(String staffName) {
        resultSet = doStatement("SELECT EXISTS(SELECT * FROM STAFF WHERE NAME='"+staffName+"' AND EXIST=1)", "SELECT");
        int i = 0;
        try {
            resultSet.first();
            i = resultSet.getInt(1);
        } catch (Exception e) {
        }
        return i;
    }
    
    public int checkStaffExists(int id) {
        resultSet = doStatement("SELECT EXISTS(SELECT * FROM STAFF WHERE ID="+id+" AND EXIST=1)", "SELECT");
        int i = 0;
        try {
            resultSet.first();
            i = resultSet.getInt(1);
        } catch (Exception e) {
        }
        return i;
    }
    
    public int getBookID(String bookName) {
        resultSet = doStatement("SELECT ID FROM BOOKS WHERE NAME='"+bookName+"'", "SELECT");
        int id = 0;
        try {
            resultSet.first();
            id = resultSet.getInt(1);
        } catch (Exception e) {
        }
        return id;
    }
    
    public int getStaffID(String staffName) {
        resultSet = doStatement("SELECT ID FROM STAFF WHERE NAME='"+staffName+"'", "SELECT");
        int id = 0;
        try {
            resultSet.first();
            id = resultSet.getInt(1);
        } catch (Exception e) {
        }
        return id;
    }
    
    // Returns the amount of rows in the BOOKS table where EXIST=1 (book hasn't been deleted)
    public int countBooks() {
        int i = 0;
        resultSet = doStatement("SELECT COUNT(*) FROM BOOKS WHERE EXIST=1", "SELECT");
        try {
            resultSet.first();
            i = resultSet.getInt(1);
        } catch (Exception e) {
        }
        return i;
    }
    
    // Returns the amount of rows in the BOOKS table whether they have been "deleted" or not
    public int countAllBooks() {
        int i = 0;
        resultSet = doStatement("SELECT COUNT(*) FROM BOOKS", "SELECT");
        try {
            resultSet.first();
            i = resultSet.getInt(1);
        } catch (Exception e) {
        }
        return i;
    }
    
    // Returns the amount of rows in the STAFF table whether they have been "deleted" or not
    public int countAllStaff() {
        int i = 0;
        resultSet = doStatement("SELECT COUNT(*) FROM STAFF", "SELECT");
        try {
            resultSet.first();
            i = resultSet.getInt(1);
        } catch (Exception e) {
        }
        return i;
    }
    
    // Adds a new row to BOOKS, STORESTOCK and WAREHOUSESTOCK
    public void insertBook(Book book) {
        String name = book.getName();
        int i = checkBookExists(name);
        if (i == 0) {
            doStatement("insert into CS4125BOOKSHOP.BOOKS values (default, '"+book.getName()+"', '"+book.getAuthor()+"', '"
                    +book.getGenre()+"', '"+book.getPublisher()+"', "+book.getPrice()+", default)", "INSERT");
            doStatement("insert into CS4125BOOKSHOP.STORESTOCK values ("+getBookID(book.getName())+", 0)", "INSERT");
            doStatement("insert into CS4125BOOKSHOP.WAREHOUSESTOCK values ("+getBookID(book.getName())+", 0)", "INSERT");
        }
    }
    
    // Adds a new row to CUSTOMERS
    public void insertCustomer(Customer customer) {
        String name = customer.getName();
        int i = checkCustomerExists(name);
        if (i == 0) {
            doStatement("insert into CS4125BOOKSHOP.CUSTOMERS values (default, '"+customer.getName()+"', '"+customer.getEmail()+"', "
                    +customer.getMemship()+", default)", "INSERT");
        }
    }
    
    // Adds a new row to STAFF
    public void insertStaff(Staff staff) {
        String name = staff.getName();
        int i = checkStaffExists(name);
        if (i == 0) {
            doStatement("insert into CS4125BOOKSHOP.STAFF values (default, '"+staff.getName()+"', '"+staff.getAddress()+"', '"
                    +staff.getEmail()+"', "+staff.getPhoneNumber()+", default)", "INSERT");
        }
    }
    
    // Removes row from BOOKS (identified by id)
    public void deleteBook(int id) {
        int i = checkBookExists(id);
        if (i == 1) {
            doStatement("UPDATE BOOKS SET EXIST=0 WHERE ID="+id, "UPDATE");
        }
    }
    
    // Removes row from BOOKS (identified by name)
    public void deleteBook(String name) {
        int i = checkBookExists(name);
        if (i == 1) {
            doStatement("UPDATE BOOKS SET EXIST=0 WHERE NAME='"+name+"'", "UPDATE");
        }
    }
    
    // Removes row from STAFF (identified by id)
    public void deleteStaff(int id) {
        int i = checkStaffExists(id);
        if (i == 1) {
            doStatement("UPDATE STAFF SET EXIST=0 WHERE ID="+id, "UPDATE");
        }
    }
    
    // Removes row from STAFF (identified by name)
    public void deleteStaff(String name) {
        int i = checkStaffExists(name);
        if (i == 1) {
            doStatement("UPDATE STAFF SET EXIST=0 WHERE NAME="+name, "UPDATE");
        }
    }
    
    // Updates the values of a row in BOOKS (identified by id)
    public void updateBook(int id, Book book) {
        int i = checkBookExists(id);
        if (i == 1){
            doStatement("UPDATE BOOKS SET NAME='"+book.getName()+"' WHERE ID="+id, "UPDATE");
            doStatement("UPDATE BOOKS SET AUTHOR='"+book.getAuthor()+"' WHERE ID="+id, "UPDATE");
            doStatement("UPDATE BOOKS SET GENRE='"+book.getGenre()+"' WHERE ID="+id, "UPDATE");
            doStatement("UPDATE BOOKS SET PUBLISHER='"+book.getPublisher()+"' WHERE ID="+id, "UPDATE");
            doStatement("UPDATE BOOKS SET PRICE="+book.getPrice()+" WHERE ID="+id, "UPDATE");
        }
    }
    
    // Updates the values of a row in STAFF (identified by id)
    public void updateStaff(int id, Staff staff) {
        int i = checkStaffExists(id);
        if (i == 1){
            doStatement("UPDATE STAFF SET NAME='"+staff.getName()+"' WHERE ID="+id, "UPDATE");
            doStatement("UPDATE STAFF SET ADDRESS='"+staff.getAddress()+"' WHERE ID="+id, "UPDATE");
            doStatement("UPDATE STAFF SET EMAIL='"+staff.getEmail()+"' WHERE ID="+id, "UPDATE");
            doStatement("UPDATE STAFF SET PHONENUMBER='"+staff.getPhoneNumber()+"' WHERE ID="+id, "UPDATE");
        }
    }
    
    // Updates the values of a row in STORESTOCK (book identified by id)
    public void updateStoreStock(int id, int amount) {
        int i = checkBookExists(id);
        if (i == 1){
            doStatement("UPDATE STORESTOCK SET AMOUNT="+amount+" WHERE ID="+id, "UPDATE");
        }
    }
    
    // Returns the amount associated with a row in STORESTOCK identified by (book) id
    public int getStoreStockAmount(int id) {
        resultSet = doStatement("SELECT AMOUNT FROM STORESTOCK WHERE ID="+id, "SELECT");
        int amount = 0;
        try {
            resultSet.first();
            amount = resultSet.getInt(1);
        } catch (Exception e) {
        }
        return amount;
    }
    
    // Updates the values of a row in WAREHOUSESTOCK (book identified by id)
    public void updateWarehouseStock(int id, int amount) {
        int i = checkBookExists(id);
        if (i == 1){
            doStatement("UPDATE WAREHOUSESTOCK SET AMOUNT="+amount+" WHERE ID="+id, "UPDATE");
        }
    }
    
    // Returns the amount associated with a row in WAREHOUSESTOCK identified by (book) id
    public int getWarehouseStockAmount(int id) {
        resultSet = doStatement("SELECT AMOUNT FROM WAREHOUSESTOCK WHERE ID="+id, "SELECT");
        int amount = 0;
        try {
            resultSet.first();
            amount = resultSet.getInt(1);
        } catch (Exception e) {
        }
        return amount;
    }
    
    public Book getBook(String name) {
        String author = "";
        String genre = "";
        String publisher = "";
        double price = 0;
        Book book = new Book();
        int i = checkBookExists(name);
        if (i == 1){
            resultSet = doStatement("SELECT AUTHOR FROM BOOKS WHERE NAME='"+name+"'", "SELECT");
            try {
                resultSet.first();
                author = resultSet.getString(1);
            } catch (Exception e) {
            }
            resultSet = doStatement("SELECT GENRE FROM BOOKS WHERE NAME='"+name+"'", "SELECT");
            try {
                resultSet.first();
                genre = resultSet.getString(1);
            } catch (Exception e) {
            }
            resultSet = doStatement("SELECT PUBLISHER FROM BOOKS WHERE NAME='"+name+"'", "SELECT");
            try {
                resultSet.first();
                publisher = resultSet.getString(1);
            } catch (Exception e) {
            }            
            resultSet = doStatement("SELECT PRICE FROM BOOKS WHERE NAME='"+name+"'", "SELECT");
            try {
                resultSet.first();
                price = resultSet.getDouble(1);
            } catch (Exception e) {
            }
            book = new Book(name, author, genre, publisher, price);
        }
        return book;
    }
    
    public Book getBook(int id) {
        String name = "";
        String author = "";
        String genre = "";
        String publisher = "";
        double price = 0;
        Book book = new Book();
        int i = checkBookExists(id);
        if (i == 1){
            resultSet = doStatement("SELECT NAME FROM BOOKS WHERE ID="+id, "SELECT");
            try {
                resultSet.first();
                name = resultSet.getString(1);
            } catch (Exception e) {
            }
            resultSet = doStatement("SELECT AUTHOR FROM BOOKS WHERE ID="+id, "SELECT");
            try {
                resultSet.first();
                author = resultSet.getString(1);
            } catch (Exception e) {
            }
            resultSet = doStatement("SELECT GENRE FROM BOOKS WHERE ID="+id, "SELECT");
            try {
                resultSet.first();
                genre = resultSet.getString(1);
            } catch (Exception e) {
            }
            resultSet = doStatement("SELECT PUBLISHER FROM BOOKS WHERE ID="+id, "SELECT");
            try {
                resultSet.first();
                publisher = resultSet.getString(1);
            } catch (Exception e) {
            }            
            resultSet = doStatement("SELECT PRICE FROM BOOKS WHERE ID="+id, "SELECT");
            try {
                resultSet.first();
                price = resultSet.getDouble(1);
            } catch (Exception e) {
            }
            book = new Book(name, author, genre, publisher, price);
        }
        return book;
    }
    
    public Staff getStaff(String name) {
        String address = "";
        String email = "";
        int phoneNumber = 0;
        Staff staff = new Staff();
        int i = checkStaffExists(name);
        if (i == 1){
            resultSet = doStatement("SELECT ADDRESS FROM STAFF WHERE NAME='"+name+"'", "SELECT");
            try {
                resultSet.first();
                address = resultSet.getString(1);
            } catch (Exception e) {
            }
            resultSet = doStatement("SELECT EMAIL FROM STAFF WHERE NAME='"+name+"'", "SELECT");
            try {
                resultSet.first();
                email = resultSet.getString(1);
            } catch (Exception e) {
            }
            resultSet = doStatement("SELECT PHONE FROM STAFF WHERE NAME='"+name+"'", "SELECT");
            try {
                resultSet.first();
                phoneNumber = resultSet.getInt(1);
            } catch (Exception e) {
            }
            staff = new Staff(name, address, email, phoneNumber);
        }
        return staff;
    }
    
    public Staff getStaff(int id) {
        String name = "";
        String address = "";
        String email = "";
        int phoneNumber = 0;
        Staff staff = new Staff();
        int i = checkStaffExists(id);
        if (i == 1){
            resultSet = doStatement("SELECT NAME FROM STAFF WHERE ID="+id, "SELECT");
            try {
                resultSet.first();
                name = resultSet.getString(1);
            } catch (Exception e) {
            }
            resultSet = doStatement("SELECT ADDRESS FROM STAFF WHERE ID="+id, "SELECT");
            try {
                resultSet.first();
                address = resultSet.getString(1);
            } catch (Exception e) {
            }
            resultSet = doStatement("SELECT EMAIL FROM STAFF WHERE ID="+id, "SELECT");
            try {
                resultSet.first();
                email = resultSet.getString(1);
            } catch (Exception e) {
            }
            resultSet = doStatement("SELECT PHONE FROM STAFF WHERE ID="+id, "SELECT");
            try {
                resultSet.first();
                phoneNumber = resultSet.getInt(1);
            } catch (Exception e) {
            }
            staff = new Staff(name, address, email, phoneNumber);
        }
        return staff;
    }
    
    // Closes the ResultSet, Statement and database Connection
    public void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {
        }
    }

}
