package com.ksd.mp.servicer;

import java.util.List;

import com.ksd.mp.GuanYi.BookInfo;
import com.ksd.mp.GuanYi.TuShuJieYuexiabu;

public interface FrmjieyueServicer {
	List<TuShuJieYuexiabu> frmjieyue(String id);
	
	//��ѯ����ѡ��ͼ��
	List<BookInfo> jieyuets(String  mc,String zy);
	//����ͼ��
	Integer jieyues(String sm,String smm,String sj);

	//����
	int deltesa(String shum);
	
	
}
