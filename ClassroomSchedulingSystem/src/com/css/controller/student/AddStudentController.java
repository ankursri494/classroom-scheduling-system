package com.css.controller.student;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.css.controller.Registration;
import com.css.model.StudentVO;
import com.css.model.TrainerVO;
import com.css.service.StudentService;
import com.css.service.TrainerService;

public class AddStudentController implements ActionListener {
		
	JFrame frame;
	JPanel panel;
	JTextField nameTextField;
	JTextField ageTextField;
	JPasswordField passwordField;                                                              
	JPasswordField confirmPasswordField;
	JTextField emailTextField;
	JCheckBox agree;
	JButton btnSubmit;
	JButton btnReset;
	JButton btnBack;
	
	public AddStudentController() {
		// TODO Auto-generated constructor stub
	
		frame = new JFrame("Student Registration Form");
		frame.setSize(400,500);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);

		panel = new JPanel();
		panel.setBounds(0,0,400,500);
		frame.add(panel);
		panel.setLayout(null);
		panel.setBackground(Color.lightGray);

		
		JLabel heading = new JLabel("STUDENT'S REGISTRATION FORM");
		heading.setBounds(105, 11, 292, 32);
		panel.add(heading);

		JLabel name = new JLabel("Name :");
		name.setBounds(28, 54, 46, 14);
		panel.add(name);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(169, 54, 156, 20);
		panel.add(nameTextField);
		nameTextField.setColumns(10);
		
		JLabel email = new JLabel("Email ID :");
		email.setBounds(28, 90, 69, 14);
		panel.add(email);
		
		emailTextField = new JTextField();
		emailTextField.setBounds(169, 90, 156, 20);
		panel.add(emailTextField);
		emailTextField.setColumns(10);
		
		JLabel password = new JLabel("Create Password :");
		password.setBounds(28, 127, 131, 14);
		panel.add(password);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(169, 127, 156, 20);
		panel.add(passwordField);
		
		JLabel confirmPassword = new JLabel("Confirm Password :");
		confirmPassword.setBounds(28, 162, 131, 14);
		panel.add(confirmPassword);
		
		confirmPasswordField = new JPasswordField();
		confirmPasswordField.setBounds(169, 162, 156, 20);
		panel.add(confirmPasswordField);
		
		agree = new JCheckBox("I Agree to the terms and condition");
		agree.setBounds(28,407,450,15);
		agree.setBackground(Color.lightGray);
		panel.add(agree);
		
		btnSubmit = new JButton("SUBMIT");
		btnSubmit.setBounds(103, 437, 86, 23);
		panel.add(btnSubmit);
		btnSubmit.addActionListener(this);
		
		btnReset = new JButton("RESET");
		btnReset.setBounds(203, 437, 76, 23);
		panel.add(btnReset);
		btnReset.addActionListener(this);
		
		btnBack = new JButton("BACK");
		btnBack.setBounds(334, 0, 66, 23);
		panel.add(btnBack);
		btnBack.addActionListener(this);
		
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		StudentVO studentVO = new StudentVO();
		if(e.getSource() == btnSubmit)
		{
			int x = 0; int y;

				String s1 = nameTextField.getText();
				String s2 = emailTextField.getText();
				char[] s3 = passwordField.getPassword();
				char[] s4 = confirmPasswordField.getPassword();
				String s5 = new String(s3);
				String s6 = new String(s4);
				
				studentVO.setStudentName(s1);
				studentVO.setStudentEmail(s2);
				studentVO.setStudentPassword(s5);
				
				if(!s1.isEmpty() && !s2.isEmpty() && !s5.isEmpty())
				{
					if(s5.equals(s6))
					{
						if(agree.isSelected())
						{
							StudentService studentService = new StudentService();
							x = studentService.addStudentService(studentVO);
							if(x>0)
							{		
								y=studentService.getStudentIdService();
								JOptionPane.showMessageDialog(btnSubmit, "You are Successfully Registered!! Your user id is :" +y);
							}
						}
						else
						{
							JOptionPane.showMessageDialog(btnSubmit, "Confirm that you agree to the terms and conditions");	
						}
					}
					else
					{
						JOptionPane.showMessageDialog(btnSubmit, "Password Does Not Match");	
					}
				}
				else
				{
					JOptionPane.showMessageDialog(btnSubmit, "Please Fill all the details!!");	
				}
		}
		else if(e.getSource() == btnReset)
		{
			nameTextField.setText("");
			emailTextField.setText("");
			passwordField.setText("");
			confirmPasswordField.setText("");
		}
		else
		{
			frame.dispose();
			new Registration();
		}
		

	}
	
	public static void main(String[] args) {
		new AddStudentController();
	}
}
