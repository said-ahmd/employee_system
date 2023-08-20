
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.*;

public class empComp extends JFrame implements ActionListener {
	
	// connection info
			String url = "jdbc:mysql://localhost:3305/javap";
			String uname = "root";
			String upass = "said";
			//
	
	JPanel p = new JPanel();
	JTextArea fcom = new JTextArea();
	JLabel com = new JLabel("Complaint :");
	JButton sendbtn = new JButton("Submit");
	JButton bakbtn=new JButton("back");

	public empComp() {
		setSize(600, 600);
		setTitle("Complaints");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);


		fcom.setBounds(90, 90, 400, 200);
		com.setBounds(260, 50, 80, 30);
		com.setForeground(Color.decode("#ffffff"));
		

		p.setBackground(Color.decode("#20333E"));
		p.setLayout(null);
		p.add(com);
		p.add(fcom);
		p.add(sendbtn);
		p.add(bakbtn);
		this.add(p);

		bakbtn.setBounds(450,500,95,30);
		bakbtn.addActionListener(this);
		bakbtn.setFocusable(false);
		
		sendbtn.setBounds(245, 310, 90, 30);
		sendbtn.addActionListener(this);
		sendbtn.setFocusable(false);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String ss1 = fcom.getText().toString();
		if (e.getSource() == sendbtn) {
			if (ss1.length() == 0) {
				JOptionPane.showMessageDialog(this, "enter your complain please");
			} else {
				JOptionPane.showMessageDialog(this, "Your complaint will be examined soon");
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection(url, uname, upass);
					Statement st = con.createStatement();
					
					// my query to run
					String query = "insert into complaints (comp) values('"+ss1+"' );";
					fcom.setText("");
					st.executeUpdate(query);
					
				}
				catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
			}
		}
		else if(e.getSource()==bakbtn) {
			dispose();
			new empFrame();
		}

	}
    public static void main(String[] a) {
        new empComp();
    
}}
