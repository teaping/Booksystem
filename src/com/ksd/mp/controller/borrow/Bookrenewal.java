package com.ksd.mp.controller.borrow;

//图书续借
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
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
import com.ksd.mp.GuanYi.TuShuJieYuexiabu;
import com.ksd.mp.GuanYi.readerGu;
import com.ksd.mp.interior.Bookren;
import com.ksd.mp.servicer.BookrenServicer;
import com.ksd.mp.servicer.FrmjieyueServicer;
import com.ksd.mp.servicer.registerQueryServicer;
import com.ksd.mp.servicer.Impl.Bookrenlmpl;
import com.ksd.mp.servicer.Impl.Frmjieyuelmpl;
import com.ksd.mp.servicer.Impl.registerQuerylmp;
import com.ksd.mp.util.DateChooserJButton;

import javax.swing.BoxLayout;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;

public class Bookrenewal extends JFrame {
	private JTextField txtid;
	private JTextField txtxm;
	private JTextField txtzj;
	private JTextField txtdz;
	private JTextField txtdh;
	private JTextField txtbz;
	private JTextField tssm;
	private JTextField tsbh;
	private JTextField tszz;
	private JTextField tslb;
	String as = null;
	String bh=null;
	JTable bt = null;
	JPanel xiabujieyue = null;
	DateChooserJButton dateChooserJButton1 = null;
	DateChooserJButton dateChooserJButton2 = null;
	String dzid=null;

	public Bookrenewal() {
		super("图书续借");
		this.setSize(850, 614);
		this.setLocationRelativeTo(null); // 使窗体居中显示
		Container con = this.getContentPane();
		getContentPane().setLayout(null);
		panelz = new JPanel();
		panelz.setBounds(0, 0, 250, 585);
		panelz.setBorder(new LineBorder(Color.BLACK, 0));
		// 调用读者基本信息
		loseInfo(panelz);
		con.add(panelz);

		panelj = new JPanel();
		panelj.setBounds(260, 0, 584, 585);
		// 调用读者续借时间
		loseadmin(panelj);

		panelj.setBorder(new LineBorder(Color.red, 0));

		con.add(panelj);

		this.setResizable(false);
		this.setVisible(true);
		// 关闭方式
		// 关闭方式
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	// 读者基本信息
	private void loseInfo(JPanel panel) {
		// 读者基本信息
		JPanel panelzs = new JPanel();
		panelzs.setBounds(0, 0, 250, 404);

		Border bzs = new TitledBorder(new LineBorder(Color.black, 1), "读者基本信息");
		panelzs.setLayout(null);

		JButton btnqk = new JButton("清空");
		btnqk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtid.setText("");
				txtxm.setText("");
				txtzj.setText("");
				txtdz.setText("");
				txtdh.setText("");
				txtbz.setText("");
			}
		});
		btnqk.setBounds(142, 22, 98, 25);
		btnqk.setFont(new Font("宋体", Font.PLAIN, 14));
		panelzs.add(btnqk);
		panelzs.setBorder(bzs);

		// 温馨提示
		JPanel panelzx = new JPanel();
		panelzx.setBounds(0, 403, 250, 180);
		Border b = new TitledBorder(new LineBorder(Color.black, 1), "温馨提示");
		panelzx.setBorder(b);
		// 提示图片
		Icon icon = new ImageIcon("image/label.png");
		String disText = "<html><HTML><body style=color:red>本馆规定结束期限为,<br>" + "2个月，续借时间一个月，<br>" + "可以多次续借，<br>"
				+ "图书如果丢失或损坏，<br>" + "图书严惩！！！</body></html>";
		// 文字提示 方向样式
		JLabel labts = new JLabel(disText, icon, SwingConstants.LEFT);
		labts.setFont(new Font("宋体", Font.ITALIC, 16));
		labts.setVerticalAlignment(JLabel.TOP);
		labts.setSize(20, 250);
		panelzx.setPreferredSize(new Dimension(250, 180));
		panelzx.add(labts);
		panelz.setLayout(null);
		panel.add(panelzs);

		JLabel lblNewLabel = new JLabel("\u8BFB\u8005ID\uFF1A");
		lblNewLabel.setBounds(10, 60, 61, 15);
		panelzs.add(lblNewLabel);

		txtid = new JTextField();
		txtid.setBounds(81, 57, 159, 21);
		txtid.setEditable(false);
		panelzs.add(txtid);
		txtid.setColumns(10);

		JLabel label = new JLabel("\u59D3  \u540D\uFF1A");
		label.setBounds(10, 98, 61, 15);
		panelzs.add(label);

		txtxm = new JTextField();
		txtxm.setColumns(10);
		txtxm.setBounds(81, 95, 159, 21);
		panelzs.add(txtxm);

		JLabel lblNewLabel_1 = new JLabel("\u8BC1  \u4EF6\uFF1A");
		lblNewLabel_1.setBounds(10, 135, 54, 15);
		panelzs.add(lblNewLabel_1);

		txtzj = new JTextField();
		txtzj.setColumns(10);
		txtzj.setBounds(81, 132, 159, 21);
		panelzs.add(txtzj);

		JLabel label_1 = new JLabel("\u5730  \u5740\uFF1A");
		label_1.setBounds(10, 175, 61, 15);
		panelzs.add(label_1);

		txtdz = new JTextField();
		txtdz.setBounds(81, 175, 159, 21);
		panelzs.add(txtdz);
		txtdz.setColumns(10);

		JLabel label_2 = new JLabel("\u65E5  \u671F\uFF1A");
		label_2.setBounds(10, 218, 61, 15);

		panelzs.add(label_2);

		// 日期控件

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		String sone = df.format(new Date());
		JButton txrq = new JButton();
		DateChooserJButton dateChooserJButton = new DateChooserJButton(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"),
				sone);
		txrq.setLocation(81, 218);
		txrq.add(dateChooserJButton, java.awt.BorderLayout.CENTER);
		txrq.setSize(159, 25);
		panelzs.add(txrq);

		JLabel label_3 = new JLabel("\u7535  \u8BDD\uFF1A");
		label_3.setBounds(10, 266, 61, 15);
		panelzs.add(label_3);

		txtdh = new JTextField();
		txtdh.setColumns(10);
		txtdh.setBounds(81, 263, 159, 21);
		panelzs.add(txtdh);

		JLabel lblNewLabel_2 = new JLabel("\u5907  \u6CE8\uFF1A");
		lblNewLabel_2.setBounds(10, 309, 61, 15);
		panelzs.add(lblNewLabel_2);

		txtbz = new JTextField();
		txtbz.setColumns(10);
		txtbz.setBounds(81, 309, 159, 90);
		panelzs.add(txtbz);
		panel.add(panelzx);

		JButton btncx = new JButton("查询");
		btncx.setBounds(10, 22, 103, 25);
		btncx.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				readerGu ser = new readerGu();
				String stuxm = txtxm.getText();
				String stuid = txtzj.getText();
				String studz = txtdz.getText();
				String sturq = dateChooserJButton.getText();

				ser.setReadername(stuxm);
				ser.setReadercardid(stuid);
				ser.setReaderaddress(studz);
				ser.setReaderdate(sturq);
				BookrenServicer sds = new Bookrenlmpl();
				readerGu gu = sds.tusxujie(ser);
				txtid.setText(gu.getReaderid().toString());
				txtxm.setText(gu.getReadername());
				txtzj.setText(gu.getReadercardid());
				txtdz.setText(gu.getReaderaddress());
				dateChooserJButton.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), gu.getReaderdate());
				txtbz.setText(gu.getReaderremark());
				txtdh.setText(gu.getReadertel());

				 dzid = txtid.getText();
				Bookren.bookjs(dzid);
				xiabujieyue.removeAll();
				xiabujieyue.setLayout(new BorderLayout(10, 2));
				// 创建一个表格，指定 所有行数据 和 表头
				bt = Bookren.bookjs(dzid);
				bt.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						int s = bt.getSelectedRow();
						 as = bt.getValueAt(s, 1).toString();
						 bh = bt.getValueAt(s, 0).toString();
						BookrenServicer bos = new Bookrenlmpl();
						BookInfo instu = bos.Bangba(as, bh);

						tssm.setText(instu.getBookname());
						tszz.setText(instu.getBookauthor());
						tsbh.setText(instu.getBookcode());
						tslb.setText(instu.getBooksort());
						dateChooserJButton1.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), instu.getRetumdate());
						dateChooserJButton2.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), instu.getBorrowdate());

					}
				});
				xiabujieyue.add(bt.getTableHeader(), BorderLayout.NORTH);
				// 把 表格内容 添加到容器中
				xiabujieyue.add(bt, BorderLayout.CENTER);
				xiabujieyue.revalidate();

			}
		});
		btncx.setFont(new Font("宋体", Font.PLAIN, 14));
		panelzs.add(btncx);
	}

	JTable jt = null;
	JScrollPane jsp = null;
	private JPanel panelj;
	private JPanel panelz;

	// 续借图书
	private void loseadmin(JPanel panel) {
		// 选择图书上部信息
		JPanel panelzs = new JPanel();
		panelzs.setBounds(10, 0, 564, 267);

		Border bzs = new TitledBorder(new LineBorder(Color.black, 1), "续借图书");
		panelj.setLayout(null);
		panelzs.setBorder(bzs);

		panel.add(panelzs);
		panelzs.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("\u7EED\u501F\u65F6\u957F\uFF1A");
		lblNewLabel_3.setBounds(26, 39, 87, 15);
		panelzs.add(lblNewLabel_3);

		


		JButton btnqx = new JButton("清空");
		btnqx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tssm.setText("");
				tszz.setText("");
				tsbh.setText("");
				tslb.setText("");
				
				dateChooserJButton1.setDate(new Date());
				dateChooserJButton2.setDate(new Date());
			}
		});
		btnqx.setBounds(440, 35, 93, 23);
		panelzs.add(btnqx);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(123, 36, 54, 21);
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
		panelzs.add(comboBox);

		JLabel label = new JLabel("\u5929");
		label.setBounds(187, 39, 54, 15);
		panelzs.add(label);

		JLabel label_1 = new JLabel("\u56FE\u4E66\u4E66\u540D\uFF1A");
		label_1.setBounds(26, 100, 87, 15);
		panelzs.add(label_1);

		JLabel label_2 = new JLabel("\u56FE\u4E66\u7F16\u53F7\uFF1A");
		label_2.setBounds(26, 165, 87, 15);
		panelzs.add(label_2);

		JLabel label_3 = new JLabel("\u501F\u4E66\u65E5\u671F\uFF1A");
		label_3.setBounds(26, 220, 87, 15);
		panelzs.add(label_3);
		
		JButton btncs = new JButton("\u7EED\u501F\u6B64\u4E66");
		btncs.setBounds(260, 35, 93, 23);
		btncs.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String ts=comboBox.getSelectedItem().toString();
				if(as!=null&&!as.equals("")){
					if(bh!=null&&!bh.equals("")){
						BookrenServicer sda=new Bookrenlmpl();
						int s=sda.insertXj(bh,as,ts);
						if(s>0){
							
							
							xiabujieyue.removeAll();
							xiabujieyue.setLayout(new BorderLayout(10, 2));
							// 创建一个表格，指定 所有行数据 和 表头
							bt = Bookren.bookjs(dzid);
							bt.addMouseListener(new MouseAdapter() {
								@Override
								public void mouseClicked(MouseEvent e) {
									// TODO Auto-generated method stub
									int s = bt.getSelectedRow();
									 as = bt.getValueAt(s, 1).toString();
									 bh = bt.getValueAt(s, 0).toString();
									BookrenServicer bos = new Bookrenlmpl();
									BookInfo instu = bos.Bangba(as, bh);

									tssm.setText(instu.getBookname());
									tszz.setText(instu.getBookauthor());
									tsbh.setText(instu.getBookcode());
									tslb.setText(instu.getBooksort());
									dateChooserJButton1.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), instu.getRetumdate());
									dateChooserJButton2.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), instu.getBorrowdate());

								}
							});
							xiabujieyue.add(bt.getTableHeader(), BorderLayout.NORTH);
							// 把 表格内容 添加到容器中
							xiabujieyue.add(bt, BorderLayout.CENTER);
							xiabujieyue.revalidate();
						}
					}
				}
				
			
				
			}	
		});
		panelzs.add(btncs);

		// 借书日期
		// 日期控件
		JButton txrq = new JButton();
		txrq.setBounds(98, 220, 155, 25);
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		String sone1 = df1.format(new Date());
		dateChooserJButton2 = new DateChooserJButton(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"), sone1);
		txrq.add(dateChooserJButton2, java.awt.BorderLayout.CENTER);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();
		int w = txrq.getWidth();
		int h = txrq.getHeight();
		panelzs.add(txrq);

		JLabel label_5 = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");
		label_5.setBounds(293, 100, 87, 15);
		panelzs.add(label_5);

		JLabel label_6 = new JLabel("\u56FE\u4E66\u7C7B\u522B\uFF1A");
		label_6.setBounds(293, 165, 87, 15);
		panelzs.add(label_6);

		JLabel label_7 = new JLabel("\u5E94\u8FD8\u65E5\u671F\uFF1A");
		label_7.setBounds(293, 220, 87, 15);
		panelzs.add(label_7);

		tssm = new JTextField();
		tssm.setBounds(109, 97, 118, 21);
		panelzs.add(tssm);
		tssm.setColumns(10);

		tsbh = new JTextField();
		tsbh.setBounds(109, 162, 118, 21);
		tsbh.setColumns(10);
		panelzs.add(tsbh);

		tszz = new JTextField();
		tszz.setBounds(390, 97, 118, 21);
		tszz.setColumns(10);
		panelzs.add(tszz);

		tslb = new JTextField();
		tslb.setBounds(390, 162, 118, 21);
		tslb.setColumns(10);
		panelzs.add(tslb);

		// 应还日期

		// 日期控件
		JButton txrq1 = new JButton();
		txrq1.setBounds(390, 220, 155, 25);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		String sone = df.format(new Date());
		dateChooserJButton1 = new DateChooserJButton(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"), sone);
		txrq1.add(dateChooserJButton1, java.awt.BorderLayout.CENTER);
		Toolkit kit1 = Toolkit.getDefaultToolkit();
		Dimension screenSize1 = kit1.getScreenSize();
		int width1 = (int) screenSize1.getWidth();
		int height1 = (int) screenSize.getHeight();
		int w1 = txrq1.getWidth();
		int h1 = txrq1.getHeight();
		panelzs.add(txrq1);

		JPanel penxjrq = new JPanel();
		penxjrq.setBounds(10, 277, 564, 298);
		Border bzs1 = new TitledBorder(new LineBorder(Color.black, 1), "续借信息");

		penxjrq.setBorder(bzs1);

		xiabujieyue = new JPanel();
		xiabujieyue.setLayout(new BorderLayout(10, 2));

		// 创建一个表格，指定 所有行数据 和 表头
		bt = Bookren.bookjs(null);
		bt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int s = bt.getSelectedRow();
				 as = bt.getValueAt(s, 1).toString();
				 bh = bt.getValueAt(s, 0).toString();
				BookrenServicer bos = new Bookrenlmpl();
				BookInfo instu = bos.Bangba(as, bh);

				tssm.setText(instu.getBookname());
				tszz.setText(instu.getBookauthor());
				tsbh.setText(instu.getBookcode());
				tslb.setText(instu.getBooksort());
				dateChooserJButton1.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), instu.getRetumdate());
				dateChooserJButton2.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), instu.getBorrowdate());

			}
		});
		panelj.setLayout(null);
		penxjrq.setLayout(null);
		penxjrq.setLayout(new BorderLayout(0, 0));
		xiabujieyue.add(bt.getTableHeader(), BorderLayout.NORTH);
		// 把 表格内容 添加到容器中
		xiabujieyue.add(bt, BorderLayout.CENTER);
		penxjrq.add(xiabujieyue);
		panel.add(penxjrq);

		panelj.add(penxjrq);

	}

	public static void main(String[] args) {
		new Bookrenewal();
	}
}
