package com.ksd.mp.controller.terminal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.ksd.mp.controller.MyThread;
import com.ksd.mp.controller.homepage;
import com.ksd.mp.controller.logfrom;
import com.ksd.mp.servicer.LoginServicer;
import com.ksd.mp.servicer.systemServier;
import com.ksd.mp.servicer.Impl.LoginServicerlmpl;
import com.ksd.mp.servicer.Impl.systemImpl;

//用户修改密码
public class systemho extends JDialog{
	private JLabel wordbook_1;
	JFrame frameqw=null;
	public systemho(JFrame frameq){
		super(frameq,"用户修改密码",true);
		frameqw=frameq;
		this.setSize(300, 339);
		this.setLocationRelativeTo(null);
		Container con=this.getContentPane();

		this.setResizable(false);
		
		JLabel wordbook=new JLabel();
		getContentPane().setLayout(null);
		wordbook_1=new JLabel("用户修改密码",SwingConstants.CENTER);
		wordbook_1.setBounds(0, 0, 294, 30);
		wordbook_1.setFont(new Font("宋体", Font.PLAIN, 28));
//		wordbook.setBorder(new LineBorder(Color.GREEN, 2));
		con.add(wordbook_1);
		
		JPanel panel=new JPanel();
		panel.setBounds(0, 35, 294, 232);
		// TODO Auto-generated method stub
		JPanel panezs=new JPanel();
		panezs.setBounds(0, 0, 294, 231);
		Border br= new TitledBorder(new LineBorder(Color.black, 1), "请谨慎填写");
		panel.setLayout(null);
		panezs.setBorder(br);
		panezs.setLayout(null);
		
		JLabel jl=new JLabel(new ImageIcon("image/Muisc.png"));
		jl.setBounds(6, 17, 94, 31);
		panezs.add(jl);
		JLabel labyhm=new JLabel("用户名:");
		labyhm.setFont(new Font("宋体", Font.PLAIN, 14));
		labyhm.setBounds(90, 17, 58, 31);
		panezs.add(labyhm);
		JTextField txyhm=new JTextField(logfrom.gylname);
		txyhm.setBounds(145, 17, 94, 31);
		txyhm.setHorizontalAlignment(SwingConstants.LEFT);
		panezs.add(txyhm);
		
		JLabel jlq=new JLabel(new ImageIcon("image/Muisc.png"));
		jlq.setBounds(6, 68, 94, 31);
		panezs.add(jlq);
		JLabel labymi=new JLabel("原密码:");
		labymi.setFont(new Font("宋体", Font.PLAIN, 14));
		labymi.setBounds(90, 68, 58, 31);
		panezs.add(labymi);
		JPasswordField txmim=new JPasswordField();
		txmim.setBounds(145, 68, 94, 31);
		txmim.setHorizontalAlignment(SwingConstants.LEFT);
		panezs.add(txmim);
		
		JLabel jlw=new JLabel(new ImageIcon("image/Muisc.png"));
		jlw.setBounds(6, 119, 94, 31);
		panezs.add(jlw);
		JLabel labxmi=new JLabel("新密码:");
		labxmi.setFont(new Font("宋体", Font.PLAIN, 14));
		labxmi.setBounds(90, 119, 58, 31);
		panezs.add(labxmi);
		JPasswordField txxmi=new JPasswordField();
		txxmi.setBounds(145, 119, 94, 31);
		txxmi.setHorizontalAlignment(SwingConstants.LEFT);
		panezs.add(txxmi);
		
		JLabel jle=new JLabel(new ImageIcon("image/Muisc.png"));
		jle.setBounds(6, 170, 94, 31);
		panezs.add(jle);
		JLabel labqm=new JLabel("确认码:");
		labqm.setFont(new Font("宋体", Font.PLAIN, 14));
		labqm.setBounds(90, 170, 58, 31);
		panezs.add(labqm);
		JPasswordField txqm=new JPasswordField();
		txqm.setBounds(145, 170, 94, 31);
		txqm.setHorizontalAlignment(SwingConstants.LEFT);
		panezs.add(txqm);
		panel.add(panezs);
		
		

		
		con.add(panel);
		
		JPanel panelxb=new JPanel();
		panelxb.setBounds(0, 266, 294, 34);
		JButton btnxg=new JButton("修改");
		btnxg.setBounds(10, 10, 112, 24);
		btnxg.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				String	ad = txyhm.getText();
				String mi = txmim.getText();

				// 判断账号是否为空
				if (ad.equals("")) {
					JOptionPane.showMessageDialog(panel, "账号不需许为空", "提示消息", JOptionPane.WARNING_MESSAGE);
					return;
				} else if (mi.equals("")) {
					JOptionPane.showMessageDialog(panel, "密码不需许为空", "提示消息", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if (!txxmi.getText().equals(txqm.getText())) {
					JOptionPane.showMessageDialog(panel, "两次密码不一致", "提示消息", JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				
				// 实现接口调用方法
				systemServier s=new systemImpl();
				String da=s.changepassword(ad, mi, txxmi.getText());
				if (da.equals("1")) {
//					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//					Thread t = Thread.currentThread();
//					MyThread t1 =new  MyThread();
//					t1.run();
//					setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
					//销毁当前页面
//					 homepage.this.setVisible(true);  
//					
					frameqw.dispose();
					logfrom sqwe=new logfrom();
					sqwe.logJz();
					systemho.this.dispose();
					
					
//					t.stop();
//					System.out.println("成功");
				}else {
					System.out.println(da);
				}
				// 显示提示
		
			}
		});
		panelxb.setLayout(null);
		panelxb.add(btnxg);
		JButton btnqx=new JButton("取消");
		btnqx.setBounds(172, 10, 112, 24);
		btnqx.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txyhm.setText("");
				txmim.setText("");
				txqm.setText("");
				txxmi.setText("");
			}
		});
		panelxb.add(btnqx);
		
		con.add(panelxb);
		this.setVisible(true);
		// 关闭方式
	this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

	}

	

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		system s=new system();
//
//	}

}
