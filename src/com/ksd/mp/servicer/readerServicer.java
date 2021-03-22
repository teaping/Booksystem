package com.ksd.mp.servicer;

import java.util.List;

import com.ksd.mp.GuanYi.BookInfo;
import com.ksd.mp.GuanYi.Overbook;
import com.ksd.mp.GuanYi.jiexbook;
import com.ksd.mp.GuanYi.readerGu;


public interface readerServicer {
	//查询所有读者
	List<readerGu> readerQuery();

	//查询单个读者
	readerGu readerQuery(Integer i);
	
	
	//查询读者列表
	List<readerGu> readerListQuery(Integer i);
	
	//添加读者
	int rederadditive(readerGu red);
	
	//删除读者
	int rederdelete(Integer i);
	
	//修改讀者信息
	int	rederalter(Integer i,readerGu red);
	
	//查询借阅信息表
	List<jiexbook> cardbook();
	
	//连和查询超期表

	List<BookInfo> excessbook();
	
	//查询
	List<jiexbook> selectbokk(String i);
}
