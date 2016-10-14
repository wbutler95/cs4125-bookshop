package cs4125bookshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DBHandler {
    
    private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private String name;

    // Default constructor creates a connection to MySQL using IP localhost, database cs4125bookshop, 
    // username sqluser, password sqluserpw
    // Taken from JDBC use example by UL Staff Member: James Murphy
    public DBHandler() {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Set up the connection with the DB
            connect = DriverManager.getConnection("jdbc:mysql://localhost/cs4125bookshop?"+"user=sqluser&password=sqluserpw");

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
        } catch (Exception e) {
        }
    }
    
    // Constructor creates a connection to MySQL using parameters for IP, database, username, password
    // Taken from JDBC use example by UL Staff Member: James Murphy
    public DBHandler(String ip, String db, String user, String pw) {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager.getConnection("jdbc:mysql://"+ip+"/"+db+"?"+"user="+user+"&password="+pw);

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
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
    
    // Adds a new row to BOOKS
    public void insertBook(Book book) {
        name = book.getName();
        int i = checkBookExists(name);
    if (i == 0)
        doStatement("insert into CS4125BOOKSHOP.BOOKS values (default, '"+book.getName()+"', '"+book.getAuthor()+"', '"
                +book.getGenre()+"', '"+book.getPublisher()+"', "+book.getPrice()+")", "INSERT");
    return;
    }
    
    // Removes row from BOOKS (identified by id)
    public void deleteBook(int id) {
    int i = checkidExists(id);
    if (i == 0)
        doStatement("DELETE FROM BOOKS WHERE ID='"+id+"'", "UPDATE");
    }
    
    // Updates the values of a row in BOOKS (identified by id)
    public void updateBook(int id, Book book) {
        int i = checkidExists(id);
        if (i == 0){
        doStatement("UPDATE BOOKS SET NAME='"+book.getName()+"' WHERE ID='"+id+"'", "UPDATE");
        doStatement("UPDATE BOOKS SET AUTHOR='"+book.getAuthor()+"' WHERE ID='"+id+"'", "UPDATE");
        doStatement("UPDATE BOOKS SET GENRE='"+book.getGenre()+"' WHERE ID='"+id+"'", "UPDATE");
        doStatement("UPDATE BOOKS SET PUBLISHER='"+book.getPublisher()+"' WHERE ID='"+id+"'", "UPDATE");
        doStatement("UPDATE BOOKS SET PRICE="+book.getPrice()+" WHERE ID='"+id+"'", "UPDATE");
                    }
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

