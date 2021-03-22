package com.ksd.mp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sunking.swing.JDatePicker;

public class ReaderDate extends JPanel implements ActionListener {
	private JDatePicker jdpDate = null;
	private JLabel lblDate = null;

	public ReaderDate() {
		init();
		this.setSize(400, 300);
		this.setVisible(true);
	}

	private void init() {
		jdpDate = new JDatePicker();
		jdpDate.addActionListener(this);
		jdpDate.setBounds(46, 0, 108, 20);
		lblDate = new JLabel("ÈÕÆÚ:",JLabel.RIGHT);
		lblDate.setBounds(0, 0, 40, 20);
		this.setLayout(null);
		this.add(jdpDate);
		this.add(lblDate);
	}
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String time=null;
	int count=0;
	public void actionPerformed(ActionEvent e) {
		count++;
		try {
			Date date = jdpDate.getSelectedDate();
		    time= sdf.format(date);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
	}

	public String gettime() {
		if(count==0){
			time=sdf.format(new Date());
		}
		return time;
	}

	public static void main(String[] args) {
		
	}
}
