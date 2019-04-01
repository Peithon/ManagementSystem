package ManagementSystem;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ManagementSystem.CourseCreate.C;

public class Update1 extends JFrame implements ActionListener{
	 private JLabel label,label2,label3,label4;
	    private JTextField field1,field2,field3;
	    private JButton button1,button2;
	    private JPanel panel1,panel2,panel3,panel4;
	    private Connection conn=null;
	    private PreparedStatement perstmt=null;
	    private String Cno=null;
	    public Update1(String string,String Cno,Connection conn,PreparedStatement perstmt){
	    	 this.conn=conn;
	    	 this.perstmt=perstmt;
	    	 this.Cno=Cno;
	    	 
	    	 Font font=new Font("",Font.BOLD,22);
	    	 label=new JLabel("�γ̺�");
	    	 label2=new JLabel("�γ���");
	    	 label3=new JLabel("ѧ    ��");
	    	 label.setFont(font);
	    	 label2.setFont(font);
	    	 label3.setFont(font);
	    	 
	    	 field1=new JTextField(10);
	    	 field2=new JTextField(10);
	    	 field3=new JTextField(10);
	    	 field1.setFont(font);
	    	 field2.setFont(font);
	    	 field3.setFont(font);
	    	 
	    	 button1=new JButton("�޸�");
	    	 button2=new JButton("ȡ��");
	    	 button1.setFont(font);
	    	 button2.setFont(font);
	    	 
	    	 panel1=new JPanel();
	    	 panel2=new JPanel();
	    	 panel3=new JPanel();
	    	 panel4=new JPanel();
	    	 
	    	 panel1.setLayout(new FlowLayout());
	    	 panel1.add(label);
	    	 panel1.add(field1);
	    	
	    	 panel2.setLayout(new FlowLayout());
	    	 panel2.add(label2);
	    	 panel2.add(field2);
	    	
	    	 panel3.setLayout(new FlowLayout());
	    	 panel3.add(label3);
	    	 panel3.add(field3);
	    	
	    	 panel4.setLayout(new FlowLayout());   	 
	    	 label4=new JLabel("     ");
	    	 panel4.add(button1);
	    	 panel4.add(label4);
	    	 panel4.add(button2);
	    	 
	    	 this.setTitle(string);
	    	 this.setSize(450,330);
	    	 this.setLocation(700,150);
	    	 this.setVisible(true);
	    	 this.setLayout(new GridLayout(4,1));
	    	 this.add(panel1);
	    	 this.add(panel2);
	    	 this.add(panel3);
	    	 this.add(panel4);
	    	 //�س�����
	    	 field1.addKeyListener(new C());
	    	 field2.addKeyListener(new C());
	    	 field3.addKeyListener(new C());
	    	 
	    	 //���ö�������
	    	 field1.addActionListener(this);
	    	 field2.addActionListener(this);
	    	 field3.addActionListener(this);
	    	 button1.addActionListener(this);
	    	 button2.addActionListener(this);
	    	 
	    }
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if(arg0.getSource().equals(button1)){
				if(field1.getText().isEmpty()&&field2.getText().isEmpty()&&field3.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"����д�γ�����","����",JOptionPane.WARNING_MESSAGE);
				}else if(field1.getText().isEmpty()){			
					JOptionPane.showMessageDialog(null,"�γ̺Ų���Ϊ��","����",JOptionPane.WARNING_MESSAGE);				
				}else if(field2.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"�γ�������Ϊ��","����",JOptionPane.WARNING_MESSAGE);
				}else if(field3.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"ѧ�ֲ���Ϊ��","����",JOptionPane.WARNING_MESSAGE);	
				}else if(!field3.getText().isEmpty()){                          
					try { 	               
		                double nume=Integer.valueOf(field3.getText());//���ַ���ǿ��ת��Ϊ���� 
		             } 
		              catch (Exception e) {	 
		            	  JOptionPane.showMessageDialog(null,"ѧ�ֲ���Ϊ�ַ�","����",JOptionPane.WARNING_MESSAGE);
		            	  field3.setText("");
		             }
				}			
	            if(!(field1.getText().isEmpty()||field2.getText().isEmpty()||field3.getText().isEmpty())){ 
	            	//�������������ݿ�
					try{    
						 String sql;
						 if(field1.getText().equals(Cno)){
							 sql="update c set cname=?,credit=? where cno=?";
								perstmt=conn.prepareStatement(sql);
								perstmt.setString(1,field2.getText());
								perstmt.setString(2,field3.getText());
								perstmt.setString(3,Cno);
								perstmt.executeUpdate(); 
					            conn.commit();
						 }else{
							 sql = "INSERT INTO C(cno,cname,credit) VALUES(?,?,?)";
						        perstmt=conn.prepareStatement(sql);  
								perstmt.setString(1,field1.getText()); 
								perstmt.setString(2,field2.getText());
								perstmt.setString(3,field3.getText());
								perstmt.executeUpdate();
					            conn.commit();	
							 sql="update sc set cno=? where cno=?";
								perstmt=conn.prepareStatement(sql);
								perstmt.setString(1,field1.getText());	
								perstmt.setString(2,Cno);
								perstmt.executeUpdate(); 
					            conn.commit();
					          sql="delete from c where cno=?";		
								perstmt=conn.prepareStatement(sql);
								perstmt.setString(1,Cno);
								perstmt.executeUpdate();
								conn.commit();
						 }
						 
				            JOptionPane.showMessageDialog(null,"�޸ĳɹ�","��ʾ",JOptionPane.CLOSED_OPTION); 
				            this.dispose();
		      		  }catch(Exception te){	      			  
		      			JOptionPane.showMessageDialog(null,"��ϸ�������ĳ�������\n","��ʾ",JOptionPane.QUESTION_MESSAGE);      		
		      		  }	 
				}  
			}else{
		//	if(arg0.getSource().equals(button2)){
				this.dispose();
			}
		}
		
		class C extends KeyAdapter{    //�س�����
		  	  public void keyPressed(KeyEvent e){
		  		  if(e.getKeyCode()==KeyEvent.VK_ENTER){
		  			  e.consume();
		  			  KeyboardFocusManager.getCurrentKeyboardFocusManager().focusNextComponent();
		  		  }
		  	  }
		    }  
}
