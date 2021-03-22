package com.ksd.mp.servicer.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ksd.mp.GuanYi.BookInfo;
import com.ksd.mp.GuanYi.TuShuJieYuexiabu;
import com.ksd.mp.GuanYi.readerGu;
import com.ksd.mp.servicer.BookrenServicer;
import com.ksd.mp.util.BaseDao;

public class Bookrenlmpl implements BookrenServicer {

	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	@Override
	public readerGu tusxujie(readerGu restu) {
		// TODO Auto-generated method stub
		readerGu sd=null;
		String sql="select * from libraryreader where 1=1 ";
		if(!restu.getReadername().equals("")){
			sql+=" and readername='"+restu.getReadername()+"'";
		}
		if(!restu.getReadercardid().equals("")){
			sql+=" and readercardid='"+restu.getReadercardid()+"'";
		}
		if(!restu.getReaderaddress().equals("")){
			sql+=" and readeraddress='"+restu.getReaderaddress()+"'";
		}
		try {
			conn=BaseDao.getConn();
			st =conn.createStatement();
			rs=st.executeQuery(sql);
					while (rs.next()) {
						sd=new readerGu();
						sd.setReaderid(rs.getInt("readerid"));
						sd.setReadername(rs.getString("readername"));
						sd.setReadercardid(rs.getString("readercardid"));
						sd.setReaderaddress(rs.getString("readeraddress"));
						sd.setReadertel(rs.getString("readertel"));
						sd.setReaderremark(rs.getString("readerremark"));
						sd.setReaderdate(rs.getString("readerdate"));
					}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			BaseDao.CloseConn(conn, st, rs);
		}
		return sd;
			
		}
	
	
	//查询图书
	@Override
	public BookInfo Bangba(String i,String bh) {
		// TODO Auto-generated method stub
		BookInfo sa=null;
		String sql="select * from libraryborrow  as a join libraryBookInfo"
				+ " as b on a.bookcode=b.bookcode where"
				+ " a.bookcode='"+i+"' and a.readerid="+bh+"";
		try {
			conn=BaseDao.getConn();
			st =conn.createStatement();
			rs=st.executeQuery(sql);
			if (rs.next()) {
						sa=new BookInfo();
						sa.setBookname(rs.getString("bookname"));
						sa.setBookcode(rs.getString("bookcode"));
						sa.setBooksort(rs.getString("booksort"));
						sa.setBookauthor(rs.getString("bookauthor"));
						sa.setRetumdate(rs.getString("returndate"));
						sa.setBorrowdate(rs.getString("borrowdate"));
					}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			BaseDao.CloseConn(conn, st, rs);
		}
	return sa;
		
	}


	//修改借阅时间
	@Override
	public int insertXj(String as,String bh ,String ts) {
		// TODO Auto-generated method stub
		int num=0;
		String sql="update  libraryborrow  set  returndate=dateadd(DAY,"+ts+",returndate) where readerid="+as+" and bookcode='"+bh+"'";
		
		conn=BaseDao.getConn();
		try {
			st =conn.createStatement();
			num=st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return num;
	}
}

