package com.ksd.mp.servicer.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ksd.mp.GuanYi.BookInfo;
import com.ksd.mp.GuanYi.Overbook;
import com.ksd.mp.GuanYi.jiexbook;
import com.ksd.mp.GuanYi.readerGu;
import com.ksd.mp.servicer.readerServicer;
import com.ksd.mp.util.BaseDao;

public class rederImpl implements readerServicer {

	Connection conn = BaseDao.getConn();;
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement pt = null;

	// 查询对象
	@Override
	public List<readerGu> readerQuery() {
		// TODO Auto-generated method stub//存储容器
		List<readerGu> bok = new ArrayList<readerGu>();
		// 对象
		readerGu r = null;
		try {
			st = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "select * from libraryreader";
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
	public int rederadditive(readerGu red) {
		int num = 0;
		// TODO Auto-generated method stub
		String sql = "insert into libraryreader(readername,readercardid,readerdate,readertel,readeraddress,readerremark) values(?,?,?,?,?,?)";
		try {
			pt = conn.prepareStatement(sql);
			pt.setString(1, red.getReadername());
			pt.setString(2, red.getReadercardid());
			pt.setString(3, red.getReaderdate());
			pt.setString(4, red.getReadertel());
			pt.setString(5, red.getReaderaddress());
			pt.setString(6, red.getReaderremark());
			num = pt.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return num;
	}

	// 删除读者
	@Override
	public int rederdelete(Integer i) {
		// TODO Auto-generated method stub
		int num = 0;
		// TODO Auto-generated method stub
		String sql = "delete from libraryreader where readerid=?";
		try {
			pt = conn.prepareStatement(sql);
			pt.setInt(1, i);
			num = pt.executeUpdate();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return num;
	}

	// 查询单个对象
	@Override
	public readerGu readerQuery(Integer i) {
		// TODO Auto-generated method stub
		// 对象
		readerGu r = null;
		try {
			st = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "select * from libraryreader where readerid=" + i + " ";
		try {
			rs = st.executeQuery(sql);
			if (rs.next()) {
				r = new readerGu();
				r.setReaderid(rs.getInt("readerid"));
				r.setReadername(rs.getString("readername"));
				r.setReadercardid(rs.getString("readercardid"));
				r.setReaderdate(rs.getString("readerdate"));
				r.setReadertel(rs.getString("readertel"));
				r.setReaderaddress(rs.getString("readeraddress"));
				r.setReaderremark(rs.getString("readerremark"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.CloseConn(conn, st, rs);
		}
		return r;
	}

	// 修改讀者信息
	@Override
	public int rederalter(Integer i, readerGu red) {
		Integer num = null;
		// TODO Auto-generated method stub
		String sql = "update libraryreader set readername=?,"
				+ "readercardid=?,readerdate=?,readertel=?,readeraddress=?,readerremark=? where readerid=?";
		try {
			pt = conn.prepareStatement(sql);
			pt.setString(1, red.getReadername());
			pt.setString(2, red.getReadercardid());
			pt.setString(3, red.getReaderdate());
			pt.setString(4, red.getReadertel());
			pt.setString(5, red.getReaderaddress());
			pt.setString(6, red.getReaderremark());
			pt.setInt(7, i);

			num = pt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return num;
	}

	// 图书借阅
	@Override
	public List<jiexbook> cardbook() {
		// TODO Auto-generated method stub
		List<jiexbook> bok = new ArrayList<jiexbook>();
		// 对象
		jiexbook r = null;
		try {
			st = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "select * from libraryborrow";
		try {
			rs = st.executeQuery(sql);
			while (rs.next()) {
				r = new jiexbook();
				r.setReaderid(rs.getInt("readerid"));

				r.setBookcode(rs.getString("bookcode"));

				r.setBorrowdate(rs.getString("borrowdate"));

				r.setReturndate(rs.getString("returndate"));
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

	// 超期
	@Override
	public List<BookInfo> excessbook() {
		// TODO Auto-generated method stub
		String sql = "select a.*,b.*,c.* from libraryborrow as a join libraryBookInfo as b on "
				+ "a.bookcode=b.bookcode inner join libraryreader c on"
				+ " a.readerid=c.readerid where a.returndate<convert(datetime,getdate())";
		List<BookInfo> bok = new ArrayList<BookInfo>();
		// 对象
		BookInfo r = null;
		try {
			st = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs = st.executeQuery(sql);
			while (rs.next()) {
				r = new BookInfo();

				r.setBookcode(rs.getString("bookcode"));
				r.setBookname(rs.getString("bookname"));
				r.setBookpublish(rs.getString("bookpublish"));
				r.setBookaddnumber(rs.getInt("bookaddnumber"));
				r.setBooksort(rs.getString("booksort"));
				r.setBookauthor(rs.getString("bookauthor"));
				r.setBookprice(rs.getString("bookprice"));
				r.setBooktime(rs.getString("booktime"));
				r.setYhrq(rs.getString("returndate"));
				r.setReadername	(rs.getString("readername"));
				r.setReaderid(rs.getInt("readerid"));
				
				
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
			    try  
			    {  
			      Date d1 = df.parse(rs.getString("returndate"));  
			      Date d2 = new Date();  
			      long diff = d1.getTime() - d2.getTime();//这样得到的差值是毫秒级别  
			      long days = diff / (1000 * 60 * 60 * 24);  
			      r.setCqts((int) days);
			      
			    }catch (Exception e)  
			    {  
			    	e.printStackTrace();
			    }  

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

	
	//查询读者列表
	@Override
	public List<readerGu> readerListQuery(Integer i) {
		// TODO Auto-generated method stub
		List<readerGu> bok = new ArrayList<readerGu>();
		// 对象
		readerGu r = null;
		try {
			st = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "select * from libraryreader where readerid="+i+"";
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
	public List<jiexbook> selectbokk(String i) {
		// TODO Auto-generated method stub
		List<jiexbook> bok = new ArrayList<jiexbook>();
		jiexbook so=null;
		// 对象
		Integer r = null;
		try {
			st = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String bhsa="select  readerid from libraryreader where readername='"+i+"'";
		
		try {
			rs = st.executeQuery(bhsa);
			if (rs.next()) {
				r=rs.getInt("readerid");
//				bok.add(r);
			}
			rs.close();
			String sql = "select * from libraryborrow where readerid="+r+" ";
				rs = st.executeQuery(sql);
				while (rs.next()) {
				so = new jiexbook();
				so.setReaderid(rs.getInt("readerid"));

				so.setBookcode(rs.getString("bookcode"));

				so.setBorrowdate(rs.getString("borrowdate"));

				so.setReturndate(rs.getString("returndate"));
				bok.add(so);
				
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
