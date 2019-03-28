package cn.itsource.spring.service.impl;

import cn.itsource.spring.domain.User;
import cn.itsource.spring.mapper.UserMapper;
import cn.itsource.spring.query.UserQuery;
import cn.itsource.spring.service.IUserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional(propagation= Propagation.SUPPORTS,readOnly = true)//只读
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    public User getById(Long id) {
        return userMapper.getById(id);
    }

    public List<User> loadByQuery(UserQuery userQuery) {
        // pangeNum 第几页   pageSize 每页多少条

        PageHelper.startPage(2,2);
        return userMapper.loadByQuery(userQuery);
    }
    @Transactional
    public void save(User user) {
        userMapper.save(user);
        //测试事务回滚
        int i=1/0;
    }

    public User getUserByUsername(String name) {
        return userMapper.getUserByUsername(name);
    }
}
