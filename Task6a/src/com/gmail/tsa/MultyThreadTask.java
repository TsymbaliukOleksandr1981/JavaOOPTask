package com.gmail.tsa;

public class MultyThreadTask {
	private Thread[] threadArray;
	private int n;

	public MultyThreadTask(int n) {
		super();
		this.n = n;
		this.threadArray = new Thread[this.n];
	}

	public MultyThreadTask() {
		super();
		this.threadArray = new Thread[0];
	}

	public void startCompute() {
		for (int i = 0; i < threadArray.length; i++) {
			threadArray[i] = new Thread(new FactorialThread(i));
			threadArray[i].start();
		}
	}

}
