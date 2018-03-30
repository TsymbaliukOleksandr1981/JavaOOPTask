package com.gmail.tsa;

public class MultyThreadCalculation {
	private int threadNumber;
	private Thread[] threadArray;
	private int[] array;
	private SingleThreadSummator[] stArray;

	public MultyThreadCalculation(int threadNumber, int[] array) {
		super();
		this.threadNumber = threadNumber;
		this.array = array;
		this.threadArray = new Thread[this.threadNumber];
		stArray = new SingleThreadSummator[this.threadNumber];
	}

	public MultyThreadCalculation(int[] array) {
		super();
		this.array = array;
		this.threadNumber = Runtime.getRuntime().availableProcessors() * 2;
		this.threadArray = new Thread[this.threadNumber];
		stArray = new SingleThreadSummator[this.threadNumber];
	}

	public int calculateSum() {
		int sum = 0;
		int step = array.length / threadArray.length;
		for (int i = 0; i < threadArray.length; i++) {
			int begin = step * i;
			int end = (array.length - step * (i + 1)) < step ? array.length : step * (i + 1);
			stArray[i] = new SingleThreadSummator(array, begin, end);
			threadArray[i] = new Thread(stArray[i]);
			threadArray[i].start();
		}
		for (int i = 0; i < threadArray.length; i++) {
			try {
				threadArray[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int i = 0; i < stArray.length; i++) {
			sum += stArray[i].getSum();
		}
		return sum;
	}

}
