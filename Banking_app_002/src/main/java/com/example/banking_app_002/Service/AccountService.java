package com.example.banking_app_002.Service;

import com.example.banking_app_002.Model.Account;
import com.example.banking_app_002.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    AccountRepository repository;

    public Account createAccount(Account account){
        Account account_saved =repository.save(account);
        return account_saved;
    }

    public Account getAccountByAccNo(Long accountNumber){
        Optional<Account> account= repository.findById(accountNumber);
        if (account.isEmpty()){
            throw new RuntimeException("account is not found");
        }
        Account account_found = account.get();
        return account_found;

    }

    public List<Account> getAllAccount(){
        List<Account> accountList=repository.findAll();
        return accountList;
    }


    public Account depositAmount(Long accountNumber, Double amount) {
       Optional<Account>account=repository.findById(accountNumber);
        if (account.isEmpty()){
            throw new RuntimeException("error");
        }
        Account account_present=account.get();
        Double totalBalance=account_present.getAccount_balance()+amount;
        account_present.setAccount_balance(totalBalance);
        repository.save(account_present);
        return account_present;
    }

    public Account withdrwaAmount(Long accountNumber, Double amount) {
        Optional<Account>account=repository.findById(accountNumber);
        if (account.isEmpty()){
            throw new RuntimeException("Account not present");
        }
        Account accountPresent=account.get();
        Double totalAmount=accountPresent.getAccount_balance()-amount;
        accountPresent.setAccount_balance(totalAmount);
        repository.save(accountPresent);
        return accountPresent;
    }

    public void closeAccount(Long accountNumber) {
        getAccountByAccNo(accountNumber);
        repository.deleteById(accountNumber);
    }
}
