package Public_Home_Page;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;



public class SearchEvents_view extends JFrame 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5799526083857283637L;
	private JPanel contentPane;
	private final JTextArea txtrEnterStdName = new JTextArea();
	private final JTextField tfName = new JTextField();
	private final JButton btnNameSearch = new JButton("search!");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					SearchEvents_view frame = new SearchEvents_view();
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
	public SearchEvents_view() 
	{
		tfName.setBounds(356, 74, 270, 29);
		tfName.setColumns(10);
		initGUI();
	}
	private void initGUI() 
	{
		setVisible(true);
		setBackground(new Color(0, 0, 128));
	//	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\nafi\\Pictures\\project images\\Background (1).jpg"));
		setTitle("Search  Events");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 673, 377);
	
		// for backGround image
		contentPane = new JPanel(){  
			                 /**
			 * 
			 */
			private static final long serialVersionUID = -7986621571227772668L;

							public void paintComponent(Graphics g) {  
			                     Image img = Toolkit.getDefaultToolkit().getImage(  
			                                SearchEvents_view.class.getResource("/images/backgrounds/ph event.jpg"));  
			                      g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
			                 }  
			           };  
		
		contentPane.setBackground(new Color(51, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		txtrEnterStdName.setForeground(new Color(51, 0, 51));
		txtrEnterStdName.setFont(new Font("Monospaced", Font.PLAIN, 18));
		txtrEnterStdName.setBackground(new Color(255, 255, 255));
		txtrEnterStdName.setText("Enter Event Category : ");
		txtrEnterStdName.setBounds(43, 71, 270, 29);
		
		contentPane.add(txtrEnterStdName);
		
		contentPane.add(tfName);
		/*
		tfName.getDocument().addDocumentListener(new DocumentListener() 
		{
			@Override
			public void removeUpdate(DocumentEvent e) {warn(); }
			@Override
			public void insertUpdate(DocumentEvent e) {warn(); }
			@Override
			public void changedUpdate(DocumentEvent e) {warn();}
			public void warn()
			{
				inputStdName  = tfName.getText();
			}
		});
		*/
		btnNameSearch.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				SearchEvents_Controller eventObj = new  SearchEvents_Controller();
				try 
				{
					String inputEventCategory  = tfName.getText();
					eventObj.searchByCategory(inputEventCategory);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});


		btnNameSearch.setBackground(new Color(154, 205, 50));
		btnNameSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent mE) 
			{		
				String StudentNameInput =  tfName.getText();
			
				System.out.println("your entered name is : "+ StudentNameInput);
				/**/
				try
				{  
					//setVisible(false);
					SearchStudents_Controller obj = new SearchStudents_Controller();
					obj.searchByName(StudentNameInput);
				}catch(Exception e){ System.out.println(e);} 	
			}
		});
		btnNameSearch.setBounds(299, 166, 94, 29);
		
		contentPane.add(btnNameSearch);
	}
}

