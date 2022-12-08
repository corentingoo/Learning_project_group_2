package be.ifosup.learning.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@Service
public class EmailServiceImpl implements EmailService{
    @Autowired
    private JavaMailSender emailSender;

    @Override
    public String sendEmail(String email, String object, String text) throws MessagingException, UnsupportedEncodingException {
        try {
            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);

            helper.setFrom("learningifosup@hotmail.com", "Lydia");
            helper.setTo(email);
            String subject = object;
            String content = text;
            helper.setSubject(subject);
            helper.setText(content, true);
            System.out.println(message);
            emailSender.send(message);
        } catch (Exception e) {
            System.out.print(e);
        }
        return "";
    }
}
