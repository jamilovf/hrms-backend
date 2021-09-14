package com.jamilovf.hrms.core.services.abstracts;

import com.jamilovf.hrms.entity.concretes.Person;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

public interface EmailService {
    void sendEmail(HttpServletRequest request, Person person)
            throws UnsupportedEncodingException, MessagingException;

    void sendPasswordResetRequest(HttpServletRequest request, Person person)
            throws UnsupportedEncodingException, MessagingException;
}
