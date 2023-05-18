package projetPFA;
import java.sql.*;

public class Main {
	
	
	public static int n=0;
	public static Authentification[] auth = new Authentification[100];
	
	public static void GetAuth()
	{
		int i=0;
		n=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/scolarite","root","");
			Statement st =con.createStatement();
			ResultSet res = st.executeQuery("select * from loginadmin");
		
		
			while(res.next()) {
				auth[i]=new Authentification(res.getString(1),res.getString(2) , res.getString(3),"admin");
				i++;
				n++;
			}
		}catch(Exception e) {
			//System.out.print(e.getMessage());
		}
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/scolarite","root","");
			Statement st =con.createStatement();
			ResultSet res = st.executeQuery("select * from professeur");
		
		
			while(res.next()) {
				auth[i]=new Authentification(res.getString(1),res.getString(4) , res.getString(5),"professeur");
				i++;
				n++;
			}
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}
		

		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/scolarite","root","");
			Statement st =con.createStatement();
			ResultSet res = st.executeQuery("select * from etudiant");
		
		
			while(res.next()) {
				auth[i]=new Authentification(res.getString(1),res.getString(5) , res.getString(6),"etudiant");
				i++;
				n++;
			}
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}
		
		
	}
	
	public static void main(String[] args) {
		
		
		Login l =new Login();
		
		GetAuth();
		

	}

}
