package com.switter.storage;

import com.switter.entity.Role;
import com.switter.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserStorage {

    private final List<User> userList = new ArrayList<>();


    public void save(User user) {
        userList.add(user);
    }

    public int getIdUserStorage() {
        return userList.size() + 1;
    }

    public boolean isExistByLogin(String login) {
        for (User user : userList) {
            if (user.getLogin().equals(login)) {
                return true;
            }
        }
        return false;
    }

    public User findByLogin(String login) {

        for (User user : userList) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return new User();
    }

    public boolean editRoleById(int userId) {
        boolean isEdited = false;

        for (User user : userList) {
            if (user.getIdUser() == userId) {
                user.setRole(Role.ADMIN);
                isEdited = true;
            }
        }

        return isEdited;
    }

    public boolean deleteUserByID(int userId) {
        boolean isDeleted = false;

        for (User user : userList) {
            if (user.getIdUser() == userId) {
                userList.remove(user);
                isDeleted = true;
            }
        }

        return isDeleted;
    }

    public List<User> getAllUsers() {
        List<User> userList1 = new ArrayList<>();
        userList1 = userList;
        return userList1;
    }

    public User getUserById(int idUser){

        for (User user : userList){
            if (user.getIdUser() == idUser){
                return user;
            }
        }
        return new User();
    }


}
