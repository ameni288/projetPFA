package Agent;

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

public class AcceuilAgent extends JFrame {
	private JPanel contentPane;
	
	public AcceuilAgent() {
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
		txtpnWelcomeAdmin.setText("Bienvenue Agent");
		txtpnWelcomeAdmin.setBounds(457, 7, 372, 40);
		panel.add(txtpnWelcomeAdmin);
		
		JButton consultAgentBtn = new JButton("Consulter Agent de Scolarité");
		consultAgentBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
			}
		});
		consultAgentBtn.setBorder(new LineBorder(new Color(128, 128, 128)));
		consultAgentBtn.setBackground(new Color(128, 128, 128));
		consultAgentBtn.setBounds(157, 307, 232, 78);
		getContentPane().add(consultAgentBtn);
		
		JButton consultEtdBtn = new JButton("Consulter Etudiant");
		consultEtdBtn.setPreferredSize(new Dimension(161, 21));
		consultEtdBtn.setBorder(new LineBorder(new Color(128, 128, 128)));
		consultEtdBtn.setBackground(new Color(128, 128, 128));
		consultEtdBtn.setBounds(543, 307, 223, 68);
		getContentPane().add(consultEtdBtn);
		
		consultEtdBtn.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			
    		}
    	});
		
		
		JButton consultProfBtn = new JButton("Consulter Professeur");
		consultProfBtn.setPreferredSize(new Dimension(161, 21));
		consultProfBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	
		consultProfBtn.setBorder(new LineBorder(new Color(128, 128, 128)));
		consultProfBtn.setBackground(new Color(128, 128, 128));
		consultProfBtn.setBounds(920, 307, 212, 66);
		getContentPane().add(consultProfBtn);
		

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Settings");
        JMenuItem changerItem = new JMenuItem("Changer mot de passe");
        changerItem.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			
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
