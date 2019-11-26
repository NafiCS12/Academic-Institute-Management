package Admin_Reasearches;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


import tableDrawFromQuery.DrawJDBCTable;

public class Admin_addResearch_view 
{

	public JFrame frame;
	private JTextField tfResearchID;
	private JTextArea txtrEnterResearchCategory;
	private JTextField tfResearchCategory;
	private JTextField tfResearchTitle;
	private JTextField tfResearchStartDate;
	
	String a,inputResearchID,inputResearchCategory,inputResearchTitle,inputResearchT,inputS,inputY;
	private JTextField textFieldShowResponse;
	private JButton btnGoBack;
	private final JTextArea txtrEnterResearchDetails = new JTextArea();
	private final JTextField tfResearchYear = new JTextField();
	private final JTextArea txtrEnterResearchEndDate = new JTextArea();
	private JTextField tfResearchEndDate = new JTextField();
	
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the application.
	 */
	public Admin_addResearch_view() 
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
		JTextArea txtrEnterResearchId = new JTextArea();
		txtrEnterResearchId.setText("Enter Research ID");
		txtrEnterResearchId.setBounds(38, 32, 198, 28);
		frame.getContentPane().add(txtrEnterResearchId);
		
		tfResearchID = new JTextField();
	
		
		
		tfResearchID.setBounds(299, 30, 254, 28);
		frame.getContentPane().add(tfResearchID);
		tfResearchID.setColumns(10);
		
		inputResearchID = tfResearchID.getText();
		/////// ***** ///////
		
		txtrEnterResearchCategory = new JTextArea();
		txtrEnterResearchCategory.setText("Enter Research Category");
		txtrEnterResearchCategory.setBounds(38, 83, 198, 28);
		frame.getContentPane().add(txtrEnterResearchCategory);
		
		
		tfResearchCategory = new JTextField();
		
		
		tfResearchCategory.setColumns(10);
		tfResearchCategory.setBounds(299, 83, 254, 28);
		frame.getContentPane().add(tfResearchCategory);
		
		inputResearchCategory = tfResearchCategory.getText();
	/////// ***** ///////
		JTextArea txtrEnterResearchTitle = new JTextArea();
		txtrEnterResearchTitle.setText("Enter Research Title");
		txtrEnterResearchTitle.setBounds(38, 140, 198, 28);
		frame.getContentPane().add(txtrEnterResearchTitle);
		
		tfResearchTitle = new JTextField();
		
		
		tfResearchTitle.setColumns(10);
		tfResearchTitle.setBounds(299, 138, 254, 28);
		frame.getContentPane().add(tfResearchTitle);
		
		inputResearchTitle = tfResearchTitle.getText();
		
	/////// ***** ///////	
		JTextArea txtrEnterResearchStartDate = new JTextArea();
		txtrEnterResearchStartDate.setText("Enter Research Teacher ID");
		txtrEnterResearchStartDate.setBounds(38, 202, 211, 28);
		frame.getContentPane().add(txtrEnterResearchStartDate);
		
		tfResearchStartDate = new JTextField();
		tfResearchStartDate.setColumns(10);
		tfResearchStartDate.setBounds(299, 202, 254, 28);
		frame.getContentPane().add(tfResearchStartDate);
		
		inputResearchT = tfResearchStartDate.getText();
		
		
		tfResearchEndDate = new JTextField();
		frame.getContentPane().add(txtrEnterResearchEndDate);
		tfResearchEndDate.setColumns(10);
		tfResearchEndDate.setBounds(299, 255, 254, 28);
		
		frame.getContentPane().add(tfResearchEndDate);
		
		inputS = ( tfResearchEndDate.getText() );
		
		
		
		
		
		
		
		textFieldShowResponse = new JTextField();
		textFieldShowResponse.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldShowResponse.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldShowResponse.setForeground(Color.BLUE);
		textFieldShowResponse.setEnabled(false);
		textFieldShowResponse.setBounds(281, 638, 232, 28);
		frame.getContentPane().add(textFieldShowResponse);
		textFieldShowResponse.setColumns(10);
		
		frame.getContentPane().add(txtrEnterResearchDetails);
		tfResearchYear.setColumns(10);
		tfResearchYear.setBounds(299, 308, 458, 28);
		
		inputY= ( tfResearchYear.getText() );
		
		
		frame.getContentPane().add(tfResearchYear);
		
		
		JButton btnAddResearch = new JButton("   add this Research");
		btnAddResearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAddResearch.setHorizontalAlignment(SwingConstants.LEFT);
		btnAddResearch.setBackground(Color.BLACK);
		btnAddResearch.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					Reasearches ResearchFromInput = new Reasearches(inputResearchID,inputResearchCategory,inputResearchTitle,inputResearchT,inputS,inputY);//
					ResearchFromInput.displayDetails();
					new Admin_addResearch_controller( ResearchFromInput);
					textFieldShowResponse.setEnabled(false);
					textFieldShowResponse.setText("successfully inserted a Research");
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnGoBack = new JButton("Go back");
		btnGoBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGoBack.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				frame.setVisible(false);
				
			}
		});
		btnGoBack.setIcon(new ImageIcon(Admin_addResearch_view.class.getResource("/images/icons/used/arrow_left.png")));
		btnGoBack.setHorizontalAlignment(SwingConstants.LEFT);
		btnGoBack.setBackground(new Color(244, 164, 96));
		btnGoBack.setToolTipText("Go back to previous page");
		btnGoBack.setBounds(95, 698, 154, 73);
		frame.getContentPane().add(btnGoBack);
		btnAddResearch.setIcon(new ImageIcon(Admin_addResearch_view.class.getResource("/images/icons/used/research.png")));
		btnAddResearch.setBounds(281, 509, 232, 102);
		frame.getContentPane().add(btnAddResearch);
		
		
		
		
		JButton btnAddAnother = new JButton("add another Research");
		btnAddAnother.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddAnother.setHorizontalAlignment(SwingConstants.LEFT);
		btnAddAnother.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				System.out.println("you clicked add new Research");
				frame.setVisible(false);
				initialize();
				
			}
		});
		btnAddAnother.setIcon(new ImageIcon(Admin_addResearch_view.class.getResource("/images/icons/used/research add.png")));
		btnAddAnother.setBackground(Color.GREEN);
		btnAddAnother.setToolTipText("Add a new Research");
		btnAddAnother.setBounds(490, 698, 235, 73);
		frame.getContentPane().add(btnAddAnother);
		
		JButton btnShowResearchDatabase = new JButton("show Researchs DB");
		btnShowResearchDatabase.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnShowResearchDatabase.setHorizontalAlignment(SwingConstants.LEFT);
		btnShowResearchDatabase.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent Ae) 
			{
				try {
					new DrawJDBCTable("Research");
				} catch (Exception e) {
					e.printStackTrace();
				}			
			}
		});
		btnShowResearchDatabase.setBackground(new Color(173, 255, 47));
		btnShowResearchDatabase.setIcon(new ImageIcon(Admin_addResearch_view.class.getResource("/images/icons/used/database.png")));
		btnShowResearchDatabase.setBounds(259, 698, 221, 73);
		frame.getContentPane().add(btnShowResearchDatabase);
		txtrEnterResearchDetails.setText("Enter Research Year");
		txtrEnterResearchDetails.setBounds(38, 308, 198, 28);
		txtrEnterResearchEndDate.setText("Enter Research Student ID");
		txtrEnterResearchEndDate.setBounds(38, 255, 211, 28);

	}
}
