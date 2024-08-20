import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcCreateConnection {
    public static void main(String[] args) {
        try{
            // load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // create a connection
            String url = "jdbc:mysql://localhost:3306/studentJdbc";
            String user = "root";
            String password = "root";
            Connection con = DriverManager.getConnection(url, user, password);

            if(con.isClosed()) {
                System.out.println("connection is closed");
            }
            else {
                System.out.println("connection created");
            }


        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
