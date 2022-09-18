package opgaver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class Opgave5 {

    public static void main(String[] args) {

        try {
            System.out.println("Opret Medlem ");
            BufferedReader inLine = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Indtast Starttid: ");
            String startTid = inLine.readLine();
            System.out.print("Indtast Sluttid: ");
            String slutTid = inLine.readLine();
            System.out.println("Indtast Beskrivelse");
            String beskrivelse = inLine.readLine();
            System.out.println("Intast Dato: ");
            String dato = inLine.readLine();
            System.out.println("Indtast medarbejderNr: ");
            String medarbejderNr = inLine.readLine();
            System.out.println("Indtast OpgaveNr");
            String opgaveNr = inLine.readLine();

            Connection minConnection;
            minConnection = DriverManager.getConnection(
                    "jdbc:sqlserver://DESKTOP-C9CSAU4\\SQLExpress;databaseName=Tidsregistrering_SH;user=sa;password=Rbh66tvy;");

            String sql = "insert into Tidsregistrering values(?,?,?,?,?,?) ";// preparedStatement
            PreparedStatement prestmt = minConnection.prepareStatement(sql);
            prestmt.clearParameters();

            prestmt.setString(1, startTid);
            prestmt.setString(2, slutTid);
            prestmt.setString(3, beskrivelse);
            prestmt.setString(4,dato);
            prestmt.setInt(5,Integer.parseInt(medarbejderNr));
            prestmt.setInt(6,Integer.parseInt(opgaveNr));

            prestmt.executeUpdate();
            System.out.println("Indsat tidsregistrering");

            if (prestmt != null)
                prestmt.close();
            if (minConnection != null)
                minConnection.close();


        } catch (SQLException | IOException sqE) {
            System.out.println("fejl:  " + sqE.getMessage());
        }
    }

}
