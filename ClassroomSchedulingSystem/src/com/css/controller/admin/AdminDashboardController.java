package com.css.controller.admin;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
//import javax.swing.JOptionPane;

import com.css.controller.classroom.AddClassroomController;
import com.css.controller.classroom.DeleteClassroomController;
import com.css.controller.classroom.UpdateClassroomController;
import com.css.controller.student.AddStudentController;
import com.css.controller.trainer.AddTrainerController;
import com.css.controller.trainer.DeleteTrainerController;
import com.css.controller.trainer.UpdateTrainerController;
import com.css.controller.training.AddTrainingProgramController;
import com.css.controller.training.DeleteTrainingProgramController;
import com.css.controller.training.DisplayAllTrainingProgramController;
import com.css.controller.training.ScheduleTrainingProgramController;
import com.css.controller.training.UpdateTrainingProgramController;

public class AdminDashboardController implements ActionListener {
	JFrame frame;
	JMenuBar menuBar;
	JMenu trainingProgram, trainer, student, classroom;
	JMenuItem addTrainingProgram, updateTrainingProgram, deleteTrainingProgram,scheduleTrainingProgram, viewTrainingProgram, addTrainer,
			updateTrainer, deleteTrainer, viewTrainer, addStudent, updateStudent, deleteStudent, viewStudent,
			addClassroom, updateClassroom, deleteClassroom, viewClassroom;

	public AdminDashboardController() {
		frame = new JFrame();
		menuBar = new JMenuBar();

		trainingProgram = new JMenu("Training Program");
		trainer = new JMenu("Trainer");
		student = new JMenu("Student");
		classroom = new JMenu("Classroom");

		addTrainingProgram = new JMenuItem("Add");
		updateTrainingProgram = new JMenuItem("Update");
		deleteTrainingProgram = new JMenuItem("Delete");
		scheduleTrainingProgram = new JMenuItem("Schedule");
		viewTrainingProgram = new JMenuItem("View");

		addTrainer = new JMenuItem("Add");
		updateTrainer = new JMenuItem("Update");
		deleteTrainer = new JMenuItem("Delete");
		viewTrainer = new JMenuItem("View");

		addStudent = new JMenuItem("Add");
		updateStudent = new JMenuItem("Update");
		deleteStudent = new JMenuItem("Delete");
		viewStudent = new JMenuItem("View");

		addClassroom = new JMenuItem("Add");
		updateClassroom = new JMenuItem("Update");
		deleteClassroom = new JMenuItem("Delete");
		viewClassroom = new JMenuItem("View");

		addTrainingProgram.addActionListener(this);
		updateTrainingProgram.addActionListener(this);
		deleteTrainingProgram.addActionListener(this);
		viewTrainingProgram.addActionListener(this);
		scheduleTrainingProgram.addActionListener(this);

		addTrainer.addActionListener(this);
		updateTrainer.addActionListener(this);
		deleteTrainer.addActionListener(this);
		viewTrainer.addActionListener(this);

		addStudent.addActionListener(this);
		updateStudent.addActionListener(this);
		deleteStudent.addActionListener(this);
		viewStudent.addActionListener(this);

		addClassroom.addActionListener(this);
		updateClassroom.addActionListener(this);
		deleteClassroom.addActionListener(this);
		viewClassroom.addActionListener(this);

		trainingProgram.add(addTrainingProgram);
		trainingProgram.add(updateTrainingProgram);
		trainingProgram.add(deleteTrainingProgram);
		trainingProgram.add(scheduleTrainingProgram);
		trainingProgram.add(viewTrainingProgram);

		trainer.add(addTrainer);
		trainer.add(updateTrainer);
		trainer.add(deleteTrainer);
		trainer.add(viewTrainer);

		student.add(addStudent);
		student.add(updateStudent);
		student.add(deleteStudent);
		student.add(viewStudent);

		classroom.add(addClassroom);
		classroom.add(updateClassroom);
		classroom.add(deleteClassroom);
		classroom.add(viewClassroom);

		menuBar.add(trainingProgram);
		menuBar.add(trainer);
		menuBar.add(student);
		menuBar.add(classroom);

		frame.add(menuBar);

		frame.setJMenuBar(menuBar);
		frame.setLayout(null);
		Dimension sceensize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(sceensize.width, sceensize.height);
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addTrainingProgram) 
		{
			new AddTrainingProgramController();
		} 
		else if (e.getSource() == updateTrainingProgram) {
			new UpdateTrainingProgramController();
		}
		else if (e.getSource() == deleteTrainingProgram) {
			new DeleteTrainingProgramController();

		}
		else if(e.getSource()==scheduleTrainingProgram){
			new ScheduleTrainingProgramController();
		}
		else if (e.getSource() == viewTrainingProgram) {

			new DisplayAllTrainingProgramController();
		}
		else if (e.getSource() == addTrainer) { 
			new AddTrainerController();
		}
		else if (e.getSource() == updateTrainer) { 
			
		new UpdateTrainerController();
		}
		else if (e.getSource() == deleteTrainer) { 
			new DeleteTrainerController();
		}
		else if (e.getSource() == viewTrainer) { // new
													// DisplayAllTrainerController();
		}
		else if (e.getSource() == addStudent) { new AddStudentController();
		}
		else if (e.getSource() == updateStudent) { // new
														// UpdateStudentController();
		}
		else if (e.getSource() == deleteStudent) { // new
														// DeleteStudentController();
		}
		else if (e.getSource() == viewStudent) {
			// new DisplayAllStudentController();
		}
		

		else if(e.getSource() == addClassroom) 
		{
			new AddClassroomController();
		}
		else if(e.getSource() == updateClassroom) 
		{ 
			new UpdateClassroomController();
		}
		else if (e.getSource() == deleteClassroom) 
		{
			new DeleteClassroomController();
		}
		else if (e.getSource() == viewClassroom) 
		{
			// new DisplayAllClassroomController();
		}

	}

	public static void main(String[] args) {
		new AdminDashboardController();
	}

}
