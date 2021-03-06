package com.roman.shilov.hw9.travelagency.user.repo.impl;

import com.roman.shilov.hw9.travelagency.cities.domain.City;
import com.roman.shilov.hw9.travelagency.common.buisness.search.SortType;
import com.roman.shilov.hw9.travelagency.user.domain.User;
import com.roman.shilov.hw9.travelagency.user.repo.UserRepo;
import com.roman.shilov.hw9.travelagency.user.search.UserSearchCondition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static com.roman.shilov.hw9.travelagency.storage.Storage.userList;

public class UserMemoryCollectionRepo implements UserRepo {
    @Override
    public void add(User user) {
        userList.add(user);
    }

    @Override
    public User findById(long id) {
        return findUserById(id);
    }

    @Override
    public List<User> search(UserSearchCondition searchCondition) {
        if (searchCondition.getId() != null) {
            return Collections.singletonList(findById(searchCondition.getId()));
        } else {
            boolean searchByName = searchCondition.getName() != null;
            boolean searchByLast = searchCondition.getLast() != null;

            List<User> result = new ArrayList<>();
            for (User user : userList) {
                if (user != null) {
                    boolean found = true;
                    if (searchByName) {
                        found = searchCondition.getName().equals(user.getName());
                    }

                    if (found && searchByLast) {
                        found = searchCondition.getLast().equals(user.getLast());
                    }


                    if (found) {
                       result.add(user);
                    }
                }
            }

            if(searchCondition.getSortType() != null){
                if(searchCondition.getSortType().equals(SortType.ASC)){
                    result.sort(new Comparator<User>() {
                        @Override
                        public int compare(User o1, User o2) {
                            if(o1.getId() > o2.getId()){
                                return 1;
                            }else if(o1.getId() < o2.getId()){
                                return -1;
                            }else {
                                return 0;
                            }
                        }
                    });
                }else {
                    result.sort(new Comparator<User>() {
                        @Override
                        public int compare(User o1, User o2) {
                            if(o1.getId() > o2.getId()){
                                return -1;
                            }else if(o1.getId() < o2.getId()){
                                return 1;
                            }else {
                                return 0;
                            }
                        }
                    });
                }
            }

            return result;
        }
    }

    @Override
    public void deleteById(long id) {
        User found = findUserById(id);

        if (found != null) {
            userList.remove(found);
        }
    }

    @Override
    public void update(User user) {
        User found = findById(user.getId());
        found.setName(user.getName());
        found.setLast(user.getLast());
        found.setPassport(user.getPassport());
    }

    @Override
    public void printAll() {
        for(User user: userList){
            System.out.println(user);
        }
    }

    private User findUserById(long userId) {
        for (User user : userList) {
            if (Long.valueOf(userId).equals(user.getId())) {
                return user;
            }
        }
        return null;
    }
}
