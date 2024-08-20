import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

public class SelectQuery {
    public static void main(String[] args) {
        try {
            Connection con = ConnectionProvider.getConnection();
            String q = "select * from stdinfo";
            Statement stmt = con.createStatement();
            ResultSet rSet = stmt.executeQuery(q);
            // rSet is storing data in same as the table (in form of rows and columns)
            // rSet has a pointer which points to above the first row in the beginning.
            // to go to next row, use next() method.

            while(rSet.next()) {
                int id = rSet.getInt(1);
                String name = rSet.getString(2);
                // String city = rSet.getString(3);
                String city = rSet.getString("sCity");
                // int marks = rSet.getInt(4);
                int marks = rSet.getInt("sMarks");
                // System.out.println("id: " + id + " name: " + name + " city: " + city + " marks: " + marks);

                System.out.println(id + "   | " + name + "   | " + city + "   | " + marks);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
