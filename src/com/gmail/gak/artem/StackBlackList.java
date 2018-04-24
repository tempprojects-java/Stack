package com.gmail.gak.artem;

public class StackBlackList {
	private String[] list;

	public StackBlackList(String[] list) {
		super();
		this.list = list;
	}

	public StackBlackList() {
		super();
		this.list = new String[0];
	}

	public void add(String type) {
		if (type == null) {
			throw new IllegalArgumentException();
		}

		if (getIndexOfType(type) == -1) {
			resize(list.length + 1);
			list[list.length - 1] = type;
		}
	}

	public boolean isSetType(String type) {
		if (type == null) {
			throw new IllegalArgumentException();
		}

		if (getIndexOfType(type) == -1) {
			return false;
		}

		return true;
	}

	private int getIndexOfType(String type) {
		for (int i = 0; i < list.length; ++i) {
			if (list[i].equals(type)) {
				return i;
			}
		}

		return -1;
	}

	private void resize(int size) {
		int limit = 0;
		if (size > list.length) {
			limit = list.length;
		} else {
			limit = size;
		}
		String[] buffer = new String[size];
		System.arraycopy(list, 0, buffer, 0, limit);
		list = buffer;
	}

	public String[] getList() {
		return list;
	}

	public void setList(String[] list) {
		this.list = list;
	}

}
