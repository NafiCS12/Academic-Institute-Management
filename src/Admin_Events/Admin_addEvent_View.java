package Admin_Events;

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
import java.sql.Date;
import java.beans.PropertyChangeEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Admin_addEvent_View 
{

	public JFrame frame;
	private JTextField tfEventID;
	private JTextArea txtrEnterEventCategory;
	private JTextField tfEventCategory;
	private JTextField tfEventLocation;
	private JTextField tfEventStartDate;
	
	String a,inputEventID,inputEventCategory,inputEventLocation,inputEventDetails,inputStartDate,inputEndDate;
	private JTextField textFieldShowResponse;
	private JButton btnGoBack;
	private final JTextArea txtrEnterEventDetails = new JTextArea();
	private final JTextField tfEventDetails = new JTextField();
	private final JTextArea txtrEnterEventEndDate = new JTextArea();
	private JTextField tfEventEndDate = new JTextField();
	
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the application.
	 */
	public Admin_addEvent_View() 
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
		
		frame.getContentPane().setBackground(new Color(0, 0, 128));
		frame.setBounds(100, 100, 814, 832);
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		/////// ***** ///////
		JTextArea txtrEnterEventId = new JTextArea();
		txtrEnterEventId.setText("Enter Event ID");
		txtrEnterEventId.setBounds(38, 32, 198, 28);
		frame.getContentPane().add(txtrEnterEventId);
		
		tfEventID = new JTextField();
	
		tfEventID.getDocument().addDocumentListener(new DocumentListener() 
		{
			@Override
			public void removeUpdate(DocumentEvent e) {warn(); }
			@Override
			public void insertUpdate(DocumentEvent e) {warn(); }
			@Override
			public void changedUpdate(DocumentEvent e) {warn();}
			public void warn()
			{
				inputEventID  = tfEventID.getText();
			}
		});
		
		tfEventID.setBounds(299, 30, 254, 28);
		frame.getContentPane().add(tfEventID);
		tfEventID.setColumns(10);
	
		/////// ***** ///////
		
		txtrEnterEventCategory = new JTextArea();
		txtrEnterEventCategory.setText("Enter Event Category");
		txtrEnterEventCategory.setBounds(38, 83, 198, 28);
		frame.getContentPane().add(txtrEnterEventCategory);
		
		
		tfEventCategory = new JTextField();
		tfEventCategory.getDocument().addDocumentListener(new DocumentListener() 
		{
			@Override
			public void removeUpdate(DocumentEvent e) {warn(); }
			@Override
			public void insertUpdate(DocumentEvent e) {warn(); }
			@Override
			public void changedUpdate(DocumentEvent e) {warn();}
			public void warn()
			{
				inputEventCategory  = tfEventCategory.getText();
			}
		});
		
		tfEventCategory.setColumns(10);
		tfEventCategory.setBounds(299, 83, 254, 28);
		frame.getContentPane().add(tfEventCategory);
		
	/////// ***** ///////
		JTextArea txtrEnterEventLocation = new JTextArea();
		txtrEnterEventLocation.setText("Enter Event Location");
		txtrEnterEventLocation.setBounds(38, 140, 198, 28);
		frame.getContentPane().add(txtrEnterEventLocation);
		
		tfEventLocation = new JTextField();
		tfEventLocation.getDocument().addDocumentListener(new DocumentListener() 
		{
			@Override
			public void removeUpdate(DocumentEvent e) {warn(); }
			@Override
			public void insertUpdate(DocumentEvent e) {warn(); }
			@Override
			public void changedUpdate(DocumentEvent e) {warn();}
			public void warn()
			{
				inputEventLocation = tfEventLocation.getText();
			}
		});
		
		tfEventLocation.setColumns(10);
		tfEventLocation.setBounds(299, 138, 254, 28);
		frame.getContentPane().add(tfEventLocation);
		
		
		
	/////// ***** ///////	
		JTextArea txtrEnterEventStartDate = new JTextArea();
		txtrEnterEventStartDate.setText("Enter Event Start Date");
		txtrEnterEventStartDate.setBounds(38, 202, 198, 28);
		frame.getContentPane().add(txtrEnterEventStartDate);
		
		tfEventStartDate = new JTextField();
		tfEventStartDate.setColumns(10);
		tfEventStartDate.setBounds(299, 202, 254, 28);
		frame.getContentPane().add(tfEventStartDate);
		
		tfEventStartDate.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				inputStartDate = ( tfEventStartDate.getText() );
			}
		});
		
		
		tfEventEndDate = new JTextField();
		frame.getContentPane().add(txtrEnterEventEndDate);
		tfEventEndDate.setColumns(10);
		tfEventEndDate.setBounds(299, 255, 254, 28);
		
		frame.getContentPane().add(tfEventEndDate);
		tfEventEndDate.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				inputEndDate = ( tfEventEndDate.getText() );
			}
		});
		
		
		
		
		
		
		textFieldShowResponse = new JTextField();
		textFieldShowResponse.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldShowResponse.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldShowResponse.setForeground(Color.BLUE);
		textFieldShowResponse.setEnabled(false);
		textFieldShowResponse.setBounds(281, 638, 254, 28);
		frame.getContentPane().add(textFieldShowResponse);
		textFieldShowResponse.setColumns(10);
		
		frame.getContentPane().add(txtrEnterEventDetails);
		tfEventDetails.setColumns(10);
		tfEventDetails.setBounds(299, 308, 458, 135);
		tfEventDetails.getDocument().addDocumentListener(new DocumentListener() 
		{
			@Override
			public void removeUpdate(DocumentEvent e) {warn(); }
			@Override
			public void insertUpdate(DocumentEvent e) {warn(); }
			@Override
			public void changedUpdate(DocumentEvent e) {warn();}
			public void warn()
			{
				inputEventDetails = ( tfEventDetails.getText() );
			}
		});
		frame.getContentPane().add(tfEventDetails);
		
		
		JButton btnAddEvent = new JButton("add this event");
		btnAddEvent.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddEvent.setHorizontalAlignment(SwingConstants.LEFT);
		btnAddEvent.setBackground(Color.BLACK);
		btnAddEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				try 
				{
					Events eventFromInput = new Events(inputEventID,inputEventCategory,inputEventLocation,inputStartDate,inputEndDate,inputEventLocation);//
					eventFromInput.displayDetails();
					new Admin_addEvent_Controller( eventFromInput);
					textFieldShowResponse.setEnabled(false);
					textFieldShowResponse.setText("successfully inserted a event");
					
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
		btnGoBack.setIcon(new ImageIcon(Admin_addEvent_View.class.getResource("/images/icons/used/arrow_left.png")));
		btnGoBack.setHorizontalAlignment(SwingConstants.LEFT);
		btnGoBack.setBackground(new Color(244, 164, 96));
		btnGoBack.setToolTipText("Go back to previous page");
		btnGoBack.setBounds(95, 698, 154, 73);
		frame.getContentPane().add(btnGoBack);
		btnAddEvent.setIcon(new ImageIcon(Admin_addEvent_View.class.getResource("/images/icons/used/add event.jpg")));
		btnAddEvent.setBounds(281, 509, 254, 102);
		frame.getContentPane().add(btnAddEvent);
		
		
		
		
		JButton btnAddAnother = new JButton("add another event");
		btnAddAnother.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddAnother.setHorizontalAlignment(SwingConstants.LEFT);
		btnAddAnother.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				System.out.println("you clicked add new event");
				frame.setVisible(false);
				//new Admin_addStudent_View();
				initialize();
			}
		});
		btnAddAnother.setIcon(new ImageIcon(Admin_addEvent_View.class.getResource("/images/icons/used/add another event.png")));
		btnAddAnother.setBackground(Color.GREEN);
		btnAddAnother.setToolTipText("Add a new event");
		btnAddAnother.setBounds(468, 698, 232, 73);
		frame.getContentPane().add(btnAddAnother);
		
		JButton btnShowEventDatabase = new JButton("show events DB");
		btnShowEventDatabase.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnShowEventDatabase.setHorizontalAlignment(SwingConstants.LEFT);
		btnShowEventDatabase.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				try {
					new DrawJDBCTable("EVENT");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnShowEventDatabase.setBackground(new Color(173, 255, 47));
		btnShowEventDatabase.setIcon(new ImageIcon(Admin_addEvent_View.class.getResource("/images/icons/used/database.png")));
		btnShowEventDatabase.setBounds(259, 698, 201, 73);
		frame.getContentPane().add(btnShowEventDatabase);
		txtrEnterEventDetails.setText("Enter Event Details");
		txtrEnterEventDetails.setBounds(38, 308, 198, 28);
		txtrEnterEventEndDate.setText("Enter Event End Date");
		txtrEnterEventEndDate.setBounds(38, 255, 198, 28);

	}
}
