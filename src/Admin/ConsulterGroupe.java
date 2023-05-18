package Admin;

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
import javax.swing.JTable;
import javax.swing.JTextField;

public class ConsulterGroupe extends JFrame {
	private JPanel contentPane;
	private JTable table;
    public static String[][] tabGroupe= new String[100][2];
	public static int n_groupe=0;
	public static String varId="";
	
	public static void getGroupes() {
		n_groupe=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/scolarite","root","");
			Statement st =con.createStatement();
			ResultSet resEtud = st.executeQuery("select * from groupe");

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
	
	public static void DeleteGroupe(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/scolarite","root","");
			Statement st =con.createStatement();
			String query = "DELETE FROM groupe WHERE IDGroupe = "+varId;
			st.executeUpdate(query);
			for (int i = 0; i < tabGroupe.length; i++) {
			    for (int j = 0; j < 2; j++) {
			    	tabGroupe[i][j] = null;
			    }
			}
			getGroupes();
			
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}	
	public ConsulterGroupe() {
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
		
		JButton consultAgentBtn = new JButton("HOME");
		consultAgentBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AcceuilAdmin l =new AcceuilAdmin();
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
	                String VIDGROUPE = table.getValueAt(selectedRow, 0).toString();
	                String VNOM = table.getValueAt(selectedRow, 1).toString();
	                
	                int selectedRowIndex = table.getSelectedRow();
	             
	                try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost/scolarite","root","");
						Statement st =con.createStatement();
						if(selectedRowIndex >= n_groupe) {
							   String query = "INSERT INTO groupe(IDGroupe, NOM) VALUES ('"+VIDGROUPE+"', '"+VNOM+"')";
								st.executeUpdate(query);
								for (int i = 0; i < tabGroupe.length; i++) {
								    for (int j = 0; j < 2; j++) {
								    	tabGroupe[i][j] = null;
								    }
								}
								getGroupes();
								table.revalidate();
				                table.repaint();
						}else {
							//	DeleteGroupe();
							//   String query = "INSERT INTO groupe(IDGroupe, NOM) VALUES ('"+VIDGROUPE+"', '"+VNOM+"')";
							String query ="UPDATE `groupe` SET `IDGroupe`='"+VIDGROUPE+"',`NOM`='"+VNOM+"' WHERE `IDGroupe`='"+varId+"'";

								st.executeUpdate(query);
								for (int i = 0; i < tabGroupe.length; i++) {
								    for (int j = 0; j < 2; j++) {
								    	tabGroupe[i][j] = null; 
								    }
								}
								getGroupes();
							table.revalidate();
				            table.repaint();
						}
		             
						
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
	            }
				
			}
		});
	
		applyBtn.setBorder(new LineBorder(new Color(128, 128, 128)));
		applyBtn.setBackground(new Color(128, 128, 128));	
		applyBtn.setBounds(878, 505, 212, 66);
		getContentPane().add(applyBtn);
		
		getGroupes();
		
		String[] columnNames = { "ID Groupe", "Nom Groupe" };
		
		table = new JTable(tabGroupe,columnNames);
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
		                Object value = table.getValueAt(selectedRow, 0);
		                varId=(String) value;
		                System.out.print(varId);
		                
		            }
		        }
		    }
		  
		});
        
		JButton deletedBtn = new JButton("Delete");
		deletedBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteGroupe();
				table.revalidate();
	            table.repaint();
			}
		});
		deletedBtn.setPreferredSize(new Dimension(161, 21));
		deletedBtn.setBorder(new LineBorder(new Color(128, 128, 128)));
		deletedBtn.setBackground(new Color(128, 128, 128));
		deletedBtn.setBounds(501, 505, 223, 68);
		getContentPane().add(deletedBtn);
		
	  
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

