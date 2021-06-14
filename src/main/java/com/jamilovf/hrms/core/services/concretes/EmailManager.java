package com.jamilovf.hrms.core.services.concretes;

import com.jamilovf.hrms.core.services.abstracts.EmailService;
import org.springframework.stereotype.Service;

@Service
public class EmailManager implements EmailService {
    @Override
    public String sendEmail(String email) {
        return "Verification link has sent to " + email;
    }
}
