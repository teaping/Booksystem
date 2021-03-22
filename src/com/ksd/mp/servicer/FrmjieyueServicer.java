package com.ksd.mp.servicer;

import java.util.List;

import com.ksd.mp.GuanYi.BookInfo;
import com.ksd.mp.GuanYi.TuShuJieYuexiabu;

public interface FrmjieyueServicer {
	List<TuShuJieYuexiabu> frmjieyue(String id);
	
	//查询借阅选择图书
	List<BookInfo> jieyuets(String  mc,String zy);
	//借阅图书
	Integer jieyues(String sm,String smm,String sj);

	//书借出
	int deltesa(String shum);
	
	
}
