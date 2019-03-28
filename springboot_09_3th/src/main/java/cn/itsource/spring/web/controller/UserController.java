package cn.itsource.spring.web.controller;

import cn.itsource.spring.domain.User;
import cn.itsource.spring.service.IUserService;
import cn.itsource.spring.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("login")
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping("/user")
    public User user(Long id){
        return userService.getById(id);
    }


    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public AjaxResult queryUser(User user){
        System.out.println(user);
//        System.out.println(userService.getById(1L));
//        return userService.loadByQuery(new UserQuery());
//        User userByUsername = userService.getUserByUsername(user.getName());
//        if (userByUsername.getName()!=null && user.getName() !=null && userByUsername.getName().equals(user.getName())){
//            if (user.getPassword()!=null && userByUsername.getPassword().equals(user.getPassword())){
//                return  AjaxResult.me().setSuccess(true).setMsg("登陆成功");
//            }
//        }
//        return  AjaxResult.me().setSuccess(false).setMsg("登陆失败");
        return null;
    }

    @RequestMapping("/save")
    public void save(User user){
        userService.save(user);
    }



    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult login(User user){
        System.out.println("user--->"+user);

        User userByUsername = userService.getUserByUsername(user.getName());
        if (userByUsername!=null){
            if (user.getPassword() != null && userByUsername.getPassword().equals(user.getPassword())) {
                return AjaxResult.me().setSuccess(true).setMsg("登陆成功");
            }
        }
        return AjaxResult.me().setSuccess(false).setMsg("登陆失败");
    }
}
