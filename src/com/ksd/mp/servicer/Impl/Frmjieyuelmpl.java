package com.ksd.mp.servicer.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ksd.mp.GuanYi.*;
//import com.ksd.mp.GuanYi.TuShuJieYuexiabu;
import com.ksd.mp.servicer.FrmjieyueServicer;
import com.ksd.mp.util.BaseDao;

public class Frmjieyuelmpl implements FrmjieyueServicer {
	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement ps = null;

	public List<TuShuJieYuexiabu> frmjieyue(String id) {
		// �洢����
		List<TuShuJieYuexiabu> bo = new ArrayList<TuShuJieYuexiabu>();
		// ����
		TuShuJieYuexiabu b = null;
		conn = BaseDao.getConn();

		try {
			st = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "select * from libraryborrow ";
		if (id != null) {
			sql = "select * from libraryborrow  where readerid=" + id + "";
		}
		try {
			rs = st.executeQuery(sql);
			while (rs.next()) {
				b = new TuShuJieYuexiabu();
				b.setReaderid(rs.getInt("readerid"));
				b.setBookcode(rs.getString("bookcode"));
				b.setBorrowdate(rs.getDate("borrowdate"));
				b.setReturndate(rs.getDate("returndate"));
				bo.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.CloseConn(conn, st, rs);
		}
		return bo;
	}

	// ��ѯ����ѡ��ͼ��
	@Override
	public List<BookInfo> jieyuets(String mc, String zy) {
		// TODO Auto-generated method stub
		// �洢����
		List<BookInfo> bok = new ArrayList<BookInfo>();
		// ����
		BookInfo b = null;
		conn = BaseDao.getConn();
		try {
			st = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "select * from libraryBookInfo where 1=1 ";
		if (!mc.equals("")) {
			sql += " and bookname='" + mc + "' ";
		}
		if (!zy.equals("")) {
			sql += " and bookauthor='" + zy + "'";
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

	// ����ͼ��

	@Override
	public Integer jieyues(String sm, String zz, String sj) {
		// TODO Auto-generated method stub
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// �������ڸ�ʽ
		String drs = df.format(new Date());
		Integer num = 0;
		conn = BaseDao.getConn();
		String sql = "insert into  libraryborrow  values (" + sm + ",'" + zz + "','" + drs + "','" + sj + "')  ";
		try {
			st = conn.createStatement();
			num = st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.CloseConn(conn, st, rs);
		}
		return num;
	}

	// �鼮���
	@Override
	public int deltesa(String shum) {
		// TODO Auto-generated method stub
		int num=0;
		String sql = "update libraryBookInfo set bookaddnumber=bookaddnumber-1 where bookname='"+shum+"' ";
		conn = BaseDao.getConn();
		try {
			st = conn.createStatement();
			num = st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.CloseConn(conn, st, rs);
		}
		return num;
	}

}
