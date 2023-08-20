
 import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*; 
public class adminChoice extends JFrame implements ActionListener {
      
	JFrame f=new JFrame("admin");  
	JButton addnew=new JButton("add new"); 
	JButton modify=new JButton("modify");
	JButton delete=new JButton("delete");
	JButton bak=new JButton("log out");
  
adminChoice(){
	f.getContentPane().setBackground(Color.decode("#20333E"));
//	userLabel.setForeground(Color.decode("#ffffff"));
	
    addnew.setBounds(110,250,95,30); 
    addnew.setFocusable(false);
    modify.setBounds(240,250,95,30);
    modify.setFocusable(false);
    delete.setBounds(360,250,95,30);
    delete.setFocusable(false);

    bak.setBounds(450,500,95,30);
    bak.setFocusable(false);
    
    f.add(addnew);  
    f.add(modify);
    f.add(delete);
    f.add(bak);
    f.setSize(600,600);  
    f.setLayout(null);  
    f.setVisible(true);   
    f.setResizable(false);
    
    addnew.addActionListener(this);
    modify.addActionListener(this);
    delete.addActionListener(this);
    bak.addActionListener(this);
 
}

@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==addnew) {
		f.dispose();
		new adminFrame();
	}
	else if(e.getSource()==modify) {
		f.dispose();
		adminSpecEmpToMod asem=new adminSpecEmpToMod();
		asem.AdminSpecEmpToMod();
	}
	else if(e.getSource()==delete) {
		f.dispose();
		new adminDelEmp();
	}
	else if(e.getSource()==bak) {
		f.dispose();
		new LoginFrame();
	}
	
}  
//public static void main(String[] a) {
//    new adminChoice();
//}
    
}
