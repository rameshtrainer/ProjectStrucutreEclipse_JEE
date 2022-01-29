package ConnectionClass;
import java.sql.Connection;
import java.sql.DriverManager;
public class ConnectionProvider {

	public static Connection getConnection() {
		Connection con= null;
		
	try {
		Class.forName("oracle.jdbc.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
	}catch(Exception e) {
		e.printStackTrace();
	}
	return con;
  }

}
