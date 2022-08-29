package dev.boscolo.hrpayroll.services;

import org.springframework.stereotype.Service;

import dev.boscolo.hrpayroll.entities.Payment;

@Service
public class PaymentService {

	public Payment getPayment(Long workerId, Integer days) {
		return new Payment("Bob",200.0,days);
	}
	
}
