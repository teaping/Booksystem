package com.ksd.mp.servicer;

import java.util.List;
import java.util.Vector;

import com.ksd.mp.GuanYi.BookInfo;
import com.ksd.mp.GuanYi.readerGu;

public interface registerQueryServicer {
	// ��ѯͼ��lnfo
	List<BookInfo> bookQuery(String wen);

	// Vector<Vector<Object>> data=new Vector<Vector<Object>>();
	// ��ѯͼ������lnfo
	List<BookInfo> bookranking();

	// ��ѯ�������аɰ�
	List<readerGu> redaeranking();

	List<BookInfo> bookQueryone(String sa);
	List<BookInfo> bookQueryone();

	List<String> booksortOne();

	List<BookInfo> bookQuerytsys();
}
