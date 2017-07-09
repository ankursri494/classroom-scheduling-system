package com.css.controller.trainer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.css.controller.classroom.DisplayClassroomScheduleController;
import com.css.model.ClassroomAvailabilityVO;
import com.css.model.TrainerAvailabilityVO;
import com.css.service.ClassroomService;
import com.css.service.TrainerService;

public class DisplayTrainerScheduleController {
	
	static JFrame frame;
	JPanel topPanel;
	JTable table1;
	JScrollPane scrollPane;
	
	public DisplayTrainerScheduleController()
	{
		frame = new JFrame("Training Program Details");
		frame.setSize(500, 200);
		frame.setBackground(Color.gray);

		topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		frame.getContentPane().add(topPanel);

		Object[] column = { "DAY","9:30-11:30", "12:30 to 2:30", "3:30 to 5:30" };
		DefaultTableModel tableModel = new DefaultTableModel(column,0);

       TrainerService es = new TrainerService();

		List<TrainerAvailabilityVO> l = es.getTrainerScheduleService(1101);

		for (TrainerAvailabilityVO trainerAvailabilityVO : l) {
 
			Object[] data = { 
					trainerAvailabilityVO.getDay(), "Class Id : "+trainerAvailabilityVO.getTimeSlot1()+" --- Training Id : "+trainerAvailabilityVO.getTraining1(),
					"Class Id : "+trainerAvailabilityVO.getTimeSlot2()+" --- Training Id : "+trainerAvailabilityVO.getTraining2(),
					"Class Id : "+trainerAvailabilityVO.getTimeSlot3()+" --- Training Id : "+trainerAvailabilityVO.getTraining3()
			};

			tableModel.addRow(data);

		}
		JTable table = new JTable(tableModel);
        table.setRowHeight(35);
		scrollPane = new JScrollPane(table);
		topPanel.add(scrollPane, BorderLayout.CENTER);
		frame.add(topPanel);
		frame.setVisible(true);
		
		
	}
	public static void main(String args[]) {
		// Create an instance of the test application
		new DisplayTrainerScheduleController();
		
	}
}

	