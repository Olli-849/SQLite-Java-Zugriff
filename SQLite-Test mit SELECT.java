package jdbc_mit_SQLITE_MYSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteSQLiteMitSelect
{
	public static void main(String[] args)
	{
		try
		{
			Class.forName("org.sqlite.JDBC");
//			Connection c = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\ayank\\OneDrive\\Desktop\\SQLITE\\lirionsDatenbank.geheim");
			Connection c = DriverManager.getConnection("jdbc:sqlite:C:\\Datenkram\\LF08v2\\Übungen\\SQL-Test\\test.db");
			
			Statement kampfkommando = c.createStatement();
			
			ResultSet ergebnis = kampfkommando.executeQuery("select * from kunden;");
			
			//Metainformation
			ResultSetMetaData rsmeta = ergebnis.getMetaData();
			int anzahlcolumns = rsmeta.getColumnCount();
			System.out.println(anzahlcolumns);
			for(int zaehler=1; zaehler<=anzahlcolumns; zaehler++)
			{
				System.out.println(rsmeta.getColumnTypeName(zaehler));
				System.out.println(rsmeta.getColumnClassName(zaehler));
				System.out.println(rsmeta.getColumnName(zaehler));
			}
			while(ergebnis.next())
			{
				System.out.println(ergebnis.getObject(1).toString() 
						+ " -- " + ergebnis.getObject(2).toString() 
						+ " -- " + ergebnis.getObject(3).toString()
						+ " -- " + ergebnis.getObject(4).toString()
						+ " -- " + ergebnis.getObject(5).toString()
						+ " -- " + ergebnis.getObject(6).toString()
						+ " -- " + ergebnis.getObject(7).toString()
						+ " -- " + ergebnis.getObject(8).toString()
						);
			}
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
