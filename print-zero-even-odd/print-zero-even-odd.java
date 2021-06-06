class ZeroEvenOdd {
    
	private int n;
	private int cur;
	boolean zero = true;
	boolean even = false;
	boolean odd = false;

	public ZeroEvenOdd(int n) {
		this.n = n;
		this.cur = 1;
	}

	// printNumber.accept(x) outputs "x", where x is an integer.
	public synchronized void zero(IntConsumer printNumber) throws InterruptedException {
		while (cur <= n) {
			if (!zero) {
				wait();
				continue;
			}
			printNumber.accept(0);
			zero = false;
			
            if (cur % 2 != 0)
				odd = true;
			else
				even = true;
            
			notifyAll();
		}
	}

	public synchronized void even(IntConsumer printNumber) throws InterruptedException {
		while (cur <= n) {
			if (!even) {
				wait();
				continue;
			}
			printNumber.accept(cur);
			
			cur += 1;
            zero = true;
			even = false;
			notifyAll();
		}
	}

	public synchronized void odd(IntConsumer printNumber) throws InterruptedException {

		while (cur <= n) {
			if (!odd) {
				wait();
				continue;
			}
			printNumber.accept(cur);
			
			cur += 1;
            zero = true;
			odd = false;
			notifyAll();
		}
	
	}

}