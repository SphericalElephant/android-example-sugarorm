package com.sphericalelephant.example.sugarorm.entity;

import com.orm.SugarRecord;

import java.util.Date;

/**
 * Created by siyb on 30/09/15.
 *
 * Please check Person for an explanation
 */
public class AccessCard extends SugarRecord<AccessCard> {
	private Date expirationDate;

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
}
