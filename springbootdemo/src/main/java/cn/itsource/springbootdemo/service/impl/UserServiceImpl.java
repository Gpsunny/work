package cn.itsource.springbootdemo.service.impl;

import cn.itsource.springbootdemo.mapper.UserMapper;
import cn.itsource.springbootdemo.domain.User;
import cn.itsource.springbootdemo.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements IUserService {
}
