public class ObjectTest {
	public static void main(String[] args) {
		final Object one = new Object();
		final Object two = new Object();
		final boolean[] oneDone = new boolean[] {false};

		Thread oneThread = new Thread(new Runnable() {
			public void run() {
				synchronized(one) {
					try {
						System.out.println(Thread.currentThread().getName()+": working");
						Thread.currentThread().sleep(1000);
						oneDone[0] = true;
						System.out.println(Thread.currentThread().getName()+": done ...notifing");
						one.notify();
					} catch(InterruptedException e) {
						System.out.println(Thread.currentThread().getName()+": interrupted.");
					}
				}
			}
		});


		Thread twoThread = new Thread(new Runnable() {
			public void run() {
				synchronized(two) {
					synchronized(one) {
						try {
							while(!oneDone[0]) {
								System.out.println(Thread.currentThread().getName()+": one not done wait");
								one.wait(10, 10);
								System.out.println(Thread.currentThread().getName()+": one done exit");
							}
						} catch(InterruptedException e) {
							System.out.println(Thread.currentThread().getName()+": interrupted.");
						}
					}
				}
			}
		});

		twoThread.start();

		oneThread.start();


	}
}