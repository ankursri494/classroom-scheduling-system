package com.css.controller.training;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.css.model.TrainingProgramVO;
import com.css.service.ClassroomService;
import com.css.service.TrainingProgramService;

public class ScheduleTrainingProgramController implements ActionListener {

	JFrame frame;
	JPanel panel;
	JLabel lblScheduleTraining, lblTrainingName, lblTrainerName, lblTime, lblClassId,lblDay;
	JComboBox<String> trainingCh, trainerCh, dayCh, timeCh;
	JComboBox<Integer> classroomCh;
	JButton getTrainer, getTime, getClass, getDay, btnSubmitSchedule;

	public ScheduleTrainingProgramController() {

		frame = new JFrame("Login Form");
		// Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		// frame.setSize(screenSize.width,screenSize.height);         
		frame.setSize(600, 500);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);

		panel = new JPanel();
		// panel.setSize(screenSize.width,screenSize.height);
		panel.setBounds(0, 10, 600, 500);
		frame.add(panel);
		panel.setLayout(null);
		panel.setBackground(Color.cyan);

		lblScheduleTraining = new JLabel("Schedule Training");
		lblScheduleTraining.setBounds(175, 11, 132, 14);
		panel.add(lblScheduleTraining);

		lblTrainingName = new JLabel("Training Name :");
		lblTrainingName.setBounds(28, 56, 92, 14);
		panel.add(lblTrainingName);

		trainingCh = new JComboBox<String>();
		trainingCh.setBounds(139, 50, 176, 20);
		panel.add(trainingCh);
		
		TrainingProgramService es = new TrainingProgramService();
		List<TrainingProgramVO> l = es.displayAllTrainingProgramService();
		for (TrainingProgramVO trainingProgramVO : l) {
			trainingCh.addItem(trainingProgramVO.getTrainingName());
		}
		trainingCh.setSelectedIndex(-1);

		lblTrainerName = new JLabel("Trainer Name:");
		lblTrainerName.setBounds(28, 104, 92, 14);
		panel.add(lblTrainerName);

		trainerCh = new JComboBox<String>();
		trainerCh.setBounds(139, 98, 176, 20);
		panel.add(trainerCh);
		trainerCh.setEnabled(false);
		trainerCh.addItem("Ankur");
		trainerCh.addItem("Anmol");
		trainerCh.addItem("Akansha");
		trainerCh.setSelectedIndex(-1);

		getTrainer = new JButton("Get Trainer Availability");
		getTrainer.setBounds(339, 98, 160, 23);
		panel.add(getTrainer);
		getTrainer.addActionListener(this);

		lblDay = new JLabel("Day :");
		lblDay.setBounds(28, 147, 66, 14);
		panel.add(lblDay);
		
		dayCh = new JComboBox<>();
		dayCh.setBounds(139, 141, 176, 20);
		panel.add(dayCh);
		dayCh.setEnabled(false);
		dayCh.addItem("Monday");
		dayCh.addItem("Tuesday");
		dayCh.addItem("Wednesday");
		dayCh.addItem("Thursday");
		dayCh.addItem("Friday");
		dayCh.setSelectedIndex(-1);
		
		getDay = new JButton("Get Day Availability");
		getDay.setBounds(339, 141, 160, 23);
		panel.add(getDay);
		getDay.setEnabled(false);
		getDay.addActionListener(this);

		lblTime = new JLabel("Time :");
		lblTime.setBounds(28, 192, 66, 14);
		panel.add(lblTime);

		timeCh = new JComboBox<String>();
		timeCh.setBounds(139, 186, 176, 20);
		panel.add(timeCh);
		timeCh.setEnabled(false);
		timeCh.setSelectedIndex(-1);

		getTime = new JButton("Get Time Availability");
		getTime.setBounds(339, 186, 160, 23);
		panel.add(getTime);
		getTime.setEnabled(false);
		getTime.addActionListener(this);

		lblClassId = new JLabel("Class Id :");
		lblClassId.setBounds(28, 243, 66, 14);
		panel.add(lblClassId);

		classroomCh = new JComboBox<Integer>();
		classroomCh.setBounds(139, 237, 176, 20);
		panel.add(classroomCh);
		classroomCh.setEnabled(false);
		classroomCh.addItem(2);
		classroomCh.setSelectedIndex(-1);

		getClass = new JButton("Get Class Availability");
		getClass.setBounds(339, 237, 160, 23);
		panel.add(getClass);
		getClass.setEnabled(false);
		getClass.addActionListener(this);

		btnSubmitSchedule = new JButton("Submit Schedule");
		btnSubmitSchedule.setBounds(160, 292, 142, 23);
		panel.add(btnSubmitSchedule);
		btnSubmitSchedule.addActionListener(this);
		btnSubmitSchedule.setEnabled(false);

		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String training,trainer,day;int classroom =0, time=0,trainerId = 0;
		HashMap<Integer,String> trainers=new HashMap<Integer,String>();
		HashMap<Integer,Integer> timeList = new HashMap<Integer,Integer>();
		ArrayList<Integer> classList;
		TrainingProgramService trainingProgramService = new TrainingProgramService();
		
		if (e.getSource() == getTrainer) {
			trainerCh.removeAllItems();
			if (trainingCh.getSelectedIndex() != -1) 
			{	
				training=(String) trainingCh.getSelectedItem();
				trainers=trainingProgramService.getAvailabletrainerService(training);
				for (Map.Entry<Integer, String> entry:trainers.entrySet()) {
					trainerCh.addItem(entry.getKey() + " - "+ entry.getValue());
				}
				trainerCh.setEnabled(true);
				getDay.setEnabled(true);
				trainerCh.setSelectedIndex(-1);
			} 
			else 
			{
				JOptionPane.showMessageDialog(null, "Select Any Training Program First");
			}
		}
		
		else if(e.getSource() == getDay)
		{
			if (trainerCh.getSelectedIndex() != -1) 
			{
				trainer=(String) trainerCh.getSelectedItem(); 
				//trainerId = Integer.parseInt(trainer.substring(0, 4));
				dayCh.setEnabled(true);
				getTime.setEnabled(true);
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "Select Any Trainer First");
			}
		}
		
		else if (e.getSource() == getTime) 
		{
			if (dayCh.getSelectedIndex() != -1) 
			{
				timeCh.removeAllItems();
				trainer=(String) trainerCh.getSelectedItem(); 
				day=(String) dayCh.getSelectedItem();
				trainerId = Integer.parseInt(trainer.substring(0, 4));
				timeList=trainingProgramService.getAvailableTimeService(trainerId,day);
				for (Map.Entry<Integer, Integer> entry1:timeList.entrySet()) 
				{
					if(entry1.getKey()==1 && entry1.getValue()==0)
						timeCh.addItem(entry1.getKey() + " - 9:30 to 11:30" );
					if(entry1.getKey()==2 && entry1.getValue()==0)
						timeCh.addItem(entry1.getKey() + " - 12:30 to 2:30" );
					if(entry1.getKey()==3 && entry1.getValue()==0)
						timeCh.addItem(entry1.getKey() + " - 3:30 to 5:30" );
				}	
				timeCh.setEnabled(true);
				getClass.setEnabled(true);
				timeCh.setSelectedIndex(-1); 
			} 
			else 
			{
				JOptionPane.showMessageDialog(null, "Select Any Day First");
			}
		} 
		
		else if (e.getSource() == getClass) {
			if (timeCh.getSelectedIndex() != -1) {
				classroomCh.removeAllItems();
				day=(String) dayCh.getSelectedItem();
				time=Integer.parseInt(((String)timeCh.getSelectedItem()).substring(0, 1));
				System.out.println(time);
				ClassroomService cs = new ClassroomService();
				classList = cs.getClassroomAvailabilityService(day, time);
				for (int i : classList) {
					classroomCh.addItem(i);
				}
				classroomCh.setEnabled(true);
				btnSubmitSchedule.setEnabled(true);
				classroomCh.setSelectedIndex(-1);
			} 
			else {
				JOptionPane.showMessageDialog(null, "Select Any Time First");
			}
		}
		else{
			if (classroomCh.getSelectedIndex() != -1) 
			{
				training=(String) trainingCh.getSelectedItem();
				trainer=(String) trainerCh.getSelectedItem(); 
				trainerId = Integer.parseInt(trainer.substring(0, 4));
				day=(String) dayCh.getSelectedItem();
				time=Integer.parseInt(((String)timeCh.getSelectedItem()).substring(0, 1));
				classroom=(int) classroomCh.getSelectedItem();
				int x = trainingProgramService.scheduleTrainingService(training,trainerId,day,time,classroom);
				if(x>0)
				{
					JOptionPane.showMessageDialog(btnSubmitSchedule, "Training is Scheduled Successfully");
				}
				else
				{
					JOptionPane.showMessageDialog(btnSubmitSchedule, "Scheduling UnSuccessfull");
				}
				System.out.println("Training Name = "+training);
				System.out.println("Trainer Id = "+trainerId);
				System.out.println("Day = "+day);
				System.out.println("Time = "+time);
				System.out.println("Class = "+classroom);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Select Any Class First");
			}
		}
	}

	public static void main(String[] args) {
		new ScheduleTrainingProgramController();
	}
}
