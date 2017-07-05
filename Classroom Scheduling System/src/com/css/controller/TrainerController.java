package com.css.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import com.css.model.TrainerVO;
import com.css.service.TrainerService;

public class TrainerController implements  ActionListener{
	JFrame frame;
	JPanel panel;
	JTextField nameTextField;
	JTextField ageTextField;
	JPasswordField passwordField;                                                              
	JPasswordField confirmPasswordField;
	JTextField emailTextField;
	JRadioButton male,female;
	ButtonGroup genderGroup;
	JTextField qualificationTextField;
	JList<String> trainings;
	JCheckBox agree;
	JButton btnSubmit;
	JButton btnReset;
	JButton btnBack;
	
	public TrainerController(){
		
			frame = new JFrame("Registration Form");
			frame.setSize(400,500);
			frame.setResizable(false);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLayout(null);

			panel = new JPanel();
			panel.setBounds(0,0,400,500);
			frame.add(panel);
			panel.setLayout(null);
			panel.setBackground(Color.lightGray);

			
			JLabel heading = new JLabel("TRAINER'S REGISTRATION FORM");
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
			trainings.setVisibleRowCount(1);
			trainings.setSelectedIndex(0);
			JScrollPane sp = new JScrollPane(trainings);
			sp.setBounds(165, 317, 156, 60);
			panel.add(sp);
			
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
		TrainerVO trainerVO = new TrainerVO();
		if(e.getSource() == btnSubmit)
		{
			int x = 0;int s7=0;int y;
			try
			{
				String s1 = nameTextField.getText();
				String s2 = emailTextField.getText();
				char[] s3 = passwordField.getPassword();
				char[] s4 = confirmPasswordField.getPassword();
				String s5 = new String(s3);
				String s6 = new String(s4);
				s7 = (Integer.parseInt(ageTextField.getText()));
				String s8;
				if(male.isSelected())
					 s8 = "Male";
				else
					s8 = "Female";
				String s9 = qualificationTextField.getText();
				trainerVO.setTrainerName(s1);
				trainerVO.setTrainerEmail(s2);
				trainerVO.setTrainerPassword(s5);
				trainerVO.setTrainerAge(s7);
				trainerVO.setTrainerGender(s8);
				trainerVO.setTrainerQualification(s9);
				if(!s1.isEmpty() && !s2.isEmpty() && !s5.isEmpty() && !s6.isEmpty() && s7!=0 && !s8.isEmpty() && !s9.isEmpty())
				{
					if(s5.equals(s6))
					{
						if(agree.isSelected())
						{
							TrainerService trainerService = new TrainerService();
							x = trainerService.addTrainerService(trainerVO);
							if(x>0)
							{		
								y=trainerService.getTrainerIdService();
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
			catch(NumberFormatException e1)
			{
				JOptionPane.showMessageDialog(btnSubmit, "Fill fields in correct format only");
			}
			catch(NullPointerException e1){
				System.out.println(e1);
			}
		}
		else if(e.getSource() == btnReset)
		{
			nameTextField.setText("");
			emailTextField.setText("");
			passwordField.setText("");
			confirmPasswordField.setText("");
			ageTextField.setText("");
			qualificationTextField.setText("");
			genderGroup.clearSelection();
		}
		else
		{
			frame.dispose();
			new Registration();
		}
		
	}

}
