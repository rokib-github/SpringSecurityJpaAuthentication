package com.rokib.springSecurityJpaAuthentication.service.contract;

public interface AccountService {

    void createUser(
            final String firstName,
            final String lastName,
            final String emailAddress,
            final String password);
}
