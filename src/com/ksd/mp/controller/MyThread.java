package com.ksd.mp.controller;

public class MyThread extends Thread {

	//密码修改新线程
	@Override
	public void run() {
		// TODO Auto-generated method stub
		logfrom s=new logfrom();
		s.logJz();
		
	}

}
