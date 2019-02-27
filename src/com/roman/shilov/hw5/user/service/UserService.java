package com.roman.shilov.hw5.user.service;

import com.roman.shilov.hw5.common.buisness.service.BaseService;
import com.roman.shilov.hw5.user.domain.User;
import com.roman.shilov.hw5.user.search.UserSearchCondition;

import java.util.List;

public interface UserService extends BaseService {

    void add(User user);


    User findById(Long id);

    void delete(User user);

    List<User> search(UserSearchCondition searchCondition);
}
