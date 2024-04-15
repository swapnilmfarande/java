package com.example.banking_app_002.Model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long account_numer;

    private String acc_holder_name;
    private double account_balance;
}
