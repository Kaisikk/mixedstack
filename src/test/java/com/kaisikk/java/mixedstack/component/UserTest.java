package com.kaisikk.java.mixedstack.component;

import com.kaisikk.java.mixedstack.MixedstackApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MixedstackApplication.class)
class UserTest {

    private Language language;

    private User user;

    @Autowired
    private User userPro;

    @BeforeEach
    public  void setUp(){
        language = Mockito.mock(Language.class);
        user = new User();
        user.setLanguage(language);
    }

    @Test
    void sum() {
        User user = new User();
        assertTrue(user.sum(2, 3) == 5, "2 + 3 = 5");
        assertTrue(user.sum(7, 3) == 10, "7 + 3 = 10");
        assertTrue(user.sum(-2, 3) == 1, "-2 + 3 = 1");
        assertFalse(user.sum(2, 3) == 10);

        assertEquals(2.2, (float) user.sum(2, 0), 0.5);

    }

    @Test
    public void sayHello(){
    assertTrue("Hello".equals(userPro.sayHello()));
    }


}