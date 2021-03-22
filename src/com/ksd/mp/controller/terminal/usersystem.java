package com.ksd.mp.controller.terminal;

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
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.ksd.mp.GuanYi.yhDx;
import com.ksd.mp.interior.rankingor;
import com.ksd.mp.interior.readeradminor;
import com.ksd.mp.interior.systemad;
import com.ksd.mp.servicer.readerServicer;
import com.ksd.mp.servicer.systemServier;
import com.ksd.mp.servicer.Impl.rederImpl;
import com.ksd.mp.servicer.Impl.systemImpl;
import com.ksd.mp.util.DateChooserJButton;

public class usersystem extends JFrame {
	Integer key = null;

	public usersystem() {
		super("�û���Ϣ����");
		this.setSize(1000, 800);
		this.setLocationRelativeTo(null);
		Container con = this.getContentPane();
		con.setLayout(new BorderLayout(10, 5));
		// �Ͼ�
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.BLACK, 2));

		// �����ϲ�����
		hint(panel, con);

		con.add(panel, BorderLayout.CENTER);

		this.setVisible(true);
		// �رշ�ʽ
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	// �²�����
	private void xiabs(JPanel panelx) {
		// ����
		Border b = new TitledBorder(new LineBorder(Color.black, 1), "��ܰ��ʾ");
		// ��ʾͼƬ
		Icon icon = new ImageIcon("image/label.png");
		String disText = "<html><HTML><body style=color:red>�𾴵��û�!��<br>" + "��ͼ����Ϣ��д������Ĺ���!���ڡ�<br>" + "ϵͳʱ,������ϵ��<br>"
				+ "����ϵ: 1515620..  Multiline</body></html>";

		Border br = new TitledBorder(new LineBorder(Color.black, 1), "����Ա�޸���֤����");

	}

	// �ϲ�����
	private void hint(JPanel panel, Container con) {
		// TODO Auto-generated method stub
		panel.setLayout(new BorderLayout(10, 2));
		JPanel panela = new JPanel();

		panela.setLayout(new GridLayout(3, 6, 10, 0));
		panela.setBorder(new LineBorder(Color.BLACK, 2));
		Border br = new TitledBorder(new LineBorder(Color.black, 1), "�û���Ϣ");
		panela.setBorder(br);

		JLabel labbh = new JLabel("�û����:");
		JTextField txbh = new JTextField("�Զ����");
		txbh.enable(false);
		panela.add(labbh);
		panela.add(txbh);

		JLabel labdh = new JLabel("��ϵ�绰:");
		JTextField txdh = new JTextField();
		panela.add(labdh);
		panela.add(txdh);

		JLabel labmi = new JLabel("����:");
		JTextField txmi = new JTextField();
		panela.add(labmi);
		panela.add(txmi);

		JLabel labxm = new JLabel("�û�����:");
		JTextField txxm = new JTextField();
		panela.add(labxm);
		panela.add(txxm);

		JLabel labdz = new JLabel("�û���ַ:");
		JTextField txdz = new JTextField();
		panela.add(labdz);
		panela.add(txdz);

		JLabel labqmi = new JLabel("ȷ������:");
		JTextField txqmi = new JTextField();
		panela.add(labqmi);
		panela.add(txqmi);

		JLabel labqx = new JLabel("Ȩ��:");
		JComboBox cmb = new JComboBox();
		cmb.addItem("--��ѡ��--"); // �������б������һ��
		cmb.addItem("����Ա");
		cmb.addItem("��ͨ�û�");
		panela.add(labqx);
		panela.add(cmb);

		JLabel lbarq = new JLabel("����");
		panela.add(lbarq);
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
		panela.add(txrq);

		JLabel labzm = new JLabel("״̬:");
		JTextField txzt = new JTextField();
		panela.add(labzm);
		panela.add(txzt);

		panel.add(panela, BorderLayout.NORTH);

		// �¾�
		JPanel panelw = new JPanel();
		panelw.setLayout(new BorderLayout(5, 2));
		panelw.setBorder(new LineBorder(Color.BLACK, 2));
		Border brs = new TitledBorder(new LineBorder(Color.black, 1), "�����û�");
		panelw.setBorder(brs);

		JTable table = systemad.systemas();

		table.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				int index1 = table.getSelectedRow();// ��ȡѡ�е���
				key = (Integer) table.getValueAt(index1, 0);
				systemServier sr = new systemImpl();
				yhDx r = sr.sysInquire(key);
				txbh.setText(r.getUserid().toString());
				txxm.setText(r.getUsername());
				txmi.setText(r.getUserpassword());
				txdh.setText(r.getUsertel());
				txdz.setText(r.getUseraddress());
				txrq.removeAll();
				// 2009-03-26 00:00:00.0
				txrq.add(new DateChooserJButton(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), r.getUserdate()),
						java.awt.BorderLayout.CENTER);
				txrq.revalidate();
				txzt.setText(r.getUsertruce());
				// ������
				cmb.setSelectedItem(r.getUserpurview());

			}
		});
		panelw.add(table.getTableHeader(), BorderLayout.NORTH);
		// �� ������� ��ӵ�������
		panelw.add(table, BorderLayout.CENTER);

		panel.add(panelw, BorderLayout.CENTER);

		// �Ҿ�
		JPanel panele = new JPanel();
		panele.setLayout(new GridLayout(8, 1, 20, 65));
//		panele.setBorder(new LineBorder(Color.BLACK, 2));

		 JLabel btnwy = new JLabel();
		 btnwy.setOpaque(false);
		 panele.add(btnwy);
		JButton btntj = new JButton("���");
		btntj.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				systemServier sr = new systemImpl();
				yhDx r = new yhDx();
				// r.setUserid(Integer.parseInt(txbh.getText()));
				r.setUsername(txxm.getText());
				r.setUserpassword(txmi.getText());
				r.setUsertel(txdh.getText());
				r.setUseraddress(txdz.getText());
				r.setUserdate(txrq.getText());
				r.setUserpurview(cmb.getSelectedItem().toString());

				r.setUsertruce(txzt.getText());
				Integer num = sr.addSys(r);
				if (num < 1) {
					JOptionPane.showMessageDialog(panelw, "���ʧ��", "����", JOptionPane.WARNING_MESSAGE);

				}

				panelw.removeAll();
				panelw.setLayout(new BorderLayout(5,2));
				panelw.setBorder(new LineBorder(Color.BLACK, 2));
				Border brs = new TitledBorder(new LineBorder(Color.black, 1), "�����û�");
				panelw.setBorder(brs);

				 JTable table= systemad.systemas();

					table.addMouseListener(new MouseAdapter() {

						public void mouseClicked(MouseEvent e) {
							int index1 = table.getSelectedRow();// ��ȡѡ�е���
							key = (Integer) table.getValueAt(index1, 0);
							systemServier sr = new systemImpl();
							yhDx r = sr.sysInquire(key);
							txbh.setText(r.getUserid().toString());
							txxm.setText(r.getUsername());
							txmi.setText(r.getUserpassword());
							txdh.setText(r.getUsertel());
							txdz.setText(r.getUseraddress());
							txrq.removeAll();
							// 2009-03-26 00:00:00.0
							txrq.add(new DateChooserJButton(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), r.getUserdate()),
									java.awt.BorderLayout.CENTER);
							txrq.revalidate();
							txzt.setText(r.getUsertruce());
							// ������
							cmb.setSelectedItem(r.getUserpurview());

						}
					}); 
		        
		        
		        
		        panelw.add(table.getTableHeader(), BorderLayout.NORTH);
		        // �� ������� ��ӵ�������
		        panelw.add(table,BorderLayout.CENTER);
				panelw.revalidate();

				txbh.setText("");
				txxm.setText("");
				txmi.setText("");
				txdh.setText("");
				txdz.setText("");
				txrq.removeAll();
				// 2009-03-26 00:00:00.0
				txrq.add(new DateChooserJButton(), java.awt.BorderLayout.CENTER);
				txrq.revalidate();
				cmb.setSelectedIndex(0);
				txzt.setText("");

			}
		});
		panele.add(btntj);

		JButton btnsc = new JButton("ɾ��");
		btnsc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				systemServier sr = new systemImpl();
				if (key == null) {
					JOptionPane.showMessageDialog(con, "��ѡ��һ������", "����", JOptionPane.WARNING_MESSAGE);
					return;
				}
				sr.deleteSys(key);
				panelw.removeAll();
				panelw.setLayout(new BorderLayout(5,2));
				panelw.setBorder(new LineBorder(Color.BLACK, 2));
				Border brs = new TitledBorder(new LineBorder(Color.black, 1), "�����û�");
				panelw.setBorder(brs);

				 JTable table= systemad.systemas();

					table.addMouseListener(new MouseAdapter() {

						public void mouseClicked(MouseEvent e) {
							int index1 = table.getSelectedRow();// ��ȡѡ�е���
							key = (Integer) table.getValueAt(index1, 0);
							systemServier sr = new systemImpl();
							yhDx r = sr.sysInquire(key);
							txbh.setText(r.getUserid().toString());
							txxm.setText(r.getUsername());
							txmi.setText(r.getUserpassword());
							txdh.setText(r.getUsertel());
							txdz.setText(r.getUseraddress());
							txrq.removeAll();
							// 2009-03-26 00:00:00.0
							txrq.add(new DateChooserJButton(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), r.getUserdate()),
									java.awt.BorderLayout.CENTER);
							txrq.revalidate();
							txzt.setText(r.getUsertruce());
							// ������
							cmb.setSelectedItem(r.getUserpurview());

						}
					}); 
		        
		        
		        
		        panelw.add(table.getTableHeader(), BorderLayout.NORTH);
		        // �� ������� ��ӵ�������
		        panelw.add(table,BorderLayout.CENTER);
				
				panelw.revalidate();
				key = null;
			}
		});
		panele.add(btnsc);
		// �޸�

		JButton btnxg = new JButton("�޸�");
		btnxg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				systemServier sr = new systemImpl();
				String bh = txbh.getText();
				if (bh != null && !bh.equals("")) {
					Integer ia = Integer.parseInt(bh);
					
					
					String qwtxxm = txxm.getText();
					String qwtxmi = txmi.getText();
					String qwtxdh = txdh.getText();
					String qwtxdz = txdz.getText();
					String qwtxrq = txrq.getText();
					String qwcmb = cmb.getSelectedItem().toString();
					String qwtxzt = txzt.getText();
					yhDx dx = new yhDx(ia, qwtxxm, qwtxmi, qwtxdh, qwtxdz, qwtxrq, qwcmb, qwtxzt);
					Integer num=sr.sysQuery(ia, dx);
					if (num == null) {
						JOptionPane.showMessageDialog(con, "�޸�ʧ��", "����", JOptionPane.WARNING_MESSAGE);
						return;
					}
					panelw.removeAll();
//					systemad.sysupde(panelw);
					
					
					
					
					panelw.setLayout(new BorderLayout(5,2));
					panelw.setBorder(new LineBorder(Color.BLACK, 2));
					Border brs = new TitledBorder(new LineBorder(Color.black, 1), "�����û�");
					panelw.setBorder(brs);

			        JTable table= systemad.systemas();

					table.addMouseListener(new MouseAdapter() {

						public void mouseClicked(MouseEvent e) {
							int index1 = table.getSelectedRow();// ��ȡѡ�е���
							key = (Integer) table.getValueAt(index1, 0);
							systemServier sr = new systemImpl();
							yhDx r = sr.sysInquire(key);
							txbh.setText(r.getUserid().toString());
							txxm.setText(r.getUsername());
							txmi.setText(r.getUserpassword());
							txdh.setText(r.getUsertel());
							txdz.setText(r.getUseraddress());
							txrq.removeAll();
							// 2009-03-26 00:00:00.0
							txrq.add(new DateChooserJButton(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), r.getUserdate()),
									java.awt.BorderLayout.CENTER);
							txrq.revalidate();
							txzt.setText(r.getUsertruce());
							// ������
							cmb.setSelectedItem(r.getUserpurview());

						}
					}); 
			        panelw.add(table.getTableHeader(), BorderLayout.NORTH);
			        // �� ������� ��ӵ�������
			        panelw.add(table,BorderLayout.CENTER);
					
					panelw.revalidate();
					

				}

			}
		});
		panele.add(btnxg);

		JButton btnqx = new JButton("���");
		btnqx.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txbh.setText("");
				txxm.setText("");
				txmi.setText("");
				txdh.setText("");
				txdz.setText("");
				txqmi.setText("");
				txrq.removeAll();
				// 2009-03-26 00:00:00.0
				txrq.add(new DateChooserJButton(new SimpleDateFormat("yyyy/MM/dd HH"), "2012/12/12 22"),
						java.awt.BorderLayout.CENTER);
				txrq.revalidate();
				cmb.setSelectedIndex(0);
				txzt.setText("");
			}
		});

		panele.add(btnqx);

		JButton btntc = new JButton("�˳�");
		btntc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		panele.add(btntc);
		panel.add(panele, BorderLayout.EAST);

	}

//	public static void main(String[] args) {
//		usersystem s = new usersystem();
//	}

}
