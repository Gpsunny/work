package cn.itsource.spring.web.controller;

import cn.itsource.spring.Springboot3Application;
import cn.itsource.spring.domain.User;
import cn.itsource.spring.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Springboot3Application.class)
public class UserControllerTest {
    @Autowired
    private IUserService userService;
    @Test
    public void test() throws Exception {
        User loginUser = userService.getUserByUsername("顾鹏");
        System.out.println(loginUser);

    }

}