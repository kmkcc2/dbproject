import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class Kolegia {
    private static DataBase db = new DataBase();

    public static List listaKolegia(){
        try{
            Statement statement = db.connection.createStatement();
            String query = "select \"Kolegia\".\"Nazwa\", \"Kolegia\".\"Budynek\""+
                    "from \"Kolegia\";";
            ResultSet result = statement.executeQuery(query);
            List queryData = new LinkedList<>();
            while(result.next()){
                for (int i = 1; i < 3; i++) {
                    queryData.add(result.getString(i));
                }
            }
            return queryData;
        } catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
}
