package com.sanchezc.minibank.accountservice.model;

import java.util.List;

import com.sanchezc.minibank.customerservice.model.Customer;
import com.sanchezc.minibank.transactionservice.model.Transaction;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Account {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 @ManyToOne
 @JoinColumn(name = "customer_id", nullable = false)
 private Customer customer;

 private Double balance;

 @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
 private List<Transaction> transactions;




}
