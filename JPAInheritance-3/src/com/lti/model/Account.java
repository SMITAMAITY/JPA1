package com.lti.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="account_table")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="account_type")
public class Account implements Serializable {
	@Id
	@Column(name="account_number")
	private int accountId;
	@Column(name="account_holder")
	private String accountHolder;
	@Column(name="account_balance")
	private double accountBalance;
	public Account() {
		
	}
	public Account(int accountId, String accountHolder, double accountBalance) {
		super();
		this.accountId = accountId;
		this.accountHolder = accountHolder;
		this.accountBalance = accountBalance;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getAccountHolder() {
		return accountHolder;
	}
	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountHolder=" + accountHolder + ", accountBalance="
				+ accountBalance + "]";
	}
	

}
