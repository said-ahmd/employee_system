

import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
import java.sql.*;

@SuppressWarnings("serial")
public class manModEmp extends adminSpecEmpToMod implements ActionListener {
	// JFrame frame = new JFrame();
	// connection info
	String url = "jdbc:mysql://localhost:3305/javap";
	String uname = "root";
	String passs = "said";
	//
	JFrame f = new JFrame();

	JButton add = new JButton("modify");
	JButton bakbtn = new JButton("back");

	JLabel name = new JLabel("Name");
	JLabel id = new JLabel("ID");
	JLabel pass = new JLabel("Pass");
	JLabel age = new JLabel("Age");
	JLabel address = new JLabel("Address");
	JLabel phone = new JLabel("Phone");

	JTextField fname = new JTextField();
	JTextField fid = new JTextField();
	JTextField fpass = new JTextField();
	JTextField fage = new JTextField();
	JTextField fphone = new JTextField();
	JTextField faddress = new JTextField();

	manModEmp() {

		f.setTitle("modify empployee");
		f.setVisible(true);
		f.setSize(600, 600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.getContentPane().setBackground(Color.decode("#20333E"));

		f.setLayout(null);

		name.setBounds(90, 90, 100, 20);
		id.setBounds(90, 140, 100, 30);
		pass.setBounds(90, 190, 100, 30);
		age.setBounds(90, 240, 100, 30);
		phone.setBounds(90, 290, 100, 30);
		address.setBounds(90, 340, 100, 30);
		

		name.setForeground(Color.decode("#ffffff"));
		id.setForeground(Color.decode("#ffffff"));
		pass.setForeground(Color.decode("#ffffff"));
		age.setForeground(Color.decode("#ffffff"));
		phone.setForeground(Color.decode("#ffffff"));
		address.setForeground(Color.decode("#ffffff"));

		fname.setBounds(180, 90, 200, 30);
		fid.setBounds(180, 140, 200, 30);
		fpass.setBounds(180, 190, 200, 30);
		fage.setBounds(180, 240, 200, 30);
		fphone.setBounds(180, 290, 200, 30);
		faddress.setBounds(180, 340, 200, 30);

		f.add(name);
		f.add(pass);
		f.add(id);
		f.add(age);
		f.add(address);
		f.add(phone);

		f.add(fname);
		f.add(fid);
		f.add(fpass);
		f.add(fage);
		f.add(faddress);
		f.add(fphone);

		add.setBounds(220, 390, 100, 30);
		add.setFocusable(false);
		add.addActionListener(this);
		f.add(add);

		bakbtn.setBounds(450, 500, 95, 30);
		bakbtn.setFocusable(false);
		bakbtn.addActionListener(this);
		f.add(bakbtn);

	}

	@Override
    public void actionPerformed(ActionEvent a) {
		
    	String name = fname.getText().toString();
    	String id = fid.getText().toString();
    	String pass = fpass.getText().toString();
    	String age = fage.getText().toString();
    	String address = faddress.getText().toString();
    	String phone = fphone.getText().toString();
    	
        if(a.getSource()==add){
        	if(name.length()==0&&id.length()==0&&age.length()==0&&pass.length()==0) {
        	 JOptionPane.showMessageDialog(f, "enter any data please \"at least one field\" ");
        }
        	else {//
        		try {
        		Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(url, uname, passs);
				Statement st = con.createStatement();
				
				//lastin
				String q="SELECT id FROM lastin";
				ResultSet lastid =st.executeQuery(q);
				lastid.next();
				String i_d=lastid.getString("id");
				
				if(name.length()!=0) {
					String query= (" update employee set name= '"+name+"' where id= '"+i_d+"' " );
					st.executeUpdate(query);
					
				}
				if(id.length()!=0) {
					System.out.println(name);
					String query= (" update employee set id= '"+id+"' where name= '"+name+"' " );
					st.executeUpdate(query);
				}
				if(pass.length()!=0) {
				System.out.println(1);
					String query= (" update employee set pass= '"+pass+"' where name= '"+name+"' " );
					st.executeUpdate(query);
				}
				if(age.length()!=0) {
					System.out.println(1);
					String query= (" update employee set age= '"+age+"' where name= '"+name+"' " );
					st.executeUpdate(query);
				}
				if(phone.length()!=0) {
					System.out.println(1);
					String query= (" update employee set phone= '"+phone+"' where name= '"+name+"' " );
					st.executeUpdate(query);
				}
				if(address.length()!=0) {
					System.out.println(1);
					String query= (" update employee set address= '"+address+"' where name= '"+name+"' " );
					st.executeUpdate(query);
				}
				JOptionPane.showMessageDialog(f, "data modified successfully");
				faddress.setText("");fphone.setText("");fage.setText("");fname.setText("");fid.setText("");fpass.setText("");
				st.close();
				con.close();
        		}
				catch (Exception e1) {
				System.out.println(e1.getMessage());
					}
        		}
        		
        	}
        
        else if(a.getSource()==bakbtn) {
        	f.dispose();
        	new managerFrame();
        }
    }

	public static void main(String[] a) {
		new manModEmp();
	}
}
