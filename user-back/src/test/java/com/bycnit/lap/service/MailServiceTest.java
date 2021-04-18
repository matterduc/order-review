package com.bycnit.lap.service;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bycnit.lap.domain.Application;
import com.bycnit.lap.domain.User;

/**
 * Unit test for "com.bycnit.lap.service.impl.MailService"
 *
 * @author Z.DRISSI
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MailServiceTest {

    @Autowired
    private IMailService mailService;

    @Test
    public void whenBuildMail_thenReturnBody() {

        // Arrange
        final String template = "test-init-email.ftl";
        final User user = new User();
        final Set<Application> applications = new HashSet<>();
        final Application application = new Application();

        application.setName("Nomadis");
        applications.add(application);

        user.setFirstName("John");
        user.setLastName("Doe");
        user.setApplications(applications);

        final Map<String, Object> input = new HashMap<>();

        input.put("user", user);
        input.put("activationLink", "dummyLink/1234-1234-1234-1234");

        // Act
        final String body = mailService.buildMail(template, input);

        // Assert
        assertTrue(body.contains("Bonjour John Doe"));
        assertTrue(body.contains("Accès à l'application <strong>Nomadis</strong>."));
    }

    @Test
    public void whenBuildMailWithManyApps_thenReturnBody() {

        // Arrange
        final String template = "test-init-email.ftl";
        final User user = new User();
        final Set<Application> applications = new HashSet<>();
        final Application app1 = new Application();
        final Application app2 = new Application();

        app1.setId(1L);
        app1.setName("Nomadis");
        app2.setId(2L);
        app2.setName("FyBuddy");

        applications.add(app1);
        applications.add(app2);

        user.setFirstName("John");
        user.setLastName("Doe");
        user.setApplications(applications);

        final Map<String, Object> input = new HashMap<>();

        input.put("user", user);
        input.put("activationLink", "dummyLink/1234-1234-1234-1234");

        // Act
        final String body = mailService.buildMail(template, input);

        // Assert
        assertTrue(body.contains("Bonjour John Doe"));
        assertTrue(body.contains("line-height: 16px;\">Nomadis</span></strong"));
        assertTrue(body.contains("line-height: 16px;\">FyBuddy</span></strong"));
    }
}
