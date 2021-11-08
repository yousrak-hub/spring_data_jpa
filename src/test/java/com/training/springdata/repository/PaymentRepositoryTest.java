package com.training.springdata.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.training.springdata.entities.Check;
import com.training.springdata.entities.CreditCard;

@SpringBootTest
public class PaymentRepositoryTest {

	@Autowired
	PaymentRepository paymentRepository;

	@Test
	public void testCreatePayment() {
		CreditCard creditCard = new CreditCard();
		creditCard.setAmount(1000);
		creditCard.setCardnumber("12345678");
		paymentRepository.save(creditCard);
	}
	@Test
	public void testCreateCheckPayment() {
		Check check = new Check();
		check.setAmount(1000);
		check.setChecknumber("123456780");
		paymentRepository.save(check);
	}
}
