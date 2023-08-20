
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;



public class adminFrame extends JFrame implements ActionListener {
	// connection info
		String url = "jdbc:mysql://localhost:3305/javap";
		String uname = "root";
		String upass = "said";
		//
	JPanel panel = new JPanel();
	JTextField name = new JTextField();
	JTextField pass = new JTextField();
	JTextField depart = new JTextField();
	JTextField add = new JTextField();
	JTextField id = new JTextField();
	JTextField age = new JTextField();
	JTextField phon = new JTextField();
	
	JLabel lname = new JLabel("Name");
	JLabel lpass = new JLabel("password");
	JLabel ldepart = new JLabel("depart");
	JLabel ladd = new JLabel("Address");
	JLabel lid = new JLabel("ID");
	JLabel lage = new JLabel("Age");
	JLabel lphon = new JLabel("Phone");
	
	JLabel l11 = new JLabel("*");
	JLabel l22 = new JLabel("*");
	JLabel l33 = new JLabel("*");
	JLabel l44 = new JLabel("*");
	JLabel l55 = new JLabel("*");
	JLabel l66 = new JLabel("*");
	JLabel l77 = new JLabel("*");
	
	JLabel gen = new JLabel("Gender");
	JLabel stat = new JLabel("Status");

	JRadioButton r1 = new JRadioButton("Male");
	JRadioButton r2 = new JRadioButton("Female");
	JRadioButton r3 = new JRadioButton("Single");
	JRadioButton r4 = new JRadioButton("Married");
	JRadioButton r5 = new JRadioButton("Divorced");
	JRadioButton r6 = new JRadioButton("widow");

	//ButtonGroup g1 = new ButtonGroup();
	//ButtonGroup g2 = new ButtonGroup();
	
	JButton addbtn = new JButton("Add");
	JButton bakbtn = new JButton("back");

	public adminFrame() {

		this.setTitle("admin");
		this.setVisible(true);
		this.setSize(600, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		panel.setBackground(Color.decode("#20333E"));
		panel.setLayout(null);
		panel.setBounds(0, 0, 600, 600);
		this.add(panel);
		//labels
		lname.setBounds(90, 10, 50, 30);
		lpass.setBounds(90, 60, 50, 30);
		ldepart.setBounds(90, 110, 50, 30);
		ladd.setBounds(90, 160, 50, 30);
		lid.setBounds(90, 210, 50, 30);
		lage.setBounds(90, 260, 50, 30);
		lphon.setBounds(90, 310, 50, 30);
		//
		
		//red dot
		l11.setBounds(80, 10, 10, 30);
		l22.setBounds(80, 60, 10, 30);
		l33.setBounds(80, 110, 10, 30);
		l44.setBounds(80, 160, 10, 30);
		l55.setBounds(80, 210, 10, 30);
		l66.setBounds(80, 260, 10, 30);
		l77.setBounds(80, 310, 10, 30);

		l11.setForeground(Color.white);
		l22.setForeground(Color.white);
		l33.setForeground(Color.white);
		l44.setForeground(Color.white);
		l55.setForeground(Color.white);
		l66.setForeground(Color.white);
		l77.setForeground(Color.white);
		//
		
		//fields
		name.setBounds(180, 10, 190, 30);
		age.setBounds(180, 60, 190, 30);
		add.setBounds(180, 110, 190, 30);
		id.setBounds(180, 160, 190, 30);
		phon.setBounds(180, 210, 190, 30);
		pass.setBounds(180, 260, 190, 30);
		depart.setBounds(180, 310, 190, 30);
		//
		
		//label
		panel.add(lname);
		panel.add(lpass);
		panel.add(ldepart);
		panel.add(ladd);
		panel.add(lid);
		panel.add(lage);
		panel.add(lphon);
		//dot
		panel.add(l11);
		panel.add(l22);
		panel.add(l33);
		panel.add(l44);
		panel.add(l55);
		panel.add(l66);
		panel.add(l77);
		//field
		panel.add(name);
		panel.add(pass);
		panel.add(depart);
		panel.add(add);
		panel.add(id);
		panel.add(age);
		panel.add(phon);
		
		//gen group
		gen.setBounds(50, 360, 50, 30);
		r1.setBounds(180, 360, 60, 30);
		r2.setBounds(250, 360, 70, 30);
		//
		
		//state group
		stat.setBounds(50, 410, 70, 30);
		r3.setBounds(180, 410, 70, 30);
		r4.setBounds(260, 410, 70, 30);
		r5.setBounds(340, 410, 80, 30);
		r6.setBounds(430, 410, 70, 30);
		//
		
		//gen chose group
		//g1.add(r1);
		//g1.add(r2);
		//
		
		//state choose group
		//g2.add(r3);
		//g2.add(r4);
		//g2.add(r5);
		//g2.add(r6);
		//
		
		
		addbtn.setBounds(250, 460, 100, 30);
		bakbtn.setBounds(450, 500, 95, 30);


		panel.add(r1);
		panel.add(r2);
		panel.add(gen);
		
		panel.add(r3);
		panel.add(r4);
		panel.add(r5);
		panel.add(r6);
		panel.add(stat);
		
		panel.add(addbtn);
		panel.add(bakbtn);

		addbtn.addActionListener(this);
		bakbtn.addActionListener(this);
		
		colors();
	}
	
	void colors() {



		r1.setBackground(Color.decode("#20333E"));
		r2.setBackground(Color.decode("#20333E"));
		r3.setBackground(Color.decode("#20333E"));
		r4.setBackground(Color.decode("#20333E"));
		r5.setBackground(Color.decode("#20333E"));
		r6.setBackground(Color.decode("#20333E"));
	 
		r1.setForeground(Color.decode("#ffffff"));
		r2.setForeground(Color.decode("#ffffff"));
		r3.setForeground(Color.decode("#ffffff"));
		r4.setForeground(Color.decode("#ffffff"));
		r5.setForeground(Color.decode("#ffffff"));
		r6.setForeground(Color.decode("#ffffff"));
		
		r1.setFocusable(false);
		r2.setFocusable(false);
		r3.setFocusable(false);
		r4.setFocusable(false);
		r5.setFocusable(false);
		r6.setFocusable(false);
		

		stat.setForeground(Color.decode("#ffffff"));
		gen.setForeground(Color.decode("#ffffff"));
		lname.setForeground(Color.decode("#ffffff"));
		lpass.setForeground(Color.decode("#ffffff"));
		ldepart.setForeground(Color.decode("#ffffff"));
		ladd.setForeground(Color.decode("#ffffff"));
		lid.setForeground(Color.decode("#ffffff"));
		lage.setForeground(Color.decode("#ffffff"));
		lphon.setForeground(Color.decode("#ffffff"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		

		String na = name.getText().toString();
		String pa = pass.getText().toString();
		String db = depart.getText().toString();
		String ag = age.getText().toString();
		String ad = add.getText().toString();
		String i_d = id.getText().toString();
		String ph = phon.getText().toString();
		if (e.getSource() == addbtn) {
			if (na.length() == 0 || ag.length() == 0 || ad.length() == 0 || i_d.length() == 0 || ph.length() == 0 || pa.length() == 0) {
				JOptionPane.showMessageDialog(this, "please enter all data");
				
			} else {
				JOptionPane.showMessageDialog(this, "employee added successfully");
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection(url, uname, upass);
					Statement st = con.createStatement();
					
					// my query to run
					String query = "insert into employee (name,pass,depart,address,id,phone,age) values('"+na+"' ,'"+ag+"' ,'"+ad+"' ,'"+i_d +"' ,'"+ ph+ "' ,'"+db+"' ,'"+pa+"' );";
					name.setText(""); pass.setText(""); depart.setText(""); age.setText(""); add.setText(""); id.setText(""); phon.setText("");
					st.executeUpdate(query);
					
				}
				catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
			}

		}
		else if(e.getSource()==bakbtn) {
			dispose();
			new adminChoice();
		}

	}
	 public static void main(String[] a) {
	        new adminFrame();
	    }
	
}
