package com.kh.portfolio.common.svc;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // : final멤버필드를 생성자 매개변수로 생성
//@AllArgsConstructor    // : 모든 멤버필드를 생성자 매개변수로 생성
//@NoArgsConstructor     // : 디폴트생성자 생성
public class MailService {

	private final JavaMailSender mailSender;
	private final SimpleMailMessage simpleMessage;	
	
	private final String from = "worlfdl6920@gmail.com";
	/**
	 * 메일전송
	 * @param to  : 수신자
	 * @param subject : 제목
	 * @param body : 본문
	 */
	public void sendMail(String to, String subject, String body) {
		MimeMessage message = mailSender.createMimeMessage();
		
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message,true,"UTF-8");
			messageHelper.setSubject(subject);
			messageHelper.setTo(to);
			messageHelper.setFrom(from);
			messageHelper.setText(body,true);
			mailSender.send(message);
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * 고정 메세지 보낼경우
	 * @param message : 본문
	 */
	public void sendSimpleMail(String message) {
		simpleMessage.setText(message);
		mailSender.send(simpleMessage);
		
	}	
}










