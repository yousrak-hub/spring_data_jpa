package com.training.springdata;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.training.springdata.service.BankAccountService;

@SpringBootTest
public class BankAccountServiceTest {

	@Autowired
	private BankAccountService bankAccountService;

	@Test
	public void testTransfer() {
		bankAccountService.transfer(300);
	}
}
