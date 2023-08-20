
import java.awt.Color;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class empDetails implements ActionListener {
	// connection info
	String url = "jdbc:mysql://localhost:3305/javap";
	String uname = "root";
	String upass = "said";
	//
	JFrame f=new JFrame("employee");   
	JButton back=new JButton("back");
	JButton show=new JButton("show");
	JLabel name,id,salr,rewar,oname=new JLabel(),oid=new JLabel(),osalr=new JLabel(),orewar=new JLabel();
  
	empDetails(){
    name=new JLabel("NAME :");  
    name.setBounds(40,120,100,20);  
    id=new JLabel("ID :");  
    id.setBounds(40,170,100,30);  
    salr=new JLabel("SALARY :");  
    salr.setBounds(40,220,100,30);
    rewar=new JLabel("REWARDS :");  
    rewar.setBounds(40,270,100,30);
    
    oname.setBounds(88,110,100,40);
    oid.setBounds(65,165,100,40);
    osalr.setBounds(98,215,100,40);
    orewar.setBounds(112,265,100,40);
    
    name.setForeground(Color.decode("#ffffff"));
    id.setForeground(Color.decode("#ffffff"));
    salr.setForeground(Color.decode("#ffffff"));
    rewar.setForeground(Color.decode("#ffffff"));
    oname.setForeground(Color.decode("#ffffff"));
    oid.setForeground(Color.decode("#ffffff"));
    osalr.setForeground(Color.decode("#ffffff"));
    orewar.setForeground(Color.decode("#ffffff"));
	

    f.getContentPane().setBackground(Color.decode("#20333E"));
    f.add(name);
    f.add(id); 
    f.add(salr);
    f.add(rewar);
    f.add(oname);
    f.add(oid); 
    f.add(osalr);
    f.add(orewar);
  
    show.setBounds(230,350,95,30);
    show.addActionListener(this);
    show.setFocusable(false);
    show.addActionListener(this);
    back.setBounds(450,500,95,30);
    back.addActionListener(this);
    back.setFocusable(false);

    f.add(show);
    f.add(back);  

    f.setSize(600,600);  
    f.setLayout(null);  
    f.setVisible(true);   
    f.setResizable(false);
    
	
}		
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back) {
			f.dispose();
			new empFrame();
		}
		else if(e.getSource()==show) {
			try {
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(url, uname, upass);
				String query = "SELECT * FROM datae;";
				Statement st = con.prepareStatement(query);
				
				// my query to run
				ResultSet rs = st.executeQuery(query);
				rs.next();
					String n=rs.getString(1);
					String i=rs.getString(2);
					String s=rs.getString(3);
					String r=rs.getString(4);
					
					oname.setText(n);
					oid.setText(i);
					osalr.setText(s);
					orewar.setText(r);
				
			}
			catch (Exception e1) {
				System.out.println(e1.getMessage());
			}
		}
		}
		
	 
	 public static void main(String[] a) {
	        new empDetails();
	    }

}
