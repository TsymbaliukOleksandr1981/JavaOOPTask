package com.gmail.tsa;

public class Letter {
	private char letter;
	private int count = 0;

	public Letter(char letter, int count) {
		super();
		this.letter = letter;
		this.count = count;
	}

	public Letter() {
		super();
	}

	public char getLetter() {
		return letter;
	}

	public void setLetter(char letter) {
		this.letter = letter;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return letter + " -> " + count;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + count;
		result = prime * result + letter;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Letter other = (Letter) obj;
		if (count != other.count)
			return false;
		if (letter != other.letter)
			return false;
		return true;
	}

}
