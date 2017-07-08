package com.css.controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.css.controller.student.AddStudentController;
import com.css.controller.trainer.AddTrainerController;

public class Registration implements ActionListener {
	
	JFrame frame;
	JLabel heading,heading1,studentlbl,trainerlbl;
	JButton trainer,student,btnBack;

	public Registration(){
		frame = new JFrame("CAMPUS CONNECT CLASSROOM SCHEDULING SYSTEM");
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(screenSize.width,screenSize.height);
		frame.setResizable(false);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setContentPane(new JLabel(new ImageIcon("D:\\Summer Training Project\\img\\registration.jpg")));
		
		heading = new JLabel("<html><span style='font-size:30px'>"+"CAMPUS CONNECT CLASSROOM SCHEDULING SYSTEM"+"</span></html>");
		heading.setBounds(70, 40, 1200, 150);
		heading.setForeground(Color.white ); 
		frame.add(heading);
		
		heading1 = new JLabel("<html><span style='font-size:25px'>"+"REGISTER AS"+"</span></html>");
		heading1.setBounds(500, 150, 1200, 150);
		heading1.setForeground(Color.white ); 
		frame.add(heading1);
		
		studentlbl = new JLabel("<html><span style='font-size:15px'>"+"STUDENT"+"</span></html>");
		studentlbl.setBounds(350, 190, 1200, 150);
		studentlbl.setForeground(Color.white );  
		frame.add(studentlbl);
		
		trainerlbl = new JLabel("<html><span style='font-size:15px'>"+"TRAINER"+"</span></html>");
		trainerlbl.setBounds(850, 190, 1200, 150);
		trainerlbl.setForeground(Color.white ); 
		frame.add(trainerlbl);
		
		ImageIcon studentbutton = new ImageIcon("D:\\Summer Training Project\\img\\student.png");
		student = new JButton("LOGIN");
		student.setBounds(200,300,studentbutton.getIconWidth(),studentbutton.getIconHeight());
		student.setIcon(studentbutton); 
		frame.add(student);
		student.addActionListener(this);

		ImageIcon trainerbutton = new ImageIcon("D:\\Summer Training Project\\img\\teachers.png");
		trainer = new JButton("REGISTER");
		trainer.setBounds(700,300,trainerbutton.getIconWidth(),trainerbutton.getIconHeight());
		trainer.setIcon(trainerbutton); 
		frame.add(trainer);
		trainer.addActionListener(this);

		btnBack = new JButton("BACK");
		btnBack.setBounds(1300, 0, 66, 23);
		frame.add(btnBack);
		btnBack.addActionListener(this);
		frame.setVisible(true);
		btnBack.addActionListener(this);
		
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == student){
			frame.dispose();
			new AddStudentController();
		}
		else if(e.getSource() == trainer){
			frame.dispose();
			new AddTrainerController();
		}
		else{
			frame.dispose();
			new Welcome();
		}
	}

}
