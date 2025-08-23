package com.eazybytes.accounts.service;

import com.eazybytes.accounts.dto.CustomerDTO;

public interface IAccountsService {

    void createAccount(CustomerDTO customerDTO);
    CustomerDTO fetchAccount(String mobileNumber);
    boolean updateAccount(CustomerDTO customerDto);
    boolean deleteAccount(String mobileNumber);
}
