package com.css.controller.student;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.css.service.StudentService;

import com.css.model.StudentVO;

public class UpdateStudentController extends JFrame implements ActionListener{

    JLabel labelTitle,labelStudentId ,labelStudentName,labelStudentEmail,labelStudentPassword;
    JTextField tfStudentId ,tfStudentName ,tfStudentEmail;
    JPasswordField tfStudentPassword;
    JButton buttonUpdateStudent ,buttonReset,buttonGetInfo;

	public UpdateStudentController(){

	
           setSize(700, 700);
	       setLayout(null);
	       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       setTitle("updation  in database css_student  Form in Java");

	       labelTitle = new JLabel("updation Form ");
	       labelTitle.setForeground(Color.blue);
	       labelTitle.setFont(new Font("Serif", Font.BOLD, 20));

	       labelStudentId = new JLabel("StudentID");
	       labelStudentName = new JLabel("UpdateSTudentName");
	       labelStudentEmail = new JLabel("UpdateEmail");
	       labelStudentPassword = new JLabel("UpdatePassword");

	       
	       
	       tfStudentId = new JTextField();
	       tfStudentName = new JTextField();
	       tfStudentEmail = new JTextField();
	       tfStudentPassword = new JPasswordField();
	       
	       
	       buttonUpdateStudent = new JButton("update");
			buttonGetInfo=new JButton("Get Info");

	       buttonReset = new JButton("Clear");

	       buttonUpdateStudent.addActionListener(this);
	       buttonReset.addActionListener(this);
	       buttonGetInfo.addActionListener(this);


	       labelTitle.setBounds(100, 30, 400, 30);
	       labelStudentId.setBounds(80, 70, 200, 30);
	       labelStudentName.setBounds(80, 110, 200, 30);
	       labelStudentEmail.setBounds(80, 150, 200, 30);
	       labelStudentPassword.setBounds(80, 190, 200, 40);
	       
	       
	       tfStudentId.setBounds(300, 70, 200, 30);
	       tfStudentName.setBounds(300, 110, 200, 30);
	       tfStudentEmail.setBounds(300, 150, 200, 30);
	       tfStudentPassword.setBounds(300, 190, 200, 40);
	       
	      
	       buttonUpdateStudent.setBounds(50, 350, 100, 30);
	       buttonReset.setBounds(170, 350, 100, 30);
	       buttonGetInfo.setBounds(280, 350, 100, 30);

	       add(labelTitle);
	       add(labelStudentId);
	       add(labelStudentName);
	       add(labelStudentEmail);
	       add(labelStudentPassword);
	       
	       add(tfStudentId);
	       add(tfStudentName);
	       add(tfStudentEmail);
	       add(tfStudentPassword);
	     
	       add(buttonUpdateStudent);
	       add(buttonReset);
	       add(buttonGetInfo);
	       setVisible(true);

		
		
		
	}
	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void actionPerformed(ActionEvent e) {
		int studentId;
	 String	studentName,studentEmail,studentPassword;
		
     if(e.getSource()==buttonGetInfo)
		{
    	 StudentService es=new StudentService();
			
    	 studentId=Integer.parseInt(tfStudentId.getText());
    	 tfStudentId.setEnabled(false);
    	  
			StudentVO studentvo=es.searchStudentService( Integer.toString(studentId));
			
			if(studentvo!=null)
			{
			//	studentId.Integer.parseInt(studentvo.getStudentId());
				tfStudentName.setText(studentvo.getStudentName());
				tfStudentEmail.setText(studentvo.getStudentEmail());
	              
                tfStudentPassword.setText(studentvo.getStudentPassword());
			}	
			else
			{
				JOptionPane.showMessageDialog(buttonGetInfo, "Enter valid ID");
			}
			
			
		}
		else if(e.getSource()==buttonUpdateStudent)
        {

	   
			
			try {
				StudentVO studentvo = new StudentVO();
				studentId = Integer.parseInt(tfStudentId.getText());
				studentName = tfStudentName.getText();
				studentEmail = tfStudentEmail.getText();
				studentPassword=String.valueOf(tfStudentPassword.getPassword());
				

				if (studentId != 0 && !studentName.isEmpty() && !studentEmail.isEmpty() && !studentPassword.isEmpty())
						 {
				    studentvo.setStudentId(studentId);
					
					studentvo.setStudentEmail(studentEmail);
					studentvo.setStudentName(studentName);
					studentvo.setStudentPassword(studentPassword);
					

			    	 StudentService studentservice=new StudentService();
						int x = studentservice.updateStudentService(studentvo);
								
					System.out.println(x);
					if (x > 0) {
						JOptionPane.showMessageDialog(buttonUpdateStudent, "Data Updated Successfully");
					}
				 else {
					JOptionPane.showMessageDialog(buttonUpdateStudent, "Please Fill all the details!!");
				}
			}
			}
			catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(buttonUpdateStudent, "Fill fields in correct format only");
			}
		} 
		else {
        	tfStudentId.setText("");
        	tfStudentName.setText("");
        	tfStudentEmail.setText("");
            tfStudentPassword.setText("");
		}
		
	}			
				
	public static void main(String[] args)
	{
		new UpdateStudentController();
		
	}
	

}
