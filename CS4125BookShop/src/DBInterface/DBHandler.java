package DBInterface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import Orders.Book;
import Customers.Customer;

public class DBHandler {
    
    private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private String name;
    
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
                            "PRIMARY KEY (ID))");
            
            // Create the ORDERS table if it doesn't already exist
            statement.execute("CREATE TABLE IF NOT EXISTS ORDERS (" +
                            "ID INT NOT NULL AUTO_INCREMENT, " +
                            "NAME VARCHAR(30) NOT NULL, " +
                            "PRICE DECIMAL(4,2) DEFAULT 0.00, " +
                            "PRIMARY KEY (ID))");
            
            statement.execute("CREATE TABLE IF NOT EXISTS CUSTOMERS (" +
                            "ID INT NOT NULL AUTO_INCREMENT, " +
                            "NAME VARCHAR(30) NOT NULL, " +
                            "EMAIL VARCHAR(30) NOT NULL, " +
                            "MEMSHIP INT, " +
                            "PRIMARY KEY (ID))");
            
            // Create the STORESTOCK table if it doesn't already exist
            statement.execute("CREATE TABLE IF NOT EXISTS STORESTOCK (" +
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
                            "PRIMARY KEY (ID))");
            
            // Create the ORDERS table if it doesn't already exist
            statement.execute("CREATE TABLE IF NOT EXISTS ORDERS (" +
                            "ID INT NOT NULL AUTO_INCREMENT, " +
                            "NAME VARCHAR(30) NOT NULL, " +
                            "PRICE DECIMAL(4,2) DEFAULT 0.00, " +
                            "PRIMARY KEY (ID))");
            
            // Create the STORESTOCK table if it doesn't already exist
            statement.execute("CREATE TABLE IF NOT EXISTS STORESTOCK (" +
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
        resultSet = doStatement("SELECT EXISTS(SELECT * FROM BOOKS WHERE NAME='"+bookName+"')", "SELECT");
        int i = 0;
        try {
            resultSet.first();
            i = resultSet.getInt(1);
        } catch (Exception e) {
        }
        return i;
    }
    
    public int checkidExists(int id) {
        resultSet = doStatement("SELECT EXISTS(SELECT * FROM BOOKS WHERE ID='"+id+"')", "SELECT");
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
    
    // Adds a new row to BOOKS
    public void insertBook(Book book) {
        name = book.getName();
        int i = checkBookExists(name);
        if (i == 0) {
            doStatement("insert into CS4125BOOKSHOP.BOOKS values (default, '"+book.getName()+"', '"+book.getAuthor()+"', '"
                    +book.getGenre()+"', '"+book.getPublisher()+"', "+book.getPrice()+")", "INSERT");
            doStatement("insert into CS4125BOOKSHOP.STORESTOCK values ("+getBookID(book.getName())+", 0)", "INSERT");
        }
    }
    
    // Removes row from BOOKS (identified by id)
    public void deleteBook(int id) {
        int i = checkidExists(id);
        if (i == 0) {
              doStatement("DELETE FROM BOOKS WHERE ID='"+id+"'", "UPDATE");
              doStatement("DELETE FROM STORESTOCK WHERE ID='"+id+"'", "UPDATE");
        }
    }
    
    // Updates the values of a row in BOOKS (identified by id)
    public void updateBook(int id, Book book) {
        int i = checkidExists(id);
        if (i == 0){
            doStatement("UPDATE BOOKS SET NAME='"+book.getPublisher()+"' WHERE ID='"+id+"'", "UPDATE");
            doStatement("UPDATE BOOKS SET AUTHOR='"+book.getAuthor()+"' WHERE ID='"+id+"'", "UPDATE");
            doStatement("UPDATE BOOKS SET GENRE='"+book.getGenre()+"' WHERE ID='"+id+"'", "UPDATE");
            doStatement("UPDATE BOOKS SET PUBLISHER='"+book.getPublisher()+"' WHERE ID='"+id+"'", "UPDATE");
            doStatement("UPDATE BOOKS SET PRICE="+book.getPrice()+" WHERE ID='"+id+"'", "UPDATE");
        }
    }
    
    // Updates the values of a row in STORESTOCK (book identified by id, boolean add true to add amount to stock, false for subtract)
    public void updateStoreStock(int id, int amount) {
        int i = checkidExists(id);
        if (i == 0){
            doStatement("UPDATE STORESTOCK SET AMOUNT='"+amount+"' WHERE ID='"+id+"'", "UPDATE");
        }
    }
    
    // Returns the amount associated with a row in STORESTOCK identified by (book) id
    public int getStoreStockAmount(int id) {
        resultSet = doStatement("SELECT AMOUNT FROM STORESTOCK WHERE ID='"+id+"'", "SELECT");
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
        String pub = "";
        double price = 0;
        Book book = new Book();
        int i = checkBookExists(name);
        if (i == 0){
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
                            pub = resultSet.getString(1);
                        } catch (Exception e) {
                        }            
            resultSet = doStatement("SELECT PRICE FROM BOOKS WHERE NAME='"+name+"'", "SELECT");
                                try {
                            resultSet.first();
                            price = resultSet.getDouble(1);
                        } catch (Exception e) {
                        }
            book = new Book (name, author, genre, pub, price);
        }
        return book;
    }
            public void addCustomer(Customer customer) {
            doStatement("insert into CS4125BOOKSHOP.CUSTOMERS values (default, '"+customer.getName()+"', '"+customer.getEmail()+"', '"
                +customer.getMemship(), "INSERT");
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
