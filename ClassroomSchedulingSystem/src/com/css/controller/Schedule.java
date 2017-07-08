package com.css.controller;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Choice;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Schedule extends JPanel {

	/**
	 * Create the panel.
	 */
	public Schedule() {
		setLayout(null);
		
		JLabel lblScheduleTraining = new JLabel("Schedule Training");
		lblScheduleTraining.setBounds(175, 11, 92, 14);
		add(lblScheduleTraining);
		
		JLabel lblTrainingName = new JLabel("Training Name :");
		lblTrainingName.setBounds(28, 56, 75, 14);
		add(lblTrainingName);
		
		JLabel lblTrainerName = new JLabel("Trainer Name:");
		lblTrainerName.setBounds(28, 104, 75, 14);
		add(lblTrainerName);
		
		JLabel lblTime = new JLabel("Time :");
		lblTime.setBounds(28, 147, 46, 14);
		add(lblTime);
		
		JLabel lblClassId = new JLabel("Class Id :");
		lblClassId.setBounds(28, 192, 46, 14);
		add(lblClassId);
		
		JButton btnSubmitSchedule = new JButton("Submit Schedule");
		btnSubmitSchedule.setBounds(160, 242, 122, 23);
		add(btnSubmitSchedule);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(339, 47, 89, 23);
		add(btnNewButton);

	}
}
