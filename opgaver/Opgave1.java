package opgaver;

import java.sql.*;

public class Opgave1 {
    public static void main(String[] args) {

        try {
            Connection minConnection;
            minConnection = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-C9CSAU4\\SQLExpress;databaseName=Tidsregistrering_SH;user=sa;password=Rbh66tvy;");

            Statement stmt = minConnection.createStatement();

            ResultSet resultSet = stmt.executeQuery("Select medarbejderNr, navn, stillingsbetegnelse, mobil from medarbejder");

            while (resultSet.next()){
                System.out.println(resultSet.getString(1)+ "\t"  + resultSet.getString(2) + " \t "  +resultSet.getString(3) + " \t" + resultSet.getString(4));
            }

            if (resultSet != null)
                resultSet.close();
            if (stmt != null)
                stmt.close();
            if (minConnection != null)
                minConnection.close();


        }catch (SQLException se){
            System.out.println("Error message: " + se.getMessage());
        }
    }
}
