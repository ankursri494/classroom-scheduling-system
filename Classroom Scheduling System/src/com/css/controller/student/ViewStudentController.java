package com.css.controller.student;

import java.awt.BorderLayout;
import java.awt.Color;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.css.service.StudentService;

import com.css.model.StudentVO;

public class ViewStudentController  {
	
	
	/**
	 * 
	 */
	
	static JFrame frame;
	JPanel topPanel;
	JTable table1;
	JScrollPane scrollPane;

	public ViewStudentController() {

		frame = new JFrame("Student Details");
		frame.setSize(500, 200);
		frame.setBackground(Color.gray);

		topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		frame.getContentPane().add(topPanel);

		Object[] column = { "Student Id", "Student Name", "Student password", "Student email",
				 };

		DefaultTableModel tableModel = new DefaultTableModel(column, 0);

		StudentService es = new StudentService();
		List<StudentVO> l = es.displayAllStudentService();
	    for (StudentVO studentvo : l) {

  			Object[] data = { studentvo.getStudentId(), studentvo.getStudentName(),
					 studentvo.getStudentPassword(),studentvo.getStudentEmail() };
			tableModel.addRow(data);
		}
		JTable table = new JTable(tableModel);
		scrollPane = new JScrollPane(table);
		topPanel.add(scrollPane, BorderLayout.CENTER);
		frame.add(topPanel);
		frame.setVisible(true);
	}

	

	
		
	

	public static void main(String args[]) {
		// Create an instance of the test application
		new ViewStudentController();

		
	}

	
	

}
