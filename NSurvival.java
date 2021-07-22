import java.sql.*;
import java.util.ArrayList;

public class NSurvival {
    public static void main(String[] args) {
        DB dinoBase = new DB("owned_dinosaurs", true);

        ArrayList<String> ds = dinoBase.selectAll("dLvl" );

        for (String dname:ds) {
            System.out.println(dname);
        }
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
            query = "select * from " + schema;
            res = stmt.executeQuery(query);

            if (feedback = true) {
                System.out.println("Connection successful");
            }
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("YOUR DATABASE IS NOT REACHABLE USING THIS FOLLOWING URL:" + url);
        }
    }

    public ArrayList selectAll(String selector) {
        ArrayList objs = new ArrayList<Object>();

        try {
            conn = DriverManager.getConnection(url, "RoyalFire", "#SQLPass12345");
            stmt = conn.createStatement();

            query = "select * from " + schema;
            res = stmt.executeQuery(query);

            while (res.next()){
                objs.add(res.getString(selector));
            }

            return objs;

        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("YOUR DATABASE IS NOT REACHABLE USING THIS FOLLOWING URL:" + url);
            return objs;
        }
    }
}
