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

//ͼ�������
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
		super("ͼ���ѯ������");
		this.setSize(1000, 800);
		this.setLocationRelativeTo(null);
		Container con=this.getContentPane();
		con.setLayout(new BorderLayout(10, 5));
		//�ϲ�����
		JPanel panel=new JPanel();
		panel.setBorder(new LineBorder(Color.BLACK, 2));
		
		//�в�����
		JPanel panelz=new JPanel();
//		panelz.setBorder(new LineBorder(Color.red, 2));
		
		//�²�
		JPanel panelxb=new JPanel();

//		panelxb.setBorder(new LineBorder(Color.red, 2));
		//��������
		hint(panel);
		bookupde(panelz);
		detailed(panelxb);
		
		
		
		con.add(panel,BorderLayout.NORTH);
		con.add(panelz,BorderLayout.CENTER);
		con.add(panelxb,BorderLayout.SOUTH);
	
		this.setVisible(true);
		// �رշ�ʽ
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
	//�²���������
	private void detailed(JPanel panelxb) {
		panelxb.setLayout(new BorderLayout(10,2));
		// TODO Auto-generated method stub
		JPanel ts = new JPanel();
		ts.setLayout(new GridLayout(3,3,10,10));
		// ����
		Border b = new TitledBorder(new LineBorder(Color.black, 1), "ͼ����ϸ��Ϣ");
		ts.setBorder(b);
		
		JLabel labbh=new JLabel("ͼ����");
		ts.add(labbh);
		txbh = new JTextField();
		ts.add(txbh);
		
		JLabel labmc=new JLabel("ͼ������");
		ts.add(labmc);
		txmc = new JTextField();
		ts.add(txmc);
		
		JLabel labxzsl=new JLabel("�ִ�����");
		ts.add(labxzsl);
		txxzsl = new JTextField();
		ts.add(txxzsl);
		
		JLabel lablb=new JLabel("ͼ�����");
		ts.add(lablb);
		txlb = new JTextField();
		ts.add(txlb);
		
		JLabel labcb=new JLabel("������");
		ts.add(labcb);
		txcb = new JTextField();
		ts.add(txcb);
		
		
		JLabel labccsl=new JLabel("��������");
		ts.add(labccsl);
		txccsl = new JTextField();
		ts.add(txccsl);
		
		JLabel labzz=new JLabel("ͼ������");
		ts.add(labzz);
		txzz = new JTextField();
		ts.add(txzz);

		JLabel labjg=new JLabel("ͼ��۸�");
		ts.add(labjg);
		txjg = new JTextField();
		ts.add(txjg);
		
		JLabel labrq=new JLabel("�������");
		ts.add(labrq);
		txrq = new JTextField();
		ts.add(txrq);
		panelxb.add(ts);
	
	}
	//�в�
	private void bookupde(JPanel panelz) {
		// TODO Auto-generated method stub
		panelz.setLayout(new BorderLayout(10,0));
		//ͼ�����
		JPanel panelzjz=new JPanel();
//		Border cts = new TitledBorder(new LineBorder(Color.black, 1), "����������ͼ����Ϣ");

		Border cts = new TitledBorder(new LineBorder(Color.black, 1), "ͼ�����");
		panelzjz.setBorder(cts);
		panzjj = new JPanel();
		 panzjj.setLayout(new BorderLayout(10,2));
		//���ؼ�
	    // �������ڵ�
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("�������");

        List<String> list = null;
		registerQueryServicer rs = new registerQuerylmp();
		list = rs.booksortOne();
		for (int i = 0; i < list.size(); i++) {
			// �Ѷ����ڵ���Ϊ�ӽڵ���ӵ����ڵ�
			rootNode.add(new DefaultMutableTreeNode(list.get(i)));
		}
        tree = new JTree(rootNode);

        // ��������ʾ���ڵ���
        tree.setShowsRootHandles(true);

        // �������ڵ�ɱ༭
        tree.setEditable(false);

        // ���ýڵ�ѡ�м�����
        tree.addTreeSelectionListener(new TreeSelectionListener() {
        	String wen=null;
            @Override
            public void valueChanged(TreeSelectionEvent e) {
            	
            	
            	panzjj.removeAll();
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				String jd=e.getPath().toString();
            	if(jd.equals("[�������]")){
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
    					JOptionPane.showMessageDialog(null, "��ѡ�����");
    					return;
    				}
    				
    					panzjj.removeAll();
    					refisteror.sobookoneone(panzjj,wen);
    					panzjj.revalidate();
            		
            	}
        		
        	jd="";
            }
        });

        // ����������壬����������Ϊ���ڵ�չ���������Ҫ�ܴ�Ŀռ�����ʾ��������Ҫ��һ�����������������
        JScrollPane scrollPane = new JScrollPane(tree);

        // ��ӹ�����嵽���������
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
	        // �� ������� ��ӵ�������
	        panzjj.add(table,BorderLayout.CENTER);
		
		
		panelzjz.setBorder(new LineBorder(Color.BLACK, 2));
		panzjj.setBorder(new LineBorder(Color.BLACK, 2));
		
		
		
		panelz.add(panelzjz,BorderLayout.WEST);
		panelz.add(panzjj,BorderLayout.CENTER);
	}
	//�ϲ���Ϣ
	private void hint(JPanel panle) {
		// TODO Auto-generated method stub
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
		labts.setSize(20, 200);
		ts.setPreferredSize(new Dimension(250, 150));
		ts.add(labts);
		panle.add(ts, BorderLayout.WEST);
		// �߼���ѯͼ����Ϣ
		JPanel tsz = new JPanel();
		Border cts = new TitledBorder(new LineBorder(Color.black, 1), "����������ͼ����Ϣ");
		tsz.setBorder(cts);
		// ����ͼ���ѯ��Ϣ
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
	//��ť
	private void bookmessag(JPanel panelzy) {
		// TODO Auto-generated method stub
		panelzy.setLayout(new BorderLayout(10, 5));
		
		JButton btn=new JButton("��ѯ");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BaseDao.getConn();
				LoginServicer ls=new LoginServicerlmpl();

				BookInfo  bkf=ls.psSelStudentBy(txtmc.getText(),txtbh.getText(),cmb.getSelectedItem().toString());
				//�ж��Ƿ���ֵ
				
				
//				if(txtmc.getText().equals("")){
//					JOptionPane.showMessageDialog(null, "�����������ͳ�����");
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
		        // �� ������� ��ӵ�������
		        panzjj.add(table,BorderLayout.CENTER);
			
			
			panzjj.setBorder(new LineBorder(Color.BLACK, 2));
			
			panzjj.revalidate();
			
			
			
			}
		});
		panelzy.add(btn);
		
	}
	//��ѯ�ؼ�
	private void bookmessage(JPanel panelzj) {
		// TODO Auto-generated method stub
		panelzj.setLayout(new GridLayout(2,4,0,20));
		JLabel labrq=new JLabel("ѡ������");
		panelzj.add(labrq);
		
		txrq2 = new JButton();
		txrq2.add(new DateChooserJButton(new SimpleDateFormat("yyyy/MM/dd HH"),"2012/12/12 22"), java.awt.BorderLayout.CENTER);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		txrq2.setSize(200, 200);
		panelzj.add(txrq2);
		
		JLabel labbh=new JLabel("ͼ����");
		panelzj.add(labbh);
		txtbh = new JTextField();
		panelzj.add(txtbh);
		
		JLabel labcbs=new JLabel("������");
		panelzj.add(labcbs);
		cmb = new JComboBox(); // ����JComboBox
		cmb.addItem("--��ѡ��--"); // �������б������һ��
		cmb.addItem("������ѧ������");
		cmb.addItem("�������������");
		cmb.addItem("�������������");
		cmb.addItem("���ϴ�ѧ������");
		cmb.addItem("�����ѧ������");
		cmb.addItem("�Ϻ���ѧ������");
		panelzj.add(cmb);
		
		JLabel labmc=new JLabel("ͼ������");
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

