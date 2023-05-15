package projetPFA;
import java.sql.*;

public class Main {
	
	public static String[] tabLogin = new String[20];
	public static String[] tabPass = new String[20];
	public static String[] tabRole = new String[20];
	
	public static int n=0;
	
	public static void main(String[] args) {
		
		Login l =new Login();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/scolarite","root","");
			Statement st =con.createStatement();
			//String query = "INSERT INTO `loginadmin` (`login`, `paswd`) VALUES ('foulen', '4569')";
			//st.executeUpdate(query);
			ResultSet res = st.executeQuery("select * from loginadmin");
			int i=0;
		
			while(res.next()) {
				//System.out.println("Login:" + res.getString(1));
				//System.out.println("Password:" + res.getString(2));
				//System.out.println("Role:" + res.getString(3));
				tabLogin[i] = res.getString(1);
				tabPass[i] = res.getString(2);
				tabRole[i] = res.getString(3);
				i++;
				n++;
			}
			
	
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}
		
	
		
		
		
	}

}
