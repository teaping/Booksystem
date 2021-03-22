package com.ksd.mp.controller.librarian;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import com.ksd.mp.GuanYi.BookInfo;
import com.ksd.mp.interior.refisteror;
import com.ksd.mp.servicer.LoginServicer;
import com.ksd.mp.servicer.registerQueryServicer;
import com.ksd.mp.servicer.Impl.LoginServicerlmpl;
import com.ksd.mp.servicer.Impl.registerQuerylmp;
import com.ksd.mp.util.BaseDao;
import com.ksd.mp.util.DateChooserJButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

//ͼ���޸Ĺ���
public class amend extends JFrame {
	private JTextField txtszz;
	private JTextField txtslb;
	private JTextField txtsmc;
	private JTextField txtsbh;
	private JTextField txtcbs;
	private JTextField txtsl;
	private JButton txrq;
	private JTextField txtsj;
	private JPanel panzjj;
	private JTable table;

	public amend() {
		super("ͼ���޸Ĺ���");
		this.setSize(1000, 800);
		this.setLocationRelativeTo(null);
		Container con = this.getContentPane();
		con.setLayout(new BorderLayout(10, 5));
		// �ϲ�����
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.BLACK, 2));

		// �в�����
		JPanel panelz = new JPanel();
		// panelz.setBorder(new LineBorder(Color.red, 2));
		// ��������
		hint(panel);
		bookupde(panelz);

		con.add(panel, BorderLayout.NORTH);
		con.add(panelz, BorderLayout.CENTER);
		this.setVisible(true);
		// �رշ�ʽ
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	// �ϲ������ʾ��Ϣ
	private void hint(JPanel panle) {
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
		Border cts = new TitledBorder(new LineBorder(Color.black, 1), "����������ͼ����Ϣ");
		tsz.setBorder(cts);
		// ����ͼ���޸���Ϣ

		JPanel panelzj = new JPanel();
		// panelzj.setBorder(new LineBorder(Color.GREEN, 2));

		JPanel panelzy = new JPanel();
		// panelzy.setBorder(new LineBorder(Color.BLACK, 2));

		bookmessage(panelzj);
		bookmessag(panelzy);

		tsz.add(panelzj, BorderLayout.CENTER);

		tsz.add(panelzy, BorderLayout.EAST);

		panle.add(tsz, BorderLayout.CENTER);
	}

	// ����ͼ���޸���Ϣ
	private void bookmessage(JPanel panel) {

		panel.setLayout(new GridLayout(4, 4, 0, 20));
		JLabel labtszz = new JLabel("ͼ������");
		txtszz = new JTextField();
		panel.add(labtszz);
		panel.add(txtszz);

		JLabel labtslb = new JLabel("ͼ�����");
		txtslb = new JTextField();
		panel.add(labtslb);
		panel.add(txtslb);

		JLabel labtsmc = new JLabel("ͼ������");
		txtsmc = new JTextField();
		panel.add(labtsmc);
		panel.add(txtsmc);

		JLabel labtsbh = new JLabel("ͼ����");
		txtsbh = new JTextField();
		panel.add(labtsbh);
		panel.add(txtsbh);

		JLabel labtcbs = new JLabel("������");
		txtcbs = new JTextField();
		panel.add(labtcbs);
		panel.add(txtcbs);

		JLabel labtsl = new JLabel("ͼ������");
		txtsl = new JTextField();
		panel.add(labtsl);
		panel.add(txtsl);

		JLabel labtrq = new JLabel("ѡ�����ڣ�");
		panel.add(labtrq);
		txrq = new JButton();
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

		JLabel labtsj = new JLabel("���ʱ��");
		txtsj = new JTextField();
		panel.add(labtsj);
		panel.add(txtsj);
	}

	// ��ť
	private void bookmessag(JPanel panel) {

		panel.setLayout(new GridLayout(3, 1, 0, 20));
		JButton btncx = new JButton("��ѯ");
		btncx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ��ѯ
				if (txtsmc.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "�������鱾����");
					return;
				}
				BaseDao.getConn();
				LoginServicer ls = new LoginServicerlmpl();
				BookInfo bkf = ls.psSelStudentBySid(txtsmc.getText());
				txtszz.setText(bkf.getBookauthor());
				txtslb.setText(bkf.getBooksort());
				txtsmc.setText(bkf.getBookname());
				txtsbh.setText(bkf.getBookcode());
				txtcbs.setText(bkf.getBookpublish());
				txtsl.setText(new Integer(bkf.getBookaddnumber()).toString());
				txtsj.setText(bkf.getBooktime());
				// ls.psSelStudentBySid(bk.getBookcode(),bk.getBookname(),
				// bk.getBookpublish(), bk.getBookaddnumber(), bk.getBooksort(),
				// bk.getBookauthor(), bk.getBooktime());
				panzjj.removeAll();

				table = refisteror.Uptable(txtsmc.getText());
				panzjj.add(table.getTableHeader(), BorderLayout.NORTH);
				// �� ������� ��ӵ�������
				panzjj.add(table, BorderLayout.CENTER);

				panzjj.setBorder(new LineBorder(Color.BLACK, 2));

				panzjj.revalidate();

			}
		});
		JButton btnxg = new JButton("�޸�");
		btnxg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BaseDao.getConn();
				LoginServicer ls = new LoginServicerlmpl();

				String qwtxtsz = txtszz.getText();
				String qwtxtslb = txtslb.getText();
				String qwtxtsb = txtsbh.getText();
				String qwtxtcb = txtcbs.getText();
				Integer qwtxtsl = Integer.parseInt(txtsl.getText());
				String qwtxtsj = txtsj.getText();
				BookInfo bkf = new BookInfo(qwtxtsb, qwtxtcb, qwtxtsl, qwtxtslb, qwtxtsz, qwtxtsj);
				int bnum = ls.wnUpdateInfo(txtsmc.getText(), bkf);
				if (bnum < 1) {
					JOptionPane.showMessageDialog(null, "�޸�ʧ��");
					return;
				}

				panzjj.removeAll();
				panzjj.setLayout(new BorderLayout(10, 5));
				// ��ʾ��
				JPanel ts = new JPanel();
				ts.setLayout(new BorderLayout(10, 5));
				// ����
				Border b = new TitledBorder(new LineBorder(Color.black, 1), "��ܰ��ʾ");
				ts.setBorder(b);
				panzjj.add(ts);
				// ����ͼ����Ϣ����
				JTable table = refisteror.retable(null);
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int s = table.getSelectedRow();
						String sadq = table.getValueAt(s, 1).toString();
						LoginServicer asd = new LoginServicerlmpl();
						BookInfo boif = asd.psSelStudentBySid(sadq);
						txtszz.setText(boif.getBookauthor());
						txtslb.setText(boif.getBooksort());
						txtsmc.setText(boif.getBookname());
						txtsbh.setText(boif.getBookcode());
						txtcbs.setText(boif.getBookpublish());
						txtsl.setText(new Integer(boif.getBookaddnumber()).toString());
						txtsj.setText(boif.getBooktime());
					}
				});
				panzjj.add(table.getTableHeader(), BorderLayout.NORTH);
				// �� ������� ��ӵ���������
				panzjj.add(table, BorderLayout.CENTER);
				panzjj.revalidate();
			}
		});
		JButton btnxq = new JButton("���");
		btnxq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtszz.setText("");
				txtslb.setText("");
				txtsmc.setText("");
				txtsbh.setText("");
				txtcbs.setText("");
				txtsl.setText("");
				txtsj.setText("");
				panzjj.removeAll();
				refisteror.sobookone(panzjj);
				panzjj.revalidate();
			}
		});
		panel.add(btncx);
		panel.add(btnxg);
		panel.add(btnxq);
	}

	// �м�ͼ�����
	private void bookupde(JPanel panel) {
		panel.setLayout(new BorderLayout(10, 0));
		// ͼ�����
		JPanel panelzjz = new JPanel();
		// Border cts = new TitledBorder(new LineBorder(Color.black, 1),
		// "����������ͼ����Ϣ");

		Border cts = new TitledBorder(new LineBorder(Color.black, 1), "ͼ�����");
		panelzjz.setBorder(cts);
		panzjj = new JPanel();
		panzjj.setLayout(new BorderLayout(10, 2));
		// ���ؼ�
		// �������ڵ�
		DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("�������");

		// ���������ڵ�

		List<String> list = null;
		registerQueryServicer rs = new registerQuerylmp();
		list = rs.booksortOne();
		for (int i = 0; i < list.size(); i++) {
			// �Ѷ����ڵ���Ϊ�ӽڵ���ӵ����ڵ�
			rootNode.add(new DefaultMutableTreeNode(list.get(i)));
		}

		// ���������ڵ�

		// ʹ�ø��ڵ㴴�������
		JTree tree = new JTree(rootNode);

		// ��������ʾ���ڵ���
		tree.setShowsRootHandles(true);

		// �������ڵ�ɱ༭
		tree.setEditable(true);

		// ���ýڵ�ѡ�м�����

		tree.addTreeSelectionListener(new TreeSelectionListener() {
			String wen = null;

			@Override
			public void valueChanged(TreeSelectionEvent e) {
				panzjj.removeAll();
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				if (node == null) {
					return;
				}
				Object object = node.getUserObject();
				if (node.isLeaf()) {
					String user = (String) object;
					wen = user.toString();
				} else if (wen == null) {
					JOptionPane.showMessageDialog(null, "��ѡ�����");
					return;
				} else {
					wen = null;
				}
				panzjj.removeAll();
				panzjj.setLayout(new BorderLayout(10, 5));
				// ��ʾ��
				JPanel ts = new JPanel();
				ts.setLayout(new BorderLayout(10, 5));
				// ����
				Border b = new TitledBorder(new LineBorder(Color.black, 1), "��ܰ��ʾ");
				ts.setBorder(b);
				panzjj.add(ts);
				// ����ͼ����Ϣ����
				JTable table = refisteror.retableone(wen);
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int s = table.getSelectedRow();
						String sadq = table.getValueAt(s, 1).toString();
						LoginServicer asd = new LoginServicerlmpl();
						BookInfo boif = asd.psSelStudentBySid(sadq);
						txtszz.setText(boif.getBookauthor());
						txtslb.setText(boif.getBooksort());
						txtsmc.setText(boif.getBookname());
						txtsbh.setText(boif.getBookcode());
						txtcbs.setText(boif.getBookpublish());
						txtsl.setText(new Integer(boif.getBookaddnumber()).toString());
						txtsj.setText(boif.getBooktime());
					}
				});

				panzjj.add(table.getTableHeader(), BorderLayout.NORTH);
				// �� ������� ��ӵ���������
				panzjj.add(table, BorderLayout.CENTER);
				panzjj.revalidate();

			}
		});

		// ����������壬����������Ϊ���ڵ�չ���������Ҫ�ܴ�Ŀռ�����ʾ��������Ҫ��һ�����������������
		JScrollPane scrollPane = new JScrollPane(tree);

		// ��ӹ�����嵽���������
		panelzjz.add(scrollPane);

		table = refisteror.retable(null);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int s = table.getSelectedRow();
				String sadq = table.getValueAt(s, 1).toString();
				LoginServicer asd = new LoginServicerlmpl();
				BookInfo boif = asd.psSelStudentBySid(sadq);
				txtszz.setText(boif.getBookauthor());
				txtslb.setText(boif.getBooksort());
				txtsmc.setText(boif.getBookname());
				txtsbh.setText(boif.getBookcode());
				txtcbs.setText(boif.getBookpublish());
				txtsl.setText(new Integer(boif.getBookaddnumber()).toString());
				txtsj.setText(boif.getBooktime());
			}
		});
		panzjj.add(table.getTableHeader(), BorderLayout.NORTH);
		// �� ������� ��ӵ�������
		panzjj.add(table, BorderLayout.CENTER);

		panelzjz.setBorder(new LineBorder(Color.BLACK, 2));
		panzjj.setBorder(new LineBorder(Color.BLACK, 2));

		panel.add(panelzjz, BorderLayout.WEST);
		panel.add(panzjj, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		amend a = new amend();
	}

	public BookInfo getLib() {
		BookInfo bkf = null;
		String bookcode = txtsbh.getText();
		String bookname = txtsmc.getText();
		String bookpublish = txtcbs.getText();
		int bookaddnumber = new Integer(txtsl.getText());
		String booksort = txtslb.getText();
		String bookauthor = txtszz.getText();
		String booktime = txrq.getText();
		bkf = new BookInfo(bookcode, bookname, bookpublish, bookaddnumber, booksort, bookauthor, booktime);
		return bkf;
	}

}