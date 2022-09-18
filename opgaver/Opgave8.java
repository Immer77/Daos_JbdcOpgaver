package opgaver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class Opgave8 {

    public static void main(String[] args) {

        try {
            System.out.println("Opret Medlem ");
            BufferedReader inLine = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Indtast Char: ");
            String testChar = inLine.readLine();
            System.out.print("Indtast Varchar: ");
            String testVarchar = inLine.readLine();
            System.out.println("Indtast int");
            String testint = inLine.readLine();
            System.out.println("Intast Decimal: ");
            String testdecimal = inLine.readLine();
            System.out.println("Indtast Date ");
            String testDate = inLine.readLine();
            System.out.println("Indtast bit");
            String testbit = inLine.readLine();

            Connection minConnection;
            minConnection = DriverManager.getConnection(
                    "jdbc:sqlserver://DESKTOP-C9CSAU4\\SQLExpress;databaseName=Tidsregistrering_SH;user=sa;password=Rbh66tvy;");

            String sql = "insert into Tidsregistrering values(?,?,?,?,?,?) ";// preparedStatement
            PreparedStatement prestmt = minConnection.prepareStatement(sql);
            prestmt.clearParameters();

            prestmt.setString(1, testChar);
            prestmt.setString(2, testVarchar);
            prestmt.setInt(3, Integer.parseInt(testint));
            prestmt.setDouble(4,Double.parseDouble(testdecimal));
            prestmt.setString(5, testDate);
            if(Integer.parseInt(testbit) > 1){
                prestmt.setString(6,null);
            }else{
                prestmt.setInt(6,Integer.parseInt(testbit));
            }


            prestmt.executeQuery();
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
