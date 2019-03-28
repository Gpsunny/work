package cn.itsource.spring.service;

import cn.itsource.spring.domain.User;
import cn.itsource.spring.query.UserQuery;

import java.util.List;

public interface IUserService {
    User getById(Long id);

    List<User> loadByQuery(UserQuery userQuery);

    void save(User user);

    User getUserByUsername(String name);
}
