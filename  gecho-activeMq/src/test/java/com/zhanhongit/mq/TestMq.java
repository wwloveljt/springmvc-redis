package com.zhanhongit.mq;

import org.junit.Test;

public class TestMq {
	@Test
	public void testProduct() {
		Producter producter = new Producter();
		producter.init();

		TestMq testMq = new TestMq();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Thread 1
		new Thread(testMq.new ProductorMq(producter)).start();
		// Thread 2
		new Thread(testMq.new ProductorMq(producter)).start();
		// Thread 3
		new Thread(testMq.new ProductorMq(producter)).start();
		// Thread 4
		new Thread(testMq.new ProductorMq(producter)).start();
		// Thread 5
		new Thread(testMq.new ProductorMq(producter)).start();
	}

	@Test
	public void testConsumer() {
		Consumer comsumer = new Consumer();
		comsumer.init();
		new Thread(new ConsumerMq(comsumer)).start();
		new Thread(new ConsumerMq(comsumer)).start();
		new Thread(new ConsumerMq(comsumer)).start();
		new Thread(new ConsumerMq(comsumer)).start();
	}

	private class ConsumerMq implements Runnable {
		Consumer comsumer;

		public ConsumerMq(Consumer comsumer) {
			this.comsumer = comsumer;
		}

		@Override
		public void run() {
			while (true) {
				try {
					comsumer.getMessage("Jaycekon-MQ");
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private class ProductorMq implements Runnable {
		Producter producter;

		public ProductorMq(Producter producter) {
			this.producter = producter;
		}

		@Override
		public void run() {
			while (true) {
				try {
					producter.sendMessage("Jaycekon-MQ");
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
