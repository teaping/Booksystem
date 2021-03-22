package com.ksd.mp.servicer.Impl;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import com.ksd.mp.util.BaseDao;
import com.ksd.mp.GuanYi.*;

import java.util.ArrayList;

import com.ksd.mp.servicer.OverdueServicer;

public class Overduelmpl implements OverdueServicer{
	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	
	@Override
	public List<Chaoqts> overb() {
		// TODO Auto-generated method stub
		//´æ´¢ÈÝÆ÷
				List<Chaoqts> chao=new ArrayList<Chaoqts>();
				//¶ÔÏó
				Chaoqts c=null;
				conn=BaseDao.getConn();
				
						try {
							st =conn.createStatement();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						String sql="select a.bookcode,a.bookname,a.booksort,a.bookpublish,b.readerid,c.readername,c.readercardid,b.returndate,"
								+ " datediff(day,b.returndate ,GETDATE())  as raet from "
								+ " libraryBookInfo a,libraryborrow b, libraryreader c where "
								+ " a.bookcode=b.bookcode and b.readerid=c.readerid and b.returndate< GETDATE()";
						try {
							rs=st.executeQuery(sql);
							while (rs.next()) {
								c=new Chaoqts();
								c.setBookcode(rs.getString("bookcode"));
								c.setBookname(rs.getString("bookname"));
								c.setBooksort(rs.getString("booksort"));
								c.setBookpublish(rs.getString("bookpublish"));
								c.setReaderid(rs.getInt("readerid"));
								c.setReadername(rs.getString("readername"));
								c.setReadercardid(rs.getString("readercardid"));
								c.setTsq(rs.getString("raet"));
								c.setReturndate(rs.getString("returndate"));
								chao.add(c);
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}finally {
							BaseDao.CloseConn(conn, st, rs);
						}
						return chao;
	}
	
}
