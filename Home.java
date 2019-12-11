package airforce1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.jena.rdfxml.xmlinput.states.Frame;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Home extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home() {
		setTitle("Semantic Search");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 727, 429);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnLOGIN = new JButton("LOGIN");
		btnLOGIN.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnLOGIN.setBounds(263, 129, 89, 23);
		btnLOGIN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String password = textField.getText();
				if(password.contains("india")) {
					textField.setText("india");
			        new HomeScreen_1().setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null,"Invalid Login details" ,"Login Error", JOptionPane.ERROR_MESSAGE);
					textField.setText("");
				}	
			}
		});
		contentPane.setLayout(null);
		btnLOGIN.setForeground(new Color(0, 0, 204));
		btnLOGIN.setBackground(Color.GRAY);
		contentPane.add(btnLOGIN);
		
		JButton btnAboutUs = new JButton("About Us");
		btnAboutUs.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnAboutUs.setBounds(10, 11, 104, 23);
		btnAboutUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Aboutus aboutus = new Aboutus();
				aboutus.setVisible(true);
				
				
			}
		});
		contentPane.add(btnAboutUs);
		
		JButton btnjob = new JButton("Jobs and Carrer");
		btnjob.setBounds(144, 12, 89, 23);
		btnjob.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnjob.setBounds(10, 11, 104, 23);
		btnjob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			   Jobs jobs = new Jobs();
				jobs.setVisible(true);
				
				
			}
		});
		contentPane.add(btnjob);
		
		textField = new JTextField();
		textField.setBounds(126, 130, 127, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("PASSWORD");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(25, 129, 89, 18);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("INDIAN AIR FORCE");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_1.setBounds(102, 60, 233, 40);
		contentPane.add(lblNewLabel_1);
		
		JLabel lbl = new JLabel(" ");
		lbl.setIcon(new ImageIcon("C:\\Users\\w10\\OneDrive\\Pictures\\airforce.jpg"));
		lbl.setBounds(0, 0, 711, 390);
		contentPane.add(lbl);
		
		JButton btnNewButton = new JButton("Jobs and Carrer");
		btnNewButton.setBounds(144, 12, 135, 23);
		contentPane.add(btnNewButton);
	}
}






