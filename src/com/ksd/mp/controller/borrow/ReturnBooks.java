package com.ksd.mp.controller.borrow;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.Border;

import com.ksd.mp.GuanYi.BookInfo;
import com.ksd.mp.GuanYi.TuShuJieYuexiabu;
import com.ksd.mp.GuanYi.readerGu;
import com.ksd.mp.interior.Bookren;
import com.ksd.mp.interior.Retrunor;
import com.ksd.mp.servicer.BookrenServicer;
import com.ksd.mp.servicer.FrmjieyueServicer;
import com.ksd.mp.servicer.ReturnServicer;
import com.ksd.mp.servicer.Impl.Bookrenlmpl;
import com.ksd.mp.servicer.Impl.Frmjieyuelmpl;
import com.ksd.mp.servicer.Impl.Returnlmpl;
import com.ksd.mp.util.DateChooserJButton;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.awt.FlowLayout;

//图书归还
public class ReturnBooks extends JFrame {
	private JTextField txtid;
	private JTextField txtxm;
	private JTextField txtzj;
	private JTextField txtdz;
	private JTextField txtdh;
	private JTextField txtbz;
	private JPanel panelj;
	private JTextField txtzz;
	private JTextField txtbh;
	private JTextField txtlb;
	private JPanel panelz;
	String yhrq = null;
	JTextField tssm = null;
	String dzid = null;
	JTable bt = null;
	JPanel xiabujieyue = null;
	String as = null;
	String bh = null;
	DateChooserJButton dateChooserJButton = null;
	DateChooserJButton dateChooserJButton2 = null;
	DateChooserJButton dateChooserJButton1 = null;

	public static void main(String[] args) {
		new ReturnBooks();
	}

	public ReturnBooks() {
		super("图书归还");
		this.setSize(753, 564);
		this.setLocationRelativeTo(null); // 使窗体居中显示
		Container con = this.getContentPane();
		getContentPane().setLayout(null);
		panelz = new JPanel();
		panelz.setBounds(0, 0, 254, 538);
		panelz.setBorder(new LineBorder(Color.BLACK, 0));
		// 调用读者基本信息
		loseInfo(panelz);
		con.add(panelz);

		panelj = new JPanel();
		panelj.setBounds(264, 0, 491, 538);
		// 调用读者续借时间
		tsgh(panelj);

		// 调用读者归还日期
		dzghrq(panelz);

		panelj.setBorder(new LineBorder(Color.red, 0));

		con.add(panelj);
		this.setResizable(false);

		// 显示
		this.setVisible(true);
		// 关闭方式
		// 关闭方式
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	// 读者归还日期
	private void dzghrq(JPanel panel) {
		JPanel panedzghrq = new JPanel();
		Border gh = new TitledBorder(new LineBorder(Color.black, 1), "归还日期");
		// panedzghrq.setLayout(null);
		panedzghrq.setBorder(gh);
		panedzghrq.setBounds(10, 258, 467, 275);
		// panelj.add(panedzghrq);

		xiabujieyue = new JPanel();
		xiabujieyue.setLayout(new BorderLayout(10, 2));
		// 创建一个表格，指定 所有行数据 和 表头
		bt = Retrunor.reteBook();

		bt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int s = bt.getSelectedRow();
				as = bt.getValueAt(s, 1).toString();
				bh = bt.getValueAt(s, 0).toString();
				yhrq = bt.getValueAt(s, 2).toString();
				BookrenServicer bos = new Bookrenlmpl();
				BookInfo instu = bos.Bangba(as, bh);

				tssm.setText(instu.getBookname());
				txtzz.setText(instu.getBookauthor());
				txtbh.setText(instu.getBookcode());
				txtlb.setText(instu.getBooksort());
				dateChooserJButton1.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), instu.getRetumdate());
				dateChooserJButton2.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), instu.getBorrowdate());

			}
		});
		panedzghrq.setLayout(new BorderLayout(0, 0));
		xiabujieyue.add(bt.getTableHeader(), BorderLayout.NORTH);
		// 把 表格内容 添加到容器中
		xiabujieyue.add(bt, BorderLayout.CENTER);
		panedzghrq.add(xiabujieyue);

		panelj.add(panedzghrq);
	}

	// 读者基本信息
	private void loseInfo(JPanel panel) {
		// 读者基本信息
		JPanel panelzs = new JPanel();
		panelzs.setBounds(2, 0, 250, 385);

		Border bzs = new TitledBorder(new LineBorder(Color.black, 1), "读者基本信息");
		panelzs.setLayout(null);

		JButton btncx = new JButton("查询");
		btncx.setBounds(10, 22, 103, 25);
		btncx.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String stuxm = txtxm.getText();
				String stuid = txtzj.getText();
				String studz = txtdz.getText();
				String sturq = dateChooserJButton.getText();

				if(stuxm.equals("")&&stuid.equals("")&&studz.equals("")){
					xiabujieyue.removeAll();
					xiabujieyue.setLayout(new BorderLayout(10, 2));
					// 创建一个表格，指定 所有行数据 和 表头
					bt = Retrunor.reteBook();

					bt.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							// TODO Auto-generated method stub
							int s = bt.getSelectedRow();
							as = bt.getValueAt(s, 1).toString();
							bh = bt.getValueAt(s, 0).toString();
							yhrq = bt.getValueAt(s, 2).toString();
							BookrenServicer bos = new Bookrenlmpl();
							BookInfo instu = bos.Bangba(as, bh);

							tssm.setText(instu.getBookname());
							txtzz.setText(instu.getBookauthor());
							txtbh.setText(instu.getBookcode());
							txtlb.setText(instu.getBooksort());
							dateChooserJButton1.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), instu.getRetumdate());
							dateChooserJButton2.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), instu.getBorrowdate());

						}
					});
					xiabujieyue.add(bt.getTableHeader(), BorderLayout.NORTH);
					// 把 表格内容 添加到容器中
					xiabujieyue.add(bt, BorderLayout.CENTER);

					xiabujieyue.revalidate();
					
				}else{
					
				
				readerGu serq =null;
				serq= new readerGu();
				
				serq.setReadername(stuxm);
				serq.setReadercardid(stuid);
				serq.setReaderaddress(studz);
				serq.setReaderdate(sturq);
				BookrenServicer sds = new Bookrenlmpl();
				readerGu gu = sds.tusxujie(serq);
				
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
						yhrq = bt.getValueAt(s, 2).toString();
						BookrenServicer bos = new Bookrenlmpl();
						BookInfo instu = bos.Bangba(as, bh);

						tssm.setText(instu.getBookname());
						txtzz.setText(instu.getBookauthor());
						txtbh.setText(instu.getBookcode());
						txtlb.setText(instu.getBooksort());
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
		});
		btncx.setFont(new Font("宋体", Font.PLAIN, 14));
		panelzs.add(btncx);
		JButton btnqk = new JButton("清空");
		btnqk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		panelzx.setBounds(2, 384, 250, 149);
		Border b = new TitledBorder(new LineBorder(Color.black, 1), "温馨提示");
		panelzx.setBorder(b);
		// 提示图片
		Icon icon = new ImageIcon("image/label.png");
		String disText = "<html><HTML><body style=color:red>愉快的借书<br>" + "开心的还书！！！<br>" + "如有系统问题<br>" + "请联系：<br>"
				+ "15116206615</body></html>";
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
		lblNewLabel.setBounds(10, 57, 61, 15);
		panelzs.add(lblNewLabel);

		txtid = new JTextField();
		txtid.setBounds(81, 54, 159, 21);
		txtid.setEnabled(false);
		panelzs.add(txtid);
		txtid.setColumns(10);

		JLabel label = new JLabel("\u59D3  \u540D\uFF1A");
		label.setBounds(10, 94, 61, 15);
		panelzs.add(label);

		txtxm = new JTextField();
		txtxm.setBounds(81, 85, 159, 21);
		txtxm.setColumns(10);
		panelzs.add(txtxm);

		JLabel lblNewLabel_1 = new JLabel("\u8BC1  \u4EF6\uFF1A");
		lblNewLabel_1.setBounds(10, 131, 54, 15);
		panelzs.add(lblNewLabel_1);

		txtzj = new JTextField();
		txtzj.setBounds(81, 128, 159, 21);
		txtzj.setColumns(10);
		panelzs.add(txtzj);

		JLabel label_1 = new JLabel("\u5730  \u5740\uFF1A");
		label_1.setBounds(10, 169, 61, 15);
		panelzs.add(label_1);

		txtdz = new JTextField();
		txtdz.setBounds(81, 166, 159, 21);
		panelzs.add(txtdz);
		txtdz.setColumns(10);

		JLabel label_2 = new JLabel("\u65E5  \u671F\uFF1A");
		label_2.setBounds(10, 209, 61, 15);

		panelzs.add(label_2);

		// 日期控件
		JButton txrq = new JButton();

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		String sone = df.format(new Date());
		dateChooserJButton = new DateChooserJButton(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"), sone);
		txrq.add(dateChooserJButton, java.awt.BorderLayout.CENTER);
		txrq.setBounds(81, 199, 159, 25);
		panelzs.add(txrq);

		JLabel label_3 = new JLabel("\u7535  \u8BDD\uFF1A");
		label_3.setBounds(10, 249, 61, 15);
		panelzs.add(label_3);

		txtdh = new JTextField();
		txtdh.setBounds(81, 246, 159, 21);
		txtdh.setColumns(10);
		panelzs.add(txtdh);

		JLabel lblNewLabel_2 = new JLabel("\u5907  \u6CE8\uFF1A");
		lblNewLabel_2.setBounds(10, 289, 61, 15);
		panelzs.add(lblNewLabel_2);

		txtbz = new JTextField();
		txtbz.setBounds(81, 289, 159, 90);
		txtbz.setColumns(10);
		panelzs.add(txtbz);
		panel.add(panelzx);

	}

	// 图书归还
	public void tsgh(JPanel panelgh) {
		JPanel gh = new JPanel();
		gh.setBounds(10, 0, 467, 248);
		// 标题
		Border b = new TitledBorder(new LineBorder(Color.black, 1), "图书归还");
		panelj.setLayout(null);
		gh.setBorder(b);
		gh.setLayout(null);

		JButton btngh = new JButton("归还此书");
		btngh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
						int hois=0;
						 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//注意月份是MM
					        Date d1=null;
					        if(yhrq==""){
					        	JOptionPane.showMessageDialog(null, "请选择一条消息");
					        	
					        }
							try {
								d1 = simpleDateFormat.parse(yhrq);
							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						Date d2 = new Date();
						long diff = d2.getTime() - d1.getTime();
						long days = diff / (1000 * 60 * 60 * 24);
						//long hours = (diff - days * (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
						//long minutes = (diff - days * (1000 * 60 * 60 * 24) - hours * (1000 * 60 * 60)) / (1000 * 60);
						//hois=(int)minutes;
						if(days<6){
							JOptionPane.showMessageDialog(null,"本馆规定只有借足6天才可以归还");
							return;
						}
							ReturnServicer saf=new Returnlmpl();
							int asd=saf.Bookguih(bh, as);
							if(asd>0){
								int numqw=saf.deltesa(as);
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
										yhrq = bt.getValueAt(s, 2).toString();
										BookrenServicer bos = new Bookrenlmpl();
										BookInfo instu = bos.Bangba(as, bh);
		
										tssm.setText(instu.getBookname());
										txtzz.setText(instu.getBookauthor());
										txtbh.setText(instu.getBookcode());
										txtlb.setText(instu.getBooksort());
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
						
//			}
		
					
			
		});
		btngh.setBounds(212, 20, 96, 23);
		gh.add(btngh);

		JLabel jtssm = new JLabel("图书书名：");
		jtssm.setBounds(10, 61, 71, 15);
		gh.add(jtssm);
		tssm = new JTextField();
		tssm.setBounds(80, 58, 130, 21);
		gh.add(tssm);

		panelgh.add(gh);

		JLabel label = new JLabel("\u56FE\u4E66\u4F5C\u8005:");
		label.setBounds(244, 61, 64, 15);
		gh.add(label);

		txtzz = new JTextField();
		txtzz.setBounds(314, 58, 130, 21);
		gh.add(txtzz);

		JLabel label_1 = new JLabel("\u56FE\u4E66\u7F16\u53F7\uFF1A");
		label_1.setBounds(10, 127, 71, 15);
		gh.add(label_1);

		JLabel label_2 = new JLabel("\u501F\u4E66\u65E5\u671F\uFF1A");
		label_2.setBounds(10, 194, 71, 15);
		gh.add(label_2);

		txtbh = new JTextField();
		txtbh.setBounds(80, 124, 130, 21);
		// 日期控件

		JButton txrq = new JButton();
		txrq.setBounds(79, 189, 150, 25);
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
		gh.add(txrq);
		gh.add(txtbh);

		txtlb = new JTextField();
		txtlb.setBounds(314, 124, 130, 21);
		// 日期控件

		JButton txrq1 = new JButton();
		txrq1.setBounds(310, 189, 150, 25);
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
		gh.add(txrq1);
		gh.add(txtlb);

		JLabel label_3 = new JLabel("\u56FE\u4E66\u7C7B\u522B:");
		label_3.setBounds(244, 127, 64, 15);
		gh.add(label_3);

		JLabel label_4 = new JLabel("\u5E94\u8FD8\u65E5\u671F\uFF1A");
		label_4.setBounds(244, 194, 71, 15);
		gh.add(label_4);
	}

}
