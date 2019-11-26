package Admin_Teachers;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.im.InputContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import ConnectionDetails.InstituteConnection;
import tableDrawFromQuery.DrawJDBCTable;
import javax.swing.JCheckBox;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Admin_editTeacher_View 
{

	public JFrame frame;
	private JTextField tfTeacherID;
	String inputTeacherDesignation,inputTeacherID;
	private JTextField textFieldShowResponse;
	private JButton btnGoBack;
	Teacher teacherObj = new Teacher();
	
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public Admin_editTeacher_View() throws Exception 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() throws Exception 
	{
		System.out.println("init called- edit tcr view  ");
		frame = new JFrame();
		frame.setVisible(true);
		
		frame.getContentPane().setBackground(new Color(0, 0, 51));
		frame.setBounds(100, 100, 726, 577);
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		/////// ***** ///////
		JTextArea txtrEnterTeacherId = new JTextArea();
		txtrEnterTeacherId.setFont(new Font("Monospaced", Font.PLAIN, 16));
		txtrEnterTeacherId.setForeground(new Color(51, 204, 255));
		txtrEnterTeacherId.setBackground(new Color(51, 0, 51));
		txtrEnterTeacherId.setText("Enter Teacher ID");
		txtrEnterTeacherId.setBounds(37, 82, 198, 28);
		frame.getContentPane().add(txtrEnterTeacherId);
		
		tfTeacherID = new JTextField();
	
		tfTeacherID.setBounds(446, 80, 144, 28);
		frame.getContentPane().add(tfTeacherID);
		tfTeacherID.setColumns(10);
		
		
		
	/////// ***** ///////	
		JTextArea txtrEnterTeacherNewDesig = new JTextArea();
		txtrEnterTeacherNewDesig.setBackground(new Color(51, 0, 51));
		txtrEnterTeacherNewDesig.setForeground(new Color(51, 204, 255));
		txtrEnterTeacherNewDesig.setFont(new Font("Monospaced", Font.PLAIN, 16));
		txtrEnterTeacherNewDesig.setText("Select Teacher New Designation");
		txtrEnterTeacherNewDesig.setBounds(38, 146, 305, 28);
		frame.getContentPane().add(txtrEnterTeacherNewDesig);
		
		//Integer[] semesterOptions={2,3,4,5,6,7,8};
		String[]semesterOptions =  {"2", "3", "4", "5", "6", "7", "8"};
		JComboBox comboBox = new JComboBox(semesterOptions);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox.setMaximumRowCount(4);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Assistant Professor", "Associate Professor", "Professor"}));
		//comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"2", "3", "4", "5", "6", "7", "8"}));
		comboBox.setBackground(new Color(128, 128, 128));
		comboBox.setToolTipText("Select a semester\r\n");
		comboBox.setEditable(true);
		comboBox.setBounds(446, 147, 144, 28);
		/*comboBox.addItemListener
		(
				new ItemListener() 
				{			
					@Override
					public void itemStateChanged(ItemEvent arg0) 
					{
					 // TeacherFromInput.Teacher_Semester = (int) comboBox.getSelectedItem();
						String ax = (String) ( comboBox.getSelectedItem() );
						inputStdSem = Integer.parseInt(ax);
					}
				}
		);*/
		comboBox.addActionListener(new ActionListener() 
		{
		      public void actionPerformed(ActionEvent e) 
		      {
		        //System.out.println("Selected index=" + comboBox.getSelectedIndex()
		        //    + " Selected item=" + comboBox.getSelectedItem());
		       inputTeacherDesignation =  (String) ( comboBox.getSelectedItem() );
	
		      }
		    });
		
		frame.getContentPane().add(comboBox);
		
		textFieldShowResponse = new JTextField();
		textFieldShowResponse.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldShowResponse.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldShowResponse.setForeground(Color.BLUE);
		textFieldShowResponse.setEnabled(false);
		textFieldShowResponse.setBounds(260, 391, 194, 34);
		frame.getContentPane().add(textFieldShowResponse);
		textFieldShowResponse.setColumns(10);
		
		
		JButton btnEditTeacher = new JButton("Edit this teacher");
		btnEditTeacher.setHorizontalAlignment(SwingConstants.LEFT);
		btnEditTeacher.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{			
				try 
				{		
					//Teacher TeacherFromInput = new Teacher(inputStdID,inputStdName,inputStdCntct,inputStdCG,inputStdSem	,inputStdBatch,inputStdCredit);			
					teacherObj.setTeacherID(tfTeacherID.getText());
				
					//teacherObj.teacher_Designation = inputTeacherDesignation;
				//	System.out.println("  Teachers new post   is : "+ teacherObj.teacher_Designation);
					
					new Admin_editTeacher_Controller( teacherObj,inputTeacherDesignation);
					textFieldShowResponse.setEnabled(false);
					textFieldShowResponse.setText("successfully updated");
					
				} catch (Exception e1) 
				{	
					e1.printStackTrace();
				}
			}
		});
		
		btnGoBack = new JButton("Go back ");
		btnGoBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
			}
		});
		btnGoBack.setIcon(new ImageIcon(Admin_editTeacher_View.class.getResource("/images/icons/back-icon tiny.png")));
		btnGoBack.setHorizontalAlignment(SwingConstants.LEFT);
		btnGoBack.setBackground(Color.MAGENTA);
		btnGoBack.setToolTipText("Go back to previous page");
		btnGoBack.setBounds(80, 447, 143, 67);
		frame.getContentPane().add(btnGoBack);
		btnEditTeacher.setIcon(new ImageIcon(Admin_editTeacher_View.class.getResource("/images/icons/user_edit.png")));
		btnEditTeacher.setBounds(260, 294, 194, 78);
		frame.getContentPane().add(btnEditTeacher);
		
		
		
		
		JButton btnUpdateAnother = new JButton("update another");
		btnUpdateAnother.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUpdateAnother.setHorizontalAlignment(SwingConstants.LEFT);
		btnUpdateAnother.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				System.out.println("you clicked add new std");
				frame.setVisible(false);
				//new Admin_addTeacher_View();
				try {
					initialize();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnUpdateAnother.setIcon(new ImageIcon(Admin_editTeacher_View.class.getResource("/images/icons/Add-male-user tiny.png")));
		btnUpdateAnother.setBackground(Color.GREEN);
		btnUpdateAnother.setToolTipText("update a new Teacher");
		btnUpdateAnother.setBounds(464, 449, 183, 67);
		frame.getContentPane().add(btnUpdateAnother);
		
		JButton btnShowTeacherDatabase = new JButton("Show Teacher DB");
		btnShowTeacherDatabase.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnShowTeacherDatabase.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				try {
					new DrawJDBCTable("Teacher");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnShowTeacherDatabase.setBackground(Color.BLACK);
		btnShowTeacherDatabase.setIcon(new ImageIcon(Admin_editTeacher_View.class.getResource("/images/icons/used/sky blue db.jpg")));
		btnShowTeacherDatabase.setBounds(238, 447, 216, 67);
		frame.getContentPane().add(btnShowTeacherDatabase);
		
		
		
	}
}
