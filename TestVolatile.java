package com.egan.matt;

public class TestVolatile {

	// private static volatile double volatileField ;
	private static volatile int volatileField ;

	private static final int MAX_THREADS = 100000;

	public static void main(String[] args) {

		System.out.println("main starts");
		
		Thread[] thrArray = new Thread[MAX_THREADS];

		for (int i=0; i<MAX_THREADS; i++) {
			thrArray[i] = new Thread(
					() -> { volatileField++ ; }
					);
		}

		for (Thread thr: thrArray) 
			thr.start();

		try {
		for (Thread thr: thrArray) 
			thr.join();
		} catch (InterruptedException iEx) {
			iEx.printStackTrace();
		}

		System.out.println("final value of volatileField is " + volatileField); 
		
		System.out.println("main ends");
		
	}


}

