package com.example.by.minevich;

import com.example.by.minevich.models.UsersEntity;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyProjectApplication {

    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(UsersEntity.class);
        //SpringApplication.run(MyProjectApplication.class, args);
    }
}
