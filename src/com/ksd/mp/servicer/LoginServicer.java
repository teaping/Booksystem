package com.ksd.mp.servicer;

import java.sql.ResultSet;
import java.util.List;

import javax.swing.JTable;

import com.ksd.mp.GuanYi.BookInfo;


/***
 * ����
 * @author Asus
 *
 */

public interface LoginServicer {
	
	/**������֤
	 * @param id �˺�
	 * @param pwd  ����
	 * @return
	 */
	String query(String id,String pwd);
	
	//ȡ������
	void  cancel();
	
	int insertlibrarian(BookInfo bkf);
	int psinsertlibrarian(BookInfo bkf);
	int psDellibrarian(String bookcode);
	BookInfo psSelStudentBySid(String bookname);
	ResultSet wnSelectInfo(String sql2);
	List<BookInfo> getLibList();
	BookInfo bookByrs(ResultSet rs2);
	void bindTablelibList(JTable jt,BookInfo bkf);
	BookInfo psSelStudentBy(String bookname,String bookcode,String bookpublish);
	int wnUpdateInfo(String bookname,BookInfo bkf);
	BookInfo psSelStudentBytsys(String readerid);
	int wnUpdateInfotxys(String bookid,Integer i);

	String queryQx(String da);
	
	//��ѯͼ��
	List<BookInfo>	psSelStudentByzong(String bookname,String bookcode,String bookpublish);
	
	


}
