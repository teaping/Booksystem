package com.text;
import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;


public class TestSwingGUILock{



public static void main(String[] args) throws InterruptedException {
	new TestSwingGUILock();
	 Thread t = Thread.currentThread();
     System.out.println(t.getName());
     for (int i = 0; i < 1000; i++) {
		t.sleep(2000);
		System.out.println(i);
	}
     
     asdasd   myThread = new asdasd();
     myThread.start();
}
}