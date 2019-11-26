package FirstPage;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Public_Home_Page.SearchStudents_view;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Public_homePage_View extends JFrame 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6898462655358267295L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Public_homePage_View frame = new Public_homePage_View();
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
	public Public_homePage_View() 
	{
		setVisible(true);
		System.out.println("inside PHV");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 845, 520);
		
		contentPane = new JPanel() 
		{  
			   /**
			 * 
			 */
			private static final long serialVersionUID = -3304459803515235955L;

			public void paintComponent(Graphics g) 
			   {  
			                      Image img = Toolkit.getDefaultToolkit().getImage(  
			                                Public_homePage_View.class.getResource("/images/phv bg.jpg"));  
		                      g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
			   }  
		};  
		contentPane.setBackground(new Color(51, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnStudents = new JButton("Students");
		btnStudents.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				setVisible(false);
				new SearchStudents_view();
			}
		});
		btnStudents.setForeground(Color.BLACK);
		btnStudents.setBackground(Color.WHITE);
		btnStudents.setBounds(61, 31, 109, 23);
		contentPane.add(btnStudents);
		
		JButton btnTeachers = new JButton("Teachers");
		btnTeachers.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTeachers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTeachers.setBounds(61, 109, 109, 23);
		contentPane.add(btnTeachers);
		
		JButton btnCourses = new JButton("Courses");
		btnCourses.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCourses.setBounds(61, 184, 109, 23);
		contentPane.add(btnCourses);
		
		JButton btnResearch = new JButton("Research");
		btnResearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnResearch.setBounds(61, 262, 109, 23);
		contentPane.add(btnResearch);
		
		JButton btnEvents = new JButton("Events");
		btnEvents.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEvents.setBounds(61, 338, 109, 23);
		contentPane.add(btnEvents);
		
		
	}
}
