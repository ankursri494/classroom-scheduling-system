package com.css.controller;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Welcome implements ActionListener {
	JFrame frame;
	JLabel heading;
	JButton login,register;
	
	Welcome(){
		frame = new JFrame("CAMPUS CONNECT CLASSROOM SCHEDULING SYSTEM");
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(screenSize.width,screenSize.height);
		//frame.setSize(2590,1619); 
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setContentPane(new JLabel(new ImageIcon("D:\\Summer Training Project\\img\\welcome.jpeg")));

		ImageIcon loginbutton = new ImageIcon("D:\\Summer Training Project\\img\\loginbutton.png");
		login = new JButton();
		login.setBounds(250,500,loginbutton.getIconWidth(),loginbutton.getIconHeight());
		login.setIcon(loginbutton); 
		frame.add(login);
		
		ImageIcon registerbutton = new ImageIcon("D:\\Summer Training Project\\img\\registerbutton.jpg");
		register = new JButton();
		register.setBounds(700,500,registerbutton.getIconWidth(),registerbutton.getIconHeight());
		register.setIcon(registerbutton); 
		frame.add(register);
		
		register.addActionListener(this);
		login.addActionListener(this);
		
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==login){
			frame.dispose();
			new Login();
		}
		else{
			frame.dispose();
			new Registration();
		}
	}
	
public static void main(String[] args) {
		new Welcome();
	}
}
