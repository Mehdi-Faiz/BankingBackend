package com.mehdi.BankingBackend.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Setter
public class CustomerCreateDTO {
    private String email;
    private String password;
}
