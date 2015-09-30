package com.sphericalelephant.example.sugarorm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.sphericalelephant.example.sugarorm.entity.AccessCard;
import com.sphericalelephant.example.sugarorm.entity.EmailAddress;
import com.sphericalelephant.example.sugarorm.entity.Person;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by siyb on 30/09/15.
 */
public class MainActivity extends AppCompatActivity {

	// a bunch of views used to bind data to
	private TextView userName;
	private TextView birthDay;
	private TextView height;
	private TextView expires;
	private TextView email;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mainactivity);

		// view bindings, nothing special happens here
		userName = (TextView) findViewById(R.id.activity_mainactivity_tv_username);
		birthDay = (TextView) findViewById(R.id.activity_mainactivity_tv_birthday);
		height = (TextView) findViewById(R.id.activity_mainactivity_tv_height);
		expires = (TextView) findViewById(R.id.activity_mainactivity_tv_expires);
		email = (TextView) findViewById(R.id.activity_mainactivity_tv_email);

		findViewById(R.id.activity_mainactivity_b_createuser).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Person p = getPerson();
				if (p == null) {
					p = createPerson();
				} else {
					Toast.makeText(MainActivity.this, R.string.activity_mainactivity_personexists, Toast.LENGTH_SHORT).show();
				}
				userName.setText(p.getName());
				birthDay.setText(p.getBirthday().toString());
				height.setText(String.valueOf(p.getHeight())); // int needs to be parsed to string, otherwise it will be used understood as a string id
				expires.setText(p.getAccessCard().getExpirationDate().toString());
				email.setText(p.getEmail().getAddress());
			}
		});
	}

	private Iterator<Person> getPersons() {
		return Person.findAll(Person.class);
	}

	private Person getPerson() {
		List<Person> p = Person.find(Person.class, "name = ?", "ExampleName");
		return p.size() == 0 ? null : p.get(0);
	}

	private EmailAddress createEmail(Person person) {
		EmailAddress emailAddress = new EmailAddress();
		emailAddress.setPerson(person);
		emailAddress.setAddress("test@test.com");

		emailAddress.save();
		return emailAddress;
	}

	private AccessCard createAccessCard() {
		Calendar cal = Calendar.getInstance();

		AccessCard accessCard = new AccessCard();
		accessCard.setExpirationDate(new Date(cal.getTimeInMillis()));

		accessCard.save();
		return accessCard;
	}

	private Person createPerson() {
		Calendar cal = Calendar.getInstance();

		Person person = new Person();
		person.setName("ExampleName");

		cal.set(1983, 10, 11);
		person.setBirthday(new Date(cal.getTimeInMillis()));
		person.setHeight(175);
		person.setAccessCard(createAccessCard());
		person.setEmail(createEmail(person));
		person.save();

		return person;
	}

}
