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

//读者管理
public class readeradmin extends JFrame {

	private int rowNum = -1;
	private int cols = -1;
	JPanel panelz = null;
	Container con = null;

	public readeradmin() {
		super("读者登记管理");
		this.setSize(1000, 800);
		this.setLocationRelativeTo(null);
		con = this.getContentPane();
		con.setLayout(new BorderLayout(10, 5));
		// 上部布局
		JPanel panel = new JPanel();
//		panel.setBorder(new LineBorder(Color.BLACK, 2));

		// 中部布局
		panelz = new JPanel();
		panelz.setBorder(new LineBorder(Color.BLACK, 2));
		// 方法调用
		hint(panel);
		bookupde(panelz);

		con.add(panel, BorderLayout.NORTH);
		con.add(panelz, BorderLayout.CENTER);
		this.setVisible(true);
		// 关闭方式
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	// 读者
	private void bookupde(JPanel panelz) {
		// TODO Auto-generated method stub

		panelz.setLayout(new BorderLayout(10, 5));
		JTable table = readeradminor.adminq();
		panelz.add(table.getTableHeader(), BorderLayout.NORTH);

		table.addMouseListener(new MouseAdapter() {
			@Override

			public void mouseClicked(MouseEvent e) {

				JPopupMenu m1 = new JPopupMenu();
				JMenuItem m2 = new JMenuItem("添加读者");
				m1.add(m2);
				JMenuItem m3 = new JMenuItem("删除读者");
				m3.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub

						int index1 = table.getSelectedRow();// 获取选中的行
						Integer key = (Integer) table.getValueAt(index1, 0);
						readerServicer rada = new rederImpl();
						int n = rada.rederdelete(key);
						if (n < 1) {

							JOptionPane.showMessageDialog(panelz, "删除失败", "标题", JOptionPane.WARNING_MESSAGE);
						}
						panelz.removeAll();
						readeradminor.bookupde(panelz);
						panelz.revalidate();
					}
				});
				m1.add(m3);
				JMenu m4 = new JMenu("读者排序");
				m1.add(m4);
				JMenuItem mdz = new JMenuItem("按地址");
				m4.add(mdz);
				JMenuItem mxm = new JMenuItem("按姓名");
				m4.add(mxm);
				if (table.getSelectedRow() != -1) {
					if (e.getButton() == MouseEvent.BUTTON3) {
						// 弹出菜单的位置
						m1.show(table, e.getX(), e.getY());

					}
				}
			}

		});

		// 把 表格内容 添加到容器中
		panelz.add(table, BorderLayout.CENTER);

	}

	// 左右提示

	private void hint(JPanel panle) {
		// TODO Auto-generated method stub
		panle.setLayout(new BorderLayout(10, 5));
		// 提示框
		JPanel ts = new JPanel();
		ts.setLayout(new BorderLayout(10, 5));
		// 标题
		Border b = new TitledBorder(new LineBorder(Color.black, 1), "温馨提示");
		ts.setBorder(b);
		// 提示图片
		Icon icon = new ImageIcon("image/label.png");
		String disText = "<html><HTML><body style=color:red>尊敬的用户!…<br>" + "把图书信息填写完便您的管理!你在…<br>" + "系统时,如遇到系…<br>"
				+ "请联系: 1515620..  Multiline</body></html>";

		// 文字提示 方向样式
		JLabel labts = new JLabel(disText, icon, SwingConstants.LEFT);
		labts.setFont(new Font("宋体", Font.ITALIC, 18));
		labts.setVerticalAlignment(JLabel.TOP);
		labts.setSize(20, 250);
		ts.setPreferredSize(new Dimension(250, 200));
		ts.add(labts);
		panle.add(ts, BorderLayout.WEST);
		// 右边图书信息
		JPanel tsz = new JPanel();
		Border cts = new TitledBorder(new LineBorder(Color.black, 1), "请输入完整读者信息");
		tsz.setBorder(cts);
		// 调用图书修改信息
		bookmessage(tsz);

		panle.add(tsz, BorderLayout.CENTER);

	}

	// 上部中间
	private void bookmessage(JPanel tsz) {

		JPanel panelzj = new JPanel();
//		panelzj.setBorder(new LineBorder(Color.GREEN, 2));

		// TODO Auto-generated method stub
		panelzj.setLayout(new GridLayout(4, 4, 0, 20));

		JLabel labzdbb = new JLabel("读者编号");
		panelzj.add(labzdbb);
		JTextField txzzbh = new JTextField("自动编号");
		txzzbh.setEditable(false);
		panelzj.add(txzzbh);

		JLabel labsfz = new JLabel("身份证");
		panelzj.add(labsfz);
		JTextField txzsfz = new JTextField();
		panelzj.add(txzsfz);

		JLabel labxm = new JLabel("读者姓名");
		panelzj.add(labxm);
		JTextField txzxm = new JTextField();
		panelzj.add(txzxm);

		JLabel labrq = new JLabel("选择日期");
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

		JLabel labdh = new JLabel("读者电话");
		panelzj.add(labdh);
		JTextField txzdh = new JTextField();
		panelzj.add(txzdh);

		JLabel labdz = new JLabel("读者地址");
		panelzj.add(labdz);
		JTextField txdz = new JTextField();
		panelzj.add(txdz);

		JLabel labbz = new JLabel("备注");
		panelzj.add(labbz);
		JTextField txbz = new JTextField();
		panelzj.add(txbz);

		JPanel panelzy = new JPanel();
//		panelzy.setBorder(new LineBorder(Color.BLACK, 2));

		// 按钮

		panelzy.setLayout(new GridLayout(2, 1, 0, 20));
		JButton btndj = new JButton("登记");
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
					JOptionPane.showMessageDialog(tsz, "添加失败", "标题", JOptionPane.WARNING_MESSAGE);
				}
				panelz.removeAll();
				readeradminor.bookupde(panelz);
				panelz.revalidate();
				//清空设置
				txzxm.setText("");
				txzsfz.setText("");
				txrq.setText("");
				txzdh.setText("");
				txdz.setText("");
				txbz.setText("");

			}
		});
		JButton btnqx = new JButton("清空");
		btnqx.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//清空设置
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
