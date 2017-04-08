package GUI;
/*  The java.net package contains the basics needed for network operations. */
import java.net.*;
/* The java.io package contains the basics needed for IO operations. */
import java.io.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Client extends JFrame {

	private JPanel contentPane;
	private JTextField userNameTextField;
	private JTextField passwordTextField;
    public static String host = "localhost";
    public static int port = 9000;
    static BufferedReader read;
    static PrintWriter output;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws IOException {

		Client frame = new Client();
		frame.setVisible(true);

		// connect to the server
        InetAddress address = InetAddress.getByName(host);
		Socket connection = new Socket("localhost", port);
		//create printwriter for sending login to server
        output = new PrintWriter(new OutputStreamWriter(connection.getOutputStream()));
        
		while(true){}
	}
	
	

	/**
	 * Create the frame.
	 */
	public Client() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		userNameTextField = new JTextField();
		userNameTextField.setBounds(176, 120, 86, 20);
		contentPane.add(userNameTextField);
		userNameTextField.setColumns(10);
		
		passwordTextField = new JTextField();
		passwordTextField.setBounds(176, 151, 86, 20);
		contentPane.add(passwordTextField);
		passwordTextField.setColumns(10);
		
		JLabel titleLable = new JLabel("Employee Login");
		titleLable.setBounds(177, 87, 74, 14);
		contentPane.add(titleLable);
		
		JLabel usernameLable = new JLabel("Username:");
		usernameLable.setBounds(116, 123, 52, 14);
		contentPane.add(usernameLable);
		
		JLabel passwordLable = new JLabel("Password:");
		passwordLable.setBounds(116, 154, 50, 14);
		contentPane.add(passwordLable);
		
		JButton SubmitButton = new JButton("Submit");
		
		//Send information to server when button is clicked
		SubmitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				output.println(userNameTextField.getText());
				output.println(passwordTextField.getText());
				output.flush();
				userNameTextField.setText("");
				passwordTextField.setText("");
			}
		});
		
		SubmitButton.setBounds(173, 192, 89, 23);
		contentPane.add(SubmitButton);
	}
}
