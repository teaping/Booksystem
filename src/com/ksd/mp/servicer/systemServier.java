package com.ksd.mp.servicer;

import java.util.List;

import com.ksd.mp.GuanYi.yhDx;

//ϵͳ
public interface systemServier {
	//�޸�����
	String changepassword(String user,String pwd,String m);

	//�û���ѯ
	List<yhDx> sysQuery();
	
	//�û�ɾ��
	Integer deleteSys(Integer i);
	
	//����û�
	Integer addSys(yhDx s);
	
	//��ѯ�����û�
	yhDx sysInquire(Integer i);
	
	//�޸��û�
	Integer sysQuery(Integer i,yhDx st);

}
