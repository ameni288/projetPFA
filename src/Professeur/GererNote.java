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

public class GererNote extends JFrame {
	private JPanel contentPane;
	private JTable table;
    public static String[][] tabEtudiant = new String[100][8];
	public static int n_etd=0;
	public static String varNote="";
	public static String varAbscence="";
	public static String varType="";

	
	public static void getEtudiants() {
		n_etd=0;
		String IDMATIERE="";
		String NOMMATIERE="";
		System.out.print(ChoisirGroupe.GroupChoisi);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/scolarite","root","");
			Statement st =con.createStatement();
			String sql2 = "SELECT matiere.Nom, matiere.IDMATIERE FROM matiere JOIN professeur ON matiere.IDMATIERE = professeur.IDMATIERE WHERE professeur.id ="+Login.index;
			ResultSet resMatiere = st.executeQuery(sql2);
			
			 while (resMatiere.next()) {
			    	NOMMATIERE = resMatiere.getString(1);
			    	IDMATIERE = resMatiere.getString(2);

			      
			    }   
			    
			String query = "SELECT ID, NOM, PRENOM FROM etudiant WHERE IDGROUPE = (SELECT IDGROUPE FROM groupe WHERE NOM LIKE '" + ChoisirGroupe.GroupChoisi + "')";
			ResultSet resEtud = st.executeQuery(query);
			int j=0;
		
			while(resEtud.next()) {
				tabEtudiant[j][0] = resEtud.getString(1);
				tabEtudiant[j][1] = resEtud.getString(2);
				tabEtudiant[j][2] = resEtud.getString(3);
				tabEtudiant[j][3] = NOMMATIERE;
				tabEtudiant[j][4] = IDMATIERE;
				j++;
				n_etd++;
			}
			
		  
			
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}
	}
	
	
	public GererNote() {
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
		txtpnWelcomeAdmin.setText("Liste des Etudiants");
		txtpnWelcomeAdmin.setBounds(499, 7, 288, 40);
		panel.add(txtpnWelcomeAdmin);
		
		JButton consultAgentBtn = new JButton("BACK");
		consultAgentBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChoisirGroupe l =new ChoisirGroupe();
				l.setVisible(true);
				dispose();
			}
		});
		consultAgentBtn.setBorder(new LineBorder(new Color(128, 128, 128)));
		consultAgentBtn.setBackground(new Color(128, 128, 128));
		consultAgentBtn.setBounds(115, 505, 232, 78);
		getContentPane().add(consultAgentBtn);
	
		JButton applyBtn = new JButton("APPLY");
		applyBtn.setPreferredSize(new Dimension(161, 21));
		applyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
	            if (selectedRow != -1) {
	                String VIDETUDIANT = table.getValueAt(selectedRow, 0).toString();
	                String VNOMETD = table.getValueAt(selectedRow, 1).toString();
	                String VPRENOMETD = table.getValueAt(selectedRow, 2).toString();
	                String VNOMMATIERE = table.getValueAt(selectedRow, 3).toString();
	                String VIDMATIERE = table.getValueAt(selectedRow, 4).toString();
	                String VNOTE = table.getValueAt(selectedRow, 5).toString();
	                String VTYPE = table.getValueAt(selectedRow, 6).toString();
	                String VABSCENCE = table.getValueAt(selectedRow, 7).toString();
	              
	            //VNOTE==null && VTYPE==null && VABSCENCE==null
	                System.out.println("ligne selected "+selectedRow+" nbr etd : "+n_etd);
	                System.out.println(VNOTE);
	                try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost/scolarite","root","");
						Statement st =con.createStatement();
						if( varNote==null && varType==null && varAbscence==null) {
							   String query = "INSERT INTO `evaluation`(`IDETUDIANT`, `IDPROF`, `IDMATIERE`, `NOTE`, `TYPE`, `ABSCENCE`) VALUES ('"+VIDETUDIANT+"', '"+Login.index+"', '"+VIDMATIERE+"', '"+VNOTE+"', '"+VTYPE+"', '"+VABSCENCE+"')";
								st.executeUpdate(query);
								
								for (int i = 0; i < tabEtudiant.length; i++) {
								    for (int j = 0; j < 8; j++) {
								        tabEtudiant[i][j] = null;
								    }
								}
							
								getEtudiants();
								table.revalidate();
				                table.repaint();
						}else {
							
							String query = "UPDATE `evaluation` SET `NOTE`='" + VNOTE + "', `TYPE`='" + VTYPE + "', `ABSCENCE`='" + VABSCENCE + "' WHERE `IDETUDIANT`='" + VIDETUDIANT + "' AND `IDPROF`='" + Login.index + "' AND `IDMATIERE`='" + VIDMATIERE + "'";
							    st.executeUpdate(query);
								for (int i = 0; i < tabEtudiant.length; i++) {
								    for (int j = 0; j < 8; j++) {
								        tabEtudiant[i][j] = null; 
								    }
								}
							getEtudiants();
							table.revalidate();
				            table.repaint();
						}
		         
						
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
						for (int i = 0; i < tabEtudiant.length; i++) {
						    for (int j = 0; j < 8; j++) {
						        tabEtudiant[i][j] = null;
						    }
						}
						getEtudiants();
						table.revalidate();
		                table.repaint();
				
					}
	            }
				
			}
		});
	
		applyBtn.setBorder(new LineBorder(new Color(128, 128, 128)));
		applyBtn.setBackground(new Color(128, 128, 128));
		applyBtn.setBounds(878, 505, 212, 66);
		getContentPane().add(applyBtn);
		
		for (int i = 0; i < tabEtudiant.length; i++) {
		    for (int j = 0; j < 8; j++) {
		        tabEtudiant[i][j] = null; 
		    }
		}
		getEtudiants();
		for(int i=0;i<n_etd;i++) {
			System.out.println(tabEtudiant[i][1]+tabEtudiant[i][2]);
		}
        
		String[] columnNames = { "ID Etudiant", "Nom", "Prenom", "Nom Matière", "ID Matière","Note","Type","Absence" };
		
		table = new JTable(tabEtudiant,columnNames);
		table.setSurrendersFocusOnKeystroke(true);
		table.setBounds(137, 96, 901, 380);
		JScrollPane scrollPane = new JScrollPane(table); 
		scrollPane.setBounds(137, 96, 901, 380);
		getContentPane().add(scrollPane);
		
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    public void valueChanged(ListSelectionEvent e) {
		        if (!e.getValueIsAdjusting()) { 
		            int selectedRow = table.getSelectedRow();
		            if (selectedRow != -1) {
		                Object value = table.getValueAt(selectedRow, 5);
		                varNote=(String) value;
		                Object value2 = table.getValueAt(selectedRow, 6);
		                varType=(String) value2;
		                Object value3 = table.getValueAt(selectedRow, 7);
		                varAbscence=(String) value3;
		              
		            }
		            
		        }
		    }
		  
		});
        
		
	  
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

