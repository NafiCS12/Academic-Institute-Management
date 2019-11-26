package Admin_Teachers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import tableDrawFromQuery.DrawJDBCTable;

import javax.swing.JCheckBox;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Admin_removeTeacher_View 
{

	public JFrame frame;
	private JTextField tfTeacherID;
	Teacher tchrToDelete;
	String a,inputTchrID,inputTchrName,inputTchrCntct;
	Boolean ProcedeAction = false;
	private JTextField textFieldShowResponse;
	private JButton btnGoBack;
	 
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public Admin_removeTeacher_View() throws Exception 
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
		
		frame.getContentPane().setBackground(new Color(51, 0, 51));
		frame.setBounds(100, 100, 687, 525);
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		/////// ***** ///////
		JTextArea txtrEnterTeacherId = new JTextArea();
		txtrEnterTeacherId.setFont(new Font("Monospaced", Font.PLAIN, 16));
		txtrEnterTeacherId.setForeground(new Color(51, 204, 255));
		txtrEnterTeacherId.setBackground(new Color(51, 0, 51));
		txtrEnterTeacherId.setText("Enter Teacher ID to remove");
		txtrEnterTeacherId.setBounds(28, 81, 273, 28);
		frame.getContentPane().add(txtrEnterTeacherId);
		
		tfTeacherID = new JTextField();
	
		
		
		tfTeacherID.setBounds(325, 82, 220, 28);
		frame.getContentPane().add(tfTeacherID);
		tfTeacherID.setColumns(10);
		
		JCheckBox chckbxConfirm = new JCheckBox("confirm");
		chckbxConfirm.addItemListener(new ItemListener() 
		{
			public void itemStateChanged(ItemEvent Ie) 
			{
				if(Ie.getStateChange() ==1)
				{
//					System.out.println("u checked it ");
					ProcedeAction= true;
					inputTchrID  = tfTeacherID.getText();
					System.out.println("u inserted : " + inputTchrID);
					try {
						tchrToDelete = Admin_editTeacher_getQueryResults.getQueryResult(inputTchrID);
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
		textFieldShowResponse.setBounds(218, 313, 219, 34);
		frame.getContentPane().add(textFieldShowResponse);
		textFieldShowResponse.setColumns(10);
	
		JButton btnRemoveTeacher = new JButton("Delete thisTeacher");
		btnRemoveTeacher.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnRemoveTeacher.setHorizontalAlignment(SwingConstants.LEFT);
		btnRemoveTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				try 
				{
					//tchrToDelete.displayDetails();
					new Admin_removeTeacher_Controller( tchrToDelete);
					textFieldShowResponse.setEnabled(false);
					textFieldShowResponse.setText("successfully inserted");
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnGoBack = new JButton("Go back");
		btnGoBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
			}
		});
		btnGoBack.setIcon(new ImageIcon(Admin_removeTeacher_View.class.getResource("/images/icons/used/arrow_left.png")));
		btnGoBack.setHorizontalAlignment(SwingConstants.LEFT);
		btnGoBack.setBackground(Color.MAGENTA);
		btnGoBack.setToolTipText("Go back to previous page");
		btnGoBack.setBounds(50, 372, 145, 84);
		frame.getContentPane().add(btnGoBack);
		btnRemoveTeacher.setIcon(new ImageIcon(Admin_removeTeacher_View.class.getResource("/images/icons/used/10118-database-remove-vector.jpg")));
		btnRemoveTeacher.setBounds(218, 208, 219, 84);
		frame.getContentPane().add(btnRemoveTeacher);
		
		
		
		
		JButton btnRemoveAnother = new JButton("Delete Another Teacher");
		btnRemoveAnother.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnRemoveAnother.setIcon(new ImageIcon(Admin_removeTeacher_View.class.getResource("/images/icons/delete teacher.jpg")));
		btnRemoveAnother.setHorizontalAlignment(SwingConstants.LEFT);
		btnRemoveAnother.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				System.out.println("you clicked add new Tchr");
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
		btnRemoveAnother.setBackground(Color.GREEN);
		btnRemoveAnother.setToolTipText("Add a new Teacher");
		btnRemoveAnother.setBounds(414, 372, 238, 84);
		frame.getContentPane().add(btnRemoveAnother);
		
		JButton btnShowTeacherDatabase = new JButton("Show Teacher DB");
		btnShowTeacherDatabase.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnShowTeacherDatabase.setHorizontalAlignment(SwingConstants.LEFT);
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
		btnShowTeacherDatabase.setBackground(new Color(255, 228, 196));
		btnShowTeacherDatabase.setIcon(new ImageIcon(Admin_removeTeacher_View.class.getResource("/images/icons/used/database.png")));
		btnShowTeacherDatabase.setBounds(205, 372, 203, 84);
		frame.getContentPane().add(btnShowTeacherDatabase);
		chckbxConfirm.setBackground(new Color(255, 255, 255));
		chckbxConfirm.setBounds(585, 83, 67, 27);
		
		frame.getContentPane().add(chckbxConfirm);
		
	}
}
