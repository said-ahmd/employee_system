import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class manSpecEmpToSh implements ActionListener {
	// connection info
	String url = "jdbc:mysql://localhost:3305/javap";
	String uname = "root";
	String pass = "said";
	//

	JFrame f = new JFrame("admin");
	JButton submit = new JButton("submit");
	JButton back = new JButton("back");
	JTextField fid = new JTextField();
	JTextField fname = new JTextField();
	JLabel l1, l2;

	public void manSpecEmpToSh() {


		f.getContentPane().setBackground(Color.decode("#20333E"));

		l1 = new JLabel("ID");
		l1.setBounds(160, 170, 100, 30);
		l1.setForeground(Color.decode("#ffffff"));
		l2 = new JLabel("NAME");
		l2.setBounds(160, 220, 100, 30);
		l2.setForeground(Color.decode("#ffffff"));

		fid.setBounds(230, 170, 150, 30);
		fname.setBounds(230, 220, 150, 30);

		submit.setBounds(240, 300, 95, 30);
		submit.addActionListener(this);
		back.setBounds(450, 500, 95, 30);
		back.addActionListener(this);

		f.add(l1);
		f.add(l2);
		f.add(fid);
		f.add(fname);
		f.add(submit);
		f.add(back);
		f.setSize(600, 600);
		f.setLayout(null);
		f.setVisible(true);
		f.setResizable(false);

	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String id = fid.getText().toString();
		String name = fname.getText().toString();

		if (e.getSource() == back) {
			f.dispose();
			new managerFrame();
		} else if (e.getSource() == submit) {
			if(id.length()==0||name.length()==0) {
				JOptionPane.showMessageDialog(f, "enter data please");
			}
			else {
				
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(url, uname, pass);
				Statement st = con.createStatement();
				
				// my query to run
				String query = "SELECT * FROM employee where name='" + name + "' and id='" + id+"'";
				ResultSet rs = st.executeQuery(query);
				if (rs.next()) {
					query = "SELECT depart FROM employee where name='" + name + "' and id='" + id+"'";
					rs=st.executeQuery(query);
					rs.next();
					String db=rs.getString("depart");
					boolean admin=db.equals("admin");
					//login as admin
					if(admin) {
						JOptionPane.showMessageDialog(f, "you can't modify admin");
					}//not admin
					else {
						String m = "update lastin set id='" + id+"',  name='"+name+"'" ;
						st.executeUpdate(m);	
						f.dispose();
						new manModEmp();
					}
					
				}
				else {
					
					JOptionPane.showMessageDialog(f, "Invalid id or user name");
				}
				st.close();
				con.close();
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(f, "Invalid id or user name");
			}}

		}

	}
	public static void main(String[] a) {
		manSpecEmpToSh as=new manSpecEmpToSh ();
		 as.manSpecEmpToSh();
	}

}
