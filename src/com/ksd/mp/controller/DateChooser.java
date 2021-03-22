package com.ksd.mp.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.ksd.mp.util.CalendarPanel;

public class DateChooser {
	private static final long serialVersionUID = 1L;
	//private static Point startp = null;
	//private Point endp = null;
 //日期控件案例
	public static void main(String[] args) {
 
		JFrame f = new JFrame();
		f.setLayout(null);
		JTextField txt1 = new JTextField();
//		JTextField txt2 = new JTextField();
		txt1.setBounds(20, 50, 300, 30);
//		JButton b =new JButton();

//		b.setBounds(20, 80, 300, 30);
//		b.addActionListener(new ActionListener() {
			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//
//				System.out.println(txt1.getText());	
//			}
//		});
//		f.add(b);
 
		// 定义日历控件面板类
		CalendarPanel p = new CalendarPanel(txt1, "yyyy/MM/dd");
		p.initCalendarPanel();
 
		JLabel l = new JLabel("日历面板");
		p.add(l);
		f.getContentPane().add(p);
		f.getContentPane().add(txt1);
//		f.getContentPane().add(txt2);
		f.setSize(500, 400);
		f.setBackground(Color.WHITE);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
	}

	private void sad(JTextField a){
	System.out.println(a.getText());	
	}

}
