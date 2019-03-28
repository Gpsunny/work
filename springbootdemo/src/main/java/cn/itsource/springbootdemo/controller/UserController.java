package cn.itsource.springbootdemo.controller;

import cn.itsource.springbootdemo.domain.User;
import cn.itsource.springbootdemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 查询所有用户
     * @return
     */
    @RequestMapping("/index")
    public List<User> index(){
        return userService.list();
    }

}
