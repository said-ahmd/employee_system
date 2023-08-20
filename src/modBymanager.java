

import javax.swing.*;
import java.awt.event.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;


@SuppressWarnings("serial")
public class modBymanager extends JFrame implements ActionListener {
  //  JFrame frame = new JFrame();
    
    JButton add = new JButton("add");
    JButton bakbtn=new JButton("back");

    JLabel name = new JLabel("Name");
    JLabel id = new JLabel("ID");
    JLabel pass = new JLabel("pass");
    JLabel slr = new JLabel("Salary");
    JLabel age = new JLabel("Age");
    
    JTextField fname = new JTextField();
    JTextField fid = new JTextField();
    JTextField fpass = new JTextField();
    JTextField fslr = new JTextField();
    JTextField fage = new JTextField();
    
    modBymanager(){
    	
    	this.setTitle("modify empployee");
		this.setVisible(true);
		this.setSize(600, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
    	
    	
        setLayout(null);
        
        name.setBounds(40,50,100,20);
        add(name);
       
        fname.setBounds(125,45,200,30);
        add(fname);
        
        id.setBounds(40,100,100,30);
        add(id);
        
        fid.setBounds(125,100,200,30);
        add(fid);
        
        pass.setBounds(40,150,100,30);
        add(pass);
        
        fpass.setBounds(125,150,200,30);
        add(fpass);
        
        slr.setBounds(40,200,100,30);
        add(slr);
        
        fslr.setBounds(125,200,200,30);
        this.add(fslr);
        
        age.setBounds(40,250,100,30);
        add(age);
        
        fage.setBounds(125,250,200,30);
        add(fage);
        
        bakbtn.setBounds(450,500,95,30);
        bakbtn.setFocusable(false);
        bakbtn.addActionListener(this);
        add(bakbtn);
        
        
        add.setBounds(173,300,100,30);
        add.setFocusable(false);
        add.addActionListener(this);
        add(add);
        
        
        
    }   

    @Override
    public void actionPerformed(ActionEvent a) {
    	String ss1 = fname.getText().toString();
    	String ss2 = fid.getText().toString();
    	String ss3 = fpass.getText().toString();
    	String ss4 = fslr.getText().toString();
    	String ss5 = fage.getText().toString();
        if(a.getSource()==add){
        	if(ss1.length()==0||ss2.length()==0||ss3.length()==0||ss4.length()==0||ss5.length()==0) {
        	 JOptionPane.showMessageDialog(this, "enter all data please");
        	}
        	else {
        		 JOptionPane.showMessageDialog(this, "emplyee added succesfully");
        	}
        }
        else if(a.getSource()==bakbtn) {
        	this.dispose();
        	new managerFrame();
        }
    }
       
}