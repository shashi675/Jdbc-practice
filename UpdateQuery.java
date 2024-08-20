import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateQuery {
    public static void main(String[] args) {
        try {
            Connection con = ConnectionProvider.getConnection();
            String q = "update stdInfo set sName = ?, sCity = ?, sMarks = ? where sId = ?";
    
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setString(1, "skr");
            pstmt.setString(2, "Kolkata");
            pstmt.setInt(3, 21);
            pstmt.setInt(4, 4);
            pstmt.executeUpdate();

            System.out.println("update successfull");
            con.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
