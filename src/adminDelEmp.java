
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.*;

public class adminDelEmp implements ActionListener {
	// connection info
			String url = "jdbc:mysql://localhost:3305/javap";
			String uname = "root";
			String upass = "said";
	//
			
	JFrame f = new JFrame("admin");
	JButton delete = new JButton("delete");
	JButton back = new JButton("back");
	JTextField fid = new JTextField();
	JTextField fname = new JTextField();
	JLabel l1, l2;

	adminDelEmp() {
		fid.setText("");
		fname.setText("");
		
		f.getContentPane().setBackground(Color.decode("#20333E"));
		
		l1 = new JLabel("ID");
		l1.setBounds(160, 170, 100, 30);
		l1.setForeground(Color.decode("#ffffff"));
		l2 = new JLabel("NAME");
		l2.setBounds(160, 220, 100, 30);
		l2.setForeground(Color.decode("#ffffff"));
		
		fid.setBounds(230, 170, 150, 30);
		fname.setBounds(230, 220, 150, 30);
		
		delete.setBounds(240, 300, 95, 30);
		delete.addActionListener(this);
		back.setBounds(450, 500, 95, 30);
		back.addActionListener(this);
		
		f.add(l1);
		f.add(l2);
		f.add(fid);
		f.add(fname);
		f.add(delete);
		f.add(back);
		f.setSize(600, 600);
		f.setLayout(null);
		f.setVisible(true);
		f.setResizable(false);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String name=fname.getText().toString();
		String id=fid.getText().toString();
		if(e.getSource()==back) {
			f.dispose();
			new adminChoice();
		}
		else if(e.getSource()==delete) {
			try {
				if(name.length()==0||id.length()==0) {
					JOptionPane.showMessageDialog(f, "enter all data please");
				}
				else {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(url, uname, upass);
				Statement st = con.createStatement();
				
				// my query to run
				JOptionPane.showMessageDialog(f, "employee deleted successfully");
				String query = "delete  from employee where name='"+name+"' and id='"+id+"';";
				st.executeUpdate(query);
				fid.setText("");
				fname.setText("");
				}
				
			}
			catch (Exception e1) {
				System.out.println(e1.getMessage());
			}
			
		}
		
	}
	
	    public static void main(String[] a) {
	        new adminDelEmp();
	    }

	}
