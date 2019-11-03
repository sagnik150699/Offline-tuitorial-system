package Tutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
    Connection connection;
    Statement statement;

    private static final String Url = "jdbc:mysql://localhost:3306/onlinetutorial";
    private static final String Username = "root";
    private static final String Password = "123456789";

    public Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(Url, Username, Password);

            statement = connection.createStatement();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Conn ob = new Conn();
    }
}

