package com.css.controller.trainer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.css.model.TrainerVO;
import com.css.service.TrainerService;

public class UpdateTrainerController extends Trainer implements ActionListener{

	public JButton btnSubmit;
	JButton getinfo;

	public UpdateTrainerController() {

		//frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		nameTextField.setEnabled(false);
		emailTextField.setEnabled(false);
		ageTextField.setEnabled(false);
		qualificationTextField.setEnabled(false); 
		passwordField.setEnabled(false);
		confirmPasswordField.setEnabled(false);
		male.setEnabled(false); 
		female.setEnabled(false);  
		trainings.setEnabled(false);
		agree.setEnabled(false);
		
		btnSubmit = new JButton("SUBMIT");
		btnSubmit.setBounds(103, 437, 86, 23);
		panel.add(btnSubmit);
		btnSubmit.addActionListener(this);
		btnSubmit.setEnabled(false);

		getinfo = new JButton("GET INFO");
		getinfo.setBounds(324, 11,90, 20);
		panel.add(getinfo);
		getinfo.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		TrainerVO trainerVO = new TrainerVO();
		if(e.getSource() == btnSubmit)
		{
			int x = 0;int s7=0;
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
							x = trainerService.updateTrainerService(trainerVO);
							if(x>0)
							{		
								JOptionPane.showMessageDialog(btnSubmit, "Details are Updated");
								frame.dispose();
								new UpdateTrainerController();
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
		else if(e.getSource()==getinfo){
			TrainerService trainerService = new  TrainerService();
			trainerVO = trainerService.searchTrainer(idTextField.getText());
			idTextField.setEnabled(false);
			getinfo.setEnabled(false); 
			nameTextField.setText(trainerVO.getTrainerName());
			emailTextField.setText(trainerVO.getTrainerEmail());
			ageTextField.setText(Integer.toString(trainerVO.getTrainerAge()));
			qualificationTextField.setText(trainerVO.getTrainerQualification());
			passwordField.setText(trainerVO.getTrainerPassword());
			confirmPasswordField.setText(trainerVO.getTrainerPassword());
			if(trainerVO.getTrainerGender()=="Male")                                                                                                                                                                      
				male.setSelected(true);
			else
				female.setSelected(true);
			nameTextField.setEnabled(true);
			emailTextField.setEnabled(true);
			ageTextField.setEnabled(true);
			qualificationTextField.setEnabled(true); 
			passwordField.setEnabled(true);
			confirmPasswordField.setEnabled(true);
			male.setEnabled(true); 
			female.setEnabled(true);
			trainings.setEnabled(true);
			agree.setEnabled(true); 
			btnSubmit.setEnabled(true); 
		}
	}
}
