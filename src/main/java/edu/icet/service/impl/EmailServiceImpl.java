package edu.icet.service.impl;

import edu.icet.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender emailSender;
    private final SpringTemplateEngine templateEngine;
    private static final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

    private static String fromEmail = "test@gmail.com";

    private void sendHtmlEmail(String to, String subject, String templateName, Map<String, Object> templateModel) throws MessagingException {
        Context context = new Context();
        context.setVariables(templateModel);
        String htmlBody = templateEngine.process(templateName, context);

        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

        helper.setFrom(fromEmail);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(htmlBody, true);

        try {
            emailSender.send(message);
        } catch (MailException e) {
            logger.error("Failed to send email", e);
            throw new MessagingException("Failed to send email", e);
        }
    }

    @Override
    public boolean sendAccountCreatedSuccessEmail(String to, String name) {
        try {
            String subject = "Account Created.";
            Map<String, Object> templateModel = new HashMap<>();
            templateModel.put("name", name);

            sendHtmlEmail(to, subject, "successAccountCreate", templateModel);
            return true;
        } catch (MessagingException e) {
            logger.error("Failed to send account create success email", e);
            return false;
        }
    }

    @Override
    public boolean sendAccountPasswordChangedSuccessEmail(String to, String name) {
        try {
            String subject = "Password Changed.";
            Map<String, Object> templateModel = new HashMap<>();
            templateModel.put("name", name);

            sendHtmlEmail(to, subject, "successPasswordChange", templateModel);
            return true;
        } catch (MessagingException e) {
            logger.error("Failed to send account password change success email", e);
            return false;
        }
    }
}
