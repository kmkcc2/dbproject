import javax.swing.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class Pracownicy {
    private static DataBase db = new DataBase();

    public static List listPrac(){
        try{
            Statement statement = db.connection.createStatement();
            String query = "select \"Pracownicy\".\"Imie\", \"Pracownicy\".\"Nazwisko\",\"Pracownicy\".\"Stopien_naukowy\",\"Pracownicy\".\"Instytut\"\n" +
                    "from \"Pracownicy\";";
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

    public static List prac_bez_opie(){
        try{
            Statement statement = db.connection.createStatement();
            String query = "select * from prac_bez_opie();";
            ResultSet result = statement.executeQuery(query);
            List queryData = new LinkedList<>();
            while(result.next()){
                for (int i = 1; i < 4; i++) {
                    queryData.add(result.getString(i));
                }
            }
            return queryData;
        } catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
    public static void delRecord(String imie,String nazwisko){

        try{
            Statement statement = db.connection.createStatement();
            String query = "DELETE FROM public.\"Pracownicy\" WHERE \"Imie\" = \'"+imie+"\' AND \"Nazwisko\" = \'"+nazwisko+"\';";
            statement.executeQuery(query);
            JOptionPane.showMessageDialog(null, "Pomyślnie usunięto 1 rekord!");
        } catch(Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Nie moża usunąć pracownika");
        }


    }
    public static void dodajPraco(String imie, String nazwisko, String stopien, String instytut, Boolean opiekun){
        try{
            Statement statement = db.connection.createStatement();
            String query = "Insert INTO \"Pracownicy\"(\"Imie\", \"Nazwisko\", \"Stopien_naukowy\", \"Instytut\",\"Opiekun_roku\")" +
                    "VALUES(\'"+imie+"\',\'"+nazwisko+"\',\'"+stopien+"\',\'"+instytut+"\',\'"+opiekun+"\')";
            statement.executeQuery(query);
        } catch(Exception e){
            System.out.println(e);
        }

    }
    public static List searchPraco(String arr){

        try{
            Statement statement = db.connection.createStatement();
            String query = "select \"Pracownicy\".\"Imie\", \"Pracownicy\".\"Nazwisko\",\"Pracownicy\".\"Stopien_naukowy\",\"Pracownicy\".\"Instytut\"\n" +
                    "from \"Pracownicy\"\n" +
                    "WHERE \"Imie\" LIKE '%"+arr+"%'\n" +
                    " OR \"Nazwisko\" LIKE '%"+arr+"%'"+
                    " OR \"Stopien_naukowy\" LIKE '%"+arr+"%'"+
                    " OR \"Instytut\" LIKE '%"+arr+"%';";

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
