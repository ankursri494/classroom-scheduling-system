package com.css.controller.student;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.css.model.StudentVO;

public class StudentDashboardController {
JFrame frame;
JPanel panel1,panel2;	
JTextField nameTextField,idTextField,emailTextField;
	public StudentDashboardController(StudentVO studentVO){
		
		frame = new JFrame("Student Dashboard");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(screenSize.width,screenSize.height);
		//frame.setSize(500, 500);
		frame.setResizable(false); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		//frame.setContentPane(new JLabel(new ImageIcon("D:\\Summer Training Project\\src\\com\\css\\controller\\WELCOME.jpeg")));
		
		panel1 = new JPanel();
		panel1.setBounds(0,0,400,500);
		frame.add(panel1);
		panel1.setLayout(null);
		panel1.setBackground(Color.lightGray);

		
		JLabel heading = new JLabel("STUDENT DASHBOARD");
		heading.setBounds(105, 11, 292, 32);
		panel1.add(heading);
		
		JLabel name = new JLabel("STUDENT NAME :");
		name.setBounds(28, 54, 46, 14);
		panel1.add(name);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(129, 54, 156, 20);
		panel1.add(nameTextField); nameTextField.setText(studentVO.getStudentName()); nameTextField.setEditable(false);
		nameTextField.setColumns(20);
		
		JLabel email = new JLabel("STUDENT EMAIL ID :");
		email.setBounds(28, 90, 69, 14);
		panel1.add(email);
		
		emailTextField = new JTextField();
		emailTextField.setBounds(129, 90, 156, 20);
		panel1.add(emailTextField); emailTextField.setText(studentVO.getStudentEmail()); emailTextField.setEditable(false); 
		emailTextField.setColumns(20);
		
		JLabel id = new JLabel("STUDENT ID :");
		id.setBounds(28, 130, 69, 14);
		panel1.add(id);
		
		idTextField = new JTextField();
		idTextField.setBounds(129, 130, 156, 20);
		panel1.add(idTextField); idTextField.setText(Integer.toString(studentVO.getStudentId())); idTextField.setEditable(false);
		idTextField.setColumns(20);
		
		frame.setVisible(true); 
		
		JOptionPane.showMessageDialog(frame, "Welcome "+studentVO.getStudentName()); 
	}

}