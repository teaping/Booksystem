package Music;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

public class GeCiLabel extends Thread{

	String inline;
	int x,y,w,h;
	JLabel l;
	int font=20;
	
	public JLabel getL() {
		return l;
	}

	GeCiLabel(String inline,int x,int y,int w,int h){
		this.inline=qudiaofuhao(inline);
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
	
		l=new JLabel();
		l.setText(this.inline);
		l.setForeground(Color.RED);
		l.setFont(new Font("ºÚÌå", Font.PLAIN, font));
		l.setBounds(x, y, w, h);
		l.setOpaque(false);
		
		
	}
	
	
	
public String qudiaofuhao(String s) {
	int start=s.indexOf("]")+1;
	if(start>0) {
	String result=s.substring(start);
	
	return result;
	}else {
		return "";
	}
}
	
	
public void run() {
	while(true) {
	   y=y-1;
	   l.setBounds(x, y, w, h);
	   //ÅĞ¶ÏÓï¾äÊµÏÖ
	   if(y<-h) {
	       break;}
	   try {
		   this.sleep(30);
	   } catch (InterruptedException e) {
		e.printStackTrace();
	  }
	}
	
	
}
	

	
}
