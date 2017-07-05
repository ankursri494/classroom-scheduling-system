package com.css.controller.trainer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class Trainer {

	public JFrame frame;
	public JPanel panel;
	public JPasswordField passwordField,confirmPasswordField;
	public JTextField nameTextField, idTextField,ageTextField,emailTextField,qualificationTextField;
	public JRadioButton male,female;
	public ButtonGroup genderGroup;
	public JList<String> trainings;
	public JCheckBox agree;
	
	public Trainer(){
		
		frame = new JFrame("Registration Form");
		Dimension sceensize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(sceensize.width, sceensize.height);
		//frame.setSize(420,600);
		frame.setResizable(false);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);

		panel = new JPanel();
		panel.setBounds(0,0,420,600);
		frame.add(panel);
		panel.setLayout(null);
		panel.setBackground(Color.lightGray);
		
		JLabel id = new JLabel("Trainer Id :");
		id.setBounds(28,11,66,14);
		panel.add(id);
		
		idTextField = new JTextField();
		idTextField.setBounds(169, 11, 155, 20);
		panel.add(idTextField);
		idTextField.setColumns(10);
		
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
		
		JLabel age = new JLabel("Age :");
		age.setBounds(28, 197, 98, 14);
		panel.add(age);
		
		ageTextField = new JTextField();
		ageTextField.setBounds(169, 197, 156, 20);
		panel.add(ageTextField);
		ageTextField.setColumns(10);
		
		JLabel gender = new JLabel("Gender :");
		gender.setBounds(28, 237, 56, 14);
		panel.add(gender);
		
		male = new JRadioButton("MALE");
		male.setSelected(true);
		male.setBounds(172, 237, 74, 20);
		male.setBackground(Color.lightGray);
		female = new JRadioButton("FEMALE");
		female.setBounds(242, 237, 80, 20);
		female.setBackground(Color.lightGray);			
		genderGroup = new ButtonGroup();
		genderGroup.add(male);
		genderGroup.add(female);
		
		panel.add(male);
		panel.add(female);
		
		JLabel qualification = new JLabel("Qualification :");
		qualification.setBounds(28, 277, 131, 14);
		panel.add(qualification);
		
		qualificationTextField  = new JTextField();
		qualificationTextField.setBounds(169, 277, 156, 20);
		panel.add(qualificationTextField);
		qualificationTextField.setColumns(10);
		
		JLabel training = new JLabel("Trainings Offered :");
		training.setBounds(28, 317, 135, 15);
		panel.add(training);
		
		DefaultListModel<String> d1 = new DefaultListModel<>();
		d1.addElement("a");
		d1.addElement("b");
		d1.addElement("c");
		d1.addElement("d");
		d1.addElement("e");
		trainings = new JList<>(d1);
		trainings.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		trainings.setVisibleRowCount(2);
		JScrollPane sp = new JScrollPane(trainings);
		sp.setBounds(165, 317, 156, 60);
		panel.add(sp);
		
		agree = new JCheckBox("I Agree to the terms and condition");
		agree.setBounds(28,407,450,15);
		agree.setBackground(Color.lightGray);
		panel.add(agree);
		
		frame.setVisible(true);
	}
}
