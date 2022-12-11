package Model;

import javax.imageio.IIOException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.util.ArrayList;

public class TableStorage {
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

    public static void createTableTables() throws ClassNotFoundException, SQLException, IIOException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        statement.executeUpdate("use home_works");
        statement.executeUpdate("INSERT INTO tables (count, category) VALUES (4,1), (4,1), (4,1), (4,1), (8, 1), (6,2)," +
                "(8,2);");
    }

    public static boolean tableExist(int number) throws ClassNotFoundException, SQLException, IIOException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        statement.executeUpdate("use home_works");
        ResultSet resultSet = statement.executeQuery("Select id from tables;");
        ArrayList<Integer> numbers = new ArrayList<>();
        while (resultSet.next()){
            numbers.add(resultSet.getInt(1));
        }
        if(numbers.contains(number)){
            return true;
        }else {
            return false;
        }
    }

    public static Table getTable(int number) throws ClassNotFoundException, SQLException, IIOException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        statement.executeUpdate("use home_works");
        String a = String.valueOf(number);
        ResultSet resultSet = statement.executeQuery("Select * from tables where id =" + a + " ;");
        int n1; int n2; int n3;
        if (resultSet.next()){
            n1 = resultSet.getInt(1);
            n2 = resultSet.getInt(2);
            n3 = resultSet.getInt(3);
            return new Table(n1, n2, n3);
        }
        return new Table();


    }
}
