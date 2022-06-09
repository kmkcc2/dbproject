import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class Export {
    private static DataBase db = new DataBase();

    private static String checkColumnType(String kolumna, String tabela){
        try{
            Statement statement = db.connection.createStatement();
            String query = "SELECT pg_typeof(\""+kolumna+"\") from \""+tabela+"\" limit 1;";
            ResultSet result = statement.executeQuery(query);
            String data_type = "";
            while (result.next()) {
                data_type = result.getString(1);
            }
            return data_type;
        } catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
    private static int columnCount;
    private static String[] columnNames;
        public static List listaExport(String tabela){
            try{
                Statement statement = db.connection.createStatement();
                String query = "select * from \""+tabela+"\";";
                ResultSet result = statement.executeQuery(query);
                ResultSetMetaData meta = result.getMetaData();
                columnCount = meta.getColumnCount();
                columnNames = new String[columnCount];
                for (int i = 1; i< columnCount;i++){
                    columnNames[i] = meta.getColumnName(i+1);
                }
                List queryData = new LinkedList<>();
                while(result.next()){
                    for (int i = 1; i < columnCount+1; i++) {
                        queryData.add(result.getString(i));
                    }
                }
                return queryData;
            } catch(Exception e){
                System.out.println(e);
            }
            return null;
    }
    public static String[] getColumnNames(String tabela){
        Statement statement = null;
        String[] columnNames = null;
        try {
            statement = db.connection.createStatement();
            String query = "Select * from \""+tabela+"\"";
            ResultSet result = statement.executeQuery(query);
            ResultSetMetaData meta = result.getMetaData();
            columnCount = meta.getColumnCount();
            columnNames = new String[columnCount];
            for (int i = 1; i< columnCount;i++){
                columnNames[i] = meta.getColumnName(i+1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return columnNames;
    }
        public static List listaFiltrExport(String tabela, String kolumna, String warunek){
        try{
            Statement statement = db.connection.createStatement();
            String data_type = checkColumnType(kolumna, tabela);
            String query = "";
            if(data_type.equals("integer")){
                int war = Integer.parseInt(warunek);
                 query = "select * from \""+tabela+"\" where \""+kolumna+"\" = "+war+";";
            }else if(data_type.equals("boolean") ){
                 query = "select * from \""+tabela+"\" where \""+kolumna+"\" = "+warunek+";";
            }else{
                 query = "select * from \""+tabela+"\" where \""+kolumna+"\" LIKE '%"+warunek+"%';";
            }

            ResultSet result = statement.executeQuery(query);
            ResultSetMetaData meta = result.getMetaData();
            columnCount = meta.getColumnCount() - 1;
            columnNames = new String[columnCount];
            for (int i = 1; i< columnCount;i++){
                columnNames[i] = meta.getColumnName(i+1);
            }
            List queryData = new LinkedList<>();
            while(result.next()){
                for (int i = 1; i < columnCount+1; i++) {
                    queryData.add(result.getString(i));
                }
            }
            return queryData;
        } catch(Exception e){
            System.out.println("Tutaj jest problem: ");
            System.out.println(e);
        }
        return null;
    }
        public static TableModel updatePreview(String tabela){
            List lista = listaExport(tabela);
            int rekordy = lista.size()/columnCount;
            String data[][] = new String[rekordy][columnCount];
            for (int i = 0, k=0; i < rekordy; i++) {
                for (int j = 0; j < columnCount; j++) {
                    data[i][j] = (String)lista.get(k);
                    k++;

                }
            }
            TableModel model = new DefaultTableModel(data, columnNames) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;//This causes all cells to be not editable
                }
            };
            return model;
        }
        public static TableModel filtrTable(String tabela, String columna, String filtr){
            List lista = listaFiltrExport(tabela,columna,filtr);
            int rekordy = lista.size()/columnCount;
            String data[][] = new String[rekordy][columnCount];
            for (int i = 0, k=0; i < rekordy; i++) {
                for (int j = 0; j < columnCount; j++) {
                    data[i][j] = (String)lista.get(k);
                    k++;

                }
            }
            TableModel model = new DefaultTableModel(data, columnNames) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;//This causes all cells to be not editable
                }
            };
            return model;
        }
        public static boolean exportToCSV(JTable tableToExport,
                                          String pathToExportTo) {

            try {

                TableModel model = tableToExport.getModel();
                FileWriter csv = new FileWriter(new File(pathToExportTo));

                for (int i = 0; i < model.getColumnCount(); i++) {
                    csv.write(model.getColumnName(i) + ",");
                }

                csv.write("\n");

                for (int i = 0; i < model.getRowCount(); i++) {
                    for (int j = 0; j < model.getColumnCount(); j++) {
                        csv.write(model.getValueAt(i, j).toString() + ",");
                    }
                    csv.write("\n");
                }

                csv.close();
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }
//
}
