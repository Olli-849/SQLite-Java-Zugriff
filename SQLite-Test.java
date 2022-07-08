package jdbc_mit_SQLITE_MYSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteSQLite
{

	public static void main(String[] args)
	{
		try
		{
			Class.forName("org.sqlite.JDBC");
			Connection c = DriverManager.getConnection("jdbc:sqlite:C:\\Datenkram\\LF08v2\\Übungen\\SQL-Test\\test.db"); //Pfad hier als Beispiel
			Statement erstellen = c.createStatement();
			
			
			//Das wars...
			erstellen.execute("drop table if exists kunden;");
			erstellen.execute("create table kunden"
					+ "("
					+ "id integer, "
					+ "datum date, "
					+ "name varchar(100), "
					+ "strasse varchar(100), "
					+ "ort varchar(100), "
					+ "artikel varchar(100), "
					+ "anzahl integer, "
					+ "preis varchar(50)"
					+ ");"
					);
			erstellen.execute("insert into kunden values"
					+ "("
					+ "1, "
					+ "\"2018/10/10\" ,"
					+ "\"Max Mustermann\", "
					+ "\"Musterstr. 1\", "
					+ "\"12345 MusterOrt\", "
					+ "\"Bleistift\", "
					+ "5, "
					+ "\"1.00€\""
					+ ");"
					);
			erstellen.execute("insert into kunden values"
					+ "("
					+ "2, "
					+ "\"2018/10/10\" ,"
					+ "\"Max Mustermann\", "
					+ "\"Musterstr. 1\", "
					+ "\"12345 MusterOrt\", "
					+ "\"Papier\", "
					+ "500, "
					+ "\"7.00€\""
					+ ");"
					);
///*
//Auslesen
			ResultSet ergebnis = erstellen.executeQuery("select * from kunden");
			
			while(ergebnis.next()) 
			{
				System.out.println(ergebnis.getObject(1).toString() + " - " 
						+ ergebnis.getObject(2).toString() + " - " 
						+ ergebnis.getObject(3).toString() + " - " 
						+ ergebnis.getObject(4).toString() + " - " 
						+ ergebnis.getObject(5).toString() + " - " 
						+ ergebnis.getObject(6).toString() + " - " 
						+ ergebnis.getObject(7).toString() + " - " 
						+ ergebnis.getObject(8).toString());
			}
//*/
		} 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		} 
	}
}
