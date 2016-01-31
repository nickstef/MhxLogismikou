import java.sql.*;
import javax.swing.*;
public class DBConnect {

	Connection conn=null;
	
	public static  Connection DBConnector(){
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/nick","root","n5i2k3o4s");
			
			return conn;
			
			
			
		}catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,  ex);
			return null;
		}
	}
}
