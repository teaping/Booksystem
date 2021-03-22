package com.ksd.mp.controller.borrow;

//ͼ�����
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
	String shum = null;// ����
	String shuzz = null;// ����
	String snumb=null;//���
	private JTextField dzbh;
	JPanel xiabujieyue=null;
	JTable table = null;
	JPanel panelta=null;
	JButton txrq=null;

	public Frmjieyue() {
		super("ͼ�����");
		this.setSize(1000, 800);
		this.setLocationRelativeTo(null); // ʹ���������ʾ
		Container con = this.getContentPane();
		con.setLayout(new BorderLayout(10, 5));
		JPanel panelz = new JPanel();
		panelz.setBorder(new LineBorder(Color.BLACK, 0));
		// ����ͼ�����
		loseInfo(panelz);
		con.add(panelz, BorderLayout.WEST);

		panelj = new JPanel();
		// ����ѡ��ͼ�顢����ͼ��
		loseadmin(panelj);

		this.setResizable(false);
		panelj.setBorder(new LineBorder(Color.red, 0));

		con.add(panelj, BorderLayout.CENTER);

		this.setVisible(true);
		// �رշ�ʽ
		// �رշ�ʽ
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	// ͼ�����
	private void loseInfo(JPanel panel) {
		panel.setLayout(new BorderLayout(10, 5));
		// ͼ�����
		JPanel panelzs = new JPanel();

		Border bzs = new TitledBorder(new LineBorder(Color.black, 1), "ͼ�����");
		panelzs.setBorder(bzs);
		// ���ؼ�
		// �������ڵ�
		DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("�������");

		// ���������ڵ�

		List<String> list = null;
		registerQueryServicer rs = new registerQuerylmp();
		list = rs.booksortOne();
		for (int i = 0; i < list.size(); i++) {
			// �Ѷ����ڵ���Ϊ�ӽڵ���ӵ����ڵ�
			rootNode.add(new DefaultMutableTreeNode(list.get(i)));
		}

		// ���������ڵ�

		// ʹ�ø��ڵ㴴�������
		JTree tree = new JTree(rootNode);

		// ��������ʾ���ڵ���
		tree.setShowsRootHandles(true);

		// �������ڵ�ɱ༭
		tree.setEditable(false);
		
		
		 // ���ýڵ�ѡ�м�����
        tree.addTreeSelectionListener(new TreeSelectionListener() {
        	String wen=null;
            @Override
            public void valueChanged(TreeSelectionEvent e) {
            	
            	panelta.removeAll();
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				String jd=e.getPath().toString();
            	if(jd.equals("[�������]")){
            		panelta.removeAll();
            		panelta.setLayout(new BorderLayout(10, 2));
            		// ����һ�����ָ�� ���������� �� ��ͷ
            		table = refisteror.retable(null);
            		table.addMouseListener(new MouseAdapter() {
            			// �������¼�
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

            		JScrollPane jsp = new JScrollPane(table);// �������Ϲ�����
            		// panelta.add(table.getTableHeader(), BorderLayout.NORTH);
            		// �� ������� ��ӵ�������
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
    					JOptionPane.showMessageDialog(null, "��ѡ�����");
    					return;
    				}
    				
    				panelta.removeAll();
    				
    				panelta.setLayout(new BorderLayout(10, 2));
    				// ����һ�����ָ�� ���������� �� ��ͷ
    				table = refisteror.retable(wen);
    				table.addMouseListener(new MouseAdapter() {
    					// �������¼�
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

    				JScrollPane jsp = new JScrollPane(table);// �������Ϲ�����
    				// panelta.add(table.getTableHeader(), BorderLayout.NORTH);
    				// �� ������� ��ӵ�������
    				panelta.add(jsp, BorderLayout.CENTER);
    				
    				panelta.revalidate();
            		
            	}
        		
        	jd="";
            }
        });
		panelzs.setLayout(null);
		// ����������壬����������Ϊ���ڵ�չ���������Ҫ�ܴ�Ŀռ�����ʾ��������Ҫ��һ�����������������
		JScrollPane scrollPane = new JScrollPane(tree);
		scrollPane.setBounds(10, 22, 180, 554);
		// scrollPane.setSize(500, 500);

		// ��ӹ�����嵽���������
		panelzs.add(scrollPane);

		// ��ܰ��ʾ
		JPanel panelzx = new JPanel();
		Border b = new TitledBorder(new LineBorder(Color.black, 1), "��ܰ��ʾ");
		panelzx.setBorder(b);
		// ��ʾͼƬ
//		Icon icon = new ImageIcon("image/label.png");
		String disText = "<html><HTML><body style=color:red>���ݹ涨��������Ϊ2���£�<br>" + "����һ���£����ɽ�8��<br>" + "ͼ�飬��׼�ظ�����ͬ����<br>"
				+ "������ϵͳ����<br>" + "����ϵ: <br>115116206615 </body></html>";

//		icon,
		// ������ʾ ������ʽ
		JLabel labts = new JLabel(disText,  SwingConstants.LEFT);
		labts.setFont(new Font("����", Font.ITALIC, 16));
		labts.setVerticalAlignment(JLabel.TOP);
		labts.setSize(20, 250);
		panelzx.setPreferredSize(new Dimension(200, 180));
		panelzx.add(labts);
		panel.add(panelzs, BorderLayout.CENTER);
		panel.add(panelzx, BorderLayout.SOUTH);

	}

	// ѡ��ͼ��
	private void loseadmin(JPanel panel) {
		// ѡ��ͼ���ϲ���Ϣ
		JPanel panelzs = new JPanel();
		panelzs.setBounds(0, 0, 730, 412);
		panelzs.setLayout(new BorderLayout(10, 2));

		Border bzs = new TitledBorder(new LineBorder(Color.black, 1), "ѡ��ͼ��");
		panelzs.setBorder(bzs);
		// ������ʾ
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

		// �·����
		panelta = new JPanel();
		panelta.setLayout(new BorderLayout(10, 2));
		// ����һ�����ָ�� ���������� �� ��ͷ
		table = refisteror.retable(null);
		table.addMouseListener(new MouseAdapter() {
			// �������¼�
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

		JScrollPane jsp = new JScrollPane(table);// �������Ϲ�����
		// panelta.add(table.getTableHeader(), BorderLayout.NORTH);
		// �� ������� ��ӵ�������
		panelta.add(jsp, BorderLayout.CENTER);
		panelzs.add(panelta, BorderLayout.CENTER);
		panel.add(panelzs);

		// ��ѯ
		JButton cx = new JButton("��ѯ");
		cx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ����ͼ�����ƺ����߲�ѯ
				panelta.removeAll();

				panelta.setLayout(new BorderLayout(10, 2));
				// ����һ�����ָ�� ���������� �� ��ͷ
				table = Frmjie.Frmtable(tsmc.getText(), tszz.getText());
				table.addMouseListener(new MouseAdapter() {
					// �������¼�
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

				JScrollPane jsp = new JScrollPane(table);// �������Ϲ�����
				// panelta.add(table.getTableHeader(), BorderLayout.NORTH);
				// �� ������� ��ӵ�������
				panelta.add(jsp, BorderLayout.CENTER);

				panelta.revalidate();

			}
		});
		panelwz.add(cx);
		panelzs.add(panelwz, BorderLayout.NORTH);

		// ���Ĺ���
		JPanel panelxd = new JPanel();
		panelxd.setBounds(0, 422, 730, 349);
		Border bdz = new TitledBorder(new LineBorder(Color.black, 1), "������Ϣ");
		panelxd.setBorder(bdz);
		panel.add(panelxd);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();

		xiabujieyue = new JPanel();
		xiabujieyue.setBounds(5, 53, 720, 291);
		xiabujieyue.setLayout(new BorderLayout(10, 2));

		// ����һ�����ָ�� ���������� �� ��ͷ
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
		// �� ������� ��ӵ�������
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

		// ���ڿؼ�
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// �������ڸ�ʽ
		String sone = df.format(new Date());
		txrq = new JButton();
		DateChooserJButton dateChooserJButton = new DateChooserJButton(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"), sone);
	
		txrq.add(dateChooserJButton,java.awt.BorderLayout.CENTER);
		txrq.setBounds(300, 22, 159, 25);
		panelxd.add(txrq);
		
		JButton btnjy = new JButton("\u501F\u9605");
		btnjy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ���ݶ��߱�Ų�ѯ 3
				if (dzbh.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "���߱�Ų�����Ϊ�գ�����");
					return;
				}
				Date dae=dateChooserJButton.getDate();
				Date dqrq=new Date();
				if(dae.before(dqrq)){
					JOptionPane.showMessageDialog(null, "�黹���ݼ������ڽ���֮ǰ!");
					return;
				}
//				df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// �������ڸ�ʽ
				String eq = df.format(dae);

				 int n=JOptionPane.showConfirmDialog(null,"��ȷ��Ҫ������Ϊ:"+shum+"����Ϊ:"+shuzz+"��ͼ����","����",
				 JOptionPane.YES_NO_OPTION);
				 if(n==0){
				 FrmjieyueServicer sr=new Frmjieyuelmpl();
				 int s=sr.jieyues(dzbh.getText(),snumb, eq);
				 if(s<1){
				 JOptionPane.showMessageDialog(null, "����ʧ�ܣ�");
				 return;
				 }else{
					int sd=sr.deltesa(shum);
					
					panelta.removeAll();
            		panelta.setLayout(new BorderLayout(10, 2));
            		// ����һ�����ָ�� ���������� �� ��ͷ
            		table = refisteror.retable(null);
            		table.addMouseListener(new MouseAdapter() {
            			// �������¼�
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

            		JScrollPane jsp = new JScrollPane(table);// �������Ϲ�����
            		// panelta.add(table.getTableHeader(), BorderLayout.NORTH);
            		// �� ������� ��ӵ�������
            		panelta.add(jsp, BorderLayout.CENTER);
					panelta.revalidate();
					
					
					 
					 
				 xiabujieyue.removeAll();
				 xiabujieyue.setBounds(5, 53, 720, 291);
				 xiabujieyue.setLayout(new BorderLayout(10,2));
				
				 // ����һ�����ָ�� ���������� �� ��ͷ
				 JTable bt = Frmjie.Frmjiyue();
				 panelj.setLayout(null);
				 panelxd.setLayout(null);
				 xiabujieyue.add(bt.getTableHeader(), BorderLayout.NORTH);
				 // �� ������� ��ӵ�������
				 xiabujieyue.add(bt, BorderLayout.CENTER);
				 xiabujieyue.revalidate();
				 }
				 }

			}
		});
		btnjy.setBounds(553, 24, 93, 23);
		panelxd.add(btnjy);

//		JButton btncj = new JButton("���");
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

		// �ص���toString���ڵ����ʾ�ı�����toString
		public String toString() {
			return name;
		}

	}
}
