package cn.itsource.spring.mapper;

import cn.itsource.spring.domain.User;
import cn.itsource.spring.query.UserQuery;

import java.util.List;

public interface UserMapper {

    User getById(Long id);

    List<User> loadByQuery(UserQuery userQuery);

    void save(User user);

    /**
     * 根据用户名获取用户数据
     */
    User getUserByUsername(String name);

}
