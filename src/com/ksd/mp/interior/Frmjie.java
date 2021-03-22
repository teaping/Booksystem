package com.ksd.mp.interior;

import java.util.List;

import javax.swing.JTable;

import com.ksd.mp.GuanYi.BookInfo;
import com.ksd.mp.GuanYi.TuShuJieYuexiabu;
import com.ksd.mp.servicer.FrmjieyueServicer;
import com.ksd.mp.servicer.registerQueryServicer;
import com.ksd.mp.servicer.Impl.Frmjieyuelmpl;
import com.ksd.mp.servicer.Impl.registerQuerylmp;

public class Frmjie {
	public static JTable Frmtable(String mc,String zz){
		FrmjieyueServicer frm =new Frmjieyuelmpl();
		List<BookInfo> s=frm.jieyuets(mc, zz);
		  Object[] columnNames = {"图书编码", "图书名称", "出版社", "入馆数量", "类别","图书作者","图书价钱","入馆日期"};
		  Object[][]  data=new  Object[s.size()][columnNames.length];
	        // 表格所有行数据
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
	   JTable     table = new JTable(data, columnNames){
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		};
	   
	   return table;
	}
	
	public static JTable Frmjiyue(){
		FrmjieyueServicer fr=new Frmjieyuelmpl();
		List<TuShuJieYuexiabu> li=fr.frmjieyue(null);
		Object[] sbg={"读者ID","图书编号","借还日期","归还日期"};
		Object[][] dat=new  Object[li.size()][sbg.length];
		for (int i = 0; i < li.size(); i++) {
			for (int j = 0; j < sbg.length; j++) {
				dat[i][0]=li.get(i).getReaderid();
				dat[i][1]=li.get(i).getBookcode();
				dat[i][2]=li.get(i).getBorrowdate();
				dat[i][3]=li.get(i).getReturndate();
			}
		}
		JTable  table = new JTable(dat, sbg){
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		};
		return table;
	}
	
	
//	public static JTable Frmjiyueone(String bh,String rq){
//		FrmjieyueServicer fr=new Frmjieyuelmpl();
//		 li=fr.jieyues(bh, rq);
//		Object[] sbg={"读者ID","图书编号","借还日期","归还日期"};
//		Object[][] dat=new  Object[li.size()][sbg.length];
//		for (int i = 0; i < li.size(); i++) {
//			for (int j = 0; j < sbg.length; j++) {
//				dat[i][0]=li.get(i).getReaderid();
//				dat[i][1]=li.get(i).getBookcode();
//				dat[i][2]=li.get(i).getBorrowdate();
//				dat[i][3]=li.get(i).getReturndate();
//			}
//		}
//		JTable  table = new JTable(dat, sbg);
//		return table;
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
