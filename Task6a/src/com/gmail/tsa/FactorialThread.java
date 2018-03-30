package com.gmail.tsa;

import java.math.BigInteger;

public class FactorialThread implements Runnable {
	private int n;

	public FactorialThread(int n) {
		super();
		this.n = n;
	}

	public FactorialThread() {
		super();
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " " + this.n + "! = " + this.calculateFactorial());
	}

	private BigInteger calculateFactorial() {
		BigInteger fact = new BigInteger("1");
		for (int i = 1; i <= this.n; i++) {
			fact = fact.multiply(new BigInteger("" + i));
		}
		return fact;
	}
}
