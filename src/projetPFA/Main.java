package projetPFA;

public class Main {

	public static void main(String[] args) {
			
		User u=new User("chokri","admin","aaaaa@bbb.tn");
		System.out.println(u.username+" "+u.password+" "+""+u.email);
		
		Admin a=new Admin("aaa","tk","aaaaa@pi.tn");
		System.out.println(a.username+" "+a.password+" "+""+a.email);
	}

}
