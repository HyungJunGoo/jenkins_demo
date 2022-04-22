package me.hyungjun.jenkins_demo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JenkinsDemoApplicationTests {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;

    @AfterEach
    void cleanUpEach() {
        accountRepository.deleteAll();
    }

    @Test
    @DisplayName("회원 등록 테스트")
    void testEnrollAccount() {

        EnrollForm enrollForm = new EnrollForm();
        enrollForm.setEmail("example@email.com");
        enrollForm.setPassword("password111");

        Account account = accountService.enrollAccount(enrollForm);


        Assertions.assertEquals(1, accountRepository.findAll().size());

    }

    @Test
    @DisplayName("회원 등록 테스트2")
    void testEnrollAccount2() {

        EnrollForm enrollForm = new EnrollForm();
        enrollForm.setEmail("example@email.com");
        enrollForm.setPassword("password111");

        EnrollForm enrollForm2 = new EnrollForm();
        enrollForm.setEmail("example2@email.com");
        enrollForm.setPassword("password111");

        Account account = accountService.enrollAccount(enrollForm);
        Account account2 = accountService.enrollAccount(enrollForm2);


        Assertions.assertEquals(1, accountRepository.findAll().size());

    }

}
