package FirstPage;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Admin_Events.Admin_addEvent_View;
import Admin_Students.Admin_addStudent_View;
import Admin_Students.Admin_editStudent_View;
import Admin_Students.Admin_removeStudent_View;
import Admin_Teachers.Admin_addTeacher_View;
import tableDrawFromQuery.DrawJDBCTable;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

public class Admin_homepage extends JFrame 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3924446276286472473L;
	private JPanel contentPane;
	private JTextField txtDatabases;
	String tableToShow;
	private final JButton btnAddTeacher = new JButton("  Add Teacher");
	private final JButton btnUpdateTeacher = new JButton("  Update Teacher");
	private final JButton btnDeleteTeacher = new JButton("  Delete Teacher");
	private final JButton btnNewButton_1 = new JButton("");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_homepage frame = new Admin_homepage();
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
	public Admin_homepage() 
	{
		/*comboBoxSeeDatabase.addItemListener
		(
				new ItemListener() 
				{
					public void itemStateChanged(ItemEvent arg0) {
					 // studentFromInput.student_Semester = (int) comboBox.getSelectedItem();
						tableToShow = (String) comboBoxSeeDatabase.getSelectedItem();
					}
				}
		);*/
		initGUI();
	}
	private void initGUI() {
		System.out.println("inside Admin Homepage");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1087, 600);
		
		contentPane = new JPanel() 
		{  
			   /**
			 * 
			 */
			private static final long serialVersionUID = -6926605703025567448L;

			public void paintComponent(Graphics g) 
			   {  
			                      Image img = Toolkit.getDefaultToolkit().getImage(  
			                                Admin_homepage.class.getResource("/images/ah bg1.jpg"));  
		                      g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
			   }  
		};  
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddStudent = new JButton("      Add Student");
		btnAddStudent.setHorizontalAlignment(SwingConstants.LEFT);
		btnAddStudent.setIcon(new ImageIcon(Admin_homepage.class.getResource("/images/icons/Add-male-user small.png")));
		btnAddStudent.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				Admin_addStudent_View window = new Admin_addStudent_View();
				window.frame.setVisible(true);
			}
		});
		btnAddStudent.setForeground(Color.BLACK);
		btnAddStudent.setBackground(Color.WHITE);
		btnAddStudent.setBounds(31, 35, 220, 74);
		contentPane.add(btnAddStudent);
		
		JButton btnUpdateStudent = new JButton("    Update Student");
		btnUpdateStudent.setHorizontalAlignment(SwingConstants.LEFT);
		btnUpdateStudent.setIcon(new ImageIcon(Admin_homepage.class.getResource("/images/icons/Edit-male-user small.png")));
		btnUpdateStudent.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Admin_editStudent_View window = null;
				try {
					window = new Admin_editStudent_View();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				window.frame.setVisible(true);
			}
		});
		btnUpdateStudent.setBounds(31, 160, 220, 74);
		contentPane.add(btnUpdateStudent);
		
		JButton btnDeleteStudent = new JButton("    Delete Student");
		btnDeleteStudent.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
			
				try {
					new Admin_removeStudent_View();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnDeleteStudent.setHorizontalAlignment(SwingConstants.LEFT);
		btnDeleteStudent.setIcon(new ImageIcon(Admin_homepage.class.getResource("/images/icons/Remove-male-user smal.png")));
		btnDeleteStudent.setBounds(31, 292, 220, 74);
		contentPane.add(btnDeleteStudent);
		
		JButton btnAddEvent = new JButton("  Add Event");
		btnAddEvent.setHorizontalAlignment(SwingConstants.LEFT);
		btnAddEvent.setIcon(new ImageIcon(Admin_homepage.class.getResource("/images/icons/add events small.jpg")));
		btnAddEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
			 new Admin_addEvent_View();
			}
		});
		btnAddEvent.setBounds(293, 35, 191, 74);
		contentPane.add(btnAddEvent);
		
		JButton btnDeleteEvent = new JButton("  Delete Event");
		btnDeleteEvent.setIcon(new ImageIcon(Admin_homepage.class.getResource("/images/icons/remove event-small.png")));
		btnDeleteEvent.setHorizontalAlignment(SwingConstants.LEFT);
		btnDeleteEvent.setBounds(293, 292, 191, 74);
		contentPane.add(btnDeleteEvent);
		
		JButton btnUpdateEvent = new JButton("  Update Event");
		btnUpdateEvent.setIcon(new ImageIcon(Admin_homepage.class.getResource("/images/icons/update event small.png")));
		btnUpdateEvent.setHorizontalAlignment(SwingConstants.LEFT);
		btnUpdateEvent.setBounds(293, 160, 191, 74);
		contentPane.add(btnUpdateEvent);
		
		String[] allDb= {"Student", "Course_LIST","Teacher", "Event", "Research"};
		JComboBox comboBoxSeeDatabase = new JComboBox(allDb);
		comboBoxSeeDatabase.setModel(new DefaultComboBoxModel(new String[] {"Student", "Enrolled", "Result", "Course_LIST", "Teacher", "Event", "Research"}));
		comboBoxSeeDatabase.setBackground(Color.GRAY);
		
		comboBoxSeeDatabase.setBounds(917, 103, 144, 34);
		contentPane.add(comboBoxSeeDatabase);
		comboBoxSeeDatabase.addActionListener(new ActionListener() 
		 {
		    /*  public void comboBoxSeeDatabase(ActionEvent e) {
		        System.out.println("Selected index=" + comboBoxSeeDatabase.getSelectedIndex()
		            + " Selected item=" + comboBoxSeeDatabase.getSelectedItem());
		      }*/

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Selected index=" + comboBoxSeeDatabase.getSelectedIndex()
	            + " Selected item=" + comboBoxSeeDatabase.getSelectedItem());
				
			}
		    });
		//	tableToShow = (String) comboBoxSeeDatabase.getSelectedItem();
		//	System.out.println(tableToShow+" was selected.");
			
			txtDatabases = new JTextField();
		txtDatabases.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDatabases.setForeground(Color.YELLOW);
		txtDatabases.setBackground(Color.GRAY);
		txtDatabases.setText("Databases");
		txtDatabases.setBounds(917, 35, 144, 51);
		contentPane.add(txtDatabases);
		txtDatabases.setColumns(10);
		
		JButton btnNewButton = new JButton("    Display");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Object a = comboBoxSeeDatabase.getSelectedItem();
				tableToShow = (String)a;
				System.out.println(tableToShow+" was selected.");
				
				try 
				{
					System.out.println(" trying to display table "+ tableToShow+" from Admin homepage");
					new DrawJDBCTable (tableToShow);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon(Admin_homepage.class.getResource("/images/icons/database tiny.png")));
		btnNewButton.setBounds(917, 265, 144, 63);
		contentPane.add(btnNewButton);
		
		setVisible(true);
		btnAddTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				new Admin_addTeacher_View();
			}
		});
		btnAddTeacher.setIcon(new ImageIcon(Admin_homepage.class.getResource("/images/icons/used/teacher_add.jpg")));
		btnAddTeacher.setHorizontalAlignment(SwingConstants.LEFT);
		btnAddTeacher.setBounds(521, 35, 191, 74);
		
		contentPane.add(btnAddTeacher);
		btnUpdateTeacher.setIcon(new ImageIcon(Admin_homepage.class.getResource("/images/icons/used/teacher_edit.jpg")));
		btnUpdateTeacher.setHorizontalAlignment(SwingConstants.LEFT);
		btnUpdateTeacher.setBounds(521, 160, 191, 74);
		
		contentPane.add(btnUpdateTeacher);
		btnDeleteTeacher.setIcon(new ImageIcon(Admin_homepage.class.getResource("/images/icons/used/teacher_delete.jpg")));
		btnDeleteTeacher.setHorizontalAlignment(SwingConstants.LEFT);
		btnDeleteTeacher.setBounds(521, 292, 191, 74);
		
		contentPane.add(btnDeleteTeacher);
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setIcon(new ImageIcon(Admin_homepage.class.getResource("/images/icons/used/research-icon.png")));
		btnNewButton_1.setBounds(764, 186, 123, 105);
		
		contentPane.add(btnNewButton_1);
	}
}
