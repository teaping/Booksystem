package com.ksd.mp.util;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Vector;
import java.awt.Dialog.ModalExclusionType;
public class Calculator {
  String str1 = "0"; // ������1 ��ֵһ��Ϊ0 Ϊ�˳���İ�ȫ
  String str2 = "0"; // ������2
  String signal = "+"; // �����
  String result = "";// ���
  // ״̬����
  int k1 = 1;// ����1 ����ѡ�����뷽�� ��Ҫд��str2�� str2
  int k2 = 1;// ����2 ���ż� ���� k2>1˵�����е���2+3-9+8 �����Ķ��������
  int k3 = 1;// ����3 str1 �Ƿ���Ա���0 ==1ʱ���� !=1ʱ���ܱ���0
  int k4 = 1;// ����4 str2 ͬ��
  int k5 = 1;// ����5 ����С����ɷ�¼�� ==1ʱ���� !=1 �����С���㱻����
  JButton store; // �Ĵ��� ��¼ �Ƿ��������·��ż�
  Vector vt = new Vector(20, 10);
  JFrame frame = null;
  JTextField result_TextField = new JTextField(result, 20);// 20��
  JButton clear_Button = new JButton("���");
  JButton button0 = new JButton("0");
  JButton button1 = new JButton("1");
  JButton button2 = new JButton("2");
  JButton button3 = new JButton("3");
  JButton button4 = new JButton("4");
  JButton button5 = new JButton("5");
  JButton button6 = new JButton("6");
  JButton button7 = new JButton("7");
  JButton button8 = new JButton("8");
  JButton button9 = new JButton("9");
  JButton button_Dian = new JButton(".");
  JButton button_jia = new JButton("+");
  JButton button_jian = new JButton("-");
  JButton button_cheng = new JButton("*");
  JButton button_chu = new JButton("/");
  JButton button_dy = new JButton("=");
public  Calculator() {
	 frame = new JFrame("������");
    button0.setMnemonic(KeyEvent.VK_0);// ��Ч��
    // ���� ��Ч�� ��,
    result_TextField.setHorizontalAlignment(JTextField.RIGHT);// �ı��� �Ҷ���
    JPanel pan = new JPanel();
    pan.setLayout(new GridLayout(4, 4, 5, 5));// �������� �߾�Ϊ5����
    pan.add(button7);
    pan.add(button8);
    pan.add(button9);
    pan.add(button_chu);
    pan.add(button4);
    pan.add(button5);
    pan.add(button6);
    pan.add(button_cheng);
    pan.add(button1);
    pan.add(button2);
    pan.add(button3);
    pan.add(button_jian);
    pan.add(button0);
    pan.add(button_Dian);
    pan.add(button_dy);
    pan.add(button_jia);
    pan.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));// pan����ı߾�
    JPanel pan2 = new JPanel();
    pan2.setLayout(new BorderLayout());
    pan2.add(result_TextField, BorderLayout.WEST);
    pan2.add(clear_Button, BorderLayout.EAST);

    frame.setLocationRelativeTo(null); // ������ ������λ��
//    frame.setSize(1000, 800);
    frame.setResizable(false); // ���ܵ���С
    frame.getContentPane().setLayout(new BorderLayout());
    frame.getContentPane().add(pan2, BorderLayout.NORTH);
    frame.getContentPane().add(pan, BorderLayout.CENTER);
    frame.pack();
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    // �¼����� �� ��
    // �� �� ��
    class Listener implements ActionListener {
      @SuppressWarnings("unchecked")
      public void actionPerformed(ActionEvent e) {
        String ss = ((JButton) e.getSource()).getText();
        store = (JButton) e.getSource();
        vt.add(store);
        if (k1 == 1) {
          if (k3 == 1) {
            str1 = "";
            k5 = 1;// ��ԭ����k5״̬
          }
          str1 = str1 + ss;
          k3 = k3 + 1;
          result_TextField.setText(str1);// ��ʾ
        } else if (k1 == 2) {
          if (k4 == 1) {
            str2 = "";
            k5 = 1; // ��ԭ����k5״̬
          }
          str2 = str2 + ss;
          k4 = k4 + 1;
          result_TextField.setText(str2);
        }
      }
    }
    // �� ��
    class Listener_signal implements ActionListener {
      @SuppressWarnings("unchecked")
      public void actionPerformed(ActionEvent e) {
        String ss2 = ((JButton) e.getSource()).getText();
        store = (JButton) e.getSource();
        vt.add(store);
        if (k2 == 1) {
          k1 = 2;// ���� k1 Ϊ1ʱ,����1д Ϊ2ʱ������2д
          k5 = 1;
          signal = ss2;
          k2 = k2 + 1;// �����ż��Ĵ���
        } else {
          int a = vt.size();
          JButton c = (JButton) vt.get(a - 2);
          if (!(c.getText().equals("+"))
              && !(c.getText().equals("-"))
              && !(c.getText().equals("*"))
              && !(c.getText().equals("/")))
          {
            cal();
            str1 = result;
            k1 = 2;// ���� k1 Ϊ1ʱ,����1д Ϊ2ʱ������2д
            k5 = 1;
            k4 = 1;
            signal = ss2;
          }
          k2 = k2 + 1;
        }
      }
    }
    // ���
    class Listener_clear implements ActionListener {
      @SuppressWarnings("unchecked")
      public void actionPerformed(ActionEvent e) {
        store = (JButton) e.getSource();
        vt.add(store);
        k5 = 1;
        k2 = 1;
        k1 = 1;
        k3 = 1;
        k4 = 1;
        str1 = "0";
        str2 = "0";
        signal = "";
        result = "";
        result_TextField.setText(result);
        vt.clear();
      }
    }
    // �� ��
    class Listener_dy implements ActionListener {
      @SuppressWarnings("unchecked")
      public void actionPerformed(ActionEvent e) {
        store = (JButton) e.getSource();
        vt.add(store);
        cal();
        k1 = 1; // ��ԭ����k1״̬
        // str1=result;
        k2 = 1;
        k3 = 1;// ��ԭ����k3״̬
        k4 = 1; // ��ԭ����k4״̬
        str1 = result; // Ϊ7+5=12 +5=17 ���ּ�����׼��
      }
    }
    // С����
    class Listener_xiaos implements ActionListener {
      @SuppressWarnings("unchecked")
      public void actionPerformed(ActionEvent e) {
        store = (JButton) e.getSource();
        vt.add(store);
        if (k5 == 1) {
          String ss2 = ((JButton) e.getSource()).getText();
          if (k1 == 1) {
            if (k3 == 1) {
              str1 = "";
              k5 = 1; // ��ԭ����k5״̬
            }
            str1 = str1 + ss2;
            k3 = k3 + 1;
            result_TextField.setText(str1);// ��ʾ
          } else if (k1 == 2) {
            if (k4 == 1) {
              str2 = "";
              k5 = 1; // ��ԭ����k5״̬
            }
            str2 = str2 + ss2;
            k4 = k4 + 1;
            result_TextField.setText(str2);
          }
        }
        k5 = k5 + 1;
      }
    }
    // ע�� ������
    Listener_dy jt_dy = new Listener_dy();
    Listener jt = new Listener();// �������ּ�
    Listener_signal jt_signal = new Listener_signal();// �� ���� �ż�
    Listener_clear jt_c = new Listener_clear(); // �����
    Listener_xiaos jt_xs = new Listener_xiaos();// С���� ��
    button7.addActionListener(jt);
    button8.addActionListener(jt);
    button9.addActionListener(jt);
    button_chu.addActionListener(jt_signal);
    button4.addActionListener(jt);
    button5.addActionListener(jt);
    button6.addActionListener(jt);
    button_cheng.addActionListener(jt_signal);
    button1.addActionListener(jt);
    button2.addActionListener(jt);
    button3.addActionListener(jt);
    button_jian.addActionListener(jt_signal);
    button0.addActionListener(jt);
    button_Dian.addActionListener(jt_xs);
    button_dy.addActionListener(jt_dy);
    button_jia.addActionListener(jt_signal);
    clear_Button.addActionListener(jt_c);
    // �ر��¼���������
//    frame.addWindowListener(new WindowAdapter() {
//      public void windowClosing(WindowEvent e) {
//        System.exit(0);
//      }
//    });
  }
  // �� ��
  public void cal() {
    double a2;// ������1
    double b2;// ������2
    String c = signal;// �����
    double result2 = 0;// ���
    if (c.equals("")) {
      result_TextField.setText("�����������");
    } else {
      if (str1.equals(".")) // �ַ��� "." ת����double������ʱ ����� �����ֹ�ת
        str1 = "0.0";
      if (str2.equals("."))
        str2 = "0.0";
      a2 = Double.valueOf(str1).doubleValue();
      b2 = Double.valueOf(str2).doubleValue();
      if (c.equals("+")) {
        result2 = a2 + b2;
      }
      if (c.equals("-")) {
        result2 = a2 - b2;
      }
      if (c.equals("*")) {
        result2 = a2 * b2;
      }
      if (c.equals("/")) {
        if (b2 == 0) {
          result2 = 0;
        } else {
          result2 = a2 / b2;
        }
      }
      result = ((new Double(result2)).toString());
      result_TextField.setText(result);
    }
  }

}