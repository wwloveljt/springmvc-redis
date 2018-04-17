package com.zhanhongit.mq;

import lombok.extern.log4j.Log4j;

@Log4j
public class Producter_admin {

	public static void main(String[] args) {
		Producter producter = new Producter();
		producter.init();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Thread 1
		new Thread(new ProductorMq(producter)).start();
		// Thread 2
		new Thread(new ProductorMq(producter)).start();
		// Thread 3
		new Thread(new ProductorMq(producter)).start();
		// Thread 4
		new Thread(new ProductorMq(producter)).start();
		// Thread 5
		new Thread(new ProductorMq(producter)).start();
	}
}

class ProductorMq implements Runnable {
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