package com.gmail.tsa;

public class Stack {
	private Object[] stackArray = new Object[10];
	private int top = 0;
	private BlackList blackList;

	public Stack() {
		super();
	}

	public Stack(BlackList blackList) {
		super();
		this.blackList = blackList;
	}

	public BlackList getBlackList() {
		return blackList;
	}

	public void setBlackList(BlackList blackList) {
		this.blackList = blackList;
	}

	private void resizeUp() {
		Object[] temp = new Object[(this.stackArray.length * 7) / 4];
		System.arraycopy(stackArray, 0, temp, 0, stackArray.length);
		this.stackArray = temp;
	}

	public boolean addElement(Object obj) {
		if (obj == null) {
			return false;
		}
		if (blackList.checkObject(obj)) {
			System.out.println("Class is blackList");
			return false;
		}
		if (top == stackArray.length) {
			this.resizeUp();
		}
		stackArray[top++] = obj;
		return true;

	}

	public Object pop() {
		if (top == 0) {
			return null;
		}
		Object temp = stackArray[--top];
		stackArray[top] = null;
		return temp;
	}

	public Object peek() {
		if (top == 0) {
			return null;
		}
		return stackArray[top - 1];
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < top; i++) {
			if (stackArray[i] == null) {
				continue;
			}
			sb.append(stackArray[i].getClass() + "   ").append(stackArray[i]);
			sb.append(System.lineSeparator());
		}
		return sb.toString();
	}

}
