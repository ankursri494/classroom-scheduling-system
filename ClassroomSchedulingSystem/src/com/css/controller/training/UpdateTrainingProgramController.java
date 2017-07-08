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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.css.model.TrainingProgramVO;
import com.css.service.TrainingProgramService;


public class UpdateTrainingProgramController implements ActionListener{

	JFrame frame;
	JLabel labelTitle, labelTrainingId, labelTrainingName, labelStudentIntake, labelTrainingDuration,
			labelTrainingDescription;
	JTextField tfTrainingId, tfTrainingName, tfStudentIntake, tfTrainingDuration;
	JButton buttonUpdateTrainingProgram, buttonReset,buttonGetInfo;
	JTextArea taTrainingDescription;
	
	
	public UpdateTrainingProgramController()
	{
		frame=new JFrame("frame");
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Add New Training Programs");

		labelTitle = new JLabel("Add New Training Program");
		labelTitle.setForeground(Color.blue);
		labelTitle.setFont(new Font("serif", Font.BOLD, 20));

		labelTrainingId = new JLabel("Training ID");
		labelTrainingName = new JLabel("Training Name");
		labelStudentIntake = new JLabel("Students Intake");
		labelTrainingDuration = new JLabel("Training Duration");
		labelTrainingDescription = new JLabel("Training Description");

		tfTrainingId = new JTextField();
		tfTrainingName = new JTextField();
		tfStudentIntake = new JTextField();
		tfTrainingDuration = new JTextField();
		taTrainingDescription = new JTextArea();
		taTrainingDescription.setSize(400, 400);
		taTrainingDescription.setLineWrap(true);
		taTrainingDescription.setEditable(true);
		taTrainingDescription.setVisible(true);
		JScrollPane scrollV = new JScrollPane(taTrainingDescription);
		JScrollPane scrollH = new JScrollPane(taTrainingDescription);
		scrollV.setBounds(300, 230, 200, 60);
		scrollH.setBounds(300, 230, 200, 60);

		scrollV.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollH.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		// setContentPane(new JLabel(new
		// ImageIcon("C://Users//admin//Desktop//images.jpg")));
		Dimension sceensize = Toolkit.getDefaultToolkit().getScreenSize();

		frame.setSize(sceensize.width, sceensize.height);

		buttonUpdateTrainingProgram = new JButton("Update");
		buttonReset = new JButton("CLEAR");
		buttonGetInfo=new JButton("Get Info");

		buttonUpdateTrainingProgram.addActionListener(this);
		buttonReset.addActionListener(this);
		buttonGetInfo.addActionListener(this);

		labelTitle.setBounds(100, 30, 400, 30);
		labelTrainingId.setBounds(80, 70, 200, 30);
		labelTrainingName.setBounds(80, 110, 200, 30);
		labelStudentIntake.setBounds(80, 150, 200, 30);
		labelTrainingDuration.setBounds(80, 190, 200, 30);
		labelTrainingDescription.setBounds(80, 230, 200, 30);

		tfTrainingId.setBounds(300, 70, 200, 30);
		tfTrainingName.setBounds(300, 110, 200, 30);
		tfStudentIntake.setBounds(300, 150, 200, 30);
		tfTrainingDuration.setBounds(300, 190, 200, 30);
		// taTrainingDescription.setBounds(300, 230, 200, 60);

		buttonUpdateTrainingProgram.setBounds(50, 350, 100, 30);
		buttonReset.setBounds(170, 350, 100, 30);
		buttonGetInfo.setBounds(290,350,100,30);

		frame.add(labelTitle);
		frame.add(labelTrainingId);
		frame.add(labelTrainingName);
		frame.add(labelStudentIntake);
		frame.add(labelTrainingDuration);
		frame.add(labelTrainingDescription);
		frame.add(tfTrainingId);
		frame.add(tfTrainingName);
		frame.add(tfStudentIntake);
		frame.add(tfTrainingDuration);
		// add(taTrainingDescription);
		frame.add(buttonUpdateTrainingProgram);
		frame.add(buttonReset);
		frame.add(buttonGetInfo);
		frame.add(scrollH);
		frame.add(scrollV);
		frame.setVisible(true);
	}
	
	
	
	
	public void actionPerformed(ActionEvent e) {
	    int trainingId,studentIntake,trainingDuration;
	    String trainingName,trainingDescription;
	    
		if(e.getSource()==buttonGetInfo)
		{
			TrainingProgramService es=new TrainingProgramService();
			
			trainingId=Integer.parseInt(tfTrainingId.getText());
			tfTrainingId.setEnabled(false);
			TrainingProgramVO trainingProgramVO=es.searchTrainingProgramService(trainingId);
			
			if(trainingProgramVO!=null)
			{
				//tfTrainingId.setText(trainingProgramVO.getTrainingId());
				tfTrainingName.setText(trainingProgramVO.getTrainingName());
				tfStudentIntake.setText(Integer.toString(trainingProgramVO.getStudentIntake()));
				tfTrainingDuration.setText(Integer.toString(trainingProgramVO.getTrainingDuration()));
				taTrainingDescription.setText(trainingProgramVO.getTrainingDescription());
			}	
			else
			{
				JOptionPane.showMessageDialog(buttonGetInfo, "Enter valid ID");
			}
			
			
		}
		else if(e.getSource()==buttonUpdateTrainingProgram)
		{
			
			try {
				TrainingProgramVO trainingProgramVO = new TrainingProgramVO();
				trainingId = Integer.parseInt(tfTrainingId.getText());
				trainingName = tfTrainingName.getText();
				studentIntake = Integer.parseInt(tfStudentIntake.getText());
				trainingDuration = Integer.parseInt(tfTrainingDuration.getText());
				trainingDescription = taTrainingDescription.getText();

				if (trainingId != 0 && !trainingName.isEmpty() && studentIntake != 0 && trainingDuration != 0
						&& !trainingDescription.isEmpty()) {
					trainingProgramVO.setTrainingId(trainingId);
					trainingProgramVO.setTrainingName(trainingName);
					trainingProgramVO.setStudentIntake(studentIntake);
					trainingProgramVO.setTrainingDuration(trainingDuration);
					trainingProgramVO.setTrainingDescription(trainingDescription);

					TrainingProgramService trainingProgramService = new TrainingProgramService();
					int x = trainingProgramService.updateTrainingProgramService(trainingProgramVO);
					System.out.println(x);
					if (x > 0) {
						JOptionPane.showMessageDialog(buttonUpdateTrainingProgram, "Data Updated Successfully");
					}
				} else {
					JOptionPane.showMessageDialog(buttonUpdateTrainingProgram, "Please Fill all the details!!");
				}
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(buttonUpdateTrainingProgram, "Fill fields in correct format only");
			}
		} 
		else {
			tfTrainingId.setText("");
			tfTrainingName.setText("");
			tfStudentIntake.setText("");
			tfTrainingDuration.setText("");
			taTrainingDescription.setText("");

		}
		
	}
	
	public static void main(String args[]) {
		new UpdateTrainingProgramController();
	}
	
	
	
	

}
