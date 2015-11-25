package com.defysope.controller;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;

@Controller
public class EmailUtils {
	
	@Autowired
	ApplicationContext applicationContext;
	
	public void sendEmail (String subject,  String body) {
		System.out.println("applicationContext >>> "+applicationContext);
		JavaMailSenderImpl mailSender = applicationContext.getBean(JavaMailSenderImpl.class);
		System.out.println("applicationContext >>>222 ");
		
		
		   MimeMessage mimeMessage = mailSender.createMimeMessage();
	      	   MimeMessageHelper mailMsg = new MimeMessageHelper(mimeMessage);
	      	   try {
	/*			mailMsg.setFrom("hellotoall87@gmail.com");
		      	   mailMsg.setTo("yogeshniclucky@gmail.com");*/
		      	   mailMsg.setSubject(subject);
		      	   mailMsg.setText(body);
			} catch (MessagingException e) {
				e.printStackTrace();
			}

		   mailSender.send(mimeMessage);
	}
}
