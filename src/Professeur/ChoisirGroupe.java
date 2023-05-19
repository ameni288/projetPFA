package Professeur;


import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import projetPFA.Login;
import projetPFA.Main;

import javax.swing.JTable;
import javax.swing.JTextField;

public class ChoisirGroupe extends JFrame {
	private JPanel contentPane;
	private JTable table;
    public static String[][] tabGroupe= new String[100][2];
	public static int n_groupe=0;
	public static String varId="";
	public static String GroupChoisi="";
	
	public static void getGroupes() {
		n_groupe=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/scolarite","root","");
			Statement st =con.createStatement();
			ResultSet resEtud = st.executeQuery("SELECT PG.IDGROUPE,groupe.NOM FROM `prof_group` PG join groupe on PG.IDGROUPE=groupe.IDGROUPE WHERE PG.IDPROF=" +Main.auth[Login.index].id);

			int j=0;
		
			while(resEtud.next()) {
				tabGroupe[j][0] = resEtud.getString(1);
				tabGroupe[j][1] = resEtud.getString(2);
				
				j++;
				n_groupe++;
			}
			
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}
	}
	
	
	public ChoisirGroupe() {
		getContentPane().setForeground(new Color(192, 192, 192));
		this.setTitle("Gestion de Scolarite PI");
		setResizable(false);
		this.setSize(1300,800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLocation(0, 0);
		panel.setSize(new Dimension(1286, 57));
		panel.setPreferredSize(new Dimension(300, 50));
		panel.setForeground(new Color(64, 0, 128));
		panel.setToolTipText("test");
		panel.setBackground(new Color(227, 0, 0));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JTextPane txtpnWelcomeAdmin = new JTextPane();
		txtpnWelcomeAdmin.setForeground(new Color(255, 255, 255));
		txtpnWelcomeAdmin.setBackground(new Color(227, 0, 0));
		txtpnWelcomeAdmin.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 24));
		txtpnWelcomeAdmin.setText("Liste des Groupes");
		txtpnWelcomeAdmin.setBounds(499, 7, 288, 40);
		panel.add(txtpnWelcomeAdmin);
		
		getGroupes();
		
		for (int i = 0; i < n_groupe; i++) {
		    JButton consultAgentBtn1 = new JButton(tabGroupe[i][1]); 
		    consultAgentBtn1.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		           //System.out.println(e.getActionCommand());
		           GroupChoisi=e.getActionCommand();
		           GererNote l =new  GererNote();
					l.setVisible(true);
					dispose();
		          
		        }
		    });
		    consultAgentBtn1.setBorder(new LineBorder(new Color(128, 128, 128)));
		    consultAgentBtn1.setBackground(Color.GRAY);
		    consultAgentBtn1.setBounds(115, 100 + (i * 60) , 232, 48); 
		    getContentPane().add(consultAgentBtn1);
		}
		
		JButton consultAgentBtn = new JButton("HOME");
		consultAgentBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AcceuilProfesseur l =new AcceuilProfesseur();
				l.setVisible(true);
				dispose();
			}
		});
		consultAgentBtn.setBorder(new LineBorder(new Color(128, 128, 128)));
		consultAgentBtn.setBackground(new Color(128, 128, 128));
		consultAgentBtn.setBounds(115, 505, 232, 78);
		getContentPane().add(consultAgentBtn);
	
    
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Settings");
        JMenuItem changerItem = new JMenuItem("Changer mot de passe");
        changerItem.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			ChangerPassword l =new ChangerPassword();
				l.setVisible(true);
				dispose(); 
    		}
    	});
        JMenuItem logoutItem = new JMenuItem("Déconnexion");
        logoutItem.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			Login l =new Login();
				l.setVisible(true);
				dispose(); 
    		}
    	});
        fileMenu.add(changerItem);
        fileMenu.addSeparator();
        fileMenu.add(logoutItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
        setVisible(true);
		
	}
}

