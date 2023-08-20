import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class LoginFrame extends JFrame implements ActionListener {
	// connection info
	String url = "jdbc:mysql://localhost:3305/javap";
	String uname = "root";
	String pass = "said";
	//
	Container container = getContentPane();
	
	JLabel userLabel = new JLabel("USERNAME");
	JLabel passwordLabel = new JLabel("PASSWORD");
	
	JTextField userTextField = new JTextField();
	JPasswordField passwordField = new JPasswordField();
	
	JButton loginButton = new JButton("LOGIN");
	JButton resetButton = new JButton("RESET");
	
	JCheckBox showPassword = new JCheckBox("Show Password");

	LoginFrame() {

		
		
		
		this.setTitle("Login Form");
        this.setVisible(true);
        this.setSize( 600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
		
		
		
		setLayoutManager();
		setLocationAndSizeAndFocus();
		addComponentsToContainer();
		addActionEvent();
		colors();
	}

	public void colors() {
		container.setBackground(Color.decode("#20333E"));
		userLabel.setForeground(Color.decode("#ffffff"));
		passwordLabel.setForeground(Color.decode("#ffffff"));
		showPassword.setBackground(Color.decode("#20333E"));
		showPassword.setForeground(Color.decode("#ffffff"));
	}
		
	public void setLayoutManager() {
		container.setLayout(null);
	}

	public void setLocationAndSizeAndFocus() {
		userLabel.setBounds(165, 190, 100, 30);
		userTextField.setBounds(265, 190, 150, 30);

		passwordLabel.setBounds(165, 240, 100, 30);
		passwordField.setBounds(265, 240, 150, 30);

		showPassword.setBounds(260, 280, 150, 30);
		showPassword.setFocusable(false);

		loginButton.setBounds(165, 380, 100, 30);
		loginButton.setFocusable(false);
		resetButton.setBounds(305, 380, 100, 30);
		resetButton.setFocusable(false);

	}

	public void addComponentsToContainer() {
		container.add(userLabel);
		container.add(passwordLabel);
		container.add(userTextField);
		container.add(passwordField);
		container.add(showPassword);
		container.add(loginButton);
		container.add(resetButton);
	}

	public void addActionEvent() {
		loginButton.addActionListener(this);
		resetButton.addActionListener(this);
		showPassword.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Coding Part of LOGIN button
		if (e.getSource() == loginButton) {
			
				
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(url, uname, pass);

				String username = userTextField.getText();
				String pass = passwordField.getText();

				Statement st = con.createStatement();
				// my query to run
				String query = "SELECT * FROM employee where name='" + username + "' and pass=" + pass;
				ResultSet rs = st.executeQuery(query);
				if (rs.next()) {
					JOptionPane.showMessageDialog(this, "Login Successful");
					query = "SELECT depart FROM employee where name='" + username + "' and pass=" + pass;
					rs=st.executeQuery(query);
					rs.next();
					String db=rs.getString("depart");
					boolean admin=db.equals("admin");
					boolean employee=db.equals("employee");
					boolean manager=db.equals("manager");
					//login as admin
					if(admin) {
//						dispose();
						new adminChoice();
					}//login as employee
					else if(employee){
//						dispose();
						new empFrame();
					}//login as manager
					else if(manager) {
//						dispose();
						new managerFrame();
					}
					
				} else {
					JOptionPane.showMessageDialog(this, "Invalid Username or Password");
				}
				st.close();
				con.close();
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
			}

		}

		// Coding Part of RESET button
		if (e.getSource() == resetButton) {
			userTextField.setText("");
			passwordField.setText("");
		}
		// Coding Part of showPassword JCheckBox
		if (e.getSource() == showPassword) {
			if (showPassword.isSelected()) {
				passwordField.setEchoChar((char) 0);
			} else {
				passwordField.setEchoChar('*');
			}

		}
	}
	   public static void main(String[] a) {
	        new LoginFrame();
	    }

}