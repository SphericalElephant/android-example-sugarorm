package com.sphericalelephant.example.sugarorm.entity;

import com.orm.SugarRecord;
import com.orm.dsl.Ignore;

import java.util.Date;

/**
 * Created by siyb on 30/09/15.
 */
public class Person extends SugarRecord<Person> {
	@Ignore
	private boolean ignored;
	private String name;
	private Date birthday;
	private int height;
	// this is everything we need to define a relationship, unfortunately, Many-To-Many and One-To-Many are not supported yet m(
	// https://github.com/satyan/sugar/issues/60
	private EmailAddress email;
	// accesscard relationship (To-One)
	private AccessCard accessCard;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public EmailAddress getEmail() {
		return email;
	}

	public void setEmail(EmailAddress email) {
		this.email = email;
	}

	public AccessCard getAccessCard() {
		return accessCard;
	}

	public void setAccessCard(AccessCard accessCard) {
		this.accessCard = accessCard;
	}
}
