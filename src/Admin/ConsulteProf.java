package Admin;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ConsulteProf extends JFrame {

	private JPanel contentPane;

	
	public ConsulteProf() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		 JFrame frame = new JFrame("JTable Example");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        // Sample column names
	        String[] columnNames = {"Name", "Age", "City", "Country"};

	        // Sample data
	        Object[][] data = {
	                {"John Doe", "30", "New York", "USA"},
	                {"Jane Smith", "25", "London", "UK"},
	                {"Robert Johnson", "40", "Sydney", "Australia"},
	                {"Maria Rodriguez", "35", "Madrid", "Spain"},
	                {"Mohamed Ahmed", "28", "Cairo", "Egypt"},
	                {"Anna Kim", "32", "Seoul", "South Korea"},
	                {"Luis Garcia", "37", "Mexico City", "Mexico"},
	        };

	        // Create the table model with data and column names
	        DefaultTableModel model = new DefaultTableModel(data, columnNames);

	        // Create the table using the table model
	        JTable table = new JTable(model);

	        // Create a scroll pane and add the table to it
	        JScrollPane scrollPane = new JScrollPane(table);

	        // Add the scroll pane to the frame
	        frame.getContentPane().add(scrollPane);

	        frame.pack();
	        frame.setVisible(true);
	}

}
