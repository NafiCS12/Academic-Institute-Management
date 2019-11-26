package FirstPage;
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
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;



public class Admin_login_View extends JFrame 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1005340620359602017L;
	private JPanel contentPane;
	private final JTextArea txtrEnterUserId = new JTextArea();
	private final JTextField textField = new JTextField();
	private final JTextArea txtrEnterPassworrd = new JTextArea();
	private final JPasswordField passwordField = new JPasswordField();
	private final JButton btnLogin = new JButton("Login");
	private final JButton btnGuestSession = new JButton("guest Session");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_login_View frame = new Admin_login_View();
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
	public Admin_login_View() {
		textField.setBounds(296, 30, 162, 29);
		textField.setColumns(10);
		initGUI();
	}
	private void initGUI() {
		setBackground(new Color(0, 0, 128));
	//	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\nafi\\Pictures\\project images\\Background (1).jpg"));
		setTitle("Institute Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 355);
	
		// for backGround image
		contentPane = new JPanel(){  
			                 /**
			 * 
			 */
			private static final long serialVersionUID = -4305465435067243294L;

							public void paintComponent(Graphics g) {  
			                     Image img = Toolkit.getDefaultToolkit().getImage(  
			                                Admin_login_View.class.getResource("/images/Admin_login_bg.jpg"));  
			                      g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
			                 }  
			           };  
		
		contentPane.setBackground(new Color(100, 149, 237));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		txtrEnterUserId.setForeground(Color.BLACK);
		txtrEnterUserId.setFont(new Font("Monospaced", Font.PLAIN, 18));
		txtrEnterUserId.setBackground(Color.WHITE);
		txtrEnterUserId.setText("Enter User id : ");
		txtrEnterUserId.setBounds(52, 32, 184, 29);
		
		contentPane.add(txtrEnterUserId);
		
		contentPane.add(textField);
		txtrEnterPassworrd.setForeground(Color.BLACK);
		txtrEnterPassworrd.setFont(new Font("Monospaced", Font.PLAIN, 18));
		txtrEnterPassworrd.setBackground(Color.WHITE);
		txtrEnterPassworrd.setText("Enter Password : ");
		txtrEnterPassworrd.setBounds(52, 101, 184, 31);
		
		contentPane.add(txtrEnterPassworrd);
		passwordField.setBounds(296, 101, 162, 29);
		
		contentPane.add(passwordField);
		btnLogin.setBackground(new Color(154, 205, 50));
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent mE) 
			{
				
				String UserIdInput =  textField.getText();
				String PasswordInput = passwordField.getText().toString();
				
			//	System.out.println("your id is : "+ UserIdInput);
			//	System.out.print("type " + PasswordInput+" as pw \n");
				
				//now query on AdminInfo Db. for this user id , fetch the correct pw.
				
				/**/
				try
				{  
					//Admin_login_Controller alc = new Admin_login_Controller(UserIdInput, PasswordInput);
					setVisible(false);
					new Admin_login_Controller(UserIdInput, PasswordInput);
				}catch(Exception e){ System.out.println(e);} 
				
				
			}
		});
		btnLogin.setBounds(211, 182, 89, 23);
		
		contentPane.add(btnLogin);
		
		
		
		
		btnGuestSession.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				//System.out.println(" taking u to guest session ");
			 //	
				setVisible(false);
				//Public_homePage_View phV = 
				new Public_homePage_View();
			}
		});
		btnGuestSession.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGuestSession.setForeground(new Color(0, 0, 0));
		btnGuestSession.setBackground(new Color(153, 204, 255));
		btnGuestSession.setBounds(369, 259, 130, 46);
		
		contentPane.add(btnGuestSession);
		
	}
}
