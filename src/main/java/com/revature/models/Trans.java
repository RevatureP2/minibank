package com.revature.models;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="trans")
public class Trans {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="trans_id")
	private int id;
	private double trans_amount;
	private java.sql.Date transdate;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "sender_id_fk",referencedColumnName="account_id")

	public Account sender;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "receiver_id_fk",referencedColumnName="account_id")

	public Account receiver;
	
	public Trans(double trans_amount, Date transdate, Account sender, Account receiver) {
		super();
		this.trans_amount = trans_amount;
		this.transdate = transdate;
		this.sender = sender;
		this.receiver = receiver;
	}
	
	public Trans(int id, double trans_amount, Date transdate, Account sender, Account receiver) {
		super();
		this.id = id;
		this.trans_amount = trans_amount;
		this.transdate = transdate;
		this.sender = sender;
		this.receiver = receiver;
	}
	
	public Trans(Account sender) {
		super();
		this.sender = sender;
	}
	
	public Trans() {
		super();
		// TODO Auto-generated constructor stub
	}
//	public Trans(int id, double trans_amount, Account sender, Account receiver) {
//		super();
//		this.id = id;
//		this.trans_amount = trans_amount;
//		this.sender = sender;
//		this.receiver = receiver;
//	}
//	public Trans(double trans_amount, Account sender, Account receiver) {
//		super();
//		this.trans_amount = trans_amount;
//		this.sender = sender;
//		this.receiver = receiver;
//	}
	
	public java.sql.Date getTransdate() {
		return transdate;
	}
	public void setTransdate(java.sql.Date transdate) {
		this.transdate = transdate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getTrans_amount() {
		return trans_amount;
	}
	public void setTrans_amount(double trans_amount) {
		this.trans_amount = trans_amount;
	}
	public Account getSender() {
		return sender;
	}
	public void setSender(Account sender) {
		this.sender = sender;
	}
	public Account getReceiver() {
		return receiver;
	}
	public void setReceiver(Account receiver) {
		this.receiver = receiver;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((receiver == null) ? 0 : receiver.hashCode());
		result = prime * result + ((sender == null) ? 0 : sender.hashCode());
		long temp;
		temp = Double.doubleToLongBits(trans_amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((transdate == null) ? 0 : transdate.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trans other = (Trans) obj;
		if (id != other.id)
			return false;
		if (receiver == null) {
			if (other.receiver != null)
				return false;
		} else if (!receiver.equals(other.receiver))
			return false;
		if (sender == null) {
			if (other.sender != null)
				return false;
		} else if (!sender.equals(other.sender))
			return false;
		if (Double.doubleToLongBits(trans_amount) != Double.doubleToLongBits(other.trans_amount))
			return false;
		if (transdate == null) {
			if (other.transdate != null)
				return false;
		} else if (!transdate.equals(other.transdate))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Trans [id=" + id + ", trans_amount=" + trans_amount + ", transdate=" + transdate + ", sender=" + sender
				+ ", receiver=" + receiver + "]";
	}
	
	
	
}
