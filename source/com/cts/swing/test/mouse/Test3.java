package com.cts.swing.test.mouse;

import java.util.List;

public class Test3 extends Thread{
	 
	public static void main(String[] args) {
		Test3 t3 = new Test3();
		Thread t = new Thread(t3);
		t.start();
		t.isAlive();
	}
	
	public void run() {
		for(int i = 0; i< 3; i++) {
			System.out.println( ".." + i);
		}
	}
	
}

