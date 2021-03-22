package com.ksd.mp.servicer;

import java.util.List;

import com.ksd.mp.GuanYi.yhDx;

//系统
public interface systemServier {
	//修改密码
	String changepassword(String user,String pwd,String m);

	//用户查询
	List<yhDx> sysQuery();
	
	//用户删除
	Integer deleteSys(Integer i);
	
	//添加用户
	Integer addSys(yhDx s);
	
	//查询单个用户
	yhDx sysInquire(Integer i);
	
	//修改用户
	Integer sysQuery(Integer i,yhDx st);

}
