package com.ksd.mp.controller.librarian;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableColumn;

import com.ksd.mp.GuanYi.BookInfo;
import com.ksd.mp.interior.refisteror;
import com.ksd.mp.servicer.LoginServicer;
import com.ksd.mp.servicer.registerQueryServicer;
import com.ksd.mp.servicer.Impl.LoginServicerlmpl;
import com.ksd.mp.servicer.Impl.registerQuerylmp;
import com.ksd.mp.util.BaseDao;
import com.ksd.mp.util.DateChooserJButton;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

//新书登记管理
public class register extends JFrame {

	private JTable table;
	private JTextField txtsbm;
	private JTextField txtsmc;
	private JTextField txtszz;
	private JTextField txtsjq;
	private JTextField txtssl;
	private JButton txrgrq;//   Date控件改为Text文本框输入
	private Toolkit kit;
	private JPanel panx;
	private JButton butqc;
	private JButton buttj;
	private JButton buttc;

	
	JComboBox ccbcbs=null;
	JComboBox cmbtslx=null;
	private JPanel panelz;

	public register() {
		super("新书登记管理");
		this.setSize(1000, 800);
		this.setLocationRelativeTo(null); // 使窗体居中显示
		Container con = this.getContentPane();
		con.setLayout(new BorderLayout(10, 5));

		// 创建的顶部
		JPanel panel = new JPanel();
//		panel.setBorder(new LineBorder(Color.red, 2));

		panelz = new JPanel();
		panelz.setBorder(new LineBorder(Color.BLACK, 2));

		// 调用上方绑定方法
		hint(panel);
		
		//调用所以图书信息
		 sobook(panelz);

		// 添加顶部按钮面板
		con.add(panel, BorderLayout.NORTH);

		// 添加到内容面板
		con.add(panelz, BorderLayout.CENTER);

		this.setVisible(true);
//		 关闭方式
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	// 提示框
	private void hint(JPanel panle) {
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
		Border cts = new TitledBorder(new LineBorder(Color.black, 1), "请输入完整图书信息");
		tsz.setBorder(cts);
		// 调用图书完整信息
		bookmessage(tsz);

		panle.add(tsz, BorderLayout.CENTER);
	}

	// 书籍完整信息
	private void bookmessage(JPanel panel) {

		panel.setLayout(new BorderLayout(10, 5));
		JPanel pansl = new JPanel();

		pansl.setLayout(new GridLayout(4, 4,20,8));
//		pansl.setBorder(new LineBorder(Color.red, 2));

		JLabel blx = new JLabel("图书类型:");
		cmbtslx = new JComboBox(); // 创建JComboBox
		cmbtslx.addItem("--请选择--"); // 向下拉列表中添加一项
		cmbtslx.addItem("文学");
		cmbtslx.addItem("美食");
		cmbtslx.addItem("修养");
		cmbtslx.addItem("传记");
		cmbtslx.addItem("动漫");
		cmbtslx.addItem("政治 军事");
		cmbtslx.addItem("求职");
		cmbtslx.addItem("武侠");
		pansl.add(blx);
		pansl.add(cmbtslx);		
		
		JLabel labmc = new JLabel("图书名称:");
		txtsmc = new JTextField();
		pansl.add(labmc);
		pansl.add(txtsmc);	
		
		JLabel labzz = new JLabel("图书作者:");
		txtszz = new JTextField();
		pansl.add(labzz);
		pansl.add(txtszz);	
		
		JLabel labjq = new JLabel("图书价钱:");
		txtsjq = new JTextField();
		pansl.add(labjq);
		pansl.add(txtsjq);	
		JLabel bcb = new JLabel("出版社:");
		ccbcbs = new JComboBox(); // 创建JComboBox
		ccbcbs.addItem("--请选择--"); // 向下拉列表中添加一项
		ccbcbs.addItem("北京大学出版社");
		ccbcbs.addItem("陕西人民出版社");
		ccbcbs.addItem("当代世界出版社");
		ccbcbs.addItem("湖南大学出版社");
		ccbcbs.addItem("人民大学出版社");
		ccbcbs.addItem("上海大学出版社");
		pansl.add(bcb);
		pansl.add(ccbcbs);	
		
		
		
		JLabel labsl = new JLabel("图书数量:");
		txtssl = new JTextField();
		pansl.add(labsl);
		pansl.add(txtssl);	
		
		
		JLabel labsq = new JLabel("入馆日期:");
//		 = new JTextField();
		
		txrgrq = new JButton();
		txrgrq.add(new DateChooserJButton(new SimpleDateFormat("yyyy/MM/dd HH"), "2020/12/12 22"),
				java.awt.BorderLayout.CENTER);
		
		
		
		pansl.add(labsq);
		pansl.add(txrgrq);
		
		//日期控件
		JLabel labxzrq = new JLabel("\u56FE\u4E66\u7F16\u7801\uFF1A");
		kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();
		pansl.add(labxzrq);
		
		

		panx = new JPanel();
		butqc = new JButton("清空");
		butqc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				清空
				txtsbm.setText("");
				txtsmc.setText("");
				txtszz.setText("");
				txtsjq.setText("");
				txrgrq.removeAll();
				txrgrq.add(new DateChooserJButton(new SimpleDateFormat("yyyy/MM/dd HH"), "2020/12/12 22"),java.awt.BorderLayout.CENTER);
				txrgrq.revalidate();
				
				cmbtslx.setSelectedIndex(0);
				ccbcbs.setSelectedIndex(0);
				txtssl.setText("");
				txrgrq.setText("");
			}
		});
		buttj = new JButton("添加");
		buttj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BaseDao.getConn();
				LoginServicer ls=new LoginServicerlmpl();
				BookInfo bk=getLib();
				int s=ls.psinsertlibrarian(bk);
				if(s>0){
					//添加
					JOptionPane.showMessageDialog(null, "添加成功");
					panelz.removeAll();
					refisteror.sobookone(panelz);
				    panelz.revalidate();
					
				}else{
					JOptionPane.showMessageDialog(null, "添加失败");
				}
				txtsbm.setText("");
				txtsmc.setText("");
				txtszz.setText("");
				txtsjq.setText("");
				txrgrq.removeAll();
				txrgrq.add(new DateChooserJButton(new SimpleDateFormat("yyyy/MM/dd HH"), "2020/12/12 22"),java.awt.BorderLayout.CENTER);
				txrgrq.revalidate();
				
				cmbtslx.setSelectedIndex(0);
				ccbcbs.setSelectedIndex(0);
				txtssl.setText("");
				txrgrq.setText("");
				
			}
		});
		
		buttc = new JButton("退出");
		buttc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//退出
				dispose();
			}
		});
		panx.setLayout(new GridLayout(0, 3, 0, 0));
		
		
		panx.add(butqc);
		panx.add(buttj);
		panx.add(buttc);
		
		
//		panx.setBorder(new LineBorder(Color.red, 2));

		// 绑定
		panel.add(pansl, BorderLayout.CENTER);
		
		txtsbm = new JTextField();
		pansl.add(txtsbm);
		txtsbm.setColumns(10);
		panel.add(panx, BorderLayout.SOUTH);
	}

	//所以图书
	private void sobook(JPanel panel){
		panel.setLayout(new BorderLayout(10, 5));
		// 提示框
		JPanel ts = new JPanel();
		ts.setLayout(new BorderLayout(10, 5));
		// 标题
		Border b = new TitledBorder(new LineBorder(Color.black, 1), "温馨提示");
		ts.setBorder(b);
		panel.add(ts);
		//调用图书信息方法
	
	        
	        table = refisteror.retable(null);
	        panel.add(table.getTableHeader(), BorderLayout.NORTH);
	        // 把 表格内容 添加到容器中心
	        panel.add(table, BorderLayout.CENTER);
	}
	
//	public static void main(String[] args) {
//		register s=new register();
//		
//	}
	public BookInfo getLib(){
		BookInfo bkf=null;
		String bookcode=txtsbm.getText();
		String bookname=txtsmc.getText();
		String  bookpublish=(String) ccbcbs.getSelectedItem();
		int bookaddnumber=new Integer(txtssl.getText());
		String booksort=(String) cmbtslx.getSelectedItem();
		String bookauthor=txtszz.getText();
		String bookprice=txtsjq.getText();
		String booktime=txrgrq.getText();
		bkf=new BookInfo(bookcode, bookname, bookpublish, bookaddnumber, booksort, bookauthor, bookprice, booktime);
		return bkf;
	}
	
	
}