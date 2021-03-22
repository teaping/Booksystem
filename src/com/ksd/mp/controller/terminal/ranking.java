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

//排行榜
public class ranking extends JFrame {
	public ranking(){
		super("排行榜");
		this.setSize(1000, 800);
		this.setLocationRelativeTo(null);
		Container con=this.getContentPane();
		con.setLayout(new GridLayout(2,1,10,0));
		//上
		JPanel panels=new JPanel();
		above(panels);
		
		
		//下
		JPanel panelx=new JPanel();
		below(panelx);
		
		con.add(panels);
		con.add(panelx);
		this.setVisible(true);
		// 关闭方式
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	//下面
	private void below(JPanel panelx) {
		// TODO Auto-generated method stub
		panelx.setLayout(new BorderLayout(10,2));
		// TODO Auto-generated method stub
		JLabel wordbook=new JLabel();
		wordbook=new JLabel("读者借阅排行榜",SwingConstants.CENTER);
		wordbook.setFont(new Font("华文琥珀",Font.PLAIN,28));
//		wordbook.setBorder(new LineBorder(Color.GREEN, 2));
		panelx.add(wordbook,BorderLayout.NORTH);
		
		//上部
		JPanel panezx=new JPanel();
		Border b= new TitledBorder(new LineBorder(Color.black, 1), "勇者无敌之十大书生");
		panezx.setBorder(b);
		
		panezx.setLayout(new BorderLayout(10, 5));
		
	        

	        JTable table = rankingor.readrank();  
	        panezx.add(table.getTableHeader(), BorderLayout.NORTH);
	        // 把 表格内容 添加到容器中
	        panezx.add(table,BorderLayout.CENTER);
	        
	        panelx.add(panezx);
	        
	}

	//上面
	private void above(JPanel panels) {
		panels.setLayout(new BorderLayout(10,2));
		// TODO Auto-generated method stub
		JLabel wordbook=new JLabel();
		wordbook=new JLabel("图书借阅排行榜",SwingConstants.CENTER);
		wordbook.setFont(new Font("华文琥珀",Font.PLAIN,28));
//		wordbook.setBorder(new LineBorder(Color.GREEN, 2));
		panels.add(wordbook,BorderLayout.NORTH);
		
		//上部
		JPanel panezx=new JPanel();
		Border b= new TitledBorder(new LineBorder(Color.black, 1), "最受欢迎之十大名著");
		panezx.setBorder(b);
		
		panezx.setLayout(new BorderLayout(10, 5));
		
	        JTable table =rankingor.bookrank(); 
	        panezx.add(table.getTableHeader(), BorderLayout.NORTH);
	        // 把 表格内容 添加到容器中
	        panezx.add(table,BorderLayout.CENTER);
	        
	        panels.add(panezx);
	        
		
	}


//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		ranking s=new ranking();
//
//	}

}
