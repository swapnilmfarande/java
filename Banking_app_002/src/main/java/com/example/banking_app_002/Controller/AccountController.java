package com.example.banking_app_002.Controller;

import com.example.banking_app_002.Model.Account;
import com.example.banking_app_002.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService service;

    @PostMapping("/create")
    public Account createAccount(@RequestBody Account account){
        Account createAcc = service.createAccount(account);
        return createAcc;
    }

    @GetMapping("/{accountNumber}")
    public Account getAccountByAccNo(@PathVariable  Long accountNumber){
        Account account=service.getAccountByAccNo(accountNumber);
        return account;
    }

    @GetMapping("/getallaccounts")
    public List<Account> getAllAccount(){
        List<Account> allaccounts=service.getAllAccount();
        return allaccounts;
    }

    @PutMapping("/deposit/{accountNumber}/{amount}")
    public Account depositAmount(@PathVariable Long accountNumber,@PathVariable Double amount){
        Account account=service.depositAmount(accountNumber,amount);
        return account;
    }

    @PutMapping("/withdrwa/{accountNumber}/{amount}")
    public Account withdrwaAmount(@PathVariable Long accountNumber,@PathVariable Double amount){
       Account account= service.withdrwaAmount(accountNumber,amount);
       return account;
    }

    @DeleteMapping("/delete/{accountNumber}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long accountNumber){
        service.closeAccount(accountNumber);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Account Closed");
    }


}
