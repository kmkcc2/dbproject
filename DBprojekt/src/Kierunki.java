import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class Kierunki {
    private static DataBase db = new DataBase();
    public static List showList(){
        try{
            Statement statement = db.connection.createStatement();
            String query = "select \"Kierunki\".\"Nazwa\",\n" +
                    "\tCASE\n" +
                    "\t\tWHEN \"Kierunki\".\"Licencjat\" = TRUE THEN 'licencjat'\n" +
                    "\t\tELSE 'inzynier'\n" +
                    "\tEND\n" +
                    "\tas \"typ\"\n" +
                    "from \"Kierunki\";";
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
    public static List showList(String arr){

        try{
            Statement statement = db.connection.createStatement();
            String query = "select \"Kierunki\".\"Nazwa\",\n" +
                    "\tCASE\n" +
                    "\t\tWHEN \"Kierunki\".\"Licencjat\" = TRUE THEN 'licencjat'\n" +
                    "\t\tELSE 'inzynier'\n" +
                    "\tEND\n" +
                    "\tas \"typ\"\n" +
                    "from \"Kierunki\"" +
                    "where \""+arr+"\" = TRUE;";

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
    public static List searchKierunki(String arr){

        try{
            Statement statement = db.connection.createStatement();
            String query = "select \"Kierunki\".\"Nazwa\",\n" +
                    "\tCASE\n" +
                    "\t\tWHEN \"Kierunki\".\"Licencjat\" = TRUE THEN 'licencjat'\n" +
                    "\t\tELSE 'inzynier'\n" +
                    "\tEND\n" +
                    "\tas \"typ\"\n" +
                    "from \"Kierunki\"" +
                    "where \"Nazwa\" LIKE \'%"+arr+"%\';";

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
    public static void delRecord(String arr){

        try{
            Statement statement = db.connection.createStatement();
            String query = "DELETE FROM public.\"Kierunki\" WHERE \"Nazwa\" = \'"+arr+"\'";
            statement.executeQuery(query);

        } catch(Exception e){
            System.out.println(e);
        }


    }
    public static void dodajKierunek(String nazwa, Boolean licencjat, int kolegium, int pracownik){
        try{
            Statement statement = db.connection.createStatement();
            String query = "Insert INTO \"Kierunki\"(\"Nazwa\", \"Licencjat\", \"Inzynier\", \"Id_kolegia\", \"Id_pracownicy\")" +
                    "VALUES(\'"+nazwa+"\',"+licencjat+","+!licencjat+","+kolegium+","+pracownik+")";
            statement.executeQuery(query);
        } catch(Exception e){
            System.out.println(e);
        }

    }
}
