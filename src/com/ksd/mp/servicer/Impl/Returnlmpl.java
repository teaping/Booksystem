package com.ksd.mp.servicer.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ksd.mp.servicer.ReturnServicer;
import com.ksd.mp.util.BaseDao;

public class Returnlmpl implements ReturnServicer {

	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	//图书归还
	@Override
	public Integer Bookguih(String a, String b) {
		// TODO Auto-generated method stub
		int as=0;
		String sql="delete from libraryborrow where readerid="+a+" and bookcode='"+b+"' ";
		conn=BaseDao.getConn();
		try {
			st =conn.createStatement();
			as=st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return as;
	}
	//归还加
	@Override
	public int deltesa(String as) {
		// TODO Auto-generated method stub
		
		
		int num=0;
		String sql = "update libraryBookInfo set bookaddnumber=bookaddnumber+1 where bookcode='"+as+"' ";
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
