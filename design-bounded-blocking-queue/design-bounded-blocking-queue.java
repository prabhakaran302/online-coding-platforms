class BoundedBlockingQueue {

    

	private Queue<Integer> queue;
	private int size;

	public BoundedBlockingQueue(int capacity) {
		queue = new LinkedList<>();
		size = capacity;
	}

	public void enqueue(int element) throws InterruptedException {
		synchronized (queue) {
			while (queue.size() == size) {
				queue.wait();
			}
		}

		synchronized (queue) {
			queue.add(element);
			queue.notifyAll();
		}
	}

	public int dequeue() throws InterruptedException {
		synchronized (queue) {
			while (queue.size() == 0) {
				queue.wait();
			}
		}

		synchronized (queue) {
			int ele = queue.remove();
			queue.notifyAll();
			return ele;
		}
	}

	public int size() {
		return queue.size();
	}

}