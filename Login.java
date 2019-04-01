package ManagementSystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.*;
	public class Login extends JFrame implements ActionListener {
	    //�����¼��������	
		private String path="D:\\java ���\\StudentManagementSystem\\back.jpg";
		private Image image=Toolkit.getDefaultToolkit().getImage(path);
		private  Connection conn=null;
		private  PreparedStatement perstmt=null;
		private JButton button1,button2;
		private JRadioButton jrbutton1,jrbutton2;
		private JLabel label1,label2,label3;
		private JLabel  label4,label5,label6;  //���Ű�����
		private JTextField text;
		private JPasswordField password;
		private ButtonGroup buttongroup;
		private JPanel panel1,panel2,panel3,panel4;
		public Login(String string,Connection conn,PreparedStatement perstmt){
			
			this.conn=conn;
			this.perstmt=perstmt;
			
			
			Font font=new Font("",Font.BOLD,32);
			Font font1=new Font("",Font.BOLD,22);
			//�������
		    label1=new JLabel("�� ��");
		    label1.setFont(font);
		    label2=new JLabel("�� ��");
		    label2.setFont(font);
		    label3=new JLabel("Ȩ ��");
		    label3.setFont(font);
		    label4=new JLabel("            ");
		    label5=new JLabel("         ");
		    label6=new JLabel("                     ");
		    
		    jrbutton1 =new JRadioButton("��ʦ");
		    jrbutton1.setFont(font1);
		    jrbutton2 =new JRadioButton("ѧ��");
		    jrbutton2.setFont(font1);
		    buttongroup=new ButtonGroup();
		    buttongroup.add(jrbutton1);
		    buttongroup.add(jrbutton2);
		    jrbutton2.setSelected(true);    //����ֻ����ѡ��һ����ť Ĭ�ϰ�ť2
			
		    button1= new JButton("�˳�");
			button1.setFont(font);
			button2= new JButton("��¼");
			button2.setFont(font);
			
			panel1=new JPanel();
			panel2=new JPanel();
			panel3=new JPanel();
			panel4=new JPanel();
			
			text=new JTextField(10);               //�����û�
			text.setFont(font);
			password=new JPasswordField(10);        //��������
			password.setFont(font);
			
			panel1.setLayout(new FlowLayout());         //�û���
			panel1.add(label1);
			panel1.add(text);
			
			panel2.setLayout(new FlowLayout());         //����
			panel2.add(label2);
			panel2.add(password);
			
			panel3.setLayout(new FlowLayout());         //���
			panel3.add(label3);
			panel3.add(label4);
			panel3.add(jrbutton1);
			panel3.add(label5);
			panel3.add(jrbutton2);
			panel3.add(label6);
			
			panel4.setLayout(new FlowLayout());          //����
			panel4.add(button1);       //�����ڵ�¼�����һ���˳���ť�в�����,����������
			JLabel  jl=new JLabel("                   ");
			panel4.add(jl);
			panel4.add(button2);
			
			//����ͼƬ
			/*String path="D:\\java ���\\StudentManagementSystem\\back.jpg";
			Icon background = new ImageIcon(path);
			JLabel label66=new JLabel(background,JLabel.CENTER);
			label66.setBounds(0,0,this.getWidth(),this.getHeight());		
			JPanel imagePanel=(JPanel)this.getContentPane();		
			imagePanel.setOpaque(false);
			this.getLayeredPane().add(label66,new Integer(Integer.MIN_VALUE));  */
			this.setLayout(new GridLayout(4,1));  //��״���� ����һ��
			this.add(panel1); 
			this.add(panel2);
			this.add(panel3);
			this.add(panel4); 
			
				   
			//���ñ��⡢���ڴ�С�����ڵĳ�ʼλ��
			this.setTitle(string);
			this.setSize(550, 350);
			this.setLocation(700, 150);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //�˳�Ӧ�ó���ʹ��System exit����������Ӧ�ó�����ʹ��		
			this.setVisible(true);
			
			//���ü���
			button1.addActionListener(this);
			button2.addActionListener(this);
			text.addKeyListener(new C());
			password.addKeyListener(new C());
		}
		
		public void cls(){
			text.setText("");
			password.setText("");
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			if(arg0.getSource().equals(button1)){   //ѡ�˹رհ�ť��ֱ���˳�
				System.exit(0);
			}else{       //��¼ ���ж������Ϊ�յ����
				
				if(text.getText().isEmpty()&&password.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"�������˻������룡","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
				}else if(text.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"�������˻���","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
				}else if(password.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"���������룡","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
				}else{
					//�������򶼲�Ϊ�գ��������ݿ�
					if(jrbutton1.isSelected()){    //���Ȩ��ѡ�˽�ʦ
						try {		
							if(DBConnection.teacherQuery(text.getText(),password.getText(),conn,perstmt)==true){     //�˺ź�������ȷ
							//if(text.getText().equals("admin")&&password.getText().equals("password")){//�����õĴ���
								JOptionPane.showMessageDialog(null,"��¼�ɹ���","��ʾ��Ϣ",JOptionPane.NO_OPTION);
								//�رյ�ǰ����
								this.dispose();
							   // this.setVisible(false);
							   //System.exit(0);
								//����һ���½���	
								new TeacherSystem("ѧ������ϵͳ--��ʦ����",conn,perstmt);
							}else{
								JOptionPane.showMessageDialog(null,"�˻����������\n����������","��ʾ��Ϣ",JOptionPane.ERROR_MESSAGE);
								cls();
							}					
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}else{              //���Ȩ��ѡ��ѧ��        
						try {					
							if(DBConnection.studentQuery(text.getText(),password.getText(),conn,perstmt)){     //�˺ź�������ȷ
						//	if(text.getText().equals("801")&&password.getText().equals("good")){  //�����õĴ���
								JOptionPane.showMessageDialog(null,"��¼�ɹ���","��ʾ��Ϣ",JOptionPane.CLOSED_OPTION);
								//�رյ�ǰ����
								this.dispose();
								//System.exit(0);
								//����һ���½���	
								new StudentSystem("ѧ������ϵͳ--ѧ������",text.getText(),conn,perstmt);
							}else{
								JOptionPane.showMessageDialog(null,"�˻����������\n����������","��ʾ��Ϣ",JOptionPane.ERROR_MESSAGE);
								cls();
								/*
								 ��ʾһ������Ի�����ʾ��Ϣ������������ 
	                             JOptionPane.showMessageDialog(null, "alert", "alert", JOptionPane.ERROR_MESSAGE); 
								 */
							}
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}   
					}
				}											
			}
		}
	/*	public void paint(Graphics g){    //��ӱ���ͼƬ
			super.paintComponents(g);
			g.drawImage(image,0,0,this);
		}*/
		class C extends KeyAdapter{    //�س�����
	  	  public void keyPressed(KeyEvent e){
	  		  if(e.getKeyCode()==KeyEvent.VK_ENTER){
	  			  e.consume();
	  			  KeyboardFocusManager.getCurrentKeyboardFocusManager().focusNextComponent();
	  		  }
	  	  }
	    }  
		
	}
