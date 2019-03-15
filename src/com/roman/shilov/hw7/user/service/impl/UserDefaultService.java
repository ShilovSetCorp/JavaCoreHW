package com.roman.shilov.hw7.user.service.impl;

import com.roman.shilov.hw7.user.domain.User;
import com.roman.shilov.hw7.user.repo.UserRepo;
import com.roman.shilov.hw7.user.search.UserSearchCondition;
import com.roman.shilov.hw7.user.service.UserService;

import java.util.List;

public class UserDefaultService implements UserService {
    private final UserRepo repo;

    public UserDefaultService(UserRepo repo) {
        this.repo = repo;
    }

    @Override
    public void add(User user) {
      //  user.setId(SequenceCreator.getNextId());
        repo.add(user);
    }

    @Override
    public void update(User user) {
        repo.update(user);
    }


    @Override
    public User findById(Long id) {
        if(id != null){
            return repo.findById(id);
        }else {
            return null;
        }
    }

    @Override
    public void delete(User user) {
        if(user.getId() != null){
            repo.deleteById(user.getId());
        }
    }

    @Override
    public List<User> search(UserSearchCondition searchCondition) {
        return repo.search(searchCondition);
    }

    @Override
    public void deleteById(Long id) {
        if(id != null){
            repo.deleteById(id);
        }
    }

    @Override
    public void printAll() {
        repo.printAll();
    }
}
