package com.css.controller.training;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.css.model.TrainingProgramVO;
import com.css.service.TrainingProgramService;

public class DisplayAllTrainingProgramController {

	static JFrame frame;
	JPanel topPanel;
	JTable table1;
	JScrollPane scrollPane;

	public DisplayAllTrainingProgramController() {

		frame = new JFrame("Training Program Details");
		frame.setSize(500, 200);
		frame.setBackground(Color.gray);

		topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		frame.getContentPane().add(topPanel);

		Object[] column = { "Training Id", "Training Name", "Student Intake", "Training Duration",
				"Training Description" };

		DefaultTableModel tableModel = new DefaultTableModel(column, 0);

		TrainingProgramService es = new TrainingProgramService();

		List<TrainingProgramVO> l = es.displayAllTrainingProgramService();

		for (TrainingProgramVO trainingProgramVO : l) {

			Object[] data = { trainingProgramVO.getTrainingId(), trainingProgramVO.getTrainingName(),
					trainingProgramVO.getStudentIntake(), trainingProgramVO.getTrainingDuration(),
					trainingProgramVO.getTrainingDescription() };

			tableModel.addRow(data);

		}
		JTable table = new JTable(tableModel);

		scrollPane = new JScrollPane(table);
		topPanel.add(scrollPane, BorderLayout.CENTER);
		frame.add(topPanel);
		frame.setVisible(true);
	}

	// Main entry point for this example
	public static void main(String args[]) {
		// Create an instance of the test application
		new DisplayAllTrainingProgramController();

		
	}
}
