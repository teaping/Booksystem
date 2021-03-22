package com.ksd.mp.controller;

import com.ksd.mp.servicer.Impl.LoginServicerlmpl;
import com.ksd.mp.util.DoRun;
import com.ksd.mp.util.Yanzhencode;
import com.ksd.mp.EnterScreen;
import com.ksd.mp.servicer.LoginServicer;

import javax.sound.midi.Soundbank;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class logfrom {
	public static Thread threado=null;
	
	JFrame frame = null;
	//权限
	public static String qxqw=null;

	public Integer numn = 0;
	// 管理员
	public static String ad = null;

	// 权限
	public static String uview = null;

	// 登入
	public static void main(String[] args) {
		logfrom lo = new logfrom();
		lo.logJz();
	}

	public static String gylname = null;

	public void logJz() {
		// 美化包
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		// 创建 JFrame 实例
		frame = new JFrame("Login");

		frame.setResizable(false);
		// Setting the width and height of frame
		frame.setSize(579, 356);
		frame.setLocationRelativeTo(null);
		/*
		 * 创建面板，这个类似于 HTML 的 div 标签 我们可以创建多个面板并在 JFrame 中指定位置
		 * 面板中我们可以添加文本字段，按钮及其他组件。
		 */
		frame.setAlwaysOnTop(true);
		JPanel panel = new JPanel();
		// 添加面板
		frame.getContentPane().add(panel);
		/*
		 * 调用用户定义的方法并添加组件到面板
		 */
		placeComponents(panel);

		JLabel label = new JLabel("图书管理系统");
		label.setFont(new Font("宋体", Font.BOLD, 24));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(173, 33, 244, 43);
		panel.add(label);

		// 设置界面可见
		frame.setVisible(true);
		// 关闭方式
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	private void placeComponents(JPanel panel) {
		Font font1 = new Font("宋体", Font.PLAIN, 24);

		panel.setLayout(null);

		// 创建账号
		JLabel userLabel = new JLabel("账号:");
		userLabel.setFont(new Font("宋体", Font.PLAIN, 19));
		userLabel.setBounds(134, 99, 80, 25);
		panel.add(userLabel);

		/*
		 * 账号输入框
		 */
		JTextField userText = new JTextField();
		userText.setBounds(240, 101, 165, 25);
		panel.add(userText);

		// 密码
		JLabel userpwd = new JLabel("密码:");
		userpwd.setFont(new Font("宋体", Font.PLAIN, 19));
		userpwd.setBounds(134, 149, 80, 25);
		panel.add(userpwd);

		// 密码输入
		JPasswordField passwordLabel = new JPasswordField(20);
		passwordLabel.setBounds(240, 151, 165, 25);
		panel.add(passwordLabel);

		//验证码
		JLabel labyzm=new JLabel("验证码：");
		labyzm.setFont(new Font("宋体", Font.PLAIN, 19));
		labyzm.setBounds(134, 198, 165, 25);
		panel.add(labyzm);
		
		//验证码输入
		JTextField txtyazm = new JTextField();
		txtyazm.setBounds(240, 198, 165, 25);
		panel.add(txtyazm);
		
		// 登入按钮
		JButton loginButton = new JButton("登录");
		loginButton.setBounds(121, 281, 93, 25);
		panel.add(loginButton);

		// 取消按钮
		JButton cancel = new JButton("取消");
		cancel.setBounds(371, 281, 93, 25);
		panel.add(cancel);
		
		

		Yanzhencode vcode = new  Yanzhencode();

		vcode.setBounds(240, 233, 80, 25);
		panel.add(vcode);

		// 提示框
		JLabel hintLabel = new JLabel();
		hintLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		hintLabel.setBounds(337, 233, 175, 25);
		hintLabel.setForeground(Color.red);
		panel.add(hintLabel);

		// 登入验证
		loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				String da=" ";
				// userText.setText("admin");
				// passwordLabel.setText("12345");
				ad = userText.getText();
				String mi = passwordLabel.getText();

				// 判断账号是否为空
				if (ad.equals("")) {
					JOptionPane.showMessageDialog(panel, "账号不需许为空", "提示消息", JOptionPane.WARNING_MESSAGE);
					return;
				} else if (mi.equals("")) {
					JOptionPane.showMessageDialog(panel, "密码不需许为空", "提示消息", JOptionPane.WARNING_MESSAGE);
					return;
				}
				String yzq=txtyazm.getText();
				
				// 实现接口调用方法
				LoginServicer login = new LoginServicerlmpl();
				 da = login.query(ad, mi);
				//判断输入验证码是否正确
	             if(yzq==null||yzq.equals("")) {
	            	 da="验证码不允许为空";
	            	 vcode.nextCode();
	             }else if(vcode.getCode().equals(yzq)) {
	                 da=" ";
	             }else{
	            	 da="验证码错误";
	            	 vcode.nextCode();
	             }
				if (da == " ") {
					if (numn == 1) {
						 homepage.frame.dispose();
					}
					 qxqw=login.queryQx(ad);
					// 赋值给静态管理员
					gylname = ad;
					// 跳转主页面
					// new homepage();
					Thread tone = Thread.currentThread();
					DoRun run = new DoRun();
					threado=new Thread(run);
					threado.start();
					frame.dispose();
				}
				// 显示提示
				hintLabel.setText(da);
			}
		});
		// alt+enter登入
		loginButton.setMnemonic(KeyEvent.VK_ENTER);

		// 取消按钮
		cancel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				// 清空文本框内容
				userText.setText("");
				passwordLabel.setText("");
				if (numn == 1) {
					frame.dispose();
				}
			}
		});

		// 回车登入事件
//		loginButton.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// userText.setText("admin");
//				// passwordLabel.setText("12345");
//				ad = userText.getText();
//				String mi = passwordLabel.getText();
//
//				// 判断账号是否为空
//				if (ad.equals("")) {
//					JOptionPane.showMessageDialog(panel, "账号不需许为空", "提示消息", JOptionPane.WARNING_MESSAGE);
//					return;
//				} else if (mi.equals("")) {
//					JOptionPane.showMessageDialog(panel, "密码不需许为空", "提示消息", JOptionPane.WARNING_MESSAGE);
//					return;
//				}
//				// 实现接口调用方法
//				LoginServicer login = new LoginServicerlmpl();
//				String da = login.query(ad, mi);
//				if (da == " ") {
//					// 跳转主页面
//					// new homepage().logzh();
//					// 隐藏该页面
//					frame.setVisible(false);
//				}
//				// 显示提示
//				hintLabel.setText(da);
//			}
//		});

	}
}
