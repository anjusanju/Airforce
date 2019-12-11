package airforce1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class HomeScreen_1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	public static HomeScreen_1 home_frame = new HomeScreen_1();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeScreen_1 frame = new HomeScreen_1();
					home_frame.setVisible(true);
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HomeScreen_1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSearchaircraft = new JButton("SearchAircraft");
		btnSearchaircraft.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnSearchaircraft.setBounds(215, 75, 139, 39);
		contentPane.add(btnSearchaircraft);
		btnSearchaircraft.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			new SearchAircraft().setVisible(true);
			HomeScreen.home_frame.setVisible(false);
		}
		});
		
		JButton btnsearchairperson = new JButton("SearchAirperson");
		btnsearchairperson.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnsearchairperson.setBounds(65, 179, 135, 39);
		contentPane.add(btnsearchairperson);
		btnsearchairperson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SearchAirperson().setVisible(true);
				HomeScreen.home_frame.setVisible(false);
			}
			});
		
		JButton btnjob = new JButton("Job Application");
		btnjob.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnjob.setBounds(405, 179, 139, 39);
		contentPane.add(btnjob);
		btnjob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new jobseeker().setVisible(true);
				HomeScreen.home_frame.setVisible(false);
			}
			});
		
		JButton btnNewButton = new JButton("Awards\r\n");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setBounds(231, 259, 123, 39);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new awards().setVisible(true);
				HomeScreen.home_frame.setVisible(false);
			}
			});
		
		
		JLabel lblNewLabel = new JLabel("                                                                                                                                                                                                 ");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\w10\\OneDrive\\Pictures\\af3.jpg"));
		lblNewLabel.setBounds(0, 11, 590, 346);
		contentPane.add(lblNewLabel);
		
		
		
	}
}
