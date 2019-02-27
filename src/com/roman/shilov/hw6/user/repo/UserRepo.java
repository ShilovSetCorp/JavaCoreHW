package com.roman.shilov.hw6.user.repo;

import com.roman.shilov.hw6.common.buisness.repo.BaseRepo;
import com.roman.shilov.hw6.user.domain.User;
import com.roman.shilov.hw6.user.search.UserSearchCondition;

import java.util.List;

public interface UserRepo extends BaseRepo {
    void add(User user);

    User findById(long id);

    List<User> search(UserSearchCondition searchCondition);
}
