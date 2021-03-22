package com.ksd.mp.controller.terminal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.ksd.mp.GuanYi.BookInfo;
import com.ksd.mp.interior.rankingor;
import com.ksd.mp.servicer.registerQueryServicer;
import com.ksd.mp.servicer.Impl.registerQuerylmp;

//���а�
public class ranking extends JFrame {
	public ranking(){
		super("���а�");
		this.setSize(1000, 800);
		this.setLocationRelativeTo(null);
		Container con=this.getContentPane();
		con.setLayout(new GridLayout(2,1,10,0));
		//��
		JPanel panels=new JPanel();
		above(panels);
		
		
		//��
		JPanel panelx=new JPanel();
		below(panelx);
		
		con.add(panels);
		con.add(panelx);
		this.setVisible(true);
		// �رշ�ʽ
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	//����
	private void below(JPanel panelx) {
		// TODO Auto-generated method stub
		panelx.setLayout(new BorderLayout(10,2));
		// TODO Auto-generated method stub
		JLabel wordbook=new JLabel();
		wordbook=new JLabel("���߽������а�",SwingConstants.CENTER);
		wordbook.setFont(new Font("��������",Font.PLAIN,28));
//		wordbook.setBorder(new LineBorder(Color.GREEN, 2));
		panelx.add(wordbook,BorderLayout.NORTH);
		
		//�ϲ�
		JPanel panezx=new JPanel();
		Border b= new TitledBorder(new LineBorder(Color.black, 1), "�����޵�֮ʮ������");
		panezx.setBorder(b);
		
		panezx.setLayout(new BorderLayout(10, 5));
		
	        

	        JTable table = rankingor.readrank();  
	        panezx.add(table.getTableHeader(), BorderLayout.NORTH);
	        // �� ������� ��ӵ�������
	        panezx.add(table,BorderLayout.CENTER);
	        
	        panelx.add(panezx);
	        
	}

	//����
	private void above(JPanel panels) {
		panels.setLayout(new BorderLayout(10,2));
		// TODO Auto-generated method stub
		JLabel wordbook=new JLabel();
		wordbook=new JLabel("ͼ��������а�",SwingConstants.CENTER);
		wordbook.setFont(new Font("��������",Font.PLAIN,28));
//		wordbook.setBorder(new LineBorder(Color.GREEN, 2));
		panels.add(wordbook,BorderLayout.NORTH);
		
		//�ϲ�
		JPanel panezx=new JPanel();
		Border b= new TitledBorder(new LineBorder(Color.black, 1), "���ܻ�ӭ֮ʮ������");
		panezx.setBorder(b);
		
		panezx.setLayout(new BorderLayout(10, 5));
		
	        JTable table =rankingor.bookrank(); 
	        panezx.add(table.getTableHeader(), BorderLayout.NORTH);
	        // �� ������� ��ӵ�������
	        panezx.add(table,BorderLayout.CENTER);
	        
	        panels.add(panezx);
	        
		
	}


//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		ranking s=new ranking();
//
//	}

}
