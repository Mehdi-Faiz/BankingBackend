package com.mehdi.BankingBackend.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class AccountDTO {
    private long id;
    private String accountNumber;
    private Double balance;
}
