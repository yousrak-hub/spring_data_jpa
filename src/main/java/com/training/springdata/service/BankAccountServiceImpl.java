package com.training.springdata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.training.springdata.entities.BankAccount;
import com.training.springdata.repository.BankAccountRepository;

@Service
public class BankAccountServiceImpl implements BankAccountService {

	@Autowired
	private BankAccountRepository bankAccountRepository;

	@Override
	@Transactional
	public void transfer(int amount) {

		BankAccount account = bankAccountRepository.findById(1).orElse(null);
		account.setBalance(account.getBalance() - amount);
		bankAccountRepository.save(account);
		if (true)
			throw new RuntimeException();
		BankAccount bankAccount = bankAccountRepository.findById(2).orElse(null);
		bankAccount.setBalance(bankAccount.getBalance() + amount);
		bankAccountRepository.save(bankAccount);

	}

}
