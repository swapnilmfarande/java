package com.example.banking_app_002.Repository;

import com.example.banking_app_002.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Long> {

}
