
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
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class managPlan implements ActionListener {
	// connection info
		String url = "jdbc:mysql://localhost:3305/javap";
		String uname = "root";
		String pass = "said";
		//
		
	JFrame f = new JFrame("manager");
	JButton savebtn = new JButton("save");
	JButton bakbtn = new JButton("back");
	JTextField fname = new JTextField();
	JTextField fdate = new JTextField();
	JTextArea fplan = new JTextArea();
	JLabel name, date, plan;

	managPlan() {
		fname.setText("");
		fdate.setText("");
		fplan.setText("");

		name = new JLabel("Name of plan :");
		name.setBounds(65, 70, 100, 20);
		name.setForeground(Color.decode("#ffffff"));
		date = new JLabel("Date :");
		date.setBounds(65, 120, 100, 30);
		date.setForeground(Color.decode("#ffffff"));
		plan = new JLabel("Plan :");
		plan.setBounds(65, 170, 100, 30);
		plan.setForeground(Color.decode("#ffffff"));

		fname.setBounds(155, 65, 200, 30);
		fdate.setBounds(155, 120, 200, 30);
		fplan.setBounds(155, 170, 350, 150);

		savebtn.setBounds(240, 360, 95, 30);
		savebtn.addActionListener(this);
		bakbtn.setBounds(450, 500, 95, 30);
		bakbtn.addActionListener(this);

		f.add(name);
		f.add(date);
		f.add(plan);
		f.add(fname);
		f.add(fdate);
		f.add(fplan);
		f.add(savebtn);
		f.add(bakbtn);
		f.getContentPane().setBackground(Color.decode("#20333E"));
		f.setResizable(false);
		f.setSize(600, 600);
		f.setLayout(null);
		f.setVisible(true);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String sname=fname.getText().toString();
		String sdate=fdate.getText().toString();
		String splane=fplan.getText().toString();

		if (e.getSource() == savebtn) {
			if(sname.length()==0||sdate.length()==0||splane.length()==0) {
				JOptionPane.showMessageDialog(f, "please enter data");
			}
			else {
				JOptionPane.showMessageDialog(f, "employee added successfully");
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection(url, uname, pass);
					Statement st = con.createStatement();
					
					// my query to run
					String query = "insert into plqns (name,date,plan) values('"+sname+"' ,'"+sdate+"' ,'"+splane+"' );";
					fname.setText(""); fdate.setText(""); fplan.setText("");
					st.executeUpdate(query);
					
				}
				catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
		}
			}
		else if(e.getSource() == bakbtn) {
			f.dispose();
			new managerFrame();
		}
	}
	public static void main(String[] a) {
        new managPlan();
    }

}
