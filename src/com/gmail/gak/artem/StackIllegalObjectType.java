package com.gmail.gak.artem;

public class StackIllegalObjectType extends Exception {
	
	static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Illegal Object Type";
	}
}
