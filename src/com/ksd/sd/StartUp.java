package com.ksd.sd;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
 
 
 
 
public class StartUp  extends JFrame  implements ActionListener{
	 private JLabel imagelabel=new JLabel();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new  StartUp();
		
	}
 
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
public  StartUp(){
	this.setTitle("“Ù¿÷≤•∑≈∆˜");
	this.setBounds(500, 150, 500, 800);
	//this.setLocation(500, 150);
	//this.setSize(500, 800);
	this.setLayout(null);
	this.setLocationRelativeTo(null);
	this.setUndecorated(true);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	ImageIcon image=new ImageIcon("src/picture/∆Ù∂Ø“≥√Ê2.png");
     imagelabel = new JLabel(image);
     imagelabel.setBounds(0,0,500,800);
     this.add(imagelabel);
     this.setVisible(true);
    
 
    
     	  
    B b=new B();
    
    try{
 	  Thread.sleep(3000);
 	  b.start();
    }catch(InterruptedException e){
 	   e.printStackTrace();
 
	
	}
}
 
class B extends Thread{
	public void run(){
		 StartUp.this.dispose();
		//new UserLogin1();	
		 zhuye z=new zhuye();
	}
 
	
 
}}
