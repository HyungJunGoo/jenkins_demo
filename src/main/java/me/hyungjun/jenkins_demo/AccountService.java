package me.hyungjun.jenkins_demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public Account enrollAccount(EnrollForm enrollForm) {

        Account newAccount = Account.builder()
                .email(enrollForm.getEmail())
                .password(enrollForm.getPassword()).build();

        return accountRepository.save(newAccount);
    }
}
