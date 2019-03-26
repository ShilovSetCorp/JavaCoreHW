package com.roman.shilov.hw15.travelagency.user.service.impl;

import com.roman.shilov.hw15.travelagency.order.domain.Order;
import com.roman.shilov.hw15.travelagency.user.domain.User;
import com.roman.shilov.hw15.travelagency.user.repo.UserRepo;
import com.roman.shilov.hw15.travelagency.user.search.UserSearchCondition;
import com.roman.shilov.hw15.travelagency.user.service.UserService;
import com.roman.shilov.hw15.travelagency.user.service.exceptions.UserStillHasOrdersException;

import java.util.Iterator;
import java.util.List;

import static com.roman.shilov.hw15.travelagency.storage.Storage.ordersList;

public class UserDefaultService implements UserService {
    private final UserRepo repo;

    public UserDefaultService(UserRepo repo) {
        this.repo = repo;
    }

    @Override
    public void insert(User user) {
        repo.insert(user);
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
    public void delete(User user){
        if(user.getId() != null){
            try {
                for(Order order: ordersList) {
                    if (order.getUser().getId().equals(user.getId())) {
                        throw new UserStillHasOrdersException("There are still orders which contains user that should be deleted", 20);
                    }
                }
            }catch (UserStillHasOrdersException e) {
                System.out.println(e.getMessage());
            } finally {
                Iterator<Order> it = ordersList.iterator();
                while (it.hasNext()){
                    if(it.next().getUser().getId().equals(user.getId())){
                        it.remove();
                    }
                }
                this.deleteById(user.getId());
            }
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
