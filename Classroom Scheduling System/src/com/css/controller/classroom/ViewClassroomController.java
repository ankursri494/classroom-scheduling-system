package com.css.controller.classroom;

import java.util.ArrayList;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.Toolkit;
import java.awt.Dimension;

import com.css.model.ClassroomVO;
import com.css.service.ClassroomService;

public class ViewClassroomController {
	JFrame classFrame;
	JPanel tablePanel;
	
	ViewClassroomController(){

		classFrame = new JFrame("View Classrooms");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		classFrame.setSize(screenSize.width,screenSize.height);
		classFrame.setResizable(false);
		classFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		classFrame.setLayout(null);

		
		ArrayList<ClassroomVO> classrooms = new ArrayList<ClassroomVO>();

		ClassroomService classroomservice=new ClassroomService();

		classrooms= classroomservice.viewDataService();

		String headers[] = {"Classroom Id","Block","Floors","Capacity"};
		DefaultTableModel tableModel = new DefaultTableModel(headers, 0);		
		for (int i = 0; i < classrooms.size(); i++){
			String classId=classrooms.get(i).getClassId();
			String classBlock=classrooms.get(i).getClassBlock();
			String classFloor=classrooms.get(i).getClassFloor();
			String classCapacity=classrooms.get(i).getClassCapacity();

			Object[] data = {classId,classBlock,classFloor,classCapacity};
			tableModel.addRow(data);
		}

		tablePanel = new JPanel();
		tablePanel.setBounds(10, 10,screenSize.width-30,screenSize.height);
		classFrame.add(tablePanel);
		tablePanel.setLayout(null);

		JTable table = new JTable(tableModel);
		JTableHeader Header = table.getTableHeader();
		Header.setForeground(Color.white);
		Header.setBackground(Color.gray);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 10,screenSize.width-30,screenSize.height);

		tablePanel.add(scrollPane);
		classFrame.setVisible(true);

	}

	public static void main (String args[]) {
		new ViewClassroomController();
	}
}	
