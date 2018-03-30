package com.gmail.tsa;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ViewService vs = new ViewService();
		Thread th = new Thread(vs);
		th.start();
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		th.interrupt();
	}

}
