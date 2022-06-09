import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class Przedmioty {
    private static DataBase db = new DataBase();

    public static List listPrzed(){
        try{
            Statement statement = db.connection.createStatement();
            String query = "select DISTINCT \"Przedmioty\".\"Nazwa\",\"Przedmioty\".\"pkt_ECTS\""+
                    "from \"Przedmioty\";";
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
    public static void delRecord(String nazwa){

        try{
            Statement statement = db.connection.createStatement();
            String query = "DELETE FROM public.\"Przedmioty\" WHERE \"Nazwa\" = \'"+nazwa+"\';";
            statement.executeQuery(query);

        } catch(Exception e){
            System.out.println(e);
        }


    }
    public static void dodajPrzed(String nazwa, int id_prac, int id_kier, int pkt_ECTS){
        try{
            Statement statement = db.connection.createStatement();
            String query = "Insert INTO \"Przedmioty\"(\"Nazwa\", \"Id_pracownicy\", \"Id_kierunki\", \"pkt_ECTS\")" +
                    "VALUES(\'"+nazwa+"\',\'"+id_prac+"\',\'"+id_kier+"\', \'"+pkt_ECTS+"\')";
            statement.executeQuery(query);
        } catch(Exception e){
            System.out.println(e);
        }

    }
    public static List searchPrzed(String arr){

        try{
            Statement statement = db.connection.createStatement();
            String query = "select DISTINCT \"Przedmioty\".\"Nazwa\", \"Przedmioty\".\"pkt_ECTS\"" +
                    "from \"Przedmioty\"\n" +
                    "WHERE \"Nazwa\" LIKE '%"+arr+"%'\n";

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
