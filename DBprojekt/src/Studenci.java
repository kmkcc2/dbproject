import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class Studenci {
    private static DataBase db = new DataBase();

    public static List listStud(){
        try{
            Statement statement = db.connection.createStatement();
            String query = "SELECT \"Nr_albumu\", \"Pesel\", \"Imie\", \"Nazwisko\", \"Kierunki\".\"Nazwa\", \"Rok\", " +
                    "CASE" +
                    "   WHEN \"Stypendium_socjalne\" = TRUE THEN 'TAK' ELSE 'NIE' END, " +
                    "CASE" +
                    "   WHEN \"Stypendium_rektora\" = TRUE THEN 'TAK' ELSE 'NIE' END, \"Plec\"\n" +
                    "FROM public.\"Studenci\"\n" +
                    "JOIN \"Kierunki\" on \"Kierunki\".\"Id_kierunki\" = \"Studenci\".\"Id_kierunki\"";
            ResultSet result = statement.executeQuery(query);
            List queryData = new LinkedList<>();
            while(result.next()){
                for (int i = 1; i < 10; i++) {
                    queryData.add(result.getString(i));
                }
            }
            return queryData;
        } catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
    public static void delRecord(String nr){

        try{
            Statement statement = db.connection.createStatement();
            String query = "DELETE FROM public.\"Studenci\" WHERE \"Nr_albumu\" = \'"+nr+"\';";
            statement.executeQuery(query);

        } catch(Exception e){
            System.out.println(e);
        }


    }
    public static void dodajStud(String pesel, String imie, String nazwisko, String kierunek, int rok, boolean socjal, boolean rektor, String plec){
        int id_kierunku_i = 0;
        try{
            Statement statement = db.connection.createStatement();
            String query = "SELECT \"Id_kierunki\""+
                    "FROM public.\"Kierunki\" " +
                    "Where \"Nazwa\" = '"+kierunek+"'";
            ResultSet result = statement.executeQuery(query);
            List queryData = new LinkedList<>();
            while(result.next()){
                for (int i = 1; i < 2; i++) {
                    queryData.add(result.getString(i));
                }
            }
            String id_kierunku = String.valueOf(queryData.get(0));
            id_kierunku_i = Integer.valueOf(id_kierunku);
        } catch(Exception e){
            System.out.println(e);
        }
        try{
            Statement statement = db.connection.createStatement();
            String query = "INSERT INTO public.\"Studenci\"(\n" +
                    "\t\"Pesel\", \"Imie\", \"Nazwisko\", \"Id_kierunki\", \"Rok\", \"Stypendium_socjalne\", \"Stypendium_rektora\", \"Plec\")\n" +
                    "\tVALUES ('"+pesel+"', '"+imie+"', '"+nazwisko+"', '"+id_kierunku_i+"', '"+rok+"', '"+socjal+"', '"+rektor+"', '"+plec+"');";
            statement.executeQuery(query);
        } catch(Exception e){
            System.out.println(e);
        }

    }
    public static List searchStud(String arr){

        try{
            Statement statement = db.connection.createStatement();
            String query = "SELECT \"Nr_albumu\", \"Pesel\", \"Imie\", \"Nazwisko\", \"Kierunki\".\"Nazwa\", \"Rok\", " +
                    "CASE" +
                    "   WHEN \"Stypendium_socjalne\" = TRUE THEN 'TAK' ELSE 'NIE' END, " +
                    "CASE" +
                    "   WHEN \"Stypendium_rektora\" = TRUE THEN 'TAK' ELSE 'NIE' END, \"Plec\"\n" +
                    "FROM public.\"Studenci\"\n" +
                    "JOIN \"Kierunki\" on \"Kierunki\".\"Id_kierunki\" = \"Studenci\".\"Id_kierunki\""+
                    "WHERE \"Nr_albumu\" LIKE '%"+arr+"%' OR \"Imie\" LIKE '%"+arr+"%' OR \"Nazwisko\" LIKE '%"+arr+"%' OR \"Nazwa\" LIKE '%"+arr+"%'";

            ResultSet result = statement.executeQuery(query);
            List queryData = new LinkedList<>();
            while(result.next()){
                for (int i = 1; i < 10; i++) {
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
