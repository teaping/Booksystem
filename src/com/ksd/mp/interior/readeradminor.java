package com.ksd.mp.interior;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.ksd.mp.GuanYi.BookInfo;
import com.ksd.mp.GuanYi.jiexbook;
import com.ksd.mp.GuanYi.readerGu;
import com.ksd.mp.servicer.readerServicer;
import com.ksd.mp.servicer.Impl.rederImpl;

public class readeradminor {
	//��ѯ�����б�
	public static JTable adminq(){
		readerServicer r = new rederImpl();
		List<readerGu> s = r.readerQuery();
		Object[] columnNames = { "���߱���", "��������", "���֤", "�Ǽ�����", "���ߵ绰", "���ߵ�ַ", "��ע" };
		Object[][] data = new Object[s.size()][columnNames.length];
		// �������������
		for (int i = 0; i < s.size(); i++) {
			for (int j = 0; j < columnNames.length; j++) {
				data[i][0] = s.get(i).getReaderid();
				data[i][1] = s.get(i).getReadername();
				data[i][2] = s.get(i).getReadercardid();
				data[i][3] = s.get(i).getReaderdate();
				data[i][4] = s.get(i).getReadertel();
				data[i][5] = s.get(i).getReaderaddress();
				data[i][6] = s.get(i).getReaderremark();
			}
		}

		JTable table = new JTable(data, columnNames){
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		};
		
		return table;
	}
	
	//���ߵǼǹ���ɾ��ˢ��
	public static void bookupde(JPanel panelz) {
		// TODO Auto-generated method stub
		
		panelz.setLayout(new BorderLayout(10, 5));
		JTable  table =readeradminor.adminq();
		panelz.add(table.getTableHeader(), BorderLayout.NORTH);

		table.addMouseListener(new MouseAdapter() {
			@Override

			public void mouseClicked(MouseEvent e) {

				JPopupMenu m1 = new JPopupMenu();
				JMenuItem m2 = new JMenuItem("��Ӷ���");
				m1.add(m2);
				JMenuItem m3 = new JMenuItem("ɾ������");
				m3.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub

						int index1 = table.getSelectedRow();// ��ȡѡ�е���
						Integer key = (Integer) table.getValueAt(index1, 0);
					   	readerServicer rada=new rederImpl();
					   	int	n =rada.rederdelete(key);
						   if(n<1){

							    JOptionPane.showMessageDialog(panelz,"ɾ��ʧ��", "����",JOptionPane.WARNING_MESSAGE);
						   }

						   	panelz.removeAll();
						   	readeradminor.bookupde(panelz);
							panelz.revalidate();
					}
				});
				m1.add(m3);
				JMenu m4 = new JMenu("��������");
				m1.add(m4);
				JMenuItem mdz = new JMenuItem("����ַ");
				m4.add(mdz);
				JMenuItem mxm = new JMenuItem("������");
				m4.add(mxm);
				if (table.getSelectedRow() != -1) {
					if (e.getButton() == MouseEvent.BUTTON3) {
						// �����˵���λ��
						m1.show(table, e.getX(), e.getY());

					}
				}
			}

		
		});

		// �� ������� ��ӵ�������
		panelz.add(table, BorderLayout.CENTER);

	}
	
	//��ѯ���߽����
		public static JTable card(){
			readerServicer r = new rederImpl();
			List<jiexbook> s = r.cardbook();
			Object[] columnNames = { "���߱���", "ͼ�����", "��������", "��������"};
			Object[][] data = new Object[s.size()][columnNames.length];
			// �������������
			for (int i = 0; i < s.size(); i++) {
				for (int j = 0; j < columnNames.length; j++) {
					data[i][0] = s.get(i).getReaderid();
					data[i][1] = s.get(i).getBookcode();
					data[i][2] = s.get(i).getBorrowdate();
					data[i][3] = s.get(i).getReturndate();
				}
			}

			JTable table = new JTable(data, columnNames){
			    public boolean isCellEditable(int row, int column) {
			        return false;
			    }
			};
			return table;
		}
	
		public static JTable sele(String ia){
			readerServicer r = new rederImpl();
			List<jiexbook> s = r.selectbokk(ia);
			Object[] columnNames = { "���߱���", "ͼ�����", "��������", "��������"};
			Object[][] data = new Object[s.size()][columnNames.length];
			// �������������
			for (int i = 0; i < s.size(); i++) {
				for (int j = 0; j < columnNames.length; j++) {
					data[i][0] = s.get(i).getReaderid();
					data[i][1] = s.get(i).getBookcode();
					data[i][2] = s.get(i).getBorrowdate();
					data[i][3] = s.get(i).getReturndate();
				}
			}

			JTable table = new JTable(data, columnNames){
			    public boolean isCellEditable(int row, int column) {
			        return false;
			    }
			};
			
			return table;
			
		}
		
		
		
		
		

		//��ѯͼ�鳬�ڱ�
		public static JTable cqbi(){
			readerServicer r = new rederImpl();
			List<BookInfo> s = r.excessbook();
			Object[] columnNames = { "ͼ������","������", "���߱��", "��������", "��������","Ӧ������"};
			Object[][] data = new Object[s.size()][columnNames.length];
			// �������������
			for (int i = 0; i < s.size(); i++) {
				for (int j = 0; j < columnNames.length; j++) {
					data[i][0] = s.get(i).getBookname();
					data[i][1] = s.get(i).getBookpublish();
					data[i][2] = s.get(i).getReaderid();
					data[i][3] = s.get(i).getReadername();
					data[i][4] = s.get(i).getCqts();
					data[i][5] = s.get(i).getYhrq();
					
				}
			}

			JTable table = new JTable(data, columnNames){
			    public boolean isCellEditable(int row, int column) {
			        return false;
			    }
			};
			
			return table;
		}
	

		
		
		//��ѯid�����б�
		public static JTable Idadminq(Integer iq){
			readerServicer r = new rederImpl();
			List<readerGu> s = 	r.readerListQuery(iq);
			
			Object[] columnNames = { "���߱���", "��������", "���֤", "�Ǽ�����", "���ߵ绰", "���ߵ�ַ", "��ע" };
			Object[][] data = new Object[s.size()][columnNames.length];
			// �������������
			for (int i = 0; i < s.size(); i++) {
				for (int j = 0; j < columnNames.length; j++) {
					data[i][0] = s.get(i).getReaderid();
					data[i][1] = s.get(i).getReadername();
					data[i][2] = s.get(i).getReadercardid();
					data[i][3] = s.get(i).getReaderdate();
					data[i][4] = s.get(i).getReadertel();
					data[i][5] = s.get(i).getReaderaddress();
					data[i][6] = s.get(i).getReaderremark();
				}
			}

			JTable table = new JTable(data, columnNames){
			    public boolean isCellEditable(int row, int column) {
			        return false;
			    }
			};
			
			return table;
		}
}
