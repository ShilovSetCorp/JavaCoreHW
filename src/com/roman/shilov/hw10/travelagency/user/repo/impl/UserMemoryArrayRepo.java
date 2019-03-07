package com.roman.shilov.hw10.travelagency.user.repo.impl;

import com.roman.shilov.hw10.travelagency.common.buisness.search.OrderType;
import com.roman.shilov.hw10.travelagency.common.solutions.utils.ArrayUtils;
import com.roman.shilov.hw10.travelagency.user.domain.User;
import com.roman.shilov.hw10.travelagency.user.repo.UserRepo;
import com.roman.shilov.hw10.travelagency.user.search.UserSearchCondition;

import java.util.*;

import static com.roman.shilov.hw9.travelagency.storage.Storage.users;


public class UserMemoryArrayRepo implements UserRepo {
    private static final User[] EMPTY_USER_ARR = new User[0];
    private int userIndex = -1;

    @Override
    public void add(User user) {
        if(userIndex == users.length - 1){
            User[] newArrUsers = new User[users.length * 2];
            System.arraycopy(users, 0, newArrUsers, 0, users.length);
            users = newArrUsers;
        }

        userIndex++;
        users[userIndex] = user;
    }

    @Override
    public User findById(long id) {
        Integer userIndex = findUserIndexById(id);
        if(userIndex != null){
            return users[userIndex];
        }

        return null;
    }

    @Override
    public List<User> search(UserSearchCondition searchCondition) {
        if (searchCondition.getId() != null) {
            return Collections.singletonList(findById(searchCondition.getId()));
        } else {
            boolean searchByName = searchCondition.getName() != null;
            boolean searchByLast = searchCondition.getLast() != null;


            User[] result = new User[users.length];
            int resultIndex = 0;

            for (User user : users) {
                if (user != null) {
                    boolean found = true;

                    if (searchByName) {
                        found = searchCondition.getName().equals(user.getName());
                    }

                    if (found && searchByLast) {
                        found = searchCondition.getLast().equals(user.getLast());
                    }


                    if (found) {
                        result[resultIndex] = user;
                        resultIndex++;
                    }
                }
            }

            if (resultIndex > 0) {
                User[] toReturn = new User[resultIndex];
                System.arraycopy(result, 0, toReturn, 0, resultIndex);

                if(searchCondition.getOrderType() != null) {
                    if (searchCondition.getOrderType().equals(OrderType.ASC)) {
                        Arrays.sort(toReturn, new Comparator<User>() {
                            @Override
                            public int compare(User o1, User o2) {
                                if (o1.getId() > o2.getId()) {
                                    return 1;
                                } else if (o1.getId() < o2.getId()) {
                                    return -1;
                                } else {
                                    return 0;
                                }
                            }
                        });
                    } else {
                        Arrays.sort(toReturn, new Comparator<User>() {
                            @Override
                            public int compare(User o1, User o2) {
                                if (o1.getId() > o2.getId()) {
                                    return -1;
                                } else if (o1.getId() < o2.getId()) {
                                    return 1;
                                } else {
                                    return 0;
                                }
                            }
                        });
                    }
                }

                return new ArrayList<>(Arrays.asList(toReturn));
            }
        }
        return Collections.emptyList();
    }

    @Override
    public void update(User user) {
        User found = findById(user.getId());
        found.setName(user.getName());
        found.setLast(user.getLast());
        found.setPassport(user.getPassport());
    }

    @Override
    public void deleteById(long id) {
        Integer userIndex = findUserIndexById(id);
        if(userIndex != null){
            deleteUserByIndex(userIndex);
        }
    }

    private void deleteUserByIndex(int index){
        ArrayUtils.removeElement(users, index);
        userIndex--;
    }

    @Override
    public void printAll() {
        for(User user: users){
            System.out.println(user);
        }
    }

    private Integer findUserIndexById(Long userId){
        for (int i = 0; i < users.length; i++) {
            if(users[i].getId().equals(userId)){
                return i;
            }
        }
        return null;
    }
}
