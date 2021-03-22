package com.ksd.mp.controller.reader;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.ksd.mp.GuanYi.BookInfo;
import com.ksd.mp.GuanYi.readerGu;
import com.ksd.mp.interior.readeradminor;
import com.ksd.mp.servicer.readerServicer;
import com.ksd.mp.servicer.registerQueryServicer;
import com.ksd.mp.servicer.Impl.rederImpl;
import com.ksd.mp.servicer.Impl.registerQuerylmp;
import com.ksd.mp.util.DateChooserJButton;

//������Ϣ����
public class readerinformation extends JFrame {
	JPanel panezs=null;
	public readerinformation() {
		super("������Ϣ����");
		this.setSize(1000, 800);
		this.setLocationRelativeTo(null);
		Container con = this.getContentPane();
		con.setLayout(new BorderLayout(10, 5));
		// �󲿲���
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.BLACK, 2));

		// �в�����
		JPanel panelz = new JPanel();
//		panelz.setBorder(new LineBorder(Color.red, 2));ad
		panelz.setLayout(new GridLayout(2, 1, 10, 50));
		// ��������
		hint(panel, panelz);

		con.add(panel, BorderLayout.WEST);
		con.add(panelz, BorderLayout.CENTER);
		this.setVisible(true);
		// �رշ�ʽ
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	// �м�
	// private void bookupde(JPanel panelz,) {
	// // TODO Auto-generated method stub
	//
	// }
	// ��߶��߻�����Ϣ
	private void hint(JPanel panleq, JPanel panelz) {

		panleq.setLayout(new BorderLayout(10, 5));

		// TODO Auto-generated method stub
		JPanel panel = new JPanel();
		Border br = new TitledBorder(new LineBorder(Color.black, 1), "���߻�����Ϣ");
		panel.setBorder(br);
		// ���߻�����Ϣ����
		// meagesd(panel);

		panel.setLayout(new GridLayout(8, 2, 10, 50));
		// TODO Auto-generated method stub

		JLabel lbabh = new JLabel("���߱��");
		panel.add(lbabh);
		JTextField txzzbh = new JTextField();
		panel.add(txzzbh);

		JLabel lbaxm = new JLabel("����");
		panel.add(lbaxm);
		JTextField txxm = new JTextField();
		panel.add(txxm);

		JLabel lbazj = new JLabel("֤��");
		panel.add(lbazj);
		JTextField txzzj = new JTextField();
		panel.add(txzzj);

		JLabel lbadz = new JLabel("��ַ");
		panel.add(lbadz);
		JTextField txzdz = new JTextField();
		panel.add(txzdz);

		JLabel lbarq = new JLabel("����");
		panel.add(lbarq);
		JButton txrq = new JButton();
		txrq.add(new DateChooserJButton(new SimpleDateFormat("yyyy/MM/dd HH"), "2012/12/12 22"),
				java.awt.BorderLayout.CENTER);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();
		int w = txrq.getWidth();
		int h = txrq.getHeight();
		txrq.setSize(200, 200);
		panel.add(txrq);

		JLabel lbadh = new JLabel("�绰");
		panel.add(lbadh);
		JTextField txzdh = new JTextField();
		panel.add(txzdh);

		JLabel lbabz = new JLabel("��ע");
		panel.add(lbabz);
		JTextField txbz = new JTextField();
		panel.add(txbz);

		panleq.add(panel, BorderLayout.CENTER);

		JButton btncx = new JButton("��ѯ");
		btncx.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String xms=txxm.getText();

				if(xms.equals("")){
					panezs.removeAll();

					Border brA = new TitledBorder(new LineBorder(Color.black, 1), "���߽����");
					panezs.setBorder(brA);

					panezs.setLayout(new BorderLayout(10, 5));
					// ���ı�
					JTable table = readeradminor.card();

					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							if (table.getSelectedRow() != -1) {
								int index1 = table.getSelectedRow();// ��ȡѡ�е���
								Integer key = (Integer) table.getValueAt(index1, 0);
								readerServicer r = new rederImpl();
								readerGu rd = r.readerQuery(key);
								txzzbh.setText(rd.getReaderid().toString());
								txxm.setText(rd.getReadername());
								txzzj.setText(rd.getReadercardid());
								txzdz.setText(rd.getReaderaddress());
								txrq.removeAll();
								// 2009-03-26 00:00:00.0
								txrq.add(new DateChooserJButton(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), rd.getReaderdate()),
										java.awt.BorderLayout.CENTER);
								txrq.revalidate();
								txzdh.setText(rd.getReadertel());
								txbz.setText(rd.getReaderremark());
							}
						}

					});

					panezs.add(table.getTableHeader(), BorderLayout.NORTH);
					// �� ������� ��ӵ�������
					panezs.add(table, BorderLayout.CENTER);
					
					panezs.revalidate();
				}else{
					panezs.removeAll();

					Border brA = new TitledBorder(new LineBorder(Color.black, 1), "���߽����");
					panezs.setBorder(brA);

					panezs.setLayout(new BorderLayout(10, 5));
					// ���ı�
					JTable table = readeradminor.sele(xms);

					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							if (table.getSelectedRow() != -1) {
								int index1 = table.getSelectedRow();// ��ȡѡ�е���
								Integer key = (Integer) table.getValueAt(index1, 0);
								readerServicer r = new rederImpl();
								readerGu rd = r.readerQuery(key);
								txzzbh.setText(rd.getReaderid().toString());
								txxm.setText(rd.getReadername());
								txzzj.setText(rd.getReadercardid());
								txzdz.setText(rd.getReaderaddress());
								txrq.removeAll();
								// 2009-03-26 00:00:00.0
								txrq.add(new DateChooserJButton(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), rd.getReaderdate()),
										java.awt.BorderLayout.CENTER);
								txrq.revalidate();
								txzdh.setText(rd.getReadertel());
								txbz.setText(rd.getReaderremark());
							}
						}

					});

					panezs.add(table.getTableHeader(), BorderLayout.NORTH);
					// �� ������� ��ӵ�������
					panezs.add(table, BorderLayout.CENTER);
					
					panezs.revalidate();
					
				}
				
				
			}
		});
		panel.add(btncx);
		JButton btnqk = new JButton("���");
		btnqk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txzzbh.setText("");
				txxm.setText("");
				txzzj.setText("");
				txzdz.setText("");
				txrq.removeAll();
        		txrq.add(new DateChooserJButton(new SimpleDateFormat("yyyy/MM/dd HH"), "2012/12/12 22"),java.awt.BorderLayout.CENTER);
				txrq.revalidate();
				txzdh.setText("");
				txbz.setText("");
			}
		});
		panel.add(btnqk);

		// ��ܰ��ʾ
		JPanel ts = new JPanel();
		ts.setLayout(new BorderLayout(10, 5));
		// ����
		Border b = new TitledBorder(new LineBorder(Color.black, 1), "��ܰ��ʾ");
		ts.setBorder(b);
		// ��ʾͼƬ
		Icon icon = new ImageIcon("image/label.png");
		String disText = "<html><HTML><body style=color:red>�𾴵��û�!��<br>" + "��ͼ����Ϣ��д������Ĺ���!���ڡ�<br>" + "ϵͳʱ,������ϵ��<br>"
				+ "����ϵ: 1515620..  Multiline</body></html>";

		// ������ʾ ������ʽ
		JLabel labts = new JLabel(disText, icon, SwingConstants.LEFT);
		labts.setFont(new Font("����", Font.ITALIC, 18));
		labts.setVerticalAlignment(JLabel.TOP);
		labts.setSize(20, 250);
		ts.setPreferredSize(new Dimension(250, 200));
		ts.add(labts);
		panleq.add(ts, BorderLayout.SOUTH);

		// �м��ϲ�
		 panezs = new JPanel();

		Border brA = new TitledBorder(new LineBorder(Color.black, 1), "���߽����");
		panezs.setBorder(brA);

		panezs.setLayout(new BorderLayout(10, 5));

		// �м��²�
		JPanel panezx = new JPanel();
		Border bA = new TitledBorder(new LineBorder(Color.black, 1), "����ͼ��");
		panezx.setBorder(bA);

		panezx.setLayout(new BorderLayout(10, 5));
		// ���ı�
		JTable table = readeradminor.card();

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (table.getSelectedRow() != -1) {
					int index1 = table.getSelectedRow();// ��ȡѡ�е���
					Integer key = (Integer) table.getValueAt(index1, 0);
					readerServicer r = new rederImpl();
					readerGu rd = r.readerQuery(key);
					txzzbh.setText(rd.getReaderid().toString());
					txxm.setText(rd.getReadername());
					txzzj.setText(rd.getReadercardid());
					txzdz.setText(rd.getReaderaddress());
					txrq.removeAll();
					// 2009-03-26 00:00:00.0
					txrq.add(new DateChooserJButton(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), rd.getReaderdate()),
							java.awt.BorderLayout.CENTER);
					txrq.revalidate();
					txzdh.setText(rd.getReadertel());
					txbz.setText(rd.getReaderremark());
				}
			}

		});

		panezs.add(table.getTableHeader(), BorderLayout.NORTH);
		// �� ������� ��ӵ�������
		panezs.add(table, BorderLayout.CENTER);

		panelz.add(panezs);

		// ����ͼ��

		
		JTable tableo = readeradminor.cqbi();
		tableo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tableo.getSelectedRow() != -1) {
					int index1 = tableo.getSelectedRow();// ��ȡѡ�е���
					Integer key = (Integer) tableo.getValueAt(index1, 2);
					readerServicer r = new rederImpl();
					readerGu rd = r.readerQuery(key);
					txzzbh.setText(rd.getReaderid().toString());
					txxm.setText(rd.getReadername());
					txzzj.setText(rd.getReadercardid());
					txzdz.setText(rd.getReaderaddress());
					txrq.removeAll();
					// 2009-03-26 00:00:00.0
					txrq.add(new DateChooserJButton(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), rd.getReaderdate()),
							java.awt.BorderLayout.CENTER);
					txrq.revalidate();
					txzdh.setText(rd.getReadertel());
					txbz.setText(rd.getReaderremark());
				}
			}

		});
		panezx.add(tableo.getTableHeader(), BorderLayout.NORTH);
		// �� ������� ��ӵ�������
		panezx.add(tableo, BorderLayout.CENTER);

		panelz.add(panezx);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		readerinformation a = new readerinformation();
	}

}
