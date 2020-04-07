package com.rokib.springSecurityJpaAuthentication.rest;

import com.rokib.springSecurityJpaAuthentication.dto.account.request.SignUpCommand;
import com.rokib.springSecurityJpaAuthentication.service.contract.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;

@RestController
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


    @GetMapping(path = "/")
    public ResponseEntity<HashMap<String, String>> basePath() {
        HashMap<String, String> baseMap = new HashMap<>();
        baseMap.put("HI", "I AM BASE PATH");
        return ResponseEntity.ok().body(baseMap);
    }


    @PostMapping(path = "/account/signUp")
    public ResponseEntity<?> signUp(@Valid @RequestBody SignUpCommand signUpCommand) {
        accountService.createUser(
                signUpCommand.getFirstName(),
                signUpCommand.getLastName(),
                signUpCommand.getEmailAddress(),
                signUpCommand.getPassword()
        );
        return ResponseEntity
                .created(null)
                .body(null);
    }
}
