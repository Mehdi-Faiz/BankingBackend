package com.mehdi.BankingBackend.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class CustomerDTO {
    private long id;
    private String email;
    private List<AccountDTO> accounts;
}
