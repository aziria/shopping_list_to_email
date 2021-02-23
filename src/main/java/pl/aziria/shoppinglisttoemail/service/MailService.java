package pl.aziria.shoppinglisttoemail.service;

import org.thymeleaf.TemplateEngine;

public interface MailService {
    void sendEmail(String to, String subject, String content);

    TemplateEngine getTemplateEngine();
}
