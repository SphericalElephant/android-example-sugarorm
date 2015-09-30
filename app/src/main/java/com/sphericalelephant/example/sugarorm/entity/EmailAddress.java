package com.sphericalelephant.example.sugarorm.entity;

import com.orm.SugarRecord;

/**
 * Created by siyb on 30/09/15.
 *
 * Please check Person for an explanation
 */
public class EmailAddress extends SugarRecord<EmailAddress> {
	private String address;
	private Person person;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}
