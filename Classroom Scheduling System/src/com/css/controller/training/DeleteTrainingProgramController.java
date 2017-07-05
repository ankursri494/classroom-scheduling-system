package com.css.controller.training;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.css.model.TrainingProgramVO;
import com.css.service.TrainingProgramService;

public class DeleteTrainingProgramController implements ActionListener{

	JFrame frame;
	JLabel labelTitle, labelTrainingId; 
	JTextField tfTrainingId;
	JButton buttonDeleteTrainingProgram, buttonReset;

	
	public DeleteTrainingProgramController()
	{   
		frame=new JFrame("Frame");
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Delete Training Programs");
		
		labelTitle = new JLabel("Delete Training Program");
		labelTitle.setForeground(Color.blue);
		labelTitle.setFont(new Font("serif", Font.BOLD, 20));
		
		labelTrainingId = new JLabel("Training ID");
		tfTrainingId = new JTextField();
			
		buttonDeleteTrainingProgram = new JButton("Delete");
		buttonReset = new JButton("CLEAR");
     
		buttonDeleteTrainingProgram.addActionListener(this);
		buttonReset.addActionListener(this);
		
		labelTitle.setBounds(100, 30, 400, 30);
		labelTrainingId.setBounds(80, 70, 200, 30);
		tfTrainingId.setBounds(300, 70, 200, 30);
		
		buttonDeleteTrainingProgram.setBounds(50, 350, 100, 30);
		buttonReset.setBounds(170, 350, 100, 30);
		
		frame.add(labelTitle);
		frame.add(labelTrainingId);
		frame.add(tfTrainingId);
		
		frame.add(buttonDeleteTrainingProgram);
		frame.add(buttonReset);
		Dimension sceensize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(sceensize.width, sceensize.height);
		frame.setVisible(true);
		
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == buttonDeleteTrainingProgram) {
			
			
			int trainingId = 0;
			try {
				TrainingProgramVO trainingProgramVO = new TrainingProgramVO();
				trainingId = Integer.parseInt(tfTrainingId.getText());

				if (trainingId != 0) {
					trainingProgramVO.setTrainingId(trainingId);
					
					TrainingProgramService trainingProgramService = new TrainingProgramService();
					int x = trainingProgramService.deleteTrainingProgramService(trainingProgramVO);
					System.out.println(x);
					if (x > 0) {
						JOptionPane.showMessageDialog(buttonDeleteTrainingProgram, "Successfully Deleted");
					}
				} else {
					JOptionPane.showMessageDialog(buttonDeleteTrainingProgram, "Please Enter Id");
				}
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(buttonDeleteTrainingProgram, "Fill fields in correct format only");
			}
		} else {
			tfTrainingId.setText("");
		}

	}
	
	public static void main(String args[]) {
		new DeleteTrainingProgramController();
	}


}