package com.ksd.mp;

import java.awt.*;//����awt��
 import javax.swing.*;//����swing��

import com.ksd.mp.util.Yanzhencode;

import java.awt.event.ActionListener;//����awt���еļ������¼���
 import java.awt.event.ActionEvent;//����awt���е�ActionEvent�¼���
 
 public class EnterScreen extends JFrame {
     static int s=0;
     public EnterScreen() { 
         Yanzhencode vcode = new  Yanzhencode();
         setSize(300,290);//��ƴ���Ĵ�С
         setTitle("���¼");
         setBackground(Color.RED);//���ñ�����ɫ
         JLabel a=new JLabel("��¼��"); //ʵ����JLabel����
         JLabel b=new JLabel("��    ��");
         JLabel g=new JLabel("�����û���/���룿");
         JLabel h=new JLabel("��֤��");
         g.setForeground(Color.BLUE); 
         JTextField c=new JTextField(15);//ʵ�����û����ı���
         JPasswordField d=new JPasswordField(15);//ʵ���������
         JTextField k=new JTextField(4);//ʵ������֤���
         d.setEchoChar('*');//������������е�������*��ʾ����
         JButton e=new JButton("��¼");
         JButton f=new JButton("����ע��");
         e.setBackground(Color.YELLOW);//���õ�¼��ť������ɫ
         f.setForeground(Color.GRAY);//���ÿ��ٵ�¼��ť���ɫ
         setVisible(true);//ʹ������ӻ�
         Container m=getContentPane();//��ȡһ������
         getContentPane().setBackground(Color.WHITE);//���ô������ɫ
 //        ���û����������Jlabel���û���JTextField�ı�������JPasswordField������Լ�ȷ��JButton������ע��JButton��ӵ�container��������                         //
         m.add(a);
         m.add(b);
         m.add(c);
         m.add(d);
         m.add(e);
         m.add(f);
         m.add(g);
         m.add(h);
         m.add(k);
         m.add(vcode);
         setBounds(300,300,300,300);//���ô���ĳ����Ϊ300��300  ������ʾ�����Ϸ���300��300��
         m.setLayout(null);
 //        a��b��c��d��e��f��ʾ��container�����е�λ������
         a.setBounds(10,40,50,18);
         b.setBounds(10,80,50,18);
         c.setBounds(60,40,130,18);
         d.setBounds(60,80,130,18);
         h.setBounds(10,120,50,18);
         k.setBounds(60,120,80,18);
         e.setBounds(90,180,100,30);
         f.setBounds(90,220,100,30);
         g.setBounds(190,75,100,30);
         vcode.setBounds(140,110,80,30);
         e.addActionListener(new ActionListener() {//�Ե�¼��ť��Ӽ����¼�
              
             @SuppressWarnings("deprecation")
             @Override
             public void actionPerformed(ActionEvent arg0) {
                 // TODO Auto-generated method stub
                 
                 if(c.getText().trim().equals("xiaoyang")&&new String(d.getPassword()).equals("123456")&&s==1) {//equals���������û����������ƥ��
                     JOptionPane.showMessageDialog(null,"��¼�ɹ�");
                     
//                     new NewFrame();//���뵽NewFrame���������
                 }else if(c.getText().trim().equals("xiaoyang")&&new String(d.getPassword()).equals("123456")&&s==0) {
                     JOptionPane.showMessageDialog(null,"��֤���������");
                 }else {
                     JOptionPane.showMessageDialog(null, "��¼ʧ��,�û������������֤���������");
                 }
             }
                 
         });
        f.addActionListener(new ActionListener(){//�Կ���ע�ᰴť��Ӽ����¼�
             @SuppressWarnings("deprecation")
             @Override
             public void actionPerformed(ActionEvent arg0) {
                 // TODO Auto-generated method stub
//                 new zhuce();//���붼��zhuce������
             }
             
         });
         //�ж�������֤���Ƿ���ȷ
             if(k.getText()== null) {
                 s=0;
             }else if(vcode.getCode() == null) {
                 s=1;
             }else if(vcode.getCode() .equals(k.getText())) {
                 s=1;
             }else { 
             s=0;    
         }
     }
     
         public static void main(String[] args) {
             new EnterScreen();
             
         }
         
     }