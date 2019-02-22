package com.roman.shilov.hw4.user.repo;

import com.roman.shilov.hw4.user.User;

import static com.roman.shilov.hw4.storage.Storage.users;

public class UserMemoryRepo {
    private int userIndex = -1;

    public void addUser(User user) {
        if (userIndex == users.length - 1){
            User[] newArrUsers = new User[users.length * 2];
            System.arraycopy(users, 0, newArrUsers, 0, users.length);
            users = newArrUsers;
        }

        userIndex++;
        users[userIndex] = user;
    }

    public User findUserById(long id) {
        Integer userIndex = findUserIndexById(id);
        if(userIndex != null) {
            return users[userIndex];
        }
        return null;
    }

    public void deleteUser(User user){
        Integer foundIndex = findUserIndexByEntity(user);

        if(foundIndex != null){
            deleteUserByIndex(foundIndex);
            this.userIndex--;
        }
    }

    public void deleteUser(Long id){
        Integer userIndex = findUserIndexById(id);
        if(userIndex != null){
            deleteUserByIndex(userIndex);
        }
    }

    private void deleteUserByIndex(int index){
        User[] newArrUsers = new User[users.length];
        System.arraycopy(users, 0, newArrUsers, 0, index - 1);
        System.arraycopy(users, index, newArrUsers, index - 1, users.length - index);
        users = newArrUsers;
        this.userIndex--;
    }

    private Integer findUserIndexByEntity(User user){
        for (int i = 0; i < users.length; i++) {
            if(users[i].equals(user)){
                return i;
            }
        }
        return null;
    }

    private Integer findUserIndexById(Long userId){
        for (int i = 0; i < users.length; i++) {
            if(users[i].getId().equals(userId)){
                return i;
            }
        }
        return null;
    }

    public void printUsers(){
        for(User user : users){
            System.out.println(user);
        }
    }
}

