package com.ksd.mp.servicer;

import java.util.List;

import com.ksd.mp.GuanYi.BookInfo;
import com.ksd.mp.GuanYi.TuShuJieYuexiabu;
import com.ksd.mp.GuanYi.readerGu;

public interface BookrenServicer {

	//ͼ�������ѯ
	 readerGu tusxujie(readerGu restu);

	 //��ѯͼ��
	BookInfo Bangba(String i,String bh);
	
	//�޸Ľ���ʱ��
	int insertXj(String as,String bh ,String ts);
	
}
