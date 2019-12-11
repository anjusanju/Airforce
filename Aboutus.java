package airforce1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JEditorPane;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;

public class Aboutus extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aboutus frame = new Aboutus();
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
	public Aboutus() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMISSION = new JLabel("MISSION");
		lblMISSION.setBackground(new Color(32, 178, 170));
		lblMISSION.setForeground(new Color(0, 0, 205));
		lblMISSION.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblMISSION.setBounds(10, 11, 138, 33);
		contentPane.add(lblMISSION);
		
		JLabel lblTouchTheSky = new JLabel("TOUCH THE SKY WITH GLORY");
		lblTouchTheSky.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblTouchTheSky.setBounds(10, 78, 424, 99);
		contentPane.add(lblTouchTheSky);
		
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
