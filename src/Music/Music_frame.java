package Music;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JSlider;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FileDialog;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;

public class Music_frame extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JScrollPane jsp;
	JFrame JF=this;
	JPanel pane;
	JButton dellist;
	JButton inlist;
	JButton add;
	JButton up;
	JButton down;
	JButton play;
	JLabel singer ;
	JLabel singname;
	JSlider ylslider;
	JSlider singslider;
	JLabel bg;
	private JLabel song;
	Actionjian jian=new Actionjian();
	List<File> musiclist;
	int songnum=100;
	JLabel sea;
	int num=0;
    int y=5;
    int jspheight=1;
    MusicThread playth;
    boolean pause=false;
    File dangqianmusic;
    JLabel gecilabel;
    JPanel gecipanel;
    JButton searchbtn;
    private JTextField search;
    private JPanel seapanel;
//	public static void main(String[] args) {
//	                 
//					Music_frame frame = new Music_frame();
//					frame.setVisible(true);
//					frame.setResizable(false);
//					
//					
//
//	}

	public Music_frame() {
		
		 musiclist=new ArrayList<File>(num);
		setFont(new Font("黑体", Font.PLAIN, 14));
		setTitle("  \u9177 \u5C0F \u72D7 \u97F3 \u4E50   V 1.0");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\16631\\Pictures\\music\\icon.gif"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(330, 100, 900, 630);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(2, 2, 2, 2));
		setContentPane(contentPane);
		
		contentPane.setLayout(null);
		
	    up = new JButton("上一首");
	    up.addActionListener(jian);
		up.setOpaque(false);
		up.setBounds(307, 533, 75, 50);
		contentPane.add(up);
		
		down = new JButton("下一首");
		down.addActionListener(jian);
		down.setBounds(537, 533, 75, 50);
		contentPane.add(down);
		
	    play = new JButton("播放/暂停");
		play.setBackground(Color.WHITE);
		//play.setIcon(new ImageIcon("C:\\Users\\16631\\Pictures\\music\\play.gif"));
		play.setBounds(410, 523, 100, 60);
		play.addActionListener(jian);
		contentPane.add(play);
		
	    singer = new JLabel("");
		singer.setIcon(new ImageIcon("C:\\Users\\16631\\Pictures\\music\\singer\\noicon.gif"));
		singer.setBounds(10, 517, 66, 66);
		contentPane.add(singer);
		
		
		singname=new MoveLabel("");
		singname.setForeground(Color.BLACK);
		singname.setFont(new Font("黑体", Font.PLAIN, 16));
		singname.setBounds(86, 522, 140, 20);
		contentPane.add(singname);
		
		JLabel yinliang = new JLabel("");
		yinliang.setIcon(new ImageIcon("C:\\Users\\16631\\Pictures\\music\\\u672A\u6807\u9898-3.gif"));
		yinliang.setBounds(671, 517, 45, 50);
		contentPane.add(yinliang);
		
		
		ylslider = new JSlider(0,100,30);
		ylslider.setPaintTicks(true);//显示滑动痕迹，无用
		ylslider.setOpaque(false);
		ylslider.setBounds(714, 539, 137, 20);
		contentPane.add(ylslider);
		
		singslider = new JSlider();
		singslider.setOpaque(false);
		singslider.setBounds(62, 493, 789, 22);
		contentPane.add(singslider);
		
		pane = new JPanel();
		pane.setBackground(Color.WHITE);
		//pane.setBounds(10, 38, 272, 454);
		//pane.setOpaque(false);
		contentPane.add(pane);
		pane.setLayout(null);
		
		jsp = new JScrollPane(pane);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jsp.setBounds(10, 38, 272, 454);
	
		pane.setPreferredSize(new Dimension(jsp.getWidth() - 50, jspheight));
		getContentPane().add(jsp);
		pane.revalidate(); //告诉其他部件,我的宽高变了
		
		gecilabel = new JLabel("\u6B22\u8FCE\u6765\u5230\u7CFB\u7EDF\u97F3\u4E50");
		gecilabel.setForeground(Color.RED);
		gecilabel.setFont(new Font("黑体", Font.PLAIN, 26));
		gecilabel.setBounds(458, 235, 261, 50);
		contentPane.add(gecilabel);
		
		gecipanel = new JPanel();
		gecipanel.setOpaque(false);
		gecipanel.setBounds(419, 67, 451, 413);
		contentPane.add(gecipanel);
//		gecipanel.setLayout(null);
//		
//		JScrollPane jsp2 = new JScrollPane(gecipanel);
//		jsp2.setOpaque(false);
//		jsp2.getViewport().setOpaque(false);
//		jsp2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
//		jsp2.setBounds(300, 20, 570, 460);
//		gecipanel.setPreferredSize(new Dimension(jsp2.getWidth() - 50, getHeight()));
//		getContentPane().add(jsp2);
//		gecipanel.revalidate(); //告诉其他部件,我的宽高变了
		
		
		
		add = new JButton("\u6DFB  \u52A0");
		add.setBounds(10, 10, 97, 23);
		contentPane.add(add);
		add.setBackground(Color.WHITE);
		add.addActionListener(jian);
		
//		inlist = new JButton("\u5BFC  \u5165");
//		inlist.addActionListener(jian);
//		inlist.setBounds(103, 10, 97, 23);
//		contentPane.add(inlist);
//		inlist.setBackground(Color.WHITE);
		
		dellist = new JButton("\u6E05  \u9664");
		dellist.addActionListener(jian);
		dellist.setBounds(194, 10, 97, 23);
		contentPane.add(dellist);
		dellist.setBackground(Color.WHITE);
		
		search = new JTextField();
		search.setBounds(367, 11, 300, 25);
		contentPane.add(search);
		search.setColumns(10);
		
		searchbtn = new JButton("\u641C \u7D22");
		searchbtn.setFont(new Font("黑体", Font.PLAIN, 14));
		searchbtn.setBounds(680, 11, 70, 25);
		contentPane.add(searchbtn);
		searchbtn.addActionListener(jian);
		
		bg = new JLabel();
		bg.setIcon(new ImageIcon("C:\\Users\\16631\\Pictures\\music\\bg.jpg"));
		bg.setBounds(0, 0, 883, 593);
		contentPane.add(bg);
		initlist();
		new Thread(new Runnable() {//长期保持，刷新音乐列表

			@Override
			public void run() {
			   while(true) {
				   
				   pane.repaint();
				   jsp.repaint();
				   try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   }
				
			}}).start();
		
	}
	
public void huaone(String singname, ImageIcon icon,File f) {
	
	musiclist.add(f);
	num++;
	song = new JLabel(singname);
	song.setOpaque(true);
	song.setBounds(5, y, 245, 50);
	//song.setPreferredSize(new Dimension(270,50));
	song.setIcon(icon);
	pane.add(song);
	pane.validate();
	mousein mjian=new mousein(song);
	song.addMouseMotionListener(mjian);
	mouseexit mexit =new mouseexit(song,f);
	song.addMouseListener(mexit);
	y=y+53;
	jspheight=jspheight+53;
	pane.setPreferredSize(new Dimension(jsp.getWidth() - 50, jspheight));
	getContentPane().add(jsp);
	pane.revalidate(); //告诉其他部件,我的宽高变了
	} 

public boolean judgesing(String singname) {
	int a=singname.indexOf(".mp3");
	if(a>0) {
		return true;
	}else {
		return false;
	}
}


public String getsingername(String singname) {
	int start=0;
	int end=singname.indexOf(" - ");
	if(end>start) {
		String str=singname.substring(start, end);
		return str;
	}else {
		return null;
	}

}
public ImageIcon getsingericon(String singername) {
	 File dir=new File("E:\\CloudMusic");
	 File[] filelist=dir.listFiles();
	 for(int i=0;i<filelist.length;i++) {
		 if((singername+".jpg").equals(filelist[i].getName())) {
			 ImageIcon icon =new ImageIcon(filelist[i].getAbsolutePath());
			 return icon;
		 }
		 
	 }
	ImageIcon icon =new ImageIcon("E:\\CloudMusic");
	return icon;
}



public void inlist() {//导入列表
	 JFileChooser saveFile = new JFileChooser( "添加歌曲");
	 saveFile.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	 saveFile.showOpenDialog(JF);
	 String singpath = saveFile.getSelectedFile().getAbsolutePath();
	 if(singpath!=null) {
	 File dir=new File(singpath);
	 File[] filelist=dir.listFiles();
	 File[] filelist2=new File[filelist.length];
	 for(int i=0;i<filelist.length;i++) {
		 boolean real=judgesing(filelist[i].getName());
		 if(real==true) {//判断是否是MP3
			 filelist2[i]=filelist[i];
			 ImageIcon icon=getsingericon(getsingername(filelist[i].getName()));
			 huaone(filelist[i].getName(),icon,filelist[i]);
		 }
	 }
	 }
}

public void initlist() {//初始化导入列表
	
	 String singpath = "E:\\CloudMusic";//默认导入的文件夹
	 if(singpath!=null) {
	 File dir=new File(singpath);
	 File[] filelist=dir.listFiles();
	
	 for(int i=0;i<filelist.length;i++) {
		 boolean real=judgesing(filelist[i].getName());
		 if(real==true) {//判断是否是MP3
			 ImageIcon icon=getsingericon(getsingername(filelist[i].getName()));
			 huaone(filelist[i].getName(),icon,filelist[i]);
		 }
	 }
	 }
}



class Actionjian implements ActionListener{
   
	
	boolean flag=false;
	List<File> sealist=new ArrayList<File>(0);
	int h=22;
	
	
	private void updownsong(int num) {
		for(int i=0;i<musiclist.size();i++) {
			if(playth.getMusic().equals(musiclist.get(i))) {
				playth.stop();
				i=i+num;
				
				if(i+1>musiclist.size()) {
					i=0;
				}else if(i<0) {
					i=musiclist.size()-1;//歌曲切换到小于0时候，默认播放第最后一曲
				}
				playth=new MusicThread(musiclist.get(i));
				playth.start();
				singer.setIcon(getsingericon(getsingername(musiclist.get(i).getName())));
				singer.repaint();//加上实时显示
			    singer.revalidate();//重绘，但是不显示1
			    play.setIcon(new ImageIcon("C:\\Users\\16631\\Pictures\\music\\stop.gif"));
				play.repaint();
				singname.setText(musiclist.get(i).getName());
				break;
			}
		}
		
	}
	
	public JPanel seapanel(int h) {
		seapanel = new JPanel();
		
		seapanel.setBackground(Color.WHITE);
		seapanel.setBounds(367, 36, 300, h);
		contentPane.add(seapanel);
		seapanel.repaint();
		seapanel.revalidate();
		return seapanel;
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==play) {
		
			 if(flag){//播放歌舞
				  playth=new MusicThread(dangqianmusic);
				  playth.start();
	        	  //playth.userPlay();
	        	  play.setIcon(new ImageIcon("C:\\Users\\16631\\Pictures\\music\\stop.gif"));
	        	  play.repaint();
	        	  flag=false;
	          }else if(playth!=null&&flag==false) {//停止播放
	        	 // playth.userPause();
	        	  playth.suspend();
	        	  play.setIcon(new ImageIcon("C:\\Users\\16631\\Pictures\\music\\play.gif"));
	        	  play.repaint();
	        	  flag=true;
	          }
			
			
		}else if(e.getSource()==up) {
			if(play!=null)
			updownsong(-1);
			
		}else if(e.getSource()==down) {
			if(play!=null)
			updownsong(1);
			
		}else if(e.getSource()==add) {
			 FileDialog saveFile = new FileDialog(JF, "添加歌曲",FileDialog.LOAD);
			 saveFile.setBounds(JF.getX()+100, JF.getY()+50, JF.getWidth()-150, JF.getHeight()-200);
			 saveFile.setVisible(true);
			 String singpath = saveFile.getDirectory() + saveFile.getFile();
			 File file=new File(singpath);
			 String singname=file.getName();
			 if(singpath!=null&&!singname.equals("nullnull")) {
				 ImageIcon icon=getsingericon(getsingername(singname));
				huaone(singname,icon,file);
				pane.repaint();//加上实时显示
			    pane.revalidate();//重绘，但是不显示1
			 }
			
			
		}else if(e.getSource()==inlist) {
			inlist();
			pane.repaint();//加上实时显示
		    pane.revalidate();//重绘，但是不显示1
		}else if(e.getSource()==dellist) {
	         pane.removeAll();
	         pane.repaint();
	         pane.revalidate();
	         y=5;//新加入的便签位于开始
	         musiclist.removeAll(musiclist);
	         jspheight=1;//标签初始化，否则面板清除后在导入有一半空白
	         pane.setPreferredSize(new Dimension(jsp.getWidth() - 50, jspheight));
	 		 getContentPane().add(jsp);
	 		 pane.revalidate(); //告诉其他部件,我的宽高变了
		}else if(e.getSource()==searchbtn) {
	         String info=search.getText();
	         h=22;
	         if(info!="") {
	        	 
	        	for(int i=0;i<musiclist.size();i++) {
	        		if(musiclist.get(i).getName().indexOf(info)>0) {//找到了查询及结果
	        			sealist.add(musiclist.get(i));
	        			System.out.println(musiclist.get(i).getName());
	        			
	        		}
	        	}
	        	if(sealist.size()>0) {
	        		
	        		for(int i=1;i<=sealist.size();i++) {
	        			sea=new JLabel(sealist.get(i-1).getName());
	        			mouseexit ex=new mouseexit(sea,sealist.get(i-1));
	        			sea.addMouseListener(ex);
	        			
	        			sea.setBounds(0, 0, 300, h);
	        			seapanel(22*sealist.size()).add(sea);
	        			h+=22;
	        			
	        		}
	        	     
	        	}
	        	
	        	
	         }
	         
			
			
		}
		
	}
	
	
	
}

class mousein implements MouseMotionListener{
	
	JLabel l;
	
	mousein(JLabel l){
		this.l=l;
		
	}

	public void mouseMoved(MouseEvent e) {
		l.setBackground(Color.LIGHT_GRAY);
		
		
	}
	
	public void mouseDragged(MouseEvent arg0) {
		
	}
	
}

class mouseexit implements MouseListener{
	JLabel l;
	File music=null;
	public File getMusic() {
		return music;
	}

	public void setMusic(File music) {
		this.music = music;
	}

	mouseexit(JLabel l,File music){
		this.l=l;
		this.music=music;

	}

	
	public void flushsinger(){
		singer.setIcon(getsingericon(getsingername(music.getName())));
		singer.repaint();//加上实时显示
	    singer.revalidate();//重绘，但是不显示1
	}
	
	public void mouseClicked(MouseEvent e) {
		int clickcount=e.getClickCount();
		
		
		if(clickcount==2) {//双击事件
			if(playth==null) {
				playth=new MusicThread(music);
				pause=true;
				playth.start();
				dangqianmusic=music;
				singname.setText(music.getName());
				flushsinger();
			}else if(playth.isAlive()) {
				playth.stop();
				playth=new MusicThread(music);
				playth.start();
				dangqianmusic=music;
				singname.setText(music.getName());
				flushsinger();
			}
			
			play.setIcon(new ImageIcon("C:\\Users\\16631\\Pictures\\music\\stop.gif"));
			play.repaint();
		    singname.setText(music.getName());
		
		}else if(e.getSource()==sea) {
			if(clickcount==2) {//双击事件
				if(playth==null) {
					playth=new MusicThread(music);
					pause=true;
					playth.start();
					dangqianmusic=music;
					singname.setText(music.getName());
					flushsinger();
				}else if(playth.isAlive()) {
					playth.stop();
					playth=new MusicThread(music);
					playth.start();
					dangqianmusic=music;
					singname.setText(music.getName());
					flushsinger();
				}
				
				play.setIcon(new ImageIcon("C:\\Users\\16631\\Pictures\\music\\stop.gif"));
				play.repaint();
			    singname.setText(music.getName());
			}
			
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	     l.setBackground(null);
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}



class MusicThread extends Thread{

	File music;

	
	public File getMusic() {
		return music;
	}
	public void setMusic(File music) {
		this.music = music;
	}
	MusicThread(File music){
		this.music=music;
		
	}

	

	public File getlrc(String filename) {
		int end =filename.indexOf(".mp3");
		String lrc=filename.substring(0, end);
		
		File dir=new File("E:\\CloudMusic");
		 File[] filelist=dir.listFiles();
		 
		 
		 for(int i=0;i<filelist.length;i++) {
			if((lrc+".lrc").equals(filelist[i].getName())) {
				return filelist[i];
			}
			 
		 }
		 
		return null;	
	}
	
	
	public void playgeci(File geci) {
		if(geci!=null) {
		gecilabel.setVisible(false);
		try {
		BufferedReader br = new BufferedReader(new FileReader(geci));
		String s;
		int x=10;
		int y=460;
		int w=570;
		int h=22;
		while((s = br.readLine())!=null){
			System.out.println(s);
			GeCiLabel t=new GeCiLabel(s,x,y,w,h);
			t.start();
			gecipanel.add(t.getL());
			
            try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}
		}catch( FileNotFoundException e) {
			System.out.println("文件找不到");
		}catch( IOException e) {
			System.out.println("歌词io异常");
		}
		}
	}
	public  void run() { 
		
	  try {
		  
		   FileInputStream fis = new FileInputStream(music);
			Player player=new Player(fis);
			new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					playgeci(getlrc(music.getName()));//歌词显示
				}
				
			}).start();
			player.play();
			
			
			
		} catch (JavaLayerException e) {
			e.printStackTrace();
		
       }catch (FileNotFoundException e) {
			e.printStackTrace();
		
       }
		//同步syn结尾
		
	}//run结尾

}
}
