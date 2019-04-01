package ManagementSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class TeacherSystem extends JFrame implements ActionListener{
	//�������
	private Connection conn=null;
	private PreparedStatement perstmt=null;
	private JTextArea textfield1,textfield2;
	private JPanel panel;
	private JLabel label;
	private JMenu menubar1,menubar2,menubar3,menubar4,menubar5,menubar6;//�ļ���ѧ�������γ̹����ɼ���������������
	private JMenuBar bar1; //�˵���
	private JMenuItem bar1open,bar1exit;
	private JMenuItem bar2create,bar2read,bar2update,bar2delete;     //ѧ����Ϣ����ɾ���
	private JMenuItem bar3create,bar3read,bar3update,bar3delete;     //�γ���Ϣ����ɾ���
	private JMenuItem bar4create,bar4read,bar4update,bar4delete;     //�ɼ���Ϣ����ɾ���
	private JMenuItem bar5other;   
	private JMenuItem bar6help,bar6about;
	public TeacherSystem(String string,Connection conn,PreparedStatement perstmt){
		this.conn=conn;
		this.perstmt=perstmt;
		
		Font font=new Font("",Font.BOLD,25);
		Font font1=new Font("",Font.BOLD,19);
		//�˵��� �����˵����ӵ��˵�����
		bar1=new JMenuBar();
		menubar1=new JMenu("��");
		menubar1.setFont(font);
		menubar2=new JMenu("ѧ������");
		menubar2.setFont(font);
		menubar3=new JMenu("�γ̹���");
		menubar3.setFont(font);
		menubar4=new JMenu("�ɼ�����");
		menubar4.setFont(font);
		menubar5=new JMenu("����");
		menubar5.setFont(font);
		menubar6=new JMenu("����");
		menubar6.setFont(font);
		bar1.add(menubar1);
		bar1.add(menubar2);
		bar1.add(menubar3);
		bar1.add(menubar4);
		bar1.add(menubar5);
		bar1.add(menubar6);
		
		//�����˵������ӵ��˵���
		bar1open=new JMenuItem("��½����");
		bar1open.setFont(font1);
		bar1exit=new JMenuItem("�˳�ϵͳ");
		bar1exit.setFont(font1);
		menubar1.add(bar1open);
		menubar1.add(bar1exit);
		
		bar2create=new JMenuItem("��  ��");
		bar2read=new JMenuItem("��  ѯ");
		bar2update=new JMenuItem("��  ��");
		bar2delete=new JMenuItem("ɾ  ��");
		bar2create.setFont(font1);
		bar2read.setFont(font1);
		bar2update.setFont(font1);
		bar2delete.setFont(font1);
		menubar2.add(bar2create);
		menubar2.add(bar2read);
		menubar2.add(bar2update);
		menubar2.add(bar2delete);
		
		bar3create=new JMenuItem("��  ��");
		bar3read=new JMenuItem("��  ѯ");
		bar3update=new JMenuItem("��  ��");
		bar3delete=new JMenuItem("ɾ  ��");
		bar3create.setFont(font1);
		bar3read.setFont(font1);
		bar3update.setFont(font1);
		bar3delete.setFont(font1);
		menubar3.add(bar3create);
		menubar3.add(bar3read);
		menubar3.add(bar3update);
		menubar3.add(bar3delete);
		 
		bar4create=new JMenuItem("��  ��");
		bar4read=new JMenuItem("��  ѯ");
		bar4update=new JMenuItem("��  ��");
		bar4delete=new JMenuItem("ɾ  ��");
		bar4create.setFont(font1);
		bar4read.setFont(font1);
		bar4update.setFont(font1);
		bar4delete.setFont(font1);
		menubar4.add(bar4create);
		menubar4.add(bar4read);
		menubar4.add(bar4update);
		menubar4.add(bar4delete);
		
		bar5other=new JMenuItem("�汾");
		bar5other.setFont(font1);
		menubar5.add(bar5other);
		
		bar6help=new JMenuItem("ʹ��");
		bar6about=new JMenuItem("����");
		bar6help.setFont(font1);
		bar6about.setFont(font1);
		menubar6.add(bar6help);
		menubar6.add(bar6about);
		
		label=new JLabel("      ѧ   ��   ��  ��  ϵ   ͳ");
		label.setFont(new Font("����",Font.BOLD,50));
		textfield1=new JTextArea();
		textfield1.setBackground(Color.gray);
		textfield1.setEditable(false);
	    textfield2 =new JTextArea();
	    textfield2.setBackground(Color.blue);
	    textfield2.setEditable(false);
	    panel=new JPanel();
	    panel.setLayout(new BorderLayout());
	    panel.add(textfield1,BorderLayout.NORTH);
	    panel.add(label,BorderLayout.CENTER);
	    panel.add(textfield2,BorderLayout.SOUTH);
	    this.add(panel);
	    
		this.setTitle(string);
		this.setSize(1050, 850);
		this.setLocation(600, 110);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setJMenuBar(bar1);
		this.setVisible(true);
		
		//���ü���
		bar1open.addActionListener(this);
		bar1exit.addActionListener(this);
		
		bar2create.addActionListener(this);
		bar2read.addActionListener(this);
		bar2update.addActionListener(this);
		bar2delete.addActionListener(this);
		
		bar3create.addActionListener(this);
		bar3read.addActionListener(this);
		bar3update.addActionListener(this);
		bar3delete.addActionListener(this);
		
		bar4create.addActionListener(this);
		bar4read.addActionListener(this);
		bar4update.addActionListener(this);
		bar4delete.addActionListener(this);	
		
		bar5other.addActionListener(this); 
		
		bar6help.addActionListener(this);
		bar6about.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(bar1open)){      //���ص�½����
			JOptionPane.showMessageDialog(null,"�������ص�¼����","��ʾ��Ϣ",JOptionPane.CLOSED_OPTION);
			this.dispose();
			new Login("ѧ������ϵͳ",conn,perstmt); 
		}else if(e.getSource().equals(bar1exit)){    //�˳�ϵͳ
			try {
				DBConnection.Close(conn);
				JOptionPane.showMessageDialog(null,"�ڴ������ٴμ���","��ܰ��ʾ",JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
			
		}else if(e.getSource().equals(bar2create)){    //ѧ����Ϣ���
		    new StudentCreate("���ѧ����Ϣ",conn,perstmt);			
		}else if(e.getSource().equals(bar2read)){      //ѧ����Ϣ��ѯ
			new StudentRead("ѧ����Ϣ��ѯ",conn,perstmt);		
		}else if(e.getSource().equals(bar2update)){     //ѧ����Ϣ�޸�
			new StudentUpdate("�޸�ѧ����Ϣ����",conn,perstmt);			
		}else if(e.getSource().equals(bar2delete)){      //ѧ����Ϣɾ��						
			new StudentDelete("ѧ��ɾ������",conn,perstmt);
			
			
        }else if(e.getSource().equals(bar3create)){    //�γ���Ϣ���
		    new CourseCreate("��ӿγ���Ϣ",conn,perstmt);        	
		}else if(e.getSource().equals(bar3read)){      //�γ���Ϣ��ѯ
			new CourseRead("�γ���Ϣ��ѯ",conn,perstmt);			
		}else if(e.getSource().equals(bar3update)){     //�γ���Ϣ�޸�
			new CourseUpdate("�γ��޸Ľ���",conn,perstmt);
		}else if(e.getSource().equals(bar3delete)){      //�γ���Ϣɾ��
			new CourseDelete("�γ�ɾ������",conn,perstmt);
			
			
        }else if(e.getSource().equals(bar4create)){    //�ɼ���Ϣ���
			new ScoreCreate("��ӳɼ���Ϣ",conn,perstmt);
		}else if(e.getSource().equals(bar4read)){      //�ɼ���Ϣ��ѯ
			new ScoreRead("��ѯ�ɼ���Ϣ",conn,perstmt);			
		}else if(e.getSource().equals(bar4update)){     //�ɼ���Ϣ�޸�
			new ScoreUpdate("�޸ĳɼ�����",conn,perstmt);
		}else if(e.getSource().equals(bar4delete)){      //�ɼ���Ϣɾ��
			new ScoreDelete("ɾ���ɼ�����",conn,perstmt);
			
			
		}else if(e.getSource().equals(bar5other)){        //����
			JOptionPane.showMessageDialog(null,"system 1-1-1.0","�汾��Ϣ",JOptionPane.INFORMATION_MESSAGE);
		}else if(e.getSource().equals(bar6help)){        //ʹ��
			JOptionPane.showMessageDialog(null,"�򿪹��ܿ���ѡ���˳�ϵͳ�����ص�½����\n"
					+ "ѧ��������ѧ����Ϣ������ɾ��Ĳ���\n"
					+ "�γ̹���ͳɼ�����ͬѧ����������\n"
					+ "�������Բ鿴�汾��Ϣ\n","ʹ��",JOptionPane.QUESTION_MESSAGE);
		}else{                                            //����
			JOptionPane.showMessageDialog(null,"��ֻ��һ��Сϵͳ\n"
					+ "�����²�,���Ҳ���","����ϵͳ",JOptionPane.INFORMATION_MESSAGE);
		}
	}

}
