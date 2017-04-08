package dbConnection;
import java.sql.*;

public class dbConnection {

	 private Connection connection;        // The database connection object.
	 private Statement statement;          // the database statement object, used to execute SQL commands
	 
	public void connectDB(String url, String username, String password) throws SQLException {
		connection = DriverManager.getConnection(url, username, password);
		System.out.println("Database connected!");
	}
	 
	public void getEmployeeName() throws SQLException {
		ResultSet rs;

		statement = connection.createStatement();

		rs = statement.executeQuery("select * from login");

		while (rs.next())
			System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + " " + rs.getString(4));
	}
	
	public Connection getConnection()
	{
		return connection;
	}

	 public void closeConnections()
	 {
		 try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	 }
	 
	 public void closeStatement()
	 {
		 try {
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	 }

}
