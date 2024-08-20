import java.sql.*;

public class CreateQuery {
    public static void main(String[] args) {
        try {
            // load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create a connection
            String url = "jdbc:mysql://localhost:3306/studentjdbc";
            String user = "root";
            String password = "root";
            Connection con = DriverManager.getConnection(url, user, password);

            // create a query
            String q = "create table stdInfo(sId int primary key auto_increment, sName varchar(100) not null, sCity varchar(200))";

            // create a statement
            Statement stmt = con.createStatement();

            // execute the query
            // executeUpdate(q) -> when no data is returned by the database.
            // if data is returned, use executeQuery, and store in ResultSet object.
            stmt.executeUpdate(q);
            System.out.println("table created successfully");

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
