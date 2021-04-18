package com.crosssolutions.user.service.impl;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.crosssolutions.user.config.AppProperties;
import com.crosssolutions.user.service.IMailService;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * Mail managemnt service
 *
 * @author Duc.Nguyen
 */
@Service
public class MailService implements IMailService {

    @Autowired
    private AppProperties properties;

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private Configuration freemarkerConfig;

    /**
     * @see com.crosssolutions.user.service.IMailService#sendEmail(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public void sendEmail(final String email, final String subject, final String body) {

        try {

            final MimeMessage message = emailSender.createMimeMessage();
            final MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());

            helper.addAttachment("logo.png", new ClassPathResource("templates/img/logo.png"));
            helper.setFrom(properties.getDefaultSender());
            helper.setTo(email);
            helper.setSubject(subject);
            helper.setText(body, true);

            emailSender.send(message);
        } catch (final MessagingException e) {
            throw new IllegalStateException("Cannot send the email", e);
        }
    }

    /**
     * @see com.crosssolutions.user.service.IMailService#buildMail(java.lang.String, java.util.Map)
     */
    @Override
    public String buildMail(final String template, final Map<String, Object> input) {

        try {
            final Template t = freemarkerConfig.getTemplate(template);

            // implicit parameters
            input.put("currentDate", DateFormatUtils.format(new Date(), "dd/MM/yyyy"));

            final String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, input);

            return html;
        } catch (final IOException | TemplateException e) {
            throw new IllegalStateException("Impossible de générer le template");
        }
    }
}
