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

//读者信息管理
public class readerinformation extends JFrame {
	JPanel panezs=null;
	public readerinformation() {
		super("读者信息管理");
		this.setSize(1000, 800);
		this.setLocationRelativeTo(null);
		Container con = this.getContentPane();
		con.setLayout(new BorderLayout(10, 5));
		// 左部布局
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.BLACK, 2));

		// 中部布局
		JPanel panelz = new JPanel();
//		panelz.setBorder(new LineBorder(Color.red, 2));ad
		panelz.setLayout(new GridLayout(2, 1, 10, 50));
		// 方法调用
		hint(panel, panelz);

		con.add(panel, BorderLayout.WEST);
		con.add(panelz, BorderLayout.CENTER);
		this.setVisible(true);
		// 关闭方式
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	// 中间
	// private void bookupde(JPanel panelz,) {
	// // TODO Auto-generated method stub
	//
	// }
	// 左边读者基本信息
	private void hint(JPanel panleq, JPanel panelz) {

		panleq.setLayout(new BorderLayout(10, 5));

		// TODO Auto-generated method stub
		JPanel panel = new JPanel();
		Border br = new TitledBorder(new LineBorder(Color.black, 1), "读者基本信息");
		panel.setBorder(br);
		// 读者基本信息方法
		// meagesd(panel);

		panel.setLayout(new GridLayout(8, 2, 10, 50));
		// TODO Auto-generated method stub

		JLabel lbabh = new JLabel("读者编号");
		panel.add(lbabh);
		JTextField txzzbh = new JTextField();
		panel.add(txzzbh);

		JLabel lbaxm = new JLabel("姓名");
		panel.add(lbaxm);
		JTextField txxm = new JTextField();
		panel.add(txxm);

		JLabel lbazj = new JLabel("证件");
		panel.add(lbazj);
		JTextField txzzj = new JTextField();
		panel.add(txzzj);

		JLabel lbadz = new JLabel("地址");
		panel.add(lbadz);
		JTextField txzdz = new JTextField();
		panel.add(txzdz);

		JLabel lbarq = new JLabel("日期");
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

		JLabel lbadh = new JLabel("电话");
		panel.add(lbadh);
		JTextField txzdh = new JTextField();
		panel.add(txzdh);

		JLabel lbabz = new JLabel("备注");
		panel.add(lbabz);
		JTextField txbz = new JTextField();
		panel.add(txbz);

		panleq.add(panel, BorderLayout.CENTER);

		JButton btncx = new JButton("查询");
		btncx.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String xms=txxm.getText();

				if(xms.equals("")){
					panezs.removeAll();

					Border brA = new TitledBorder(new LineBorder(Color.black, 1), "读者借书表");
					panezs.setBorder(brA);

					panezs.setLayout(new BorderLayout(10, 5));
					// 借阅表
					JTable table = readeradminor.card();

					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							if (table.getSelectedRow() != -1) {
								int index1 = table.getSelectedRow();// 获取选中的行
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
					// 把 表格内容 添加到容器中
					panezs.add(table, BorderLayout.CENTER);
					
					panezs.revalidate();
				}else{
					panezs.removeAll();

					Border brA = new TitledBorder(new LineBorder(Color.black, 1), "读者借书表");
					panezs.setBorder(brA);

					panezs.setLayout(new BorderLayout(10, 5));
					// 借阅表
					JTable table = readeradminor.sele(xms);

					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							if (table.getSelectedRow() != -1) {
								int index1 = table.getSelectedRow();// 获取选中的行
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
					// 把 表格内容 添加到容器中
					panezs.add(table, BorderLayout.CENTER);
					
					panezs.revalidate();
					
				}
				
				
			}
		});
		panel.add(btncx);
		JButton btnqk = new JButton("清空");
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

		// 温馨提示
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
		panleq.add(ts, BorderLayout.SOUTH);

		// 中间上部
		 panezs = new JPanel();

		Border brA = new TitledBorder(new LineBorder(Color.black, 1), "读者借书表");
		panezs.setBorder(brA);

		panezs.setLayout(new BorderLayout(10, 5));

		// 中间下部
		JPanel panezx = new JPanel();
		Border bA = new TitledBorder(new LineBorder(Color.black, 1), "超期图书");
		panezx.setBorder(bA);

		panezx.setLayout(new BorderLayout(10, 5));
		// 借阅表
		JTable table = readeradminor.card();

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (table.getSelectedRow() != -1) {
					int index1 = table.getSelectedRow();// 获取选中的行
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
		// 把 表格内容 添加到容器中
		panezs.add(table, BorderLayout.CENTER);

		panelz.add(panezs);

		// 超期图书

		
		JTable tableo = readeradminor.cqbi();
		tableo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tableo.getSelectedRow() != -1) {
					int index1 = tableo.getSelectedRow();// 获取选中的行
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
		// 把 表格内容 添加到容器中
		panezx.add(tableo, BorderLayout.CENTER);

		panelz.add(panezx);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		readerinformation a = new readerinformation();
	}

}
