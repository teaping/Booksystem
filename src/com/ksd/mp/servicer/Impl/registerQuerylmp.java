package com.ksd.mp.servicer.Impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ksd.mp.GuanYi.BookInfo;
import com.ksd.mp.GuanYi.readerGu;
import com.ksd.mp.servicer.registerQueryServicer;
import com.ksd.mp.util.BaseDao;

public class registerQuerylmp implements registerQueryServicer {

	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;

	@Override
	public List<BookInfo> bookQuery(String wen) {
		// TODO Auto-generated method stub
		// 存储容器
		List<BookInfo> bok = new ArrayList<BookInfo>();
		// 对象
		BookInfo b = null;
		conn = BaseDao.getConn();
		try {
			st = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "select * from libraryBookInfo";
		if(wen!=null){
			sql = "select * from libraryBookInfo where booksort='"+wen+"'";
		}
		
		
		try {
			rs = st.executeQuery(sql);
			while (rs.next()) {
				b = new BookInfo();
				b.setBookcode(rs.getString("bookcode"));
				b.setBookname(rs.getString("bookname"));
				b.setBookpublish(rs.getString("bookpublish"));
				b.setBookaddnumber(rs.getInt("bookaddnumber"));
				b.setBooksort(rs.getString("booksort"));
				b.setBookauthor(rs.getString("bookauthor"));
				b.setBookprice(rs.getString("bookprice"));
				b.setBooksort(rs.getString("booksort"));
				b.setBooktime(rs.getString("booktime"));
				bok.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.CloseConn(conn, st, rs);
		}
		return bok;
	}

	// 查询图书排行
	@Override
	public List<BookInfo> bookranking() {
		// TODO Auto-generated method stub // TODO Auto-generated method stub
		// 存储容器
		List<BookInfo> bok = new ArrayList<BookInfo>();
		// 对象
		BookInfo b = null;
		conn = BaseDao.getConn();
		try {
			st = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "select top (10) a.num,b.* from(select count (*) as num,bookcode "
				+ "from  libraryborrow group by bookcode ) as a inner join libraryBookInfo as b on a.bookcode=b.bookcode  order  by a.bookcode asc ";
		try {
			rs = st.executeQuery(sql);
			while (rs.next()) {
				b = new BookInfo();
				b.setBookcode(rs.getString("bookcode"));
				b.setBookname(rs.getString("bookname"));
				b.setBookpublish(rs.getString("bookpublish"));
				b.setBookaddnumber(rs.getInt("bookaddnumber"));
				b.setBooksort(rs.getString("booksort"));
				b.setBookauthor(rs.getString("bookauthor"));
				b.setBookprice(rs.getString("bookprice"));
				b.setBooksort(rs.getString("booksort"));
				b.setBooktime(rs.getString("booktime"));
				bok.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.CloseConn(conn, st, rs);
		}
		return bok;
	}

	// 读者排行
	@Override
	public List<readerGu> redaeranking() {
		// TODO Auto-generated method stub//存储容器
		List<readerGu> bok = new ArrayList<readerGu>();
		// 对象
		readerGu r = null;
		conn = BaseDao.getConn();
		try {
			st = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = " select top (10) a.num,b.* from(select count (*) as num,readerid "
				+ "from  libraryborrow group by readerid  ) as a inner join libraryreader as b on a.readerid=b.readerid order  by a.num desc ";
		try {
			rs = st.executeQuery(sql);
			while (rs.next()) {
				r = new readerGu();
				r.setReaderid(rs.getInt("readerid"));
				r.setReadername(rs.getString("readername"));
				r.setReadercardid(rs.getString("readercardid"));
				r.setReaderdate(rs.getString("readerdate"));
				r.setReadertel(rs.getString("readertel"));
				r.setReaderaddress(rs.getString("readeraddress"));
				r.setReaderremark(rs.getString("readerremark"));
				bok.add(r);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.CloseConn(conn, st, rs);
		}
		return bok;
	}

	@Override
	public List<BookInfo> bookQueryone(String sa) {
		// TODO Auto-generated method stub
		List<BookInfo> bok = new ArrayList<BookInfo>();
		// 对象
		BookInfo b = null;
		conn = BaseDao.getConn();
		try {
			st = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "select * from libraryBookInfo where booksort='" + sa + "'";
		if(sa==null){
			 sql = "select * from libraryBookInfo";
		}
		
		try {
			rs = st.executeQuery(sql);
			while (rs.next()) {
				b = new BookInfo();
				b.setBookcode(rs.getString("bookcode"));
				b.setBookname(rs.getString("bookname"));
				b.setBookpublish(rs.getString("bookpublish"));
				b.setBookaddnumber(rs.getInt("bookaddnumber"));
				b.setBooksort(rs.getString("booksort"));
				b.setBookauthor(rs.getString("bookauthor"));
				b.setBookprice(rs.getString("bookprice"));
				b.setBooksort(rs.getString("booksort"));
				b.setBooktime(rs.getString("booktime"));
				bok.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.CloseConn(conn, st, rs);
		}
		return bok;
	}
	
	public List<BookInfo> bookQueryone() {
		// TODO Auto-generated method stub
		List<BookInfo> bok = new ArrayList<BookInfo>();
		// 对象
		BookInfo b = null;
		conn = BaseDao.getConn();
		try {
			st = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "select * from libraryBookInfo";
		try {
			rs = st.executeQuery(sql);
			while (rs.next()) {
				b = new BookInfo();
				b.setBookcode(rs.getString("bookcode"));
				b.setBookname(rs.getString("bookname"));
				b.setBookpublish(rs.getString("bookpublish"));
				b.setBookaddnumber(rs.getInt("bookaddnumber"));
				b.setBooksort(rs.getString("booksort"));
				b.setBookauthor(rs.getString("bookauthor"));
				b.setBookprice(rs.getString("bookprice"));
				b.setBooksort(rs.getString("booksort"));
				b.setBooktime(rs.getString("booktime"));
				bok.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.CloseConn(conn, st, rs);
		}
		return bok;
	}
	
	

	@Override
	public List<String> booksortOne() {
		// TODO Auto-generated method stub
		conn = BaseDao.getConn();
		try {
			st = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<String> las = new ArrayList<>();
		String sql = "select booksort  from libraryBookInfo   GROUP BY booksort ";

		try {
			rs = st.executeQuery(sql);
			while (rs.next()) {
				String s = rs.getString("booksort");
				las.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.CloseConn(conn, st, rs);
		}
		return las;
	}

	@Override
	public List<BookInfo> bookQuerytsys() {
		// TODO Auto-generated method stub
		List<BookInfo> bok = new ArrayList<BookInfo>();
		// 对象
		BookInfo b = null;
		conn = BaseDao.getConn();
		try {
			st = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "select a.bookcode,a.bookname,a.bookpublish,a.booksort,a.bookprice,b.readerid,b.returndate,c.readername,c.readercardid,c.readertel,c.readerremark,c.readeraddress from libraryBookInfo a, libraryborrow b , libraryreader c  where a.bookcode=b.bookcode and b.readerid=c.readerid and b.readerid is not null";
		try {
			rs = st.executeQuery(sql);
			while (rs.next()) {
				b = new BookInfo();
				b.setBookcode(rs.getString("bookcode"));
				b.setBookname(rs.getString("bookname"));
				b.setBookpublish(rs.getString("bookpublish"));
				b.setBooksort(rs.getString("booksort"));
				b.setBookprice(rs.getString("bookprice"));
				b.setReaderid(rs.getInt("readerid"));
				b.setRetumdate(rs.getString("returndate"));
				b.setReadername(rs.getString("readername"));
				b.setReadercardid(rs.getString("readercardid"));
				b.setReadertel(rs.getString("readertel"));
				b.setReaderremark(rs.getString("readerremark"));
				b.setReaderaddress(rs.getString("readeraddress"));
				bok.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.CloseConn(conn, st, rs);
		}
		return bok;
	}

}
