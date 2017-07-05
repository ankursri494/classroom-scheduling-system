package com.css.controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
//import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.css.controller.trainer.TrainerDashboardController;
import com.css.controller.admin.AdminDashboardController;
import com.css.controller.student.StudentDashboardController;
import com.css.model.StudentVO;
import com.css.model.TrainerVO;
import com.css.service.AdminService;
import com.css.service.StudentService;
import com.css.service.TrainerService;

public class Login implements ActionListener{
	JFrame frame;
	JPanel panel;
	JLabel heading,email,password,role;
	JTextField emailTextfield;
	JPasswordField passwordTextfield;
	JButton login,back;
	JRadioButton admin,trainer,student;
	ButtonGroup roleGroup;
	
	public Login(){
		frame = new JFrame("Login Form");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(screenSize.width,screenSize.height);
		//frame.setSize(500, 500);
		frame.setResizable(false); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		//frame.setContentPane(new JLabel(new ImageIcon("D:\\Summer Training Project\\src\\com\\css\\controller\\WELCOME.jpeg")));

		panel = new JPanel();
		panel.setSize(screenSize.width,screenSize.height);
		//panel.setBounds(0,10,500,500);
		frame.add(panel);
		panel.setLayout(null);
		panel.setBackground(Color.cyan);
		
		heading = new JLabel("LOGIN FORM");
		heading.setBounds(35, 11, 320, 32);
		panel.add(heading);

		email = new JLabel("EMAIL ID / USER ID :");
		email.setBounds(65,60,186,23);
		panel.add(email);

		emailTextfield = new JTextField();
		emailTextfield.setBounds(65,85,250,20);
		panel.add(emailTextfield);

		password = new JLabel("PASSWORD :");
		password.setBounds(65,125,86,23);
		panel.add(password);

		passwordTextfield = new JPasswordField();
		passwordTextfield.setBounds(65,150,250,20);
		panel.add(passwordTextfield);
		
		role = new JLabel("ROLE :");
		role.setBounds(65,190,65,23);
		panel.add(role);
		
		//ImageIcon studentbutton = new ImageIcon("D:\\Summer Training Project\\img\\student.png");
		//student = new JRadioButton("STUDENT");
		//student.setBounds(200,300,studentbutton.getIconWidth(),studentbutton.getIconHeight());
		//student.setIcon(studentbutton); 
		//frame.add(student);
		
		admin = new JRadioButton("ADMIN");
		admin.setBounds(65, 220, 65,23);
		admin.setSelected(true);
		admin.setBackground(Color.cyan);
		
		trainer = new JRadioButton("TRAINER");
		trainer.setBounds(65,260,85,23);
		trainer.setBackground(Color.cyan);
		
		student = new JRadioButton("STUDENT");
		student.setBounds(65,300,85,23);
		student.setBackground(Color.cyan);
		
		roleGroup = new ButtonGroup();	
		roleGroup.add(admin);
		roleGroup.add(trainer);
		roleGroup.add(student);
		
		panel.add(admin);
		panel.add(trainer);
		panel.add(student);
		
		login = new JButton("LOGIN");
		login.setBounds(180,343,100,30);
		panel.add(login);
		login.addActionListener(this);

		back = new JButton("BACK");
		back.setBounds(334, 0, 66, 23);
		panel.add(back);
		back.addActionListener(this);

		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == back){
			frame.dispose();
			new Welcome();
		}
		else
		{
			String s1 = emailTextfield.getText();
			char[] s2 = passwordTextfield.getPassword();
			String p1 = new String(s2);
			
			if(trainer.isSelected())
			{
				TrainerService trainerService = new TrainerService();
				boolean bool = trainerService.authenticateTrainerService(s1,p1);
				if(bool){
					frame.dispose();
					TrainerVO trainerVO = trainerService.searchTrainer(s1);
					new TrainerDashboardController(trainerVO);
				}
				else
				{
					JOptionPane.showMessageDialog(login, "Email / User ID or Password Not Correct");	
				}
			}
			else if(admin.isSelected())
			{
				AdminService adminService = new AdminService();
				boolean bool = adminService.authenticateAdminService(s1,p1);
				if(bool){
					new AdminDashboardController();
				}
				else
				{
					JOptionPane.showMessageDialog(login, "Email / User ID or Password Not Correct");	
				}

			}
			else
			{
				StudentService studentService = new StudentService();
				boolean bool = studentService.authenticateStudentService(s1,p1);
				if(bool){
					StudentVO studentVO = studentService.searchStudent(s1);
					new StudentDashboardController(studentVO);
				}
				else
				{
					JOptionPane.showMessageDialog(login, "Email / User ID or Password Not Correct");	
				}	
			}
		}
	}
}
