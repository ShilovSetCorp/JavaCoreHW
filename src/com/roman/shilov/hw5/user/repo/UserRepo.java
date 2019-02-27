package com.roman.shilov.hw5.user.repo;

import com.roman.shilov.hw5.common.buisness.repo.BaseRepo;
import com.roman.shilov.hw5.user.domain.User;
import com.roman.shilov.hw5.user.search.UserSearchCondition;

import java.util.List;

public interface UserRepo extends BaseRepo {
    void add(User user);

    User findById(long id);

    List<User> search(UserSearchCondition searchCondition);
}
