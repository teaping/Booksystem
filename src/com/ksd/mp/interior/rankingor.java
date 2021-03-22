package com.ksd.mp.interior;

import java.util.List;

import javax.swing.JTable;

import com.ksd.mp.GuanYi.BookInfo;
import com.ksd.mp.GuanYi.readerGu;
import com.ksd.mp.servicer.registerQueryServicer;
import com.ksd.mp.servicer.Impl.registerQuerylmp;

public class rankingor {
	
	//图书
	public static JTable bookrank(){
		registerQueryServicer r = new registerQuerylmp();
		List<BookInfo> s = r.bookranking();
		Object[] columnNames = { "图书编码", "图书名称", "出版社", "图书类别", "图书作者", "图书价格", "现存数量","时间" };
		Object[][] data = new Object[s.size()][columnNames.length];
		// 表格所有行数据
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
	//读者
	public static JTable readrank(){
		registerQueryServicer r = new registerQuerylmp();
		List<readerGu> s = r.redaeranking();
		Object[] columnNames = { "读者编码", "读者姓名", "身份证",  "登记日期", "读者电话", "读者地址", "备注"};
		Object[][] data = new Object[s.size()][columnNames.length];
		// 表格所有行数据
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
