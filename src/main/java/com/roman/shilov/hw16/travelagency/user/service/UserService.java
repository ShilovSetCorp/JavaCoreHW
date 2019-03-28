package com.roman.shilov.hw16.travelagency.user.service;

import com.roman.shilov.hw16.travelagency.common.solutions.service.BaseService;
import com.roman.shilov.hw16.travelagency.user.domain.User;
import com.roman.shilov.hw16.travelagency.user.search.UserSearchCondition;

import java.util.List;

public interface UserService extends BaseService<User, Long> {


    List<User> search(UserSearchCondition searchCondition);
}
