package com.cts.swing.test.mouse;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class TestClass {

	public static void main(String... args) throws AWTException, InterruptedException {
		PointerInfo a = MouseInfo.getPointerInfo();
		Point b = a.getLocation();
		int x = (int) b.getX();
		int y = (int) b.getY();
		Robot r = new Robot();

		System.out.println(" x " + x + " y" + y);

		Thread.sleep(3000);

		while (true) {
			// r.mouseMove( 1095, 518);
			// r.mousePress(InputEvent.BUTTON1_MASK);
			// r.mouseRelease(InputEvent.BUTTON1_MASK);
			// r.mouseMove(513, 599);

			// Thread.sleep(5000);HELLO
			r.keyPress(KeyEvent.VK_ESCAPE);
			Thread.sleep(3000);
			printHelloGreek();

			// r.mouseMove(513, 599);
			// Thread.sleep(3000);
			// r.mousePress(InputEvent.BUTTON1_MASK);
		}
	}

	public static void printHelloGreek() throws InterruptedException, AWTException {
		Robot robot = new Robot();
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_CAPS_LOCK);
		robot.keyRelease(KeyEvent.VK_CAPS_LOCK);
		robot.keyPress(KeyEvent.VK_H);
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_E);
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_L);
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_L);
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_O);
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_SPACE);
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_F);
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_R);
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_O);
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_M);
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_SPACE);
		robot.keyPress(KeyEvent.VK_SPACE);
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_L);
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_A);
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_K);
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_S);
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_H);
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_Y);
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_A);
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_SPACE);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(500);
	}
}

