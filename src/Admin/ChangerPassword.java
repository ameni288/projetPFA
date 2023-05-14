package Admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import projetPFA.Login;


public class ChangerPassword extends JFrame {
	private JTextField txtEntrerVotreMot;
	private JTextField textField;
	private JTextField textField_1;

	public ChangerPassword() {
		getContentPane().setForeground(new Color(192, 192, 192));
	this.setTitle("Gestion de Scolarite PI");
	setResizable(false);
	this.setSize(1300,800);
	this.setLocationRelativeTo(null);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	getContentPane().setLayout(null);
	
	JPanel panel = new JPanel();
	panel.setLocation(0, 0);
	panel.setSize(new Dimension(1286, 50));
	panel.setPreferredSize(new Dimension(300, 50));
	panel.setForeground(new Color(64, 0, 128));
	panel.setToolTipText("test");
	panel.setBackground(new Color(227, 0, 0));
	getContentPane().add(panel);
	panel.setLayout(null);
	
	JLabel lblNewLabel_2 = new JLabel("Modification du mot de passe");
	lblNewLabel_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 25));
	lblNewLabel_2.setForeground(new Color(255, 255, 255));
	lblNewLabel_2.setBounds(465, 10, 355, 30);
	panel.add(lblNewLabel_2);
	
	JLabel lblNewLabel_1 = new JLabel("Ancient Password:");
	lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
	lblNewLabel_1.setBounds(363, 160, 187, 34);
	getContentPane().add(lblNewLabel_1);
	
	txtEntrerVotreMot = new JTextField("");
	txtEntrerVotreMot.setBorder(new LineBorder(Color.DARK_GRAY));
	txtEntrerVotreMot.setForeground(new Color(0, 0, 0));
	txtEntrerVotreMot.setFont(new Font("Sitka Display", Font.PLAIN, 17));
	txtEntrerVotreMot.setColumns(10);
	txtEntrerVotreMot.setBounds(444, 203, 351, 28);
	getContentPane().add(txtEntrerVotreMot);
	
	JButton btnNewButton = new JButton("Modifier");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			AcceuilAdmin l =new AcceuilAdmin();
			l.setVisible(true);
			dispose(); //setVisible(false);
		}
	});
	btnNewButton.setBorder(new LineBorder(new Color(128, 128, 128)));
	btnNewButton.setBackground(new Color(128, 128, 128));
	btnNewButton.setBounds(818, 577, 148, 47);
	getContentPane().add(btnNewButton);
	
	textField = new JTextField("");
	textField.setForeground(Color.BLACK);
	textField.setFont(new Font("Sitka Display", Font.PLAIN, 17));
	textField.setColumns(10);
	textField.setBorder(new LineBorder(Color.DARK_GRAY));
	textField.setBounds(445, 302, 350, 28);
	getContentPane().add(textField);
	
	textField_1 = new JTextField("");
	textField_1.setForeground(Color.BLACK);
	textField_1.setFont(new Font("Sitka Display", Font.PLAIN, 17));
	textField_1.setColumns(10);
	textField_1.setBorder(new LineBorder(Color.DARK_GRAY));
	textField_1.setBounds(447, 409, 348, 28);
	getContentPane().add(textField_1);
	
	JLabel newPass = new JLabel("New Password:");
	newPass.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
	newPass.setBounds(367, 254, 171, 34);
	getContentPane().add(newPass);
	
	JLabel confirmPasss = new JLabel("Confirm Password:");
	confirmPasss.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
	confirmPasss.setBounds(369, 356, 171, 34);
	getContentPane().add(confirmPasss);
	
	JButton btnAnnuler = new JButton("Annuler");
	btnAnnuler.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			AcceuilAdmin l =new AcceuilAdmin();
			l.setVisible(true);
			dispose(); //setVisible(false);
		}
	});
	btnAnnuler.setBorder(new LineBorder(new Color(128, 128, 128)));
	btnAnnuler.setBackground(Color.GRAY);
	btnAnnuler.setBounds(340, 582, 148, 49);
	getContentPane().add(btnAnnuler);
	this.setVisible(true);
	
}
}
