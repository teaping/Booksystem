package com.ksd.mp.servicer;

import java.util.List;
import java.util.Vector;

import com.ksd.mp.GuanYi.BookInfo;
import com.ksd.mp.GuanYi.readerGu;

public interface registerQueryServicer {
	// 查询图书lnfo
	List<BookInfo> bookQuery(String wen);

	// Vector<Vector<Object>> data=new Vector<Vector<Object>>();
	// 查询图书排行lnfo
	List<BookInfo> bookranking();

	// 查询读者排行吧榜
	List<readerGu> redaeranking();

	List<BookInfo> bookQueryone(String sa);
	List<BookInfo> bookQueryone();

	List<String> booksortOne();

	List<BookInfo> bookQuerytsys();
}
