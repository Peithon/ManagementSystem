package ManagementSystem;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
//�α��ѯ���ɼ���ѯ��������Ϣ�����������ѧ���������������޸ġ��˳�ϵͳ����¼����
//ʹ����״����
public class StudentSystem extends JFrame implements ActionListener {
    private Connection conn=null;
    private PreparedStatement perstmt=null;
    private String Sno=null;
    private JButton button1,button2,button3,button4,button5,button6,button7,button8;
    private JMenuBar bar;
    private JMenu menubar;
    private JMenuItem men1,men2;
    private JPanel panel,panel2;
	public StudentSystem(String string,String Sno,Connection conn,PreparedStatement perstmt){
		this.conn=conn;
		this.perstmt=perstmt;
		this.Sno=Sno;
		
		Font font=new Font("",Font.BOLD,22);
		Font font1=new Font("",Font.BOLD,15);
		
		button1=new JButton("���ص�¼����");
		button2=new JButton("�ɼ���ѯ");
		button3=new JButton("������Ϣ");
		button4=new JButton("�����");
		button5=new JButton("��ѧ��������");
		button6=new JButton("�α��ѯ");
		button7=new JButton("�����޸�");
		button8=new JButton("�˳�ϵͳ");
		
		button1.setFont(font);
		button2.setFont(font);
		button3.setFont(font);
		button4.setFont(font);
		button5.setFont(font);
		button6.setFont(font);
		button7.setFont(font);
		button8.setFont(font);
		
		panel=new JPanel();
		panel.setLayout(new GridLayout(8,1));
		panel2=new JPanel();
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);
		panel.add(button6);
		panel.add(button7);
		panel.add(button8);
		
		bar=new JMenuBar();
		menubar=new JMenu("����");
		menubar.setFont(font1);
		bar.add(menubar);
		men1=new JMenuItem("ʹ��");
		men2=new JMenuItem("����");
		menubar.add(men1);
		menubar.add(men2);
		
			
		panel2.add(panel);
		this.add(panel2);
		this.setTitle(string);
		this.setJMenuBar(bar);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(750, 550);
		this.setLocation(700, 150);
		this.setVisible(true);
		
		//���ü���
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);
		button7.addActionListener(this);
		button8.addActionListener(this);
		men1.addActionListener(this);
		men2.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource().equals(men1)){                      //ʹ��
			JOptionPane.showMessageDialog(null,"��ûʲô��˵��","ʹ��",JOptionPane.QUESTION_MESSAGE);
		}else if(arg0.getSource().equals(men2)){                //����
			JOptionPane.showMessageDialog(null,"�汾1-1-1.0\n"
					+ "   ��Ȩ����,Υ���ϲ˵�","����",JOptionPane.CLOSED_OPTION);
		}else if(arg0.getSource().equals(button1)){                   //���ص�¼����
			JOptionPane.showMessageDialog(null,"�������ص�¼����","��ʾ��Ϣ",JOptionPane.CLOSED_OPTION);
			this.dispose();
			new Login("ѧ������ϵͳ",conn,perstmt); 
        }else if(arg0.getSource().equals(button2)){                    //�ɼ���ѯ       	
		        try {
		        	String sql,name=null;								     	   
				    sql = "select sname from s where sno=?";
					perstmt=conn.prepareStatement(sql);
					perstmt.setString(1,Sno); 
					perstmt.executeUpdate();
					ResultSet rs = perstmt.executeQuery(); 
					 while(rs.next()){ 
				   	       name=rs.getString("sname");
				            //����ʽ�������
					    }
				   new StudentScoreSearch(name+"ͬѧ�ĳɼ�",Sno,conn,perstmt);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,"����ʲô�ˣ�","��ʾ",JOptionPane.QUESTION_MESSAGE);
				}			
        }else if(arg0.getSource().equals(button3)){                    //������Ϣ
        	try {
	        	String sql,name=null;								     	   
			    sql = "select sname from s where sno=?";
				perstmt=conn.prepareStatement(sql);
				perstmt.setString(1,Sno); 
				perstmt.executeUpdate();
				ResultSet rs = perstmt.executeQuery(); 
				 while(rs.next()){ 
			   	       name=rs.getString("sname");
			            //����ʽ�������
				    }
			   new MyInfo(name+"ͬѧ�ĸ�����Ϣ",Sno,conn,perstmt);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null,"����ʲô�ˣ�","��ʾ",JOptionPane.QUESTION_MESSAGE);
			}			
        }else if(arg0.getSource().equals(button4)){                     //�����
        	JOptionPane.showMessageDialog(null,"��û�з������Ϣ�������ĵȴ�","��ܰ��ʾ",JOptionPane.CLOSED_OPTION);
        }else if(arg0.getSource().equals(button5)){                     //��ѧ��������
        	JOptionPane.showMessageDialog(null,"��û�н�ѧ������Ϣ�������ĵȴ�","��ܰ��ʾ",JOptionPane.CLOSED_OPTION);
        }else if(arg0.getSource().equals(button6)){                     //�α��ѯ
 			try {
				new TimeTable();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }else if(arg0.getSource().equals(button7)){                     //�޸�����
        	 new Password("�޸�����",Sno,this,conn,perstmt);
        	
        }else {                                              //�˳�ϵͳ
        	try {
				DBConnection.Close(conn);
				JOptionPane.showMessageDialog(null,"�ڴ������ٴμ���","��ܰ��ʾ",JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	        	
		}
	}

}
