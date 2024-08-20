import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertQuery {
    public static void main(String[] args) {
        try {
            // load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // create connection
            String url = "jdbc:mysql://localhost:3306/studentJdbc";
            String user = "root";
            String password = "root";
            Connection con = DriverManager.getConnection(url, user, password);

            // create a query
            String q = "insert into stdInfo(sName, sMarks, sCity) values(?, ?, ?)";

            // preparedStatement: used for dynamic/paramitarized queries (which accept parameter dynamically). eg: values(?,?).
            
            // get the preparedStatement object
            PreparedStatement pstmt = con.prepareStatement(q);

            // set the values
            pstmt.setString(1, "Shashi KR");
            pstmt.setInt(2, 30);
            pstmt.setString(3, "Patna");

            pstmt.executeUpdate();

            System.out.println("data inserted in the table");
            con.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
