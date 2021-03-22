package com.ksd.mp.controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutFocusTraversalPolicy;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

import com.ksd.mp.controller.borrow.Bookrenewal;
import com.ksd.mp.controller.borrow.Frmjieyue;
import com.ksd.mp.controller.borrow.Overdue;
import com.ksd.mp.controller.borrow.ReturnBooks;
import com.ksd.mp.controller.librarian.amend;
import com.ksd.mp.controller.librarian.inquirebook;
import com.ksd.mp.controller.librarian.lose;
import com.ksd.mp.controller.librarian.register;
import com.ksd.mp.controller.reader.management;
import com.ksd.mp.controller.reader.readeradmin;
import com.ksd.mp.controller.reader.readerinformation;
import com.ksd.mp.controller.terminal.ranking;
import com.ksd.mp.controller.terminal.systemho;
import com.ksd.mp.controller.terminal.usersystem;
import com.ksd.mp.util.Calculator;
import com.ksd.mp.util.ExcelExporter;

import Music.Music_frame;
import music0.StartUp;

public class homepage {
	public homepage() {
	}

	public static JFrame frame = null;
	//// 几个管理功能用到的图片
	Icon iconsz = new ImageIcon("image/Play.png");
	JPanel ts = null;
	// 底部panle
	JPanel pandb = null;
	// 时间文本
	JLabel labxtsj = null;
	// 中间显示文字
	JLabel wordbook = null;
	JPanel pabook=null;

	public void logzh() {
		// 创建 JFrame 实例
		frame = new JFrame("图书管理系统");
		// 美化包
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		// Setting the width and height of frame
		frame.setSize(1600, 1800);

		// 加载监听事件
		frame.addWindowListener(new WindowListener() {
			@Override
			public void windowOpened(WindowEvent e) {

				bottom(pandb);
				// TODO Auto-generated method stub
				new Timer(1000, taskPerformer).start();
				// 调用状态栏
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}
		});

		// 居中
		frame.setLocationRelativeTo(null);
		// 图片
		// 窗口置顶
		// frame.setAlwaysOnTop(true);
		// 创建内容面板
		Container con = frame.getContentPane();
		// 设置水平间距
		con.setLayout(new BorderLayout(10, 5));

		// 添加内容面板到frame
		// frame.getContentPane().add(con);

		// JLabel lbbj=new JLabel(new ImageIcon(""));
		// 创建面板
		JPanel panel = new JPanel();

		// panel.setBorder(new LineBorder(Color.red, 2));

		// 创建中间面板
		JPanel panelz = new JPanel();
		panelz.setBorder(new LineBorder(Color.BLACK, 2));

		// 创建底部面板 底部状态栏
		pandb = new JPanel();
		pandb.setBorder(new LineBorder(Color.BLACK, 1));
		pandb.setLayout(new FlowLayout(FlowLayout.LEFT));
		con.add(pandb, BorderLayout.SOUTH);
		// 添加顶部按钮面板
		con.add(panel, BorderLayout.NORTH);
		// 添加到内容面板
		con.add(panelz, BorderLayout.CENTER);
		// 调用顶部按钮方法
		ZhuiYe(panel);

		// 调用中部按钮方法
		Zhongbu(panelz);
		// 设置界面可见
		frame.setVisible(true);
		// 关闭方式
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// 上部按钮方法
	private void ZhuiYe(JPanel panel) {
		// panel.setSize(1600, 150);
		// 设置按钮图片
		Icon icons[] = new ImageIcon[] { new ImageIcon("image/conver.png"), new ImageIcon("image/locksys.png"),
				new ImageIcon("image/SysSet.png"), new ImageIcon("image/DataBak.png"),
			 new ImageIcon("image/Help.png"),
				new ImageIcon("image/exit.png"), };
		// 按钮布局方式
		panel.setLayout(new GridLayout(1, 3, 130, 3));
		// 遍历图片数组
		JButton but = null;
		for (int i = 0; i < icons.length; i++) {
			but = new JButton(icons[i]);
			but.setActionCommand(i + "");
			// 设置大小位置
			but.setSize(icons[i].getIconWidth(), icons[i].getIconHeight());
			but.setBounds(i * 300, 0, icons[i].getIconWidth(), icons[i].getIconHeight());
			but.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String a = e.getActionCommand();
					// TODO Auto-generated method stub
					// String qwe=logfrom.qxqw;
					switch (a) {

					case "0":
						logfrom l = new logfrom();
						l.numn = 1;
						l.logJz();
						break;
					case "1":

						// 锁屏功能
						LockFrame lock = new LockFrame(null, "系统锁屏", true);
						lock.setVisible(true);
						break;
					case "2":
						ts.removeAll();
						wordbook.setText("系统管理");
						system(pabook);
						ts.revalidate();
						break;
						
						
					case "3":
						new ExcelExporter();

						break;

					case "4":
						// new StartUp();
						try {
							Desktop.getDesktop().open(new File("CHM 帮助.chm"));
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						break;

					case "5":
						if (JOptionPane.showConfirmDialog(null, "确定退出吗?", "提示", JOptionPane.OK_CANCEL_OPTION) == 0) {
							System.exit(0);
						}
						break;

					default:
						break;
					}
				}
			});
			panel.add(but);
		}

	}

	// 中部方式
	private void Zhongbu(JPanel panelz) {
		// 设置间距
		panelz.setLayout(new BorderLayout(10, 10));
		// 创建面板左部
		JPanel pazz = new JPanel();

		// 设置左边样式
		pazz.setLayout(new GridLayout(8, 1, 30, 80));
		// 创建中部 //样式
		pabook = new JPanel();
		pabook.setLayout(new BorderLayout(10, 10));
		// pabook.setBorder(new LineBorder(Color.red, 2));
		// 准备图片数组
		Icon icons[] = new ImageIcon[] { new ImageIcon("image/File.png"), new ImageIcon("image/Next.png"),
				new ImageIcon("image/Stop.png"), new ImageIcon("image/Front.png") };
		Font font = new Font("宋体", Font.BOLD, 30);
		// 准备文字
		String[] word = new String[] { "图书管理", "借阅管理", "读者管理", "系统管理" };
		// 左边第一个
		JLabel lawy = new JLabel();
		lawy.setOpaque(false);
		pazz.add(lawy);
		
		JLabel lawy1 = new JLabel();
		lawy1.setOpaque(false);
		pazz.add(lawy1);

		// 创建按钮
		JButton but = null;
		for (int i = 0; i < icons.length; i++) {
			but = new JButton(word[i], icons[i]);
			but.setHorizontalTextPosition(SwingConstants.RIGHT);
			but.setFont(font);
			but.setSize(icons[i].getIconWidth() + 80, icons[i].getIconHeight() + 10);
			but.setBounds(0, i * 100, icons[i].getIconWidth() + 80, icons[i].getIconHeight() + 10);
			but.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					ts.removeAll();
					// ts.repaint();
					// TODO Auto-generated method stub
					JButton but1 = (JButton) e.getSource();
					String wz = but1.getText();
					switch (wz) {
					case "图书管理":
						wordbook.setText("图书管理");
						bookadmin(pabook);
						ts.revalidate();
						break;
					case "借阅管理":
						wordbook.setText("借阅管理");
						borrow(pabook);
						ts.revalidate();
						break;
					case "读者管理":
						wordbook.setText("读者管理");
						reader(pabook);
						ts.revalidate();
						break;
					case "系统管理":
						wordbook.setText("系统管理");
						system(pabook);
						ts.revalidate();
						break;
					}
				}
			});
			pazz.add(but);
		}
		// 创建中的上部面板
		JPanel zjsb = new JPanel();
		zjsb.setLayout(new GridLayout(2, 1, 30, 50));

		JLabel zjwy = new JLabel();

		zjwy.setOpaque(false);
		// 中间显示文字
		wordbook = new JLabel("图书管理", SwingConstants.CENTER);
		wordbook.setFont(new Font("华文琥珀", Font.PLAIN, 58));
		// wordbook.setBorder(new LineBorder(Color.GREEN, 2));
		zjsb.add(zjwy);
		zjsb.add(wordbook);

		// 绑定中间文字
		pabook.add(zjsb, BorderLayout.NORTH);

		bookadmin(pabook);

		panelz.add(pazz, BorderLayout.WEST);

		panelz.add(pabook, BorderLayout.CENTER);

	}

	// 图书管理功能
	private void bookadmin(JPanel pabook) {

		ts = new JPanel();
		ts.setLayout(null);
		// ts.setBorder(new LineBorder(Color.GREEN, 2));
		// 准备图书管理按钮上面的文字
		String[] bookword = { "图书登记", "图书遗失", "图书修改", "图书查询" };
		Font font1 = new Font("宋体", Font.BOLD, 28);

		JButton btndj = new JButton("图书登记", iconsz);
		btndj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new register();
			}
		});
		btndj.setFont(font1);
		btndj.setBounds(300, 200, 200, 50);
		ts.add(btndj);
		JButton btnys = new JButton("图书遗失", iconsz);
		btnys.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new lose();
			}
		});
		btnys.setFont(font1);
		btnys.setBounds(650, 200, 200, 50);
		ts.add(btnys);
		JButton btnxg = new JButton("图书修改", iconsz);
		btnxg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new amend();
			}
		});
		btnxg.setFont(font1);
		btnxg.setBounds(950, 200, 200, 50);
		ts.add(btnxg);
		JButton btncx = new JButton("图书查询", iconsz);
		btncx.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new inquirebook();
			}
		});
		btncx.setFont(font1);
		btncx.setBounds(1250, 200, 200, 50);
		ts.add(btncx);

		
		pabook.add(ts, BorderLayout.CENTER);

	}

	// 借阅管理
	private void borrow(JPanel pabook) {

		ts = new JPanel();

		ts.setLayout(null);
		Font font = new Font("宋体", Font.BOLD, 30);

		JButton btnjy = new JButton("图书借阅", iconsz);
		btnjy.setFont(font);
		btnjy.setBounds(300, 200, 200, 50);
		btnjy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Frmjieyue();
			}
		});
		ts.add(btnjy);
		
		
		JButton btnxj = new JButton("图书续借", iconsz);
		btnxj.setFont(font);
		btnxj.setBounds(650, 200, 200, 50);
		btnxj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Bookrenewal();
			}
		});
		ts.add(btnxj);
		
		JButton btngj = new JButton("图书归借" ,iconsz);
		btngj.setFont(font);
		btngj.setBounds(950, 200, 200, 50);
		btngj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ReturnBooks();
			}
		});
		ts.add(btngj);
		
		
		JButton btncq = new JButton("超期图书", iconsz);
		btncq.setFont(font);
		btncq.setBounds(1250, 200, 200, 50);
		btncq.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Overdue();
			}
		});
		ts.add(btncq);
		
		
		
		
		
//
//		// 准备图书管理按钮上面的文字
//		String[] bookword = { "图书借阅", "图书续借", "图书归还", "超期图书" };
//
//		// 创建按钮
//		JButton but = null;
//		for (int i = 0; i < bookword.length; i++) {
//			but = new JButton(bookword[i], iconsz);
//			but.setFont(font);
//			ts.add(but);
//		}

		pabook.add(ts, BorderLayout.CENTER);

	}

	// 读者管理
	private void reader(JPanel pabook) {

		ts = new JPanel();
		// ts.setBorder(new LineBorder(Color.GREEN, 2));
		ts.setLayout(null);
		Font font = new Font("宋体", Font.BOLD, 30);
		// 准备图书管理按钮上面的文字
		// String [] bookword={"读者登记","读者信息","读者删改"};

		JButton btndzdj = new JButton("读者登记", iconsz);
		btndzdj.setFont(font);
		btndzdj.setBounds(450, 200, 200, 50);
		btndzdj.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new readeradmin();
			}
		});
		ts.add(btndzdj);

		JButton btndzxx = new JButton("读者信息", iconsz);
		btndzxx.setFont(font);
		btndzxx.setBounds(750, 200, 200, 50);
		btndzxx.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new readerinformation();
			}
		});

		ts.add(btndzxx);

		JButton btndzsg = new JButton("读者删改", iconsz);
		btndzsg.setFont(font);
		btndzsg.setBounds(1050, 200, 200, 50);
		btndzsg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new management();
			}
		});
		ts.add(btndzsg);
		pabook.add(ts, BorderLayout.CENTER);

	}

	// 系统管理
	private void system(JPanel pabook) {

		ts = new JPanel();
		ts.setLayout(null);
		Font font = new Font("宋体", Font.BOLD, 30);
		// 准备图书管理按钮上面的文字
		// String [] bookword={"用户改密","排行榜单","用户管理"};
		JButton btngm = new JButton("用户改密", iconsz);
		btngm.setFont(font);
		btngm.setBounds(300, 200, 200, 50);
		btngm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new systemho(frame);
			}
		});
		ts.add(btngm);
		JButton btnpbb = new JButton("排行榜单", iconsz);
		btnpbb.setFont(font);
		btnpbb.setBounds(650, 200, 200, 50);
		btnpbb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ranking();
			}
		});
		ts.add(btnpbb);

		JButton btngl = new JButton("用户管理", iconsz);
		if (logfrom.qxqw.equals("普通用户")) {
			btngl.setEnabled(false);
		}
		btngl.setFont(font);
		btngl.setBounds(950, 200, 200, 50);
		btngl.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new usersystem();
			}
		});
		ts.add(btngl);

		JButton btnjsq = new JButton("计算器", iconsz);
		btnjsq.setFont(font);
		btnjsq.setBounds(1250, 200, 200, 50);
		btnjsq.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Calculator();
			}
		});
		ts.add(btnjsq);

		JButton btnyg = new JButton("音乐", iconsz);
		btnyg.setFont(font);
		btnyg.setBounds(750, 300, 200, 50);
		btnyg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Music_frame frame = new Music_frame();

				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				frame.setResizable(false);
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			}
		});
		ts.add(btnyg);

		pabook.add(ts, BorderLayout.CENTER);

	}

	// 底部
	private void bottom(JPanel pandb) {

		Font font = new Font("宋体", Font.PLAIN, 24);
		// 时间

		JLabel labyh = new JLabel("当前用户:" + logfrom.gylname);
		labyh.setFont(font);
		// labyh.setSize(50, 20);;
		JLabel labjb = new JLabel("级别:");
		labjb.setFont(font);
		labjb.setText("级别:" + logfrom.uview);
		labxtsj = new JLabel();// new Date()为获取当前系统时间
		labxtsj.setFont(font);
		JLabel labbbh = new JLabel("版本号：图书管理系统");
		labbbh.setFont(font);
		JLabel labzz = new JLabel("作者:夏克南,谢凯枫,谢家旺");
		labzz.setFont(font);
		pandb.add(labyh);
		pandb.add(labjb);
		pandb.add(labxtsj);
		pandb.add(labbbh);
		pandb.add(labzz);
	}

	// 获取系统时间
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
	ActionListener taskPerformer = new ActionListener() {

		public void actionPerformed(ActionEvent evt) {
			labxtsj.setText("系统时间：" + df.format(new Date())); // 打印当前时间
			// ...Perform a task...
		}
	};

	public static void main(String[] args) {
		homepage q = new homepage();
		q.logzh();
	}

}
