
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class empFrame implements ActionListener {

	JFrame f = new JFrame("employee");

	JButton detail = new JButton("details");
	JButton compl = new JButton("complain");
	JButton bak = new JButton("log out");

	empFrame() {

		detail.setBounds(170,250,95,30); 
		detail.addActionListener(this);
		detail.setFocusable(false);
		compl.setBounds(300,250,95,30); 
		compl.addActionListener(this);
		compl.setFocusable(false);
		bak.setBounds(450, 500, 95, 30);
		bak.addActionListener(this);
		bak.setFocusable(false);

		f.getContentPane().setBackground(Color.decode("#20333E"));
		f.add(detail);
		f.add(compl);
		f.add(bak);
		f.setSize(600, 600);
		f.setLayout(null);
		f.setVisible(true);
		f.setResizable(false);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bak) {
			f.dispose();
			new LoginFrame();
		}
		if (e.getSource() == detail) {
			f.dispose();
			new empDetails();
		}
		if (e.getSource() == compl) {
			f.dispose();
			new empComp();

		}

	}

//	public static void main(String[] a) {
//		new empFrame();
//
//	}

}
