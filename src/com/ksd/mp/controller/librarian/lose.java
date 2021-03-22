package com.ksd.mp.controller.librarian;

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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.ksd.mp.GuanYi.BookInfo;
import com.ksd.mp.controller.ReaderDate;
import com.ksd.mp.interior.refisteror;
import com.ksd.mp.servicer.LoginServicer;
import com.ksd.mp.servicer.Impl.LoginServicerlmpl;
import com.ksd.mp.util.BaseDao;
import com.ksd.mp.util.DateChooserJButton;

public class lose extends JFrame {
	public	static Double key;
	private JButton butcx;
	private JPanel panelzs;
	public static String dz;
	public static String bm;
	public static String mc;
	public static String jg;
	private JButton butqk;
	private JTextField txtbh;
	private JTextField txxm;
	private JTextField txzj;
	private JTextField txdz;
	private JTextField txdh;
	private JTextField txbz;
	private JTextField txdzbh;
	private JTextField txtsbh;
	private JTextField txtsmc;
	private JTextField txtdzxm;
	private JTextField txtcbs;
	private JTextField txtlx;
	private JTextField txtrq;
	private JTextField txtsfz;
	private JPanel panelxd;
	private JLabel labq;
	private JButton butqr;
	private JButton txrq;
	public JTable table1;
	String tushubh=null;
	String studxc=null;
	JPanel panelta=null;
	public lose(){
		super("图书遗失管理");
		this.setSize(1000, 800);
		this.setLocationRelativeTo(null); // 使窗体居中显示
		Container con=this.getContentPane();
		con.setLayout(new BorderLayout(10, 5));
		JPanel panelz=new JPanel();
//		panelz.setBorder(new LineBorder(Color.BLACK, 2));
		//调用读者基本信息
		loseInfo(panelz);
		con.add(panelz,BorderLayout.WEST);
		
		JPanel panelj=new JPanel();
		//调用遗失读者信息操作
		loseadmin(panelj);
		
//		panelj.setBorder(new LineBorder(Color.red, 2));

		con.add(panelj,BorderLayout.CENTER);
		
		this.setVisible(true);
		// 关闭方式

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
	//读者基本信息
	private void loseInfo(JPanel panel){
		panel.setLayout(new BorderLayout(10, 5));
		panelzs = new JPanel();

		panelzs.setLayout(new GridLayout(8,2,0,50));
		
		Border bzs = new TitledBorder(new LineBorder(Color.black, 1), "读者基本信息");
		panelzs.setBorder(bzs);
		butcx = new JButton("查询");
		butcx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtbh.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "请输入书本名称");
					return;
				}
				BaseDao.getConn();
				BookInfo bkf=null;
				LoginServicer ls = new LoginServicerlmpl();
				bkf=ls.psSelStudentBytsys(txtbh.getText());
				txxm.setText(bkf.getReadername());
				txzj.setText(bkf.getReadercardid());   
				txdz.setText(bkf.getReaderaddress());   
				txdh.setText(bkf.getReadertel());   
				txbz.setText(bkf.getReaderremark());   
				txdzbh.setText(new Integer(bkf.getReaderid()).toString());
				txtsbh.setText(bkf.getBookcode()); 
				txtsmc.setText(bkf.getBookname()); 
				txtdzxm.setText(bkf.getReadername());
				txtcbs.setText(bkf.getBookpublish()); 
				txtlx.setText(bkf.getBooksort());  
				txtrq.setText(bkf.getRetumdate());  
				txtsfz.setText(bkf.getReadercardid()); 
				txrq.setText(bkf.getRetumdate());
			}
		});
		panelzs.add(butcx);
		butqk = new JButton("清空");
		butqk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtbh.setText(""); 
				txxm.setText("");  
				txzj.setText("");  
				txdz.setText("");  
				txdh.setText("");  
				txbz.setText("");  
				txdzbh.setText("");
				txtsbh.setText("");
				txtsmc.setText("");
				txtdzxm.setText("");
				txtcbs.setText("");
				txtlx.setText(""); 
				txtrq.setText("");   
				txtsfz.setText("");
			}
		});
		panelzs.add(butqk);
		
		JLabel labbh=new JLabel("读者编号");
		panelzs.add(labbh);
		txtbh = new JTextField();
		panelzs.add(txtbh);
		JLabel labxm=new JLabel("姓名");
		panelzs.add(labxm);
		txxm = new JTextField();
		txxm.setEditable(false);

		panelzs.add(txxm);
		JLabel labzj=new JLabel("证件");

		panelzs.add(labzj);
		txzj = new JTextField();
		txzj.setEditable(false);

		panelzs.add(txzj);
		JLabel labdz=new JLabel("地址");

		panelzs.add(labdz);
		txdz = new JTextField();
		txdz.setEditable(false);

		panelzs.add(txdz);
		JLabel labrq=new JLabel("日期");

		panelzs.add(labrq);
		txrq = new JButton();
		DateChooserJButton dateChooserJButton = new DateChooserJButton(new SimpleDateFormat("yyyy/MM/dd HH"),"2012/12/12 22");
		dateChooserJButton.setText("");
		txrq.add(dateChooserJButton, java.awt.BorderLayout.CENTER);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();
		int w = txrq.getWidth();
		int h = txrq.getHeight();
		txrq.setSize(200, 200);
		
		panelzs.add(txrq);
		
		JLabel labdh=new JLabel("电话");

		panelzs.add(labdh);
		txdh = new JTextField();
		txdh.setEditable(false);

		panelzs.add(txdh);
		JLabel labbz=new JLabel("备注");

		panelzs.add(labbz);
		txbz = new JTextField();
		txbz.setEditable(false);

		panelzs.add(txbz);
		
		
		//温馨提示
		JPanel panelzx=new JPanel();
		Border b = new TitledBorder(new LineBorder(Color.black, 1), "温馨提示");
		panelzx.setBorder(b);
		// 提示图片
		Icon icon = new ImageIcon("image/label.png");
		String disText = "<html><HTML><body style=color:red>尊敬的用户!…<br>" + "把图书信息填写完<br>"+"便您的管理!你在…<br>" + "系统时,如遇到系…<br>"
				+ "请联系: 1515620..<br>  Multiline</body></html>";

		// 文字提示 方向样式
		JLabel labts = new JLabel(disText,icon,SwingConstants.LEFT);
		labts.setFont(new Font("宋体", Font.ITALIC, 16));
		labts.setVerticalAlignment(JLabel.TOP);
		labts.setSize(20, 250);
		panelzx.setPreferredSize(new Dimension(250, 180));
		panelzx.add(labts);
		panel.add(panelzs,BorderLayout.CENTER);
		panel.add(panelzx,BorderLayout.SOUTH);
		
	}
	
	
	//遗失操作
	private void loseadmin(JPanel panel){
		panel.setLayout(new BorderLayout(10, 5));
		//读者信息上部信息
		JPanel panelzs=new JPanel();
		
		panelzs.setLayout(new BorderLayout(10, 2));
		
		Border bzs = new TitledBorder(new LineBorder(Color.black, 1), "读者确认遗失操作");
		panelzs.setBorder(bzs);
		//文字显示
		JPanel panelwz=new JPanel();
//		panelwz.setBorder(new LineBorder(Color.GREEN, 2));
		
		labq = new JLabel("请读者确认此书遗失:");
		panelwz.add(labq);
		butqr = new JButton("确认");
		butqr.addActionListener(new ActionListener() {
			
		

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(tushubh.equals(null)){
					JOptionPane.showMessageDialog(null,"请选择一行");
					return;
				}
					

					
				//弹出付费框
				new loseysjf(lose.this);
				
				
				if(loseysjf.one==true){
					LoginServicer sa=new  LoginServicerlmpl();
//				Integer sda=	Integer.parseInt(studxc);
					int rq=sa.wnUpdateInfotxys(tushubh,Integer.parseInt(studxc));
					if(rq<1){
						JOptionPane.showMessageDialog(null,"失败");
						return;
					}
			
					}
			
					
					panelta.removeAll();
					 table1 = refisteror.losebookone();
				        table1.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								// TODO Auto-generated method stub
								  int s = table1.getSelectedRow();
								  tushubh=table1.getValueAt(s , 0).toString();
								  studxc=table1.getValueAt(s , 5).toString();
								  txdzbh.setText(table1.getValueAt(s,5).toString());
									txtsbh.setText(table1.getValueAt(s , 0).toString());
									txtsmc.setText(table1.getValueAt(s , 1).toString());
									txtdzxm.setText(table1.getValueAt(s , 7).toString());
									txtcbs.setText(table1.getValueAt(s , 2).toString());
									txtlx.setText(table1.getValueAt(s , 3).toString());
									txtrq.setText(table1.getValueAt(s , 6).toString());
									txtsfz.setText(table1.getValueAt(s , 8).toString());
							
							
							
							}
						});
				    	
				        panelta.add(table1.getTableHeader(), BorderLayout.NORTH);
				        // 把 表格内容 添加到容器中
				        panelta.add(table1, BorderLayout.CENTER);
				        panelta.revalidate();
					
					
					
			}
		});
		panelwz.add(butqr);
		

		JLabel labhq=new JLabel("(选中表格中的图书，点击确认即可....):");
		panelwz.add(labhq);
		panelzs.add(panelwz,BorderLayout.NORTH);
		//下方表格
		panelta=new JPanel();
		panelta.setLayout(new BorderLayout(10, 2));
		
	        // 创建一个表格，指定 所有行数据 和 表头
	        JTable table = refisteror.losebookone();
	        
	        table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					  int s = table.getSelectedRow();
					  if(s==-1){
						  JOptionPane.showMessageDialog(null, "请选中一行");
						  return;
					  }
					  tushubh=table.getValueAt(s , 0).toString();
					  studxc=table.getValueAt(s , 5).toString();
						String sad=table.getValueAt(s,4).toString();
						key =new Double(sad);
						//"图书编码", "图书名称", "出版社", "类别","价格","读者编号","归还日期","读者姓名","身份证","电话","备注","地址"
						dz = table.getValueAt(s,7).toString();
						bm = table.getValueAt(s,0).toString();
						mc = table.getValueAt(s,1).toString();
						jg = table.getValueAt(s,4).toString();
						txdzbh.setText(table.getValueAt(s,5).toString());
						txtsbh.setText(table.getValueAt(s , 0).toString());
						txtsmc.setText(table.getValueAt(s , 1).toString());
						txtdzxm.setText(table.getValueAt(s , 7).toString());
						txtcbs.setText(table.getValueAt(s , 2).toString());
						txtlx.setText(table.getValueAt(s , 3).toString());
						txtrq.setText(table.getValueAt(s , 6).toString());
						txtsfz.setText(table.getValueAt(s , 8).toString());
				
				
				
				
				
				
				}

			});
	        panelta.add(table.getTableHeader(), BorderLayout.NORTH);
	        // 把 表格内容 添加到容器中
	        panelta.add(table, BorderLayout.CENTER);
	        panelzs.add(panelta,BorderLayout.CENTER);
			panel.add(panelzs);
		
		
		panelxd = new JPanel();
		Border bdz = new TitledBorder(new LineBorder(Color.black, 1), "请输入完整图书信息");
		panelxd.setBorder(bdz);
		panelxd.setLayout(new GridLayout(4,4,0,50));
		
		JLabel ladduxm=new JLabel("读者编号");
		panelxd.add(ladduxm);
		txdzbh = new JTextField("");
		txdzbh.setEditable(false);
		panelxd.add(txdzbh);
		
		JLabel latsbm=new JLabel("\u56FE\u4E66\u7F16\u53F7");
		panelxd.add(latsbm);
		txtsbh = new JTextField("");
		txtsbh.setEditable(false);
		panelxd.add(txtsbh);
		
		JLabel latsmc=new JLabel("图书名称");
		panelxd.add(latsmc);
		txtsmc = new JTextField("");
		txtsmc.setEditable(false);
		panelxd.add(txtsmc);

		JLabel ladzxm=new JLabel("读者姓名");
		panelxd.add(ladzxm);
		txtdzxm = new JTextField("");
		txtdzxm.setEditable(false);
		panelxd.add(txtdzxm);
		
		JLabel ladcbs=new JLabel("出版社");
		panelxd.add(ladcbs);
		txtcbs = new JTextField("");
		txtcbs.setEditable(false);
		panelxd.add(txtcbs);
		
		JLabel ladlx=new JLabel("图书类型");
		panelxd.add(ladlx);
		txtlx = new JTextField("");
		txtlx.setEditable(false);
		panelxd.add(txtlx);
		
		JLabel ladrq=new JLabel("应还日期");
		panelxd.add(ladrq);
		txtrq = new JTextField("");
		txtrq.setEditable(false);
		panelxd.add(txtrq);
		
		JLabel ladsfz=new JLabel("读者身份证");
		panelxd.add(ladsfz);
		txtsfz = new JTextField("");
		txtsfz.setEditable(false);
		panelxd.add(txtsfz);
		
		
		panel.add(panelxd,BorderLayout.SOUTH);
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		lose l=new lose();

		ReaderDate s=new ReaderDate();
	}

}
