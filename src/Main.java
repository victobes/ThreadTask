import java.util.Scanner;

public class Main extends Thread {

	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner (System.in);
		System.out.println("¬ведите число потоков");
		int n = sc.nextInt();
		TestThread[] t = new TestThread[n];
		for (int i = 0; i<n; i++) {
			t[i] = new TestThread(String.valueOf(n));
			test("Thread "+ String.valueOf(i));
			t[i].start();
			Thread.sleep(1500);
			t[i].work = false;
			t[i].join();
		}
		
		/*TestThread t1 = new TestThread("*");
		TestThread t2 = new TestThread("+");
		t1.start();
		t2.start();
		Thread.sleep(500);
		t1.work = false;
		t1.join();
		test("Stopped");
		*/
	}

	static Object monitor = new Object();

	public static void test(String message) {
		try {
			synchronized (monitor) {
				System.out.print("[");
				Thread.sleep(1000);
				System.out.print(message);
				Thread.sleep(1000);
				System.out.print("]");
			}
		} catch (InterruptedException e) {

		}
	}
}
