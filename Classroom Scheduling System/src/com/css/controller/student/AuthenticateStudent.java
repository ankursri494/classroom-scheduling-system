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


public class AuthenticateStudent extends JFrame implements ActionListener {
	
	
    
	private static final long serialVersionUID = 1L;
	JLabel labelTitle ,labelStudentId,labelStudentPassword ,labelStudentEmail;
    JTextField tfStudentId, tfStudentEmail ;
    JButton StudentLogin ,buttonReset;
    JPasswordField tfStudentPassword;


    AuthenticateStudent(){
    	
    	
    	setSize(700, 700);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Authgentication  of student detail in css_student Table");
 
        labelTitle =new JLabel("Welcome to login page ");
        labelTitle.setForeground(Color.green);
        labelTitle.setFont(new Font("Serif", Font.BOLD, 40));
 
        labelStudentId = new JLabel("Student Id or Email");
      //  labelStudentEmail = new JLabel("Student Email");
        labelStudentPassword = new JLabel("Student Password");
       
        tfStudentId =new JTextField();
        tfStudentPassword = new JPasswordField();
      //  tfStudentEmail = new JTextField();

      
        StudentLogin = new JButton("Login");
        buttonReset = new JButton("Reset");
 
        StudentLogin.addActionListener(this);
        buttonReset.addActionListener(this);
       
        labelTitle.setBounds(150,20,300,50);
        labelStudentId.setBounds(80, 120, 200, 30);
        labelStudentPassword.setBounds(80, 170, 200, 30);
        //labelStudentEmail.setBounds(80, 220, 200, 30);
       
        tfStudentId.setBounds(250, 120, 200, 30);
        tfStudentPassword.setBounds(250, 170, 200, 30);
        //tfStudentEmail.setBounds(250, 220, 200, 30);
        
        
        StudentLogin.setBounds(100, 300, 100, 30);
        buttonReset.setBounds(300, 300, 100, 30);
        
        add(labelTitle);
        add(labelStudentId);
        add(labelStudentPassword);
        //add(labelStudentEmail);
    
        add(labelStudentId);
        add(tfStudentId);
        add(tfStudentPassword);
        //add(tfStudentEmail);
        add(StudentLogin);
        add(buttonReset);
        setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
        if (e.getSource() == StudentLogin)
        {	//StudentVO studentvo = new StudentVO();
             //int s1 = Integer.toString(tfStudentId.getText());
             
        	
        	
        String s1 =tfStudentId.getText();
            
        	
             //studentvo.setStudentId(s1);

	          System.out.println("Enter student   password authenticated");
	       //    char[] s2 =tfStudentPassword.getPassword();
	           String s2 = String.valueOf(tfStudentPassword.getPassword());
	          

	           //studentVO.setStudentPassword(new String(s3));

	         // String s2=tfStudentPassword.getText();
	             //studentvo.setStudentPassword(s2);

	          
	         // System.out.println("Enter student   Email");
	          //String s3=tfStudentEmail.getText();
	           //  studentvo.setStudentEmail(s3);

	          
			     

	            StudentService studentService = new StudentService();
	   			boolean x=studentService.authenticateStudentService(s1,s2);
	   			System.out.println(x);
	   			if(x)
	   			{
	   				System.out.println("authenticate successfully");
	   				
	   				JOptionPane.showMessageDialog(StudentLogin, "You are valid user");

	             }
	    }
	        else
	        {
	        	tfStudentId.setText("");
	        	tfStudentPassword.setText("");
	        	tfStudentEmail.setText("");

	          }
	         
	        }
	public static void main(String[] args)
	{

     new AuthenticateStudent();
	}
	

		
		
	}
	
	
	
	


