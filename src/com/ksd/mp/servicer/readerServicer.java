package com.ksd.mp.servicer;

import java.util.List;

import com.ksd.mp.GuanYi.BookInfo;
import com.ksd.mp.GuanYi.Overbook;
import com.ksd.mp.GuanYi.jiexbook;
import com.ksd.mp.GuanYi.readerGu;


public interface readerServicer {
	//��ѯ���ж���
	List<readerGu> readerQuery();

	//��ѯ��������
	readerGu readerQuery(Integer i);
	
	
	//��ѯ�����б�
	List<readerGu> readerListQuery(Integer i);
	
	//��Ӷ���
	int rederadditive(readerGu red);
	
	//ɾ������
	int rederdelete(Integer i);
	
	//�޸��x����Ϣ
	int	rederalter(Integer i,readerGu red);
	
	//��ѯ������Ϣ��
	List<jiexbook> cardbook();
	
	//���Ͳ�ѯ���ڱ�

	List<BookInfo> excessbook();
	
	//��ѯ
	List<jiexbook> selectbokk(String i);
}
