import java.io.FileInputStream;
import java.sql.*;


public class InsertImage {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/studentJdbc";
            String user = "root";
            String password = "root";
            Connection con = DriverManager.getConnection(url, user, password);
            
            String q = "insert into images(pic) values (?)";
            PreparedStatement pstmt = con.prepareStatement(q);

            FileInputStream fis = new FileInputStream("logicalXOR.png");
            // image size should less than 65kb (blob datatype)
            pstmt.setBinaryStream(1, fis, fis.available());
            pstmt.executeUpdate();

            System.out.println("image inserted");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
