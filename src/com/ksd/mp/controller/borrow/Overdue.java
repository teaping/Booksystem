package com.ksd.mp.controller.borrow;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.ksd.mp.GuanYi.BookInfo;
import com.ksd.mp.GuanYi.Chaoqts;
import com.ksd.mp.interior.Overdor;
import com.ksd.mp.servicer.OverdueServicer;
import com.ksd.mp.servicer.registerQueryServicer;
import com.ksd.mp.servicer.Impl.Overduelmpl;
import com.ksd.mp.servicer.Impl.registerQuerylmp;

import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
//����ͼ��
public class Overdue extends JFrame {
	static JTextField txttslb;
	static JTextField txttsbh;
	static JTextField txtdzbh;
	static JTextField txttssm;
	static JTextField txtyhrq;
	static JTextField txtcqts;
	static JTextField txtdzxm;
	static JTextField txtsfz;
	private JPanel panelz;
	public static void main(String[] args) {
		new Overdue();
	}
	public Overdue() {
		super("����ͼ��");
		this.setSize(942, 673);
		this.setLocationRelativeTo(null); // ʹ���������ʾ
		//ȡ�����
		this.setResizable(false);
		
		//�����²�����
		//�²�
		JPanel panelzong=new JPanel();
		panelzong.setBorder(new LineBorder(Color.red, 2));
		cqtsxb(panelzong);
		
		//�����ϲ�
		JPanel panelsb=new JPanel();
		panelsb.setBorder(new LineBorder(Color.red, 2));
		

		Container con=this.getContentPane();

		panelz=new JPanel();
		panelz.setBounds(0, 0, 936, 456);
		panelz.setBorder(new LineBorder(Color.BLACK, 0));
		//����ͼ�����
		loseInfo(panelz);
		con.add(panelz);
		
		
		this.setVisible(true);
		// �رշ�ʽ
		// �رշ�ʽ
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}


	
	//����ͼ��
			private void loseInfo(JPanel panel){
				//����ͼ��
				JPanel panelzs=new JPanel();
				panelzs.setLayout(new BorderLayout(10, 2));
				
				Border bzs = new TitledBorder(new LineBorder(Color.black, 1), "����ͼ��");
				panelzs.setBorder(bzs);
				//������ʾ
				JPanel panelwz=new JPanel();
				panelwz.setBorder(new LineBorder(Color.GREEN, 0));
				panelwz.setLayout(new BoxLayout(panelwz, BoxLayout.X_AXIS));
				panelzs.add(panelwz,BorderLayout.NORTH);
				
				
				//�·����
				JPanel panelta=new JPanel();
				panelta.setLayout(new BorderLayout(10, 2));
			        
			        
			        // ����һ�����ָ�� ���������� �� ��ͷ
			        JTable table =Overdor.Cqbook();  
			        table.addMouseListener(new MouseAdapter() {
			        	//�������¼�
						@Override
						public void mouseClicked(MouseEvent e) {
							// TODO Auto-generated method stub
							  int s = table.getSelectedRow();
							  txttslb.setText(table.getValueAt(s , 2).toString());          
							  txttsbh.setText(table.getValueAt(s , 0).toString());          
							  txtdzbh.setText(table.getValueAt(s , 4).toString());          
							  txttssm.setText(table.getValueAt(s , 1).toString());          
							  txtyhrq.setText(table.getValueAt(s , 7).toString());          
							  txtcqts.setText(table.getValueAt(s , 8).toString());          
							  txtdzxm.setText(table.getValueAt(s , 5).toString());          
							  txtsfz.setText(table.getValueAt(s , 6).toString());          
							  
//							  JPopupMenu jp1=new JPopupMenu();
//							  JMenuItem m1=new JMenuItem("���");
//							  jp1.add(m1);
//							  
//							  //m1.addAncestorListener();
//							  JMenuItem m2=new JMenuItem("ɾ��");
//							  jp1.add(m2);
//							  JMenuItem m3=new JMenuItem("�޸�");
//							  jp1.add(m3);
//							  
//							  if (table.getSelectedRow()!=-1) {
//								if (e.getButton()==MouseEvent.BUTTON3) {
//									  jp1.show(table,e.getX(),e.getY());
//								}
//							}
							 
						}
						
					});
			        panelz.setLayout(new BorderLayout(0, 0));
			        panelta.add(table.getTableHeader(), BorderLayout.NORTH);
			        // �� ������� ��ӵ�������
			        panelta.add(table, BorderLayout.CENTER);
			        panelzs.add(panelta,BorderLayout.CENTER);
					panel.add(panelzs);

					
			}
	
	
	
	//�²�
	private void cqtsxb(JPanel panelzong){
		//�²�����ߣ�
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(0, 462, 994, 190);
		getContentPane().add(panel);
		
		//��ܰ��ʾ 
		JPanel panelzx=new JPanel();
		panelzx.setBounds(0, 0, 270, 180);
		Border b = new TitledBorder(new LineBorder(Color.black, 1), "��ܰ��ʾ");
		panelzx.setBorder(b);
		// ��ʾͼƬ 
		Icon icon = new ImageIcon("image/label.png");
		String disText = "<html><HTML><body style=color:red>���ݹ涨��������Ϊ2����<br>" + "����һ���£�˫�������Ϣ<br>"+"��Ϣ������ʾ������ͼ��<br>" +"��Ϣ����������ϵͳ����<br>"+
				 "����ϵ: <br>115116206615 </body></html>";
		panel.setLayout(null);

		// ������ʾ ������ʽ
		JLabel labts = new JLabel(disText,icon,SwingConstants.LEFT);
		labts.setFont(new Font("����", Font.ITALIC, 16));
		labts.setVerticalAlignment(JLabel.TOP);
		labts.setSize(20, 250);
		panelzx.setPreferredSize(new Dimension(260, 180));
		panelzx.add(labts);
		panel.add(panelzx);
		
		
		//------------------------------------------------------------------------------------------
		//�²��ұ�
		JPanel cqtsxx = new JPanel();
		cqtsxx.setBounds(280, 0, 657, 180);
		panel.add(cqtsxx);
		Border  bo=new TitledBorder(new LineBorder(Color.black, 1),"����ͼ����Ϣ");
		cqtsxx.setBorder(bo);
		cqtsxx.setLayout(null);
		
		JLabel label = new JLabel("\u56FE\u4E66\u7C7B\u522B\uFF1A");
		label.setBounds(21, 27, 78, 15);
		cqtsxx.add(label);
		
		JLabel label_1 = new JLabel("\u56FE\u4E66\u7F16\u53F7\uFF1A");
		label_1.setBounds(343, 27, 78, 15);
		cqtsxx.add(label_1);
		
		JLabel label_2 = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		label_2.setBounds(21, 65, 78, 15);
		cqtsxx.add(label_2);
		
		JLabel label_3 = new JLabel("\u5E94\u8FD8\u65E5\u671F\uFF1A");
		label_3.setBounds(21, 98, 78, 15);
		cqtsxx.add(label_3);
		
		JLabel label_4 = new JLabel("\u8D85\u671F\u5929\u6570\uFF1A");
		label_4.setBounds(21, 138, 78, 15);
		cqtsxx.add(label_4);
		
		JLabel label_5 = new JLabel("\u8BFB\u8005\u7F16\u53F7\uFF1A");
		label_5.setBounds(343, 65, 78, 15);
		cqtsxx.add(label_5);
		
		JLabel label_6 = new JLabel("\u8BFB\u8005\u59D3\u540D\uFF1A");
		label_6.setBounds(343, 98, 78, 15);
		cqtsxx.add(label_6);
		
		JLabel label_7 = new JLabel("\u8EAB \u4EFD \u8BC1\uFF1A");
		label_7.setBounds(343, 138, 78, 15);
		cqtsxx.add(label_7);
		
		txttslb = new JTextField();
		txttslb.setBounds(109, 24, 164, 21);
		cqtsxx.add(txttslb);
		txttslb.setColumns(10);
		
		txttsbh = new JTextField();
		txttsbh.setColumns(10);
		txttsbh.setBounds(431, 24, 164, 21);
		cqtsxx.add(txttsbh);
		
		txtdzbh = new JTextField();
		txtdzbh.setColumns(10);
		txtdzbh.setBounds(431, 62, 164, 21);
		cqtsxx.add(txtdzbh);
		
		txttssm = new JTextField();
		txttssm.setColumns(10);
		txttssm.setBounds(109, 62, 164, 21);
		cqtsxx.add(txttssm);
		
		txtyhrq = new JTextField();
		txtyhrq.setColumns(10);
		txtyhrq.setBounds(109, 98, 164, 21);
		cqtsxx.add(txtyhrq);
		
		txtcqts = new JTextField();
		txtcqts.setColumns(10);
		txtcqts.setBounds(109, 136, 164, 21);
		cqtsxx.add(txtcqts);
		
		txtdzxm = new JTextField();
		txtdzxm.setColumns(10);
		txtdzxm.setBounds(431, 98, 164, 21);
		cqtsxx.add(txtdzxm);
		
		txtsfz = new JTextField();
		txtsfz.setColumns(10);
		txtsfz.setBounds(431, 136, 164, 21);
		cqtsxx.add(txtsfz);
		
		
		
		
		
		
	}
}
