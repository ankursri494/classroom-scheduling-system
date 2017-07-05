package com.css.controller.trainer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import com.css.controller.Registration;
import com.css.model.TrainerVO;
import com.css.service.TrainerService;

public class AddTrainerController extends Trainer implements  ActionListener{

	JButton btnSubmit;
	JButton btnReset;
	JButton btnBack;

	public AddTrainerController(){

		idTextField.setEnabled(false); 
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
			int x = 0,z=0;int s7=0;int y;
			try
			{
				//Getting Values From Trainer's Registration Form.
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
				ArrayList<String> trainersTrainings = new ArrayList<String>();
				trainersTrainings.addAll(trainings.getSelectedValuesList());


				//Setting the values of trainer in TrainerVO Class.
				trainerVO.setTrainerName(s1);
				trainerVO.setTrainerEmail(s2);
				trainerVO.setTrainerPassword(s5);
				trainerVO.setTrainerAge(s7);
				trainerVO.setTrainerGender(s8);
				trainerVO.setTrainerQualification(s9);
				trainerVO.setTrainings(trainersTrainings); 
				
				ArrayList<Integer> trainersTrainingsId = new TrainerService().getTrainersTrainingsIdService(trainerVO);
				trainerVO.setTrainingsId(trainersTrainingsId);
				
				Iterator<Integer> itr = trainersTrainingsId.iterator();
				while(itr.hasNext())
					System.out.println(itr.next());
				
				
				//Performing Validations and inserting data in database.
				if(!s1.isEmpty() && !s2.isEmpty() && !s5.isEmpty() && !s6.isEmpty() && s7!=0 && !s8.isEmpty() && !s9.isEmpty() && !trainersTrainings.isEmpty())
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
								trainerVO.setTrainerId(y); 
								System.out.println(trainerVO.getTrainerId()); 
								z= trainerService.addTrainersTrainingsService(trainerVO);
								JOptionPane.showMessageDialog(btnSubmit, "You are Successfully Registered!! Your user id is :" +y);
								nameTextField.setText("");
								emailTextField.setText("");
								passwordField.setText("");
								confirmPasswordField.setText("");
								ageTextField.setText("");
								qualificationTextField.setText("");
								genderGroup.clearSelection();
								trainings.clearSelection();
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
			trainings.clearSelection();
		}
		else
		{
			frame.dispose();
			new Registration();
		}

	}

}
