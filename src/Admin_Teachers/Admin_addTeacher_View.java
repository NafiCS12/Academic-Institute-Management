package Admin_Teachers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


import tableDrawFromQuery.DrawJDBCTable;

import javax.swing.SwingConstants;
import java.awt.Font;

public class Admin_addTeacher_View 
{

	public JFrame frame;
	private JTextField tfTeacherID;
	private JTextArea txtrEnterStudentName;
	private JTextField tfTeacherName;
	private JTextField tfTeacherContact;
	private JTextField tfTeacherDate;
	
	String a,inputStdID,inputStdName,inputStdCntct,inputJoinDate;
	private JTextField textFieldShowResponse;
	private JButton btnGoBack;
	
	public Admin_addTeacher_View() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		//System.out.println("init called");
		frame = new JFrame();
		frame.setVisible(true);
		
		frame.getContentPane().setBackground(new Color(0, 51, 51));
		frame.setBounds(100, 100, 679, 577);
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		/////// ***** ///////
		JTextArea txtrEnterTeacherId = new JTextArea();
		txtrEnterTeacherId.setFont(new Font("Monospaced", Font.PLAIN, 16));
		txtrEnterTeacherId.setForeground(new Color(51, 204, 255));
		txtrEnterTeacherId.setBackground(new Color(51, 51, 51));
		txtrEnterTeacherId.setText("Enter Teacher ID");
		txtrEnterTeacherId.setBounds(52, 45, 238, 28);
		frame.getContentPane().add(txtrEnterTeacherId);
		
		tfTeacherID = new JTextField();
	
		tfTeacherID.getDocument().addDocumentListener(new DocumentListener() 
		{
			@Override
			public void removeUpdate(DocumentEvent e) {warn(); }
			@Override
			public void insertUpdate(DocumentEvent e) {warn(); }
			@Override
			public void changedUpdate(DocumentEvent e) {warn();}
			public void warn()
			{
				inputStdID  = tfTeacherID.getText();
			}
		});
		
		tfTeacherID.setBounds(314, 45, 254, 28);
		frame.getContentPane().add(tfTeacherID);
		tfTeacherID.setColumns(10);
	
		/////// ***** ///////
		
		txtrEnterStudentName = new JTextArea();
		txtrEnterStudentName.setFont(new Font("Monospaced", Font.PLAIN, 16));
		txtrEnterStudentName.setForeground(new Color(51, 204, 255));
		txtrEnterStudentName.setBackground(new Color(51, 51, 51));
		txtrEnterStudentName.setText("Enter Teacher Name");
		txtrEnterStudentName.setBounds(52, 98, 238, 28);
		frame.getContentPane().add(txtrEnterStudentName);
		
		
		tfTeacherName = new JTextField();
		tfTeacherName.getDocument().addDocumentListener(new DocumentListener() 
		{
			@Override
			public void removeUpdate(DocumentEvent e) {warn(); }
			@Override
			public void insertUpdate(DocumentEvent e) {warn(); }
			@Override
			public void changedUpdate(DocumentEvent e) {warn();}
			public void warn()
			{
				inputStdName  = tfTeacherName.getText();
			}
		});
		
		tfTeacherName.setColumns(10);
		tfTeacherName.setBounds(314, 98, 254, 28);
		frame.getContentPane().add(tfTeacherName);
		
	/////// ***** ///////
		JTextArea txtrEnterStudentContact = new JTextArea();
		txtrEnterStudentContact.setFont(new Font("Monospaced", Font.PLAIN, 16));
		txtrEnterStudentContact.setForeground(new Color(51, 204, 255));
		txtrEnterStudentContact.setBackground(new Color(51, 51, 51));
		txtrEnterStudentContact.setText("Enter  Contact Number");
		txtrEnterStudentContact.setBounds(52, 155, 238, 28);
		frame.getContentPane().add(txtrEnterStudentContact);
		
		tfTeacherContact = new JTextField();
		tfTeacherContact.getDocument().addDocumentListener(new DocumentListener() 
		{
			@Override
			public void removeUpdate(DocumentEvent e) {warn(); }
			@Override
			public void insertUpdate(DocumentEvent e) {warn(); }
			@Override
			public void changedUpdate(DocumentEvent e) {warn();}
			public void warn()
			{
				inputStdCntct  = tfTeacherContact.getText();
			}
		});
		
		tfTeacherContact.setColumns(10);
		tfTeacherContact.setBounds(314, 153, 254, 28);
		frame.getContentPane().add(tfTeacherContact);
		
		
		
	/////// ***** ///////	
		JTextArea txtrEnterTeacherDate = new JTextArea();
		txtrEnterTeacherDate.setFont(new Font("Monospaced", Font.PLAIN, 16));
		txtrEnterTeacherDate.setForeground(new Color(51, 204, 255));
		txtrEnterTeacherDate.setBackground(new Color(51, 51, 51));
		txtrEnterTeacherDate.setText("Enter Join Date");
		txtrEnterTeacherDate.setBounds(52, 205, 238, 28);
		frame.getContentPane().add(txtrEnterTeacherDate);
		
		tfTeacherDate = new JTextField();
		tfTeacherDate.getDocument().addDocumentListener(new DocumentListener() 
		{
			@Override
			public void removeUpdate(DocumentEvent e) {warn(); }
			@Override
			public void insertUpdate(DocumentEvent e) {warn(); }
			@Override
			public void changedUpdate(DocumentEvent e) {warn();}
			public void warn()
			{
				inputJoinDate = (tfTeacherDate.getSelectedText()) ;
			}
		});
		
		
		tfTeacherDate.setColumns(10);
		tfTeacherDate.setBounds(314, 203, 254, 28);
		frame.getContentPane().add(tfTeacherDate);
		
		textFieldShowResponse = new JTextField();
		textFieldShowResponse.setEnabled(false);
		textFieldShowResponse.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldShowResponse.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldShowResponse.setForeground(Color.BLUE);
		textFieldShowResponse.setBounds(239, 369, 199, 34);
		frame.getContentPane().add(textFieldShowResponse);
		textFieldShowResponse.setColumns(10);
	
		JButton btnAddTeacher = new JButton("Add this teacher");
		btnAddTeacher.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddTeacher.setBackground(new Color(51, 51, 51));
		btnAddTeacher.setHorizontalAlignment(SwingConstants.LEFT);
		btnAddTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				try 
				{
					Teacher teacherFromInput = new Teacher(inputStdID,inputStdName,inputStdCntct,inputJoinDate,"Lecturer");
					teacherFromInput.displayDetails();
					
					new Admin_addTeacher_Controller( teacherFromInput);
					textFieldShowResponse.setEnabled(false);
					textFieldShowResponse.setText("successfully inserted");
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnGoBack = new JButton("Go back");
		btnGoBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
			}
		});
		btnGoBack.setIcon(new ImageIcon(Admin_addTeacher_View.class.getResource("/images/icons/used/arrow_left.png")));
		btnGoBack.setHorizontalAlignment(SwingConstants.LEFT);
		btnGoBack.setBackground(Color.MAGENTA);
		btnGoBack.setToolTipText("Go back to previous page");
		btnGoBack.setBounds(32, 428, 164, 73);
		frame.getContentPane().add(btnGoBack);
		btnAddTeacher.setIcon(new ImageIcon(Admin_addTeacher_View.class.getResource("/images/icons/user_add small.png")));
		btnAddTeacher.setBounds(239, 271, 199, 83);
		frame.getContentPane().add(btnAddTeacher);
		
		
		
		
		JButton btnAddAnother = new JButton("Add new teacher");
		btnAddAnother.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddAnother.setHorizontalAlignment(SwingConstants.LEFT);
		btnAddAnother.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				System.out.println("you clicked add new tcr");
				frame.setVisible(false);
				//new Admin_addStudent_View();
				initialize();
			}
		});
		btnAddAnother.setIcon(new ImageIcon(Admin_addTeacher_View.class.getResource("/images/icons/used/add another teacher.png")));
		btnAddAnother.setBackground(Color.RED);
		btnAddAnother.setToolTipText("Add a new teacher");
		btnAddAnother.setBounds(416, 428, 214, 73);
		frame.getContentPane().add(btnAddAnother);
		
		JButton btnShowTeacherDatabase = new JButton("show Database");
		btnShowTeacherDatabase.setHorizontalAlignment(SwingConstants.LEFT);
		btnShowTeacherDatabase.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnShowTeacherDatabase.setForeground(new Color(0, 0, 0));
		btnShowTeacherDatabase.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				try 
				{
					new DrawJDBCTable("TEACHER");
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
		btnShowTeacherDatabase.setBackground(Color.BLACK);
		btnShowTeacherDatabase.setIcon(new ImageIcon(Admin_addTeacher_View.class.getResource("/images/icons/used/database.png")));
		btnShowTeacherDatabase.setBounds(206, 428, 199, 73);
		frame.getContentPane().add(btnShowTeacherDatabase);
		
	}
}
