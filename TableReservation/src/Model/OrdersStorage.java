package Model;

import javax.imageio.IIOException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.util.ArrayList;

public class OrdersStorage {
    public static final String USER_NAME =  "root";
    public  static  final String PASSWORD;

    static {
        try {
            PASSWORD = Files.readString(Path.of("/Users/goodday/TextFiles/Pass.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static final String URL = "jdbc:mysql://localhost:3306/mysql";
    public static Statement statement;
    public static Connection connection;
    static {
        try {
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        }catch (SQLException throwables){
            throwables.printStackTrace();
            throw new RuntimeException();
        }
    }
    static {
        try {
            statement = connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        }
    }
    public static void makeOrder(int dateOrder, int tableId)throws ClassNotFoundException, SQLException, IIOException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        statement.executeUpdate("use home_works");
        statement.executeUpdate("INSERT INTO OrdersTables (DateOrder, TableId) Values (" +
                dateOrder  + "," + tableId+");");
    }

    public static void changeTable(int dateOrder, int tableId) throws ClassNotFoundException, SQLException, IIOException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        statement.executeUpdate("use home_works");
        statement.executeUpdate("DELETE FROM OrdersTables " +
                "WHERE DateOrder=" +
                dateOrder + " AND TableId =" + tableId + ";");
    }


    public static ResultSet loadTables(int date) throws ClassNotFoundException, SQLException, IIOException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        statement.executeUpdate("use home_works");
        ResultSet resultSet = statement.executeQuery("SELECT *"
                +
                "FROM tables " +
                "WHERE tables.id not IN (Select TableId from OrdersTables where DateOrder =" + date +")");
        return resultSet;

    }

    public static boolean orderExist(int date, int numberTable) throws ClassNotFoundException, SQLException, IIOException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        statement.executeUpdate("use home_works");
        boolean res = false;
        ResultSet resultSet = statement.executeQuery("SELECT EXISTS(SELECT * FROM OrdersTables WHERE DateOrder =" +
                date + " and TableId = " + numberTable + " );");
        if(resultSet.next()) {
            res = resultSet.getBoolean(1);
        }
        return res;
    }




}
