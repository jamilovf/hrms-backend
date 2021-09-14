package com.jamilovf.hrms.core.model.settings;

public class EmailSettings {
    public static final String MAIL_HOST = "smtp.gmail.com";
    public static final int MAIL_PORT = 587;
    public static final String MAIL_USERNAME = "fjhrms.company@gmail.com";
    public static final String MAIL_PASSWORD = "a";
    public static final String SMTP_AUTH = "true";
    public static final String SMTP_SECURED= "true";
    public static final String MAIL_FROM = "fjhrms.company@gmail.com";
    public static final String MAIL_SENDER_NAME = "FJ HRMS";
    public static final String MAIL_SUBJECT =  "Email address verification";
    public static final String MAIL_CONTENT = "<h1>Please verify your email address</h1>"
            + "<p>Thank you for registering. To complete registration process and be able to log in,"
            + " click on the below link: <br/>"
            + "<a href='http://localhost:8080/api/auth/verifyEmailToken?token=$tokenValue'>"
            + "Final step to complete your registration" + "</a><br/><br/>"
            + "Thank you! And we are waiting for you inside!";
    public static final String PASSWORD_RESET_SUBJECT =  "Password Reset Request";
    public static final String PASSWORD_RESET_CONTENT = "<h1>A request to reset your password</h1>"
            + "<p>Hi,</p> "
            + "<p>Someone has requested to reset your password with our project. If it were not you, please ignore it."
            + " otherwise please click on the link below to set a new password: "
            + "<a href='http://localhost:8080/api/auth/resetPassword?token=$tokenValue'>"
            + " Click this link to Reset Password"
            + "</a><br/><br/>"
            + "Thank you!";


}
