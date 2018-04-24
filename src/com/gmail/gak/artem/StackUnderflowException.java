package com.gmail.gak.artem;

public class StackUnderflowException extends Exception {
	
	static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Stack Underflow";
	}
}
