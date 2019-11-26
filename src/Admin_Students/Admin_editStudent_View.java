package Admin_Students;

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

public class Admin_editStudent_View 
{

	public JFrame frame;
	private JTextField tfStudentID;
	private JTextField tfStudentCgpa;
	private JTextField tfCreditCompleted;
	
	String a,inputStdID,inputStdName,inputStdCntct;
	String inputStdCG,inputStdCredit;
	int inputStdSem,inputStdBatch;
	private JTextField textFieldShowResponse;
	private JButton btnGoBack;
	Student stdObj = new Student();
	private final JButton btnConfirmStdID = new JButton("Confirm");
	
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public Admin_editStudent_View() throws Exception 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() throws Exception 
	{
		System.out.println("init called- edit std view  ");
		frame = new JFrame();
		frame.setVisible(true);
		
		frame.getContentPane().setBackground(new Color(51, 0, 51));
		frame.setBounds(100, 100, 740, 577);
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		/////// ***** ///////
		JTextArea txtrEnterStudentId = new JTextArea();
		txtrEnterStudentId.setFont(new Font("Monospaced", Font.PLAIN, 16));
		txtrEnterStudentId.setForeground(new Color(153, 255, 255));
		txtrEnterStudentId.setBackground(new Color(51, 0, 51));
		txtrEnterStudentId.setText("Enter Student ID");
		txtrEnterStudentId.setBounds(38, 42, 249, 28);
		frame.getContentPane().add(txtrEnterStudentId);
		
		tfStudentID = new JTextField();
	
		tfStudentID.getDocument().addDocumentListener(new DocumentListener() 
		{
			@Override
			public void removeUpdate(DocumentEvent e) {try {
				warn();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} }
			@Override
			public void insertUpdate(DocumentEvent e) {try {
				warn();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} }
			@Override
			public void changedUpdate(DocumentEvent e) {try {
				warn();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}}
			public void warn() throws Exception
			{
				inputStdID  = tfStudentID.getText();
				
			}
		});
		tfStudentID.setBounds(337, 40, 254, 28);
		frame.getContentPane().add(tfStudentID);
		tfStudentID.setColumns(10);
		
		btnConfirmStdID.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				try {
					stdObj = Admin_editStudent_getQueryResults.getQueryResult(inputStdID);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnConfirmStdID.setBackground(Color.RED);
		btnConfirmStdID.setBounds(612, 42, 89, 23);
		
		frame.getContentPane().add(btnConfirmStdID);
		
	/////// ***** ///////
		JTextArea txtrEnterStudentCgpa = new JTextArea();
		txtrEnterStudentCgpa.setFont(new Font("Monospaced", Font.PLAIN, 16));
		txtrEnterStudentCgpa.setForeground(new Color(153, 255, 255));
		txtrEnterStudentCgpa.setBackground(new Color(51, 0, 51));
		txtrEnterStudentCgpa.setText("Enter Student CGPA");
		txtrEnterStudentCgpa.setBounds(38, 97, 249, 28);
		frame.getContentPane().add(txtrEnterStudentCgpa);
		
		tfStudentCgpa = new JTextField();
		tfStudentCgpa.getDocument().addDocumentListener(new DocumentListener() 
		{
			@Override
			public void removeUpdate(DocumentEvent e) {warn(); }
			@Override
			public void insertUpdate(DocumentEvent e) {warn(); }
			@Override
			public void changedUpdate(DocumentEvent e) {warn();}
			public void warn()
			{
				inputStdCG = ( tfStudentCgpa.getText() );
			}
		});
		
		tfStudentCgpa.setForeground(Color.BLUE);
		tfStudentCgpa.setText("");
		tfStudentCgpa.setColumns(10);
		tfStudentCgpa.setBounds(337, 95, 254, 28);
		frame.getContentPane().add(tfStudentCgpa);
		
	/////// ***** ///////	
		JTextArea txtrEnterStudentSemester = new JTextArea();
		txtrEnterStudentSemester.setFont(new Font("Monospaced", Font.PLAIN, 16));
		txtrEnterStudentSemester.setForeground(new Color(153, 255, 255));
		txtrEnterStudentSemester.setBackground(new Color(51, 0, 51));
		txtrEnterStudentSemester.setText("Enter Student Semester");
		txtrEnterStudentSemester.setBounds(38, 152, 249, 28);
		frame.getContentPane().add(txtrEnterStudentSemester);
		
		//Integer[] semesterOptions={2,3,4,5,6,7,8};
		String[]semesterOptions =  {"2", "3", "4", "5", "6", "7", "8"};
		JComboBox comboBox = new JComboBox(semesterOptions);
		//comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"2", "3", "4", "5", "6", "7", "8"}));
		comboBox.setBackground(new Color(128, 128, 128));
		comboBox.setToolTipText("Select a semester\r\n");
		comboBox.setEditable(true);
		comboBox.setBounds(337, 150, 254, 28);
		/*comboBox.addItemListener
		(
				new ItemListener() 
				{			
					@Override
					public void itemStateChanged(ItemEvent arg0) 
					{
					 // studentFromInput.student_Semester = (int) comboBox.getSelectedItem();
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
		        String ax = (String) ( comboBox.getSelectedItem() );
				inputStdSem = Integer.parseInt(ax);
		      }
		    });
		
		frame.getContentPane().add(comboBox);
		
	/////// ***** ///////		
		
		
		JTextArea txtrEnterCreditCompleted = new JTextArea();
		txtrEnterCreditCompleted.setFont(new Font("Monospaced", Font.PLAIN, 16));
		txtrEnterCreditCompleted.setForeground(new Color(153, 255, 255));
		txtrEnterCreditCompleted.setBackground(new Color(51, 0, 51));
		txtrEnterCreditCompleted.setText("Enter Credit Completed");
		txtrEnterCreditCompleted.setBounds(38, 217, 249, 28);
		frame.getContentPane().add(txtrEnterCreditCompleted);
		
		
		tfCreditCompleted = new JTextField();
		tfCreditCompleted .getDocument().addDocumentListener(new DocumentListener() 
		{
			@Override
			public void removeUpdate(DocumentEvent e) {warn(); }
			@Override
			public void insertUpdate(DocumentEvent e) {warn(); }
			@Override
			public void changedUpdate(DocumentEvent e) {warn();}
			public void warn()
			{
				inputStdCredit = ( tfCreditCompleted .getText() );
			}
		});
		
		tfCreditCompleted.setColumns(10);
		tfCreditCompleted.setBounds(337, 219, 254, 28);
		frame.getContentPane().add(tfCreditCompleted);
		
		
		// after taking all the "new " values of input- StdObj must be updated
		
		
		textFieldShowResponse = new JTextField();
		textFieldShowResponse.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldShowResponse.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldShowResponse.setForeground(Color.BLUE);
		textFieldShowResponse.setEnabled(false);
		textFieldShowResponse.setBounds(301, 391, 181, 34);
		frame.getContentPane().add(textFieldShowResponse);
		textFieldShowResponse.setColumns(10);
		
		
		JButton btnEditStudent = new JButton("Edit this student");
		btnEditStudent.setHorizontalAlignment(SwingConstants.LEFT);
		btnEditStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{			
				try 
				{		
					//Student studentFromInput = new Student(inputStdID,inputStdName,inputStdCntct,inputStdCG,inputStdSem	,inputStdBatch,inputStdCredit);
					//
					//stdObj.displayDetails();
					stdObj.student_CGPA = inputStdCG;
					System.out.println(" my students new cg is : "+ stdObj.student_CGPA);
					
					
					//stdObj.student_Semester = inputStdSem;
					System.out.println(" my students new semester is : "+ stdObj.student_Semester);
					
					stdObj.student_CreditCompleted = inputStdCredit;
					System.out.println(" my students new credit hour completed  is : "+ stdObj.student_CreditCompleted);
					
					new Admin_editStudent_Controller( stdObj,inputStdSem);
					textFieldShowResponse.setEnabled(false);
					textFieldShowResponse.setText("successfully updated");
					
				} catch (Exception e1) 
				{	
					e1.printStackTrace();
				}
			}
		});
		
		btnGoBack = new JButton("Go back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
			}
		});
		btnGoBack.setIcon(new ImageIcon(Admin_editStudent_View.class.getResource("/images/icons/back-icon tiny.png")));
		btnGoBack.setHorizontalAlignment(SwingConstants.LEFT);
		btnGoBack.setBackground(Color.MAGENTA);
		btnGoBack.setToolTipText("Go back to previous page");
		btnGoBack.setBounds(92, 447, 118, 59);
		frame.getContentPane().add(btnGoBack);
		btnEditStudent.setIcon(new ImageIcon(Admin_editStudent_View.class.getResource("/images/icons/edit Student small.png")));
		btnEditStudent.setBounds(301, 304, 181, 76);
		frame.getContentPane().add(btnEditStudent);
		
		
		
		
		JButton btnUpdateAnother = new JButton("update Another");
		btnUpdateAnother.setHorizontalAlignment(SwingConstants.LEFT);
		btnUpdateAnother.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				System.out.println("you clicked add new std");
				frame.setVisible(false);
				//new Admin_addStudent_View();
				try {
					initialize();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnUpdateAnother.setIcon(new ImageIcon(Admin_editStudent_View.class.getResource("/images/icons/Add-male-user tiny.png")));
		btnUpdateAnother.setBackground(Color.GREEN);
		btnUpdateAnother.setToolTipText("update a new student");
		btnUpdateAnother.setBounds(391, 447, 174, 59);
		frame.getContentPane().add(btnUpdateAnother);
		
		JButton btnShowStudentDatabase = new JButton("Show Student DB");
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
		btnShowStudentDatabase.setBackground(new Color(204, 153, 255));
		btnShowStudentDatabase.setIcon(new ImageIcon(Admin_editStudent_View.class.getResource("/images/icons/database tiny.png")));
		btnShowStudentDatabase.setBounds(210, 447, 181, 59);
		frame.getContentPane().add(btnShowStudentDatabase);
		
		
		
	}
}
