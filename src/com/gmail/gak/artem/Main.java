package com.gmail.gak.artem;

public class Main {

	public static void main(String[] args) {
		
		
		Stack stack = new Stack(4, new StackBlackList());
		stack.denyType("Integer");
		
//		try {
//			stack.push(new Integer(10));
//		} catch(StackIllegalObjectType | StackOverflowException e) {
//			throw new Error(e.getMessage());
//		}
		
		StackBlackList bList = new StackBlackList();
		bList.add("String");
		stack.setbList(bList);
		
		System.out.println(stack.isDenyType(new String()));
		
		try {
			stack.push(new Integer(10));
			stack.push(new Integer(20));
			stack.push(new Integer(30));
			stack.push(new Integer(40));
			stack.setSize(10);
			stack.push(new Integer(50));
			stack.push(new Integer(60));
			stack.setTopIndex(2);
			stack.push(new Integer(70));
			stack.push(new Integer(80));
			
		} catch(StackIllegalObjectType | StackOverflowException e) {
			throw new Error(e.getMessage());
		}
		
		System.out.println(stack.toString());
	}
}
