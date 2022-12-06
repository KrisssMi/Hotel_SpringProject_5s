package com.example.by.minevich.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfig {
    @Value("${spring.mail.host}")
    private String host;

    @Value("${spring.mail.port}")
    private int port;

    @Value("${spring.mail.username}")
    private String username;

    @Value("${spring.mail.password}")
    private String password;

    @Value("${spring.mail.properties.mail.smtp.starttls.enable}")
    private String starttls;

    @Value("${spring.mail.transport.protocol}")
    private String protocol;

    @Value("${spring.mail.debug}")
    private String debug;

    @Value("${spring.mail.smtp.ssl.trust}")
    private String trust;

    //@Value("${mail.smtp.starttls.required}")
    //private String startlls_required;

    @Bean
    public JavaMailSender getMailSender(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(host);
        mailSender.setPort(port);
        mailSender.setUsername(username);
        mailSender.setPassword(password);
        //mailSender.setTLS(true);

        Properties properties = mailSender.getJavaMailProperties();

        properties.setProperty("mail.transport.protocol", protocol);
        properties.setProperty("mail.debug", debug);    //comment for prod
        properties.setProperty("mail.smtp.ssl.trust", trust);

        //properties.put("mail.smtp.starttls.enable", mailSender.isStartTls());
        //properties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2"); // Added this line
        properties.setProperty("mail.smtp.starttls.enable", starttls);
        //properties.setProperty("mail.smtp.starttls.required", startlls_required);
        return  mailSender;
    }
}
