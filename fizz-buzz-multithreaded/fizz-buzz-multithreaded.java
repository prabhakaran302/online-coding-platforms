class FizzBuzz {

	
	
	
	private int n;
	private int cur;

	public FizzBuzz(int n) {
		this.n = n;
		this.cur = 1;
	}

	// printFizz.run() outputs "fizz".
	public synchronized void fizz(Runnable printFizz) throws InterruptedException {
		while (cur <= n) {
			if (cur % 3 != 0 || cur % 5 == 0) {
				wait();
				continue;
			}
			printFizz.run();
			cur += 1;
			notifyAll();
		}

	}

	// printBuzz.run() outputs "buzz".
	public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
		while (cur <= n) {
			if (cur % 5 != 0 || cur % 3 == 0) {
				wait();
				continue;
			}
			printBuzz.run();
			cur += 1;
			notifyAll();
		}

	}

	// printFizzBuzz.run() outputs "fizzbuzz".
	public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
		while (cur <= n) {
			if (cur % 15 != 0) {
				wait();
				continue;
			}
			printFizzBuzz.run();
			cur += 1;
			notifyAll();
		}

	}

	// printNumber.accept(x) outputs "x", where x is an integer.
	public synchronized void number(IntConsumer printNumber) throws InterruptedException {

		while (cur <= n) {
			if (cur % 3 == 0 || cur % 5 == 0) {
				wait();
				continue;
			}
			printNumber.accept(cur);
			cur += 1;
			notifyAll();
		}

	}



}