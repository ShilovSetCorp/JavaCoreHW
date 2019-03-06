package com.roman.shilov.hw9.travelagency.user.service;

import com.roman.shilov.hw9.travelagency.common.buisness.service.BaseService;
import com.roman.shilov.hw9.travelagency.user.domain.User;
import com.roman.shilov.hw9.travelagency.user.search.UserSearchCondition;

import java.util.List;

public interface UserService extends BaseService {

    void add(User user);

    void update(User user);

    User findById(Long id);

    void delete(User user);

    List<User> search(UserSearchCondition searchCondition);
}
