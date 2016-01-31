import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Login {

	
	
	private JFrame frame;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection = null;
	private JTextField usernameField;
	private JPasswordField passwordField;
	
	
	public Login() {
		initialize();
		connection=DBConnect.DBConnector();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 471, 233);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(87, 48, 66, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(87, 76, 66, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnLogin = new JButton("Είσοδος");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					
					
					String query = "SELECT * from loginfo where Username=? AND Password=? AND (Type=1 or Type=2)";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1,usernameField.getText());
					pst.setString(2,passwordField.getText());
					ResultSet rs=pst.executeQuery();
					
					 
					int type=0;
					int count = 0;
					while(rs.next()){
						
						type=rs.getInt("Type");
						count=count+1;
					}
					
					if(count == 1)
					{
						
						
						if(type==1){
						JOptionPane.showMessageDialog(null, "Καλώς Ήρθατε(HR)");
						
						frame.dispose();
						Manage mng=new Manage();
						mng.setVisible(true);
					}
						else {
							JOptionPane.showMessageDialog(null, "Καλώς Ήρθατε(Admin)");
							
							frame.dispose();
							feedback fb=new feedback();
							fb.setVisible(true);
							
						}
						
					}	
				
				else if(count>1)
					{
						JOptionPane.showMessageDialog(null, "Ο κωδικός ή το username υπάρχει ήδη!");
					}
					else{
						JOptionPane.showMessageDialog(null, "Προσπαθήστε ξανά...");
					}
					
					
					
					rs.close();
					pst.close();
					
					
					
					
				}catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, ex);
					
				}
				
			}
				
			
		});
		btnLogin.setBounds(183, 110, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		usernameField = new JTextField();
		usernameField.setBounds(183, 45, 89, 20);
		frame.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setBounds(183, 73, 89, 20);
		frame.getContentPane().add(passwordField);
		
		JLabel label = new JLabel("Παρακαλώ εισάγετε τα στοιχέια σας.");
		label.setBounds(87, 11, 265, 14);
		frame.getContentPane().add(label);
	}
}
