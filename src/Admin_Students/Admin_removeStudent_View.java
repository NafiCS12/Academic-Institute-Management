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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.InputMethodEvent;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Admin_removeStudent_View 
{

	public JFrame frame;
	private JTextField tfStudentID;
	Student stdToDelete;
	String a,inputStdID,inputStdName,inputStdCntct;
	Boolean ProcedeAction = false;
	int inputStdSem=1,inputStdBatch;
	private JTextField textFieldShowResponse;
	private JButton btnGoBack;
	 
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public Admin_removeStudent_View() throws Exception 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() throws Exception 
	{
		//System.out.println("init called");
		frame = new JFrame();
		frame.setVisible(true);
		
		frame.getContentPane().setBackground(new Color(51, 0, 102));
		frame.setBounds(100, 100, 687, 525);
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		/////// ***** ///////
		JTextArea txtrEnterStudentId = new JTextArea();
		txtrEnterStudentId.setFont(new Font("Monospaced", Font.PLAIN, 16));
		txtrEnterStudentId.setForeground(new Color(102, 255, 255));
		txtrEnterStudentId.setBackground(new Color(51, 0, 51));
		txtrEnterStudentId.setText("Enter Student ID to remove");
		txtrEnterStudentId.setBounds(42, 82, 264, 28);
		frame.getContentPane().add(txtrEnterStudentId);
		
		tfStudentID = new JTextField();
	
		
		
		tfStudentID.setBounds(325, 82, 220, 28);
		frame.getContentPane().add(tfStudentID);
		tfStudentID.setColumns(10);
		
		JCheckBox chckbxConfirm = new JCheckBox("confirm");
		chckbxConfirm.addItemListener(new ItemListener() 
		{
			public void itemStateChanged(ItemEvent Ie) 
			{
				if(Ie.getStateChange() ==1)
				{
//					System.out.println("u checked it ");
					ProcedeAction= true;
					inputStdID  = tfStudentID.getText();
					System.out.println("u inserted : " + inputStdID);
					try {
						stdToDelete = Admin_editStudent_getQueryResults.getQueryResult(inputStdID);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}		
			}
		});
		
		
		
		textFieldShowResponse = new JTextField();
		textFieldShowResponse.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldShowResponse.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldShowResponse.setForeground(Color.BLUE);
		textFieldShowResponse.setEnabled(false);
		textFieldShowResponse.setBounds(218, 313, 185, 34);
		frame.getContentPane().add(textFieldShowResponse);
		textFieldShowResponse.setColumns(10);
	
		JButton btnRemoveStudent = new JButton("");
		btnRemoveStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				try 
				{
					//stdToDelete.displayDetails();
					new Admin_removeStudent_Controller( stdToDelete);
					textFieldShowResponse.setEnabled(false);
					textFieldShowResponse.setText("successfully inserted");
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnGoBack = new JButton("");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
			}
		});
		btnGoBack.setIcon(new ImageIcon(Admin_removeStudent_View.class.getResource("/images/icons/used/arrow_left.png")));
		btnGoBack.setHorizontalAlignment(SwingConstants.LEFT);
		btnGoBack.setBackground(Color.MAGENTA);
		btnGoBack.setToolTipText("Go back to previous page");
		btnGoBack.setBounds(123, 372, 90, 84);
		frame.getContentPane().add(btnGoBack);
		btnRemoveStudent.setIcon(new ImageIcon(Admin_removeStudent_View.class.getResource("/images/icons/used/delete_this student.png")));
		btnRemoveStudent.setBounds(252, 189, 118, 103);
		frame.getContentPane().add(btnRemoveStudent);
		
		
		
		
		JButton btnRemoveAnother = new JButton("");
		btnRemoveAnother.addActionListener(new ActionListener() 
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
		btnRemoveAnother.setIcon(new ImageIcon(Admin_removeStudent_View.class.getResource("/images/icons/used/delete student1.png")));
		btnRemoveAnother.setBackground(Color.GREEN);
		btnRemoveAnother.setToolTipText("Add a new student");
		btnRemoveAnother.setBounds(426, 372, 84, 84);
		frame.getContentPane().add(btnRemoveAnother);
		
		JButton btnShowStudentDatabase = new JButton("");
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
		btnShowStudentDatabase.setBackground(new Color(255, 228, 196));
		btnShowStudentDatabase.setIcon(new ImageIcon(Admin_removeStudent_View.class.getResource("/images/icons/used/database.png")));
		btnShowStudentDatabase.setBounds(273, 372, 97, 84);
		frame.getContentPane().add(btnShowStudentDatabase);
		chckbxConfirm.setBackground(new Color(255, 255, 255));
		chckbxConfirm.setBounds(585, 83, 67, 27);
		
		frame.getContentPane().add(chckbxConfirm);
		
	}
}
