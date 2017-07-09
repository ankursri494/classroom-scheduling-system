package com.css.controller.classroom;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Toolkit;
import java.awt.Dimension;
import javax.swing.ImageIcon;

import com.css.model.ClassroomVO;
import com.css.service.ClassroomService;

public class DeleteClassroomController implements ActionListener {	

	JFrame classFrame;
	JPanel formPanel,imgPanel;
	JLabel labelHeading,labelID,labelImg;
	JTextField id;
	JButton deleteDetails;

	public DeleteClassroomController(){

		classFrame = new JFrame("Delete Classroom Form");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		classFrame.setSize(screenSize.width,screenSize.height);
		classFrame.setResizable(false);
		classFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		classFrame.setLayout(null);

		formPanel = new JPanel();
		formPanel.setBounds(screenSize.width-420,20,400,600);
		classFrame.add(formPanel);
		formPanel.setLayout(null);
		formPanel.setBackground(Color.gray);

		labelHeading = new JLabel("Delete Classroom");
		labelHeading.setBounds(35, 11, 320, 32);
		formPanel.add(labelHeading);

		labelID = new JLabel("ID :");
		//	labelID.setFont (labelID.getFont ().deriveFont (64.0f));

		labelID.setBounds(65,60,86,23);
		formPanel.add(labelID);

		id = new JTextField();
		id.setBounds(65,85,250,20);
		formPanel.add(id);

		deleteDetails = new JButton("Delete Classroom");
		deleteDetails.setBounds(65,150,200,30);
		formPanel.add(deleteDetails);

		ImageIcon background = new ImageIcon("..\\ClassroomSchedulingSystem\\img\\classroom.jpg");
		labelImg = new JLabel();
		labelImg.setBounds(0,0,screenSize.width-450,screenSize.height);
		labelImg.setIcon(background);

		imgPanel = new JPanel();
		imgPanel.setLayout(null);
		imgPanel.setBounds(10,-50,screenSize.width-450,screenSize.height);
		imgPanel.add(labelImg);
		classFrame.add(imgPanel);

		deleteDetails.addActionListener(this);

		classFrame.setVisible(true);

	}

	public static void main (String args[]) {
		new DeleteClassroomController();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ClassroomVO classData = new ClassroomVO();

		int x=0;
		String s1=id.getText();
		classData.setClassId(s1);

		if(!s1.isEmpty())
		{
			ClassroomService classroomservice = new ClassroomService();
			x=classroomservice.deleteDataService(classData);
			if(x>0){
				JOptionPane.showMessageDialog(deleteDetails, "Class deleted Successfully!!");
			}
			classFrame.dispose();
		}
		else
		{
			JOptionPane.showMessageDialog(deleteDetails, "Enter ID!!");
		}
	}
}

