package com.lti.model;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="saving_table")
@DiscriminatorValue("saving")
public class Saving extends Account{
	private int roi;

	public int getRoi() {
		return roi;
	}

	public void setRoi(int roi) {
		this.roi = roi;
	}

	public Saving(int roi) {
		super();
		this.roi = roi;
	}

	

	
	

	public Saving(int accountId, String accountHolder, double accountBalance,int roi) {
		super(accountId, accountHolder, accountBalance);
		this.roi = roi;
	}

	@Override
	public String toString() {
		return "Saving [roi=" + roi + "]";
	}
	
}
