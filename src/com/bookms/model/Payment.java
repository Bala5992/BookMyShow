package com.bookms.model;

import java.time.LocalDate;

import com.bookms.enumeration.PaymentStatus;

public class Payment {
	public int transactionId;
	public double amount;
	public LocalDate paymentDate;
	public PaymentStatus paymentStatus;
}
