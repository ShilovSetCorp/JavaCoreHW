package com.roman.shilov.hw7.user.service;

import com.roman.shilov.hw7.common.buisness.service.BaseService;
import com.roman.shilov.hw7.user.domain.User;
import com.roman.shilov.hw7.user.search.UserSearchCondition;

import java.util.List;

public interface UserService extends BaseService {

    void add(User user);

    void update(User user);

    User findById(Long id);

    void delete(User user);

    List<User> search(UserSearchCondition searchCondition);
}
