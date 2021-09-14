package com.jamilovf.hrms.core.services.concretes;

import com.jamilovf.hrms.core.model.settings.EmailSettings;
import com.jamilovf.hrms.core.services.abstracts.EmailService;
import com.jamilovf.hrms.entity.concretes.Person;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

@Service
public class EmailManager implements EmailService {

    @Override
    public void sendEmail(HttpServletRequest request, Person person)
            throws UnsupportedEncodingException, MessagingException {
        JavaMailSenderImpl mailSender = prepareMailSender();

        String toAddress = person.getEmail();
        String subject = EmailSettings.MAIL_SUBJECT;
        String content = EmailSettings.MAIL_CONTENT;

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom(EmailSettings.MAIL_FROM, EmailSettings.MAIL_SENDER_NAME);
        helper.setTo(toAddress);
        helper.setSubject(subject);

        content = content.replace("$tokenValue", person.getEmailVerificationToken());

        helper.setText(content,true);

        mailSender.send(message);
    }

    @Override
    public void sendPasswordResetRequest(HttpServletRequest request, Person person)
            throws UnsupportedEncodingException, MessagingException {
        JavaMailSenderImpl mailSender = prepareMailSender();

        String toAddress = person.getEmail();
        String subject = EmailSettings.PASSWORD_RESET_SUBJECT;
        String content = EmailSettings.PASSWORD_RESET_CONTENT;

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom(EmailSettings.MAIL_FROM, EmailSettings.MAIL_SENDER_NAME);
        helper.setTo(toAddress);
        helper.setSubject(subject);

        content = content.replace("$tokenValue", person.getPasswordResetToken());

        helper.setText(content,true);

        mailSender.send(message);
    }

    public JavaMailSenderImpl prepareMailSender(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost(EmailSettings.MAIL_HOST);
        mailSender.setPort(EmailSettings.MAIL_PORT);
        mailSender.setUsername(EmailSettings.MAIL_USERNAME);
        mailSender.setPassword(EmailSettings.MAIL_PASSWORD);

        Properties mailProperties = new Properties();
        mailProperties.setProperty("mail.smtp.auth", EmailSettings.SMTP_AUTH);
        mailProperties.setProperty("mail.smtp.starttls.enable", EmailSettings.SMTP_SECURED);

        mailSender.setJavaMailProperties(mailProperties);

        return mailSender;
    }
}
