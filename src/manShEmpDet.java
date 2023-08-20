
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class manShEmpDet implements ActionListener {
	JFrame f=new JFrame("employee");   
	JButton back=new JButton("back");
	JLabel name,id,salr,rewar,abd;
  
	manShEmpDet(){
    name=new JLabel("NAME :");  
    name.setBounds(40,120,100,20);  
    id=new JLabel("OVER TIME :");  
    id.setBounds(40,170,100,30);  
    salr=new JLabel("SALARY :");  
    salr.setBounds(40,220,100,30);
    rewar=new JLabel("REWARDS :");  
    rewar.setBounds(40,270,100,30);
    abd=new JLabel("ABEDANCE :");  
    abd.setBounds(40,320,100,30);
    
    name.setForeground(Color.decode("#ffffff"));
    id.setForeground(Color.decode("#ffffff"));
    salr.setForeground(Color.decode("#ffffff"));
    rewar.setForeground(Color.decode("#ffffff"));
    abd.setForeground(Color.decode("#ffffff"));
	

    f.getContentPane().setBackground(Color.decode("#20333E"));
    f.add(name);
    f.add(id); 
    f.add(salr);
    f.add(rewar);
    f.add(back);  
    f.add(abd);
    f.setSize(600,600);  
    f.setLayout(null);  
    f.setVisible(true);   
    f.setResizable(false);
 
    back.setBounds(450,500,95,30);
    back.addActionListener(this);
    back.setFocusable(false);
}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back) {
			f.dispose();
			new managerFrame();
		}
		
	}  
	public static void main(String[] a) {
        new manShEmpDet();
    
}
}
