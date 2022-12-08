package be.ifosup.learning.email.service;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

public interface EmailService {
    public String sendEmail(String email, String object, String text) throws MessagingException, UnsupportedEncodingException;
}
