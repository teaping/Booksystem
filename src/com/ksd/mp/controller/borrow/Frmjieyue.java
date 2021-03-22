package com.ksd.mp.controller.borrow;

//图书借阅
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.ksd.mp.interior.Frmjie;
import com.ksd.mp.interior.refisteror;
import com.ksd.mp.servicer.FrmjieyueServicer;
import com.ksd.mp.servicer.registerQueryServicer;
import com.ksd.mp.servicer.Impl.Frmjieyuelmpl;
import com.ksd.mp.servicer.Impl.registerQuerylmp;
import com.ksd.mp.util.DateChooserJButton;

import javax.swing.BoxLayout;

public class Frmjieyue extends JFrame {
	private JPanel panelj;
	String shum = null;// 书名
	String shuzz = null;// 作者
	String snumb=null;//编号
	private JTextField dzbh;
	JPanel xiabujieyue=null;
	JTable table = null;
	JPanel panelta=null;
	JButton txrq=null;

	public Frmjieyue() {
		super("图书借阅");
		this.setSize(1000, 800);
		this.setLocationRelativeTo(null); // 使窗体居中显示
		Container con = this.getContentPane();
		con.setLayout(new BorderLayout(10, 5));
		JPanel panelz = new JPanel();
		panelz.setBorder(new LineBorder(Color.BLACK, 0));
		// 调用图书类别
		loseInfo(panelz);
		con.add(panelz, BorderLayout.WEST);

		panelj = new JPanel();
		// 调用选择图书、借阅图书
		loseadmin(panelj);

		this.setResizable(false);
		panelj.setBorder(new LineBorder(Color.red, 0));

		con.add(panelj, BorderLayout.CENTER);

		this.setVisible(true);
		// 关闭方式
		// 关闭方式
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	// 图书类别
	private void loseInfo(JPanel panel) {
		panel.setLayout(new BorderLayout(10, 5));
		// 图书类别
		JPanel panelzs = new JPanel();

		Border bzs = new TitledBorder(new LineBorder(Color.black, 1), "图书类别");
		panelzs.setBorder(bzs);
		// 树控件
		// 创建根节点
		DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("所有类别");

		// 创建二级节点

		List<String> list = null;
		registerQueryServicer rs = new registerQuerylmp();
		list = rs.booksortOne();
		for (int i = 0; i < list.size(); i++) {
			// 把二级节点作为子节点添加到根节点
			rootNode.add(new DefaultMutableTreeNode(list.get(i)));
		}

		// 创建三级节点

		// 使用根节点创建树组件
		JTree tree = new JTree(rootNode);

		// 设置树显示根节点句柄
		tree.setShowsRootHandles(true);

		// 设置树节点可编辑
		tree.setEditable(false);
		
		
		 // 设置节点选中监听器
        tree.addTreeSelectionListener(new TreeSelectionListener() {
        	String wen=null;
            @Override
            public void valueChanged(TreeSelectionEvent e) {
            	
            	panelta.removeAll();
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				String jd=e.getPath().toString();
            	if(jd.equals("[所有类别]")){
            		panelta.removeAll();
            		panelta.setLayout(new BorderLayout(10, 2));
            		// 创建一个表格，指定 所有行数据 和 表头
            		table = refisteror.retable(null);
            		table.addMouseListener(new MouseAdapter() {
            			// 鼠标操作事件
            			@Override
            			public void mouseClicked(MouseEvent e) {
            				// TODO Auto-generated method stub
            				int s = table.getSelectedRow();
            				shum = table.getValueAt(s, 1).toString();
            				shuzz = table.getValueAt(s, 5).toString();

            				 snumb=table.getValueAt(s, 0).toString();
            				// System.out.printf("%s",as);

            			}

            		});
            		panelj.setLayout(null);

            		JScrollPane jsp = new JScrollPane(table);// 给表格加上滚动杠
            		// panelta.add(table.getTableHeader(), BorderLayout.NORTH);
            		// 把 表格内容 添加到容器中
            		panelta.add(jsp, BorderLayout.CENTER);
					panelta.revalidate();
					
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
    				
    				panelta.removeAll();
    				
    				panelta.setLayout(new BorderLayout(10, 2));
    				// 创建一个表格，指定 所有行数据 和 表头
    				table = refisteror.retable(wen);
    				table.addMouseListener(new MouseAdapter() {
    					// 鼠标操作事件
    					@Override
    					public void mouseClicked(MouseEvent e) {
    						// TODO Auto-generated method stub
    						int s = table.getSelectedRow();
    						shum = table.getValueAt(s, 1).toString();
    						shuzz = table.getValueAt(s, 5).toString();

    						 snumb=table.getValueAt(s, 0).toString();
    						// System.out.printf("%s",as);

    					}

    				});
    				panelj.setLayout(null);

    				JScrollPane jsp = new JScrollPane(table);// 给表格加上滚动杠
    				// panelta.add(table.getTableHeader(), BorderLayout.NORTH);
    				// 把 表格内容 添加到容器中
    				panelta.add(jsp, BorderLayout.CENTER);
    				
    				panelta.revalidate();
            		
            	}
        		
        	jd="";
            }
        });
		panelzs.setLayout(null);
		// 创建滚动面板，包裹树（因为树节点展开后可能需要很大的空间来显示，所以需要用一个滚动面板来包裹）
		JScrollPane scrollPane = new JScrollPane(tree);
		scrollPane.setBounds(10, 22, 180, 554);
		// scrollPane.setSize(500, 500);

		// 添加滚动面板到那内容面板
		panelzs.add(scrollPane);

		// 温馨提示
		JPanel panelzx = new JPanel();
		Border b = new TitledBorder(new LineBorder(Color.black, 1), "温馨提示");
		panelzx.setBorder(b);
		// 提示图片
//		Icon icon = new ImageIcon("image/label.png");
		String disText = "<html><HTML><body style=color:red>本馆规定结束期限为2个月，<br>" + "续借一个月，最多可借8本<br>" + "图书，不准重复借相同的书<br>"
				+ "如遇到系统问题<br>" + "请联系: <br>115116206615 </body></html>";

//		icon,
		// 文字提示 方向样式
		JLabel labts = new JLabel(disText,  SwingConstants.LEFT);
		labts.setFont(new Font("宋体", Font.ITALIC, 16));
		labts.setVerticalAlignment(JLabel.TOP);
		labts.setSize(20, 250);
		panelzx.setPreferredSize(new Dimension(200, 180));
		panelzx.add(labts);
		panel.add(panelzs, BorderLayout.CENTER);
		panel.add(panelzx, BorderLayout.SOUTH);

	}

	// 选择图书
	private void loseadmin(JPanel panel) {
		// 选择图书上部信息
		JPanel panelzs = new JPanel();
		panelzs.setBounds(0, 0, 730, 412);
		panelzs.setLayout(new BorderLayout(10, 2));

		Border bzs = new TitledBorder(new LineBorder(Color.black, 1), "选择图书");
		panelzs.setBorder(bzs);
		// 文字显示
		JPanel panelwz = new JPanel();
		panelwz.setBorder(new LineBorder(Color.GREEN, 0));
		panelwz.setLayout(new BoxLayout(panelwz, BoxLayout.X_AXIS));

		JLabel labq = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		panelwz.add(labq);
		JTextField tsmc = new JTextField();
		panelwz.add(tsmc);

		JLabel label_2 = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");
		panelwz.add(label_2);
		JTextField tszz = new JTextField();
		panelwz.add(tszz);

		// 下方表格
		panelta = new JPanel();
		panelta.setLayout(new BorderLayout(10, 2));
		// 创建一个表格，指定 所有行数据 和 表头
		table = refisteror.retable(null);
		table.addMouseListener(new MouseAdapter() {
			// 鼠标操作事件
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int s = table.getSelectedRow();
				shum = table.getValueAt(s, 1).toString();
				shuzz = table.getValueAt(s, 5).toString();

				 snumb=table.getValueAt(s, 0).toString();
				// System.out.printf("%s",as);

			}

		});
		panelj.setLayout(null);

		JScrollPane jsp = new JScrollPane(table);// 给表格加上滚动杠
		// panelta.add(table.getTableHeader(), BorderLayout.NORTH);
		// 把 表格内容 添加到容器中
		panelta.add(jsp, BorderLayout.CENTER);
		panelzs.add(panelta, BorderLayout.CENTER);
		panel.add(panelzs);

		// 查询
		JButton cx = new JButton("查询");
		cx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 根据图书名称和作者查询
				panelta.removeAll();

				panelta.setLayout(new BorderLayout(10, 2));
				// 创建一个表格，指定 所有行数据 和 表头
				table = Frmjie.Frmtable(tsmc.getText(), tszz.getText());
				table.addMouseListener(new MouseAdapter() {
					// 鼠标操作事件
					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						int s = table.getSelectedRow();
						shum = table.getValueAt(s, 1).toString();
						shuzz = table.getValueAt(s, 5).toString();
						// System.out.printf("%s",as);

					 snumb=table.getValueAt(s, 0).toString();
					}

				});
				panelj.setLayout(null);

				JScrollPane jsp = new JScrollPane(table);// 给表格加上滚动杠
				// panelta.add(table.getTableHeader(), BorderLayout.NORTH);
				// 把 表格内容 添加到容器中
				panelta.add(jsp, BorderLayout.CENTER);

				panelta.revalidate();

			}
		});
		panelwz.add(cx);
		panelzs.add(panelwz, BorderLayout.NORTH);

		// 借阅管理
		JPanel panelxd = new JPanel();
		panelxd.setBounds(0, 422, 730, 349);
		Border bdz = new TitledBorder(new LineBorder(Color.black, 1), "借阅信息");
		panelxd.setBorder(bdz);
		panel.add(panelxd);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();

		xiabujieyue = new JPanel();
		xiabujieyue.setBounds(5, 53, 720, 291);
		xiabujieyue.setLayout(new BorderLayout(10, 2));

		// 创建一个表格，指定 所有行数据 和 表头
		JTable bt = Frmjie.Frmjiyue();
		bt.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			}
		});
		panelj.setLayout(null);
		panelxd.setLayout(null);
		xiabujieyue.add(bt.getTableHeader(), BorderLayout.NORTH);
		// 把 表格内容 添加到容器中
		xiabujieyue.add(bt, BorderLayout.CENTER);
		panelxd.add(xiabujieyue);
		panel.add(panelxd);

		JLabel label = new JLabel("\u8BFB\u8005\u7F16\u53F7\uFF1A");
		label.setBounds(22, 28, 82, 15);
		panelxd.add(label);

		dzbh = new JTextField();
		dzbh.setColumns(10);
		dzbh.setBounds(99, 25, 107, 21);
		panelxd.add(dzbh);

		JLabel label_1 = new JLabel("\u5F52\u8FD8\u65E5\u671F\uFF1A");
		label_1.setBounds(233, 28, 82, 15);
		panelxd.add(label_1);

		// 日期控件
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		String sone = df.format(new Date());
		txrq = new JButton();
		DateChooserJButton dateChooserJButton = new DateChooserJButton(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"), sone);
	
		txrq.add(dateChooserJButton,java.awt.BorderLayout.CENTER);
		txrq.setBounds(300, 22, 159, 25);
		panelxd.add(txrq);
		
		JButton btnjy = new JButton("\u501F\u9605");
		btnjy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 根据读者编号查询 3
				if (dzbh.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "读者编号不允许为空！！！");
					return;
				}
				Date dae=dateChooserJButton.getDate();
				Date dqrq=new Date();
				if(dae.before(dqrq)){
					JOptionPane.showMessageDialog(null, "归还数据集不能在借阅之前!");
					return;
				}
//				df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
				String eq = df.format(dae);

				 int n=JOptionPane.showConfirmDialog(null,"你确认要借书名为:"+shum+"作者为:"+shuzz+"的图书吗？","借阅",
				 JOptionPane.YES_NO_OPTION);
				 if(n==0){
				 FrmjieyueServicer sr=new Frmjieyuelmpl();
				 int s=sr.jieyues(dzbh.getText(),snumb, eq);
				 if(s<1){
				 JOptionPane.showMessageDialog(null, "借阅失败！");
				 return;
				 }else{
					int sd=sr.deltesa(shum);
					
					panelta.removeAll();
            		panelta.setLayout(new BorderLayout(10, 2));
            		// 创建一个表格，指定 所有行数据 和 表头
            		table = refisteror.retable(null);
            		table.addMouseListener(new MouseAdapter() {
            			// 鼠标操作事件
            			@Override
            			public void mouseClicked(MouseEvent e) {
            				// TODO Auto-generated method stub
            				int s = table.getSelectedRow();
            				shum = table.getValueAt(s, 1).toString();
            				shuzz = table.getValueAt(s, 5).toString();

            				 snumb=table.getValueAt(s, 0).toString();
            				// System.out.printf("%s",as);

            			}

            		});
            		panelj.setLayout(null);

            		JScrollPane jsp = new JScrollPane(table);// 给表格加上滚动杠
            		// panelta.add(table.getTableHeader(), BorderLayout.NORTH);
            		// 把 表格内容 添加到容器中
            		panelta.add(jsp, BorderLayout.CENTER);
					panelta.revalidate();
					
					
					 
					 
				 xiabujieyue.removeAll();
				 xiabujieyue.setBounds(5, 53, 720, 291);
				 xiabujieyue.setLayout(new BorderLayout(10,2));
				
				 // 创建一个表格，指定 所有行数据 和 表头
				 JTable bt = Frmjie.Frmjiyue();
				 panelj.setLayout(null);
				 panelxd.setLayout(null);
				 xiabujieyue.add(bt.getTableHeader(), BorderLayout.NORTH);
				 // 把 表格内容 添加到容器中
				 xiabujieyue.add(bt, BorderLayout.CENTER);
				 xiabujieyue.revalidate();
				 }
				 }

			}
		});
		btnjy.setBounds(553, 24, 93, 23);
		panelxd.add(btnjy);

//		JButton btncj = new JButton("清空");
//		btncj.setBounds(600, 24, 93, 23);
//		panelxd.add(btncj);

	}

	public static void main(String[] args) {
		new Frmjieyue();
	}

	class User {
		private String name;

		public User(String n) {
			name = n;
		}

		// 重点在toString，节点的显示文本就是toString
		public String toString() {
			return name;
		}

	}
}
