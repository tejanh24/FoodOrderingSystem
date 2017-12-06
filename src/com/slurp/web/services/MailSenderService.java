package com.slurp.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.slurp.web.dao.model.User;

@Service
public class MailSenderService implements Runnable {

	@Autowired
	private MailSender mailSender;
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		sendMail(user);
	}

	public void sendMail(User user) {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setFrom("teja.nh24@gmail.com");
		mail.setTo(user.getUsername());
		mail.setSubject("Welcome To SLURP!!!");
		mail.setText("Dear " + user.getFirstName() + " " + user.getLastName() + ","
				+ "\n\nWe are excited to have you on SLURP.\n\n\n" + "Thank You, \nTeam Slurp.");

		try {
			mailSender.send(mail);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Can't send message");
		}
	}

}
