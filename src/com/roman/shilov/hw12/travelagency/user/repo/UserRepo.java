package com.roman.shilov.hw12.travelagency.user.repo;

import com.roman.shilov.hw12.travelagency.common.solutions.repo.BaseRepo;
import com.roman.shilov.hw12.travelagency.user.domain.User;
import com.roman.shilov.hw12.travelagency.user.search.UserSearchCondition;

import java.util.List;

public interface UserRepo extends BaseRepo<User, Long> {

    List<User> search(UserSearchCondition searchCondition);
}
