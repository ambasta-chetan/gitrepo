package com.informatica.test;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadRunner {

	public static void main(String[] args) {

		AtomicInteger number=new AtomicInteger(2);
		int maxValue=100;
		Thread t2=new Thread(new NumberTask(number, maxValue, 2));
		Thread t3=new Thread(new NumberTask(number, maxValue, 3));
		Thread t5=new Thread(new NumberTask(number, maxValue, 5));
		t2.start();
		t3.start();
		t5.start();
	}

}
