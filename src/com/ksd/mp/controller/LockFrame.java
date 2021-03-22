package com.ksd.mp.controller;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LockFrame extends JDialog {
	BorderLayout borderLayout1 = new BorderLayout();
	JButton jButton2 = new JButton();
	boolean isOK = true;
	JLabel jlableInfo = null;
	private boolean canRunCount = true;
	private JPasswordField passwordField;
	private JLabel label_3;

	public LockFrame(JFrame jframe, String str, boolean bool) {
		super(jframe, str, true);
		setSize(300, 130);
		// 这个方法尤为重要，只要屏蔽了右上角的关闭按钮
		setUndecorated(true);
		// 设置总是将dialog显示在屏幕的最前面
		setAlwaysOnTop(true);
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - getWidth()) / 2,
				(Toolkit.getDefaultToolkit().getScreenSize().height - getHeight()) / 2);
		setPreferredSize(new Dimension(200, 130));
		getContentPane().setLayout(new BorderLayout(0, 0));
		JPanel rootPanel = new JPanel();
		rootPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 255, 255), null));
		getContentPane().add(rootPanel, BorderLayout.CENTER);
		rootPanel.setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 60));
		rootPanel.add(panel, BorderLayout.NORTH);
		// panel.setLayout(new MigLayout("", "[][][][]", "[][]"));
		JLabel label = new JLabel("\u7CFB\u7EDF\u8FD0\u884C\u6B63\u5E38\uFF0C\u4F46\u5DF2\u9501\u5B9A\u3002");
		label.setFont(new Font("宋体", Font.PLAIN, 14));
		panel.add(label, "cell 1 0");
		JLabel label_1 = new JLabel("请您输入登录的密码解锁! ");
		label_1.setFont(new Font("宋体", Font.PLAIN, 14));
		panel.add(label_1, "cell 1 1");
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(10, 5));
		rootPanel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 255, 255));
		separator.setPreferredSize(new Dimension(280, 2));
		panel_1.add(separator);
		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(10, 60));
		rootPanel.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(null);
		JLabel label_2 = new JLabel("\u5BC6\u7801\uFF1A");
		label_2.setBounds(26, 10, 36, 15);
		panel_2.add(label_2);
		passwordField = new JPasswordField();
		passwordField.setBounds(66, 7, 210, 21);
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent event) {
//				System.out.println(event.getKeyCode());
				if (event.getKeyCode() == 10) {
					String pw = passwordField.getText();
					// 获取登录的用户密码
					if (pw.equals("123456")) {
						dispose();
					} else {
						label_3.setText("对不起，请您输入正确的密码！");
						passwordField.setText("");
						return;
					}
				}
			}
		});
		passwordField.setPreferredSize(new Dimension(210, 21));
		panel_2.add(passwordField);
		label_3 = new JLabel("");
		label_3.setBackground(Color.ORANGE);
		label_3.setBounds(66, 35, 210, 15);
		panel_2.add(label_3);
	}
}