package ManagementSystem;

import java.sql.*;
public class SystemDemo {
	private static Connection conn=null;
	private static PreparedStatement perstmt=null;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		conn=DBConnection.getDBConnection();
		 //new StudentSystem("ѧ������ϵͳ--ѧ������","",conn,perstmt);
	  //	new TimeTable();
		//new MyInfo(""+"ͬѧ�ĳɼ�","",conn,perstmt);
		//new TimeTable();
 //		new TeacherSystem("ѧ������ϵͳ--��ʦ����",conn,perstmt);
		new Login("ѧ������ϵͳ",conn,perstmt);	
		
		// new Password("ѧ������ϵͳ","",conn,perstmt);
		//new CourseCreate("��ӿγ���Ϣ",conn,perstmt);
		//new StudentCreate("���ѧ����Ϣ",conn,perstmt);
		//new ScoreCreate("��ӳɼ���Ϣ",conn,perstmt);
		//new Update2("�޸�ѧ���ɼ���Ϣ","14","14",conn,perstmt);
		//new ScoreDelete("ɾ���ɼ�����",conn,perstmt);
		//new CourseUpdate("�޸�ѧ����Ϣ����",conn,perstmt);
		//new Update1("�޸Ľ���","025",conn,perstmt);
     //   perstmt.close();
      //  conn.close();
	}

}
