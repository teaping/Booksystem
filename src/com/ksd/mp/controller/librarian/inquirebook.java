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

import javax.imageio.spi.RegisterableService;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

//图书管理器
public class inquirebook extends JFrame{
	private DefaultMutableTreeNode gdNode;
	private JTree tree;
	private DefaultMutableTreeNode fjNode;
	private DefaultMutableTreeNode shNode;
	private DefaultMutableTreeNode twNode;
	private DefaultMutableTreeNode gzNode;
	private DefaultMutableTreeNode szNode;
	private DefaultMutableTreeNode fzNode;
	private registerQueryServicer r;
	private JTable table;
	private JPanel panzjj; 
	private List<BookInfo> s;
	private Object[] columnNames;
	private JTextField txrq;
	private JTextField txjg;
	private JTextField txzz;
	private JTextField txccsl;
	private JTextField txcb;
	private JTextField txlb;
	private JTextField txxzsl;
	private JTextField txmc;
	private JTextField txbh;
	private JTextField txtmc;
	private JComboBox cmb;
	private JTextField txtbh;
	private JButton txrq2;
	public inquirebook() {
		// TODO Auto-generated constructor stub
		super("图书查询管理器");
		this.setSize(1000, 800);
		this.setLocationRelativeTo(null);
		Container con=this.getContentPane();
		con.setLayout(new BorderLayout(10, 5));
		//上部布局
		JPanel panel=new JPanel();
		panel.setBorder(new LineBorder(Color.BLACK, 2));
		
		//中部布局
		JPanel panelz=new JPanel();
//		panelz.setBorder(new LineBorder(Color.red, 2));
		
		//下部
		JPanel panelxb=new JPanel();

//		panelxb.setBorder(new LineBorder(Color.red, 2));
		//方法调用
		hint(panel);
		bookupde(panelz);
		detailed(panelxb);
		
		
		
		con.add(panel,BorderLayout.NORTH);
		con.add(panelz,BorderLayout.CENTER);
		con.add(panelxb,BorderLayout.SOUTH);
	
		this.setVisible(true);
		// 关闭方式
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
	//下部方法调用
	private void detailed(JPanel panelxb) {
		panelxb.setLayout(new BorderLayout(10,2));
		// TODO Auto-generated method stub
		JPanel ts = new JPanel();
		ts.setLayout(new GridLayout(3,3,10,10));
		// 标题
		Border b = new TitledBorder(new LineBorder(Color.black, 1), "图书详细信息");
		ts.setBorder(b);
		
		JLabel labbh=new JLabel("图书编号");
		ts.add(labbh);
		txbh = new JTextField();
		ts.add(txbh);
		
		JLabel labmc=new JLabel("图书名称");
		ts.add(labmc);
		txmc = new JTextField();
		ts.add(txmc);
		
		JLabel labxzsl=new JLabel("现存数量");
		ts.add(labxzsl);
		txxzsl = new JTextField();
		ts.add(txxzsl);
		
		JLabel lablb=new JLabel("图书类别");
		ts.add(lablb);
		txlb = new JTextField();
		ts.add(txlb);
		
		JLabel labcb=new JLabel("出版社");
		ts.add(labcb);
		txcb = new JTextField();
		ts.add(txcb);
		
		
		JLabel labccsl=new JLabel("储存数量");
		ts.add(labccsl);
		txccsl = new JTextField();
		ts.add(txccsl);
		
		JLabel labzz=new JLabel("图书作者");
		ts.add(labzz);
		txzz = new JTextField();
		ts.add(txzz);

		JLabel labjg=new JLabel("图书价格");
		ts.add(labjg);
		txjg = new JTextField();
		ts.add(txjg);
		
		JLabel labrq=new JLabel("入馆日期");
		ts.add(labrq);
		txrq = new JTextField();
		ts.add(txrq);
		panelxb.add(ts);
	
	}
	//中部
	private void bookupde(JPanel panelz) {
		// TODO Auto-generated method stub
		panelz.setLayout(new BorderLayout(10,0));
		//图书类别
		JPanel panelzjz=new JPanel();
//		Border cts = new TitledBorder(new LineBorder(Color.black, 1), "请输入完整图书信息");

		Border cts = new TitledBorder(new LineBorder(Color.black, 1), "图书类别");
		panelzjz.setBorder(cts);
		panzjj = new JPanel();
		 panzjj.setLayout(new BorderLayout(10,2));
		//树控件
	    // 创建根节点
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("所有类别");

        List<String> list = null;
		registerQueryServicer rs = new registerQuerylmp();
		list = rs.booksortOne();
		for (int i = 0; i < list.size(); i++) {
			// 把二级节点作为子节点添加到根节点
			rootNode.add(new DefaultMutableTreeNode(list.get(i)));
		}
        tree = new JTree(rootNode);

        // 设置树显示根节点句柄
        tree.setShowsRootHandles(true);

        // 设置树节点可编辑
        tree.setEditable(false);

        // 设置节点选中监听器
        tree.addTreeSelectionListener(new TreeSelectionListener() {
        	String wen=null;
            @Override
            public void valueChanged(TreeSelectionEvent e) {
            	
            	
            	panzjj.removeAll();
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				String jd=e.getPath().toString();
            	if(jd.equals("[所有类别]")){
            		panzjj.removeAll();
					refisteror.sobookoneone(panzjj);
					panzjj.revalidate();
					
            	}else{
            		if (node == null){
    					return;
    				}
    				Object object = node.getUserObject();
    				if (node.isLeaf()) {
    					String user = (String) object;
    					wen = user.toString();
    				} else if (wen == null) {
    					JOptionPane.showMessageDialog(null, "请选择类别");
    					return;
    				}
    				
    					panzjj.removeAll();
    					refisteror.sobookoneone(panzjj,wen);
    					panzjj.revalidate();
            		
            	}
        		
        	jd="";
            }
        });

        // 创建滚动面板，包裹树（因为树节点展开后可能需要很大的空间来显示，所以需要用一个滚动面板来包裹）
        JScrollPane scrollPane = new JScrollPane(tree);

        // 添加滚动面板到那内容面板
        panelzjz.add(scrollPane);
        
		
	        table = refisteror.retable(null); 
	        table.addMouseListener(new MouseAdapter()  {
		
				@Override
				public void mouseClicked(MouseEvent e) {

					int s = table.getSelectedRow();
					String sadq = table.getValueAt(s, 1).toString();
					BookInfo bkf=refisteror.Uptableoneqwe(sadq);
					
					
					// TODO Auto-generated method stub
					txzz.setText(bkf.getBookauthor());
					txlb.setText(bkf.getBooksort());
					txmc.setText(bkf.getBookname());
					txbh.setText(bkf.getBookcode());
					txcb.setText(bkf.getBookpublish());
					txccsl.setText(new Integer(bkf.getBookaddnumber()).toString());
					txxzsl.setText(new Integer(bkf.getBookaddnumber()).toString());
					txjg.setText(bkf.getBookprice());
					txrq.setText(bkf.getBooktime());
					
				}
			});
	        panzjj.add(table.getTableHeader(), BorderLayout.NORTH);
	        // 把 表格内容 添加到容器中
	        panzjj.add(table,BorderLayout.CENTER);
		
		
		panelzjz.setBorder(new LineBorder(Color.BLACK, 2));
		panzjj.setBorder(new LineBorder(Color.BLACK, 2));
		
		
		
		panelz.add(panelzjz,BorderLayout.WEST);
		panelz.add(panzjj,BorderLayout.CENTER);
	}
	//上部消息
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
		labts.setSize(20, 200);
		ts.setPreferredSize(new Dimension(250, 150));
		ts.add(labts);
		panle.add(ts, BorderLayout.WEST);
		// 高级查询图书信息
		JPanel tsz = new JPanel();
		Border cts = new TitledBorder(new LineBorder(Color.black, 1), "请输入完整图书信息");
		tsz.setBorder(cts);
		// 调用图书查询信息
		JPanel panelzj=new JPanel();
//		panelzj.setBorder(new LineBorder(Color.GREEN, 2));

		JPanel panelzy=new JPanel();
//		panelzy.setBorder(new LineBorder(Color.BLACK, 2));
		
		bookmessage(panelzj);
		bookmessag(panelzy);

		tsz.add(panelzj,BorderLayout.CENTER);
		
		tsz.add(panelzy,BorderLayout.EAST);

		panle.add(tsz, BorderLayout.CENTER);
	}
	//按钮
	private void bookmessag(JPanel panelzy) {
		// TODO Auto-generated method stub
		panelzy.setLayout(new BorderLayout(10, 5));
		
		JButton btn=new JButton("查询");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BaseDao.getConn();
				LoginServicer ls=new LoginServicerlmpl();

				BookInfo  bkf=ls.psSelStudentBy(txtmc.getText(),txtbh.getText(),cmb.getSelectedItem().toString());
				//判断是否有值
				
				
//				if(txtmc.getText().equals("")){
//					JOptionPane.showMessageDialog(null, "请输入书名和出版社");
//				}
				
				//ls.psSelStudentBySid(bk.getBookcode(),bk.getBookname(), bk.getBookpublish(), bk.getBookaddnumber(), bk.getBooksort(), bk.getBookauthor(), bk.getBooktime());
				panzjj.removeAll();

//				String bookname,String booktime,String bookcode,String bookpublish
		        table = refisteror.Uptabletow(txtmc.getText(),txtbh.getText(),cmb.getSelectedItem().toString());
		       table.addMouseListener(new MouseAdapter()  {
		   		
					@Override
					public void mouseClicked(MouseEvent e) {

						int s = table.getSelectedRow();
						String sadq = table.getValueAt(s, 1).toString();
						BookInfo bkf=refisteror.Uptableoneqwe(sadq);
						
						
						// TODO Auto-generated method stub
						txzz.setText(bkf.getBookauthor());
						txlb.setText(bkf.getBooksort());
						txmc.setText(bkf.getBookname());
						txbh.setText(bkf.getBookcode());
						txcb.setText(bkf.getBookpublish());
						txccsl.setText(new Integer(bkf.getBookaddnumber()).toString());
						txxzsl.setText(new Integer(bkf.getBookaddnumber()).toString());
						txjg.setText(bkf.getBookprice());
						txrq.setText(bkf.getBooktime());
						
					}
				});
		        panzjj.add(table.getTableHeader(), BorderLayout.NORTH);
		        // 把 表格内容 添加到容器中
		        panzjj.add(table,BorderLayout.CENTER);
			
			
			panzjj.setBorder(new LineBorder(Color.BLACK, 2));
			
			panzjj.revalidate();
			
			
			
			}
		});
		panelzy.add(btn);
		
	}
	//查询控件
	private void bookmessage(JPanel panelzj) {
		// TODO Auto-generated method stub
		panelzj.setLayout(new GridLayout(2,4,0,20));
		JLabel labrq=new JLabel("选择日期");
		panelzj.add(labrq);
		
		txrq2 = new JButton();
		txrq2.add(new DateChooserJButton(new SimpleDateFormat("yyyy/MM/dd HH"),"2012/12/12 22"), java.awt.BorderLayout.CENTER);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		txrq2.setSize(200, 200);
		panelzj.add(txrq2);
		
		JLabel labbh=new JLabel("图书编号");
		panelzj.add(labbh);
		txtbh = new JTextField();
		panelzj.add(txtbh);
		
		JLabel labcbs=new JLabel("出版社");
		panelzj.add(labcbs);
		cmb = new JComboBox(); // 创建JComboBox
		cmb.addItem("--请选择--"); // 向下拉列表中添加一项
		cmb.addItem("北京大学出版社");
		cmb.addItem("陕西人民出版社");
		cmb.addItem("当代世界出版社");
		cmb.addItem("湖南大学出版社");
		cmb.addItem("人民大学出版社");
		cmb.addItem("上海大学出版社");
		panelzj.add(cmb);
		
		JLabel labmc=new JLabel("图书名称");
		panelzj.add(labmc);
		txtmc = new JTextField();
		panelzj.add(txtmc);
		
	}
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		inquirebook q=new inquirebook();
//	}
	public BookInfo getLib(){
		BookInfo bkf=null;
		String bookcode=txbh.getText();
		String bookname=txmc.getText();
		String bookpublish=txcb.getText();
		int bookaddnumber=new Integer(txccsl.getText()) ;
		String booksort=txlb.getText();
		String bookauthor=txzz.getText();
		String bookprice=txjg.getText();
		String booktime=txrq.getText();
		bkf=new BookInfo(bookcode, bookname, bookpublish, bookaddnumber, booksort, bookauthor, bookprice, booktime);
		return bkf;
	}
}

