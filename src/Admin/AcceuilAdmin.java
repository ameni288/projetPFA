package Admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import projetPFA.Login;
import Admin.ConsulteEtudiant;

public class AcceuilAdmin extends JFrame {
	private JPanel contentPane;
	
	public AcceuilAdmin() {
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
		txtpnWelcomeAdmin.setText("Bienvenue Admin");
		txtpnWelcomeAdmin.setBounds(540, 7, 206, 40);
		panel.add(txtpnWelcomeAdmin);
		
		JButton consultEtdBtn = new JButton("Consulter Etudiant");
		consultEtdBtn.setPreferredSize(new Dimension(161, 21));
		consultEtdBtn.setBorder(new LineBorder(new Color(128, 128, 128)));
		consultEtdBtn.setBackground(new Color(128, 128, 128));
		consultEtdBtn.setBounds(577, 306, 223, 68);
		getContentPane().add(consultEtdBtn);
		
		consultEtdBtn.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			ConsulteEtudiant l =new ConsulteEtudiant();
				l.setVisible(true);
				dispose(); //setVisible(false);
    		}
    	});
		
		
		JButton consultProfBtn = new JButton("Consulter Professeur");
		consultProfBtn.setPreferredSize(new Dimension(161, 21));
		consultProfBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsulteProf l =new ConsulteProf();
				l.setVisible(true);
				dispose(); //setVisible(false);
			}
		});
	
		consultProfBtn.setBorder(new LineBorder(new Color(128, 128, 128)));
		consultProfBtn.setBackground(new Color(128, 128, 128));
		consultProfBtn.setBounds(920, 307, 212, 66);
		getContentPane().add(consultProfBtn);
		
		JButton consultEtdBtn_1 = new JButton("Consulter Groupe");
		consultEtdBtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsulterGroupe l =new ConsulterGroupe();
				l.setVisible(true);
				dispose(); //setVisible(false);
			}
		});
		consultEtdBtn_1.setPreferredSize(new Dimension(161, 21));
		consultEtdBtn_1.setBorder(new LineBorder(new Color(128, 128, 128)));
		consultEtdBtn_1.setBackground(Color.GRAY);
		consultEtdBtn_1.setBounds(246, 306, 223, 68);
		getContentPane().add(consultEtdBtn_1);
		
		JButton consultEtdBtn_2 = new JButton("Consulter Matiere");
		consultEtdBtn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsulterMatiere l =new ConsulterMatiere();
				l.setVisible(true);
				dispose(); //setVisible(false);
			}
		});
		consultEtdBtn_2.setPreferredSize(new Dimension(161, 21));
		consultEtdBtn_2.setBorder(new LineBorder(new Color(128, 128, 128)));
		consultEtdBtn_2.setBackground(Color.GRAY);
		consultEtdBtn_2.setBounds(546, 189, 223, 68);
		getContentPane().add(consultEtdBtn_2);
		

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Settings");
        JMenuItem changerItem = new JMenuItem("Changer mot de passe");
        changerItem.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			ChangerPassword l =new ChangerPassword();
				l.setVisible(true);
				dispose(); //setVisible(false);
    		}
    	});
        JMenuItem logoutItem = new JMenuItem("Déconnexion");
        logoutItem.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			Login l =new Login();
				l.setVisible(true);
				dispose(); //setVisible(false);
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
