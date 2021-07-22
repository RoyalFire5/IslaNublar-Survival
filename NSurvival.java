import java.sql.*;

public class NSurvival {
    public static void main(String[] args) {
        DB dinoBase = new DB("owned_dinosaurs", true);
    }
}

class DB {
    private String url = "jdbc:mysql://localhost:3306/nsurvival";
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet res = null;
    private String query = null;
    private String schema = null;

    public DB(String schemaName, Boolean feedback) {
        schema = schemaName;
        try {
            conn = DriverManager.getConnection(url, "RoyalFire", "#SQLPass12345");
            stmt = conn.createStatement();
            if (feedback = true) {
                System.out.println("Connection successful");
            }
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("YOUR DATABASE IS NOT REACHABLE USING TH FOLLOWING URL:" + url);
        }
    }
}
