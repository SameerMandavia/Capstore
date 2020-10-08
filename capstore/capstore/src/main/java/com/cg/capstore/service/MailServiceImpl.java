package com.cg.capstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MailServiceImpl implements IMailService{

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Override
	public void sendMail(String to, String body,String topic) {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setFrom("capstore57@gmail.com");
		mail.setTo(to);
		mail.setSubject(topic);
		mail.setText(body);
		javaMailSender.send(mail);
		
	}

	
	
}
