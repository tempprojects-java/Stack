package com.gmail.gak.artem;

import java.util.Arrays;

public class Stack {
	private Object[] elements;
	private int size;
	private int topIndex;
	private StackBlackList bList;

	public Stack(int size, StackBlackList bList) {
		super();
		this.size = size;
		this.elements = new Object[size];
		this.bList = bList;
	}

	public Stack(int size) {
		super();
		this.size = size;
		this.elements = new Object[size];
	}

	public Stack() {
		super();
	}

	public void push(Object obj) throws StackOverflowException, StackIllegalObjectType {
		if (obj == null) {
			throw new IllegalArgumentException();
		}

		if (bList.isSetType(obj.getClass().getSimpleName())) {
			throw new StackIllegalObjectType();
		}

		if (topIndex == size) {
			throw new StackOverflowException();
		}

		elements[topIndex] = obj;
		topIndex += 1;
	}

	public Object pop() throws StackUnderflowException {
		if (topIndex == 0) {
			throw new StackUnderflowException();
		}

		topIndex -= 1;
		Object result = elements[topIndex];
		elements[topIndex] = null;

		return result;
	}

	public Object top() {
		if (topIndex == 0) {
			return null;
		}

		return elements[topIndex - 1];
	}

	public void denyType(String type) {
		bList.add(type);
	}

	@Override
	public String toString() {
		return Arrays.toString(elements);
	}

	public Object[] getElements() {
		return elements;
	}

	public void setElements(Object[] elements) {
		this.elements = elements;
		if (elements.length > size) {
			size = elements.length;
		}
		topIndex = elements.length;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		if (size < this.size) {
			this.size = size;
			Object[] buffer = new Object[size];
			System.arraycopy(elements, 0, buffer, 0, size);
			elements = buffer;
			topIndex = size;
		} else if (size > elements.length) {
			this.size = size;
			Object[] buffer = new Object[size];
			System.arraycopy(elements, 0, buffer, 0, elements.length);
			elements = buffer;
		}
	}

	public int getTopIndex() {
		return topIndex;
	}

	public void setTopIndex(int topIndex) {
		if (topIndex == 0 || topIndex > size) {
			throw new IllegalArgumentException();
		}

		Object[] buffer = new Object[size];
		System.arraycopy(elements, 0, buffer, 0, topIndex);
		elements = buffer;
		this.topIndex = topIndex;
	}

	public StackBlackList getbList() {
		return bList;
	}

	public void setbList(StackBlackList bList) {
		this.bList = bList;
	}

}
