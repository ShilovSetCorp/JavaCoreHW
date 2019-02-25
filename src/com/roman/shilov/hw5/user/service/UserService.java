package com.roman.shilov.hw5.user.service;

import com.roman.shilov.hw5.common.buisness.service.BaseService;
import com.roman.shilov.hw5.user.domain.User;

public interface UserService extends BaseService {

    void add(User user);

    User findById(Long id);

    void delete(User user);
}
