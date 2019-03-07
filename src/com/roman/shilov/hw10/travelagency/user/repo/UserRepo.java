package com.roman.shilov.hw10.travelagency.user.repo;

import com.roman.shilov.hw10.travelagency.common.buisness.repo.BaseRepo;
import com.roman.shilov.hw10.travelagency.user.domain.User;
import com.roman.shilov.hw10.travelagency.user.search.UserSearchCondition;

import java.util.List;

public interface UserRepo extends BaseRepo {
    void add(User user);

    User findById(long id);

    List<User> search(UserSearchCondition searchCondition);

    void update(User user);
}
