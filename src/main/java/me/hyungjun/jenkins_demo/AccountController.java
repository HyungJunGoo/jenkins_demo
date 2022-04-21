package me.hyungjun.jenkins_demo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/account")
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<?> enrollAccount(EnrollForm enrollForm) {
        Account account = accountService.enrollAccount(enrollForm);

        return ResponseEntity.ok().body(account);
    }
}
