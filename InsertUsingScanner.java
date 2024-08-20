import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertUsingScanner {
    public static void main(String[] args) {
        try {
            // load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // create the connection
            String url = "jdbc:mysql://localhost:3306/studentJdbc";
            String user = "root";
            String password = "root";
            Connection con = DriverManager.getConnection(url, user, password);

            // create a query
            String q = "insert into stdInfo (sName, sCity, sMarks) values (?, ?, ?)";

            // take user input using Scanner
            Scanner sc = new Scanner(System.in);
            System.out.println("enter student name");
            String sName = sc.nextLine();
            System.out.println("enter student city");
            String sCity = sc.nextLine();
            System.out.println("enter student marks");
            int sMarks = sc.nextInt();

            // prepared statement object
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setString(1, sName);
            pstmt.setString(2, sCity);
            pstmt.setInt(3, sMarks);

            // execute the query
            pstmt.executeUpdate();

            System.out.println("data inserted in table");
            con.close();
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
