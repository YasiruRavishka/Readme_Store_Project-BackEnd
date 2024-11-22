package edu.icet.service;

public interface EmailService {
    boolean sendAccountCreatedSuccessEmail(String to, String name);
    boolean sendAccountPasswordChangedSuccessEmail(String to, String name);
}
