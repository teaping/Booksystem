package com.ksd.mp.controller.reader;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.JMenu;
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

import com.ksd.mp.GuanYi.BookInfo;
import com.ksd.mp.GuanYi.readerGu;
import com.ksd.mp.controller.LockFrame;
import com.ksd.mp.interior.readeradminor;
import com.ksd.mp.servicer.readerServicer;
import com.ksd.mp.servicer.registerQueryServicer;
import com.ksd.mp.servicer.Impl.rederImpl;
import com.ksd.mp.servicer.Impl.registerQuerylmp;
import com.ksd.mp.util.DateChooserJButton;

//����ɾ��
public class management extends JFrame {
	Integer key = null;
	JPanel panelz = null;
	JTextField txbh= null;// �x�߾�̖

	public management() {
		super("����ɾ������");
	
		this.setSize(1000, 800);
		this.setLocationRelativeTo(null);
		Container con = this.getContentPane();
		con.setLayout(new BorderLayout(10, 5));
		// �ϲ�����
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(10, 5));
//		panel.setBorder(new LineBorder(Color.BLACK, 2));

		// ��������
		hint(panel, con);
		//

		con.add(panel, BorderLayout.NORTH);
		this.setVisible(true);
		// �رշ�ʽ
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	// �ϲ���Ϣ
	private void hint(JPanel panel, Container con) {
		// TODO Auto-generated method stub
		// ��ťpanle

		// ��Ϣ
		JPanel panleon = new JPanel();
		// ���÷���
		// hintxx(panleon,con);
		// ɾ����Ϣ
		panleon.setLayout(new BorderLayout(10, 5));

		// TODO Auto-generated method stub
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
		panleon.add(ts, BorderLayout.WEST);

		// ͼ����Ϣ
		JPanel panelq = new JPanel();
		panelq.setLayout(new GridLayout(4, 4, 0, 20));
		Border bo = new TitledBorder(new LineBorder(Color.black, 1), "��������ȷͼ����Ϣ");
		panelq.setBorder(b);

		JLabel labrq = new JLabel("ѡ������");
		panelq.add(labrq);
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
		panelq.add(txrq);

		JLabel labdh = new JLabel("���ߵ绰");
		panelq.add(labdh);
		JTextField txdh = new JTextField();
		panelq.add(txdh);

		JLabel labxm = new JLabel("��������");
		panelq.add(labxm);
		JTextField txxm = new JTextField();
		panelq.add(txxm);

		JLabel labbh = new JLabel("���߱��");
		panelq.add(labbh);
		txbh = new JTextField();
		panelq.add(txbh);

		JLabel labsf = new JLabel("���֤");
		panelq.add(labsf);
		JTextField txsf = new JTextField();
		panelq.add(txsf);

		JLabel labbf = new JLabel("����");
		panelq.add(labbf);
		JTextField txbf = new JTextField();
		panelq.add(txbf);

		JLabel labdz = new JLabel("���ߵ�ַ");
		panelq.add(labdz);
		JTextField txdz = new JTextField();
		panelq.add(txdz);

		panleon.add(panelq);

		// �в�����
		panelz = new JPanel();
//		panelz.setBorder(new LineBorder(Color.BLACK, 2));
		panelz.setLayout(new BorderLayout(10, 5));
		// ����
		Border br = new TitledBorder(new LineBorder(Color.black, 1), "���ж���");
//qweqwe
		// �в����� //���ñ�񷽷�
		JTable table = readeradminor.adminq();
		panelz.add(table.getTableHeader(), BorderLayout.NORTH);
		panelz.setBorder(br);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 
				if (table.getSelectedRow() != -1) {
					int index1 = table.getSelectedRow();// ��ȡѡ�е���
					key = (Integer) table.getValueAt(index1, 0);
					readerServicer r = new rederImpl();
					readerGu rd = r.readerQuery(key);
					txxm.setText(rd.getReadername());
					txsf.setText(rd.getReadercardid());
					txrq.removeAll();
					// 2009-03-26 00:00:00.0
					txrq.add(new DateChooserJButton(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), rd.getReaderdate()),
							java.awt.BorderLayout.CENTER);
					txrq.revalidate();
					txbh.setText(rd.getReaderid().toString());
					txdh.setText(rd.getReadertel());
					txdz.setText(rd.getReaderaddress());
					txbf.setText(rd.getReaderremark());
				}
			}

		});

		// �� ������� ��ӵ�������
		panelz.add(table, BorderLayout.CENTER);
		con.add(panelz, BorderLayout.CENTER);

		JPanel panelbtn = new JPanel();
		panelbtn.setLayout(new FlowLayout());
		String[] btnstr = { "�˳�", "���", "ɾ��", "��ѯ", "�޸�"};
		JButton btn = null;
		for (int i = 0; i < btnstr.length; i++) {
			btn = new JButton(btnstr[i]);
			btn.setActionCommand(i + "");
			btn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String a = e.getActionCommand();
					// TODO Auto-generated method stub
					switch (a) {
					case "0":
						if(JOptionPane.showConfirmDialog(null,"ȷ���˳���?","��ʾ",JOptionPane.OK_CANCEL_OPTION)==0){
							dispose();
						}
						
						break;
					case "1":
						txxm.setText("");
						txsf.setText("");
						txrq.setText("");
						txdh.setText("");
						txdz.setText("");
						txbf.setText("");
                        txbh.setText("");
                        txrq.removeAll();
    					// 2009-03-26 00:00:00.0

                		txrq.add(new DateChooserJButton(new SimpleDateFormat("yyyy/MM/dd HH"), "2012/12/12 22"),java.awt.BorderLayout.CENTER);
    					txrq.revalidate();
						break;
					
					
					case "2":
						if (key != null && key != 0) {
							readerServicer rada = new rederImpl();
							int n = rada.rederdelete(key);
							if (n < 1) {

								JOptionPane.showMessageDialog(panel, "ɾ��ʧ��", "����", JOptionPane.WARNING_MESSAGE);
							}
							panelz.removeAll();
							JTable table = readeradminor.adminq();
							panelz.add(table.getTableHeader(), BorderLayout.NORTH);
							panelz.add(table, BorderLayout.CENTER);
							table.addMouseListener(new MouseAdapter() {
								@Override
								public void mouseClicked(MouseEvent e) {
									if (table.getSelectedRow() != -1) {
										int index1 = table.getSelectedRow();// ��ȡѡ�е���
										key = (Integer) table.getValueAt(index1, 0);
										readerServicer r = new rederImpl();
										readerGu rd = r.readerQuery(key);
										txxm.setText(rd.getReadername());
										txsf.setText(rd.getReadercardid());
										txrq.removeAll();
										// 2009-03-26 00:00:00.0
										txrq.add(new DateChooserJButton(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), rd.getReaderdate()),
												java.awt.BorderLayout.CENTER);
										txrq.revalidate();
										txbh.setText(rd.getReaderid().toString());
										txdh.setText(rd.getReadertel());
										txdz.setText(rd.getReaderaddress());
										txbf.setText(rd.getReaderremark());
									}
								}

							});
							panelz.revalidate();
						} else {
							JOptionPane.showMessageDialog(panelz, "��ѡ��һ��ɾ��", "����", JOptionPane.WARNING_MESSAGE);
						}
						key = null;

						break;
						
						
					case "3":
						String qwe=txbh.getText().trim();
						if(qwe!=null&&!qwe.equals("")){
							Integer nu=Integer.parseInt(qwe);
							panelz.removeAll();
							JTable table = readeradminor.Idadminq(nu);
							panelz.add(table.getTableHeader(), BorderLayout.NORTH);
							panelz.add(table, BorderLayout.CENTER);
							table.addMouseListener(new MouseAdapter() {
								@Override
								public void mouseClicked(MouseEvent e) {
									if (table.getSelectedRow() != -1) {
										int index1 = table.getSelectedRow();// ��ȡѡ�е���
										key = (Integer) table.getValueAt(index1, 0);
										readerServicer r = new rederImpl();
										readerGu rd = r.readerQuery(key);
										txxm.setText(rd.getReadername());
										txsf.setText(rd.getReadercardid());
										txrq.removeAll();
										// 2009-03-26 00:00:00.0
										txrq.add(new DateChooserJButton(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), rd.getReaderdate()),
												java.awt.BorderLayout.CENTER);
										txrq.revalidate();
										txbh.setText(rd.getReaderid().toString());
										txdh.setText(rd.getReadertel());
										txdz.setText(rd.getReaderaddress());
										txbf.setText(rd.getReaderremark());
									}
								}

							});
							panelz.revalidate();
						}else{
							panelz.removeAll();
							JTable table = readeradminor.adminq();
							panelz.add(table.getTableHeader(), BorderLayout.NORTH);
							panelz.add(table, BorderLayout.CENTER);
							table.addMouseListener(new MouseAdapter() {
								@Override
								public void mouseClicked(MouseEvent e) {
									if (table.getSelectedRow() != -1) {
										int index1 = table.getSelectedRow();// ��ȡѡ�е���
										key = (Integer) table.getValueAt(index1, 0);
										readerServicer r = new rederImpl();
										readerGu rd = r.readerQuery(key);
										txxm.setText(rd.getReadername());
										txsf.setText(rd.getReadercardid());
										txrq.removeAll();
										// 2009-03-26 00:00:00.0
										txrq.add(new DateChooserJButton(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), rd.getReaderdate()),
												java.awt.BorderLayout.CENTER);
										txrq.revalidate();
										txbh.setText(rd.getReaderid().toString());
										txdh.setText(rd.getReadertel());
										txdz.setText(rd.getReaderaddress());
										txbf.setText(rd.getReaderremark());
									}
								}

							});
							panelz.revalidate();
						}
						
						
						break;
					case "4":
						String lv = txbh.getText().trim();
//						System.out.println();
						if (lv != null && lv != "") {
							Integer in = Integer.parseInt(lv);
							readerGu r = new readerGu();
							r.setReadername(txxm.getText());
							r.setReadercardid(txsf.getText());
							r.setReaderdate(txrq.getText());
							r.setReadertel(txdh.getText());
							r.setReaderaddress(txdz.getText());
							r.setReaderremark(txbf.getText());

							readerServicer rad = new rederImpl();
							Integer num = rad.rederalter(in, r);
							if(num<1){
								JOptionPane.showMessageDialog(panel, "�޸�ʧ��", "����", JOptionPane.WARNING_MESSAGE);
							}
						   	panelz.removeAll();
						   	JTable table = readeradminor.adminq();
							panelz.add(table.getTableHeader(), BorderLayout.NORTH);
							panelz.add(table, BorderLayout.CENTER);
							table.addMouseListener(new MouseAdapter() {
								@Override
								public void mouseClicked(MouseEvent e) {
									if (table.getSelectedRow() != -1) {
										int index1 = table.getSelectedRow();// ��ȡѡ�е���
										key = (Integer) table.getValueAt(index1, 0);
										readerServicer r = new rederImpl();
										readerGu rd = r.readerQuery(key);
										txxm.setText(rd.getReadername());
										txsf.setText(rd.getReadercardid());
										txrq.removeAll();
										// 2009-03-26 00:00:00.0
										txrq.add(new DateChooserJButton(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), rd.getReaderdate()),
												java.awt.BorderLayout.CENTER);
										txrq.revalidate();
										txbh.setText(rd.getReaderid().toString());
										txdh.setText(rd.getReadertel());
										txdz.setText(rd.getReaderaddress());
										txbf.setText(rd.getReaderremark());
									}
								}

							});
						   	
						   	
						   	
							panelz.revalidate();

						}

						break;

					default:
						break;
					}
				}
			});
			panelbtn.add(btn);
		}

		panel.add(panelbtn, BorderLayout.NORTH);
		panel.add(panleon, BorderLayout.CENTER);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		management a = new management();
	}

}
