package Practice_Package;

import org.testng.annotations.Test;

public class ThreadCountEx2 {
	@Test
	public void thread1() {
		System.out.println("Thread Id 1"+Thread.currentThread().getId());

	}
	@Test
	public void thread2() {
		System.out.println("Thread Id 2"+Thread.currentThread().getId());

	}
	@Test
	public void thread3() {
		System.out.println("Thread Id 3"+Thread.currentThread().getId());

	}
	@Test
	public void thread4() {
		System.out.println("Thread Id 4"+Thread.currentThread().getId());
	}
	@Test
	public void thread5() {
		System.out.println("Thread Id 5"+Thread.currentThread().getId());

	}
}
