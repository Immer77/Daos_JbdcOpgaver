package opgaver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class Opgave3 {

    public static void main(String[] args) {

        try {
            System.out.println("Find mobilnummer på medarbejder");
            BufferedReader inLine = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Intast navn: ");
            String navn = inLine.readLine();


            Connection minConnection;
            minConnection = DriverManager.getConnection(
                    "jdbc:sqlserver://DESKTOP-C9CSAU4\\SQLExpress;databaseName=Tidsregistrering_SH;user=sa;password=Rbh66tvy;");

            String sql = "Select mobil from medarbejder where navn = ?";// preparedStatement
            PreparedStatement prestmt = minConnection.prepareStatement(sql);
            prestmt.clearParameters();

            prestmt.setString(1,navn);
            ResultSet res = prestmt.executeQuery();

            while (res.next()){
                System.out.println("Mobil nr." + res.getString(1));
            }

            if (prestmt != null)
                prestmt.close();
            if (minConnection != null)
                minConnection.close();


        } catch (SQLException | IOException sqE) {
            System.out.println("fejl:  " + sqE.getMessage());
        }
    }

}
