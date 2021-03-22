package com.ksd.mp.controller.librarian;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.ksd.mp.controller.librarian.lose;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

public class loseysjf extends JDialog{
	
	public static boolean one=false;

	public JPanel contentPane;
	public static JTextField txtjfc;
	public static JTextField txtdz;
	public static JTextField txtbm;
	public static JTextField txtmc;
	public static JTextField txtjg;
	public static JTextField txtsk;
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					loseysjf frame = new loseysjf();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public loseysjf(JFrame famle) {
		
		super(famle,"缴费",true);
		Container con=this.getContentPane();
	
		contentPane = new JPanel();
		this.setBounds(100, 100, 450, 400);
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8D54\u507F\u7A97\u53E3");
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 20));
		lblNewLabel.setBounds(156, 21, 80, 35);
		contentPane.add(lblNewLabel);
		
		JPanel plpc = new JPanel();
		Border b = new TitledBorder(new LineBorder(Color.black, 1), "丢失赔偿");
		plpc.setBorder(b);
		plpc.setBounds(10, 67, 414, 143);
		contentPane.add(plpc);
		plpc.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\u7F34\u8D39\u5904\uFF1A");
		lblNewLabel_1.setBounds(72, 107, 54, 15);
		plpc.add(lblNewLabel_1);
		
		txtjfc = new JTextField();
		txtjfc.setBounds(119, 104, 99, 21);
		plpc.add(txtjfc);
		txtjfc.setColumns(10);
		
		txtdz = new JTextField(lose.dz);
		txtdz.setBounds(10, 20, 66, 21);
		txtdz.setEditable(false);
		txtdz.setOpaque(false);
		plpc.add(txtdz);
		txtdz.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u8BFB\u8005\uFF0C\u4F60\u9057\u5931\u7684\u56FE\u4E66\u4FE1\u606F\u4E3A\uFF1A\u7F16\u7801\uFF1A");
		lblNewLabel_2.setBounds(84, 23, 206, 15);
		plpc.add(lblNewLabel_2);
		
		txtbm = new JTextField(lose.bm);
		txtbm.setOpaque(false);
		txtbm.setEditable(false);
		txtbm.setColumns(10);
		txtbm.setBounds(288, 20, 66, 21);
		plpc.add(txtbm);
		
		JLabel lblNewLabel_3 = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		lblNewLabel_3.setBounds(20, 51, 106, 15);
		plpc.add(lblNewLabel_3);
		
		txtmc = new JTextField(lose.mc);
		txtmc.setOpaque(false);
		txtmc.setEditable(false);
		txtmc.setColumns(10);
		txtmc.setBounds(94, 48, 66, 21);
		plpc.add(txtmc);
		
		JLabel lblNewLabel_4 = new JLabel("\u56FE\u4E66\u4EF7\u683C\uFF1A");
		lblNewLabel_4.setBounds(165, 51, 70, 15);
		plpc.add(lblNewLabel_4);
		
		txtjg = new JTextField(lose.jg);
		txtjg.setOpaque(false);
		txtjg.setEditable(false);
		txtjg.setColumns(10);
		txtjg.setBounds(245, 48, 66, 21);
		plpc.add(txtjg);
		
		JLabel lblNewLabel_5 = new JLabel("\u6309\u7167\u89C4\u5B9A\u4F60\u5E94\u8BE5\u539F\u4EF7\u8D54\u507F\uFF0C\u5171\u6536\u60A8");
		lblNewLabel_5.setBounds(61, 82, 198, 15);
		plpc.add(lblNewLabel_5);
		
		txtsk = new JTextField(lose.jg);
		txtsk.setOpaque(false);
		txtsk.setEditable(false);
		txtsk.setColumns(10);
		txtsk.setBounds(255, 79, 66, 21);
		plpc.add(txtsk);
		
		JButton btnqr = new JButton("\u786E\u8BA4");
		btnqr.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Double num=Double.parseDouble(txtjfc.getText());
				if(num-lose.key==0){
					one=true;
					loseysjf.this.dispose();
				}else{
					JOptionPane.showMessageDialog(null,"钱不够哦！！！！");
					return;
				}
				//"图书编码", "图书名称", "出版社", "类别","价格","读者编号","归还日期","读者姓名","身份证","电话","备注","地址"
		
				
		
				
			}
		});
		btnqr.setBounds(58, 230, 93, 23);
		contentPane.add(btnqr);
		
		JButton btnqx = new JButton("\u53D6\u6D88");
		btnqx.setBounds(207, 230, 93, 23);
		con.add(btnqx);
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
}
