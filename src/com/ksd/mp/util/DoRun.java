package com.ksd.mp.util;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.WindowConstants;

import com.ksd.mp.controller.homepage;
import javax.swing.SwingConstants;
import java.awt.Font;

public class DoRun extends JPanel implements Runnable	 {
	
	public static JFrame homepage=null;
	private static final long serialVersionUID = 1L;
	
	private final int DELAY = 50;// 转动快慢设置
//	private final static Long time = (long) 5000;	//窗体关闭事件
	private static Timer timer;	//动画计时器
	private int x = 0;
	JLabel s=null;
	
	/**
	 * 调用
	 */
	static JFrame frame=null;
	
	/**
	 * 面板构造函数，初始化面板。包括Timer 的场景。
	 */
	public DoRun() {
		
		

		 frame = new JFrame("加载中...");
		 this.setLayout(null);
		 frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//本类为Panel
		frame.getContentPane().add(this);
		frame.setSize(1000, 600);;
		frame.setLocation(400, 400);
		
		

		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	
		s=new JLabel("122222");
		s.setBounds(466, 309, 100, 100);
		
		JLabel jaz=new JLabel("图书系统加载中...");
		jaz.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 30));
		jaz.setHorizontalAlignment(SwingConstants.CENTER);

		jaz.setBounds(337, 106, 315, 153);
		this.add(jaz);
		this.add(s);
	}

	/**
	 * 动画效果：不断的更新图像的位置，以达到动画的效果。
	 */
	private class ReboundListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (x< DoRun.frame.getSize().getWidth()) {
				x = x + 20;
			Integer sa=	x*100/(int) DoRun.frame.getSize().getWidth();
			s.setText(sa.toString()+"%");
			} else {
				timer.stop();
				
				new homepage().logzh();
				frame.dispose();
			}
			repaint();
		}
	}

	/**
	 * 绘出图像在面板中的位置
	 */
	public void paintComponent(Graphics page) {
		super.paintComponent(page);
		drawArc(page);
	}
	
	/**
	 * 画图形
	 */
	private void drawArc(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		//抗锯齿 
		//JDK文档：http://tool.oschina.net/uploads/apidocs/jdk-zh/java/awt/RenderingHints.html
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		int width = getWidth();
		int height = getHeight();
		//设置画笔颜色
		g2d.setColor(Color.BLACK);
		g2d.drawLine(0,400,x,400);
		g2d.dispose();
	}

	@Override
	public void run() {
		
		// TODO Auto-generated method stub
		timer = new Timer(DELAY, new ReboundListener());
		timer.start();
	}
}
