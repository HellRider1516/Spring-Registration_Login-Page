package in.mahesh.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import in.mahesh.entity.Instrgram;

@Configuration
public class EmailSend {
	@Autowired
	private JavaMailSender sender;
	
	public void mailSend(String to,String sub,String body) {
		Instrgram i=new Instrgram();
		SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom("hellridermahesh@gmail.com");
		message.setTo(to);
		message.setText(body);
		message.setSubject(sub);
		sender.send(message);
		
		
		
	}
	
	
	

}
