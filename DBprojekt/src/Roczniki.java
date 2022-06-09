import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class Roczniki {

        private static DataBase db = new DataBase();

        public static List listaRoczniki(){
            try{
                Statement statement = db.connection.createStatement();
                String query = "select \"Roczniki\".\"Data_rozpoczecia\", \"Roczniki\".\"Stopien\",\n" +
                        "CASE \n" +
                        "\tWHEN \"Roczniki\".\"Stacjonarne\" = TRUE THEN 'Stacjonarne'\n" +
                        "\tELSE 'Niestacjonarne'\n" +
                        "end as \"Typ\", \"Studenci\".\"Nr_albumu\" as \"Starosta\"\n" +
                        "from \"Roczniki\"\n" +
                        "JOIN \"Studenci\" on \"Studenci\".\"Id_studenci\" = \"Roczniki\".\"Id_studenci\"\n" +
                        "\n" +
                        "\n";
                ResultSet result = statement.executeQuery(query);
                List queryData = new LinkedList<>();
                while(result.next()){
                    for (int i = 1; i < 5; i++) {
                        queryData.add(result.getString(i));
                    }
                }
                return queryData;
            } catch(Exception e){
                System.out.println(e);
            }
            return null;
        }
        public static List showRocznik(String rok){
            try{
                Statement statement = db.connection.createStatement();
                String query = "select * from rocznik('"+rok+"')";
                ResultSet result = statement.executeQuery(query);
                List queryData = new LinkedList<>();
                while(result.next()){
                    for (int i = 1; i < 7; i++) {
                        queryData.add(result.getString(i));
                    }
                }
                return queryData;
            } catch(Exception e){
                System.out.println(e);
            }
            return null;
        }
    public static List searchRocznik(String arr){

        try{
            Statement statement = db.connection.createStatement();
            String query = "select \"Roczniki\".\"Data_rozpoczecia\", \"Roczniki\".\"Stopien\",\n" +
                    "CASE \n" +
                    "\tWHEN \"Roczniki\".\"Stacjonarne\" = TRUE THEN 'Stacjonarne'\n" +
                    "\tELSE 'Niestacjonarne'\n" +
                    "end as \"Typ\", \"Studenci\".\"Nr_albumu\" as \"Starosta\"\n" +
                    "from \"Roczniki\"\n" +
                    "JOIN \"Studenci\" on \"Studenci\".\"Id_studenci\" = \"Roczniki\".\"Id_studenci\"\n" +
                    "WHERE \"Roczniki\".\"Data_rozpoczecia\" LIKE '%"+arr+"%' \n" +
                    "\n";

            ResultSet result = statement.executeQuery(query);
            List queryData = new LinkedList<>();
            while(result.next()){
                for (int i = 1; i < 5; i++) {
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
