package com.encl.accounts.service;

import com.encl.accounts.dto.CustomerDTO;

public interface IAccountsService {

    void createAccount(CustomerDTO customerDTO);
    CustomerDTO fetchAccount(String mobileNumber);
    boolean updateAccount(CustomerDTO customerDto);
    boolean deleteAccount(String mobileNumber);
}
