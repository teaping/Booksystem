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

//����Ǽǹ���
public class register extends JFrame {

	private JTable table;
	private JTextField txtsbm;
	private JTextField txtsmc;
	private JTextField txtszz;
	private JTextField txtsjq;
	private JTextField txtssl;
	private JButton txrgrq;//   Date�ؼ���ΪText�ı�������
	private Toolkit kit;
	private JPanel panx;
	private JButton butqc;
	private JButton buttj;
	private JButton buttc;

	
	JComboBox ccbcbs=null;
	JComboBox cmbtslx=null;
	private JPanel panelz;

	public register() {
		super("����Ǽǹ���");
		this.setSize(1000, 800);
		this.setLocationRelativeTo(null); // ʹ���������ʾ
		Container con = this.getContentPane();
		con.setLayout(new BorderLayout(10, 5));

		// �����Ķ���
		JPanel panel = new JPanel();
//		panel.setBorder(new LineBorder(Color.red, 2));

		panelz = new JPanel();
		panelz.setBorder(new LineBorder(Color.BLACK, 2));

		// �����Ϸ��󶨷���
		hint(panel);
		
		//��������ͼ����Ϣ
		 sobook(panelz);

		// ��Ӷ�����ť���
		con.add(panel, BorderLayout.NORTH);

		// ��ӵ��������
		con.add(panelz, BorderLayout.CENTER);

		this.setVisible(true);
//		 �رշ�ʽ
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	// ��ʾ��
	private void hint(JPanel panle) {
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
		labts.setSize(20, 250);
		ts.setPreferredSize(new Dimension(250, 200));
		ts.add(labts);
		panle.add(ts, BorderLayout.WEST);
		// �ұ�ͼ����Ϣ
		JPanel tsz = new JPanel();
		Border cts = new TitledBorder(new LineBorder(Color.black, 1), "����������ͼ����Ϣ");
		tsz.setBorder(cts);
		// ����ͼ��������Ϣ
		bookmessage(tsz);

		panle.add(tsz, BorderLayout.CENTER);
	}

	// �鼮������Ϣ
	private void bookmessage(JPanel panel) {

		panel.setLayout(new BorderLayout(10, 5));
		JPanel pansl = new JPanel();

		pansl.setLayout(new GridLayout(4, 4,20,8));
//		pansl.setBorder(new LineBorder(Color.red, 2));

		JLabel blx = new JLabel("ͼ������:");
		cmbtslx = new JComboBox(); // ����JComboBox
		cmbtslx.addItem("--��ѡ��--"); // �������б������һ��
		cmbtslx.addItem("��ѧ");
		cmbtslx.addItem("��ʳ");
		cmbtslx.addItem("����");
		cmbtslx.addItem("����");
		cmbtslx.addItem("����");
		cmbtslx.addItem("���� ����");
		cmbtslx.addItem("��ְ");
		cmbtslx.addItem("����");
		pansl.add(blx);
		pansl.add(cmbtslx);		
		
		JLabel labmc = new JLabel("ͼ������:");
		txtsmc = new JTextField();
		pansl.add(labmc);
		pansl.add(txtsmc);	
		
		JLabel labzz = new JLabel("ͼ������:");
		txtszz = new JTextField();
		pansl.add(labzz);
		pansl.add(txtszz);	
		
		JLabel labjq = new JLabel("ͼ���Ǯ:");
		txtsjq = new JTextField();
		pansl.add(labjq);
		pansl.add(txtsjq);	
		JLabel bcb = new JLabel("������:");
		ccbcbs = new JComboBox(); // ����JComboBox
		ccbcbs.addItem("--��ѡ��--"); // �������б������һ��
		ccbcbs.addItem("������ѧ������");
		ccbcbs.addItem("�������������");
		ccbcbs.addItem("�������������");
		ccbcbs.addItem("���ϴ�ѧ������");
		ccbcbs.addItem("�����ѧ������");
		ccbcbs.addItem("�Ϻ���ѧ������");
		pansl.add(bcb);
		pansl.add(ccbcbs);	
		
		
		
		JLabel labsl = new JLabel("ͼ������:");
		txtssl = new JTextField();
		pansl.add(labsl);
		pansl.add(txtssl);	
		
		
		JLabel labsq = new JLabel("�������:");
//		 = new JTextField();
		
		txrgrq = new JButton();
		txrgrq.add(new DateChooserJButton(new SimpleDateFormat("yyyy/MM/dd HH"), "2020/12/12 22"),
				java.awt.BorderLayout.CENTER);
		
		
		
		pansl.add(labsq);
		pansl.add(txrgrq);
		
		//���ڿؼ�
		JLabel labxzrq = new JLabel("\u56FE\u4E66\u7F16\u7801\uFF1A");
		kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();
		pansl.add(labxzrq);
		
		

		panx = new JPanel();
		butqc = new JButton("���");
		butqc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				���
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
		buttj = new JButton("���");
		buttj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BaseDao.getConn();
				LoginServicer ls=new LoginServicerlmpl();
				BookInfo bk=getLib();
				int s=ls.psinsertlibrarian(bk);
				if(s>0){
					//���
					JOptionPane.showMessageDialog(null, "��ӳɹ�");
					panelz.removeAll();
					refisteror.sobookone(panelz);
				    panelz.revalidate();
					
				}else{
					JOptionPane.showMessageDialog(null, "���ʧ��");
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
		
		buttc = new JButton("�˳�");
		buttc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//�˳�
				dispose();
			}
		});
		panx.setLayout(new GridLayout(0, 3, 0, 0));
		
		
		panx.add(butqc);
		panx.add(buttj);
		panx.add(buttc);
		
		
//		panx.setBorder(new LineBorder(Color.red, 2));

		// ��
		panel.add(pansl, BorderLayout.CENTER);
		
		txtsbm = new JTextField();
		pansl.add(txtsbm);
		txtsbm.setColumns(10);
		panel.add(panx, BorderLayout.SOUTH);
	}

	//����ͼ��
	private void sobook(JPanel panel){
		panel.setLayout(new BorderLayout(10, 5));
		// ��ʾ��
		JPanel ts = new JPanel();
		ts.setLayout(new BorderLayout(10, 5));
		// ����
		Border b = new TitledBorder(new LineBorder(Color.black, 1), "��ܰ��ʾ");
		ts.setBorder(b);
		panel.add(ts);
		//����ͼ����Ϣ����
	
	        
	        table = refisteror.retable(null);
	        panel.add(table.getTableHeader(), BorderLayout.NORTH);
	        // �� ������� ��ӵ���������
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