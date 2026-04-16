package DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

    private static final String DBName="EventManagement";
    private static final String ServerName="localhost:3306";


    private static final String URL="jdbc:mysql://"+ServerName+"/"+DBName;

    private static final String UserName="root";
    private static final String Password="";


    public static Connection getConnection()
    {
        try {
            System.out.println("Connected to DB!");
            return DriverManager.getConnection(URL, UserName, Password);
        }
        catch (Exception e)
        {

            e.printStackTrace();
            System.out.println(e.toString());

        }
        return  null;
    }
}
