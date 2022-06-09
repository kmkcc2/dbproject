import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class DataBase {
    public Connection connection = null;
    public DataBase(){
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/uczelnia","postgres","student");
            if(connection!=null){

            }else{
                System.out.println("Connection failed");
            }

        } catch(Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null,"Błąd podczas łączenia z bazą danych.");
        }
    }

}
