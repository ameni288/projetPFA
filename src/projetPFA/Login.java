package projetPFA;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import Admin.AcceuilAdmin;

public class Login extends JFrame {
	private JTextField txtEnterVotreAdresse;
	private JTextField txtEntrerVotreMot;

	public Login() {
	getContentPane().setForeground(new Color(192, 192, 192));
	this.setTitle("Gestion de Scolarite PI");
	this.setSize(1300,800);
	setResizable(false);
	this.setLocationRelativeTo(null);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	getContentPane().setLayout(null);
	
	JPanel panel = new JPanel();
	panel.setLocation(-2, -2);
	panel.setSize(new Dimension(1288, 50));
	panel.setPreferredSize(new Dimension(300, 50));
	panel.setForeground(new Color(64, 0, 128));
	panel.setToolTipText("test");
	panel.setBackground(new Color(227, 0, 0));
	getContentPane().add(panel);
	panel.setLayout(null);
	
	JLabel lblNewLabel_2 = new JLabel("Authentification");
	lblNewLabel_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 26));
	lblNewLabel_2.setForeground(new Color(255, 255, 255));
	lblNewLabel_2.setBounds(541, 13, 205, 30);
	panel.add(lblNewLabel_2);
	
	JLabel lblNewLabel = new JLabel("Login:");
	lblNewLabel.setForeground(new Color(0, 0, 0));
	lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
	lblNewLabel.setBounds(611, 152, 63, 50);
	getContentPane().add(lblNewLabel);
	
	JLabel lblNewLabel_1 = new JLabel("Password:");
	lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
	lblNewLabel_1.setBounds(594, 289, 97, 34);
	getContentPane().add(lblNewLabel_1);
	
	txtEnterVotreAdresse = new JTextField("Ameni");
	txtEnterVotreAdresse.setBorder(new LineBorder(Color.DARK_GRAY));
	txtEnterVotreAdresse.setForeground(new Color(0, 0, 0));
	txtEnterVotreAdresse.setFont(new Font("Sitka Display", Font.PLAIN, 17));
	txtEnterVotreAdresse.setBounds(448, 215, 389, 28);
	getContentPane().add(txtEnterVotreAdresse);
	txtEnterVotreAdresse.setColumns(10);
	
	txtEntrerVotreMot = new JTextField("1234");
	txtEntrerVotreMot.setBorder(new LineBorder(Color.DARK_GRAY));
	txtEntrerVotreMot.setForeground(new Color(0, 0, 0));
	txtEntrerVotreMot.setFont(new Font("Sitka Display", Font.PLAIN, 17));
	txtEntrerVotreMot.setColumns(10);
	txtEntrerVotreMot.setBounds(451, 340, 384, 28);
	getContentPane().add(txtEntrerVotreMot);
	
	JButton btnNewButton = new JButton("Connexion");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int ath=0;
			for(int i=0;i<Main.n;i++) {
				if(txtEnterVotreAdresse.getText().equals(Main.tabLogin[i]) && txtEntrerVotreMot.getText().equals(Main.tabPass[i]) && Main.tabRole[i].equals("admin")) {
					AcceuilAdmin ac =new AcceuilAdmin();
					ac.setVisible(true);
					dispose(); //setVisible(false);
					ath=1;
					break;
				}
			}
			if(ath==0) {
		        JOptionPane.showMessageDialog(null, "Authentification erronée!","Erreur", JOptionPane.ERROR_MESSAGE);
			}
		}
	});
	btnNewButton.setBorder(new LineBorder(new Color(128, 128, 128)));
	btnNewButton.setBackground(new Color(128, 128, 128));
	btnNewButton.setBounds(734, 455, 98, 31);
	getContentPane().add(btnNewButton);
	
	JButton btnNewButton_1 = new JButton("Annuler");
	btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			txtEntrerVotreMot.setText("");
			txtEnterVotreAdresse.setText("");
		}
	});
	btnNewButton_1.setBorder(new LineBorder(new Color(128, 128, 128)));
	btnNewButton_1.setBackground(new Color(128, 128, 128));
	btnNewButton_1.setBounds(447, 454, 95, 31);
	getContentPane().add(btnNewButton_1);
	this.setVisible(true);
	
}
}
