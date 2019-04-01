package ManagementSystem;
	
	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	
	import javax.swing.*;
	import javax.swing.table.DefaultTableModel;
	
	public class TimeTable extends JFrame implements ActionListener{
	         private JPanel panel;
	         private DefaultTableModel model;
	         private JTable table;
	         private JScrollPane jsp;
	         private JLabel label;
	         public TimeTable(){
	           //��ֵ
	        	/* Object[][] data={ {"  ","  ","","","  ",""," "," "},
	        			 {"  1-2��"," �ߵ���ѧ","  "," Ӣ���д","  "," ���Դ���"," "," "},
	        			 {"  3-4��"," C++"," �ߵ���ѧ"," Ӣ������˵"," ��ѧ���� ",""," "," "},
	        			 {"  ","  ","","","  ",""," "," "},
	        			 {"  5-6��","  "," �� ��"," �� ��"," ��ѧ���� ",""," "," "},       			
	        			 {"  7-8��"," �� ��"," ��ѧ����"," "," �ߵ���ѧ "," "," "," "},
	        			 {"","  ","","","  ",""," "," "},
	        			 {"  9-10��"," �� ��"," �� ��"," �� ��"," �� �� ",""," "," �� ��"}
	        	 };*/
	        	 String[] rowName={"    ","����һ","���ڶ�","������","������","������","������","������"};     
	 		     model = new DefaultTableModel(rowName,10);
	 			 table = new JTable(model);
	 			 jsp = new JScrollPane(table);
	 	         for(int i=0;i<8;i++){
	 	        	 switch(i){
	 	        	 case 0:
	 	        		 String[] str0={"  ","  ","","","  ",""," "," "};
	 	        		 for(int j=0;j<8;j++){
	 	        			table.setValueAt(str0[j],i,j); 
	 	        		 } 	        	
	                    break;
	 	        	case 1:
	 	        		String[] str1={"  1-2��"," �ߵ���ѧ","  "," Ӣ���д","  "," ���Դ���"," "," "};
	 	        		for(int j=0;j<8;j++){
	 	        			table.setValueAt(str1[j],i,j); 
	 	        		 } 	        					   
	                    break;
	 	        	case 2:
	 	        		String[] str2={"  3-4��"," C++"," �ߵ���ѧ"," Ӣ������˵"," ��ѧ���� ",""," "," "};
	 	        		for(int j=0;j<8;j++){
	 	        			table.setValueAt(str2[j],i,j); 
	 	        		 } 	  
	                    break;
	 	        	case 3:
	 	        		String[] str3={"  ","  ","","","  ",""," "," "};
	 	        		for(int j=0;j<8;j++){
	 	        			table.setValueAt(str3[j],i,j); 
	 	        		 } 	  
	                    break;
	 	        	case 4:
	 	        		String[] str4={"  5-6��","  "," �� ��"," �� ��"," ��ѧ���� ",""," "," "};
	 	        		for(int j=0;j<8;j++){
	 	        			table.setValueAt(str4[j],i,j); 
	 	        		 } 	  
	                    break;
	 	        	case 5:
	 	        		String[] str5={"  7-8��"," �� ��"," ��ѧ����"," "," �ߵ���ѧ "," "," "," "};
	 	        		for(int j=0;j<8;j++){
	 	        			table.setValueAt(str5[j],i,j); 
	 	        		 } 	  
	                    break;
	 	        	case 6:
	 	        		String[] str6={"","  ","","","  ",""," "," "};
	 	        		for(int j=0;j<8;j++){
	 	        			table.setValueAt(str6[j],i,j); 
	 	        		 } 	  
	                    break;
	 	        	case 7:
	 	        		String[] str7={"  9-10��"," �� ��"," �� ��"," �� ��"," �� �� ",""," "," �� ��"};
	 	        		for(int j=0;j<8;j++){
	 	        			table.setValueAt(str7[j],i,j); 
	 	        		 } 	  
	                    break;
	 	        	 }
	 	         }
	//        	 table=new JTable(data,rowName);//����������       
	//        	 panel =new JPanel();
	//        	 panel.setLayout(new FlowLayout());
	//        	 panel.add(new JScrollPane(table));
	 	         this.setLayout(new GridLayout(1,1));
	        	 this.setTitle("�γ̱�");
	        	 this.setSize(800,240); 
	        	 this.add(jsp);
	        	 this.setVisible(true);
	        	 this.setLocation(600,300);
	         }
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
	}
