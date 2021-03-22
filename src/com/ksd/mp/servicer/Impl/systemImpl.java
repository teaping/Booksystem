package com.ksd.mp.servicer.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ksd.mp.GuanYi.readerGu;
import com.ksd.mp.GuanYi.yhDx;
import com.ksd.mp.interior.systemad;
import com.ksd.mp.servicer.systemServier;
import com.ksd.mp.util.BaseDao;

public class systemImpl implements systemServier {

	Connection conn = BaseDao.getConn();;
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement pt = null;

	// �޸�����
	@Override
	public String changepassword(String id, String pwd, String m) {
		// TODO Auto-generated method stub
		String userpwd = null;
		String yanz = null;
		// TODO Auto-generated method stub
		conn = BaseDao.getConn();
		try {
			st = conn.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String sql = "select count(*) from libraryUser where username='" + id + "'";
		try {
			// �ж��Ƿ��и�����¼
			rs = st.executeQuery(sql);
			rs.next();
			int s = rs.getInt(1);
			if (s == 0) {
				yanz = "�˺Ŵ���";
			} else {
				sql = "select * from libraryUser where username='" + id + "'";
				// ��������ȡ����
				rs = st.executeQuery(sql);
				if (rs.next()) {
					yanz = "�������";
					userpwd = rs.getString("userpassword");
					// �ж������Ƿ���ȷ
					if (userpwd.equals(pwd)) {
						sql = "update libraryUser set userpassword='" + m + "' where username='" + id + "'";
						Integer n = st.executeUpdate(sql);
						yanz = n.toString();
					} else {
						yanz = "�������";
					}

				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.CloseConn(conn, st, rs);
		}
		return yanz;
	}

	// �û���ѯ
	@Override
	public List<yhDx> sysQuery() {
		// TODO Auto-generated method stub
		List<yhDx> bok = new ArrayList<yhDx>();
		String sql = "select * from libraryUser";
		yhDx r = null;
		try {
			st = conn.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			rs = st.executeQuery(sql);
			while (rs.next()) {
				r = new yhDx();
				r.setUserid(rs.getInt("userid"));
				r.setUsername(rs.getString("username"));
				r.setUserpassword(rs.getString("userpassword"));
				r.setUsertel(rs.getString("usertel"));
				r.setUseraddress(rs.getString("useraddress"));
				r.setUserdate(rs.getString("userdate"));
				r.setUserpurview(rs.getString("userpurview"));
				r.setUsertruce(rs.getString("usertruce"));
				bok.add(r);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bok;
	}

	// ɾ���û�
	@Override
	public Integer deleteSys(Integer i) {
		// TODO Auto-generated method stub
		Integer num = 0;
		String sql = "delete from libraryUser where userid=?";
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

	// ���
	@Override
	public Integer addSys(yhDx r) {
		// TODO Auto-generated method stub
		Integer num = 0;
		String sql = "insert into libraryUser(username,userpassword,"
				+ "usertel,useraddress,userdate,userpurview,usertruce) values(?,?,?,?,?,?,?)";
		try {
			pt = conn.prepareStatement(sql);
			pt.setString(1, r.getUsername());
			pt.setString(2, r.getUserpassword());
			pt.setString(3, r.getUsertel());
			pt.setString(4, r.getUseraddress());
			pt.setString(5, r.getUserdate());
			pt.setString(6, r.getUserpurview());
			pt.setString(7, r.getUsertruce());

			num = pt.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return num;
	}
	// ��ѯ�����û�

	@Override
	public yhDx sysInquire(Integer i) {
		// TODO Auto-generated method stub
		yhDx r = null;
		try {
			st = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "select * from libraryUser where userid=" + i + "";
		try {
			rs = st.executeQuery(sql);
			while (rs.next()) {
				r = new yhDx();
				r.setUserid(rs.getInt("userid"));
				r.setUsername(rs.getString("username"));
				r.setUserpassword(rs.getString("userpassword"));
				r.setUsertel(rs.getString("usertel"));
				r.setUseraddress(rs.getString("useraddress"));
				r.setUserdate(rs.getString("userdate"));
				r.setUserpurview(rs.getString("userpurview"));
				r.setUsertruce(rs.getString("usertruce"));
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return r;

	}

	// �޸�
	@Override
	public Integer sysQuery(Integer i, yhDx r) {
		// TODO Auto-generated method stub
		Integer num = null;

		String sql = "update libraryUser set username='"+r.getUsername()+"',"
				+ "userpassword='"+r.getUserpassword()+"',usertel='"+r.getUsertel()+"',"
				+ "useraddress='"+r.getUseraddress()+"',userdate='"+r.getUserdate()+"',userpurview='"+r.getUserpurview()+"',"
						+ "usertruce='"+r.getUsertruce()+"' where userid="+i+"";
		try {
			st=conn.createStatement();

			num = st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}

}
