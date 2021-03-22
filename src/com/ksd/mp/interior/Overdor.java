package com.ksd.mp.interior;

import java.util.List;

import javax.swing.JTable;

import com.ksd.mp.GuanYi.Chaoqts;
import com.ksd.mp.servicer.OverdueServicer;
import com.ksd.mp.servicer.Impl.Overduelmpl;

public class Overdor {
	
	public static JTable Cqbook(){
		OverdueServicer ov=new Overduelmpl();
		List<Chaoqts> cq=ov.overb();
		  Object[] columnNames = {"图书编码", "图书名称", "图书列别", "出版社", "读者编号","读者姓名","读者身份证","应还天数","天数"};
		  Object[][]  data=new  Object[cq.size()][columnNames.length];
	        // 表格所有行数据
	        for(int i=0;i<cq.size();i++){
	            for(int j=0;j<columnNames.length;j++){
	                data[i][0]=cq.get(i).getBookcode();
	                data[i][1]=cq.get(i).getBookname();
	                data[i][2]=cq.get(i).getBooksort();
	                data[i][3]=cq.get(i).getBookpublish();
	                data[i][4]=cq.get(i).getReaderid();
	                data[i][5]=cq.get(i).getReadername();
	                data[i][6]=cq.get(i).getReadercardid();
	                data[i][7]=cq.get(i).getReturndate();
	                data[i][8]=cq.get(i).getTsq();
	            }
	        }

	        
	        
	        // 创建一个表格，指定 所有行数据 和 表头
	        JTable table = new JTable(data, columnNames){
			    public boolean isCellEditable(int row, int column) {
			        return false;
			    }
			}; 
	        return table;
	}

}
