package com.training.springdata.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.training.springdata.entities.CreditAccount;
import com.training.springdata.entities.DebitAccount;

@SpringBootTest
public class AccountRepositoryTest {

	@Autowired
	private AccountRepository accountRepository;
	
	@Test
	public void testCreateDebitAccount() {
		CreditAccount account = new CreditAccount();
        account.setBalance(10000.0);
        account.setOwner("Ramesh");
        account.setCreditLimit(10000.0);
        accountRepository.save(account);
	}
	
	@Test
	public void testCreateCreditAccount() {
		DebitAccount debitAccount = new DebitAccount();
        debitAccount.setBalance(10000.0);
        debitAccount.setOwner("Ramesh");
        debitAccount.setOverdraftFee(100.0);
        accountRepository.save(debitAccount);
	}
	
}
