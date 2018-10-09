package com.cts.swing.test.mouse;


class a {
	
}

class b extends a {
	
}

class c extends b {
	
}


class TestOverride {
	
	private static int len;
	
	public static void Change(int[] numberGame) {
		numberGame[0] = 30;
		numberGame[1] = 40;
	}
	
	public static void Ref(int[] numberGame) {
		numberGame = new int[2];
		numberGame[0] = 10;
		numberGame[1] = 20;
	}
	
	
	public static void main(String[] args) {
		a obj = new b();
		
		System.out.println(obj instanceof b);
		System.out.println(obj instanceof c);
		
	}
	
}
