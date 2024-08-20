import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
    static Connection con;
    public static Connection getConnection() {
        try {
            if(con == null) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/studentJdbc";
                // ConnectionData class is in the same directory with properties as: user, password;
                ConnectionData data = new ConnectionData();
                String user = data.user;
                String password = data.password;
                con = DriverManager.getConnection(url, user, password);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;

    }
}
