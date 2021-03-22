package com.ksd.mp.controller.borrow;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.ksd.mp.controller.borrow.Overdue;
import com.ksd.mp.GuanYi.Chaoqts;
import com.ksd.mp.servicer.Impl.Overduelmpl;
public class Ovbdwbk extends JPanel{
	JTable jt=null;//表格对象
	private Object stuBean;
	public static Chaoqts chao=null;
	public Ovbdwbk(){
		jt=new JTable();
		jt.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				int row=jt.getSelectedRow();
				String bookcode=jt.getValueAt(row, 0).toString().trim();
				String bookname=jt.getValueAt(row, 1).toString().trim();
				String booksort=jt.getValueAt(row, 2).toString().trim();
				String bookpublish=jt.getValueAt(row, 3).toString().trim();
				String readerid=jt.getValueAt(row, 4).toString().trim();
				String readername=jt.getValueAt(row, 5).toString().trim();
				String readercardid=jt.getValueAt(row, 6).toString().trim();
				Overdue.txttsbh.setText(bookcode);
				Overdue.txttsbh.setText(bookname);
				Overdue.txttsbh.setText(booksort);
				Overdue.txttsbh.setText(bookpublish);
				Overdue.txttsbh.setText(readerid);
				Overdue.txttsbh.setText(readername);
				Overdue.txttsbh.setText(readercardid);
			}
		});
		
		
		
		
	}
	
	
}
