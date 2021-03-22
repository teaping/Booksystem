package com.ksd.mp.interior;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.ksd.mp.GuanYi.BookInfo;
import com.ksd.mp.servicer.LoginServicer;
import com.ksd.mp.servicer.registerQueryServicer;
import com.ksd.mp.servicer.Impl.LoginServicerlmpl;
import com.ksd.mp.servicer.Impl.registerQuerylmp;

public class refisteror {
	
	public static JTable retable(String wen){
		registerQueryServicer r=new registerQuerylmp(); 
		List<BookInfo> s=r.bookQuery(wen);
		  Object[] columnNames = {"ͼ�����", "ͼ������", "������", "�������", "���","ͼ������","ͼ���Ǯ","�������"};
		  Object[][]  data=new  Object[s.size()][columnNames.length];
	        // �������������
	        for(int i=0;i<s.size();i++){
	            for(int j=0;j<columnNames.length;j++){
	                data[i][0]=s.get(i).getBookcode();
	                data[i][1]=s.get(i).getBookname();
	                data[i][2]=s.get(i).getBookpublish();
	                data[i][3]=s.get(i).getBookaddnumber();
	                data[i][4]=s.get(i).getBooksort();
	                data[i][5]=s.get(i).getBookauthor();
	                data[i][6]=s.get(i).getBookprice();
	                data[i][7]=s.get(i).getBooktime();
	            }
	        }
	   JTable  table = new JTable(data, columnNames){
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		};
	   
	   return table;
	}
	
	
	public static void sobookone(JPanel panel){
		panel.setLayout(new BorderLayout(10, 5));
		// ��ʾ��
		JPanel ts = new JPanel();
		ts.setLayout(new BorderLayout(10, 5));
		// ����
		Border b = new TitledBorder(new LineBorder(Color.black, 1), "��ܰ��ʾ");
		ts.setBorder(b);
		panel.add(ts);
		//����ͼ����Ϣ����
	
	        
	       JTable table = refisteror.retable(null);
	        panel.add(table.getTableHeader(), BorderLayout.NORTH);
	        // �� ������� ��ӵ���������
	        panel.add(table, BorderLayout.CENTER);
	}
	
	
	
	public static BookInfo Uptableoneqwe( String i ){
		LoginServicer r=new LoginServicerlmpl() ; 
		BookInfo s=r.psSelStudentBySid(i);
	   
	   return s;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static JTable Uptable( String i ){
		LoginServicer r=new LoginServicerlmpl() ; 
		BookInfo s=r.psSelStudentBySid(i);
		  Object[] columnNames = {"ͼ�����", "ͼ������", "������", "�������", "���","ͼ������","ͼ���Ǯ","�������"};
		  Object[][]  data=new  Object[1][columnNames.length];
	        // �������������
	        
	                data[0][0]=s.getBookcode();
	                data[0][1]=s.getBookname();
	                data[0][2]=s.getBookpublish();
	                data[0][3]=s.getBookaddnumber();
	                data[0][4]=s.getBooksort();
	                data[0][5]=s.getBookauthor();
	                data[0][6]=s.getBookprice();
	                data[0][7]=s.getBooktime();
	   JTable    table = new JTable(data,columnNames){
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		};
	   
	   return table;
	}
	public static JTable Uptabletow(String bookname,String bookcode,String bookpublish){
		LoginServicer r=new LoginServicerlmpl() ; 
		List<BookInfo> s=r.psSelStudentByzong(bookname, bookcode, bookpublish);
		  Object[] columnNames = {"ͼ�����", "ͼ������", "������", "�������", "���","ͼ������","ͼ���Ǯ","�������"};
		  Object[][]  data=new  Object[s.size()][columnNames.length];
	        // �������������
	        for(int i=0;i<s.size();i++){
	            for(int j=0;j<columnNames.length;j++){
	                data[i][0]=s.get(i).getBookcode();
	                data[i][1]=s.get(i).getBookname();
	                data[i][2]=s.get(i).getBookpublish();
	                data[i][3]=s.get(i).getBookaddnumber();
	                data[i][4]=s.get(i).getBooksort();
	                data[i][5]=s.get(i).getBookauthor();
	                data[i][6]=s.get(i).getBookprice();
	                data[i][7]=s.get(i).getBooktime();
	            }
	        }
	        
	   JTable    table = new JTable(data,columnNames){
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		};
	   
	   return table;
	}


	public static JTable retableone(String sa){
		registerQueryServicer r=new registerQuerylmp(); 
		List<BookInfo> s=r.bookQueryone(sa);
		  Object[] columnNames = {"ͼ�����", "ͼ������", "������", "�������", "���","ͼ������","ͼ���Ǯ","�������"};
		  Object[][]  data=new  Object[s.size()][columnNames.length];
	        // �������������
	        for(int i=0;i<s.size();i++){
	            for(int j=0;j<columnNames.length;j++){
	                data[i][0]=s.get(i).getBookcode();
	                data[i][1]=s.get(i).getBookname();
	                data[i][2]=s.get(i).getBookpublish();
	                data[i][3]=s.get(i).getBookaddnumber();
	                data[i][4]=s.get(i).getBooksort();
	                data[i][5]=s.get(i).getBookauthor();
	                data[i][6]=s.get(i).getBookprice();
	                data[i][7]=s.get(i).getBooktime();
	            }
	        }

	        
	   JTable table = new JTable(data, columnNames){
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		};;
	   
	   return table;
	}
	
	public static JTable retableone(){
		registerQueryServicer r=new registerQuerylmp(); 
		List<BookInfo> s=r.bookQueryone();
		  Object[] columnNames = {"ͼ�����", "ͼ������", "������", "�������", "���","ͼ������","ͼ���Ǯ","�������"};
		  Object[][]  data=new  Object[s.size()][columnNames.length];
	        // �������������
	        for(int i=0;i<s.size();i++){
	            for(int j=0;j<columnNames.length;j++){
	                data[i][0]=s.get(i).getBookcode();
	                data[i][1]=s.get(i).getBookname();
	                data[i][2]=s.get(i).getBookpublish();
	                data[i][3]=s.get(i).getBookaddnumber();
	                data[i][4]=s.get(i).getBooksort();
	                data[i][5]=s.get(i).getBookauthor();
	                data[i][6]=s.get(i).getBookprice();
	                data[i][7]=s.get(i).getBooktime();
	            }
	        }

	        
	   JTable   table = new JTable(data, columnNames){
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		};
	   
	   return table;
	}
	
	
	
	public static void sobookoneone(JPanel panel,String sa){
		panel.setLayout(new BorderLayout(10, 5));
		// ��ʾ��
		JPanel ts = new JPanel();
		ts.setLayout(new BorderLayout(10, 5));
		// ����
		Border b = new TitledBorder(new LineBorder(Color.black, 1), "��ܰ��ʾ");
		ts.setBorder(b);
		panel.add(ts);
		//����ͼ����Ϣ����
		 	JTable table= refisteror.retableone(sa);
	        
	      
	        panel.add(table.getTableHeader(), BorderLayout.NORTH);
	        // �� ������� ��ӵ���������
	        panel.add(table, BorderLayout.CENTER);
	}
	
	public static void sobookoneone(JPanel panel){
		panel.setLayout(new BorderLayout(10, 5));
		// ��ʾ��
		JPanel ts = new JPanel();
		ts.setLayout(new BorderLayout(10, 5));
		// ����
		Border b = new TitledBorder(new LineBorder(Color.black, 1), "��ܰ��ʾ");
		ts.setBorder(b);
		panel.add(ts);
		//����ͼ����Ϣ����
		 	JTable table= refisteror.retableone();
	      
	        panel.add(table.getTableHeader(), BorderLayout.NORTH);
	        // �� ������� ��ӵ���������
	        panel.add(table, BorderLayout.CENTER);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public static JTable losebookone(){
		JTable tanle=null;
		registerQueryServicer r=new registerQuerylmp(); 
		List<BookInfo> s=r.bookQuerytsys();
		  Object[] columnNames = {"ͼ�����", "ͼ������", "������", "���","�۸�","���߱��","�黹����","��������","���֤","�绰","��ע","��ַ"};
		  Object[][]  data=new  Object[s.size()][columnNames.length];
	        // �������������
	        for(int i=0;i<s.size();i++){
	            for(int j=0;j<columnNames.length;j++){
	                data[i][0]=s.get(i).getBookcode();
	                data[i][1]=s.get(i).getBookname();
	                data[i][2]=s.get(i).getBookpublish();
	                data[i][3]=s.get(i).getBooksort();
	                data[i][4]=s.get(i).getBookprice();
	                data[i][5]=s.get(i).getReaderid();
	                data[i][6]=s.get(i).getRetumdate();
	                data[i][7] =s.get(i).getReadername();
	                data[i][8] =s.get(i).getReadercardid();
	                data[i][9] =s.get(i).getReadertel();
	                data[i][10] =s.get(i).getReaderremark();
	                data[i][11] =s.get(i).getReaderaddress();
	        
	            }
	        }
	        tanle=new JTable(data, columnNames){
			    public boolean isCellEditable(int row, int column) {
			        return false;
			    }
			};  
	        
	        return tanle;
	}























































}
