package com.roman.shilov.hw4.user.service;

import com.roman.shilov.hw4.user.User;
import com.roman.shilov.hw4.user.repo.UserMemoryRepo;

public class UserMemoryService {
    UserMemoryRepo repo = new UserMemoryRepo();

    public void addUser(User user) {
        repo.addUser(user);
    }

    public User findUserById(long id) {
        return repo.findUserById(id);
    }

    public void deleteUser(User user) {
        repo.deleteUser(user);
    }

    public void deleteUser(Long id) {
        repo.deleteUser(id);
    }

    public void printUsers() {
        repo.printUsers();
    }
}
