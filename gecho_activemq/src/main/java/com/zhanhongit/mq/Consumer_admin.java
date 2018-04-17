package com.zhanhongit.mq;

public class Consumer_admin {
	public static void main(String[] args) {
		Consumer comsumer = new Consumer();
		comsumer.init();
		new Thread(new ConsumerMq(comsumer)).start();
		new Thread(new ConsumerMq(comsumer)).start();
		new Thread(new ConsumerMq(comsumer)).start();
		new Thread(new ConsumerMq(comsumer)).start();
	}
}

class ConsumerMq implements Runnable {
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