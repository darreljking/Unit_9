import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


@SuppressWarnings("serial")
public class Logic extends JFrame {

	private JPanel contentPane;
	private DB database;
	private String server;
	private String Database;
	private String user;
	private String password;
	private Boolean isValid = true;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Logic frame = new Logic();
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
	public Logic() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConnect = new JLabel("Connect");
		lblConnect.setBounds(15, 25, 100, 20);
		contentPane.add(lblConnect);

		JButton btnConnect = new JButton("Connect to Northwind DB");
		btnConnect.setBounds(150, 20, 200, 30);
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String dbURL = "jdbc:sqlserver://IRONMAN\\SQLEXPRESS03;"
							+ "database=Northwind;"
							+ "user=sa;"
							+ "password=123456;"
							+ "encrypt=false;"
							+ "trustServerCertificate=false;"
							+ "loginTimeout=30;";			
					database = new DB(dbURL);
					JOptionPane.showMessageDialog(null, "Connected");
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				
				}
			});

		
		contentPane.add(btnConnect);
		
		JLabel lblCount = new JLabel("Count");
		lblCount.setBounds(15, 75, 100, 20);
		contentPane.add(lblCount);
		
		JButton btnCount = new JButton("Customer Count");
		btnCount.setBounds(150, 70, 200, 30);
		btnCount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String countValue = database.getCustomerCount();
					JOptionPane.showMessageDialog(null, "The customer count is: " + countValue);
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				
			}
		});
		contentPane.add(btnCount);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(15, 125, 100, 20);
		contentPane.add(lblName);
		
		JButton btnName = new JButton("Get Company Names");
		btnName.setBounds(150, 120, 200, 30);
		btnName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String nameValue = database.getCompanyNames();
					javax.swing.JOptionPane.showMessageDialog(null, "Our Customer names are: \n" + nameValue);
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				
			}
		});
		contentPane.add(btnName);		
		
		JLabel lblOc = new JLabel("Order Count");
		lblOc.setBounds(15, 175, 100, 20);
		contentPane.add(lblOc);
		
		JButton btnOc = new JButton("Get Order Count");
		btnOc.setBounds(150, 170, 200, 30);
		btnOc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String nameOcValue = database.getOrderCount();
					javax.swing.JOptionPane.showMessageDialog(null, "The Order Count is: " + nameOcValue);
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				
			}
		});
		contentPane.add(btnOc);	
		
		JLabel lblShipName = new JLabel("Ship Name");
		lblShipName.setBounds(15, 225, 100, 20);
		contentPane.add(lblShipName);
		
		JButton btnShipName = new JButton("Get Ship Names");
		btnShipName.setBounds(150, 220, 200, 30);
		btnShipName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String shipNameValue = database.getShipNames();
					javax.swing.JOptionPane.showMessageDialog(null, "The Ship Names are: \n" + shipNameValue);
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				
			}
		});
		contentPane.add(btnShipName);		
		
		JLabel lblEc = new JLabel("Employee Count");
		lblEc.setBounds(15, 275, 100, 20);
		contentPane.add(lblEc);
		
		JButton btnEc = new JButton("Get Employee Count");
		btnEc.setBounds(150, 270, 200, 30);
		btnEc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String eCountValue = database.getEmployeeCount();
					javax.swing.JOptionPane.showMessageDialog(null, "The Employee Count is: " + eCountValue);
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				
			}
		});
		contentPane.add(btnEc);		
		
		JLabel lblEmployeeName = new JLabel("Employee Name");
		lblEmployeeName.setBounds(15, 325, 100, 20);
		contentPane.add(lblEmployeeName);
		
		JButton btnEmployeeName = new JButton("Get Employee Names");
		btnEmployeeName.setBounds(150, 320, 200, 30);
		btnEmployeeName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String employeeNameValue = database.getEmployeeNames();
					javax.swing.JOptionPane.showMessageDialog(null, "The Employee Names are: \n" + employeeNameValue);
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				
			}
		});
		contentPane.add(btnEmployeeName);
		
		JLabel lblServer = new JLabel("Server");
		lblServer.setBounds(15, 375, 100, 20);
		contentPane.add(lblServer);	
		
		JTextField tfServer = new JTextField("IRONMAN");
		tfServer.setBounds(150, 370, 200, 30);
		contentPane.add(tfServer);
		
		JLabel lblDatabase = new JLabel("Database");
		lblDatabase.setBounds(15, 425, 100, 20);
		contentPane.add(lblDatabase);	
		
		JTextField tfDatabase = new JTextField("Northwind");
		tfDatabase.setBounds(150, 420, 200, 30);
		contentPane.add(tfDatabase);
				
		JLabel lblUser = new JLabel("User");
		lblUser.setBounds(15, 475, 100, 20);
		contentPane.add(lblUser);	
		
		JTextField tfUser = new JTextField(20);
		tfUser.setBounds(150, 470, 200, 30);
		contentPane.add(tfUser);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(15, 525, 100, 20);
		contentPane.add(lblPassword);	
		
		final JPasswordField pfPassword = new JPasswordField(20);
		pfPassword.setBounds(150, 520, 200, 30);
		contentPane.add(pfPassword);
			
	
	JButton btnlogin = new JButton("login");
	btnlogin.setBounds(150, 600, 200, 30);
	btnlogin.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try {
			    String server = tfServer.getText();
			    String Database = tfDatabase.getText();
			    String user = tfUser.getText();
			    String password = pfPassword.getText();
			    
				//Validate user name, server, database, and server are not empty.
			    if(server.isEmpty() || Database.isEmpty() || user.isEmpty() || password.isEmpty()) {
			    	isValid = false;
			    	JOptionPane.showMessageDialog(null, "You Must enter a user name, password, server, and databse.");
			    } 
			    else if(password.length() < 6) {
			    	isValid = false;
			    	JOptionPane.showMessageDialog(null,  "Your password must have 6 or more charcters." );
			    }
			    else if(password.length() >=6) {
			    	try {
			    		Integer.parseInt(password);
			    		isValid = true;
			    	}
			    	catch(NumberFormatException nfe) {
			    		isValid = false;
			    		JOptionPane.showMessageDialog(null,  "your password must contain numbers only");
			    	}
			    }

				if(isValid) {
					JOptionPane.showMessageDialog(null,  "Values accepted.");
					String dbURL = "jdbc:sqlserver://" + server + "\\SQLEXPRESS03;"
							+ "database=" + Database + ";"
							+ "user=" + user + ";"
							+ "password=" + password + ";"
							+ "encrypt=false;"
							+ "trustServerCertificate=false;"
							+ "loginTimeout=30;";			
					database = new DB(dbURL);
					JOptionPane.showMessageDialog(null, "Connected");
					}
				else {
					JOptionPane.showMessageDialog(null, "Invalid login parameters: " + server + ", " + Database + ", " + user + ", or bad password");	
					}
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				
				}
			});  
	contentPane.add(btnlogin);
			}
		

}
