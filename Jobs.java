package airforce1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Jobs extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jobs frame = new Jobs();
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
	public Jobs() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 812, 331);
			contentPane = new JPanel();
			contentPane.setBackground(new Color(30, 144, 255));
			contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lbljobsearch= new JLabel("JOBS VACANCY");
			lbljobsearch.setBackground(new Color(32, 178, 170));
			lbljobsearch.setForeground(new Color(0, 0, 205));
			lbljobsearch.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
			lbljobsearch.setBounds(10, 11, 241, 33);
			contentPane.add(lbljobsearch);
			
			JLabel lblTouchTheSky = new JLabel("Apply for Air_commander Job \n\r Posted on 25/11/2019 \r\n last date:25/01/2020");
			JLabel lblTouchTheSky_1 = new JLabel("Apply for Air_Marshal Job \n\r Posted on 02/01/2019 \r\n last date:25/03/2019");
			lblTouchTheSky.setFont(new Font("Times New Roman", Font.BOLD, 18));
			lblTouchTheSky.setBounds(10, 78, 757, 23);
			lblTouchTheSky_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
			lblTouchTheSky_1.setBounds(10, 78, 699, 121);
			contentPane.add(lblTouchTheSky);
			contentPane.add(lblTouchTheSky_1);
			
			JButton btnX = new JButton("BACK");
			btnX.setBounds(192, 210, 104, 23);
			btnX.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Home home = new Home();
					home.setVisible(true);
					
					}
			});
				contentPane.add(btnX);
			
			
		
	

	
	
	
	
	}

}
