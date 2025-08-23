package com.eazybytes.accounts.service.impl;

import com.eazybytes.accounts.constants.AccountsConstants;
import com.eazybytes.accounts.dto.AccountsDTO;
import com.eazybytes.accounts.dto.CustomerDTO;
import com.eazybytes.accounts.entity.Accounts;
import com.eazybytes.accounts.entity.Customer;
import com.eazybytes.accounts.exception.CustomerAlreadExistsException;
import com.eazybytes.accounts.exception.ResourceNotFoundException;
import com.eazybytes.accounts.mapper.AccountsMapper;
import com.eazybytes.accounts.mapper.CustomerMapper;
import com.eazybytes.accounts.repository.AccountsRepository;
import com.eazybytes.accounts.repository.CustomerRepository;
import com.eazybytes.accounts.service.IAccountsService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor //no reason to explicitly autowire as there is only one constructor
public class AccountServiceImpl implements IAccountsService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomerDTO customerDTO) {
        Customer customer = CustomerMapper.mapToCustomer(customerDTO, new Customer());
        //Perform validation to check if customer already exists
        Optional<Customer> savedCustomer = customerRepository.findByMobileNumber(customerDTO.getMobileNumber());
        if(savedCustomer.isPresent()) {
            throw new CustomerAlreadExistsException("Customer with mobile number "+customerDTO.getMobileNumber()+" already exists");
        }
        //And save it
        Customer saedDetail =customerRepository.save(customer);
        accountsRepository.save(createNewAccount(saedDetail));
    }



    @Override
    public CustomerDTO fetchAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber));
        Accounts account =  accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString()));
        CustomerDTO customerDTO = CustomerMapper.mapToCustomerDto(customer, new CustomerDTO());
        customerDTO.setAccountsDTO(AccountsMapper.mapToAccountsDto(account, new AccountsDTO()));
        return customerDTO;
    }

    @Override
    public boolean updateAccount(CustomerDTO customerDto) {
        boolean updated = false;
        AccountsDTO accountsDTO = customerDto.getAccountsDTO();
        if (accountsDTO != null) {
            Accounts accounts = accountsRepository.findById(accountsDTO.getAccountNumber()).orElseThrow(
                    () -> new ResourceNotFoundException("Accounts", "id not found", accountsDTO.getAccountNumber().toString()));
            AccountsMapper.mapToAccounts(accountsDTO, accounts);
            accounts = accountsRepository.save(accounts);

            Long customerId = accounts.getCustomerId();
            Customer customer = customerRepository.findById(customerId).orElseThrow(
                    () ->  new ResourceNotFoundException("Customer", "id not found", customerId.toString())
            );
            CustomerMapper.mapToCustomer(customerDto, customer);
            //in both cases the JPA save will perform an update if the ID has been used and an insert if it is not present
            customerRepository.save(customer);
            updated = true;
        }
        return updated;

    }

    @Override
    public boolean deleteAccount(String mobileNumber) {
        //find the customer
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobile number not found", mobileNumber)
        );
        accountsRepository.deleteByCustomerId(customer.getCustomerId());
        customerRepository.deleteById(customer.getCustomerId());
        return true;
    }

    /**
     * @param customer - Customer Object
     * @return the new account details
     */
    private Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        return newAccount;
    }

}
