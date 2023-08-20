import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*; 
public class managerFrame extends JFrame implements ActionListener {
      
  
	JFrame f=new JFrame("manager");
	
	JButton modbtn=new JButton("modify"); 
	JButton shbtn=new JButton("show employee"); 
	JButton planbtn=new JButton("plans");
	JButton bakbtn=new JButton("log out");

	
managerFrame(){

	shbtn.setBounds(45,255,121,30); 
	shbtn.setFocusable(false);
	
	modbtn.setBounds(230,255,121,30); 
	modbtn.setFocusable(false);
	
    planbtn.setBounds(422,255,121,30);
    planbtn.setFocusable(false);
    
    bakbtn.setBounds(450,500,95,30);
    bakbtn.setFocusable(false);
    
    f.add(modbtn);  
    f.add(planbtn);
    f.add(bakbtn);
    f.add(shbtn);
    
    f.setSize(600,600);  
    f.setLayout(null);  
    f.setVisible(true);   
    
    modbtn.addActionListener(this);
    planbtn.addActionListener(this);
    bakbtn.addActionListener(this);
    shbtn.addActionListener(this);
    

    colors();
}


public void colors() {
	f.getContentPane().setBackground(Color.decode("#20333E"));
}

@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource() == modbtn) {
		f.dispose();
		manSpecEmpToSh as=new manSpecEmpToSh ();
		 as.manSpecEmpToSh();
	}
	else if(e.getSource() == bakbtn) {
		f.dispose();
		new LoginFrame();
	}
	else if(e.getSource()==planbtn) {
		f.dispose();
		new managPlan();
	}
	else if(e.getSource()==shbtn) {
		f.dispose();
		new manShEmpDet();
		
	}
	
}
public static void main(String[] a) {
	new managerFrame();
}


 
    
}