package com.mehdi.BankingBackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
@NoArgsConstructor
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @JsonProperty("email")
    private String email;

    @Column(nullable = false)
    @JsonProperty("password")
    private String password;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Account> accounts = new ArrayList<>();
}
