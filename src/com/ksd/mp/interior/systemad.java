package com.ksd.mp.interior;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.ksd.mp.GuanYi.yhDx;
import com.ksd.mp.servicer.systemServier;
import com.ksd.mp.servicer.Impl.systemImpl;

//�û���Ϣ��
public class systemad {

	public static JTable systemas() {
		systemServier r = new systemImpl();
		List<yhDx> s = r.sysQuery();
		Object[] columnNames = { "�û����", "�û�����", "��ϵ�绰", "�û���ַ", "�Ǽ�����", "Ȩ��", "״̬" };
		Object[][] data = new Object[s.size()][columnNames.length];
		// �������������
		for (int i = 0; i < s.size(); i++) {
			for (int j = 0; j < columnNames.length; j++) {
				data[i][0] = s.get(i).getUserid();
				data[i][1] = s.get(i).getUsername();
				data[i][2] = s.get(i).getUsertel();
				data[i][3] = s.get(i).getUseraddress();
				data[i][4] = s.get(i).getUserdate();
				data[i][5] = s.get(i).getUserpurview();
				data[i][6] = s.get(i).getUsertruce();

			}
		}

		JTable table = new JTable(data, columnNames){
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		};
		Font font1 = new Font("����",Font.PLAIN,18);
		table.setFont(font1);
		return table;
	}
	
	public static void sysupde(JPanel panelw){
		panelw.setLayout(new BorderLayout(5,2));
		panelw.setBorder(new LineBorder(Color.BLACK, 2));
		Border brs = new TitledBorder(new LineBorder(Color.black, 1), "�����û�");
		panelw.setBorder(brs);

        JTable table = systemad.systemas();
//        table.addMouseListener(new MouseAdapter() {
//        	
//        	public void mouseClicked(MouseEvent e) {
//        		int index1 = table.getSelectedRow();// ��ȡѡ�е���
//        		Integer key = (Integer) table.getValueAt(index1, 0);
//        	}
//		});
        
        
        panelw.add(table.getTableHeader(), BorderLayout.NORTH);
        // �� ������� ��ӵ�������
        panelw.add(table,BorderLayout.CENTER);
		
		
	}
	
	
	
	
}
