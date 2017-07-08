package com.css.controller.trainer;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.css.model.TrainerVO;

public class TrainerDashboardController implements ActionListener{
	
	JFrame frame;
	JButton btnEditProfile;
	TrainerVO trainerVO;
	
	public TrainerDashboardController(TrainerVO trainerVO){
		
		this.trainerVO = trainerVO;
		frame = new JFrame("Trainer Dashboard");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(screenSize.width,screenSize.height);
		//frame.setSize(500, 500);
		frame.setResizable(false); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		//frame.setContentPane(new JLabel(new ImageIcon("D:\\Summer Training Project\\src\\com\\css\\controller\\WELCOME.jpeg")));
		
		btnEditProfile = new JButton("EDIT PROFILE");
		btnEditProfile.setBounds(200, 200, 100, 20);
		frame.add(btnEditProfile);
		btnEditProfile.addActionListener(this);
		
		frame.setVisible(true); 
		
		JOptionPane.showMessageDialog(frame, "Welcome "+trainerVO.getTrainerName()); 

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==btnEditProfile){
			frame.dispose();
			new UpdateTrainerController();
		}
	}
}
