package com.css.controller.trainer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.css.model.TrainerVO;
import com.css.service.TrainerService;

public class DeleteTrainerController implements ActionListener {

	JFrame classFrame;
	JPanel formPanel,imgPanel;
	JLabel labelHeading,labelID,labelImg;
	JTextField id;
	JButton deleteDetails;

	public DeleteTrainerController(){

		classFrame = new JFrame("Delete Trainer Form");
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

		labelHeading = new JLabel("Delete Trainer");
		labelHeading.setBounds(35, 11, 320, 32);
		formPanel.add(labelHeading);

		labelID = new JLabel("TRAINER ID :");
		//	labelID.setFont (labelID.getFont ().deriveFont (64.0f));

		labelID.setBounds(65,60,86,23);
		formPanel.add(labelID);

		id = new JTextField();
		id.setBounds(65,85,250,20);
		formPanel.add(id);

		deleteDetails = new JButton("Delete Trainer");
		deleteDetails.setBounds(65,150,200,30);
		formPanel.add(deleteDetails);

		//ImageIcon background = new ImageIcon("D:\\Summer Training Project\\img\\classroom.jpg");
		labelImg = new JLabel();
		labelImg.setBounds(0,0,screenSize.width-450,screenSize.height);
		//labelImg.setIcon(background);

		imgPanel = new JPanel();
		imgPanel.setLayout(null);
		imgPanel.setBounds(10,-50,screenSize.width-450,screenSize.height);
		imgPanel.add(labelImg);
		classFrame.add(imgPanel);

		deleteDetails.addActionListener(this);

		classFrame.setVisible(true);

	}

	public static void main (String args[]) {
		new DeleteTrainerController();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		TrainerVO classData = new TrainerVO();

		int x=0;
		String s1=id.getText();
		classData.setTrainerId(Integer.parseInt(s1));

		if(!s1.isEmpty())
		{
			TrainerService trainerService = new TrainerService();
			x=trainerService.deleteTrainerService(s1);
			if(x>0){
				JOptionPane.showMessageDialog(deleteDetails, "Trainer deleted Successfully!!");
			}
			classFrame.dispose();
		}
		else
		{
			JOptionPane.showMessageDialog(deleteDetails, "Enter ID!!");
		}
	}

}
