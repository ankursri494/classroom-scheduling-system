package com.css.controller.classroom;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ScrollPane;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.css.controller.training.DisplayAllTrainingProgramController;
import com.css.model.ClassroomAvailabilityVO;
import com.css.model.TrainingProgramVO;
import com.css.service.ClassroomService;
import com.css.service.TrainingProgramService;

public class DisplayClassroomScheduleController {
	static JFrame frame;
	JPanel topPanel;
	JTable table1;
	JScrollPane scrollPane;
	//ClassroomAvailabilityVO classroomAvailabilityVO;

	public DisplayClassroomScheduleController()
	{
	frame = new JFrame("Training Program Details");
	frame.setSize(500, 200);
	frame.setBackground(Color.gray);
	topPanel = new JPanel();
	topPanel.setLayout(new BorderLayout());
	frame.getContentPane().add(topPanel);
	Object[] column = { "DAY","9:30-11:30", "12:30 to 2:30", "3:30 to 5:30" };
	DefaultTableModel tableModel = new DefaultTableModel(column,0);

	ClassroomService es = new ClassroomService();

	List<ClassroomAvailabilityVO> l = es.getClassroomScheduleService(151);

	for (ClassroomAvailabilityVO classroomAvailabilityVO : l) {
	Object[] data = { 
	classroomAvailabilityVO.getDay(),"Trainer Id : "+classroomAvailabilityVO.getTrainer1()+" --- Training Id : "+classroomAvailabilityVO.getTimeSlot1(),
	"Trainer Id : "+classroomAvailabilityVO.getTrainer2()+" --- Training Id : "+classroomAvailabilityVO.getTimeSlot2(),
	"Trainer Id : "+classroomAvailabilityVO.getTrainer3()+" --- Training Id : "+classroomAvailabilityVO.getTimeSlot3()};

	tableModel.addRow(data);

	}
	 JTable table = new JTable(tableModel);
	 table.setRowHeight(35);
	 scrollPane = new JScrollPane(table);
	topPanel.add(scrollPane, BorderLayout.CENTER);
		frame.add(topPanel);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		new DisplayClassroomScheduleController();
	}
}