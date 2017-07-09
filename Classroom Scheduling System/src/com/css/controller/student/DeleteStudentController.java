package com.css.controller.student;


	import java.awt.Color;
	import java.awt.Font;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	import javax.swing.JTextField;

	import com.css.service.StudentService;

	import com.css.model.StudentVO;


	public class DeleteStudentController extends JFrame implements ActionListener {
		
		
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		JLabel labelTitle,labelStudentId;
		JTextField tfStudentId;
	    JButton deleteStudent, Reset;
	    public DeleteStudentController()
	    {
	       setSize(700, 700);
	       setLayout(null);
	       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       setTitle("deletion  in database Form in Java");

	       labelTitle = new JLabel("deletion Form in Windows Form:");
	       labelTitle.setForeground(Color.blue);
	       labelTitle.setFont(new Font("Serif", Font.BOLD, 20));

	       labelStudentId = new JLabel("Employee Id");
	       
	       tfStudentId = new JTextField();
	      
	       
	       deleteStudent = new JButton("submit");
	       Reset = new JButton("Clear");

	       deleteStudent.addActionListener(this);
	       Reset.addActionListener(this);

	       labelTitle.setBounds(100, 30, 400, 30);
	      labelStudentId.setBounds(100, 100, 100, 30);
	       tfStudentId.setBounds(250, 100, 100, 30);
	    
	      
	       deleteStudent.setBounds(50, 350, 100, 30);
	       Reset.setBounds(170, 350, 100, 30);

	       add(labelTitle);
	       add(labelStudentId);
	       add(tfStudentId);
	     
	     
	       add(deleteStudent);
	       add(Reset);
	       setVisible(true);




	}
		@Override
		public void actionPerformed(ActionEvent ae) {
	        if (ae.getSource() == deleteStudent)
	        {
	    		
	    		StudentVO studentvo = new StudentVO();
	            String s2 =tfStudentId.getText();
	            if(!s2.isEmpty()){
	               int s1 = Integer.parseInt(tfStudentId.getText());
	               studentvo.setStudentId(s1);
		   			StudentService studentservice = new StudentService();
		   			int x=studentservice.deleteStudentService(studentvo.getStudentId());
		   			if(x>0)
		   			{
		   				
		   				JOptionPane.showMessageDialog(deleteStudent, "deleted successfully");
		             }
		   			else{
		   				JOptionPane.showMessageDialog(deleteStudent, "Enter valid id");

		   			}
		    }
	            else{
	   				JOptionPane.showMessageDialog(deleteStudent, "Enter id");

	            }
	        }
		        else
		        {

		        	tfStudentId.setText("");
		           
		           
		          }

			// TODO Auto-generated method stub
			
		}
		public static void main(String[] args)
		
		{
			new DeleteStudentController();
		}
	}


