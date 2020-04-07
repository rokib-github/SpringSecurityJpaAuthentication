package com.rokib.springSecurityJpaAuthentication.service.impl;

import com.rokib.springSecurityJpaAuthentication.persistence.entity.User;
import com.rokib.springSecurityJpaAuthentication.persistence.repository.UserRepository;
import com.rokib.springSecurityJpaAuthentication.service.contract.AccountService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AccountServiceImpl implements AccountService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRepository userRepository;

    public AccountServiceImpl(
            BCryptPasswordEncoder bCryptPasswordEncoder,
            UserRepository userRepository) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void createUser(String firstName, String lastName, String emailAddress, String password) {

        User user = new User();
        user.setUserDisplayName(firstName + " " + lastName);
        user.setUserName(emailAddress);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        user.setActive(true);

        userRepository.save(user);
    }
}
