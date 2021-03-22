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
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.ksd.mp.GuanYi.BookInfo;
import com.ksd.mp.GuanYi.readerGu;
import com.ksd.mp.interior.readeradminor;
import com.ksd.mp.servicer.readerServicer;
import com.ksd.mp.servicer.registerQueryServicer;
import com.ksd.mp.servicer.Impl.rederImpl;
import com.ksd.mp.servicer.Impl.registerQuerylmp;
import com.ksd.mp.util.DateChooserJButton;

//���߹���
public class readeradmin extends JFrame {

	private int rowNum = -1;
	private int cols = -1;
	JPanel panelz = null;
	Container con = null;

	public readeradmin() {
		super("���ߵǼǹ���");
		this.setSize(1000, 800);
		this.setLocationRelativeTo(null);
		con = this.getContentPane();
		con.setLayout(new BorderLayout(10, 5));
		// �ϲ�����
		JPanel panel = new JPanel();
//		panel.setBorder(new LineBorder(Color.BLACK, 2));

		// �в�����
		panelz = new JPanel();
		panelz.setBorder(new LineBorder(Color.BLACK, 2));
		// ��������
		hint(panel);
		bookupde(panelz);

		con.add(panel, BorderLayout.NORTH);
		con.add(panelz, BorderLayout.CENTER);
		this.setVisible(true);
		// �رշ�ʽ
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	// ����
	private void bookupde(JPanel panelz) {
		// TODO Auto-generated method stub

		panelz.setLayout(new BorderLayout(10, 5));
		JTable table = readeradminor.adminq();
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
						readerServicer rada = new rederImpl();
						int n = rada.rederdelete(key);
						if (n < 1) {

							JOptionPane.showMessageDialog(panelz, "ɾ��ʧ��", "����", JOptionPane.WARNING_MESSAGE);
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

	// ������ʾ

	private void hint(JPanel panle) {
		// TODO Auto-generated method stub
		panle.setLayout(new BorderLayout(10, 5));
		// ��ʾ��
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
		panle.add(ts, BorderLayout.WEST);
		// �ұ�ͼ����Ϣ
		JPanel tsz = new JPanel();
		Border cts = new TitledBorder(new LineBorder(Color.black, 1), "����������������Ϣ");
		tsz.setBorder(cts);
		// ����ͼ���޸���Ϣ
		bookmessage(tsz);

		panle.add(tsz, BorderLayout.CENTER);

	}

	// �ϲ��м�
	private void bookmessage(JPanel tsz) {

		JPanel panelzj = new JPanel();
//		panelzj.setBorder(new LineBorder(Color.GREEN, 2));

		// TODO Auto-generated method stub
		panelzj.setLayout(new GridLayout(4, 4, 0, 20));

		JLabel labzdbb = new JLabel("���߱��");
		panelzj.add(labzdbb);
		JTextField txzzbh = new JTextField("�Զ����");
		txzzbh.setEditable(false);
		panelzj.add(txzzbh);

		JLabel labsfz = new JLabel("���֤");
		panelzj.add(labsfz);
		JTextField txzsfz = new JTextField();
		panelzj.add(txzsfz);

		JLabel labxm = new JLabel("��������");
		panelzj.add(labxm);
		JTextField txzxm = new JTextField();
		panelzj.add(txzxm);

		JLabel labrq = new JLabel("ѡ������");
		panelzj.add(labrq);
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
		panelzj.add(txrq);

		JLabel labdh = new JLabel("���ߵ绰");
		panelzj.add(labdh);
		JTextField txzdh = new JTextField();
		panelzj.add(txzdh);

		JLabel labdz = new JLabel("���ߵ�ַ");
		panelzj.add(labdz);
		JTextField txdz = new JTextField();
		panelzj.add(txdz);

		JLabel labbz = new JLabel("��ע");
		panelzj.add(labbz);
		JTextField txbz = new JTextField();
		panelzj.add(txbz);

		JPanel panelzy = new JPanel();
//		panelzy.setBorder(new LineBorder(Color.BLACK, 2));

		// ��ť

		panelzy.setLayout(new GridLayout(2, 1, 0, 20));
		JButton btndj = new JButton("�Ǽ�");
		btndj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				readerGu r = new readerGu();
				r.setReadername(txzxm.getText());
				r.setReadercardid(txzsfz.getText());
				r.setReaderdate(txrq.getText());
				r.setReadertel(txzdh.getText());
				r.setReaderaddress(txdz.getText());
				r.setReaderremark(txbz.getText());
				readerServicer rada = new rederImpl();
				int n = rada.rederadditive(r);
				if (n < 1) {
					JOptionPane.showMessageDialog(tsz, "���ʧ��", "����", JOptionPane.WARNING_MESSAGE);
				}
				panelz.removeAll();
				readeradminor.bookupde(panelz);
				panelz.revalidate();
				//�������
				txzxm.setText("");
				txzsfz.setText("");
				txrq.setText("");
				txzdh.setText("");
				txdz.setText("");
				txbz.setText("");

			}
		});
		JButton btnqx = new JButton("���");
		btnqx.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//�������
				txzxm.setText("");
				txzsfz.setText("");
				txrq.removeAll();
				txrq.add(new DateChooserJButton(),java.awt.BorderLayout.CENTER);
				txrq.revalidate();
				txzdh.setText("");
				txdz.setText("");
				txbz.setText("");

				
			}
		});
		
		
		panelzy.add(btndj);
		panelzy.add(btnqx);

		tsz.add(panelzj, BorderLayout.CENTER);
		tsz.add(panelzy, BorderLayout.EAST);

	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		readeradmin r = new readeradmin();
//	}

}
