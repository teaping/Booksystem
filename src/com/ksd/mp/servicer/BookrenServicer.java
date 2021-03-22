package com.ksd.mp.servicer;

import java.util.List;

import com.ksd.mp.GuanYi.BookInfo;
import com.ksd.mp.GuanYi.TuShuJieYuexiabu;
import com.ksd.mp.GuanYi.readerGu;

public interface BookrenServicer {

	//图书续借查询
	 readerGu tusxujie(readerGu restu);

	 //查询图书
	BookInfo Bangba(String i,String bh);
	
	//修改借阅时间
	int insertXj(String as,String bh ,String ts);
	
}
