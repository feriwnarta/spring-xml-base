package com.ferdev.belajar.spring.baru.service.impl;

import com.ferdev.belajar.spring.baru.domain.Account;
import com.ferdev.belajar.spring.baru.repository.AccountRepository;
import com.ferdev.belajar.spring.baru.service.AccountService;

import java.math.BigDecimal;

public class AccounServiceImpl implements AccountService {
    private AccountRepository accountRepository;

    @Override
    public void transfer(Long source, Long target, BigDecimal balance) {
        Account send = accountRepository.find(source); // ambil objek account pengirim
        Account save = accountRepository.find(target); // ambil objek account penerima

        // logic merubah balance account pengirim dan penerima
        // mengurangi balance pengirim
        send.setBalance(send.getBalance().subtract(balance));
        // menambah balance penerima
        save.setBalance(save.getBalance().add(balance));

        // update perubahan kedatabase
        accountRepository.update(send);
        accountRepository.update(save);

    }

    @Override
    public Account getById(Long id) {
        return accountRepository.find(id);
    }

    public AccountRepository getAccountRepository() {
        return accountRepository;
    }

    public void setAccountRepository(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
}
