package com.ksd.mp.interior;

import java.util.List;

import javax.swing.JTable;

import com.ksd.mp.GuanYi.BookInfo;
import com.ksd.mp.GuanYi.readerGu;
import com.ksd.mp.servicer.registerQueryServicer;
import com.ksd.mp.servicer.Impl.registerQuerylmp;

public class rankingor {
	
	//ͼ��
	public static JTable bookrank(){
		registerQueryServicer r = new registerQuerylmp();
		List<BookInfo> s = r.bookranking();
		Object[] columnNames = { "ͼ�����", "ͼ������", "������", "ͼ�����", "ͼ������", "ͼ��۸�", "�ִ�����","ʱ��" };
		Object[][] data = new Object[s.size()][columnNames.length];
		// �������������
		for (int i = 0; i < s.size(); i++) {
			for (int j = 0; j < columnNames.length; j++) {
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
		};
		
		return table;
	}
	//����
	public static JTable readrank(){
		registerQueryServicer r = new registerQuerylmp();
		List<readerGu> s = r.redaeranking();
		Object[] columnNames = { "���߱���", "��������", "���֤",  "�Ǽ�����", "���ߵ绰", "���ߵ�ַ", "��ע"};
		Object[][] data = new Object[s.size()][columnNames.length];
		// �������������
		for (int i = 0; i < s.size(); i++) {
			for (int j = 0; j < columnNames.length; j++) {
				data[i][0] = s.get(i).getReaderid();
				data[i][1] = s.get(i).getReadername();
				data[i][2] = s.get(i).getReadercardid();
				data[i][3] = s.get(i).getReaderdate();
				data[i][4] = s.get(i).getReadertel();
				data[i][5] = s.get(i).getReaderaddress();
				data[i][6] = s.get(i).getReaderremark();
			}
		}

		JTable table = new JTable(data, columnNames){
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		};
		
		return table;
	}


}
