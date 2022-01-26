package com.revature.models;

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
@Table(name="accounts")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="account_id")
	private int id;
	
//	@Column(unique= true,nullable=false)
//	private int accnout_num;
	private String account_type;
	private double balance;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id_fk",referencedColumnName="user_id")
	public User user;
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(int id, String account_type, double balance, User user) {
		super();
		this.id = id;
		//this.accnout_num = accnout_num;
		this.account_type = account_type;
		this.balance = balance;
		this.user = user;
	}
	public Account(String account_type, double balance, User user) {
		super();
		//this.accnout_num = accnout_num;
		this.account_type = account_type;
		this.balance = balance;
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
//	public int getAccnout_num() {
//		return accnout_num;
//	}
//	public void setAccnout_num(int accnout_num) {
//		this.accnout_num = accnout_num;
//	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", account_type=" + account_type + ", balance="
				+ balance + ", user=" + user + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + accnout_num;
		result = prime * result + ((account_type == null) ? 0 : account_type.hashCode());
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Account other = (Account) obj;
		
		if (account_type == null) {
			if (other.account_type != null)
				return false;
		} else if (!account_type.equals(other.account_type))
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (id != other.id)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
}