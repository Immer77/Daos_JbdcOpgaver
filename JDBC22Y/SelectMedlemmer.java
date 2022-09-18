package JDBC22Y;

import java.sql.*;

public class SelectMedlemmer {
	
	public static void main(String[] args) {

		try {
			Connection minConnection;
			minConnection = DriverManager
					.getConnection("jdbc:sqlserver://DESKTOP-C9CSAU4\\SQLExpress;databaseName=KlubEks;user=sa;password=Rbh66tvy;");

			Statement stmt = minConnection.createStatement();

			ResultSet res = stmt.executeQuery("select * from Medlem");
			while (res.next()) {
				System.out.println(res.getString(1)+ "\t"  + res.getString(2) + " \t "  +res.getString(3) );
			}

			if (res != null)
				res.close();
			if (stmt != null)
				stmt.close();
			if (minConnection != null)
				minConnection.close();
		} catch (Exception e) {
			System.out.println("fejl:  " + e.getMessage());
		}
	}
}
