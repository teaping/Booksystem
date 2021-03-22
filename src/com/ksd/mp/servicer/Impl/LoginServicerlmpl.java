package com.ksd.mp.servicer.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.ksd.mp.GuanYi.BookInfo;
import com.ksd.mp.controller.logfrom;
import com.ksd.mp.servicer.LoginServicer;
import com.ksd.mp.util.BaseDao;




public class LoginServicerlmpl implements LoginServicer {
	Connection conn=null;
	Statement st=null;
	ResultSet rs=null;
	PreparedStatement ps=null;

	//查询
	@Override
	public String query(String id, String pwd) {
		String userpwd=null;
		String yanz=null;
		// TODO Auto-generated method stub
		conn=BaseDao.getConn();
		try {
			st =conn.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String sql="select count(*) from libraryUser where username='"+id+"'";
	try {
		//判断是否有该条记录
		rs=st.executeQuery(sql);
		rs.next();  
	    int s = rs.getInt(1);
		if(s==0){
			yanz= "账号错误";
		}else{
			 sql="select * from libraryUser where username='"+id+"'";
			//根据名获取密码
			 rs=st.executeQuery(sql);
			if(rs.next()){
				yanz= "密码错误";
				userpwd=rs.getString("userpassword");
				//判断密码是否正确
				if(userpwd.equals(pwd)){
					yanz=" ";
					logfrom.uview=rs.getString("userpurview");
				}
				
			}
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		BaseDao.CloseConn(conn, st, rs);
	}
		return yanz;
	}

	@Override
	public void cancel() {
		// TODO Auto-generated method stub

	}
	
	
	
	public int wnUpdateInfo(String bookname,BookInfo bkf) {
		int r = 0;
	
		conn = BaseDao.getConn();
		String sql = "update libraryBookInfo set bookcode='" + bkf.getBookcode() + "'"
				+ ",bookpublish='" + bkf.getBookpublish() + "'," + "bookaddnumber='"
				+ bkf.getBookaddnumber() + "',booksort='" + bkf.getBooksort() + "'," + "bookauthor='"
				+ bkf.getBookauthor() + "'," + "booktime='" + bkf.getBooktime()
				+ "' where bookname='" +bookname+ "'";
		try {
		st=conn.createStatement();
		r=st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.CloseConn(conn, st, rs);
		}
		return r;
	}
	/**
	 * 图书遗失管理  确认遗失
	 * */
	public int wnUpdateInfotxys(String bookid,Integer i) {
		int r = 0;
		int	rqw=0;
	
		conn = BaseDao.getConn();
		String sql="delete from libraryborrow where bookcode='"+bookid+"' and readerid="+i+"";
			try {
		st=conn.createStatement();
		r=st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			BaseDao.CloseConn(conn, st, rs);
		} 
			rqw=wnlose(r,bookid);
		
		return rqw;
	}
	
	
	private int wnlose(int r,String bookid){
		conn = BaseDao.getConn();
		int	rq=0;
		if(r>0){
		String	sql = "update libraryBookInfo set bookaddnumber= bookaddnumber-1 where bookcode='" +bookid+ "'";
			try {
				st=conn.createStatement();
				rq=st.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				BaseDao.CloseConn(conn, st, rs);
			}
			
		}
		return rq;
	}
	public int insertlibrarian(BookInfo bkf) {
		conn = BaseDao.getConn();
		String sql1 = "insert into libraryBookInfo(bookcode,bookname,bookpublish,bookaddnumber,booksort,bookauthor,bookprice,booktime) values('"
				+ bkf.getBookcode() + "','" + bkf.getBookname() + "','" + bkf.getBookpublish() + "','"
				+ bkf.getBookaddnumber() + "','" + bkf.getBooksort() + "','" + bkf.getBookauthor() + "','"
				+ bkf.getBookprice() + "','" + bkf.getBooktime() + "')";
		int r = 0;
		try {
			r = st.executeUpdate(sql1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;

	}

	public int psinsertlibrarian(BookInfo bkf) {
		int r = 0;
		conn = BaseDao.getConn();
		String sql3 = "insert into libraryBookInfo(bookcode,bookname,bookpublish,bookaddnumber,booksort,bookauthor,bookprice,booktime) values(?,?,?,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql3);
			ps.setString(1, bkf.getBookcode());
			ps.setString(2, bkf.getBookname());
			ps.setString(3, bkf.getBookpublish());
			ps.setInt(4, bkf.getBookaddnumber());
			ps.setString(5, bkf.getBooksort());
			ps.setString(6, bkf.getBookauthor());
			ps.setString(7, bkf.getBookprice());
			ps.setString(8, bkf.getBooktime());
			r = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.CloseConn(conn, ps, rs);
		}
		return r;
	}

	public int psDellibrarian(String bookcode) {
		conn = BaseDao.getConn();
		String sql = "delete from libraryBookInfo where bookcode=?";
		int r3 = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, bookcode);
			r3 = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			BaseDao.CloseConn(conn, st, rs);
		}
		return r3;
	}

	public BookInfo psSelStudentBySid(String bookname) {
		conn = BaseDao.getConn();
		String sql = "select * from libraryBookInfo where  bookname=? ";
		BookInfo bkf = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, bookname);
			rs = ps.executeQuery();
			if (rs.next()) {
				bkf = getLib(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			BaseDao.CloseConn(conn, st, rs);
		}
		return bkf;
	}

	public BookInfo getLib(ResultSet rs2) {
		BookInfo bkf = null;
		try {
			String bookcode = rs.getString("bookcode");
			String bookname = rs.getString("bookname");
			int bookaddnumber = rs.getInt("bookaddnumber");
			String bookpublish = rs.getString("bookpublish");
			String booksort = rs.getString("booksort");
			String bookauthor = rs.getString("bookauthor");
			String bookprice=rs.getString("bookprice");
			String booktime = rs.getString("booktime");
			bkf = new BookInfo(bookprice,bookcode, bookname, bookpublish,
					bookaddnumber, booksort, bookauthor, booktime);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			BaseDao.CloseConn(conn, st, rs);
		}
		return bkf;
	}

	public BookInfo psSelStudentBy(String bookname, String bookcode, String bookpublish) {
		conn = BaseDao.getConn();
		try {
			st = conn.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String sql = "select * from libraryBookInfo where 1=1";
		if(!bookname.equals("")){
			sql+=" and bookname like '%" + bookname + "%' ";
		}
		if(!bookcode.equals("")){
			sql+=" and bookcode like '%" +bookcode + "%' ";
		}
		if(!bookpublish.equals("")){
			sql+="  and bookpublish like '%" + bookpublish + "%' ";
		}
		BookInfo bkf = null;
		try {
			rs = st.executeQuery(sql);
			if (rs.next()) {
				bkf = gettow(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.CloseConn(conn, st, rs);
		}
		return bkf;
	}

	public BookInfo gettow(ResultSet rs2) {
		BookInfo bkf = null;
		try {
			String bookcode = rs.getString("bookcode");
			String bookname = rs.getString("bookname");
			int bookaddnumber = rs.getInt("bookaddnumber");
			String bookpublish = rs.getString("bookpublish");
			String booksort = rs.getString("booksort");
			String bookauthor = rs.getString("bookauthor");
			String bookprice = rs.getString("bookprice");
			String booktime = rs.getString("booktime");
			bkf = new BookInfo(bookcode, bookname, bookpublish, bookaddnumber, booksort, bookauthor, bookprice,booktime);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bkf;
	}
	
	
	
	
	
	/**
	 * 图书遗失查询
	 * */
	public BookInfo psSelStudentBytsys(String readerid) {
		conn = BaseDao.getConn();
		try {
			st = conn.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String sql = "select a.bookcode,a.bookname,a.bookpublish,a.booksort,b.readerid,b.returndate,c.readername,c.readercardid,c.readertel,c.readerremark,c.readeraddress from libraryBookInfo a, libraryborrow b , libraryreader c  where a.bookcode=b.bookcode and b.readerid=c.readerid  and b.readerid='"+readerid+"' ";
		BookInfo bkf = null;
		try {
			rs = st.executeQuery(sql);
			if (rs.next()) {
				bkf = gettowtsys(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			BaseDao.CloseConn(conn, st, rs);
		}
		return bkf;
	}

	public BookInfo gettowtsys(ResultSet rs2) {
		BookInfo bkf = null;
		try {
			String bookcode = rs.getString("bookcode");
			String bookname = rs.getString("bookname");
			String bookpublish = rs.getString("bookpublish");
			String booksort = rs.getString("booksort");
			int readerid=rs.getInt("readerid");
			String retumdate=rs.getString("returndate");
			String readername=rs.getString("readername");
			String readercardid=rs.getString("readercardid");
			String readertel=rs.getString("readertel");
			String readerremark=rs.getString("readerremark");
			String readeraddress =rs.getString("readeraddress");
			bkf = new BookInfo(bookcode, bookname, bookpublish,
					booksort, readerid, retumdate, readername, 
					readercardid, readertel, readerremark, readeraddress);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			BaseDao.CloseConn(conn, st, rs);
		}
		return bkf;
	}

	public ResultSet wnSelectInfo(String sql2) {
		conn = BaseDao.getConn();

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.CloseConn(conn, st, rs);
		}
		return rs;
	}

	public List<BookInfo> getLibList() {
		List<BookInfo> list = new ArrayList<BookInfo>();
		conn = BaseDao.getConn();
		String sql = "select * from libraryBookInfo ";
		rs = wnSelectInfo(sql);
		BookInfo bkf = null;
		try {
			while (rs.next()) {
				bkf = bookByrs(rs);
				list.add(bkf);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			BaseDao.CloseConn(conn, st, rs);
		}

		return list;
	}

	// 数据集
	public BookInfo bookByrs(ResultSet rs2) {
		BookInfo bkf = null;
		try {
			String bookcode = rs.getString("bookcode");
			String bookname = rs.getString("bookname");
			String bookpublish = rs.getString("bookpublish");
			int bookaddnumber = rs.getInt("bookaddnumber");
			String booksort = rs.getString("booksort");
			String bookauthor = rs.getString("bookauthor");
			String bookprice = rs.getString("bookprice");
			String booktime = rs.getString("booktime");
			bkf = new BookInfo(bookcode, bookname, 
					bookpublish, bookaddnumber, booksort, bookauthor, bookprice,
					booktime);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			BaseDao.CloseConn(conn, st, rs);
		}
		return bkf;
	}

	/**
	 * 根据表格绑定学生信息
	 */
	public void bindTablelibList(JTable jt, BookInfo bkf) {
		conn = BaseDao.getConn();
		String sql = "select * from libraryBookInfot where 1=1";
		if (!bkf.getBookcode().equals("")) {
			sql += " and bookcode like='%" + bkf.getBookcode() + "%' ";
		}
		if (!bkf.getBookname().equals("")) {
			sql += " and bookname like='%" + bkf.getBookname() + "%' ";
		}
		if (!bkf.getBookpublish().equals("")) {
			sql += " and Bookpublish like='%" + bkf.getBookpublish() + "%'";
		}
		if (bkf.getBookaddnumber() != 0) {
			sql += " and Bookaddnumber like=" + bkf.getBookaddnumber();
		}
		if (!bkf.getBooksort().equals("")) {
			sql += " and Booksort like='%" + bkf.getBooksort() + "%'";
		}
		if (!bkf.getBookauthor().equals("")) {
			sql += " and Bookauthor like='%" + bkf.getBookauthor() + "%'";
		}
		if (!bkf.getBookprice().equals("")) {
			sql += " and bookprice like='%" + bkf.getBookprice() + "%'";
		}
		if (!bkf.getBooktime().equals("")) {
			sql += " and booktime like='%" + bkf.getBooktime() + "%'";
		}
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			Vector<String> v = null;
			DefaultTableModel dtm = null;
			while (rs.next()) {
				// 1、Vector<String>
				v = new Vector<String>();
				// 2、为集合中绑定数据 对应表头列
				v.add(rs.getString("bookcode"));
				v.add(rs.getString("bookname"));
				v.add(rs.getString("bookpublish"));
				v.add(rs.getString("bookaddnumber"));
				v.add(rs.getString("booksort"));
				v.add(rs.getString("bookauthor"));
				v.add(rs.getString("bookprice"));
				v.add(rs.getString("booktime"));
				// 准备数据库模型
				dtm = (DefaultTableModel) jt.getModel();
				dtm.addRow(v);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.CloseConn(conn, st, rs);
		}
	}

	public List<BookInfo> psSelTree(String booksort) {
		conn = BaseDao.getConn();
		List<BookInfo> list = new ArrayList<BookInfo>();
		String sql = "select * from libraryBookInfo where  booksort=? ";
		BookInfo bkf = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, booksort);
			rs = ps.executeQuery();
			if (rs.next()) {
				bkf = getLib(rs);
				list.add(bkf);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			BaseDao.CloseConn(conn,ps, rs);
		}
		return list;
	}

	@Override
	public String queryQx(String da) {
		// TODO Auto-generated method stub
		String qux=null;
		conn = BaseDao.getConn();
		String sql="select * from  libraryUser  where username='"+da+"'";
		try {
			st=conn.createStatement();
			rs=st.executeQuery(sql);
			if(rs.next()){
				qux=rs.getString("userpurview");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {

			BaseDao.CloseConn(conn,st, rs);
		}
		
		return qux;
	}

	@Override
	public List<BookInfo> psSelStudentByzong(String bookname, String bookcode, String bookpublish) {
		// TODO Auto-generated method stub
		List<BookInfo> bok=new ArrayList<>();
		conn = BaseDao.getConn();
		String sql = "select * from libraryBookInfo where 1=1";
		if(!bookname.equals("")){
			sql+=" and bookname like '%" + bookname + "%' ";
		}
		if(!bookcode.equals("")){
			sql+=" and bookcode like '%" +bookcode + "%' ";
		}
		if(!bookpublish.equals("--请选择--")){
			sql+="  and bookpublish like '%" + bookpublish + "%' ";
			System.out.println("Qe");
		}
		BookInfo bkf = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				bkf = gettow(rs);
				bok.add(bkf);
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



