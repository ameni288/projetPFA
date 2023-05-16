package projetPFA;
import java.sql.*;

public class Main {
	
	public static String[] tabLogin = new String[20];
	public static String[] tabPass = new String[20];
	public static String[] tabRole = new String[20];
	public static int n=0;
	public static Authentification[] auth = new Authentification[100];
	
	public static void main(String[] args) {
		int i=0;
		
		Login l =new Login();
		
		//auth[0]=new Authentification("choko","1234","admin");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/scolarite","root","");
			Statement st =con.createStatement();
			ResultSet res = st.executeQuery("select * from loginadmin");
		
		
			while(res.next()) {
				auth[i]=new Authentification(res.getString(1) , res.getString(2),"admin");
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
			ResultSet res = st.executeQuery("select * from professeur");
		
		
			while(res.next()) {
				auth[i]=new Authentification(res.getString(4) , res.getString(5),"professeur");
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
			ResultSet res = st.executeQuery("select * from agent");
		
		
			while(res.next()) {
				auth[i]=new Authentification(res.getString(4) , res.getString(5),"agent");
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
				auth[i]=new Authentification(res.getString(5) , res.getString(6),"agent");
				i++;
				n++;
			}
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}
		
		
		for (int j=0;j<auth.length;j++) {
			System.out.println(auth[j].login);
			
		}
	}

}
