package com.ksd.mp.interior;

import java.util.List;

import javax.swing.JTable;

import com.ksd.mp.GuanYi.TuShuJieYuexiabu;
import com.ksd.mp.servicer.FrmjieyueServicer;
import com.ksd.mp.servicer.Impl.Frmjieyuelmpl;

public class Bookren {

	public static JTable bookjs(String id){
		FrmjieyueServicer fr=new Frmjieyuelmpl();
		List<TuShuJieYuexiabu> li=fr.frmjieyue(id);
		Object[] sbg={"����ID","ͼ����","�軹����","�黹����"};
		Object[][] dat=new  Object[li.size()][sbg.length];
		for (int i = 0; i < li.size(); i++) {
			for (int j = 0; j < sbg.length; j++) {
				dat[i][0]=li.get(i).getReaderid();
				dat[i][1]=li.get(i).getBookcode();
				dat[i][2]=li.get(i).getBorrowdate();
				dat[i][3]=li.get(i).getReturndate();
			}
		}
		// ����һ�����ָ�� ���������� �� ��ͷ
        JTable bt = new JTable(dat, sbg){
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		};  
        return bt;
	}
	
}
