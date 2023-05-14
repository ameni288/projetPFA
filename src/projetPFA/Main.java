package projetPFA;
import java.sql.*;
public class Main {

	public static void main(String[] args) {
			
		User u=new User("chokri","admin","aaaaa@bbb.tn");
		System.out.println(u.username+" "+u.password+" "+""+u.email);
		
		Admin a=new Admin("aaa","tk","aaaaa@pi.tn");
		System.out.println(a.username+" "+a.password+" "+""+a.email);

		Etudiant e1 = new Etudiant("abc","abc","abc@pi.tn"); 
		System.out.println(e1.username+" "+e1.password+" "+""+e1.email);
		
		
		Login l =new Login();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://192.168.188.143/login");
			Statement st =con.createStatement();
			ResultSet res = st.executeQuery("select * from loginadmin");
			
			while(res.next()) {
				System.out.println("Login:" + res.getString(1));
			}
			
			
			
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}
		
		

	}

}
