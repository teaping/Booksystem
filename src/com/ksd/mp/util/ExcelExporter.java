package com.ksd.mp.util;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.URLEncoder;

import javax.swing.*;
import javax.swing.table.*;

import com.ksd.mp.interior.rankingor;
import com.ksd.mp.interior.readeradminor;
import com.ksd.mp.interior.refisteror;
import com.ksd.mp.interior.systemad;

public class ExcelExporter extends JFrame {
	JTable table = null;
	JPanel panelzj = null;
	JScrollPane scroll = null;
	Integer inum = 0;

	public ExcelExporter() {
		super("JTable to Excel Hack");

		Container con = this.getContentPane();

		this.setSize(1000, 600);
		// this.pack();

		// //读者表
		// rankingor.readrank();
		// 用户表
		JPanel panleshangb = new JPanel();
		JButton btndz = new JButton("读者表");
		btndz.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				inum = 1;
				table = readeradminor.adminq();
				panelzj.removeAll();
				scroll = new JScrollPane(table);

				panelzj.add(scroll, BorderLayout.CENTER);
				panelzj.revalidate();
			}
		});
		JButton btnyh = new JButton("用户表");
		btnyh.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				inum = 2;
				table = systemad.systemas();
				panelzj.removeAll();
				scroll = new JScrollPane(table);

				panelzj.add(scroll, BorderLayout.CENTER);
				panelzj.revalidate();
			}
		});

		JButton btnts = new JButton("图书表");
		btnts.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				inum = 3;

				table = refisteror.retable(null);
				panelzj.removeAll();
				scroll = new JScrollPane(table);

				panelzj.add(scroll, BorderLayout.CENTER);
				panelzj.revalidate();
			}

		});
		panleshangb.add(btnts);
		panleshangb.add(btndz);
		panleshangb.add(btnyh);
		panelzj = new JPanel();
		panelzj.setLayout(new BorderLayout(10, 2));
		table = readeradminor.adminq();
		scroll = new JScrollPane(table);
		JButton export = new JButton("Export");
		export.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
				
					ExcelExporter exp = ExcelExporter.this;
					
					
					if (inum == 1) {

						exp.exportTable(table, new File("reader.xls"));
					}
					if (inum == 2) {

						exp.exportTable(table, new File("yumbia.xls"));
					}
					if(inum==3){
						exp.exportTable(table, new File("librarian.xls"));
					}

				} catch (IOException ex) {
					System.out.println(ex.getMessage());
					ex.printStackTrace();
				}
			}
		});

		con.add(panleshangb, BorderLayout.NORTH);
		panelzj.add("Center", scroll);

		con.add(panelzj, BorderLayout.CENTER);
		con.add(export, BorderLayout.SOUTH);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	public void exportTable(JTable table, File file) throws IOException {
		TableModel model = table.getModel();
//		String code = "编码";
//		code = URLEncoder.encode(code, "UTF-8");
//		FileWriter out = new FileWriter(file);
//		out=new OutputStreamWriter(out,gcode);
		OutputStreamWriter out=new OutputStreamWriter(new FileOutputStream(file), "gbk");

		for (int i = 0; i < model.getColumnCount(); i++) {
			out.write(model.getColumnName(i) + "\t");
		}
		out.write("\n");
		String s = "";
		for (int i = 0; i < model.getRowCount(); i++) {
			for (int j = 0; j < model.getColumnCount(); j++) {
				if (model.getValueAt(i, j) != null) {
					out.write(model.getValueAt(i, j).toString() + "\t");
				} else {
					out.write(" " + "\t");
				}

			}
			out.write("\n");
		}
		out.close();
		JOptionPane.showMessageDialog(null, "成功导出");
	}

}
