import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class Import {
    private static DataBase db = new DataBase();
    public static Exception sqlexc;
    public static boolean importFromCSV(String table, String delimiter, String path, String header) {
        try{
            Statement statement = db.connection.createStatement();
            String query = "";
            if(header != "NO"){
                query = "COPY \""+table+"\" FROM '"+path+"' DELIMITER '"+delimiter+"' CSV HEADER";
            }else{
                query = "COPY \""+table+"\" FROM '"+path+"' DELIMITER '"+delimiter+"' CSV";
            }


            statement.executeUpdate(query);
            return true;
        } catch(Exception e) {
            System.out.println(e);
            sqlexc = e;
        }
        return false;
    }
}
