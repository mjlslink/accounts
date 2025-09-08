package com.encl.accounts.service.impl;

import com.encl.accounts.dto.AccountsDTO;
import com.encl.accounts.dto.CardsDto;
import com.encl.accounts.dto.CustomerDetailsDto;
import com.encl.accounts.dto.LoansDto;
import com.encl.accounts.entity.Accounts;
import com.encl.accounts.entity.Customer;
import com.encl.accounts.exception.ResourceNotFoundException;
import com.encl.accounts.mapper.AccountsMapper;
import com.encl.accounts.mapper.CustomerMapper;
import com.encl.accounts.repository.AccountsRepository;
import com.encl.accounts.repository.CustomerRepository;
import com.encl.accounts.service.ICustomersService;
import com.encl.accounts.service.client.CardsFeignClient;
import com.encl.accounts.service.client.LoansFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements ICustomersService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;
    private CardsFeignClient cardsFeignClient;
    private LoansFeignClient loansFeignClient;

    @Override
    public CustomerDetailsDto fetchCustomerDetails(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber));
        Accounts account =  accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString()));

        CustomerDetailsDto customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(customer, new CustomerDetailsDto());
        customerDetailsDto.setAccountsDTO(AccountsMapper.mapToAccountsDto(account, new AccountsDTO()));

        ResponseEntity<LoansDto> loansDtoResponseEntity = loansFeignClient.fetchCardDetails(mobileNumber);
        customerDetailsDto.setLoansDto(loansDtoResponseEntity.getBody());

        ResponseEntity<CardsDto> cardsDtoResponseEntity = cardsFeignClient.fetchCardDetails(mobileNumber);
        customerDetailsDto.setCardsDto(cardsDtoResponseEntity.getBody());

        return customerDetailsDto;
    }
}
