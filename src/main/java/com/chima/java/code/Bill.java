package com.chima.java.code;

public class Bill {
	final private Currency currency;
	final private int price;

	public Bill(final Currency currency, final int price) {
		this.currency = currency;
		this.price = price;
	}

	public Currency getCurrency() {
		return this.currency;
	}

	public int getPrice() {
		return this.price;
	}
}
