package com.sanchezc.minibank.transaction.model;

import java.time.LocalDateTime;

import com.sanchezc.minibank.account.model.Account;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "account_id", nullable = false)
	private Account account;

	private Double amount;

	private LocalDateTime transactionDate;
	
	@Enumerated(EnumType.STRING)
	private TransactionType type;

	@ManyToOne
	@JoinColumn(name = "destination_account_id")
	private Account destinationAccount;
}