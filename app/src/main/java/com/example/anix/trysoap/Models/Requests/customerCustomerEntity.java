package com.example.anix.trysoap.Models.Requests;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by anix on 26/10/16.
 */
@Root(name = customerCustomerEntity.ROOT_NAME, strict = false)
public class customerCustomerEntity {

	public static final String ROOT_NAME = "customerCustomerEntity";

	@Element
	private int customer_id;
	@Element
	private String email;
	@Element(required = false)
	private String firstname;
	@Element
	private String password_hash;

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getPassword_hash() {
		return password_hash;
	}

	public void setPassword_hash(String password_hash) {
		this.password_hash = password_hash;
	}

}
