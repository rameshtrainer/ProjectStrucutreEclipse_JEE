package DatabaseFiles;
import java.sql.Connection;

import java.sql.ResultSet;

import Beans.*;

import java.sql.PreparedStatement;

import ConnectionClass.ConnectionProvider;
public class AdminValidation {

	public static boolean Validate(String username,String password) {
		boolean status = false;
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from adminlo where username=? and passwrd=?");
			 ps.setString(1,username);  
			 ps.setString(2,password);
			 
			ResultSet rs = ps.executeQuery();
			status = rs.next(); // This returns true if the values are present in the database;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return status;
}
}
