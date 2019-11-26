package Admin_Students;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.management.Notification;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Public_Home_Page.SearchStudents_view;
import tableDrawFromQuery.DrawJDBCTable;

import javax.swing.JCheckBox;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Admin_addStudent_View 
{

	public JFrame frame;
	private JTextField tfStudentID;
	private JTextArea txtrEnterStudentName;
	private JTextField tfStudentName;
	private JTextField tfStudentContact;
	private JTextField tfStudentBatch;
	
	String a,inputStdID,inputStdName,inputStdCntct;
	String inputStdCG="0.0",inputStdCredit="0.0";
	int inputStdSem=1,inputStdBatch;
	private JTextField textFieldShowResponse;
	private JButton btnGoBack;
	private JButton btnShowEnrolledDatabase;
	
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the application.
	 */
	public Admin_addStudent_View() 
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
		
		frame.getContentPane().setBackground(new Color(0, 0, 51));
		frame.setBounds(100, 100, 801, 572);
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		/////// ***** ///////
		JTextArea txtrEnterStudentId = new JTextArea();
		txtrEnterStudentId.setFont(new Font("Monospaced", Font.PLAIN, 16));
		txtrEnterStudentId.setForeground(new Color(153, 204, 255));
		txtrEnterStudentId.setBackground(new Color(0, 0, 51));
		txtrEnterStudentId.setText("Enter Student ID");
		txtrEnterStudentId.setBounds(38, 11, 232, 28);
		frame.getContentPane().add(txtrEnterStudentId);
		
		tfStudentID = new JTextField();
	
		tfStudentID.getDocument().addDocumentListener(new DocumentListener() 
		{
			@Override
			public void removeUpdate(DocumentEvent e) {warn(); }
			@Override
			public void insertUpdate(DocumentEvent e) {warn(); }
			@Override
			public void changedUpdate(DocumentEvent e) {warn();}
			public void warn()
			{
				inputStdID  = tfStudentID.getText();
			}
		});
		
		tfStudentID.setBounds(399, 11, 254, 28);
		frame.getContentPane().add(tfStudentID);
		tfStudentID.setColumns(10);
	
		/////// ***** ///////
		
		txtrEnterStudentName = new JTextArea();
		txtrEnterStudentName.setFont(new Font("Monospaced", Font.PLAIN, 16));
		txtrEnterStudentName.setForeground(new Color(153, 204, 255));
		txtrEnterStudentName.setBackground(new Color(0, 0, 51));
		txtrEnterStudentName.setText("Enter Student Name");
		txtrEnterStudentName.setBounds(38, 64, 232, 28);
		frame.getContentPane().add(txtrEnterStudentName);
		
		
		tfStudentName = new JTextField();
		tfStudentName.getDocument().addDocumentListener(new DocumentListener() 
		{
			@Override
			public void removeUpdate(DocumentEvent e) {warn(); }
			@Override
			public void insertUpdate(DocumentEvent e) {warn(); }
			@Override
			public void changedUpdate(DocumentEvent e) {warn();}
			public void warn()
			{
				inputStdName  = tfStudentName.getText();
			}
		});
		
		tfStudentName.setColumns(10);
		tfStudentName.setBounds(399, 64, 254, 28);
		frame.getContentPane().add(tfStudentName);
		
	/////// ***** ///////
		JTextArea txtrEnterStudentContact = new JTextArea();
		txtrEnterStudentContact.setFont(new Font("Monospaced", Font.PLAIN, 16));
		txtrEnterStudentContact.setForeground(new Color(153, 204, 255));
		txtrEnterStudentContact.setBackground(new Color(0, 0, 51));
		txtrEnterStudentContact.setText("Enter  Contact Number");
		txtrEnterStudentContact.setBounds(38, 121, 232, 28);
		frame.getContentPane().add(txtrEnterStudentContact);
		
		tfStudentContact = new JTextField();
		tfStudentContact.getDocument().addDocumentListener(new DocumentListener() 
		{
			@Override
			public void removeUpdate(DocumentEvent e) {warn(); }
			@Override
			public void insertUpdate(DocumentEvent e) {warn(); }
			@Override
			public void changedUpdate(DocumentEvent e) {warn();}
			public void warn()
			{
				inputStdCntct  = tfStudentContact.getText();
			}
		});
		
		tfStudentContact.setColumns(10);
		tfStudentContact.setBounds(399, 119, 254, 28);
		frame.getContentPane().add(tfStudentContact);
		
		
		
	/////// ***** ///////	
		JTextArea txtrEnterStudentBatch = new JTextArea();
		txtrEnterStudentBatch.setFont(new Font("Monospaced", Font.PLAIN, 16));
		txtrEnterStudentBatch.setForeground(new Color(153, 204, 255));
		txtrEnterStudentBatch.setBackground(new Color(0, 0, 51));
		txtrEnterStudentBatch.setText("Enter Student Batch");
		txtrEnterStudentBatch.setBounds(38, 181, 232, 28);
		frame.getContentPane().add(txtrEnterStudentBatch);
		
		tfStudentBatch = new JTextField();
		tfStudentBatch.getDocument().addDocumentListener(new DocumentListener() 
		{
			@Override
			public void removeUpdate(DocumentEvent e) {warn(); }
			@Override
			public void insertUpdate(DocumentEvent e) {warn(); }
			@Override
			public void changedUpdate(DocumentEvent e) {warn();}
			public void warn()
			{
				inputStdBatch = Integer.parseInt( tfStudentBatch.getText() );
			}
		});
		
		
		tfStudentBatch.setColumns(10);
		tfStudentBatch.setBounds(399, 183, 254, 28);
		frame.getContentPane().add(tfStudentBatch);
		
		textFieldShowResponse = new JTextField();
		textFieldShowResponse.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldShowResponse.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldShowResponse.setForeground(Color.BLUE);
		textFieldShowResponse.setEnabled(false);
		textFieldShowResponse.setBounds(239, 363, 164, 34);
		frame.getContentPane().add(textFieldShowResponse);
		textFieldShowResponse.setColumns(10);
	
		JButton btnAddStudent = new JButton("");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				try 
				{
					Student studentFromInput = new Student(inputStdID,inputStdName,inputStdCntct,inputStdCG,inputStdSem	,inputStdBatch,inputStdCredit);
					studentFromInput.displayDetails();
					new Admin_addStudent_Controller( studentFromInput);
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
		btnGoBack.setIcon(new ImageIcon(Admin_addStudent_View.class.getResource("/images/icons/back-icon tiny.png")));
		btnGoBack.setHorizontalAlignment(SwingConstants.LEFT);
		btnGoBack.setBackground(Color.MAGENTA);
		btnGoBack.setToolTipText("Go back to previous page");
		btnGoBack.setBounds(38, 424, 138, 88);
		frame.getContentPane().add(btnGoBack);
		btnAddStudent.setIcon(new ImageIcon(Admin_addStudent_View.class.getResource("/images/icons/user_add small.png")));
		btnAddStudent.setBounds(275, 265, 84, 73);
		frame.getContentPane().add(btnAddStudent);
		
		
		
		
		JButton btnAddAnother = new JButton("Add Another");
		btnAddAnother.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddAnother.setHorizontalAlignment(SwingConstants.LEFT);
		btnAddAnother.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				System.out.println("you clicked add new std");
				frame.setVisible(false);
				//new Admin_addStudent_View();
				initialize();
			}
		});
		btnAddAnother.setIcon(new ImageIcon(Admin_addStudent_View.class.getResource("/images/icons/used/add-user.png")));
		btnAddAnother.setBackground(Color.GREEN);
		btnAddAnother.setToolTipText("Add a new student");
		btnAddAnother.setBounds(592, 424, 183, 88);
		frame.getContentPane().add(btnAddAnother);
		
		JButton btnShowStudentDatabase = new JButton("Show Student DB");
		btnShowStudentDatabase.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnShowStudentDatabase.setHorizontalAlignment(SwingConstants.LEFT);
		btnShowStudentDatabase.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				try {
					new DrawJDBCTable("STUDENT");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnShowStudentDatabase.setBackground(new Color(0, 204, 255));
		btnShowStudentDatabase.setIcon(new ImageIcon(Admin_addStudent_View.class.getResource("/images/icons/used/blue database.png")));
		btnShowStudentDatabase.setBounds(175, 424, 199, 88);
		frame.getContentPane().add(btnShowStudentDatabase);
		
		btnShowEnrolledDatabase = new JButton("Show Enrolled DB");
		btnShowEnrolledDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try {
					new DrawJDBCTable("ENROLLED");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnShowEnrolledDatabase.setIcon(new ImageIcon(Admin_addStudent_View.class.getResource("/images/icons/used/sky blue db.jpg")));
		btnShowEnrolledDatabase.setHorizontalAlignment(SwingConstants.LEFT);
		btnShowEnrolledDatabase.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnShowEnrolledDatabase.setBackground(new Color(102, 204, 255));
		btnShowEnrolledDatabase.setBounds(371, 424, 222, 88);
		frame.getContentPane().add(btnShowEnrolledDatabase);
		
	}
}
