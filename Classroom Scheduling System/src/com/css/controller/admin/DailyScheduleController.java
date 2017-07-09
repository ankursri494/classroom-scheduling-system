package com.css.controller.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.peer.LightweightPeer;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.css.model.DailyScheduleVO;
import com.css.service.AdminService;

public class DailyScheduleController {

	static JFrame frame;
	JPanel topPanel;
	JTable table;
	JScrollPane scrollPane;
	JTabbedPane tabbedPane;
	
	public DailyScheduleController()
	{
		
		frame = new JFrame("Training Program Details");
		frame.setSize(500, 200);
		frame.setBackground(Color.gray);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(screenSize.width,screenSize.height);		
		
		tabbedPane =new JTabbedPane();
		frame.getContentPane().add(tabbedPane);
		
		String weekDays[] = {"Monday","Tuesday","Wednesday","Thursday","Friday"};
		for(int i=0;i<=4;i++)
		{	
			topPanel = new JPanel();
			topPanel.setLayout(new BorderLayout());
		
		

		Object[] column = { "Class Id", "9:30-11:30", "12:30 to 2:30", "3:30 to 5:30" };
		DefaultTableModel tableModel = new DefaultTableModel(column, 0);

		AdminService es = new AdminService();

		List<DailyScheduleVO> l = es.getDailyScheduleService(weekDays[i]);

		for (DailyScheduleVO dailyScheduleVO : l) {

			Object[] data = { dailyScheduleVO.getClassId(),
					"Trainer Id : "+dailyScheduleVO.getTrainer1()+ " --- Training Id : " + dailyScheduleVO.getTraining1(),
					"Trainer Id : "+dailyScheduleVO.getTrainer2() + " --- Training Id : " + dailyScheduleVO.getTraining2(),
					"Trainer Id : "+dailyScheduleVO.getTrainer3() + " --- Training Id : " + dailyScheduleVO.getTraining3() };
			        tableModel.addRow(data);

		}
		JTable table = new JTable(tableModel);
		JTableHeader Header = table.getTableHeader();
		Header.setForeground(Color.white);
		Header.setBackground(Color.gray);
		Header.setPreferredSize(new Dimension(50,50));
		table.setRowHeight(50);
		

		
	    scrollPane = new JScrollPane(table);
		topPanel.add(scrollPane, BorderLayout.CENTER);
		tabbedPane.add("<html><body><div style='font-size:15px;padding:10px'> "+weekDays[i]+" </div></body></html>", topPanel);
        tabbedPane.setTabPlacement(JTabbedPane.LEFT);
        tabbedPane.setBackground(Color.LIGHT_GRAY);
		}
		
		frame.add(tabbedPane);
		frame.setVisible(true);

	}

	public static void main(String args[]) {
		// Create an instance of the test application
		new DailyScheduleController();

	}
}
