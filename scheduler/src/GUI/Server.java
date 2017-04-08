package GUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import dbConnection.dbConnection;
import java.io.InputStreamReader;

public class Server {
	public static void main(String[] args) throws SQLException, IOException {

		// connect to database
		dbConnection db = new dbConnection();
		db.connectDB("jdbc:mysql://localhost:3306/employee_login", "root", "Ebaums87!");

		// set up socket connect and listen
		ServerSocket listener = new ServerSocket(9000);
		Socket socket = new Socket();

		while (true) {
			String lusername = "";
			String lpassword = "";
			boolean correctLogin = false;
			Statement statement;
			
			socket = listener.accept();

			System.out.println("listening for connection");
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			while(correctLogin != true) {
				System.out.println("No answer yet");
				
				//Get message from login username and password attempt
				statement = db.getConnection().createStatement();
				lusername = input.readLine();
				System.out.println(lusername + "\t" + lusername.length());
				lpassword = input.readLine();
				System.out.println(lpassword + "\t" + lpassword.length());
				
		        ResultSet resultSet = statement.executeQuery("Select * from login where username = '" + lusername + "'");
		        
				
				System.out.println("ps executed right and result set has data");
				
				int dbUsername = resultSet.getInt(1);
				
				
				System.out.println(dbUsername);
				//System.out.println(dbPassWord);
				
				/*if(lusername == dbUsername )//&& lpassword == dbPassWord)
					correctLogin = true;*/
				
				if(correctLogin = true)
					System.out.println("correct");
			}

			System.out.println("We just got the message");

			while(true){}
		}

	}
}
	/*public static void main(String[] args) throws SQLException {
		dbConnection db = new dbConnection();
		db.connectDB("jdbc:mysql://localhost:3306/employee_login", "root", "Ebaums87!");
		db.getEmployeeName();
		db.closeStatement();
		db.closeConnections();
	}
*/

