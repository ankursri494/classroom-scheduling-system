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

public class UpdateClassroomController implements ActionListener {	

	JFrame classFrame;
	JPanel formPanel,imgPanel;
	JLabel labelHeading,labelID,labelBlock,labelFloor,labelCapacity,labelImg;
	JTextField id,block,floor,capacity;
	JButton updateDetails,getDetails;

	public UpdateClassroomController(){

		classFrame = new JFrame("Update Classroom Form");
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

		labelHeading = new JLabel("Update Classroom Details");
		labelHeading.setBounds(35, 11, 320, 32);
		formPanel.add(labelHeading);

		labelID = new JLabel("ID :");
		//	labelID.setFont (labelID.getFont ().deriveFont (64.0f));

		labelID.setBounds(65,60,86,23);
		formPanel.add(labelID);

		id = new JTextField();
		id.setBounds(65,85,250,20);
		formPanel.add(id);

		getDetails = new JButton("Fetch Class Details");
		getDetails.setBounds(65,100,200,30);
		formPanel.add(getDetails);

		labelBlock = new JLabel("BLOCK :");
		labelBlock.setBounds(65,125,86,23);
		formPanel.add(labelBlock);

		block = new JTextField();
		block.setBounds(65,150,250,20);
		formPanel.add(block);

		labelFloor = new JLabel("FLOOR :");
		labelFloor.setBounds(65,190,86,23);
		formPanel.add(labelFloor);

		floor = new JTextField();
		floor.setBounds(65,215,250,20);
		formPanel.add(floor);

		labelCapacity = new JLabel("CAPACITY :");
		labelCapacity.setBounds(65,255,86,23);
		formPanel.add(labelCapacity);

		capacity = new JTextField();
		capacity.setBounds(65,280,250,20);
		formPanel.add(capacity);

		updateDetails = new JButton("Update Class Details");
		updateDetails.setBounds(65,330,200,30);
		formPanel.add(updateDetails);

		ImageIcon background = new ImageIcon("..\\ClassroomSchedulingSystem\\img\\classroom.jpg");
		labelImg = new JLabel();
		labelImg.setBounds(0,0,screenSize.width-450,screenSize.height);
		labelImg.setIcon(background);

		imgPanel = new JPanel();
		imgPanel.setLayout(null);
		imgPanel.setBounds(10,-50,screenSize.width-450,screenSize.height);
		imgPanel.add(labelImg);
		classFrame.add(imgPanel);

		getDetails.addActionListener(this);
		updateDetails.addActionListener(this);


		classFrame.setVisible(true);

	}
	
	public static void main (String args[]) {
		new UpdateClassroomController();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == getDetails)
		{
			ClassroomVO classData = new ClassroomVO();

			String s1 = id.getText();
			id.setEnabled(false);
			ClassroomService classroomservice = new ClassroomService();
			classData=classroomservice.searchDataService(s1);
			block.setText(classData.getClassBlock());
			floor.setText(classData.getClassFloor());
			capacity.setText(classData.getClassCapacity());			
		}
		if (e.getSource() == updateDetails)		
		{
			ClassroomVO classData = new ClassroomVO();

			int x=0;
			String s1=id.getText();
			String s2 = block.getText();
			String s3 = floor.getText();
			String s4 = capacity.getText();
			classData.setClassId(s1);
			classData.setClassBlock(s2);
			classData.setClassFloor(s3);
			classData.setClassCapacity(s4);


			if(!s1.isEmpty() && !s2.isEmpty() && !s3.isEmpty() && !s4.isEmpty())
			{
				ClassroomService classroomservice = new ClassroomService();
				x=classroomservice.updateDataService(classData);
				if(x>0){
					JOptionPane.showMessageDialog(updateDetails, "Classroom Details updated Successfully!!");
				}
				classFrame.dispose();
			}
			else
			{
				JOptionPane.showMessageDialog(updateDetails, "Enter all the fields!!");
			}
		}
	}

}
