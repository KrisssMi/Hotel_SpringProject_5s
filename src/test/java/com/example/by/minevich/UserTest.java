package com.example.by.minevich;

import com.example.by.minevich.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
    @Autowired
    private UserService userService;
    @Test
    public void existsUserByLogin() {
        try {
            Assert.assertTrue(userService.existsUserByLogin("Kristi"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void existsUserByLoginAndPassword(){
        try {
            Assert.assertTrue(userService.existsUserByLoginAndPassword("Kristi","Kristi"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
